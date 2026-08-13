import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //JPanel = GUI component that functions as a container to hold other components

        JLabel RedLabel = new JLabel("Red");
        JLabel BlueLabel = new JLabel("Blue");
        JLabel GreenLabel = new JLabel("Green");

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0,0,250,250);

        JPanel bluePanel =  new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250,0,250,250);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0,250,500,250);


        JFrame frame = new JFrame("Panels");
        frame.setSize(750,750);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        redPanel.add(RedLabel);
        bluePanel.add(BlueLabel);
        greenPanel.add(GreenLabel);
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);



    }
}