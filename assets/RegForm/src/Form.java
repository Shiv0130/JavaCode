//original code
// import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Form {
//
//    Form(){
//        JFrame frame = new JFrame("Signin form");
//        JLabel firstName = new JLabel("First Name:");
//        firstName.setBounds(20,40,80,20);
//
//        JTextField fnTextfield = new JTextField();
//        fnTextfield.setBounds(20,80,120,30);
//
//        JLabel lastName = new JLabel("Last Name:");
//        lastName.setBounds(20,60,100,20);
//
//        JTextField lnTextfield = new JTextField();
//        lnTextfield.setBounds(20,80,120,30);
//
//        JLabel email = new JLabel("Email:");
//        email.setBounds(30,90,120,30);
//
//        JTextField eTextfield = new JTextField();
//        eTextfield.setBounds(30,120,150,60);
//
//        JLabel password = new JLabel("Password");
//        password.setBounds(30,180,210,90);
//
//        JPasswordField passwordField = new JPasswordField();
//        passwordField.setBounds(30,210,240,120);
//
//        JButton sumbitButton = new JButton("Submit Button");
//        sumbitButton.setBounds(30,270,300,150);
//
//
//        sumbitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        //adding components to our frame
//        frame.add(firstName);
//        frame.add(fnTextfield);
//
//        frame.add(lastName);
//        frame.add(lnTextfield);
//
//        frame.add(email);
//        frame.add(eTextfield);
//
//        frame.add(password);
//        frame.add(passwordField);
//
//        frame.add(sumbitButton);
//
//        //sizing the frame
//        frame.setLayout(null);
//        frame.setSize(400,400);
//        frame.setVisible(true);
//
//
//
//
//    }
//}


import javax.swing.*;

public class Form {

    Form() {
        JFrame frame = new JFrame("Sign-in Form");

        // First name
        JLabel firstName = new JLabel("First Name:");
        firstName.setBounds(20, 20, 100, 25);
        JTextField fnTextfield = new JTextField();
        fnTextfield.setBounds(130, 20, 200, 25);

        // Last name
        JLabel lastName = new JLabel("Last Name:");
        lastName.setBounds(20, 60, 100, 25);
        JTextField lnTextfield = new JTextField();
        lnTextfield.setBounds(130, 60, 200, 25);

        // Email
        JLabel email = new JLabel("Email:");
        email.setBounds(20, 100, 100, 25);
        JTextField eTextfield = new JTextField();
        eTextfield.setBounds(130, 100, 200, 25);

        // Password
        JLabel password = new JLabel("Password:");
        password.setBounds(20, 140, 100, 25);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(130, 140, 200, 25);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(130, 180, 100, 30);

        // Attach ButtonListener
        submitButton.addActionListener(
                new ButtonListener(fnTextfield, lnTextfield, eTextfield, passwordField)
        );

        // Add components
        frame.add(firstName);
        frame.add(fnTextfield);
        frame.add(lastName);
        frame.add(lnTextfield);
        frame.add(email);
        frame.add(eTextfield);
        frame.add(password);
        frame.add(passwordField);
        frame.add(submitButton);

        // Frame settings
        frame.setLayout(null);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

