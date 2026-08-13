/*
 * Staff user — can create, update, cancel events
 * and view all participants / waitlists
 */
public class Staff extends User {

    public Staff(String userID, String name) {
        super(userID, name, "Staff");
    }

    @Override
    public void showMenu() {
        System.out.println("\n========== STAFF MENU ==========");
        System.out.println("1. Create Event");
        System.out.println("2. Update Event");
        System.out.println("3. Cancel Event");
        System.out.println("4. View All Events");
        System.out.println("5. View Participants & Waitlist");
        System.out.println("6. Search Events");
        System.out.println("7. Sort Events");
        System.out.println("0. Exit");
        System.out.println("================================");
        System.out.print("Choose an option: ");
    }
}
