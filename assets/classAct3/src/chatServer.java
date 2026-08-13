//3.1
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class chatServer {
    // List to store all connected clients' output streams (for broadcasting)
    static ArrayList<DataOutputStream> clientOutputs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // Create a server socket listening on port 5000
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started... Waiting for clients...");

        // Infinite loop to accept multiple clients
        while (true) {
            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket);

            // Create a new thread for this client
            ClientHandler handler = new ClientHandler(clientSocket);
            handler.start();
        }
    }
}

// Class to handle each client connection separately using multithreading
class ClientHandler extends Thread {
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    public ClientHandler(Socket socket) throws Exception {
        this.socket = socket;
        // Create input and output streams for this client
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());

        // Add this client's output stream to the server's list
        chatServer.clientOutputs.add(dos);
    }

    public void run() {
        try {
            // First message from client is their "username/title"
            String clientName = dis.readUTF();
            broadcast(">> " + clientName + " has joined the chat");

            // Keep reading messages from this client
            while (true) {
                String msg = dis.readUTF();
                broadcast(clientName + ": " + msg);
            }
        } catch (Exception e) {
            System.out.println("Client disconnected...");
        }
    }

    // Method to send message to all clients
    void broadcast(String message) throws Exception {
        for (DataOutputStream out : chatServer.clientOutputs) {
            out.writeUTF(message);
        }
    }
}

