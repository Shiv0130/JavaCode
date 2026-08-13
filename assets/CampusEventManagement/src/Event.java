import java.util.ArrayList; // ArrayList used to store both registered students and the waitlist

/* Represents a single campus event
 * Holds all event details, the registered participant list, and the waitlist */
public class Event {

    private int    eventID;         // unique numeric ID for this event
    private String eventName;       // name/title of the event
    private String eventDate;       // date in dd/mm/yyyy format
    private String eventTime;       // time in HH:mm format
    private String location;        // venue where the event will be held
    private int    maxParticipants; // maximum number of students that can register

    private ArrayList<String> registeredList; // stores IDs of confirmed registered students
    private ArrayList<String> waitlist;       // stores IDs of students waiting — first in, first out

    private boolean cancelled; // flag — true if a staff member has cancelled this event

    public Event(int eventID, String eventName, String eventDate,
                 String eventTime, String location, int maxParticipants) { // constructor to set all event fields
        this.eventID         = eventID;           // set the unique event ID
        this.eventName       = eventName;         // set the event name
        this.eventDate       = eventDate;         // set the event date (dd/mm/yyyy)
        this.eventTime       = eventTime;         // set the event time (HH:mm)
        this.location        = location;          // set the venue
        this.maxParticipants = maxParticipants;   // set the capacity limit
        this.registeredList  = new ArrayList<>(); // initialise empty registered list
        this.waitlist        = new ArrayList<>(); // initialise empty waitlist
        this.cancelled       = false;             // event is active by default
    }

    // ---- Getters ----
    public int       getEventID()         { return eventID; }         // return the event ID
    public String    getEventName()       { return eventName; }       // return the event name
    public String    getEventDate()       { return eventDate; }       // return the event date
    public String    getEventTime()       { return eventTime; }       // return the event time
    public String    getLocation()        { return location; }        // return the venue
    public int       getMaxParticipants() { return maxParticipants; } // return capacity limit
    public boolean   isCancelled()        { return cancelled; }       // return cancellation status
    public ArrayList<String> getRegisteredList() { return registeredList; } // return the registered list
    public ArrayList<String> getWaitlist()        { return waitlist; }       // return the waitlist

    // ---- Setters — used by staff when updating event details ----
    public void setEventName(String eventName) { this.eventName = eventName; } // update event name
    public void setEventTime(String eventTime) { this.eventTime = eventTime; } // update event time
    public void setLocation(String location)   { this.location  = location; }  // update venue
    public void setCancelled(boolean cancelled){ this.cancelled  = cancelled; } // mark as cancelled

    public boolean hasSpace() { // check if the event still has open spots
        return registeredList.size() < maxParticipants; // true if registered count is below max
    }

    public void registerStudent(String studentID) { // add a student directly to the registered list
        registeredList.add(studentID); // ArrayList.add() appends to the end
    }

    public void addToWaitlist(String studentID) { // place a student at the back of the waitlist
        waitlist.add(studentID); // add() appends to end — maintains first-in-first-out order
    }

    public boolean removeRegistered(String studentID) { // remove a student from the registered list
        return registeredList.remove(studentID); // returns true if found and removed
    }

    public boolean removeFromWaitlist(String studentID) { // remove a student from the waitlist
        return waitlist.remove(studentID); // returns true if found and removed
    }

    public String promoteFromWaitlist() { // move the first waitlisted student into the registered list
        if (!waitlist.isEmpty() && hasSpace()) { // only promote if someone is waiting and there is space
            String promoted = waitlist.remove(0); // remove(0) takes the first element — FIFO behaviour
            registeredList.add(promoted);          // add them to the registered list
            return promoted;                       // return their ID so it can be displayed
        }
        return null; // return null if no promotion was possible
    }

    public boolean isRegistered(String studentID) { // check if a student is already registered
        return registeredList.contains(studentID); // ArrayList.contains() checks for the value
    }

    public boolean isWaitlisted(String studentID) { // check if a student is already on the waitlist
        return waitlist.contains(studentID); // true if their ID is in the waitlist
    }

    public void printSummary() { // print a formatted summary of this event to the console
        System.out.println("--------------------------------------------");
        System.out.printf("ID: %d | %s%n", eventID, eventName);          // show ID and name
        System.out.printf("Date: %s  Time: %s%n", eventDate, eventTime); // show date and time
        System.out.printf("Location: %s%n", location);                   // show venue
        System.out.printf("Capacity: %d/%d  |  Waitlist: %d%n",          // show registration stats
                registeredList.size(), maxParticipants, waitlist.size());
        if (cancelled) System.out.println("*** EVENT CANCELLED ***");     // flag cancelled events
        System.out.println("--------------------------------------------");
    }

    public String toFileString() { // convert this event to a pipe-delimited line for file storage
        // build registered IDs as comma-separated string using a loop
        String reg = "";
        for (int i = 0; i < registeredList.size(); i++) {
            reg += registeredList.get(i); // append each student ID
            if (i < registeredList.size() - 1) reg += ","; // add comma between entries, not after the last
        }
        // build waitlist IDs as comma-separated string using a loop
        String wait = "";
        for (int i = 0; i < waitlist.size(); i++) {
            wait += waitlist.get(i); // append each waitlisted ID
            if (i < waitlist.size() - 1) wait += ","; // comma between entries only
        }
        return eventID + "|" + eventName + "|" + eventDate + "|" + eventTime
                + "|" + location + "|" + maxParticipants + "|"
                + (cancelled ? "1" : "0") + "|" + reg + "|" + wait; // 1 = cancelled, 0 = active
    }

    public static Event fromFileString(String line) { // rebuild an Event object from a saved file line
        String[] parts = line.split("\\|", -1);      // split on pipe; -1 keeps trailing empty strings
        int    id      = Integer.parseInt(parts[0]);  // parse the event ID
        String name    = parts[1];                    // read the event name
        String date    = parts[2];                    // read the date
        String time    = parts[3];                    // read the time
        String loc     = parts[4];                    // read the location
        int    max     = Integer.parseInt(parts[5]);  // parse max participants
        boolean cancel = parts[6].equals("1");        // 1 means cancelled

        Event e = new Event(id, name, date, time, loc, max); // create the base event object
        e.setCancelled(cancel); // restore the cancellation state

        if (!parts[7].isEmpty()) { // restore registered students if any were saved
            for (String s : parts[7].split(",")) e.registerStudent(s);
        }
        if (!parts[8].isEmpty()) { // restore waitlisted students if any were saved
            for (String s : parts[8].split(",")) e.addToWaitlist(s);
        }
        return e; // return the fully restored event
    }
}