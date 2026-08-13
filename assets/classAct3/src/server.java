//2.1 Server class code
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(2134);
        System.out.println("Server is connected");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        BufferedReader messageFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter messageToClient = new PrintWriter(socket.getOutputStream(),true);

        BufferedReader outgoingMessage = new BufferedReader(new InputStreamReader(System.in));

        String textFromClient,textToClient;

        while(true){
            textFromClient = messageFromClient.readLine();

            if(textFromClient == null || textFromClient.equalsIgnoreCase("exit"))
                break;
            System.out.println("Client:" + textFromClient.toUpperCase());
            System.out.println("You:");

            textToClient = outgoingMessage.readLine();
            messageToClient.println(textToClient);

            if(textToClient.equalsIgnoreCase("exit")) break;
        }
        socket.close();
        serverSocket.close();
        System.out.println("Server disconnected");

    }
}
