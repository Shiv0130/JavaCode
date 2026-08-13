import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseSelectionForm extends JFrame {
    JLabel labelName,labelCourse;
    JTextField nameField;
    JComboBox comboBox;
    JTextArea textArea;
    JButton button;


    CourseSelectionForm(){

        labelName = new JLabel("Student name");
        labelName.setBounds(10,10,100,20);

        nameField = new JTextField();
        nameField.setBounds(100,10,100,20);
        nameField.setEditable(true);


        String[] course = {"OPS","MIS","PRO"};

        comboBox = new JComboBox(course);
        labelCourse = new JLabel("Courses");
        labelCourse.setBounds(30,30,100,20);
        comboBox.setBounds(100,30,100,20);
        comboBox.setFocusable(false);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(100,50,200,50);

        button = new JButton("Submit");
        button.setBounds(100,100,100,20);
        button.setFocusable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button){
                    textArea.append(nameField.getText()+ "- ");
                    textArea.append(String.valueOf(comboBox.getSelectedItem()));
                    textArea.append("\n");
                }


            }
        });

        this.setVisible(true);
        textArea.setVisible(true);
        this.setTitle("Course Selection");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.add(labelName);
        this.add(nameField);
        this.add(labelCourse);
        this.add(comboBox);
        this.add(textArea);
        this.add(button);
        this.pack();
    }
}
