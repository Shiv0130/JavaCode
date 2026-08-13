////Cleint
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class Client {
//    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket("localhost",1234);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
//
//        String messageIn,messageOut = "";
//
//        while(true){
//            messageIn = bufferedReader.readLine();
//
//            if(messageIn == null || messageIn.equalsIgnoreCase("exit") )
//                break;
//
//            printWriter.println(messageOut);
//
//            messageOut =  messageIn + " ";
//
//
//            System.out.println("Server:" +  messageOut);
//        }
//
//
//        socket.close();
//    }
//
//    }
//

//Client
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner; // FIXED: Added Scanner import for better console input

public class Client {
    public static void main(String[] args) throws IOException {
        // FIXED: Added input validation as required
        Scanner scanner = new Scanner(System.in);
        String deliveryInstruction;

        // FIXED: Validate that instruction is not empty (requirement)
        do {
            System.out.print("Enter delivery instruction: "); // FIXED: Added proper prompt
            deliveryInstruction = scanner.nextLine().trim();

            if(deliveryInstruction.isEmpty()) {
                System.out.println("Error: Instruction cannot be empty. Please try again."); // FIXED: Validation message
            }
        } while(deliveryInstruction.isEmpty());

        Socket socket = new Socket("localhost",1234);
        System.out.println("Connected to server"); // FIXED: Added connection status

        // FIXED: Removed BufferedReader for System.in - using Scanner instead
        // FIXED: Added BufferedReader for socket input to receive server response
        BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);

        // FIXED: Send the validated instruction to server (not empty messageOut)
        printWriter.println(deliveryInstruction);
        System.out.println("Sent instruction: " + deliveryInstruction); // FIXED: Better logging

        // FIXED: Receive and display server's reply (this was missing)
        String serverReply = socketReader.readLine();
        System.out.println("Server replied: " + serverReply); // FIXED: Display server response as required

        // FIXED: Removed while loop - requirement is for single instruction exchange
        // FIXED: Close all resources properly
        socketReader.close(); // FIXED: Added missing resource cleanup
        printWriter.close();  // FIXED: Added missing resource cleanup
        socket.close();
        scanner.close();      // FIXED: Added Scanner cleanup

        System.out.println("Connection closed"); // FIXED: Added closure confirmation
    }
}