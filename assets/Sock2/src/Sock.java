import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Sock {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9876);
        Socket skt = serverSocket.accept();
        DataInputStream dataInputStream = new DataInputStream(skt.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(skt.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));

        String string="", string2="";
        while(!string.equals("exit")){
            string = dataInputStream.readUTF();
            System.out.println("Client says: " + string);
            string2 = bufferedReader.readLine();
            dataOutputStream.writeUTF(string2);
            dataOutputStream.flush();
        }
        dataInputStream.close();
        skt.close();
        serverSocket.close();
    }
}