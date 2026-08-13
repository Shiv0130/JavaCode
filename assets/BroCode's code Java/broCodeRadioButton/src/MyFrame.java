import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JRadioButton pizzaButton;
    JRadioButton hamburgerButton;
    JRadioButton hotdogButton;
    MyFrame(){
         pizzaButton = new JRadioButton("pizza");
         hamburgerButton = new JRadioButton("hamburger");
         hotdogButton = new JRadioButton("hotdog");

         ButtonGroup group = new ButtonGroup();

         group.add(pizzaButton);
         group.add(hamburgerButton);
         group.add(hotdogButton);

         pizzaButton.addActionListener(this);
         hamburgerButton.addActionListener(this);
         hotdogButton.addActionListener(this);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());
        this.add(pizzaButton);
        this.add(hamburgerButton);
        this.add(hotdogButton);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== pizzaButton){
            System.out.println("You ordered pizza");
        }
        else if(e.getSource()==hamburgerButton){
            System.out.println("You ordered hamburger");
        }
        else if(e.getSource()==hotdogButton){
            System.out.println("You ordered hotdog");
        }
        else {
            System.out.println("Please select something");

        }

    }
}
