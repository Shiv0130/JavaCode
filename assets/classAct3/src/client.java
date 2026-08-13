//2.2 Client class code
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost",2134);
        System.out.println("Connected to server");

        BufferedReader messageFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter messageToServer = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader outBoundMessage = new BufferedReader(new InputStreamReader(System.in));

        String textFromServer,textToServer;

        while(true){
            System.out.println("You:");
            textToServer = outBoundMessage.readLine();
            messageToServer.println(textToServer);

            if(textToServer.equalsIgnoreCase("exit")) break;

            textFromServer = messageFromServer.readLine();

            if(textFromServer == null || textFromServer.equalsIgnoreCase("exit")) break;
            System.out.println("Server says:" + textFromServer);

        }
        socket.close();
        System.out.println("Client disconnected");



    }
}
