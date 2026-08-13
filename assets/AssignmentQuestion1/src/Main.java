////Question 1
//import java.util.Scanner;
//public class Main{//b1
//    public static void main(String[] args){ //b2
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("********************");
//        System.out.println("1. Add bicycle:");
//        System.out.println("2. View All Bicycles:");
//        System.out.println("3. Borrow Bicycle:");
//        System.out.println("4. Return Bicycle:");
//        System.out.println("5. View Borrowed Bicycles:");
//        System.out.println("6. Search bicycle:");
//        System.out.println("7. Exit:");
//        System.out.print("Enter your choice:" );
//        int selection = scanner.nextInt();
//        while(selection!=7){//whleb
//        } //endwhileb
//        System.out.println("********************");
//
//
//        scanner.close();
//    }//endb2
//}//endb1

//import java.util.Scanner;
//
//public class Main { //b1
//    private static String[][] bicycles = new String[10][3]; // [ID, Name, Availability]
//    private static String[][] borrowedBicycles = new String[10][2]; // [ID, Name]
//    private static int bicycleCount = 0;
//    private static int borrowedCount = 0;
//
//    public static void main(String[] args) { //b2
//        Scanner scanner = new Scanner(System.in);
//        int selection;
//
//        do { //do whileb
//            System.out.println("********************");
//            System.out.println("1. Add Bicycle");
//            System.out.println("2. View All Bicycles");
//            System.out.println("3. Borrow Bicycle");
//            System.out.println("4. Return Bicycle");
//            System.out.println("5. View Borrowed Bicycles");
//            System.out.println("6. Search Bicycle");
//            System.out.println("7. Exit");
//            System.out.print("Enter your choice: ");
//            selection = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//
//            switch (selection) { //switchb
//                case 1:
//                    addBicycle(scanner);
//                    break;
//                case 2:
//                    viewAllBicycles();
//                    break;
//                case 3:
//                    borrowBicycle(scanner);
//                    break;
//                case 4:
//                    returnBicycle(scanner);
//                    break;
//                case 5:
//                    viewBorrowedBicycles();
//                    break;
//                case 6:
//                    searchBicycle(scanner);
//                    break;
//                case 7:
//                    System.out.println("Exiting...");
//                    break;
//                default:
//                    System.out.println("Invalid choice, please try again.");
//            } //endswitchb
//        }// end do while loop
//        while (selection != 7);
//
//        scanner.close();
//    } //endb2
//
//    private static void addBicycle(Scanner scanner) {
//        if (bicycleCount < bicycles.length) { //ifb
//            System.out.print("Enter Bicycle ID: ");
//            String id = scanner.nextLine();
//            System.out.print("Enter Bicycle Name: ");
//            String name = scanner.nextLine();
//            bicycles[bicycleCount][0] = id; // ID
//            bicycles[bicycleCount][1] = name; // Name
//            bicycles[bicycleCount][2] = "Available"; // Availability
//            bicycleCount++;
//            System.out.println("Bicycle added successfully!");
//        } //endifb
//        else { //elseb
//            System.out.println("Cannot add more bicycles.");
//        } //end elseb
//    }
//
//    private static void viewAllBicycles() {
//        System.out.println("All Bicycles:");
//        for (int i = 0; i < bicycleCount; i++) {
//            System.out.println("ID: " + bicycles[i][0] + ", Name: " + bicycles[i][1] + ", Available: " + bicycles[i][2]);
//        }
//    }
//
//    private static void borrowBicycle(Scanner scanner) {
//        System.out.print("Enter Bicycle ID to borrow: ");
//        String id = scanner.nextLine();
//        for (int i = 0; i < bicycleCount; i++) {
//            if (bicycles[i][0].equals(id) && bicycles[i][2].equals("Available")) {
//                bicycles[i][2] = "Not Available"; // Mark as borrowed
//                borrowedBicycles[borrowedCount][0] = bicycles[i][0]; // ID
//                borrowedBicycles[borrowedCount][1] = bicycles[i][1]; // Name
//                borrowedCount++;
//                System.out.println("You have borrowed: " + bicycles[i][1]);
//                return;
//            }
//        }
//        System.out.println("Bicycle not available or does not exist.");
//    }
//
//    private static void returnBicycle(Scanner scanner) {
//        System.out.print("Enter Bicycle ID to return: ");
//        String id = scanner.nextLine();
//        for (int i = 0; i < borrowedCount; i++) {
//            if (borrowedBicycles[i][0].equals(id)) {
//                // Find and mark as available
//                for (int j = 0; j < bicycleCount; j++) {
//                    if (bicycles[j][0].equals(id)) {
//                        bicycles[j][2] = "Available"; // Mark as available
//                        System.arraycopy(borrowedBicycles, i + 1, borrowedBicycles, i, borrowedCount - i - 1);
//                        borrowedCount--;
//                        System.out.println("You have returned: " + borrowedBicycles[i][1]);
//                        return;
//                    }
//                }
//            }
//        }
//        System.out.println("Bicycle not found in borrowed list.");
//    }
//
//    private static void viewBorrowedBicycles() {
//        System.out.println("Borrowed Bicycles:");
//        for (int i = 0; i < borrowedCount; i++) {
//            System.out.println("ID: " + borrowedBicycles[i][0] + ", Name: " + borrowedBicycles[i][1]);
//        }
//    }
//
//    private static void searchBicycle(Scanner scanner) {
//        System.out.print("Enter Bicycle ID to search: ");
//        String id = scanner.nextLine();
//        for (int i = 0; i < bicycleCount; i++) {
//            if (bicycles[i][0].equals(id)) {
//                System.out.println("Bicycle found: ID: " + bicycles[i][0] + ", Name: " + bicycles[i][1] + ", Available: " + bicycles[i][2]);
//                return;
//            }
//        }
//        System.out.println("Bicycle not found.");
//    }
//} //endb1

