import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections; // Import Collections class

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Creating an ArrayList to store integers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Adding elements to the ArrayList
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers.add(scanner.nextInt());
        }

        // Displaying the ArrayList
        System.out.println("Numbers in the ArrayList: " + numbers);

        // Sorting the ArrayList using Collections.sort
        Collections.sort(numbers);
        System.out.println("Numbers in the ArrayList in order: " + numbers);

        scanner.close();
    }
}

