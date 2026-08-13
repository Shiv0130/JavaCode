import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    //Friday 29.08.2025

    // Maintain a list of all connected clients' output streams
    // This allows us to broadcast messages to everyone
    static ArrayList<PrintWriter> clients = new ArrayList<>();

    // Counter for auto-generating usernames (User1, User2, etc.)
    static  int userCount = 1;

    public static void main(String[] args) throws Exception {
        System.out.println("Starting server");

        // Create server socket listening on port 5678
        // This is the port which all clients will connect
        ServerSocket server = new ServerSocket(5678);

        // Infinite loop to continuously accept new client connections
        // The server runs forever until manually stopped
        while(true){
            // When someone connects, accept() returns a Socket for that specific client
            Socket quade = server.accept();
            System.out.println("A user has joined the server");

            // Create a dedicated thread for this client
            // This allows multiple clients to be handled simultaneously
            new Thread(new ClientHandler(quade)).start();
        }
    }

    // Inner class that handles individual client connections
    // Implements Runnable to be executed in a separate thread
    private static class ClientHandler implements Runnable {
        Socket quade;              // The socket connection to this specific client
        PrintWriter messageOut;    // Stream for sending messages TO this client
        BufferedReader messageIn;  // Stream for receiving messages FROM this client
        String username;           // This client's assigned username

        // Constructor receives the client's socket connection
        public ClientHandler(Socket clientSocket) {
            this.quade = clientSocket;
        }

        @Override
        public void run() {
            // Set up input/output streams for this client
            try {
                // Create input stream to read messages from this client
                messageIn = new BufferedReader(new InputStreamReader(quade.getInputStream()));

                // Create output stream to send messages to this client
                messageOut = new PrintWriter(quade.getOutputStream(),true);

                // Assign an automatic username (User1, User2, etc.)
                username = "User"+userCount++;

                // Add this client's output stream to our master list
                // This enables broadcasting to this client
                clients.add(messageOut);

                // Announce to all users that someone new has joined
                notifyUsers(username+ " has joined chat");

                // Main message processing loop for this client
                String message;
                while((message = messageIn.readLine()) != null){
                    // Broadcast every message to all connected clients

                    //notifyUsers("User: " + message);  ->changed this to the line below so we can
                    //identify who is sending the message (I forgot to change this in class after I
                    //added the username variable)
                    notifyUsers(username + ": " + message);
                }

            } catch (IOException e) {
                // Connection was lost or an error occurred
                throw new RuntimeException(e);

            } finally {
                // Remove this client from the broadcast list
                clients.remove(messageOut);

                // Notify remaining users that someone left
                notifyUsers(username + " has left");

                // Close the socket connection properly
                try {
                    quade.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // Helper method to broadcast a message to all connected clients
        void notifyUsers(String message){
            // Iterate through all client output streams
            for(PrintWriter client: clients){
                // Send the message to each client
                client.println(message);
            }
        }
    }
}