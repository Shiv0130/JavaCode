import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //JCheckbox = A GUI component that can be selected or deselected

        JFrame frame = new JFrame("CheckBox");
        JCheckBox checkBox = new JCheckBox("I'm not a robot");
        JButton button = new JButton("submit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button){
                    if(checkBox.isSelected()){
                        System.out.println("Checkbox is selected");
                    } else{
                        System.out.println("Checkbox isn't selected");
                    }

                }
            }
        });
        //checkBox.setBounds(0,0,250,250);
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Arial",Font.BOLD,20));
        frame.setLayout(new FlowLayout());
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(checkBox);
        frame.add(button);
        frame.pack();
    }
}