// my answer
//import java.util.Scanner;
//
//public class Main { //b1
//    private static String[][] bicycles = new String[10][3]; // [ID, Name, Availability]
//    private static String[][] borrowedBicycles = new String[10][2]; // [ID, Name]
//    private static int bicycleCount = 0;
//    private static int borrowedCount = 0;
//
//    public static void main(String[] args) { //b2
//        Scanner scanner = new Scanner(System.in);
//        int selection;
//
//        do { // do whileb
//            System.out.println("********************");
//            System.out.println("1. Add Bicycle");
//            System.out.println("2. View All Bicycles");
//            System.out.println("3. Borrow Bicycle");
//            System.out.println("4. Return Bicycle");
//            System.out.println("5. View Borrowed Bicycles");
//            System.out.println("6. Search Bicycle");
//            System.out.println("7. Exit");
//            System.out.print("Enter your choice: ");
//            selection = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//
//            switch (selection) { // switchb
//                case 1: // case1b
//                    addBicycle(scanner);
//                    break; // break case1b
//                case 2: // case2b
//                    viewAllBicycles();
//                    break; // break case2b
//                case 3: // case3b
//                    borrowBicycle(scanner);
//                    break; // break case3b
//                case 4: // case4b
//                    returnBicycle(scanner);
//                    break; // break case4b
//                case 5: // case5b
//                    viewBorrowedBicycles();
//                    break; // break case5b
//                case 6: // case6b
//                    searchBicycle(scanner);
//                    break; // break case6b
//                case 7: // case7b
//                    System.out.println("Exiting...");
//                    break; // break case7b
//                default: // defaultb
//                    System.out.println("Invalid choice, please try again.");
//            } // endswitchb
//        } // end do while loop
//        while (selection != 7); // endwhileb
//
//        scanner.close(); // end scanner
//    } // endb2
//
//    private static void addBicycle(Scanner scanner) {
//        if (bicycleCount < bicycles.length) { // ifb
//            System.out.print("Enter Bicycle ID: ");
//            String id = scanner.nextLine();
//            System.out.print("Enter Bicycle Name: ");
//            String name = scanner.nextLine();
//            bicycles[bicycleCount][0] = id; // ID
//            bicycles[bicycleCount][1] = name; // Name
//            bicycles[bicycleCount][2] = "Available"; // Availability
//            bicycleCount++;
//            System.out.println("Bicycle added successfully!");
//        } // endifb
//        else { // elseb
//            System.out.println("Cannot add more bicycles.");
//        } // end elseb
//    } // end addBicycle
//
//    private static void viewAllBicycles() {
//        System.out.println("All Bicycles:");
//        for (int i = 0; i < bicycleCount; i++) { // forb
//            System.out.println("ID: " + bicycles[i][0] + ", Name: " + bicycles[i][1] + ", Available: " + bicycles[i][2]);
//        } // endforb
//    } // end viewAllBicycles
//
//    private static void borrowBicycle(Scanner scanner) {
//        System.out.print("Enter Bicycle ID to borrow: ");
//        String id = scanner.nextLine();
//        for (int i = 0; i < bicycleCount; i++) { // forb
//            if (bicycles[i][0].equals(id) && bicycles[i][2].equals("Available")) {
//                bicycles[i][2] = "Not Available"; // Mark as borrowed
//                borrowedBicycles[borrowedCount][0] = bicycles[i][0]; // ID
//                borrowedBicycles[borrowedCount][1] = bicycles[i][1]; // Name
//                borrowedCount++;
//                System.out.println("You have borrowed: " + bicycles[i][1]);
//                return; // return from borrowBicycle
//            } // end ifb
//        } // endforb
//        System.out.println("Bicycle not available or does not exist.");
//    } // end borrowBicycle
//
//    private static void returnBicycle(Scanner scanner) {
//        System.out.print("Enter Bicycle ID to return: ");
//        String id = scanner.nextLine();
//        for (int i = 0; i < borrowedCount; i++) { // forb
//            if (borrowedBicycles[i][0].equals(id)) {
//                // Find and mark as available
//                for (int j = 0; j < bicycleCount; j++) { // forb
//                    if (bicycles[j][0].equals(id)) {
//                        bicycles[j][2] = "Available"; // Mark as available
//                        System.arraycopy(borrowedBicycles, i + 1, borrowedBicycles, i, borrowedCount - i - 1);
//                        borrowedCount--;
//                        System.out.println("You have returned: " + borrowedBicycles[i][1]);
//                        return; // return from returnBicycle
//                    } // end ifb
//                } // endforb
//            } // end ifb
//        } // endforb
//        System.out.println("Bicycle not found in borrowed list.");
//    } // end returnBicycle
//
//    private static void viewBorrowedBicycles() {
//        System.out.println("Borrowed Bicycles:");
//        for (int i = 0; i < borrowedCount; i++) { // forb
//            System.out.println("ID: " + borrowedBicycles[i][0] + ", Name: " + borrowedBicycles[i][1]);
//        } // endforb
//    } // end viewBorrowedBicycles
//
//    private static void searchBicycle(Scanner scanner) {
//        System.out.print("Enter Bicycle ID to search: ");
//        String id = scanner.nextLine();
//        for (int i = 0; i < bicycleCount; i++) { // forb
//            if (bicycles[i][0].equals(id)) {
//                System.out.println("Bicycle found: ID: " + bicycles[i][0] + ", Name: " + bicycles[i][1] + ", Available: " + bicycles[i][2]);
//                return; // return from searchBicycle
//            } // end ifb
//        } // endforb
//        System.out.println("Bicycle not found.");
//    } // end searchBicycle
//} // endb1



