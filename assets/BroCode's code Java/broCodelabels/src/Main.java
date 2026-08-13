import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // JLabel = a GUI display area for a string of text, an image or both.

        ImageIcon image = new ImageIcon("dude.png");
        Border border = BorderFactory.createLineBorder(Color.green,3);

        JLabel label = new JLabel("Bro do you even code?"); // creates a label and sets text within the label
        label.setIcon(image);

        label.setHorizontalTextPosition(JLabel.CENTER); // LEFT,RIGHT or CENTER of imageIcon
        label.setVerticalTextPosition(JLabel.TOP); // set text TOP,CENTER,BOTTOM of imageIcon
        label.setForeground(new Color(0x00FF00)); // using hexadecinal to set font color of text to green
        label.setFont(new Font("MV Boli",Font.PLAIN,20)); // sets font of text
        label.setIconTextGap(-8);// set gap of text to image, the bigger you make it the higher the gap from image to text
        label.setBackground(Color.black);// set background color
        label.setOpaque(true); // display background color
        label.setBorder(border);
        //label.setVerticalAlignment(JLabel.TOP); // set vertical position of icon + text within lable to top
        label.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label to center
        label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+ text within label to center
        //label.setBounds(0,0,350,350); // Sets x and y postions in frame as well as dimensions. I'm sticking to 350
        // in this cas cause the picture is displaying properly with these dimensions.
        // It likes to align to the left due to the x and y dimensions being 0.
        //label.setBounds(100,100,350,350); // Sets x and y postions in frame as well as dimensions.
        // I'm sticking to 350 in this cas cause the picture is displaying properly with these dimensions.
        // Here it pushes the picture 100px to the right and 100px down.



        JFrame frame = new JFrame("Working with Labels");
        //frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.pack();





    }
}