import java.util.Scanner; // Scanner used to read all console input

/* Campus Event Management System — Main Entry Point
 * PROGRAMMING 731 Assignment
 * Run this class to start the application */
public class Main {

    public static void main(String[] args) { // program starts here
        Scanner sc = new Scanner(System.in);          // single Scanner shared across the whole app
        EventManager manager = new EventManager(sc);  // create the manager — loads saved events automatically

        System.out.println("=========================================");
        System.out.println("  CAMPUS EVENT MANAGEMENT SYSTEM");
        System.out.println("=========================================");

        // ---- Role Selection ----
        System.out.println("Select your role:");
        System.out.println("1. Staff");
        System.out.println("2. Student");
        System.out.print("Choose: ");
        String roleChoice = sc.nextLine().trim(); // read the user's role choice

        if (roleChoice.equals("1")) {
            runStaffSession(sc, manager);   // hand control to the staff session
        } else if (roleChoice.equals("2")) {
            runStudentSession(sc, manager); // hand control to the student session
        } else {
            System.out.println("[!] Invalid role selected. Exiting."); // reject anything other than 1 or 2
        }

        sc.close(); // close the Scanner when the session ends
        System.out.println("\nGoodbye!");
    }

    /* ====================================================
     *  Staff Session
     * ==================================================== */
    private static void runStaffSession(Scanner sc, EventManager manager) { // handles the full staff menu loop
        System.out.print("\nEnter your Staff ID: ");
        String staffID = sc.nextLine().trim();   // read staff ID
        System.out.print("Enter your Name: ");
        String staffName = sc.nextLine().trim(); // read staff name

        Staff staff = new Staff(staffID, staffName); // create a Staff object with the entered details
        System.out.println("\nWelcome, " + staff.getName() + " [" + staff.getRole() + "]");

        String choice = "";
        while (!choice.equals("0")) { // keep looping until the user chooses to exit
            staff.showMenu(); // display the staff menu
            choice = sc.nextLine().trim();

            switch (choice) {
                case "1": manager.createEvent();      break; // create a new event
                case "2": manager.updateEvent();      break; // update an existing event
                case "3": manager.cancelEvent();      break; // cancel an event
                case "4": manager.viewAllEvents();    break; // view all events
                case "5": manager.viewParticipants(); break; // view participants and waitlist
                case "6": manager.searchEvents();     break; // search for events
                case "7": manager.sortEvents();       break; // sort events
                case "0": break;                            // exit the loop
                default:  System.out.println("[!] Invalid option. Try again."); // handle bad input
            }
        }
    }

    /* ====================================================
     *  Student Session
     * ==================================================== */
    private static void runStudentSession(Scanner sc, EventManager manager) { // handles the full student menu loop
        System.out.print("\nEnter your Student ID (e.g. S101): ");
        String studentID = sc.nextLine().trim();   // read student ID
        System.out.print("Enter your Name: ");
        String studentName = sc.nextLine().trim(); // read student name

        Student student = new Student(studentID, studentName); // create a Student object with entered details
        System.out.println("\nWelcome, " + student.getName() + " [" + student.getRole() + "]");

        String choice = "";
        while (!choice.equals("0")) { // keep looping until the user chooses to exit
            student.showMenu(); // display the student menu
            choice = sc.nextLine().trim();

            switch (choice) {
                case "1": manager.viewAllEvents();                break; // view all events
                case "2": manager.studentRegister(studentID);    break; // register for an event
                case "3": manager.studentCancel(studentID);      break; // cancel a registration
                case "4": manager.viewMyStatus(studentID);       break; // check the registration status
                case "5": manager.searchEvents();                break; // search for events
                case "0": break;                                        // exit the loop
                default:  System.out.println("[!] Invalid option. Try again."); // handle bad input
            }
        }
    }
}