//import java.util.Scanner;
//public class Main{//b1
//
//    // I will define a Bicycle class to represent each bicycle's attributes.
//    static class Bicycle{//class bicycle
//        String name;
//        String make;
//        String type;
//        boolean isAvailable;
//
//
//        //Constructor to initialize a Bicycle object.
//        public Bicycle(String name, String make, String type, boolean isAvailable){//constructorb
//            this.name = name;
//            this.make = make;
//            this.type = type;
//            this.isAvailable = isAvailable;
//        }//endconstructorb
//
//        //Method to display the bicycle details.
//        public void display(){//Func
//            System.out.println("Name:" + name + ", Make:" + make + ", Type:" + type + ", Available:" + (isAvailable ? "Yes" : "No"));
//        }//EndFunc
//    } //endclass bicycle
//
//    //I will create a multidimensional array to store bicycle information.
//    // For simplicity, I will assume a fixed array size of (10 bicycles).
//    static Bicycle[][] bicycles = new Bicycle[10][1]; // 2D array(bicycles stored as rows)
//
//    // I will use this array to track borrowed bicycles by the users.
//    static String[] borrowedBicycles = new String[2]; //Only 2 Bicycles can be borrowed at a time
//    //Main method to drive the program
//    public static void main(String[] args){//b2
//        Scanner scanner = new Scanner(System.in);
//        int choice;
//
//        //The program will keep running until the user chooses to exit.
//        do{//dowhileb
//            // Display menu options for the user
//            System.out.println("*****************");
//            System.out.println("1. Add Bicycle");
//            System.out.println("2. View all Bicycles");
//            System.out.println("3. Borrow Bicycle");
//            System.out.println("4. Return Bicycles");
//            System.out.println("5. View Borrowed Bicycles");
//            System.out.println("6. Search Bicycle");
//            System.out.println("7. Exit");
//            System.out.println("**********************");
//
//            //I will read the user's choice.
//            System.out.print("Enter your choice: ");
//            choice = scanner.nextInt();
//
//            switch(choice){//switchb
//                case 1: addBicycle(scanner); // call method to add a bicycle
//                    break;
//                case 2: viewAllBicycles(); //Call method to view all bicycles
//                    break;
//                case 3: borrowBicycle(scanner); //Call method to borrow a bicycle
//                    break;
//                case 4: returnBicycle(scanner); //Call method to return a bicycle
//                    break;
//                case 5: viewBorrowedBicycles(); // Call method to view borrowed bicycles
//                    break;
//                case 6: searchBicycle(scanner); //Call method to search for a bicycle
//                    break;
//                case 7: System.out.println("Exiting the system. Goodbye!");
//                    break;
//                default: System.out.println("Invalid choice. Please try again");
//                    break;
//            }//endswitchb
//
//        }//enddowhileb
//        while(choice != 7);
//
//        scanner.close();
//    }//endb2
//
//    //Method to add a bicycle
//    public static void addBicycle(Scanner scanner){//func
//        System.out.print("Enter bicycle name: ");
//        String name = scanner.next();
//        System.out.print("Enter bicycle make: ");
//        String make = scanner.next();
//        System.out.print("Enter bicycle type: ");
//        String type = scanner.next();
//
//        //Adding the bicycle to the first available spot in the array.
//        for(int i = 0; i < bicycles.length; i++){//forloopb
//            if(bicycles[i][0] == null){//ifb
//                bicycles[i][0] = new Bicycle(name, make, type, true); // Marking the bicycle as available
//                System.out.println("Bicycle added successfully!");
//                return;
//            }//endifb
//        }//endforloopb
//        System.out.println("No space available to add more bicycles.");
//    }//endfunc
//
//    //Method to view all bicycles
//    public static void viewAllBicycles(){//Func
//        boolean hasBicycles = false;
//        for(int r = 0; r < bicycles.length; r++){//forloopb
//            if(bicycles[r][0] != null){//ifb
//                bicycles[r][0].display(); //Display bicycle details
//                hasBicycles = true;
//            }//endifb
//        }//endforloopb
//        if(!hasBicycles){//ifb
//            System.out.println("No bicycles available");
//        }//endifb
//    }//endFunc
//
//    //Method to borrow a bicycle
//    public static void borrowBicycle(Scanner scanner){//Func
//        System.out.print("Enter your name: ");
//        String name = scanner.next();
//
//        int borrowedCount = 0;
//        //Check if user is borrowing 2 bicycles
//        for(String borrowed : borrowedBicycles){//enhancedforloopb
//            if(borrowed != null){//ifb
//                borrowedCount++;
//            }//endifb
//        }//endenhancedforloopb
//
//        if(borrowedCount >= 2){//ifb
//            System.out.println("You can only borrow up to 2 bicycles.");
//            return;
//        }//endifb
//
//        System.out.print("Enter bicycle name to borrow: ");
//        String bicycleName = scanner.next();
//
//        for(int i = 0; i < bicycles.length; i++){//outerforloopb
//            if(bicycles[i][0] != null && bicycles[i][0].name.equalsIgnoreCase(bicycleName) && bicycles[i][0].isAvailable){//ifb
//                bicycles[i][0].isAvailable = false; //Bicycle is no longer available
//                System.out.println("Bicycle borrowed successfully!");
//                //Store the borrowed bicycle information
//                for(int j = 0; j < borrowedBicycles.length; j++){//innerforloopb
//                    if(borrowedBicycles[j] == null){//ifb
//                        borrowedBicycles[j] = bicycleName;
//                        return;
//                    }//endifb
//                }//endinnerforloopb
//            }//endifb
//        }//endouterforloopb
//
//        System.out.println("Bicycle not available or doesn't exist");
//    }//endFunc
//
//    //Method to return a bicycle
//    public static void returnBicycle(Scanner scanner){//Func
//        System.out.print("Enter bicycle name to return: ");
//        String bicycleName = scanner.next();
//
//        for(int i = 0; i < borrowedBicycles.length; i++){//forloopb
//            if(borrowedBicycles[i] != null && borrowedBicycles[i].equalsIgnoreCase(bicycleName)){//ifb
//                borrowedBicycles[i] = null;
//
//                for(int j = 0; j < bicycles.length; j++){//innerforloopb
//                    if(bicycles[j][0] != null && bicycles[j][0].name.equalsIgnoreCase(bicycleName)){//ifb
//                        bicycles[j][0].isAvailable = true; //Making bicycle available again
//                        System.out.println("Bicycle returned successfully!");
//                        return;
//                    }//endifb
//                }//endinnerforloopb
//            }//endifb
//        }//endforloopb
//        System.out.println("You haven't borrowed this bicycle");
//    }//endFunc
//
//    //Method to view borrowed bicycles
//    public static void viewBorrowedBicycles(){//Func
//        System.out.println("Borrowed Bicycles:");
//        boolean hasBorrowed = false;
//        for(String borrowed : borrowedBicycles){//enhancedforloopb
//            if(borrowed != null){//ifb
//                System.out.println(borrowed);
//                hasBorrowed = true;
//            }//endifb
//        }//endenhancedforloopb
//        if(!hasBorrowed){//ifb
//            System.out.println("No bicycles currently borrowed.");
//        }//endifb
//    }//endFunc
//
//    //Method to search for a bicycle by name
//    public static void searchBicycle(Scanner scanner){//Func
//        System.out.print("Enter bicycle name to search: ");
//        String name = scanner.next();
//        boolean found = false;
//
//        for(int i = 0; i < bicycles.length; i++){//forloopb
//            if(bicycles[i][0] != null && bicycles[i][0].name.equalsIgnoreCase(name)){//ifb
//                bicycles[i][0].display();
//                found = true;
//            }//endifb
//        }//endforloopb
//
//        if(!found){//ifb
//            System.out.println("Bicycle not found");
//        }//endifb
//    }//endFunc
//
//}//endb1

