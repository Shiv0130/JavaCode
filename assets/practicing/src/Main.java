//import java.util.Scanner;
//
//public class Main { // make sure the M is uppercase.
//    public static void main(String[] args){
//        //MAD LIBS GAME
//        Scanner scanner = new Scanner(System.in);
//        String adjective1 ;
//        String noun1;
//        String adjective2;
//        String verb1;
//        String adjective3;
//
//        System.out.println("Enter an adjective:");
//        adjective1 = scanner.nextLine();
//        System.out.println("Enter a noun");
//        noun1 = scanner.nextLine();
//        System.out.println("Enter an adjective:");
//        adjective2 = scanner.nextLine();
//        System.out.println("Enter a verb ending with -ing");
//        verb1 = scanner.nextLine();
//        System.out.println("Enter an adjective");
//        adjective3 = scanner.nextLine();
//
//        System.out.println("\nToday I went to a" + adjective1 + "zoo");
//        System.out.println("In an exhibit, I saw a " + noun1 + ".");
//        System.out.println(noun1 + "was" + adjective2 + "and" + verb1 + "!");
//        System.out.println("I was" + adjective3 + "!");
//
//        scanner.close();
//
//    }
//
//}

//public class Main{
//    public static void main(String[] args){
//
//        //Arithmetic Operators
//
//        //int x = 10;
//        //int y =2;
//        //int z;
//
//        //z = x+y;
//        //z = x-y;
//        //z = x*y;
//        //z = x%y;
//
//        //System.out.println(z);
//        // Augmented Assignment Operators
//
//        //int x =10;
//        //int y =3;
//
//        // x = x + y;
//        // x+=y;
//        // x=x-y;
//        // x-=y;
//        //x = x * y;
//        //x+=y;
//        //x = x / y;
//        //x/=y;
//        //x = x % y;
//        //x% = y;
//
//        //System.out.println(x);
//
//        //int x = 1;
//        //x++;
//        //x++;
//        //x++;
//        //x--;
//        //x--;
//        //x--;
//
//        // ORDER OF OPERARTIONS [P-E-M-D-A-S]// parenthesis exponents multiplication addition and subtraction
//
//        double result = 3 + 4 * (7 - 5) / 2.0;
//
//        System.out.println(result);
//
//
//
//    }
//
//}

// My Calculator program
//import java.util.Scanner;
//public class Main{//b1
//    public static void main(String[] args){//b2
//
//        Scanner  scanner = new Scanner(System.in);
//        System.out.println("Enter num1:");
//        double num1 = scanner.nextDouble();
//        System.out.println("Enter num2:");
//        double num2 = scanner.nextDouble();
//        System.out.println("Enter an operator(+,-,*,/ ,^):");
//        char operator = scanner.next().charAt(0);
//        double result = 0;
//        boolean validOperation = true;
//
//        switch(operator){//sb1
//            case '+' -> result = num1 + num2;
//            case '-' -> result = num1 - num2;
//            case '*' -> result = num1 * num2;
//            case '/' -> result = num1 / num2;
//            if(num2 == 0){//if
//                 System.out.println("Cannot divide by 0");
//                validOperation = false;
//            }//endif
//            else{
//                result = num1 / num2;
//            }
//            case '^' -> result = Math.pow(num1,num2);
//            default -> System.out.print("Invalid operation");
//            validOperation = false;
//
//        }//endsb2
//        System.out.print(result);
//        scanner.close();
//
//    }//endb2
//
//}//endb1

//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//
//        Scanner input = new Scanner(System.in);
//        int choice;
//        double bal = 0;
//        int dep = 0;
//        double withdrawal = 0;
//
//        do {
//            System.out.println("Welcome to Cash bank");
//            System.out.println("Choose an option frm menu");
//            System.out.println("1. Check account balance");
//            System.out.println("2. Deposit funds");
//            System.out.println("3. Withdraw funds");
//            System.out.println("4. Exit");
//
//            choice = input.nextInt();
//
//            switch(choice){
//                case 1: System.out.println("The balance of the account is" + ":" + bal);
//                    break;
//                case 2: System.out.println("Enter amount to deposit" + ":" + dep);
//                    dep = input.nextInt();
//                    bal += dep;
//                    break;
//                case 3: System.out.println("Enter amount you wish to withdraw" + ":" + withdrawal);
//                    withdrawal = input.nextDouble();
//                    if(bal<withdrawal){
//                        System.out.println("Insufficient funds");
//                    }
//                    else{
//                        bal = bal - withdrawal;
//                        System.out.println("Account balance after withdrawal is:" + ":" + bal);
//                    }
//                    break;
//            }
//
//
//
//        } while (choice != 4);
//        input.close();
//
//    }
//}

//Corrected calculator program
//Calculator program
//import java.util.Scanner;
//
//public class Main { //b1
//    public static void main(String[] args) { //b2
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter num1:");
//        double num1 = scanner.nextDouble();
//        System.out.println("Enter num2:");
//        double num2 = scanner.nextDouble();
//        System.out.println("Enter an operator (+, -, *, /, ^):");
//        char operator = scanner.next().charAt(0);
//
//        double result = 0;
//        boolean validOperation = true;
//
//        switch (operator) { //sb1
//            case '+' -> result = num1 + num2;
//            case '-' -> result = num1 - num2;
//            case '*' -> result = num1 * num2;
//            case '/' -> { //db1
//                if (num2 == 0) { //if
//                    System.out.println("Cannot divide by 0");
//                    validOperation = false;
//                } //endif
//                else { //else
//                    result = num1 / num2;
//                } //endelse
//            } //enddb1
//            case '^' -> result = Math.pow(num1, num2);
//            default -> { //def
//                System.out.println("Invalid operation");
//                validOperation = false;
//            } //enddef
//        } //endsb1
//
//        if (validOperation) { //if2
//            System.out.println("Result: " + result);
//        } //endif2
//
//        scanner.close();
//
//    } //endb2
//} //endb1

