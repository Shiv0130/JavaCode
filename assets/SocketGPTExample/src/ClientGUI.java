//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class ClientGUI {
//    public static void main(String[] args) throws IOException {
//
//        //GUI SETUP
//        JFrame frame = new JFrame("ChatClient");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400,400);
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
//        //NETWORKING SETUP
//        Socket socket = new Socket("localhost",6000);
//        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
//        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//
//        //RECIEVE THREAD
//
//        new Thread(()->{
//
//            String message;
//
//            while(true){
//                try {
//                    while ((message= in.readLine())!=null){
//
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//        }).start();
//
//        //SEND BUTTON ACTION
//        sendButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getSource()==sendButton){
//                    String message = inputField.getText();
//                    out.println(message);
//                    textArea.append("Client: " + message + "\n" );
//                    inputField.setText("");
//                }
//            }
//        });
//
//        socket.close();
//
//    }
//}

//ClientGUI Fixed
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientGUI {
    public static void main(String[] args) throws IOException {

        //GUI SETUP
        JFrame frame = new JFrame("ChatClient");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);

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

        //NETWORKING SETUP
        Socket socket = new Socket("localhost",6000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //RECIEVE THREAD
        new Thread(() -> {
            String message;
            try {
                while ((message = in.readLine()) != null){
                    textArea.append("Server: " + message + "\n"); // <-- FIX: Display incoming messages
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        //SEND BUTTON ACTION
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                out.println(message); // Send message to server
                textArea.append("Client: " + message + "\n"); // Display locally
                inputField.setText("");
            }
        });

        // FIX: Do NOT close socket here, leave it open while GUI is active
    }
}