//Perfect one:
// import java.util.Scanner;
//public class Main { // main-class-bracket
//
//    // Bicycle class to represent each bicycle's attributes
//    static class Bicycle { // bicycle-class-bracket
//        String name;
//        String make;
//        String type;
//        boolean isAvailable;
//
//        // Method to display the bicycle details
//        public void display() { // display-method-bracket
//            System.out.println("Name:" + name + ", Make:" + make + ", Type:" + type + ", Available:" + (isAvailable ? "Yes" : "No"));
//        } // end-display-method-bracket
//    } // end-bicycle-class-bracket
//
//    // Dynamic array to store bicycle information - increased from 10 to 20 for more capacity
//    static Bicycle[][] bicycles = new Bicycle[20][1]; // 2D array(bicycles stored as rows)
//
//    // Array to track borrowed bicycles by the users
//    static String[] borrowedBicycles = new String[2]; // Only 2 Bicycles can be borrowed at a time
//
//    // Method to add a bicycle
//    public static void addBicycle(Scanner scanner) { // add-bicycle-method-bracket
//        System.out.print("Enter bicycle name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter bicycle make: ");
//        String make = scanner.nextLine();
//        System.out.print("Enter bicycle type: ");
//        String type = scanner.nextLine();
//        System.out.println();
//
//        // Adding the bicycle to the first available spot in the array
//        for(int r = 0; r < bicycles.length; r++) { // add-bicycle-loop-bracket
//            if(bicycles[r][0] == null) { // null-check-bracket
//                // Create and initialize bicycle without constructor
//                Bicycle newBike = new Bicycle();
//                newBike.name = name;
//                newBike.make = make;
//                newBike.type = type;
//                newBike.isAvailable = true;
//
//                bicycles[r][0] = newBike; // Store the bicycle in the array
//                System.out.println("Bicycle added successfully!");
//                return;
//            } // end-null-check-bracket
//        } // end-add-bicycle-loop-bracket
//        System.out.println("No space available to add more bicycles.");
//    } // end-add-bicycle-method-bracket
//
//    // Method to view all bicycles
//    public static void viewAllBicycles() { // view-bicycles-method-bracket
//        boolean hasBicycles = false;
//        for(int r = 0; r < bicycles.length; r++) { // view-bicycles-loop-bracket
//            if(bicycles[r][0] != null) { // not-null-check-bracket
//                bicycles[r][0].display(); // Display bicycle details
//                hasBicycles = true;
//            } // end-not-null-check-bracket
//        } // end-view-bicycles-loop-bracket
//        if(!hasBicycles) { // no-bicycles-check-bracket
//            System.out.println("No bicycles available");
//        } // end-no-bicycles-check-bracket
//    } // end-view-bicycles-method-bracket
//
//    // Method to borrow a bicycle
//    public static void borrowBicycle(Scanner scanner) { // borrow-bicycle-method-bracket
//        System.out.print("Enter your name: ");
//        String name = scanner.next();
//
//        int borrowedCount = 0;
//        // Check if user is borrowing 2 bicycles
//        for(String borrowed : borrowedBicycles) { // count-borrowed-loop-bracket
//            if(borrowed != null) { // borrowed-check-bracket
//                borrowedCount++;
//            } // end-borrowed-check-bracket
//        } // end-count-borrowed-loop-bracket
//
//        if(borrowedCount >= 2) { // max-borrow-check-bracket
//            System.out.println("You can only borrow up to 2 bicycles.");
//            return;
//        } // end-max-borrow-check-bracket
//
//        System.out.print("Enter bicycle name to borrow: ");
//        String bicycleName = scanner.next();
//
//        for(int r = 0; r < bicycles.length; r++) { // outer-for-loop-bracket
//            if(bicycles[r][0] != null && bicycles[r][0].name.equalsIgnoreCase(bicycleName) && bicycles[r][0].isAvailable) { // available-check-bracket
//                bicycles[r][0].isAvailable = false; // Bicycle is no longer available
//                System.out.println("Bicycle borrowed successfully!");
//                // Store the borrowed bicycle information
//                for(int c = 0; c < borrowedBicycles.length; c++) { // inner-for-loop-bracket
//                    if(borrowedBicycles[c] == null) { // empty-slot-check-bracket
//                        borrowedBicycles[c] = bicycleName;
//                        return;
//                    } // end-empty-slot-check-bracket
//                } // end-inner-for-loop-bracket
//            } // end-available-check-bracket
//        } // end-outer-for-loop-bracket
//
//        System.out.println("Bicycle not available or doesn't exist");
//    } // end-borrow-bicycle-method-bracket
//
//    // Method to return a bicycle
//    public static void returnBicycle(Scanner scanner) { // return-bicycle-method-bracket
//        System.out.print("Enter bicycle name to return: ");
//        String bicycleName = scanner.next();
//
//        for(int r = 0; r < borrowedBicycles.length; r++) { // return-outer-loop-bracket
//            if(borrowedBicycles[r] != null && borrowedBicycles[r].equalsIgnoreCase(bicycleName)) { // borrowed-match-bracket
//                borrowedBicycles[r] = null;
//
//                for(int c = 0; c < bicycles.length; c++) { // return-inner-loop-bracket
//                    if(bicycles[c][0] != null && bicycles[c][0].name.equalsIgnoreCase(bicycleName)) { // find-bike-bracket
//                        bicycles[c][0].isAvailable = true; // Making bicycle available again
//                        System.out.println("Bicycle returned successfully!");
//                        return;
//                    } // end-find-bike-bracket
//                } // end-return-inner-loop-bracket
//            } // end-borrowed-match-bracket
//        } // end-return-outer-loop-bracket
//        System.out.println("You haven't borrowed this bicycle");
//    } // end-return-bicycle-method-bracket
//
//    // Method to view borrowed bicycles
//    public static void viewBorrowedBicycles() { // view-borrowed-method-bracket
//        System.out.println("Borrowed Bicycles:");
//        boolean hasBorrowed = false;
//        for(String borrowed : borrowedBicycles) { // display-borrowed-loop-bracket
//            if(borrowed != null) { // not-null-borrowed-bracket
//                System.out.println(borrowed);
//                hasBorrowed = true;
//            } // end-not-null-borrowed-bracket
//        } // end-display-borrowed-loop-bracket
//        if(!hasBorrowed) { // no-borrowed-check-bracket
//            System.out.println("No bicycles currently borrowed.");
//        } // end-no-borrowed-check-bracket
//    } // end-view-borrowed-method-bracket
//
//    // Method to search for a bicycle by name
//    public static void searchBicycle(Scanner scanner) { // search-bicycle-method-bracket
//        System.out.print("Enter bicycle name to search: ");
//        String name = scanner.next();
//        boolean found = false;
//
//        for(int r = 0; r < bicycles.length; r++) { // search-loop-bracket
//            if(bicycles[r][0] != null && bicycles[r][0].name.equalsIgnoreCase(name)) { // match-check-bracket
//                bicycles[r][0].display();
//                found = true;
//            } // end-match-check-bracket
//        } // end-search-loop-bracket
//
//        if(!found) { // not-found-check-bracket
//            System.out.println("Bicycle not found");
//        } // end-not-found-check-bracket
//    } // end-search-bicycle-method-bracket
//
//    // Main method to drive the program
//    public static void main(String[] args) { // main-method-bracket
//        Scanner scanner = new Scanner(System.in);
//        int selection;
//
//        // The program will keep running until the user chooses to exit
//        do { // menu-loop-bracket
//            // Display menu options for the user
//            System.out.println("*****************");
//            System.out.println("1. Add Bicycle");
//            System.out.println("2. View all Bicycles");
//            System.out.println("3. Borrow Bicycle");
//            System.out.println("4. Return Bicycles");
//            System.out.println("5. View Borrowed Bicycles");
//            System.out.println("6. Search Bicycle");
//            System.out.println("7. Exit");
//            System.out.println("**********************");
//
//            // Read the user's selection
//            System.out.print("Enter your selection: ");
//            selection = scanner.nextInt();
//
//            switch(selection) { // menu-switch-bracket
//                case 1:
//                    addBicycle(scanner); // Call method to add a bicycle
//                    break;
//                case 2:
//                    viewAllBicycles(); // Call method to view all bicycles
//                    break;
//                case 3:
//                    borrowBicycle(scanner); // Call method to borrow a bicycle
//                    break;
//                case 4:
//                    returnBicycle(scanner); // Call method to return a bicycle
//                    break;
//                case 5:
//                    viewBorrowedBicycles(); // Call method to view borrowed bicycles
//                    break;
//                case 6:
//                    searchBicycle(scanner); // Call method to search for a bicycle
//                    break;
//                case 7:
//                    System.out.println("Exiting the system. Goodbye!");
//                    break;
//                default:
//                    System.out.println("Invalid selection. Please try again");
//                    break;
//            } // end-menu-switch-bracket
//        } // end-menu-loop-bracket
//        while(selection != 7);
//
//        scanner.close();
//    } // end-main-method-bracket
//} // end-main-class-bracket