//my code from Notepad
// import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        // if statemnt = performs a block of code if its condition is true
//
//        //int age = 25;
//        //int age = 18;
//        //int age = 19;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your age:"); // always add this so we know what to input
//
//        int age = scanner.nextInt();
//        System.out.println("Enter your name:");
//        string name = scanner.nextLine();// make sure string data type has a capital S
//        System.out.println("Are you a student(true/false)?");
//        boolean isStudent = scanner.nextBoolean();
//
//
//        //GROUP 1
//        if (name.isEmpty()) { // alternatively you can check by name= "";
//            //must add parenthesis fot the functions such as isEmpty() }
//
//            //GROUP 2
//
//            if (age >= 65) {
//                System.out.println("You are a senior citezen");
//            } else if (age >= 18) {
//                System.out.println("You are an adult");
//            } else if (age < 0) {
//                System.out.println("You are undefined");
//            } else if (age == 0) {
//                System.out.println("");
//            } else {
//                System.out.println("Still small mahn");
//            }
//
//            //GROUP 3
//
//            if (isStudent) { // automatically assigns it as isStudent==true
//                System.out.println("You are a student");
//
//            } else {
//                System.out.println("Who you?");
//            }
//
//            scanner.close();
//
//        }
//    }

//Correct code from Java
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        // if statement = performs a block of code if its condition is true
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your age:"); // always add this so we know what to input
//
//        int age = scanner.nextInt();
//        scanner.nextLine(); // Add this to consume the newline character left by nextInt()
//
//        System.out.println("Enter your name:");
//        String name = scanner.nextLine(); // String with capital S
//
//        System.out.println("Are you a student(true/false)?");
//        boolean isStudent = scanner.nextBoolean();
//
//        //GROUP 1
//        if (name.isEmpty()) { // alternatively you can check by name= "";
//            //must add parenthesis for the functions such as isEmpty()
//            System.out.println("You didn't enter a name");
//        } // Closing brace was missing here
//
//        //GROUP 2
//        if (age >= 65) {
//            System.out.println("You are a senior citizen");
//        } else if (age >= 18) {
//            System.out.println("You are an adult");
//        } else if (age < 0) {
//            System.out.println("You are undefined");
//        } else if (age == 0) {
//            System.out.println("");
//        } else {
//            System.out.println("Still small mahn");
//        }
//
//        //GROUP 3
//        if (isStudent) { // automatically assigns it as isStudent==true
//            System.out.println("You are a student");
//        } else {
//            System.out.println("Who you?");
//        }
//
//        scanner.close();
//    }
//}

//public class Main{
//   public static void main(String ){
//      if(){
//         if(){
//        }
//        else if(){

//          }
//         else{

//           }
//      }
//   }
//}

//public class Main{
//    public static void main(String[] args){
//        boolean isStudent = true;
//        boolean isSenior = true;
//        double price = 9.99;
//
//        if(isStudent){
//            if(isSenior){
//                System.out.println("You get a discount of 20%");
//                System.out.println("You get a discount of 10%");
//                price *= 0.7;
//            }
//            System.out.println("You get a student discount of 10%");
//            price*= 0.9;// 100%-10% = 90% 0.9 is from 90/100
//
//        }
//        else{
//            if(isSenior){
//                System.out.println("You get a senior discount of 20%");
//            }
//            price*= 1;
//        }
//
//        //System.out.print("The price of a ticket is: R%.2f" + price);// almost correct but the format of rounding to tow dcimal places is:
//        System.out.printf("The price of a ticket is: R%.2f , price");
//
//
//
//    }
//}

//import java.util.Scanner;
//
//public class Main {//b1
//    public static void main(String[] args){//b2
//        //SHOPPING CART PROGRAM
//
//
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("What item would you like to buy?:");
//        String item = scanner.nextLine();
//        System.out.print("What is the price for each?:");
//        double price = scanner.nextDouble();
//        System.out.print("How many would you like?:");
//        int quantity = scanner.nextInt();
//        char currency = 'R';
//        double total = price * quantity;
//
//
//        //System.out.println(item);//for testing purpose
//        //System.out.println(price); //for testing purpose
//        //System.out.println(quantity);// for testing purpose
//        //System.out.println(total); //for testing purpose
//        System.out.println("\nYou habe bought" + quantity + " " + item + "/s");
//        System.out.println("Your total is" + currency+total);
//
//
//        scanner.close();
//    }//endb2
//}//endb1

// Want a switch?
//import java.util.Scanner;
//public class Main {//b1
//    public static void main(String[] args){//b2
//
//        //pre code
//
////        String day = "Sunday";
////        if(day.equals("Monday")){//ifb1
////            System.out.println("It is a weekday");
////        }//endifb1
////        else if(day.equals("Tuesday")){//ifb2
////            System.out.println("It is a weekday");
////        }//endifb2
////
////        else if(day.equals("Wednesday")){//ifb3
////            System.out.println("It is a weekday");
////        }//endifb3
////
////        else if(day.equals("Thursday")){//ifb4
////            System.out.println("It is a weekday");
////        }//endifb4
////
////        else if(day.equals("Friday")){//ifb5
////            System.out.println("It is a weekday");
////        }//endifb5
////
////        else if(day.equals("Saturday")){//ifb6
////            System.out.println("It is a weekend");
////        }//endifb6
////
////        else if(day.equals("Sunday")){//ifb7
////            System.out.println("It is a weekend");
////        }//endifb7
//
//        //Enhanced switch = A replacement to many else if statements
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a day of the week:");
//        String day = scanner.nextLine();
//
//        switch(day) {//sb1
//            case "Monday" -> System.out.println("It is a weekday"); // The '->' means do something operator
//            case "Tuesday" -> System.out.println("It is a weekday");
//            case "Wednesday" -> System.out.println("It is a weekday");
//            case "Thursday" -> System.out.println("It is a weekday");
//            case "Friday" -> System.out.println("It is a weekday");
//            case "Saturday" -> System.out.println("It is a weekend");
//            case "Sunday" -> System.out.println("It is a weekend");
//            default -> System.out.println(day + "is not a day");
//
//        }//endsb1
//        scanner.close();
//
//    }//b2
//}//b1



