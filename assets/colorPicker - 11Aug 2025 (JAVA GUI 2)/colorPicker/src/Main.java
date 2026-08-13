import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ColorPicker picker = new ColorPicker();
        ColorPicker.colorP = new JFrame("Colour Picker");
        ColorPicker.colorP.setVisible(true);
        ColorPicker.colorP.setLayout(new GridLayout(5, 1));

        ColorPicker.rdRed = new JRadioButton("Red");
        ColorPicker.rdBlack = new JRadioButton("Black");
        ColorPicker.rdGreen = new JRadioButton("Green");
        ColorPicker.rdBlue = new JRadioButton("Blue");

        ColorPicker.rdRed.addActionListener(picker);
        ColorPicker.rdBlue.addActionListener(picker);
        ColorPicker.rdBlack.addActionListener(picker);
        ColorPicker.rdGreen.addActionListener(picker);

        ColorPicker.btnGroup = new ButtonGroup();
        ColorPicker.btnGroup.add(ColorPicker.rdRed);
        ColorPicker.btnGroup.add(ColorPicker.rdGreen);
        ColorPicker.btnGroup.add(ColorPicker.rdBlue);
        ColorPicker.btnGroup.add(ColorPicker.rdBlack);

        ColorPicker.labelColor = new JLabel();
        ColorPicker.labelColor.setOpaque(true);
        ColorPicker.labelColor.setHorizontalAlignment(SwingConstants.CENTER);
        ColorPicker.labelColor.setForeground(Color.white);

        ColorPicker.colorP.add(ColorPicker.rdBlack);
        ColorPicker.colorP.add(ColorPicker.rdBlue);
        ColorPicker.colorP.add(ColorPicker.rdRed);
        ColorPicker.colorP.add(ColorPicker.rdGreen);
        ColorPicker.colorP.add(ColorPicker.labelColor);
    }
}