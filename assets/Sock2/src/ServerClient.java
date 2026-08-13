//Client
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class ServerClient {
    public static void main(String[] args) throws Exception {

        //connect to server / send request
        Socket socket = new Socket("localhost",1234);
        System.out.println("Connected to server");

        //setting up the same streams we used in the server
        BufferedReader messageFromServer =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter messageToServer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader outBoundMessage = new BufferedReader(new InputStreamReader(System.in));

        String textToServer, textFromServer;

        while(true){
            System.out.println("You");
            textToServer = outBoundMessage.readLine();//what we are typing to the server
            messageToServer.println(textToServer);//send message to server

            if(textToServer.equalsIgnoreCase("exit")) break;

            textFromServer = messageFromServer.readLine();//read messages from server
            if(textFromServer == null || textFromServer.equalsIgnoreCase("exit"))
                break;
            System.out.println("Server says: " +textFromServer);
        }
        socket.close();
        System.out.println("Client disconnected");
    }
}

