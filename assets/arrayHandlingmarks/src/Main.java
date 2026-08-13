import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int [] marks = new int[5];
        //System.out.println("Enter marks");

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Enter marks" + (i+1));
            marks[i] = input.nextInt();
            //System.out.println("The mark is = " + marks[i]);

        }
        for (int i = 0; i < marks.length; i++) {
            System.out.println("The mark is = " + marks[i]);
        }
        input.close();
    }
}