import java.util.ArrayList;  // ArrayList to store all events
import java.util.Comparator; // Comparator used for sorting events
import java.util.Scanner;    // Scanner to read user input from the console

/* Core class that handles all event operations
 * Both Staff and Student actions are processed through here */
public class EventManager {

    private ArrayList<Event> events; // master list of all events in the system
    private Scanner          sc;     // shared Scanner passed in from Main

    public EventManager(Scanner sc) { // constructor receives the Scanner so we don't open multiple
        this.sc     = sc;
        this.events = FileManager.loadEvents(); // load previously saved events from file on startup
    }

    /* ====================================================
     *  STAFF OPERATIONS
     * ==================================================== */

    public void createEvent() { // staff — collect details and add a new event to the system
        System.out.println("\n--- Create New Event ---");

        // ---- Event ID ----
        int id = 0;
        while (true) { // keep asking until a valid unique ID is entered
            System.out.print("Enter Event ID (unique number): ");
            String input = sc.nextLine().trim();
            if (!Validator.isPositiveInt(input)) { System.out.println("[!] ID must be a positive number."); continue; }
            id = Integer.parseInt(input);
            if (findEventByID(id) != null) { System.out.println("[!] That ID already exists."); continue; }
            break; // valid unique ID — exit loop
        }

        // ---- Event Name ----
        String eventName = "";
        while (!Validator.isNotEmpty(eventName)) { // keep asking until non-empty
            System.out.print("Enter Event Name: ");
            eventName = sc.nextLine().trim();
            if (!Validator.isNotEmpty(eventName)) System.out.println("[!] Name cannot be empty.");
        }

        // ---- Date ----
        String date = "";
        while (!Validator.isValidDate(date)) { // keep asking until dd/mm/yyyy format is correct
            System.out.print("Enter Event Date (dd/mm/yyyy): ");
            date = sc.nextLine().trim();
            if (!Validator.isValidDate(date)) System.out.println("[!] Invalid date format. Use dd/mm/yyyy.");
        }

        // ---- Time ----
        String time = "";
        while (!Validator.isValidTime(time)) { // keep asking until HH:mm format is correct
            System.out.print("Enter Event Time (HH:mm): ");
            time = sc.nextLine().trim();
            if (!Validator.isValidTime(time)) System.out.println("[!] Invalid time format. Use HH:mm.");
        }

        // ---- Location ----
        String location = "";
        while (!Validator.isNotEmpty(location)) { // keep asking until non-empty
            System.out.print("Enter Location: ");
            location = sc.nextLine().trim();
            if (!Validator.isNotEmpty(location)) System.out.println("[!] Location cannot be empty.");
        }

        // ---- Max Participants ----
        int max = 0;
        while (max <= 0) { // keep asking until a positive number is entered
            System.out.print("Enter Max Participants: ");
            String input = sc.nextLine().trim();
            if (!Validator.isPositiveInt(input)) { System.out.println("[!] Must be a positive number."); continue; }
            max = Integer.parseInt(input);
        }

        Event newEvent = new Event(id, eventName, date, time, location, max); // create the new Event object
        events.add(newEvent);           // add it to the master list
        FileManager.saveEvents(events); // persist to file immediately
        System.out.println("[OK] Event '" + eventName + "' created successfully!");
    }

    public void updateEvent() { // staff — change the name, time, or location of an existing event
        System.out.println("\n--- Update Event ---");
        Event e = getEventByInput(); // ask for Event ID and retrieve the matching event
        if (e == null) return;       // exit if not found

        System.out.println("What would you like to update?");
        System.out.println("1. Event Name");
        System.out.println("2. Event Time");
        System.out.println("3. Location");
        System.out.print("Choose: ");
        String choice = sc.nextLine().trim();

        switch (choice) {
            case "1": // update the event name
                System.out.print("New Event Name: ");
                String newName = sc.nextLine().trim();
                if (!Validator.isNotEmpty(newName)) { System.out.println("[!] Name cannot be empty."); return; }
                e.setEventName(newName); // apply the change
                break;
            case "2": // update the event time
                System.out.print("New Event Time (HH:mm): ");
                String newTime = sc.nextLine().trim();
                if (!Validator.isValidTime(newTime)) { System.out.println("[!] Invalid time format."); return; }
                e.setEventTime(newTime); // apply the change
                break;
            case "3": // update the location
                System.out.print("New Location: ");
                String newLoc = sc.nextLine().trim();
                if (!Validator.isNotEmpty(newLoc)) { System.out.println("[!] Location cannot be empty."); return; }
                e.setLocation(newLoc); // apply the change
                break;
            default:
                System.out.println("[!] Invalid option."); return;
        }

        FileManager.saveEvents(events); // save the updated list to file
        System.out.println("[OK] Event updated successfully.");
    }

