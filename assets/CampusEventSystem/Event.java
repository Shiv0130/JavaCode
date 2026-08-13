import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Represents a single campus event.
 * Holds the participant list and waitlist.
 */
public class Event {

    private int eventID;
    private String eventName;
    private String eventDate; // dd/mm/yyyy
    private String eventTime; // HH:mm
    private String location;
    private int maxParticipants;

    /* registered students and those waiting */
    private ArrayList<String> registeredList;
    private Queue<String>     waitlist;

    private boolean cancelled;

    public Event(int eventID, String eventName, String eventDate,
                 String eventTime, String location, int maxParticipants) {
        this.eventID         = eventID;
        this.eventName       = eventName;
        this.eventDate       = eventDate;
        this.eventTime       = eventTime;
        this.location        = location;
        this.maxParticipants = maxParticipants;
        this.registeredList  = new ArrayList<>();
        this.waitlist        = new LinkedList<>();
        this.cancelled       = false;
    }

    // ---- Getters ----
    public int       getEventID()         { return eventID; }
    public String    getEventName()       { return eventName; }
    public String    getEventDate()       { return eventDate; }
    public String    getEventTime()       { return eventTime; }
    public String    getLocation()        { return location; }
    public int       getMaxParticipants() { return maxParticipants; }
    public boolean   isCancelled()        { return cancelled; }
    public ArrayList<String> getRegisteredList() { return registeredList; }
    public Queue<String>     getWaitlist()        { return waitlist; }

    // ---- Setters (used by staff for updates) ----
    public void setEventName(String eventName) { this.eventName = eventName; }
    public void setEventTime(String eventTime) { this.eventTime = eventTime; }
    public void setLocation(String location)   { this.location  = location; }
    public void setCancelled(boolean cancelled){ this.cancelled  = cancelled; }

    /* Check if there is space left */
    public boolean hasSpace() {
        return registeredList.size() < maxParticipants;
    }

    /* Register a student directly */
    public void registerStudent(String studentID) {
        registeredList.add(studentID);
    }

    /* Add to waitlist */
    public void addToWaitlist(String studentID) {
        waitlist.add(studentID);
    }

    /* Remove from registered list, returns true if found */
    public boolean removeRegistered(String studentID) {
        return registeredList.remove(studentID);
    }

    /* Remove from waitlist */
    public boolean removeFromWaitlist(String studentID) {
        return waitlist.remove(studentID);
    }

    /* Promote first person on waitlist to registered — returns their ID or null */
    public String promoteFromWaitlist() {
        if (!waitlist.isEmpty() && hasSpace()) {
            String promoted = waitlist.poll();
            registeredList.add(promoted);
            return promoted;
        }
        return null;
    }

    /* Check if a student is already registered or waitlisted */
    public boolean isRegistered(String studentID) {
        return registeredList.contains(studentID);
    }

    public boolean isWaitlisted(String studentID) {
        return waitlist.contains(studentID);
    }

    /* Nicely print event summary */
    public void printSummary() {
        System.out.println("--------------------------------------------");
        System.out.printf("ID: %d | %s%n", eventID, eventName);
        System.out.printf("Date: %s  Time: %s%n", eventDate, eventTime);
        System.out.printf("Location: %s%n", location);
        System.out.printf("Capacity: %d/%d  |  Waitlist: %d%n",
                registeredList.size(), maxParticipants, waitlist.size());
        if (cancelled) System.out.println("*** EVENT CANCELLED ***");
        System.out.println("--------------------------------------------");
    }

    /* Serialize to one line for file saving */
    public String toFileString() {
        // Format: id|name|date|time|location|max|registered(,sep)|waitlist(,sep)
        String reg  = String.join(",", registeredList);
        String wait = String.join(",", waitlist);
        return eventID + "|" + eventName + "|" + eventDate + "|" + eventTime
                + "|" + location + "|" + maxParticipants + "|"
                + (cancelled ? "1" : "0") + "|" + reg + "|" + wait;
    }

    /* Rebuild an Event object from a saved line */
    public static Event fromFileString(String line) {
        String[] parts = line.split("\\|", -1);
        int    id      = Integer.parseInt(parts[0]);
        String name    = parts[1];
        String date    = parts[2];
        String time    = parts[3];
        String loc     = parts[4];
        int    max     = Integer.parseInt(parts[5]);
        boolean cancel = parts[6].equals("1");

        Event e = new Event(id, name, date, time, loc, max);
        e.setCancelled(cancel);

        // restore registered list
        if (!parts[7].isEmpty()) {
            for (String s : parts[7].split(",")) e.registerStudent(s);
        }
        // restore waitlist
        if (!parts[8].isEmpty()) {
            for (String s : parts[8].split(",")) e.addToWaitlist(s);
        }
        return e;
    }
}
