import java.util.Scanner;

/*
 * Campus Event Management System — Main Entry Point
 * PROGRAMMING 731 Assignment
 *
 * Run this class to start the application.
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EventManager manager = new EventManager(sc);

        System.out.println("=========================================");
        System.out.println("  CAMPUS EVENT MANAGEMENT SYSTEM");
        System.out.println("=========================================");

        // --- Role Selection ---
        System.out.println("Select your role:");
        System.out.println("1. Staff");
        System.out.println("2. Student");
        System.out.print("Choose: ");
        String roleChoice = sc.nextLine().trim();

        if (roleChoice.equals("1")) {
            runStaffSession(sc, manager);
        } else if (roleChoice.equals("2")) {
            runStudentSession(sc, manager);
        } else {
            System.out.println("[!] Invalid role selected. Exiting.");
        }

        sc.close();
        System.out.println("\nGoodbye!");
    }

    /* ====================================================
     *  Staff Session
     * ==================================================== */
    private static void runStaffSession(Scanner sc, EventManager manager) {

        System.out.print("\nEnter your Staff ID: ");
        String staffID = sc.nextLine().trim();
        System.out.print("Enter your Name: ");
        String staffName = sc.nextLine().trim();

        Staff staff = new Staff(staffID, staffName);
        System.out.println("\nWelcome, " + staff.getName() + " [" + staff.getRole() + "]");

        String choice = "";
        while (!choice.equals("0")) {
            staff.showMenu();
            choice = sc.nextLine().trim();

            switch (choice) {
                case "1": manager.createEvent();      break;
                case "2": manager.updateEvent();      break;
                case "3": manager.cancelEvent();      break;
                case "4": manager.viewAllEvents();    break;
                case "5": manager.viewParticipants(); break;
                case "6": manager.searchEvents();     break;
                case "7": manager.sortEvents();       break;
                case "0": break;
                default:  System.out.println("[!] Invalid option. Try again.");
            }
        }
    }

    /* ====================================================
     *  Student Session
     * ==================================================== */
    private static void runStudentSession(Scanner sc, EventManager manager) {

        System.out.print("\nEnter your Student ID (e.g. S101): ");
        String studentID = sc.nextLine().trim();
        System.out.print("Enter your Name: ");
        String studentName = sc.nextLine().trim();

        Student student = new Student(studentID, studentName);
        System.out.println("\nWelcome, " + student.getName() + " [" + student.getRole() + "]");

        String choice = "";
        while (!choice.equals("0")) {
            student.showMenu();
            choice = sc.nextLine().trim();

            switch (choice) {
                case "1": manager.viewAllEvents();                  break;
                case "2": manager.studentRegister(studentID);      break;
                case "3": manager.studentCancel(studentID);        break;
                case "4": manager.viewMyStatus(studentID);         break;
                case "5": manager.searchEvents();                  break;
                case "0": break;
                default:  System.out.println("[!] Invalid option. Try again.");
            }
        }
    }
}