//public class Main {//b1
//    public static void main(String[] args){//b2
//        //method = a block of resuable code that is executed when called ()
//
//        String name = "Ganpath";
//        int age = 75;
//
////        System.out.println("Happy Birthday to you!");
////        System.out.println("Happy Birthday dear you!");
////        System.out.println("You are x years old!");
////        System.out.println("Happy Birthday to you!\n");
//
//        //call method
//        happyBirthday(name,age);
//
//    }//endb2
//    //Create method within main method remember to use printf
//    static void happyBirthday(String name, int age){//Func
//        System.out.println("Happy Birthday to you!");
//        System.out.println("Happy Birthday dear " + name);
//        System.out.println("You are " + age + " years old!");
//        System.out.println("Happy Birthday to you!\n");
//    }//endFunc
//
//}//endb1

//public class Main{//b1
//    public static void main(String[] args){//b2
//        double result = square(3);
//        System.out.println(result);
//    }//endb2
//    static double square(double number){//Funcb
//        return number*number;
//
//    }//endFuncb
//}//endb1

//public class Main {//b1
//    public static void main(String[] args) {//b2
//        // Overloaded methods = methods that share the same name,
//        //                      but different parameters
//        //                      signature = name + parameters
//
//        System.out.println(add(1, 2));
//        System.out.println(add(1, 2, 3));
//        System.out.println(add(1, 2, 3,4));
//    }//endb2
//
//    static double add(double a, double b) {//funcb
//        return a + b;
//    }//endfuncb
//
//    static double add(double a, double b, double c) {//funcb
//        return a + b + c;
//    }//endfuncb
//
//
//    static double add(double a,double b,double c,double d){//funcb
//        return a + b + c + d;
//    }//endfuncb
//
//}//endb1




//import java.util.Scanner;
//
//public class Main { //b1
//    public static void main(String[] args) { //b2
//
//        // Example 1: Simple name input with while loop
//        Scanner scanner = new Scanner(System.in);
//        String name = "";
//
//        if (name.isEmpty()) { //ifb1
//            System.out.print("Enter your name: ");
//            name = scanner.nextLine();
//        } //endifb1
//
//        System.out.println("Hello " + name);
//
//        while (name.isEmpty()) { //whileb
//            System.out.print("Enter your name: ");
//            name = scanner.nextLine();
//        } //endwhileb
//
//        System.out.println("Hello " + name);
//
//        // Example 2: While loop with exit condition
//        String response = " ";
//        while (!response.equals("Q")) { //whileb
//            System.out.println("You are playing a game:");
//            System.out.println("Press Q to quit:");
//            response = scanner.next().toUpperCase();
//        } //endwhileb
//        System.out.println("You have quit the game");
//
//        // Example 3: While loop for positive age
//        int age = 0;
//        System.out.print("Enter your age: ");
//        age = scanner.nextInt();
//
//        while (age < 0) { //whileb
//            System.out.println("Your age can't be -ve");
//            System.out.println("Enter your age: ");
//            age = scanner.nextInt();
//        } //endwhileb
//        System.out.println("You are " + age + " years old");
//
//        // Example 4: do-while loop for age
//        do { //dowhileb
//            System.out.println("Your age can't be -ve");
//            System.out.print("Enter your age: ");
//            age = scanner.nextInt();
//        } while (age < 0); //enddowhileb
//
//        System.out.println("You are " + age + " years old");
//
//        // Example 5: while loop with range check
//        int number = 0;
//        while (number < 1 || number > 10) { //whileb
//            System.out.print("Enter a number between 1-10: ");
//            number = scanner.nextInt();
//        } //endwhileb
//        System.out.println("You picked " + number);
//
//        // Example 6: do-while loop with range check
//        do { //dowhileb
//            System.out.print("Enter a number between 1-10: ");
//            number = scanner.nextInt();
//        } while (number < 1 || number > 10); //enddowhileb
//
//        System.out.println("You picked " + number);
//
//        // Example 7: Basic for loop
//        for (int i = 0; i < 10; i++) { //forbloop
//            System.out.println("pizza");
//        } //endforbloop
//
//        // Example 8: For loop increment
//        for (int i = 0; i < 10; i++) { //forbloop
//            System.out.println(i);
//        } //endforbloop
//
//        // Example 9: Increment by 2
//        for (int i = 0; i < 10; i += 2) { //forbloop
//            System.out.println(i);
//        } //endforbloop
//
//        // Example 10: Decrement loop
//        for (int i = 10; i > 0; i--) { //forloopb1
//            System.out.println(i);
//        } //endforloopb1
//
//        // Example 11: Decrement by 2
//        for (int i = 10; i > 0; i -= 2) { //forloopb1
//            System.out.println(i);
//        } //endforloopb1
//
//        // Example 12: User-defined number of loops
//        System.out.print("Enter how many times you want to loop: ");
//        int max = scanner.nextInt();
//        for (int i = 0; i < max; i++) { //forloopb
//            System.out.println(i);
//        } //endforloopb
//
//        // Example 13: Countdown from user number
//        System.out.print("Enter a number to countdown from: ");
//        int start = scanner.nextInt();
//        for (int i = start; i > 0; i--) { //forloopb
//            System.out.println(i);
//        } //endforloopb
//
//        // Example 14: Nested loop - Matrix numbers
//        for (int i = 0; i < 3; i++) { //forloop2
//            for (int j = 0; j <= 9; j++) { //forloop1
//                System.out.print(j + " ");
//            } //endforloop1
//            System.out.println(); // second blank output for space
//        } //endforloop2
//
//        // Example 15: Create a matrix of symbols
//        System.out.print("Enter the # of rows: ");
//        int rows = scanner.nextInt();
//        System.out.print("Enter the # of cols: ");
//        int cols = scanner.nextInt();
//        System.out.print("Enter Symbol: ");
//        char symbol = scanner.next().charAt(0);
//
//        for (int r = 0; r < rows; r++) { //forloopb1
//            for (int c = 0; c < cols; c++) { //forloop2
//                System.out.print(symbol + " ");
//            } //endforloop2
//            System.out.println(); // new line after each row
//        } //endforloopb1
//
//        scanner.close();
//    } //endb2
//} //endb1





