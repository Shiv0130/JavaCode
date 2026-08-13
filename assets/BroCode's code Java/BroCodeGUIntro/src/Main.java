import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String  name  = JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showMessageDialog(null," Hello there " + name );

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
        JOptionPane.showMessageDialog(null," Your age is: " +  age);

        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height in cm:"));
        JOptionPane.showMessageDialog(null," Your height is: " + height);
    }
}

