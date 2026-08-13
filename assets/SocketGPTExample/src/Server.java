//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Server {
//    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(1234);
//
//        Socket socket = serverSocket.accept();
//        System.out.println("Client connected");
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
//
//        String message = in.readLine();
//        System.out.println("Client says:" + message);
//
//        out.println("Hello Client, I got your message:" + message);
//
//        socket.close();
//        serverSocket.close();
//    }
//}

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234); // Server on port 1234
        System.out.println("Server started. Waiting for a client...");

        Socket socket = serverSocket.accept(); // Accept client connection
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message = in.readLine(); // Read message from client
        System.out.println("Client says: " + message);

        out.println("Hello Client, I got your message: " + message);

        socket.close();
        serverSocket.close();
    }
}
