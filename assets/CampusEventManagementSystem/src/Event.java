import java.util.ArrayList; //Is one of many events in the event management system.

public class Event {

    private int eventID; // Unique identifier for the event
    private String eventName; // Name of the event
    private String eventDate; // Date of the event
    private String eventTime; // Time of the event
    private String location; // Place or venue of the event
    private int maxParticipants; // Number of students that can be registered in maximum

    private ArrayList<String> registeredList; // Students confirmed for the event
    private ArrayList<String> waitlist; // Students waiting in case a spot opens up

    private boolean cancelled; // Indicates whether the event has been canceled

    public Event(int eventID, String eventName, String eventDate,
                 String eventTime, String location, int maxParticipants) {
        this.eventID = eventID; //Unique ID for the event
        this.eventName = eventName; //Name of the event
        this.eventDate = eventDate; //Date of the event
        this.eventTime = eventTime; //Time of the event
        this.location = location; // Location where the event is held
        this.maxParticipants = maxParticipants; //Maximum number of participants allowed
        this.registeredList = new ArrayList<>();
        this.waitlist = new ArrayList<>();
        this.cancelled = false;
    }
    // Getters
    public int getEventID() { return eventID; }
    public String getEventName() { return eventName; }
    public String getEventDate() { return eventDate; }
    public String getEventTime() { return eventTime; }
    public String getLocation() { return location; }
    public int getMaxParticipants() { return maxParticipants; }
    public boolean isCancelled() { return cancelled; }
    public ArrayList<String> getRegisteredList() { return registeredList; }
    public ArrayList<String> getWaitlist() { return waitlist; }

    // Setters
    public void setEventName(String eventName) { this.eventName = eventName; }
    public void setEventTime(String eventTime) { this.eventTime = eventTime; }
    public void setLocation(String location) { this.location = location; }
    public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }

    // Registration Logic
    public boolean hasSpace() {
        return registeredList.size() < maxParticipants;
    }

    public void registerStudent(String studentID) {
        registeredList.add(studentID);
    }

    public void addToWaitlist(String studentID) {
        waitlist.add(studentID);
    }

    public boolean removeRegistered(String studentID) {
        return registeredList.remove(studentID);
    }

    public boolean removeFromWaitlist(String studentID) {
        return waitlist.remove(studentID);
    }

    public String promoteFromWaitlist() {
        if (!waitlist.isEmpty() && hasSpace()) {
            String promoted = waitlist.remove(0);
            registeredList.add(promoted);
            return promoted;
        }
        return null;
    }

    public boolean isRegistered(String studentID) {
        return registeredList.contains(studentID);
    }

    public boolean isWaitlisted(String studentID) {
        return waitlist.contains(studentID);
    } // // Display & File I/O

    public void printSummary() {
        System.out.println("ID:" + eventID
                + " | Name:" + eventName
                + " | Date:" + eventDate
                + " | Time:" + eventTime
                + " | Location:" + location
                + " | Registered:" + registeredList.size()
                + " | Waitlist:" + waitlist.size());
    }

    public String toFileString() {
        String reg = "";
        for (int i = 0; i < registeredList.size(); i++) {
            reg += registeredList.get(i);
            if (i < registeredList.size() - 1) reg += ",";
        }

        String wait = "";
        for (int i = 0; i < waitlist.size(); i++) {
            wait += waitlist.get(i);
            if (i < waitlist.size() - 1) wait += ",";
        }
        //An ASCII string of the entire state of an event.

        return eventID + "|" + eventName + "|" + eventDate + "|" + eventTime
                + "|" + location + "|" + maxParticipants + "|"
                + (cancelled ? "1" : "0") + "|" + reg + "|" + wait;
    }
    
    // Split on pipes, keeping empty trailing fields
    public static Event fromFileString(String line) {
        String[] parts = line.split("\\|", -1);
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        String date = parts[2];
        String time = parts[3];
        String loc = parts[4];
        int max = Integer.parseInt(parts[5]);
        boolean cancel = parts[6].equals("1");

        Event e = new Event(id, name, date, time, loc, max);
        e.setCancelled(cancel);

        // Restore registered students if any exist
        if (!parts[7].isEmpty()) {
            for (String s : parts[7].split(",")) e.registerStudent(s);
        }

        // Restore waitlisted students if any exist
        if (!parts[8].isEmpty()) {
            for (String s : parts[8].split(",")) e.addToWaitlist(s);
        }

        return e;
    }
}