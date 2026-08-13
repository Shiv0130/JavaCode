import java.util.Scanner;
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    EventManager manager = new EventManager(sc); // Initialise the event manager with scanner for input

    System.out.println("Welcome to Richfield Campus Event Management System!");

    System.out.println("Select your role:"); // Ask user to select their role
    System.out.println("1. Student");
    System.out.println("2. Staff");
    String roleChoice = sc.nextLine().trim();

    // Path to create the correct session depending on role choice.
    if (roleChoice.equals("1")) {
      runStudentSession(sc, manager);
    } else if (roleChoice.equals("2")) {
      runStaffSession(sc, manager);
    } else {
      System.out.println("[!] Invalid role selected. Exiting.");
    }

    sc.close(); // Release system resources by closing scanner.
  }

  /**
   * Manages staff menu session where staff are able to work on events.
   Repeat until the user picks option 5 to get out.
   */
  private static void runStaffSession(Scanner sc, EventManager manager) {
    String choice = "";
    while (!choice.equals("5")) {
      System.out.println("\n--- Staff Menu ---");
      System.out.println("1. Create Event");
      System.out.println("2. Update Event");
      System.out.println("3. Cancel Event");
      System.out.println("4. View Events");
      System.out.println("5. Exit");
      choice = sc.nextLine().trim();

      // Process menu selection for staff.
      switch (choice) {
        case "1": manager.createEvent();   break; // Create new event
        case "2": manager.updateEvent();   break; // Update existing event
        case "3": manager.cancelEvent();   break; // Cancel an existing event
        case "4": manager.viewAllEvents(); break; // Display events
        case "5": System.out.println("Exiting Staff Menu..."); break;
        default:  System.out.println("[!] Invalid option. Try again.");
      }
    }
  }

  /**
   Conducts student menu session, where students can see and enroll to events.
   Loops until the user selects option 5 to exit.
   */
  private static void runStudentSession(Scanner sc, EventManager manager) {
    String studentID = "STUDENT"; // Placeholder ID for student - from authentication

    String choice = "";
    while (!choice.equals("5")) {
      System.out.println("\n--- Student Menu ---"); //student menu options
      System.out.println("1. View Events");
      System.out.println("2. Register for Event");
      System.out.println("3. Cancel Registration");
      System.out.println("4. Search Events");
      System.out.println("5. Exit");
      choice = sc.nextLine().trim();

      switch (choice) {   // Process student menu choice.
        case "1": manager.viewAllEvents();            break;  // Display all events available.
        case "2": manager.studentRegister(studentID); break; // Register student for an event
        case "3": manager.studentCancel(studentID);   break; // Cancel student's registration
        case "4": manager.searchEvents();             break; //Search events by filter/keyword.
        case "5": System.out.println("Exiting Student Menu..."); break;
        default:  System.out.println("[!] Invalid option. Try again.");
      }
    }
  }
}