//Some errors
//import java.util.Scanner;
//
//public class Main {
//    // Bicycle class to represent each bicycle's attributes
//    static class Bicycle {
//        String name;
//        String make;
//        String type;
//        boolean isAvailable;
//
//        // Method to display the bicycle details
//        public void display() {
//            System.out.print("Name:" + name + ", Make:" + make + ", Type:" + type + ", Available:" + (isAvailable ? " Yes" : " No"));
//        } // end-display-method
//    } // end-Bicycle-class
//
//    // Dynamic array to store bicycle information
//    static Bicycle[][] bicycles = new Bicycle[20][1];
//
//    // Array to track borrowed bicycles by the users
//    static String[] borrowedBicycles = new String[2];
//
//    // 1.Method to add a bicycle
//    public static void addBicycle(Scanner scanner) {
//        System.out.print("Enter bicycle name: ");
//        String name = scanner.nextLine(); // Use nextLine for full input
//
//        System.out.print("Enter bicycle make: ");
//        String make = scanner.nextLine(); // Use nextLine for full input
//
//        System.out.print("Enter bicycle type: ");
//        String type = scanner.nextLine(); // Use nextLine for full input
//
//        // Adding the bicycle to the first available spot in the array
//        for (int r = 0; r < bicycles.length; r++) { // add-bicycle-loop-bracket
//            if (bicycles[r][0] == null) { // null-check-bracket
//                Bicycle newBike = new Bicycle();
//                newBike.name = name;
//                newBike.make = make;
//                newBike.type = type;
//                newBike.isAvailable = true;
//
//                bicycles[r][0] = newBike;
//                System.out.println("Bicycle added successfully!");
//                return;
//            } // end-null-check-bracket
//        } // end-add-bicycle-loop-bracket
//        System.out.println("No space available to add more bicycles.");
//    } // end-addBicycle-method
//
//    //2. Method to view all bicycles
//    public static void viewAllBicycles() {
//        boolean hasBicycles = false;
//        for (int r = 0; r < bicycles.length; r++) { // view-all-loop-bracket
//            if (bicycles[r][0] != null) { // not-null-check-bracket
//                bicycles[r][0].display();
//                System.out.println(); // Ensure each bicycle is on a new line
//                hasBicycles = true;
//            } // end-not-null-check-bracket
//        } // end-view-all-loop-bracket
//        if (!hasBicycles) { // no-bicycles-check-bracket
//            System.out.println("No bicycles available");
//        } // end-no-bicycles-check-bracket
//    } // end-viewAllBicycles-method
//
//
//    //3. Method to borrow a bicycle
//    public static void borrowBicycle(Scanner scanner) { // borrow-bicycle-method-bracket
//        System.out.print("Enter your name: ");
//        String name = scanner.next();
//
//        int borrowedCount = 0;
//        // Check if user is borrowing 2 bicycles
//        for(String borrowed : borrowedBicycles) { // count-borrowed-loop-bracket
//            if(borrowed != null) { // borrowed-check-bracket
//                borrowedCount++;
//            } // end-borrowed-check-bracket
//        } // end-count-borrowed-loop-bracket
//
//        if(borrowedCount >= 2) { // max-borrow-check-bracket
//            System.out.println("You can only borrow up to 2 bicycles.");
//            return;
//        } // end-max-borrow-check-bracket
//
//        System.out.print("Enter bicycle name to borrow: ");
//        String bicycleName = scanner.next();
//
//        for(int r = 0; r < bicycles.length; r++) { // outer-for-loop-bracket
//            if(bicycles[r][0] != null && bicycles[r][0].name.equalsIgnoreCase(bicycleName) && bicycles[r][0].isAvailable) { // available-check-bracket
//                bicycles[r][0].isAvailable = false; // Bicycle is no longer available
//                System.out.println("Bicycle borrowed successfully!");
//                // Store the borrowed bicycle information
//                for(int c = 0; c < borrowedBicycles.length; c++) { // inner-for-loop-bracket
//                    if(borrowedBicycles[c] == null) { // empty-slot-check-bracket
//                        borrowedBicycles[c] = bicycleName;
//                        return;
//                    } // end-empty-slot-check-bracket
//                } // end-inner-for-loop-bracket
//            } // end-available-check-bracket
//        } // end-outer-for-loop-bracket
//
//        System.out.println("Bicycle not available or doesn't exist");
//    } // end-borrow-bicycle-method-bracket
//
//    //4. Method to return a bicycle
//    public static void returnBicycle(Scanner scanner) { // return-bicycle-method-bracket
//        System.out.print("Enter bicycle name to return: ");
//        String bicycleName = scanner.next();
//
//        for(int r = 0; r < borrowedBicycles.length; r++) { // return-outer-loop-bracket
//            if(borrowedBicycles[r] != null && borrowedBicycles[r].equalsIgnoreCase(bicycleName)) { // borrowed-match-bracket
//                borrowedBicycles[r] = null;
//
//                for(int c = 0; c < bicycles.length; c++) { // return-inner-loop-bracket
//                    if(bicycles[c][0] != null && bicycles[c][0].name.equalsIgnoreCase(bicycleName)) { // find-bike-bracket
//                        bicycles[c][0].isAvailable = true; // Making bicycle available again
//                        System.out.println("Bicycle returned successfully!");
//                        return;
//                    } // end-find-bike-bracket
//                } // end-return-inner-loop-bracket
//            } // end-borrowed-match-bracket
//        } // end-return-outer-loop-bracket
//        System.out.println("You haven't borrowed this bicycle");
//    } // end-return-bicycle-method-bracket
//
//    // Method to view borrowed bicycles
//    public static void viewBorrowedBicycles() { // view-borrowed-method-bracket
//        System.out.println("Borrowed Bicycles:");
//        boolean hasBorrowed = false;
//        for(String borrowed : borrowedBicycles) { // display-borrowed-loop-bracket
//            if(borrowed != null) { // not-null-borrowed-bracket
//                System.out.println(borrowed);
//                hasBorrowed = true;
//            } // end-not-null-borrowed-bracket
//        } // end-display-borrowed-loop-bracket
//        if(!hasBorrowed) { // no-borrowed-check-bracket
//            System.out.println("No bicycles currently borrowed.");
//        } // end-no-borrowed-check-bracket
//    } // end-view-borrowed-method-bracket
//
//    // Method to search for a bicycle by name
//    public static void searchBicycle(Scanner scanner) { // search-bicycle-method-bracket
//        System.out.print("Enter bicycle name to search: ");
//        String name = scanner.next();
//        boolean found = false;
//
//        for(int r = 0; r < bicycles.length; r++) { // search-loop-bracket
//            if(bicycles[r][0] != null && bicycles[r][0].name.equalsIgnoreCase(name)) { // match-check-bracket
//                bicycles[r][0].display();
//                found = true;
//            } // end-match-check-bracket
//        } // end-search-loop-bracket
//
//        if(!found) { // not-found-check-bracket
//            System.out.println("Bicycle not found");
//        } // end-not-found-check-bracket
//    } // end-search-bicycle-method-bracket
//
//
//    // Main method to drive the program
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int selection;
//
//        do { // main-do-while-bracket
//            // Display menu options for the user
//            System.out.println("*****************");
//            System.out.println("1. Add Bicycle");
//            System.out.println("2. View all Bicycles");
//            System.out.println("3. Borrow Bicycle");
//            System.out.println("4. Return Bicycles");
//            System.out.println("5. View Borrowed Bicycles");
//            System.out.println("6. Search Bicycle");
//            System.out.println("7. Exit");
//            System.out.println("**********************");
//
//            // Read the user's selection
//            System.out.print("Enter your selection: ");
//            selection = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline left by nextInt()
//
//            switch (selection) { // switch-bracket
//                case 1:
//                    addBicycle(scanner);
//                    break;
//                case 2:
//                    viewAllBicycles();
//                    break;
//                case 3:
//                    borrowBicycle(scanner); // Call method to borrow a bicycle
//                    break;
//                case 4:
//                    returnBicycle(scanner); // Call method to return a bicycle
//                    break;
//                case 5:
//                    viewBorrowedBicycles(); // Call method to view borrowed bicycles
//                    break;
//                case 6:
//                    searchBicycle(scanner); // Call method to search for a bicycle
//                    break;
//                case 7:
//                    System.out.println("Exiting the system. Goodbye!");
//                    break;
//                default:
//                    System.out.println("Invalid selection. Please try again");
//                    break;
//            } // end-switch-bracket
//        } while (selection != 7); // end-main-do-while-bracket
//
//        scanner.close();
//    } // end-main-method
//} // end-Main-class


