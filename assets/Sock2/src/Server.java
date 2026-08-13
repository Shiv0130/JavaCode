//Server
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.sql.SQLOutput;

public class Server {
    public static void main(String[] args) throws Exception {

        //Create a server socket that will listen on some port
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server connected: ");

        //Ensure our server can accept a connection
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        //Setup stream for read/write operations (always handled by IOs)
        BufferedReader messageFromClient =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
        /* The line above just binds the input stream to our socket
        so that we can be able to translate whatever comes from the client
        into strings* */
        PrintWriter messageToClient = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader outgoingMessage = new BufferedReader(new InputStreamReader((System.in)));

        String textFromClient, textToClient;
        while(true){
            textFromClient = messageFromClient.readLine();
            if(textFromClient == null || textFromClient.equalsIgnoreCase("exit"))
                break;
            System.out.println("Client: "+ textFromClient); //messages from client
            System.out.println("You: ");
            textToClient = outgoingMessage.readLine();//to read/ see what you're sending
            messageToClient.println(textToClient); //"send" the message to the client

            if(textToClient.equalsIgnoreCase("exit")) break;
        }
        socket.close();
        serverSocket.close();
        System.out.println("Server disconnected");


    }
}




//Friday 22 August