//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class ServerGUI {
//    public static void main(String[] args) throws IOException {
//
//        //GUI Setup
//        JFrame frame = new JFrame("Chatapp example");
//        frame.setSize(400,400);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JTextArea textArea = new JTextArea();
//        textArea.setEditable(false);
//
//        JTextField inputField = new JTextField();
//        JButton sendButton = new JButton("Send");
//
//        JPanel panel = new JPanel(new BorderLayout());
//        panel.add(inputField,BorderLayout.CENTER);
//        panel.add(sendButton,BorderLayout.EAST);
//
//        frame.add(new JScrollPane(textArea),BorderLayout.CENTER);
//        frame.add(panel,BorderLayout.SOUTH);
//
//        frame.setVisible(true);
//
//
//
//        //Networking setup
//
//        ServerSocket serverSocket = new ServerSocket(6000);
//        System.out.println("Server started. Waiting for client...\n");
//        Socket socket = serverSocket.accept();
//        System.out.println("Clien connected \n");
//
//        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
//        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//        //String message = in.readLine();
//        //out.println("Client says:" + message);
//
//        // RECIEVE THREAD
//        //This thread constantly listens for messages from client
//
//        new Thread(() -> {
//            try{
//                String message;
//                while((message = in.readLine())!= null){
//                    textArea.append("Client: " + message + "\n" );
//
//                }
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }).start();
//
//        //Send Button Action
//        sendButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getSource()==sendButton){
//                    String message = inputField.getText();
//                    textArea.append("Server: " + message + "\n");
//                    inputField.setText("");
//                }
//            }
//        });
//
//
//
//
//
//
//        serverSocket.close();;
//
//    }
//}

//ServerGUI Fixed
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerGUI {
    public static void main(String[] args) throws IOException {

        //GUI Setup
        JFrame frame = new JFrame("Chatapp example");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        JTextField inputField = new JTextField();
        JButton sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField,BorderLayout.CENTER);
        panel.add(sendButton,BorderLayout.EAST);

        frame.add(new JScrollPane(textArea),BorderLayout.CENTER);
        frame.add(panel,BorderLayout.SOUTH);

        frame.setVisible(true);

        //Networking setup
        ServerSocket serverSocket = new ServerSocket(6000);
        textArea.append("Server started. Waiting for client...\n");
        Socket socket = serverSocket.accept();
        textArea.append("Client connected!\n");

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // RECIEVE THREAD
        new Thread(() -> {
            try{
                String message;
                while((message = in.readLine()) != null){
                    textArea.append("Client: " + message + "\n"); // Display incoming messages
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();

        //Send Button Action
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                out.println(message); // <-- FIX: Send message to client
                textArea.append("Server: " + message + "\n");
                inputField.setText("");
            }
        });

        // FIX: Do NOT close serverSocket here, let it run while GUI is open
    }
}
