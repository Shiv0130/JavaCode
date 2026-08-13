import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JTextField textField;
    JButton button;

    MyFrame(){
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        button = new JButton("Submit");
        button.addActionListener(this);
        this.add(button);
        this.add(textField);
        this.pack();
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== button){
            button.setEnabled(false);
            textField.setEditable(false);
            System.out.println("Welcome " + textField.getText());
        }

    }
}
