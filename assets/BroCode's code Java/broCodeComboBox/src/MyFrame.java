import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JComboBox comboBox;
    JLabel label;
    MyFrame(){
        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel();
        label.setBounds(100,20,100,20);
        this.setLayout(new FlowLayout());
        String [] animals = {"dog","cat","bird"};
        comboBox = new JComboBox(animals);
        //comboBox.setEditable(true);
        //comboBox.addItem("horse");
        //comboBox.removeItem("cat");
        //comboBox.insertItemAt("pig",0);
        //comboBox.setSelectedIndex(0);
        //comboBox.removeItemAt(0);
        //comboBox.removeAllItems();
        comboBox.addActionListener(this);
        this.add(comboBox);
        //this.add(label);
        this.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
            System.out.println(comboBox.getSelectedItem());
            //label.setText(String.valueOf(comboBox.getSelectedItem()));

        }

    }
}
