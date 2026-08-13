//////Server
////import javax.swing.*;
////import java.awt.*;
////import java.io.BufferedReader;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.io.PrintWriter;
////import java.net.ServerSocket;
////import java.net.Socket;
////import java.util.ArrayList;
////
////public class Server {
////    static ArrayList<> clients = new ArrayList<>();
////
////    Integer userCount = 1;
////
////    public static void main(String[] args) throws IOException {
////        JFrame frame = new JFrame("Remote temp app");
////        frame.setVisible(true);
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.setLayout(null);
////        frame.setSize(500,500);
////
////        JTextArea textArea = new JTextArea();
////        textArea.setBounds(20,40,60,80);
////
////        frame.add(textArea);
////
////        ServerSocket serverSocket = new ServerSocket(1234);
////
////        Socket socket = serverSocket.accept();
////
////        new Thread(new ClientHandler(socket)).start();
////
////        socket.close();
////        serverSocket.close();
////
////    }
////
////    private static class ClientHandler implements Runnable {
////        Socket socket;              // The socket connection to this specific client
////        PrintWriter messageOut;    // Stream for sending messages TO this client
////        BufferedReader messageIn;  // Stream for receiving messages FROM this client
////        String username;           // This client's assigned username
////
////        public ClientHandler(Socket clientSocket) { this.socket = clientSocket;}
////
////        @Override
////        public  void run(){
////            try{
////                // Create input stream to read messages from this client
////                messageIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
////
////                // Create output stream to send messages to this client
////                messageOut = new PrintWriter(socket.getOutputStream(),true);
////
////                // Assign an automatic username (User1, User2, etc.)
////                username = "User"+userCount++;
////
////                // Add this client's output stream to our master list
////                // This enables broadcasting to this client
////                clients.add(messageOut);
////
////                // Announce to all users that someone new has joined
////                notifyUsers(username+ " has joined chat");
////
////                // Main message processing loop for this client
////                String message;
////
////            }catch (RuntimeException e);
////
////
////        }
////
////        private void notifyUsers(String message) {
////            for(PrintWriter client: clients){
////                // Send the message to each client
////                client.println(message);
////            }
////        }
////
////
////    }
////}
//

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

////Server
//import javax.swing.*;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//
//public class Server {
//
//    static ArrayList<PrintWriter> clients = new ArrayList<>();
//
//    // Counter for auto-generating usernames (User1, User2, etc.)
//    static  int userCount = 1;
//
//    public static void main(String[] args) throws Exception {
//        JFrame frame = new JFrame("Remote temp app");
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(null);
//        frame.setSize(500,500);
//
//        JTextArea textArea = new JTextArea();
//        textArea.setBounds(10,20,750,750);
//        textArea.setVisible(true);
//
//        frame.add(textArea);
//        frame.pack();
//
//
//
//
//        // Create server socket listening on port 5678
//        // This is the port which all clients will connect
//        ServerSocket server = new ServerSocket(5678);
//
//        // Infinite loop to continuously accept new client connections
//        // The server runs forever until manually stopped
//        while(true){
//            // When someone connects, accept() returns a Socket for that specific client
//            Socket tempSocket = server.accept();
//            //System.out.println("A user has joined the server");
//
//            textArea.append("A user has joined the server");
//
//
//            // Create a dedicated thread for this client
//            // This allows multiple clients to be handled simultaneously
//            new Thread(new ClientHandler(tempSocket)).start();
//        }
//    }
//
//    // Inner class that handles individual client connections
//    // Implements Runnable to be executed in a separate thread
//    private static class ClientHandler implements Runnable {
//        Socket tempSocket;              // The socket connection to this specific client
//        PrintWriter messageOut;    // Stream for sending messages TO this client
//        BufferedReader messageIn;  // Stream for receiving messages FROM this client
//        String username;           // This client's assigned username
//
//        // Constructor receives the client's socket connection
//        public ClientHandler(Socket clientSocket) {
//            this.tempSocket = clientSocket;
//        }
//
//        @Override
//        public void run() {
//            // Set up input/output streams for this client
//            try {
//                // Create input stream to read messages from this client
//                messageIn = new BufferedReader(new InputStreamReader(tempSocket.getInputStream()));
//
//                // Create output stream to send messages to this client
//                messageOut = new PrintWriter(tempSocket.getOutputStream(),true);
//
//                // Assign an automatic username (User1, User2, etc.)
//                username = "User"+userCount++;
//
//                // Add this client's output stream to our master list
//                // This enables broadcasting to this client
//                clients.add(messageOut);
//
//                // Announce to all users that someone new has joined
//                notifyUsers(username+ " has joined chat");
//
//                // Main message processing loop for this client
//                String message;
//                while((message = messageIn.readLine()) != null){
//                    // Broadcast every message to all connected clients
//
//                    //notifyUsers("User: " + message);  ->changed this to the line below so we can
//                    //identify who is sending the message (I forgot to change this in class after I
//                    //added the username variable)
//                    notifyUsers(username + ": " + message);
//                }
//
//            } catch (IOException e) {
//                // Connection was lost or an error occurred
//                throw new RuntimeException(e);
//
//            } finally {
//                // Remove this client from the broadcast list
//                clients.remove(messageOut);
//
//                // Notify remaining users that someone left
//                notifyUsers(username + " has left");
//
//                // Close the socket connection properly
//                try {
//                    tempSocket.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//
//        // Helper method to broadcast a message to all connected clients
//        void notifyUsers(String message){
//            // Iterate through all client output streams
//            for(PrintWriter client: clients){
//                // Send the message to each client
//                client.println(message);
//            }
//        }
//    }
//}

//Server
public  class Server {
    private static JTextArea displayArea;

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Temperatutre Monitoring Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayArea = new JTextArea(20,40);
        displayArea.setEditable(false);
        frame.add( new JScrollPane(displayArea), BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

        ServerSocket serverSocket = new ServerSocket(5678);
        displayArea.append("Server has started on port 5678...\n");

        while(true){
            Socket clientSocket = serverSocket.accept();
            new Thread(new ClientHandler(clientSocket)).start();

        }




    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public ClientHandler(Socket socket) {
            this.client = socket;

        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String temperature = in.readLine();

                String clientIP = client.getInetAddress().getHostAddress();

                displayArea.append("client " + clientIP + " reported temperature: " + temperature + " Celcius\n ");

                client.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}



