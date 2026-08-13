////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////
////public class ButtonListener implements ActionListener {
////    @Override
////    public void actionPerformed(ActionEvent e) {
////
////    }
////}
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class ButtonListener implements ActionListener {
//    JButton jButton;
//
//    public void start(){
//        JFrame jFrame = new JFrame("ActionListener Implementation");
//        jButton = new JButton("Open Dialog");
//        jButton.addActionListener(this);
//        jFrame.add(jButton);
//        jFrame.setBounds(20,80,400,400);
//        jFrame.setVisible(true);
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == jButton){
//            DialogMessage dlgMsg = new DialogMessage();
//        }
//    }
//    static class DialogMessage extends JDialog implements ActionListener{
//
//        DialogMessage(){
//            JPanel jPanel = new JPanel();
//
//            jPanel.add(new JLabel("This should be JTextfield text"));
//            this.add(jPanel);
//            JPanel btnPnl = new JPanel();
//            JButton btnOK = new JButton("OK");
//            btnOK.addActionListener(this);
//            btnPnl.add(btnOK);
//            this.add(btnPnl, BorderLayout.SOUTH);
//            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            pack();
//            setVisible(true);
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            setVisible(false);
//            dispose();
//        }
//    }
//}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ButtonListener class implements ActionListener to handle the "Submit" button click event.
 * It retrieves values from text fields, validates them, and displays them in a dialog.
 */
public class ButtonListener implements ActionListener {

    // References to the form input fields
    private JTextField fnTextfield;      // First name field
    private JTextField lnTextfield;      // Last name field
    private JTextField eTextfield;       // Email field
    private JPasswordField passwordField; // Password field

    /**
     * Constructor for ButtonListener.
     * Takes references to the form's input fields so it can access their values when the button is clicked.
     */
    public ButtonListener(JTextField fnTextfield, JTextField lnTextfield,
                          JTextField eTextfield, JPasswordField passwordField) {
        this.fnTextfield = fnTextfield;
        this.lnTextfield = lnTextfield;
        this.eTextfield = eTextfield;
        this.passwordField = passwordField;
    }

    /**
     * This method is called automatically when the associated button is clicked.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Retrieve the entered text from each field and trim spaces
        String fName = fnTextfield.getText().trim();
        String lName = lnTextfield.getText().trim();
        String email = eTextfield.getText().trim();
        String password = new String(passwordField.getPassword()); // Convert password from char[] to String

        // Check if any of the fields are empty
        if (fName.isEmpty() || lName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            // Show an error dialog if fields are missing
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Prepare the message with the entered data
            String message = "First Name: " + fName + "\n"
                    + "Last Name: " + lName + "\n"
                    + "Email: " + email + "\n"
                    + "Password: " + password;

            // Display the collected information in a dialog box
            JOptionPane.showMessageDialog(null, message, "Registration Data", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
