////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        int max = 10;
//        int min = 1;
//        int range = max- min+1;
//
//        for(int i=0; i<10; i++){
//            int rand = (int)(Math.random() * range) + min;
//
//            System.out.println(rand);
//        }
//
//
//    }
//}

//import java.util.Random;
//
//public class Main {
//
//    public static void main (String[] args) {
//        // Convert the string to a character array
//        char[] chars = str.toCharArray();
//
//        // Create a Random object for shuffling
//        Random random = new Random();
//
//        // Perform Fisher-Yates shuffle
//        for (int i = chars.length - 1; i > 0; i--) {
//            int j = random.nextInt(i + 1); // Generate a random index between 0 and i (inclusive)
//
//            // Swap chars[i] and chars[j]
//            char temp = chars[i];
//            chars[i] = chars[j];
//            chars[j] = temp;
//        }
//
//        // Convert the character array back to a string
//        return new String(chars);
//    }
//
//    public static void main(String[] args) {
//        String originalString = "hello";
//        String scrambledString = scrambleString(originalString);
//        System.out.println("Original String: " + originalString);
//        System.out.println("Scrambled String: " + scrambledString);
//    }
//}

//Random number with length
//import java.util.Random;
//
//public class Main {
//    public static void main(String[] args) {
//        int length = 16; // Desired length of the number string
//        Random random = new Random();
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (int i = 0; i < length; i++) {
//            // Generate a random digit between 0 and 9 (inclusive)
//            int digit = random.nextInt(10);
//            stringBuilder.append(digit);
//        }
//
//        String randomNumberString = stringBuilder.toString();
//        System.out.println("Random Number String: " + randomNumberString);
//    }
//}

//String scrambler
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static String scrambleString(String str) {
        // Convert the string to a character array
        char[] chars = str.toCharArray();

        // Create a Random object for shuffling
        Random random = new Random();

        // Perform Fisher-Yates shuffle
        for (int i = chars.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // Generate a random index between 0 and i (inclusive)

            // Swap chars[i] and chars[j]
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        // Convert the character array back to a string
        return new String(chars);
    }

    public static void main(String[] args) {
        //String originalString = "hello";
        System.out.println("Enter some text:");
        Scanner scanner = new Scanner(System.in);
        String originalString = scanner.next();
        String scrambledString = scrambleString(originalString);
        System.out.println("Original String: " + originalString);
        System.out.println("Scrambled String: " + scrambledString);
    }
}