import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Core class that manages all event operations.
 * Staff and Student actions both go through here.
 */
public class EventManager {

    private ArrayList<Event> events;
    private Scanner          sc;

    public EventManager(Scanner sc) {
        this.sc     = sc;
        this.events = FileManager.loadEvents(); // load saved data on startup
    }

    /* ====================================================
     *  STAFF OPERATIONS
     * ==================================================== */

    public void createEvent() {
        System.out.println("\n--- Create New Event ---");

        // Event ID
        int id = 0;
        while (true) {
            System.out.print("Enter Event ID (unique number): ");
            String input = sc.nextLine().trim();
            if (!Validator.isPositiveInt(input)) {
                System.out.println("[!] ID must be a positive number."); continue;
            }
            id = Integer.parseInt(input);
            if (findEventByID(id) != null) {
                System.out.println("[!] That ID already exists."); continue;
            }
            break;
        }

        // Event Name
        String eventName = "";
        while (!Validator.isNotEmpty(eventName)) {
            System.out.print("Enter Event Name: ");
            eventName = sc.nextLine().trim();
            if (!Validator.isNotEmpty(eventName)) System.out.println("[!] Name cannot be empty.");
        }

        // Date
        String date = "";
        while (!Validator.isValidDate(date)) {
            System.out.print("Enter Event Date (dd/mm/yyyy): ");
            date = sc.nextLine().trim();
            if (!Validator.isValidDate(date)) System.out.println("[!] Invalid date format.");
        }

        // Time
        String time = "";
        while (!Validator.isValidTime(time)) {
            System.out.print("Enter Event Time (HH:mm): ");
            time = sc.nextLine().trim();
            if (!Validator.isValidTime(time)) System.out.println("[!] Invalid time format.");
        }

        // Location
        String location = "";
        while (!Validator.isNotEmpty(location)) {
            System.out.print("Enter Location: ");
            location = sc.nextLine().trim();
            if (!Validator.isNotEmpty(location)) System.out.println("[!] Location cannot be empty.");
        }

        // Max participants
        int max = 0;
        while (max <= 0) {
            System.out.print("Enter Max Participants: ");
            String input = sc.nextLine().trim();
            if (!Validator.isPositiveInt(input)) {
                System.out.println("[!] Must be a positive number."); continue;
            }
            max = Integer.parseInt(input);
        }

        Event newEvent = new Event(id, eventName, date, time, location, max);
        events.add(newEvent);
        FileManager.saveEvents(events);
        System.out.println("[OK] Event '" + eventName + "' created successfully!");
    }

    public void updateEvent() {
        System.out.println("\n--- Update Event ---");
        Event e = getEventByInput();
        if (e == null) return;

        System.out.println("What would you like to update?");
        System.out.println("1. Event Name");
        System.out.println("2. Event Time");
        System.out.println("3. Location");
        System.out.print("Choose: ");
        String choice = sc.nextLine().trim();

        switch (choice) {
            case "1":
                System.out.print("New Event Name: ");
                String newName = sc.nextLine().trim();
                if (!Validator.isNotEmpty(newName)) { System.out.println("[!] Name cannot be empty."); return; }
                e.setEventName(newName);
                break;
            case "2":
                System.out.print("New Event Time (HH:mm): ");
                String newTime = sc.nextLine().trim();
                if (!Validator.isValidTime(newTime)) { System.out.println("[!] Invalid time."); return; }
                e.setEventTime(newTime);
                break;
            case "3":
                System.out.print("New Location: ");
                String newLoc = sc.nextLine().trim();
                if (!Validator.isNotEmpty(newLoc)) { System.out.println("[!] Location cannot be empty."); return; }
                e.setLocation(newLoc);
                break;
            default:
                System.out.println("[!] Invalid option.");
                return;
        }

        FileManager.saveEvents(events);
        System.out.println("[OK] Event updated.");
    }

    public void cancelEvent() {
        System.out.println("\n--- Cancel Event ---");
        Event e = getEventByInput();
        if (e == null) return;

        if (e.isCancelled()) {
            System.out.println("[!] Event is already cancelled.");
            return;
        }

        System.out.print("Are you sure you want to cancel '" + e.getEventName() + "'? (yes/no): ");
        String confirm = sc.nextLine().trim().toLowerCase();
        if (confirm.equals("yes")) {
            e.setCancelled(true);
            FileManager.saveEvents(events);
            System.out.println("[OK] Event cancelled.");
        } else {
            System.out.println("Cancellation aborted.");
        }
    }

    public void viewAllEvents() {
        System.out.println("\n--- All Events ---");
        if (events.isEmpty()) {
            System.out.println("No events found."); return;
        }
        for (Event e : events) e.printSummary();
    }

