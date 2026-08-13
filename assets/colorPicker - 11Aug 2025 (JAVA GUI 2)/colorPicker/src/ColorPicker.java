import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPicker extends JPanel implements ActionListener {

    static JFrame colorP;
    static JRadioButton rdRed, rdGreen, rdBlue, rdBlack;
    static JLabel labelColor;
    static ButtonGroup btnGroup;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(rdRed.isSelected()){
            labelColor.setText("Red is selected");
            labelColor.setBackground(Color.red);
        }
        else if (rdGreen.isSelected()){
            labelColor.setText("Green is selected");
            labelColor.setBackground(Color.green);
        }
        else if (rdBlue.isSelected()){
            labelColor.setText("Blue is selected");
            labelColor.setBackground(Color.blue);
        }
        else if (rdBlack.isSelected()){
            labelColor.setText("Black is selected");
            labelColor.setBackground(Color.black);
            colorP.setBackground(Color.black);
        }
    }
}