//import java.util.ArrayList;
//import java.util.Collections;
//public class Main{//b1
//    public static void main(String[] args){//b2
//        ArrayList<String> fruits = new ArrayList<>();
//        fruits.add("Apple");
//        fruits.add("Orange");
//        fruits.add("Banana");
//        fruits.add("Coconut");
//
//        //remove method
//        //fruis.remove(1);
//
//        //set method
//        //fruits.set(1,"Pineapple");
//
//        //System.out.println(fruits);
//        //gets element at specific index
//        //System.out.println(fruits.get(0));
//        //returns size of the array
//        System.out.println(fruits.size());
//        // To sort in an array list call the sort function after importing collections class
//        Collections.sort(fruits); // sorts in alphabetical order
//        //System.out.println(fruits);
//
//        //Use enhanced for loop:
//        for(String fruit: fruits){//forloopb
//            System.out.println(fruits);
//        }//endforloopb
//    }//endb2
//}//endb1

// Alternative code for the rows and columns to work better: 2d arrays
//import java.util.Scanner;
//import java.util.ArrayList;
//
//public class Main {
//    public static void main(String[] args) {
//        ArrayList<String> names = new ArrayList<>();
//        names.add("Shivaar");
//        names.add("peter");
//
//        System.out.println(names);
//
//        Scanner input = new Scanner(System.in);
//        int row, col;
//        System.out.print("Please enter row number: ");
//        row = input.nextInt();
//
//        System.out.print("Please enter column number: ");
//        col = input.nextInt();
//        int grades[][] = new int[row][col];
//
//        // Iterate over the number of students (rows)
//        for (int i = 0; i < row; i++) {
//            System.out.print("Please enter Student " + (i + 1) + ": ");
//            for (int j = 0; j < col; j++) {
//                System.out.println("Enter grade " + (j + 1));
//                grades[i][j] = input.nextInt();
//            }
//        }
//
//        // Display the marks and calculate sum
//        for (int i = 0; i < row; i++) {
//            int sum = 0;
//            System.out.println("Grades for Student " + (i + 1) + ": ");
//            for (int j = 0; j < col; j++) {
//                sum += grades[i][j];
//                System.out.print("Grade " + (j + 1) + ": " + grades[i][j] + "\n");
//            }
//            System.out.println("Total marks for Student " + (i + 1) + ": " + sum);
//        }
//    }
//}

//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections; // Import Collections class
//
//public class Main {
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        // Creating an ArrayList to store integers
//        ArrayList<Integer> numbers = new ArrayList<>();
//
//        // Adding elements to the ArrayList
//        System.out.println("Enter 5 numbers:");
//        for (int i = 0; i < 5; i++) {
//            System.out.print("Number " + (i + 1) + ": ");
//            numbers.add(scanner.nextInt());
//        }
//
//        // Displaying the ArrayList
//        System.out.println("Numbers in the ArrayList: " + numbers);
//
//        // Sorting the ArrayList using Collections.sort
//        Collections.sort(numbers);
//        System.out.println("Numbers in the ArrayList in order: " + numbers);
//
//        scanner.close();
//    }
//}

//Encapsulation = The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. To achieve this, you must:
//
//declare class variables/attributes as private
//provide public get and set methods to access and update the value of a private variable
// class Person {
//    private String name; // private = restricted access
//
//    // Getter
//    public String getName() {
//        return name;
//    }
//
//    // Setter
//    public void setName(String newName) {
//        this.name = newName;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Person myObj = new Person();
//        myObj.setName("John"); // Set the value of the name variable to "John"
//        System.out.println(myObj.getName());
//    }
//}
//
//// Outputs "John"


// class Car {//classb
//
//    String make = "Ford";
//    String model = "Mustang";
//    int year = 2025;
//    double price = 58000.99;
//    boolean isRunning = false;
//
//    void start(){//methodb
//        System.out.println("You start the engine");
//
//    }//endmethodb
//
//    void stop(){//methodb
//        System.out.println("You stopped the engine");
//    }//endmethodb
//
//
//    void drive(){//methodb
//        System.out.println("You are driving" + model);
//    }//endmethodb
//
//
//    void brake(){//methodb
//        System.out.println("You brake the " + model);
//    }//endmethodb
//
//}//endclassb
//
//public class Main{//b1
//    public static void main(String[] args){//b2
//        //Object = An entity that holds data (attributes)
//        //         and can perform actions (methods)
//        //         It is a reference data type
//
////      Scanner scanner = new Scanner(System.in);
////      Random random = new Random();
//
//        Car car1 = new Car();
//        Car car2 = new Car();
//
//        System.out.println(car1.make + " " + car1.model);
//        System.out.println(car2.make + " " + car2.model);
//
//        // car.isRunning = true;
//
//        //System.out.println(car);// will return a reference
//        //System.out.println(car.make);
//        //System.out.println(car.model);
//        //System.out.println(car.year);
//        //System.out.println(car.price);
//        //System.out.println(car.isRunning);
//
//        //System.out.println(car.isRunning);
//        //car.start();
//        //System.out.println(car.isRunning);
//        //car.stop();
//        //System.out.println(car.isRunning);
//
//        //car.drive();
//        //car.brake();
//
//
//
//
//    }//endb2
//}//endb1

//class Student{//classb
//
//    String name;
//    int age;
//    double gpa;
//    boolean isEnrolled;
//
//    Student(String name, int age, double gpa){//constb
//        this.name = name;  //this refers to the object you currently work with
//        this.age = age;
//        this.gpa = gpa;
//        this.isEnrolled = true;
//    }//endconstb
//
//    void study(){//methodb
//        System.out.println(this.name + " is studying ");
//    }//endmethodb
//
//}//endclassb
//
//public class Main {//b1
//    public static void main(String[] args){//b2
//        // Constructor =  a special method to intialize objects
//        // You can pass arguments to a constructor
//        // and set up intial values
//
//        Student student1 = new Student("Spongebob",30,3.2);
//        Student student2 = new Student("Patrick",34,1.5);
//        Student student3 = new Student("Sandy",27,4.0);
//


////        System.out.println(student1.name);
////        System.out.println(student1.age);
////        System.out.println(student1.gpa);
////        System.out.println(student1.isEnrolled);
////
////        System.out.println(student2.name);
////        System.out.println(student2.age);
////        System.out.println(student2.gpa);
////        System.out.println(student2.isEnrolled);
////
////
////        System.out.println(student3.name);
////        System.out.println(student3.age);
////        System.out.println(student3.gpa);
////        System.out.println(student3.isEnrolled);
//
//        student1.study();
//        student2.study();
//        student3.study();
//
//    }//endb2
//}//endb1


