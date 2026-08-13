/*
 * Student user — can view events, register, cancel, check status
 */
public class Student extends User {

    public Student(String userID, String name) {
        super(userID, name, "Student");
    }

    @Override
    public void showMenu() {
        System.out.println("\n========== STUDENT MENU ==========");
        System.out.println("1. View Available Events");
        System.out.println("2. Register for an Event");
        System.out.println("3. Cancel Registration");
        System.out.println("4. View My Registration Status");
        System.out.println("5. Search Events");
        System.out.println("0. Exit");
        System.out.println("==================================");
        System.out.print("Choose an option: ");
    }
}
