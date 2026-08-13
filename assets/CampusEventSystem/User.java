/*
 * Base class for all users in the system
 * Both Student and Staff extend this
 */
public abstract class User {

    protected String userID;
    protected String name;
    protected String role;

    public User(String userID, String name, String role) {
        this.userID = userID;
        this.name   = name;
        this.role   = role;
    }

    public String getUserID() { return userID; }
    public String getName()   { return name; }
    public String getRole()   { return role; }

    // Every user type must implement this to show their menu
    public abstract void showMenu();
}
