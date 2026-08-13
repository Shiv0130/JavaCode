/* Staff user — extends User
 * Can create, update, cancel events and view all participants */
public class Staff extends User {

    public Staff(String userID, String name) { // constructor passes role "Staff" up to User
        super(userID, name, "Staff"); // call the parent constructor with role set to Staff
    }

    @Override
    public void showMenu() { // display the staff-specific menu in the console
        System.out.println("\n========== STAFF MENU ==========");
        System.out.println("1. Create Event");                // staff can create new events
        System.out.println("2. Update Event");                // staff can edit event details
        System.out.println("3. Cancel Event");                // staff can cancel an existing event
        System.out.println("4. View All Events");             // staff can see every event and its stats
        System.out.println("5. View Participants & Waitlist");// staff can see who is registered
        System.out.println("6. Search Events");               // search by name or date
        System.out.println("7. Sort Events");                 // sort events by name or date
        System.out.println("0. Exit");                        // exit the system
        System.out.println("================================");
        System.out.print("Choose an option: ");               // prompt for input
    }
}