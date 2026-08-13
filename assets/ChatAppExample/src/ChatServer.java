import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    //Monday 25.08.2025

    //create a set to store our PrintWriter objects / streams.
    //This is to ensure that the clients can write into each other using the server
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) throws IOException {
        // This is where we create our server's "front door" - it listens on port 1234
        // (ports are like apartment numbers on the internet - clients need to know which door to knock on)
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Chat server has started on port 1234");

        // This infinite loop is the heart of our server - it's like a receptionist who never goes home!
        while(true){
            // The server patiently waits here for someone to connect...
            // When a client connects (sends a request), the accept() method creates a personal Socket just for that one client
            Socket socket = serverSocket.accept();

            // Now we create a dedicated "assistant" (ClientHandler thread) for this client
            // This way, the server can go back to waiting for more clients while this one is being handled
            new ClientHandler(socket).start();
        }
    }

    /* This inner class manages  each client (if we have multiple clients - which we will)
     * this clientHandler will manage each separately
     * */
    private  static  class ClientHandler extends Thread{
        //ClientHandler members
        private Socket socket;        // The actual connection to the client
        private PrintWriter sendMessage;  // The "pipe" to send messages TO this client
        private String username;      // What this client wants to be called

        public ClientHandler(Socket _socket){
            this.socket = _socket;
        }

        // This means each client runs in its own thread (like working independently)
        public void run(){
            try(
                    // First, set up a way to RECEIVE messages from this client
                    // BufferedReader is like having an inbox for this specific client
                    BufferedReader incomingMessage = new BufferedReader
                            (new InputStreamReader(socket.getInputStream()))
            ){
                // Set up the way to SEND messages to this client
                sendMessage = new PrintWriter(socket.getOutputStream(),true);

                // First thing we do? Ask for their username!
                sendMessage.println("Username");

                // Wait for them to type their username and hit enter
                username = incomingMessage.readLine();

                // If they didn't give us a username (or just spaces) the program stops
                if(username == null || username.trim().isEmpty()) return;

                // Add this client's PrintWriter object to our master list (the HashSet created earlier)
                // synchronized means "one at a time please!" - prevents chaos if multiple clients join simultaneously
                synchronized (clientWriters){
                    clientWriters.add(sendMessage);
                }

                // Let everyone know someone new joined the party!
                broadcast("Server: " + username + " has joined the chat" );

                // Now we sit in a loop, waiting for this client to send messages
                String message;
                while((message = incomingMessage.readLine()) != null){
                    // Whatever they say, we add their name and send it to EVERYONE
                    broadcast(username +": "+ message);
                }
                // If we exit the loop, it means the client disconnected
            }
            catch(IOException e){
                // Something went wrong
                System.out.println("Error:" );
            }finally {
                // Remove this client's PrintWriter from our list
                if (sendMessage != null){
                    synchronized (clientWriters){
                        clientWriters.remove(sendMessage);
                    }
                }

                // Tell everyone remaining that this person left
                if(username != null){
                    broadcast("Server: "+ username + " has left the chat");
                }

                // Close the connection properly
                try{
                    socket.close();
                } catch (IOException e) {
                    // in case there's an issue with closing the socket
                }
            }
        }

        // This method sends a message to EVERYONE connected to the server
        private void broadcast(String message){
            // Again, synchronized = "one at a time" to avoid chaos
            synchronized (clientWriters){
                // Loop through every client's PrintWriter and send them the message
                for(PrintWriter writer : clientWriters){
                    writer.println(message);
                }
            }
        }
    }
}