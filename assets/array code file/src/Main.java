import java.util.Scanner;
import java.util.ArrayList;

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

        // Getting an element at a specific index
        System.out.print("Enter index to get the value: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < numbers.size()) {
            System.out.println("Element at index " + index + ": " + numbers.get(index));
        } else {
            System.out.println("Invalid index!");
        }

        // Removing an element
        System.out.print("Enter number to remove: ");
        int numToRemove = scanner.nextInt();
        if (numbers.contains(numToRemove)) {
            numbers.remove(Integer.valueOf(numToRemove));
            System.out.println(numToRemove + " removed.");
        } else {
            System.out.println("Number not found in list.");
        }

        // Checking if the list contains a specific number
        System.out.print("Enter a number to check if it exists: ");
        int checkNum = scanner.nextInt();
        if (numbers.contains(checkNum)) {
            System.out.println(checkNum + " is in the list.");
        } else {
            System.out.println(checkNum + " is not in the list.");
        }

        // Displaying updated ArrayList
        System.out.println("Updated ArrayList: " + numbers);

        // Clearing the ArrayList
        numbers.clear();
        System.out.println("ArrayList cleared. Size: " + numbers.size());

        scanner.close();
    }
}
