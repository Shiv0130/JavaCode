import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form {

    Form() {
        JFrame frame = new JFrame("Simple Form");
        JLabel firstName = new JLabel("First name");
        firstName.setBounds(20,40,80,20);
        JTextField textField = new JTextField();
        textField.setBounds(20,60,100,20);
        JButton button = new JButton("Test");
        button.setBounds(20,120,80,20);

        //adding an action listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonListener.DialogMessage dlgMsg = new ButtonListener.DialogMessage();
            }
        });

        //adding components to our frame
        frame.add(firstName);
        frame.add(textField);
        frame.add(button);

        //sizing the frame
        frame.setLayout(null);
        frame.setSize(400,400);
        frame.setVisible(true);

    }
}