import java.util.Scanner;

public class Main {
    // Bicycle class to represent each bicycle's attributes
    static class Bicycle {
        String name;
        String make;
        String type;
        boolean isAvailable;

        // Method to display the bicycle details
        public void display() {
            System.out.print("Name:" + name + ", Make:" + make + ", Type:" + type + ", Available:" + (isAvailable ? " Yes" : " No"));
        } // end-display-method
    } // end-Bicycle-class

    // Dynamic array to store bicycle information
    static Bicycle[][] bicycles = new Bicycle[20][1];

    // Array to track borrowed bicycles by the users
    static String[] borrowedBicycles = new String[2];

    // 1.Method to add a bicycle
    public static void addBicycle(Scanner scanner) {
        System.out.print("Enter bicycle name: ");
        String name = scanner.nextLine(); // Use nextLine for full input

        System.out.print("Enter bicycle make: ");
        String make = scanner.nextLine(); // Use nextLine for full input

        System.out.print("Enter bicycle type: ");
        String type = scanner.nextLine(); // Use nextLine for full input

        // Adding the bicycle to the first available spot in the array
        for (int r = 0; r < bicycles.length; r++) { // add-bicycle-loop-bracket
            if (bicycles[r][0] == null) { // null-check-bracket
                Bicycle newBike = new Bicycle();
                newBike.name = name;
                newBike.make = make;
                newBike.type = type;
                newBike.isAvailable = true;

                bicycles[r][0] = newBike;
                System.out.println("Bicycle added successfully!");
                return;
            } // end-null-check-bracket
        } // end-add-bicycle-loop-bracket
        System.out.println("No space available to add more bicycles.");
    } // end-addBicycle-method

