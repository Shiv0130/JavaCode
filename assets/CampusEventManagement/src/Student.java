/* Student user — extends User
 * Can view events, register, cancel, and check their own status */
public class Student extends User {

    public Student(String userID, String name) { // constructor passes role "Student" up to User
        super(userID, name, "Student"); // call the parent constructor with role set to Student
    }

    @Override
    public void showMenu() { // display the student-specific menu in the console
        System.out.println("\n========== STUDENT MENU ==========");
        System.out.println("1. View Available Events");         // see all events on the system
        System.out.println("2. Register for an Event");         // sign up using an Event ID
        System.out.println("3. Cancel Registration");           // cancel a registration or waitlist spot
        System.out.println("4. View My Registration Status");   // check registered or waitlisted events
        System.out.println("5. Search Events");                 // search by name or date
        System.out.println("0. Exit");                          // exit the system
        System.out.println("==================================");
        System.out.print("Choose an option: ");                 // prompt for input
    }
}