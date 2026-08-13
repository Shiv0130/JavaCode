////Server
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Server {
//    public static void main(String[] args) throws IOException {
//
//        ServerSocket serverSocket = new ServerSocket(1234);
//
//        Socket socket = serverSocket.accept();
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
//
//        String messageIn,messageOut;
//
//        while(true){
//            messageIn = bufferedReader.readLine();
//
//            if(messageIn == null || messageIn.equalsIgnoreCase("exit") )
//                break;
//
//            messageOut = "Hello client pickup is made";
//
//            printWriter.println(messageOut);
//
//            System.out.println("Client:" +  messageOut);
//        }
//
//        serverSocket.close();
//        socket.close();
//    }
//}
//Server
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started on localhost:1234"); // FIXED: Added server status message

        Socket socket = serverSocket.accept();
        System.out.println("Client connected"); // FIXED: Added connection status message

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);

        // FIXED: Removed while loop - requirement says "single client connection" and "receive A delivery instruction"
        // FIXED: Changed to receive only one instruction, not continuous messaging
        String messageIn = bufferedReader.readLine();

        if(messageIn != null) { // FIXED: Added null check
            System.out.println("Received delivery instruction: " + messageIn); // FIXED: Better logging message

            // FIXED: Send back the SAME instruction as received (requirement states "Send back the same instruction")
            printWriter.println(messageIn); // This was the main issue - you were sending a fixed message

            System.out.println("Sent back to client: " + messageIn); // FIXED: Correct logging message
        }

        // FIXED: Close all resources properly (requirement: "Close the connection")
        bufferedReader.close(); // FIXED: Added missing resource cleanup
        printWriter.close();    // FIXED: Added missing resource cleanup
        serverSocket.close();
        socket.close();

        System.out.println("Connection closed"); // FIXED: Added closure confirmation
    }
}