    //2. Method to view all bicycles
    public static void viewAllBicycles() {
        boolean hasBicycles = false;
        for (int r = 0; r < bicycles.length; r++) { // view-all-loop-bracket
            if (bicycles[r][0] != null) { // not-null-check-bracket
                bicycles[r][0].display();
                System.out.println(); // Ensure each bicycle is on a new line
                hasBicycles = true;
            } // end-not-null-check-bracket
        } // end-view-all-loop-bracket
        if (!hasBicycles) { // no-bicycles-check-bracket
            System.out.println("No bicycles available");
        } // end-no-bicycles-check-bracket
    } // end-viewAllBicycles-method


    // Method to borrow a bicycle
    public static void borrowBicycle(Scanner scanner) { // borrow-bicycle-method-bracket
        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Changed from next() to nextLine()

        int borrowedCount = 0;
        // Check if user is borrowing 2 bicycles
        for(String borrowed : borrowedBicycles) { // count-borrowed-loop-bracket
            if(borrowed != null) { // borrowed-check-bracket
                borrowedCount++;
            } // end-borrowed-check-bracket
        } // end-count-borrowed-loop-bracket

        if(borrowedCount >= 2) { // max-borrow-check-bracket
            System.out.println("You can only borrow up to 2 bicycles.");
            return;
        } // end-max-borrow-check-bracket

        System.out.print("Enter bicycle name to borrow: ");
        String bicycleName = scanner.nextLine(); // Changed from next() to nextLine()

        for(int r = 0; r < bicycles.length; r++) { // outer-for-loop-bracket
            if(bicycles[r][0] != null && bicycles[r][0].name.equalsIgnoreCase(bicycleName) && bicycles[r][0].isAvailable) { // available-check-bracket
                bicycles[r][0].isAvailable = false; // Bicycle is no longer available
                System.out.println("Bicycle borrowed successfully!");
                // Store the borrowed bicycle information
                for(int c = 0; c < borrowedBicycles.length; c++) { // inner-for-loop-bracket
                    if(borrowedBicycles[c] == null) { // empty-slot-check-bracket
                        borrowedBicycles[c] = bicycleName;
                        return;
                    } // end-empty-slot-check-bracket
                } // end-inner-for-loop-bracket
            } // end-available-check-bracket
        } // end-outer-for-loop-bracket

        System.out.println("Bicycle not available or doesn't exist");
    } // end-borrow-bicycle-method-bracket

