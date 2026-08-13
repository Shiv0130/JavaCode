//3.2
//Rewrite and master these two codes
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class chatClient extends JFrame implements ActionListener {
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    JTextArea textArea;
    JTextField textField;
    JButton sendButton;
    String clientName;

    public chatClient(String name) throws Exception {
        clientName = name;

        // Connect to server running on localhost, port 5000
        socket = new Socket("localhost", 5000);

        // Create input and output streams
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());

        // Send the client's name to the server first
        dos.writeUTF(clientName);

        // GUI setup
        textArea = new JTextArea();
        textArea.setEditable(false); // user cannot type inside
        textField = new JTextField(20);
        sendButton = new JButton("Send");

        // Add ActionListener to the button
        sendButton.addActionListener(this);

        // Layout
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(sendButton);
        add(panel, BorderLayout.SOUTH);

        setTitle("Chat Client - " + clientName);
        setSize(400, 300);
        setVisible(true);

        // Start a thread to listen for incoming messages from server
        new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        String msg = dis.readUTF();
                        textArea.append(msg + "\n");
                    }
                } catch (Exception e) {
                    textArea.append("Disconnected from server.\n");
                }
            }
        }).start();
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            // Send message typed in textField to server
            String msg = textField.getText();
            dos.writeUTF(msg);
            textField.setText(""); // clear after sending
        } catch (Exception e) {
            textArea.append("Error sending message.\n");
        }
    }

    public static void main(String[] args) throws Exception {
        // Ask user for their name before starting chat
        String name = JOptionPane.showInputDialog("Enter your name:");
        new chatClient(name);
    }
}