//class User {//classb
//    String username;
//    String email;
//    int age;
//
//    User(){//constructor0
//        this.username = "Guest";
//        this.email = "Not provided";
//        this.age = 0;
//    }//endconstructor0
//
//    User(String username){//constructor1b
//        this.username = username;
//        this.email = "Not provided";
//        this.age = 0;
//    }//endconstructor1b
//
//
//    User(String username,String email){//constructor2b
//        this.username = username;
//        this.email = email;
//        this.age = 0;
//    }//endconstructor2b
//
//
//    User(String username,String email,int age){//constructor2b
//        this.username = username;
//        this.email = email;
//        this.age = age;
//    }//endconstructor2b
//
//}//endclassb
//
//public class Main{//b1
//    public static void main(String[] args){//b2
//
//        //Overloaded constructors = Allows a class to have multiple constructors
//        //                          with different parameters lists.
//        //                           Enable objects to be instantiated in various ways.
//
//        User user1 = new User("Spongebob");
//        User user2 = new User("Patrick","PStar@aol.com");
//        User user3 = new User("Sandy","SCheeks@gmail.com",27);
//        User user4 = new User();
//
//
//        System.out.println(user1.username);
//        System.out.println(user1.email);
//        System.out.println(user1.age);
//
//        System.out.println(user2.username);
//        System.out.println(user2.email);
//        System.out.println(user2.age);
//
//        System.out.println(user3.username);
//        System.out.println(user3.email);
//        System.out.println(user3.age);
//
//        System.out.println(user4.username);
//        System.out.println(user4.email);
//        System.out.println(user4.age);
//
//    }//endb2
//}//endb1



//// Base class for all vehicles
//class Vehicles {
//    // Protected variables accessible to subclasses
//    protected String brand;
//    protected int year;
//
//    // Constructor to initialize base vehicle properties
//    Vehicles(String brand, int year) {
//        this.brand = brand;
//        this.year = year;
//    }
//
//    // Base method that can be overridden by subclasses
//    public void startEngine() {
//        System.out.println("Starting Vehicle Engine");
//    }
//
//    // Base display method that can be overridden by subclasses
//    public void display() {
//        System.out.println("The Brand: " + brand + " The year manufactured: " + year);
//    }
//}
//
//// Single level inheritance - Cars extends Vehicles
//class Cars extends Vehicles {
//    // Additional property specific to Cars
//    protected int numdoors;
//
//    // Constructor that calls the parent constructor using super()
//    Cars(String brand, int year, int numdoors) {
//        super(brand, year);  // Call to parent constructor
//        this.numdoors = numdoors;
//    }
//
//    // Method override - specialized implementation for Cars
//    @Override
//    public void startEngine() {
//        System.out.println("Starting Engine for Cars");
//    }
//
//    // Method override - includes numdoors in display
//    @Override
//    public void display() {
//        System.out.println("The Brand: " + brand + " The year manufactured: " + year + " Number of doors: " + numdoors);
//    }
//}
//
//// Multi-level inheritance - ElectricVehicles extends Cars (which extends Vehicles)
//class ElectricVehicles extends Cars {
//    // Additional property specific to ElectricVehicles
//    private int carrbatter;
//
//    // Constructor that calls the parent (Cars) constructor
//    ElectricVehicles(String brand, int year, int numdoors, int carrbatter) {
//        super(brand, year, numdoors);  // Call to Cars constructor
//        this.carrbatter = carrbatter;
//    }
//
//    // Method override - specialized implementation for electric vehicles
//    @Override
//    public void startEngine() {
//        System.out.println("Starting Engine for Electric Vehicle");
//    }
//
//    // Method override - includes all properties from the inheritance chain
//    @Override
//    public void display() {
//        System.out.println("The Brand: " + brand + " The year manufactured: " + year +
//                " Number of doors: " + numdoors + " Charging batt: " + carrbatter + " KWH");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        // Create instances of each vehicle type
//        Vehicles v = new Vehicles("VW Polo", 2005);
//        Cars c = new Cars("VW Polo Sedan", 2019, 4);
//        ElectricVehicles ev = new ElectricVehicles("VW Electric", 2025, 2, 1);
//
//        // Store all vehicle types in an array of the base type (polymorphism)
//        Vehicles[] vehicles = {v, c, ev};
//
//        // Loop through each vehicle and call its methods
//        // Demonstrates polymorphism - the correct overridden method is called based on actual object type
//        for(Vehicles vehicle : vehicles) {
//            System.out.println("Car Information For VW Industries\n");
//            vehicle.display();  // Will call the appropriate display() method for each object type
//            vehicle.startEngine();  // Will call the appropriate startEngine() method for each object type
//        }
//    }
//}

// With constructors
// Base class for all animals
//class Animal {
//    // Protected fields
//    protected String name;
//
//    // Constructor
//    Animal(String name) {
//        this.name = name;
//    }
//
//    // Default constructor
//    Animal() {
//        this.name = "Unknown";
//    }
//
//    // Base methods with default implementations
//    public void speak() {
//        System.out.println(this.name + " speaks");
//    }
//
//    public void move() {
//        System.out.println(this.name + " moves forward");
//    }
//}
//
//// Flying class for objects that can fly
//class Flying {
//    protected String flightType;
//
//    // Constructor
//    Flying(String flightType) {
//        this.flightType = flightType;
//    }
//
//    // Default constructor
//    Flying() {
//        this.flightType = "standard";
//    }
//
//    // Method for flying
//    public void fly() {
//        System.out.println("This object flies with " + flightType + " flight");
//    }
//}
//
//// Goose class that extends Animal and has flying capability
//class Goose extends Animal {
//    // Additional properties specific to Goose
//    private double wingSpan;
//    private String flightType;
//
//    // Constructor
//    Goose(String name, double wingSpan, String flightType) {
//        super(name); // Call to parent constructor
//        this.wingSpan = wingSpan;
//        this.flightType = flightType;
//    }
//
//    // Default constructor
//    Goose() {
//        super();
//        this.wingSpan = 100.0;
//        this.flightType = "flapping";
//    }
//
//    // Override speak method to customize output for Goose
//    @Override
//    public void speak() {
//        System.out.println(name + " honks");
//    }
//
//    // Override move method to customize output for Goose
//    @Override
//    public void move() {
//        System.out.println(name + " waddles forward");
//    }
//
//    // Fly method for Goose
//    public void fly() {
//        System.out.println(name + " flies with a wingspan of " + wingSpan + " cm using " + flightType + " flight");
//    }
//}
//
//// Lynx class that extends Animal
//class Lynx extends Animal {
//    // Additional properties specific to Lynx
//    private int speed;
//
//    // Constructor
//    Lynx(String name, int speed) {
//        super(name); // Call to parent constructor
//        this.speed = speed;
//    }
//
//    // Default constructor
//    Lynx() {
//        super();
//        this.speed = 50;
//    }
//
//    // Override speak method to customize output for Lynx
//    @Override
//    public void speak() {
//        System.out.println(name + " growls");
//    }
//
//    // Override move method to customize output for Lynx
//    @Override
//    public void move() {
//        System.out.println(name + " moves forward at " + speed + " km/h");
//    }
//}

