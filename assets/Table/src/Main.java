import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Example");
        String[] columns = {"Student Name:",
                            "Degree",
                            "Qualifications",
                            "Marks"};
        Object[][] tableData = {
                {"Sahil","Bsc","IT","75"},
                {"Shivaar","DIT","IT","100"},
                {"Kashi","DIT","IT","100"},
                {"Marsh","DIT","IT","100"},
                {"Riyaal","DIT","IT","99"},
                {"Keeran","DIT","IT","96"},
                {"Shaur","DIT","IT","89"},
        };
        JTable table = new JTable(tableData,columns);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setVisible(true);
    }
}