    // Method to return a bicycle
    public static void returnBicycle(Scanner scanner) { // return-bicycle-method-bracket
        System.out.print("Enter bicycle name to return: ");
        String bicycleName = scanner.nextLine(); // Changed from next() to nextLine()

        for(int r = 0; r < borrowedBicycles.length; r++) { // return-outer-loop-bracket
            if(borrowedBicycles[r] != null && borrowedBicycles[r].equalsIgnoreCase(bicycleName)) { // borrowed-match-bracket
                borrowedBicycles[r] = null;

                for(int c = 0; c < bicycles.length; c++) { // return-inner-loop-bracket
                    if(bicycles[c][0] != null && bicycles[c][0].name.equalsIgnoreCase(bicycleName)) { // find-bike-bracket
                        bicycles[c][0].isAvailable = true; // Making bicycle available again
                        System.out.println("Bicycle returned successfully!");
                        return;
                    } // end-find-bike-bracket
                } // end-return-inner-loop-bracket
            } // end-borrowed-match-bracket
        } // end-return-outer-loop-bracket
        System.out.println("You haven't borrowed this bicycle");
    } // end-return-bicycle-method-bracket

    // Method to view borrowed bicycles
    public static void viewBorrowedBicycles() { // view-borrowed-method-bracket
        System.out.println("Borrowed Bicycles:");
        boolean hasBorrowed = false;
        for(String borrowed : borrowedBicycles) { // display-borrowed-loop-bracket
            if(borrowed != null) { // not-null-borrowed-bracket
                System.out.println(borrowed);
                hasBorrowed = true;
            } // end-not-null-borrowed-bracket
        } // end-display-borrowed-loop-bracket
        if(!hasBorrowed) { // no-borrowed-check-bracket
            System.out.println("No bicycles currently borrowed.");
        } // end-no-borrowed-check-bracket
    } // end-view-borrowed-method-bracket

    // Method to search for a bicycle by name
    public static void searchBicycle(Scanner scanner) { // search-bicycle-method-bracket
        System.out.print("Enter bicycle name to search: ");
        String name = scanner.nextLine(); // Changed from next() to nextLine()
        boolean found = false;

        for(int r = 0; r < bicycles.length; r++) { // search-loop-bracket
            if(bicycles[r][0] != null && bicycles[r][0].name.equalsIgnoreCase(name)) { // match-check-bracket
                bicycles[r][0].display();
                System.out.println(); // Added newline for better readability
                found = true;
            } // end-match-check-bracket
        } // end-search-loop-bracket

        if(!found) { // not-found-check-bracket
            System.out.println("Bicycle not found");
        } // end-not-found-check-bracket
    } // end-search-bicycle-method-bracket


    // Main method to drive the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selection = 0;

        do { // main-do-while-bracket
            // Display menu options for the user
            System.out.println("*****************");
            System.out.println("1. Add Bicycle");
            System.out.println("2. View all Bicycles");
            System.out.println("3. Borrow Bicycle");
            System.out.println("4. Return Bicycles");
            System.out.println("5. View Borrowed Bicycles");
            System.out.println("6. Search Bicycle");
            System.out.println("7. Exit");
            System.out.println("**********************");

            // Read the user's selection
            System.out.print("Enter your selection: ");
            try {
                selection = scanner.nextInt();
                scanner.nextLine(); // Consume the newline left by nextInt()

                switch (selection) { // switch-bracket
                    case 1:
                        addBicycle(scanner);
                        break;
                    case 2:
                        viewAllBicycles();
                        break;
                    case 3:
                        borrowBicycle(scanner); // Call method to borrow a bicycle
                        break;
                    case 4:
                        returnBicycle(scanner); // Call method to return a bicycle
                        break;
                    case 5:
                        viewBorrowedBicycles(); // Call method to view borrowed bicycles
                        break;
                    case 6:
                        searchBicycle(scanner); // Call method to search for a bicycle
                        break;
                    case 7:
                        System.out.println("Closing Bicycle Management System");
                        break;
                    default:
                        System.out.println("Invalid selection. Please try again");
                        break;
                } // end-switch-bracket
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a number between 1 and 7.");
                scanner.nextLine(); // Clear the invalid input
                selection = 0; // Set to invalid selection to continue loop
            }
        } while (selection != 7); // end-main-do-while-bracket

        scanner.close();
    } // end-main-method
} // end-Main-class