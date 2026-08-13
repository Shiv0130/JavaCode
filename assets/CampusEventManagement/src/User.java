/* Base class for all users in the system
 * Both Student and Staff extend this class */
public abstract class User {

    protected String userID; // unique ID for the user e.g. ST001 or S101
    protected String name;   // full name of the user
    protected String role;   // either "Staff" or "Student"

    public User(String userID, String name, String role) { // constructor to initialise all fields
        this.userID = userID; // assign the provided ID to this object
        this.name   = name;   // assign the provided name
        this.role   = role;   // assign the role label (Staff or Student)
    }

    public String getUserID() { return userID; } // return this user's ID
    public String getName()   { return name; }   // return this user's name
    public String getRole()   { return role; }   // return this user's role

    // Every subclass must override this — shows their specific menu options
    public abstract void showMenu();
}