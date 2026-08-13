public class Student extends User {
    //Constructor initialize with userID and name, role: Student.

    public Student(String userID, String name) {
        super(userID, name, "Student");
    }

    //Shows the menu options peculiar to the student to the console.

    @Override
    public void showMenu() {
        System.out.println("\n---Student Menu---");
        System.out.println("1. View Events"); //Browse all open events
        System.out.println("2. Register for Event"); //Sign up for a selected event
        System.out.println("3. Cancel Registration"); //Withdraw from a registered event
        System.out.println("4. Search Events"); //Filter events by keyword or criteria
        System.out.println("5. Exit"); //End the session
    }
}