    public void cancelEvent() { // staff — mark an event as cancelled
        System.out.println("\n--- Cancel Event ---");
        Event e = getEventByInput(); // ask for Event ID and retrieve the matching event
        if (e == null) return;

        if (e.isCancelled()) { System.out.println("[!] Event is already cancelled."); return; } // prevent double-cancellation

        System.out.print("Are you sure you want to cancel '" + e.getEventName() + "'? (yes/no): ");
        String confirm = sc.nextLine().trim().toLowerCase(); // normalise to lowercase for comparison
        if (confirm.equals("yes")) {
            e.setCancelled(true);           // mark as cancelled
            FileManager.saveEvents(events); // persist the change
            System.out.println("[OK] Event cancelled.");
        } else {
            System.out.println("Cancellation aborted.");
        }
    }

    public void viewAllEvents() { // display a summary of every event in the system
        System.out.println("\n--- All Events ---");
        if (events.isEmpty()) { System.out.println("No events found."); return; }
        for (Event e : events) e.printSummary(); // call each event's built-in summary printer
    }

    public void viewParticipants() { // staff — list registered and waitlisted students for an event
        System.out.println("\n--- View Participants ---");
        Event e = getEventByInput();
        if (e == null) return;

        System.out.println("\nEvent: " + e.getEventName());
        System.out.println("Registered (" + e.getRegisteredList().size() + "):");
        if (e.getRegisteredList().isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (String s : e.getRegisteredList()) System.out.println("  - " + s); // print each registered ID
        }

        System.out.println("Waitlist (" + e.getWaitlist().size() + "):");
        if (e.getWaitlist().isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (String s : e.getWaitlist()) System.out.println("  - " + s); // print each waitlisted ID
        }
    }

    public void sortEvents() { // staff — sort and display all events by name or date
        System.out.println("\nSort by: 1. Event Name   2. Event Date");
        System.out.print("Choose: ");
        String choice = sc.nextLine().trim();

        if (choice.equals("1")) {
            // bubble sort by event name — Ch 3 bubble sort activity style
            for (int i = 0; i < events.size() - 1; i++) { // outer pass loop
                for (int j = 0; j < events.size() - i - 1; j++) { // inner comparison loop
                    if (events.get(j).getEventName().compareTo(events.get(j + 1).getEventName()) > 0) { // compare names
                        Event temp = events.get(j);       // store current
                        events.set(j, events.get(j + 1)); // shift next into current position
                        events.set(j + 1, temp);           // place stored into next position
                    }
                }
            }
            System.out.println("[OK] Sorted by name.");

        } else if (choice.equals("2")) {
            // bubble sort by date — convert dd/mm/yyyy to yyyymmdd string for correct ordering
            for (int i = 0; i < events.size() - 1; i++) { // outer pass loop
                for (int j = 0; j < events.size() - i - 1; j++) { // inner comparison loop
                    String[] d1 = events.get(j).getEventDate().split("/");     // split current date
                    String[] d2 = events.get(j + 1).getEventDate().split("/"); // split next date
                    String sortable1 = d1[2] + d1[1] + d1[0]; // rearrange to yyyymmdd
                    String sortable2 = d2[2] + d2[1] + d2[0]; // rearrange to yyyymmdd
                    if (sortable1.compareTo(sortable2) > 0) { // compare chronologically
                        Event temp = events.get(j);
                        events.set(j, events.get(j + 1));
                        events.set(j + 1, temp);
                    }
                }
            }
            System.out.println("[OK] Sorted by date.");

        } else {
            System.out.println("[!] Invalid option."); return;
        }
        viewAllEvents(); // display the sorted list
    }
    /* ====================================================
     *  STUDENT OPERATIONS
     * ==================================================== */

