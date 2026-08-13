/*import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<String>names = new ArrayList<>();
        names.add("Shivaar");
        names.add("peter");

        System.out.println(names);

        Scanner input = new Scanner(System.in);
        int row,col;
        System.out.print("Please enter row number: ");
        row = input.nextInt();

        System.out.print("Please enter column number: ");
        col = input.nextInt();
        int grades [][] = new int[row][col];

        for(int i=0;i<2;i++){
            System.out.print("Please enter Student: " + ":" + (i+1));
            for(int j=0;j<2;j++){
                System.out.println("Enter grade" + (j+1));
                grades[i][j] = input.nextInt();
            }
        }
        for(int i = 0; i<2;i++){
            int sum = 0;
            for(int j=0;j<2;j++){
                sum+=grades[i][j];
                System.out.print("The marks for student: "+ (i+1) + ":" + grades[i][j]+ "\n");
            }
        }

    }
}*/

// Alternative code for the rows and columns to work better:
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Shivaar");
        names.add("peter");

        System.out.println(names);

        Scanner input = new Scanner(System.in);
        int row, col;
        System.out.print("Please enter row number: ");
        row = input.nextInt();

        System.out.print("Please enter column number: ");
        col = input.nextInt();
        int grades[][] = new int[row][col];

        // Iterate over the number of students (rows)
        for (int i = 0; i < row; i++) {
            System.out.print("Please enter Student " + (i + 1) + ": ");
            for (int j = 0; j < col; j++) {
                System.out.println("Enter grade " + (j + 1));
                grades[i][j] = input.nextInt();
            }
        }

        // Display the marks and calculate sum
        for (int i = 0; i < row; i++) {
            int sum = 0;
            System.out.println("Grades for Student " + (i + 1) + ": ");
            for (int j = 0; j < col; j++) {
                sum += grades[i][j];
                System.out.print("Grade " + (j + 1) + ": " + grades[i][j] + "\n");
            }
            System.out.println("Total marks for Student " + (i + 1) + ": " + sum);
        }
    }
}
