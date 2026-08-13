//import javax.swing.*;
//import javax.swing.border.Border;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//
//
//
//
//// We need to fix the exception handling NumberFormatException
//// Adjust the sizes to be not so big,tidy it up make it look nice
//
//        JFrame frame = new JFrame("NumberSorterApp");
//        frame.setVisible(true);
//        frame.setSize(500,500);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null); // center on screen
//
//        JPanel panel = new JPanel(new BorderLayout(10,10));
//
//        JLabel labelEnterNumber = new JLabel("Enter number:");
//        labelEnterNumber.setFocusable(false);
//
//        JTextField enter_number = new JTextField();
//
//        JLabel labelDisplayNumber = new JLabel();
//        labelDisplayNumber.setFocusable(false);
//
//        JTextArea textArea = new JTextArea();
//        textArea.setEditable(false);
//
//
//
//        JButton addNumber = new JButton("Add number");
//
//        ArrayList<Integer> numbers = new ArrayList<>();
//
//        addNumber.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                try{
//                    int num = Integer.parseInt(enter_number.getText());
//                    numbers.add(num);
//                    textArea.append("Added " + num + "\n");
//                    enter_number.setText("");
//                } catch (NumberFormatException ex) {
//                    textArea.append("Invalid input.Please enter a valid number");
//
//                }
//            }
//        });
//
//        JButton sort_and_display = new JButton("Sort and Display");
//        sort_and_display.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(numbers.isEmpty()){
//                    textArea.append("Insufficient amount of numbers");
//                    return;
//                }
//                Collections.sort(numbers);
//                textArea.append("Sorted Numbers: " + numbers + "\n");
//
//            }
//        });
//
//        panel.add(labelEnterNumber);
//        panel.add(enter_number);
//        panel.add(labelDisplayNumber);
//        panel.add(new JScrollPane(textArea));
//        panel.add(textArea);
//        panel.add(addNumber);
//        panel.add(sort_and_display);
//
//
//        frame.add(panel);
//
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("NumberSorterApp");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel(new BorderLayout(10, 10));


        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel labelEnterNumber = new JLabel("Enter number:");
        JTextField enter_number = new JTextField(10);
        inputPanel.add(labelEnterNumber);
        inputPanel.add(enter_number);


        JTextArea textArea = new JTextArea(10, 25);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);


        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addNumber = new JButton("Add Number");
        JButton sort_and_display = new JButton("Sort and Display");
        buttonPanel.add(addNumber);
        buttonPanel.add(sort_and_display);


        ArrayList<Integer> numbers = new ArrayList<>();


        addNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(enter_number.getText().trim());
                    numbers.add(num);
                    textArea.append("Added: " + num + "\n");
                    enter_number.setText("");
                } catch (NumberFormatException ex) {
                    textArea.append("Invalid input. Please enter a valid number.\n");
                }
            }
        });


        sort_and_display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numbers.isEmpty()) {
                    textArea.append("No numbers to display.\n");
                    return;
                }
                Collections.sort(numbers);
                textArea.append("Sorted Numbers: " + numbers + "\n");
            }
        });


        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}
