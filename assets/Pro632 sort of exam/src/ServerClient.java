//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.sql.SQLOutput;
//
//public class ServerClient {
//    public static void main(String[] args) throws Exception {
//        //setting up the same streams we used in the server
//        Socket socket = new Socket("localhost",1234);
//        System.out.println();
//        BufferedReader messageFromServer =
//                new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//        PrintWriter messageToServer = new PrintWriter(socket.getOutputStream(), true);
//        BufferedReader outBoundMessage = new BufferedReader(new InputStreamReader(System.in));
//
//        String textToServer, textFromServer;
//
//        while(true){
//            System.out.println("You");
//            textToServer = outBoundMessage.readLine();//what we are typing to the server
//            messageToServer.println(textToServer);//send message to server
//
//            if(textToServer.equalsIgnoreCase("exit")) break;
//
//            textFromServer = messageFromServer.readLine();//read messages from server
//            if(textFromServer == null || textFromServer.equalsIgnoreCase("exit"))
//                break;
//            System.out.println("Server says: " +textFromServer);
//        }
//        socket.close();
//        System.out.println("Client disconnected");
//    }
//}
//

// ===== CLIENT CODE =====
import java.io.*;                     // Required for IO streams
import java.net.*;                   // Required for socket creation

public class ServerClient {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 1234);
        // Connects to server using TCP on localhost port 1234

        BufferedReader messageFromServer =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // Reads responses from server

        PrintWriter messageToServer = new PrintWriter(socket.getOutputStream(), true);
        // Sends messages to server

        BufferedReader outBoundMessage = new BufferedReader(new InputStreamReader(System.in));
        // Reads user keyboard input

        String textToServer, textFromServer;

        while (true) {
            System.out.println("You:");
            textToServer = outBoundMessage.readLine();
            // Reads text you type in console

            messageToServer.println(textToServer);
            // Sends typed message to server

            if (textToServer.equalsIgnoreCase("exit")) break;

            textFromServer = messageFromServer.readLine();
            // Reads server response

            System.out.println("Server says: " + textFromServer);
        }

        socket.close();
        // Ends client connection
        System.out.println("Client disconnected");
    }
}
