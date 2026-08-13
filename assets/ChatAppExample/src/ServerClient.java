import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerClient {
    //Friday 29.08.2025
    public static void main(String[] args) throws Exception {
        // Establish connection to the chat server
        // Note: This connects to port 5678
        Socket socket = new Socket("localhost",5678);


        // Create the main chat window with appropriate title
        JFrame chatWindow = new JFrame("Chat App");
        // Text area for displaying chat messages (20 rows, 30 columns)
        JTextArea chatArea = new JTextArea(20,30);
        // Input field where users type their messages
        JTextField input = new JTextField(30);
        // Configure the chat area to be read-only (users can't edit chat history)
        chatArea.setEditable(false);

        // Add components to the window:
        //Scrollable chat area in the center
        //Input field at the bottom
        chatWindow.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        chatWindow.add(input,BorderLayout.SOUTH);

        // Configure window behavior and display it
        chatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatWindow.pack();  // Size window to fit components
        chatWindow.setVisible(true);


        // Output stream for sending messages to the server
        PrintWriter messageOut = new PrintWriter(socket.getOutputStream(),true);

        // Input stream for receiving messages from the server
        BufferedReader messageIn =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));


        // Create a separate thread to continuously listen for incoming messages
        // This prevents the GUI from blocking while waiting for messages
        new Thread(() ->{
            try{
                String message;
                // Continuously read messages from the server
                while((message = messageIn.readLine())!= null){
                    // Terminal output option
                    // System.out.println(message);

                    // GUI output - append message to chat area
                    chatArea.append(message + "\n");
                }
            }catch (Exception e){
                // Connection lost or error occurred
                // Consider adding error handling here
            }
        }).start();

        // Set up Enter key functionality for sending messages
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from input field
                String message = input.getText();

                // Only send non-empty messages
                if(!message.isEmpty()){
                    messageOut.println(message);  // Send to server
                    input.setText("");            // Clear input field
                }
            }
        });

        // This section provides an alternative way to run the client using only the terminal
        // To use terminal mode: comment out the GUI code above and uncomment this section
        /*
        // Create scanner for reading terminal input
        Scanner scanner = new Scanner(System.in);

        // Continuously read user input from terminal
        while(true){
            String message = scanner.nextLine();

            // Allow user to exit by typing "exit"
            if(message.equalsIgnoreCase("exit"))break;

            // Send the message to server
            messageOut.println(message);
        }

        socket.close();
        System.out.println("Client disconnected");
        */
    }
}