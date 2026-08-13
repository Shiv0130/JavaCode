import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AttemptClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",5000);
        System.out.println("Connected to server");

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message = bufferedReader.readLine();

        printWriter.println("Hi Server!" + message);

            socket.close();


    }
}