    public void studentRegister(String studentID) { // student — register for an event using its ID
        System.out.println("\n--- Register for Event ---");
        viewAllEvents(); // show all events so the student can choose

        Event e = getEventByInput();
        if (e == null) return;

        if (e.isCancelled())          { System.out.println("[!] This event has been cancelled."); return; }
        if (e.isRegistered(studentID)){ System.out.println("[!] You are already registered for this event."); return; }
        if (e.isWaitlisted(studentID)){ System.out.println("[!] You are already on the waitlist for this event."); return; }

        if (e.hasSpace()) {               // space available — register directly
            e.registerStudent(studentID); // add to the registered list
            FileManager.saveEvents(events);
            System.out.println("[OK] You are now registered for '" + e.getEventName() + "'.");
        } else {                          // event is full — place on waitlist instead
            e.addToWaitlist(studentID);
            FileManager.saveEvents(events);
            System.out.println("[OK] Event is full. You have been added to the waitlist for '" + e.getEventName() + "'.");
        }
    }

    public void studentCancel(String studentID) { // student — cancel their registration or waitlist entry
        System.out.println("\n--- Cancel Registration ---");
        Event e = getEventByInput();
        if (e == null) return;

        if (e.removeRegistered(studentID)) { // try removing from registered list first
            FileManager.saveEvents(events);

            // fire a background thread to promote the next waitlisted student automatically
            WaitlistPromoter promoter = new WaitlistPromoter(e, studentID);
            promoter.start(); // start the background promotion thread

            try { promoter.join(); } catch (InterruptedException ex) { } // wait for thread to finish before saving

            FileManager.saveEvents(events); // save again after promotion may have changed the lists

        } else if (e.removeFromWaitlist(studentID)) { // not registered — try removing from waitlist
            FileManager.saveEvents(events);
            System.out.println("[OK] You have been removed from the waitlist.");
        } else {
            System.out.println("[!] You are not registered or waitlisted for this event."); // not found in either list
        }
    }

    public void viewMyStatus(String studentID) { // student — see all events they are registered or waitlisted for
        System.out.println("\n--- My Registration Status ---");
        boolean found = false;

        for (Event e : events) { // loop through every event and check for this student
            if (e.isRegistered(studentID)) {
                System.out.println("Event: " + e.getEventName()
                        + " (" + e.getEventDate() + ") — Status: REGISTERED"); // confirmed spot
                found = true;
            } else if (e.isWaitlisted(studentID)) {
                System.out.println("Event: " + e.getEventName()
                        + " (" + e.getEventDate() + ") — Status: WAITLISTED"); // on the waitlist
                found = true;
            }
        }

        if (!found) System.out.println("You are not registered or waitlisted for any events."); // no results
    }

    /* ====================================================
     *  SHARED OPERATIONS
     * ==================================================== */

    public void searchEvents() { // search for events by name or date — available to both roles
        System.out.println("\nSearch by: 1. Event Name   2. Event Date");
        System.out.print("Choose: ");
        String choice = sc.nextLine().trim();

        System.out.print("Enter search term: ");
        String term = sc.nextLine().trim().toLowerCase(); // normalise to lowercase for case-insensitive matching

        boolean found = false;
        for (Event e : events) { // check every event for a match
            boolean match = false;
            if (choice.equals("1") && e.getEventName().toLowerCase().contains(term)) match = true; // partial name match
            else if (choice.equals("2") && e.getEventDate().contains(term)) match = true;           // date match

            if (match) { e.printSummary(); found = true; } // print matching event details
        }

        if (!found) System.out.println("No events matched your search."); // no matches found
    }

    /* ====================================================
     *  HELPER METHODS
     * ==================================================== */

    private Event findEventByID(int id) { // search the events list for a matching ID
        for (Event e : events) {
            if (e.getEventID() == id) return e; // return the event if found
        }
        return null; // return null if no match
    }

    private Event getEventByInput() { // prompt the user to enter an Event ID and return the matching event
        System.out.print("Enter Event ID: ");
        String input = sc.nextLine().trim();

        if (!Validator.isPositiveInt(input)) { System.out.println("[!] Invalid ID."); return null; } // reject non-numbers

        Event e = findEventByID(Integer.parseInt(input)); // look up the event by ID
        if (e == null) System.out.println("[!] Event not found."); // inform user if not found
        return e; // return event or null
    }
}