//// Airplane class that extends Flying
//class Airplane extends Flying {
//    // Properties
//    private String model;
//    private int maxAltitude;
//
//    // Constructor
//    Airplane(String model, int maxAltitude, String flightType) {
//        super(flightType); // Call to parent constructor
//        this.model = model;
//        this.maxAltitude = maxAltitude;
//    }
//
//    // Default constructor
//    Airplane() {
//        super();
//        this.model = "Generic";
//        this.maxAltitude = 30000;
//    }
//
//    // Override fly method to customize output for Airplane
//    @Override
//    public void fly() {
//        System.out.println("The " + model + " flies up to " + maxAltitude + " feet with " + flightType + " flight");
//    }
//}
//
//// Main class to demonstrate the functionality
//public class Main {
//    public static void main(String[] args) {
//        // Create instances with constructors
//        Animal animal = new Animal("Generic Animal");
//        Goose goose = new Goose("Canadian Goose", 150.5, "flapping");
//        Lynx lynx = new Lynx("Eurasian Lynx", 70);
//        Airplane airplane = new Airplane("Boeing 747", 35000, "jet");
//
//        // Also create some with default constructors
//        Goose wildGoose = new Goose();
//        Airplane smallPlane = new Airplane();
//
//        // Test Animal behaviors
//        System.out.println("--- Animal Behaviors ---");
//        animal.speak();
//        animal.move();
//        goose.speak();
//        goose.move();
//        lynx.speak();
//        lynx.move();
//
//        // Test Flying behaviors
//        System.out.println("\n--- Flying Behaviors ---");
//        goose.fly();
//        wildGoose.fly();
//        airplane.fly();
//        smallPlane.fly();
//    }
//}

// class BankAccount {
//
//    private String accountHolderName;  // Name of the account holder
//
//    private final String accountNumber; // Unique account number (unchangeable)
//
//    private double balance;             // Current balance
//
//
//
//    // Constructor using 'this' keyword to assign values
//
//    public BankAccount(String accountHolderName, String accountNumber, double balance) {
//
//        this.accountHolderName = accountHolderName;
//
//        this.accountNumber = accountNumber;
//
//        this.balance = balance;
//
//    }
//
//
//
//    // Method to deposit amount to account
//
//    public void deposit(double amount) {
//
//        if (amount > 0) {
//
//            this.balance += amount;  // Add amount to balance
//
//            System.out.println("Deposited: R" + amount);
//
//        } else {
//
//            System.out.println("Invalid deposit amount.");
//
//        }
//
//    }
//
//
//
//    // Method to withdraw amount from account
//
//    public void withdraw(double amount) {
//
//        if (amount > 0 && amount <= this.balance) {
//
//            this.balance -= amount;  // Deduct amount from balance
//
//            System.out.println("Withdrawn: R" + amount);
//
//        } else {
//
//            System.out.println("Insufficient balance or invalid amount.");
//
//        }
//
//    }
//
//
//
//    // Method to display account details
//
//    public void displayDetails() {
//
//        System.out.println("Account Holder: " + this.accountHolderName);
//
//        System.out.println("Account Number: " + this.accountNumber);
//
//        System.out.println("Current Balance: R" + this.balance);
//
//    }
//
//
//
//    // Main method to test the class
//
//    public static void main(String[] args) {
//
//        // Creating a bank account object
//
//        BankAccount acc = new BankAccount("Shivaar Sewnarain", "AC123456", 1500.00);
//
//
//
//        acc.displayDetails();           // Display details
//
//        acc.deposit(500);              // Deposit money
//
//        acc.withdraw(300);             // Withdraw money
//
//        acc.withdraw(2000);            // Attempt to withdraw more than balance
//
//        acc.displayDetails();          // Final account state
//
//    }
//
//}

//Abstraction = Data abstraction is the process of hiding certain details and showing only essential information to the user.
//Abstraction can be achieved with either abstract classes or interfaces (which you will learn more about in the next chapter).
//
//The abstract keyword is a non-access modifier, used for classes and methods:
//
//Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).
//
//Abstract method: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).

//An abstract class can have both abstract and regular methods:
// Abstract class
//abstract class Animal {
//    // Abstract method (does not have a body)
//    public abstract void animalSound();
//    // Regular method
//    public void sleep() {
//        System.out.println("Zzz");
//    }
//}
//
//// Subclass (inherit from Animal)
//class Pig extends Animal {
//    public void animalSound() {
//        // The body of animalSound() is provided here
//        System.out.println("The pig says: wee wee");
//    }
//}
//
//class Main {
//    public static void main(String[] args) {
//        Pig myPig = new Pig(); // Create a Pig object
//        myPig.animalSound();
//        myPig.sleep();
//    }
//}