    public void viewParticipants() {
        System.out.println("\n--- View Participants ---");
        Event e = getEventByInput();
        if (e == null) return;

        System.out.println("\nEvent: " + e.getEventName());
        System.out.println("Registered (" + e.getRegisteredList().size() + "):");
        if (e.getRegisteredList().isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (String s : e.getRegisteredList()) System.out.println("  - " + s);
        }

        System.out.println("Waitlist (" + e.getWaitlist().size() + "):");
        if (e.getWaitlist().isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (String s : e.getWaitlist()) System.out.println("  - " + s);
        }
    }

    public void sortEvents() {
        System.out.println("\nSort by: 1. Event Name   2. Event Date");
        System.out.print("Choose: ");
        String choice = sc.nextLine().trim();

        if (choice.equals("1")) {
            events.sort(Comparator.comparing(Event::getEventName));
            System.out.println("[OK] Sorted by name.");
        } else if (choice.equals("2")) {
            // Sort by date: parse dd/mm/yyyy → yyyymmdd for correct ordering
            events.sort(Comparator.comparing(e -> {
                String[] parts = e.getEventDate().split("/");
                return parts[2] + parts[1] + parts[0]; // yyyymmdd
            }));
            System.out.println("[OK] Sorted by date.");
        } else {
            System.out.println("[!] Invalid option.");
            return;
        }
        viewAllEvents();
    }

    /* ====================================================
     *  STUDENT OPERATIONS
     * ==================================================== */

    public void studentRegister(String studentID) {
        System.out.println("\n--- Register for Event ---");
        viewAllEvents();

        Event e = getEventByInput();
        if (e == null) return;

        if (e.isCancelled()) {
            System.out.println("[!] This event has been cancelled."); return;
        }
        if (e.isRegistered(studentID)) {
            System.out.println("[!] You are already registered for this event."); return;
        }
        if (e.isWaitlisted(studentID)) {
            System.out.println("[!] You are already on the waitlist for this event."); return;
        }

        if (e.hasSpace()) {
            e.registerStudent(studentID);
            FileManager.saveEvents(events);
            System.out.println("[OK] You are now registered for '" + e.getEventName() + "'.");
        } else {
            e.addToWaitlist(studentID);
            FileManager.saveEvents(events);
            System.out.println("[OK] Event is full. You have been added to the waitlist for '" + e.getEventName() + "'.");
        }
    }

    public void studentCancel(String studentID) {
        System.out.println("\n--- Cancel Registration ---");
        Event e = getEventByInput();
        if (e == null) return;

        // Check registered list first
        if (e.removeRegistered(studentID)) {
            FileManager.saveEvents(events);

            // Fire off background thread to promote from waitlist
            WaitlistPromoter promoter = new WaitlistPromoter(e, studentID);
            promoter.start();

            try { promoter.join(); } catch (InterruptedException ex) { /* ignore */ }

            FileManager.saveEvents(events); // save again after possible promotion
        } else if (e.removeFromWaitlist(studentID)) {
            FileManager.saveEvents(events);
            System.out.println("[OK] You have been removed from the waitlist.");
        } else {
            System.out.println("[!] You are not registered or waitlisted for this event.");
        }
    }

    public void viewMyStatus(String studentID) {
        System.out.println("\n--- My Registration Status ---");
        boolean found = false;

        for (Event e : events) {
            if (e.isRegistered(studentID)) {
                System.out.println("Event: " + e.getEventName()
                        + " (" + e.getEventDate() + ") — Status: REGISTERED");
                found = true;
            } else if (e.isWaitlisted(studentID)) {
                System.out.println("Event: " + e.getEventName()
                        + " (" + e.getEventDate() + ") — Status: WAITLISTED");
                found = true;
            }
        }

        if (!found) System.out.println("You are not registered or waitlisted for any events.");
    }

    /* ====================================================
     *  SHARED OPERATIONS
     * ==================================================== */

    public void searchEvents() {
        System.out.println("\nSearch by: 1. Event Name   2. Event Date");
        System.out.print("Choose: ");
        String choice = sc.nextLine().trim();

        System.out.print("Enter search term: ");
        String term = sc.nextLine().trim().toLowerCase();

        boolean found = false;
        for (Event e : events) {
            boolean match = false;

            if (choice.equals("1") && e.getEventName().toLowerCase().contains(term)) match = true;
            else if (choice.equals("2") && e.getEventDate().contains(term)) match = true;

            if (match) {
                e.printSummary();
                found = true;
            }
        }

        if (!found) System.out.println("No events matched your search.");
    }

    /* ====================================================
     *  HELPER METHODS
     * ==================================================== */

    private Event findEventByID(int id) {
        for (Event e : events) {
            if (e.getEventID() == id) return e;
        }
        return null;
    }

    /* Prompt staff/student to enter an event ID and return the Event */
    private Event getEventByInput() {
        System.out.print("Enter Event ID: ");
        String input = sc.nextLine().trim();

        if (!Validator.isPositiveInt(input)) {
            System.out.println("[!] Invalid ID."); return null;
        }

        Event e = findEventByID(Integer.parseInt(input));
        if (e == null) System.out.println("[!] Event not found.");
        return e;
    }
}
