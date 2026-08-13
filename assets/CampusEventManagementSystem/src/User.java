//Class representing a generic system user
public abstract class User {

    protected String userID; // Unique identifier for the user
    protected String name; // Full name of the user
    protected String role; // Role assigned to the user

    // Constructor initializing the user with an ID, name, and role
    public User(String userID, String name, String role) {
        this.userID = userID;
        this.name = name;
        this.role = role;
    }

    public String getUserID() { return userID; } // Returns the user's ID
    public String getName() { return name; } // Returns the user's name
    public String getRole() { return role; } // Returns the user's role

    // Requires forces to provide their own logic of displaying menus.
    public abstract void showMenu();
}