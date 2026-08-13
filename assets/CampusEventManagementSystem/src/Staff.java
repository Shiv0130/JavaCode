public class Staff extends User {
    /**
     * Denotes a system user-staff.
     * Staff have administrative privileges such as creating, updating and cancelling events as well as viewing participants.
     */

    public Staff(String userID, String name) {
        super(userID, name, "Staff");
    }
    //Shows the staff-specific menu with all the administrative options.

    @Override
    public void showMenu() {
        System.out.println("\n---Staff Menu---");
        System.out.println("1. Create Event");
        System.out.println("2. Update Event");
        System.out.println("3. Cancel Event");
        System.out.println("4. View Events");
        System.out.println("5. Exit");
    }
}
