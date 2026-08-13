import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    //Monday 25.08.2025

    // These streams handle the two-way communication with the server
    private BufferedReader fromOtherClient;  // Receives messages from the server (which includes messages from other clients)
    private PrintWriter toOtherClient;       // Sends our messages to the server

    // GUI components - the visual elements users interact with
    private JFrame frame = new JFrame("Chat Client");        // The main window
    private JTextArea messageArea = new JTextArea(15,40);    // Where all chat messages appear
    private  JTextField inputField = new JTextField(40);     // Where users type their messages

    public Client(String username) throws IOException{

        // Establish connection to the server running on the same machine (localhost) at port 1234
        // This creates a two-way communication channel between this client and the server
        Socket socket = new Socket("localhost",1234);

        // Set up the input stream to receive messages from the server
        fromOtherClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // Set up the output stream to send messages to the server
        toOtherClient = new PrintWriter(socket.getOutputStream(), true);

        // Configure the chat window layout
        messageArea.setEditable(false);  // Users can't directly edit the chat history
        // Add scrollable message area to the center of the window
        frame.getContentPane().add(new JScrollPane(messageArea), BorderLayout.CENTER);
        // Add input field to the bottom of the window
        frame.getContentPane().add(inputField,BorderLayout.SOUTH);
        frame.pack();  // Size the window to fit all components

        // Configure the input field to send messages when Enter is pressed
        // Using a lambda expression here for cleaner code
        inputField.addActionListener(e -> {
            toOtherClient.println(inputField.getText());  // Send the typed message to server
            inputField.setText("");                       // Clear the input field for next message
        });

        // Set the window to close the application when X is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  // Display the window to the user

        // Create a separate thread to continuously listen for incoming messages
        // This prevents the GUI from freezing while waiting for messages
        new Thread(() ->{
            try{
                String text;
                // Keep reading messages from the server indefinitely
                while((text = fromOtherClient.readLine()) != null){
                    // Special case: server is asking for our username
                    if(text.equals("Username")){
                        toOtherClient.print(username);  // Send our username
                        continue;  // Skip adding this to the message area
                    }
                    // For all other messages, display them in the chat area
                    messageArea.append(text + "\n");
                }
            } catch (IOException e) {
                // Connection was lost or an error occurred
                throw new RuntimeException(e);
            }
        }).start();  // Start the thread immediately
    }

    public static void main(String[] args) throws  Exception {
        // Display a dialog box asking the user to enter their username
        String username = JOptionPane.showInputDialog(
                null,                       // No parent component
                "Enter your username: ",    // Message to display
                "Username",                 // Dialog title
                JOptionPane.QUESTION_MESSAGE);  // Style of dialog (shows question icon)

        // Only create the client if a valid username was provided
        if(username != null && !username.trim().isEmpty()){
            new Client(username.trim());  // Create the client instance with trimmed username
        }
        // If username is null (user clicked Cancel) or empty, the application exits
    }
}