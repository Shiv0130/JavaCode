////Class
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MonthlyForm {
//    MonthlyForm(){
//        JFrame frame = new JFrame("Monthly Calculator");
//        JLabel labelcBalance = new JLabel("Current Balance");
//        labelcBalance.setBounds();
//
//        JTextField current_balance = new JTextField();
//        current_balance.setBounds();
//
//        JLabel labeliRate = new JLabel("Interest rate");
//        labeliRate.setBounds();
//
//        JTextField interest_rate = new JTextField();
//        interest_rate.setBounds();
//
//        JLabel labelmRate = new JLabel("Monthly Interest");
//        labelmRate.setBounds();
//
//        JTextField monthlyInterest = new JTextField();
//
//        JButton calculate = new JButton("Calculate");
//        calculate.setBounds();
//
//        JButton clear_button = new JButton("C");
//        clear_button.setBounds();
//
//        calculate.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                double CurrentBalance = Double.parseDouble(current_balance.getText());
//                double annualInterestRate = Double.parseDouble(interest_rate.getText());
//                double MonthlyInterest = Double.parseDouble(monthlyInterest.getText());
//
//                monthlyInterest.setText(String.valueOf(MonthlyInterest));
//
//
//            }
//        });
//
//        clear_button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                if(current_balance.bounds().isEmpty()|| interest_rate.bounds().isEmpty()){
//                    monthlyInterest.isEnabled();
//                }
//
//            }
//        });
//
//    }
//
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MonthlyForm {

    MonthlyForm() {
        // Create frame
        JFrame frame = new JFrame("Monthly Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLocationRelativeTo(null); // center on screen

        // Use GridLayout for neat alignment (3 rows of labels + textfields, then buttons)
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        // Labels
        JLabel labelcBalance = new JLabel("Current Balance");
        JLabel labeliRate = new JLabel("Interest Rate");
        JLabel labelmRate = new JLabel("Monthly interest Rate");

        // TextFields
        JTextField current_balance = new JTextField();
        JTextField interest_rate = new JTextField();
        JTextField monthlyInterest = new JTextField();
        monthlyInterest.setEnabled(false); // disabled at first

        // Buttons
        JButton calculate = new JButton("Calculate");
        JButton clear_button = new JButton("C");

        // Add components in order
        panel.add(labelcBalance);
        panel.add(current_balance);
        panel.add(labeliRate);
        panel.add(interest_rate);
        panel.add(labelmRate);
        panel.add(monthlyInterest);
        panel.add(calculate);
        panel.add(clear_button);

        frame.add(panel);

        // Calculate button logic
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double CurrentBalance = Double.parseDouble(current_balance.getText());
                    double annualInterestRate = Double.parseDouble(interest_rate.getText());

                    // Formula: (Balance * Rate) / 12
                    double MonthlyInterest = (CurrentBalance * annualInterestRate / 100) / 12;

                    // Round to nearest whole number
                    long roundedInterest = Math.round(MonthlyInterest);

                    monthlyInterest.setEnabled(true);
                    monthlyInterest.setText(String.valueOf(roundedInterest));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
                }
            }
        });

        // Clear button logic
        clear_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current_balance.setText("");
                interest_rate.setText("");
                monthlyInterest.setText("");
                monthlyInterest.setEnabled(false);
            }
        });

        frame.setVisible(true);
    }

}

