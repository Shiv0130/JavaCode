import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button; // we making this global
    JLabel label;
    MyFrame(){

        ImageIcon icon = new ImageIcon("yourpointing.png");
        ImageIcon icon2 = new ImageIcon("world.png");
        label = new JLabel();
        label.setBounds(150,350,150,150);
        label.setVisible(false);
        button = new JButton("I'm a button!");
        button.setBounds(100,100,350,200);

        button.addActionListener(this);
        button.setFocusable(false);
        button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
       // button.addActionListener(e -> System.out.println("sure") );
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        label.setIcon(icon2);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.add(button);
        this.add(label);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            //System.out.println("Sure");
            //button.setEnabled(false);
            label.setVisible(true);
        }

    }
}
