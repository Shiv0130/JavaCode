import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

////Client
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Client {
//
//    public static void main(String[] args) throws Exception {
//
//        JFrame chatWindow = new JFrame("Temp Monitor App");
//
//        JTextArea chatArea = new JTextArea(20,30);
//
//        JTextField inputPort = new JTextField(30);
//
//        JTextField inputTemp = new JTextField(50);
//        JTextField inputIPAddress = new JTextField(70);
//        chatArea.setEditable(false);
//        JButton button = new JButton("Send Temparature");
//
//
//
//
//        chatWindow.add(new JScrollPane(chatArea), BorderLayout.CENTER);
//        chatWindow.add(inputPort,BorderLayout.SOUTH);
//        chatWindow.add(inputIPAddress,BorderLayout.NORTH);
//        chatWindow.add(inputTemp,BorderLayout.NORTH);
//
//
//
//        chatWindow.add(button,BorderLayout.SOUTH);
//
//
//        chatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        chatWindow.pack();
//        chatWindow.setVisible(true);
//
//
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e)  {
//
//                Socket socket = new Socket("localhost",5678);
//                // Output stream for sending messages to the server
//                PrintWriter messageOut = new PrintWriter(socket.getOutputStream(),true);
//
//
//                BufferedReader messageIn =
//                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//
//
//                new Thread(() ->{
//                    try{
//                        String message;
//
//                        while((message = messageIn.readLine())!= null){
//
//                            chatArea.append(message + "\n");
//                        }
//                    }catch (Exception e ){
//
//                    }
//                }).start();
//
//
//                String message = inputTemp.getText();
//
//
//                if(!message.isEmpty()){
//                    messageOut.println(message);
//                    inputTemp.setText("");
//
//
//
//                });
//
//
//
//
//
//
//    }
//}
//

//Client
public class Client {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Temp Sensor Client");

        JTextField ipField = new JTextField("localhost",15);
        JTextField portField = new JTextField("5678",5);
        JTextField tempField = new JTextField(10);

        JButton sendButton = new JButton("Send Temperature");

        JTextArea statusArea = new JTextArea(10,30);
        statusArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Server IP"));
        panel.add(ipField);
        panel.add(new JLabel("Port"));
        panel.add(portField);
        panel.add(tempField);
        panel.add(sendButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(statusArea),BorderLayout.CENTER);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        sendButton.addActionListener( e->{
            String serverIP = ipField.getText().trim();
            int port = Integer.parseInt(portField.getText().trim());
            String temperature = tempField.getText().trim();


            try {
                Socket socket = new Socket(serverIP,port);

                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                out.println(temperature);

                statusArea.append("Sent temperature " +  temperature  + " celcius  to " + serverIP + port + " \n " );

                socket.close();


            } catch (IOException ex) {
                statusArea.append("Error:" + ex.getMessage() + "\n");
                throw new RuntimeException(ex);
            }


        });

    }
}



















