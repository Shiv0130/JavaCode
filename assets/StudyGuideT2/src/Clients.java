import java.io.*;
import java.net.*;

public class Clients {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234); // Connect to server on same PC
        System.out.println("Connected to server.");

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("Hello Server!"); // Send message
        String reply = in.readLine(); // Receive reply

        System.out.println("Server says: " + reply);

        socket.close();
    }
}

