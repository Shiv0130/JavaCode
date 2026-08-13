import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost",9876);
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = "",string2 = "";

        while(!string.equals("exit")){

            string = br.readLine();
            dout.writeUTF(string);
            dout.flush();

            string2 = din.readUTF();

            System.out.println("Server says:" + string2);

        }
        dout.close();
        socket.close();

    }
}