//import java.util.InputMismatchException;
//import java.util.Scanner;
//public class Main{
//    public  static void main(String[] args){
//        //Exception = An event that interrupts the normal flow of a program
//        //            (Dividing by zero,file not found,mismatch input type)
//        //            Surround any dangerous code with a try{} block
//        //            try{}, catch{}, finally{}
//
//        Scanner scanner = new Scanner(System.in);
//        try {//tryb
//            //System.out.println(1/0);
//            System.out.print("Enter a number");
//            int number = scanner.nextInt();
//            System.out.println(number);
//        } //endtryb
//        catch(InputMismatchException e){ //catch1b
//            System.out.println("That wasn't a number");
//        }//endcatch1b
//        catch(ArithmeticException e){//catch2b
//            System.out.println("YOU CAN'T DIVIDE BY 0!");
//        }//endcatch2b
//
//        catch(Exception e){//catch3b
//            //SAFETY NET
//            System.out.println("Something went wrong");
//        }//endcatch3b
//        finally {//finalb
//            scanner.close();
//            System.out.println("This always executes");
//        }//endfinalb
//
//    }//endb2
//}//endb1




//FILE HANDLING
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class Main {
//    public static void main(String[] args){
//
//        //How to write a file using Java (4 popular options)
//
//        //Fileriter = Good for small or medium-sized text files
//        //BufferedWriter = Better performance for large amounts of text
//        //PrintWritter = Best for structired data, like reports or logs
//        //FileOutputStream = Best for binary files (e.g. images and audio files)
//



////        String filePath = "C:\\Users\\Shivaar\\OneDrive - Richfield Graduate Institute of Technology\\Desktop\\Example folder\\test.txt";
////
////        try(FileWriter writer = new FileWriter("test.txt")){
////            writer.write("I like pizza!");
////
////        }
////        catch (FileNotFoundException e){
////            System.out.println("Could not find file exception");
////
////        }
////        catch(IOException e){
////            System.out.println("Could not write file");
////        }
////
////
////    }
////}
//
//        //WRITING A FILE
//
//        String filePath = "C:\\Users\\Shivaar\\OneDrive - Richfield Graduate Institute of Technology\\Desktop\\Example folder\\test.txt";
//        //String textContent = "I like pizza\n It's really good\n Buy me piiza";
//        String textContent = """
//                Rosesare Red
//                Violets are Blue
//                BOOTY BOOTY BOOTY
//                ROCKIN EVERYWHERE!
//                """;
//
//
//        try(FileWriter writer = new FileWriter(filePath)){
//        writer.write(textContent);
//            System.out.println("File has been written");
//        }
//        catch(FileNotFoundException e){
//            System.out.println("File has been written");
//        }
//        catch(IOException e){
//            System.out.println("Could not write file");
//        }
//    }
//    }


    //READING A FILE
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class Main{
//    public static void main(String[] args){
//        //How to read a file using Java (3 popular opinions)
//
//        //BufferedReader + FIleReader: Best for reading text files line-by-line
//        //FileInputStream Best for Binary files (e.g. images,audio files)
//        //RandomAccessFile: Best for read/write specific portions of a large file
//
//        String filePath = "C:\\Users\\Shivaar\\OneDrive - Richfield Graduate Institute of Technology\\Desktop\\Example folder\\test.txt";
//
//
//
//        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){ //when using try with these methods it automatically closes it
//
//            String line;
//            while((line = reader.readLine()) != null ){
//                System.out.println(line);
//            }
//
//        }
//        catch(FileNotFoundException e){
//            System.out.println("Could not loacte file");
//
//        }
//        catch(IOException e){
//            System.out.println("Something went wrong");
//        }
//
//    }
//}


//CORRECT CODE

//import java.io.*;
//
//public  class Main {
//
//    public static void main(String[] args) {
//        String sourceFile = "source.txt";
//        String destinationFile = "destination.txt";
//        String sampleText = "Hello World!\nThis is a sample text file.\nIt contains multiple lines of text.\nUsed for demonstrating Java I/O operations.";
//
//        // Step a: Create and write to source.txt using FileOutputStream
//        writeToFile(sourceFile, sampleText);
//
//        // Step b: Read contents of source.txt using FileInputStream
//        System.out.println("\n--- Reading from source.txt using FileInputStream ---");
//        readFromFile(sourceFile);
//
//        // Step c: Copy contents to destination.txt using buffered streams
//        copyFileWithBufferedStreams(sourceFile, destinationFile);
//
//        // Step d: Verify destination.txt content
//        System.out.println("\n--- Verifying destination.txt content ---");
//        readFromFile(destinationFile);
//    }
//
//    /**
//     * Creates a text file and writes sample text using FileOutputStream
//     */
//    public static void writeToFile(String filename, String content) {
//        try (FileOutputStream fos = new FileOutputStream(filename)) {
//            // Convert string to bytes for OutputStream
//            byte[] contentBytes = content.getBytes();
//            fos.write(contentBytes);
//            System.out.println("Successfully wrote content to " + filename);
//        } catch (IOException e) {
//            System.err.println("Error writing to file " + filename + ": " + e.getMessage());
//        }
//    }
//
//    /**
//     * Reads file contents using FileInputStream and displays on console
//     */
//    public static void readFromFile(String filename) {
//        try (FileInputStream fis = new FileInputStream(filename)) {
//            int byteData;
//            System.out.println("Content of " + filename + ":");
//            // Read byte by byte and convert to character
//            while ((byteData = fis.read()) != -1) {
//                System.out.print((char) byteData);
//            }
//            System.out.println(); // Add newline at end
//        } catch (FileNotFoundException e) {
//            System.err.println("File not found: " + filename);
//        } catch (IOException e) {
//            System.err.println("Error reading file " + filename + ": " + e.getMessage());
//        }
//    }
//
//    /**
//     * Copies file content using BufferedInputStream and BufferedOutputStream
//     */
//    public static void copyFileWithBufferedStreams(String sourceFile, String destinationFile) {
//        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
//             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
//
//            byte[] buffer = new byte[1024]; // Buffer for better performance
//            int bytesRead;
//
//            // Read chunks of data and write to destination
//            while ((bytesRead = bis.read(buffer)) != -1) {
//                bos.write(buffer, 0, bytesRead);
//            }
//
//            System.out.println("Successfully copied " + sourceFile + " to " + destinationFile);
//
//        } catch (FileNotFoundException e) {
//            System.err.println("Source file not found: " + sourceFile);
//        } catch (IOException e) {
//            System.err.println("Error copying file: " + e.getMessage());
//        }
//    }
//}



//import  java.util.Scanner;
//
//class MyRunnable implements Runnable{
//    @Override
//    public void run(){
//
//        for(int i = 1; i <= 10;i++){
//            try{
//                Thread.sleep(1000);
//            } catch(InterruptedException e){
//                System.out.println("Thread was interrupted");
//            }
//
//            if(i==10){
//                System.out.println("Time's up");
//                System.exit(0);
//            }
//
//        }
//    }
//}
//
//public class Main{
//    public  static void main(String[] args){
//        // Threading = Allows a progam to run multiple tasks simultanously
//        //             Helps improves performance with time-consuming operations
//        //             (File I/O, network communications, or any background tasks)
//
//        // How to create a Thread
//        // Option 1. Extend the Thread class (simpler)
//        // Option 2. Implement th Rnnable interface (better)
//
//        Scanner scanner = new Scanner(System.in);
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);
//        thread.setDaemon(true); //ends when main thread is over;
//        thread.start();
//        System.out.println("You have 10 seconds to enter your name");
//
//
//
//        System.out.print(" Enter your name: ");
//        String name = scanner.nextLine();
//        System.out.println(" Hello " + name);
//
//        scanner.close();
//
//    }
//}

//class MyRunnable implements Runnable{
//
//    private final String text;
//
//    MyRunnable(String text){
//        this.text = text;
//    }
//
//    @Override
//
//    public void run(){
//
//        for(int i =1;i<=5;i++){
//            try{
//                Thread.sleep(1000);
//                //System.out.println(i);
//                //System.out.println(Thread.currentThread().getName() + " " + i); //To get each threads name
//                System.out.println(text);
//
//            } catch(InterruptedException e){
//                System.out.println("Thread was interrupted");
//            }
//        }
//
//    }
//}



//
//public class Main{
//    public static void main(String[] args){
//    //Multithreading = Enables a program to run multiple threads concurrently
//    //                 (Thread = A set of instructions that run independently)
//    //                 Useful for background tasks or time-consuming operations
//
//    //MyRunnable myRunnable = new MyRunnable();
//    Thread thread1 = new Thread(new MyRunnable("Ping"));
//    Thread thread2 = new Thread(new MyRunnable("Pong"));
//
//        System.out.println("GAME START!");
//
//
//    thread1.start();
//    thread2.start();
//
//    try{
//        thread1.join();
//        thread2.join();
//
//    } catch(InterruptedException e){
//        //throw new RuntimeException(e);
//        System.out.println("Main thread was interrupted");
//    }
//
//        System.out.println("GAME OVER");
//    }
//}

////My code
//class MyRunnable {
//
//    public void run(){
//        @Override
//       for(int i =1;i<=5;i++){
//           try{
//               Thread.sleep(1000);
//           }
//           catch (InterruptedException e){
//               System.out.println("Something went wrong");
//
//           }
//       }
//
//    }
//}
//
//class Worker extends MyRunnable{
//    public void run(){
//        @Override
//        for(int i =1;i<=5;i++){
//            try{
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException e){
//                System.out.println("Something went wrong");
//
//            }
//        }
//
//    }
//}
//}
//
//public class Main {
//    public static void main(String[] args) {
//
//        Worker worker = new Worker();
//        Thread thread = new Thread();
//        thread.start();
//
//
//    }
//}



// Worker class that extends Thread
//class Worker extends Thread {
//    private String message;
//    private int iterations;
//
//    // Constructor to accept message and iteration count
//    public Worker(String message, int iterations) {
//        this.message = message;
//        this.iterations = iterations;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Worker thread started: " + Thread.currentThread().getName());
//
//        for (int i = 1; i <= iterations; i++) {
//            System.out.println(message + " - Iteration " + i + " [" + Thread.currentThread().getName() + "]");
//
//            try {
//                // Sleep for 1 second between messages
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("Worker thread interrupted: " + e.getMessage());
//                Thread.currentThread().interrupt(); // Restore interrupt status
//                break;
//            }
//        }
//
//        System.out.println("Worker thread completed: " + Thread.currentThread().getName());
//    }
//}
//
//// TaskManager class that implements Runnable
//class TaskManager implements Runnable {
//    private int limit;
//
//    // Constructor to accept the limit for sum calculation
//    public TaskManager(int limit) {
//        this.limit = limit;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("TaskManager thread started: " + Thread.currentThread().getName());
//
//        long sum = 0;
//
//        // Sum all even numbers from 1 to limit
//        for (int i = 2; i <= limit; i += 2) {
//            sum += i;
//        }
//
//        System.out.println("TaskManager Result: Sum of even numbers from 1 to " + limit + " = " + sum);
//        System.out.println("TaskManager thread completed: " + Thread.currentThread().getName());
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Main thread started: " + Thread.currentThread().getName());
//
//        try {
//            // Create two Worker threads with different messages and iterations
//            Worker worker1 = new Worker("Hello from Worker 1", 5);
//            Worker worker2 = new Worker("Greetings from Worker 2", 3);
//
//            // Create TaskManager thread to compute sum of even numbers
//            TaskManager taskManager = new TaskManager(1000);
//            Thread taskThread = new Thread(taskManager, "TaskManager-Thread");
//
//            // Start all threads
//            System.out.println("\n--- Starting all threads ---");
//            worker1.start();
//            worker2.start();
//            taskThread.start();
//
//            System.out.println("All threads have been started and are running concurrently...\n");
//
//            // Use join() to wait for all threads to complete
//            System.out.println("Main thread waiting for all threads to complete...");
//
//            worker1.join();
//            System.out.println("Worker 1 has finished");
//
//            worker2.join();
//            System.out.println("Worker 2 has finished");
//
//            taskThread.join();
//            System.out.println("TaskManager has finished");
//
//            System.out.println("\n--- All threads completed ---");
//            System.out.println("Main thread ending: " + Thread.currentThread().getName());
//
//        } catch (InterruptedException e) {
//            System.out.println("Main thread was interrupted: " + e.getMessage());
//            Thread.currentThread().interrupt();
//        }
//    }
//}

//Autoboxing
//a) Autoboxing in Java is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. For example, converting an int to an Integer:

//int num = 5;
//Integer boxedNum = num; // Autoboxing
//b) One advantage of autoboxing is that it simplifies code by allowing developers to work with primitive types and their corresponding wrapper classes interchangeably without needing to manually convert between them.


