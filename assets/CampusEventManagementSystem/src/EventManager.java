import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class EventManager {

    private ArrayList<Event> events;  //Master list of all events loaded from file
    private Scanner sc; // Shared scanner for reading user input

    public EventManager(Scanner sc) {
        this.sc = sc;
        this.events = FileManager.loadEvents();
    }
    /**
     Allows the user to add all the information on a new event,
     Checks the fields, and adds the event to the list and file.
     */

    public void createEvent() { //Prompt positive integer which is unique-Event ID

        int id = 0;
        while (true) {
            System.out.print("Event ID: ");
            String input = sc.nextLine().trim();
            if (!Validator.isPositiveInt(input)) { System.out.println("[!] ID must be a positive number."); continue; }
            id = Integer.parseInt(input);
            if (findEventByID(id) != null) { System.out.println("[!] That ID already exists."); continue; }
            break;
        }
        // Prompt for a non-empty event name

        String eventName = "";
        while (!Validator.isNotEmpty(eventName)) {
            System.out.print("Event Name: ");
            eventName = sc.nextLine().trim();
            if (!Validator.isNotEmpty(eventName)) System.out.println("[!] Name cannot be empty.");
        }
        // Prompt for a valid date in YYYY-MM-DD format

        String date = "";
        while (!Validator.isValidDate(date)) {
            System.out.print("Event Date (YYYY-MM-DD): ");
            date = sc.nextLine().trim();
            if (!Validator.isValidDate(date)) System.out.println("Invalid date format. Use YYYY-MM-DD.");
        }
        // Prompt for a valid time in HH:mm format

        String time = "";
        while (!Validator.isValidTime(time)) {
            System.out.print("Event Time (HH:mm): ");
            time = sc.nextLine().trim();
            if (!Validator.isValidTime(time)) System.out.println("Invalid time format. Use HH:mm.");
        }
        // Prompt for a location

        String location = "";
        while (!Validator.isNotEmpty(location)) {
            System.out.print("Location: ");
            location = sc.nextLine().trim();
            if (!Validator.isNotEmpty(location)) System.out.println("[!] Location cannot be empty.");
        }
        // Prompt for a positive max participant count

        int max = 0;
        while (max <= 0) {
            System.out.print("Max Participants: ");
            String input = sc.nextLine().trim();
            if (!Validator.isPositiveInt(input)) { System.out.println("[!] Must be a positive number."); continue; }
            max = Integer.parseInt(input);
        }

        Event newEvent = new Event(id, eventName, date, time, location, max);
        events.add(newEvent);
        FileManager.saveEvents(events);
        System.out.println("Event created successfully!");
    }
    //Enables changing the name, time, and/or location of an event.

    public void updateEvent() {
        System.out.print("Enter Event ID to update: ");
        String input = sc.nextLine().trim();
        if (!Validator.isPositiveInt(input)) { System.out.println("[!] Invalid ID."); return; }
        Event e = findEventByID(Integer.parseInt(input));
        if (e == null) { System.out.println("[!] Event not found."); return; }

        System.out.print("New Name (leave blank to skip): ");
        String newName = sc.nextLine().trim();

        System.out.print("New Time (HH:mm, leave blank to skip): ");
        String newTime = sc.nextLine().trim();

        System.out.print("New Location (leave blank to skip): ");
        String newLoc = sc.nextLine().trim();

        // Only implement changes on fields where the user has filled in.

        if (Validator.isNotEmpty(newName)) e.setEventName(newName);
        if (Validator.isNotEmpty(newTime) && Validator.isValidTime(newTime)) e.setEventTime(newTime);
        if (Validator.isNotEmpty(newLoc)) e.setLocation(newLoc);

        FileManager.saveEvents(events);
        System.out.println("Event updated successfully!");
    }
    //Marks an existing event as canceled if it hasn't been already.

    public void cancelEvent() {
        System.out.print("Enter Event ID to cancel: ");
        String input = sc.nextLine().trim();
        if (!Validator.isPositiveInt(input)) { System.out.println("[!] Invalid ID."); return; }
        Event e = findEventByID(Integer.parseInt(input));
        if (e == null) { System.out.println("[!] Event not found."); return; }

        if (e.isCancelled()) { System.out.println("[!] Event is already cancelled."); return; }

        e.setCancelled(true);
        FileManager.saveEvents(events);
        System.out.println("Event cancelled successfully.");
    }

    public void viewAllEvents() {
        if (events.isEmpty()) { System.out.println("No events available."); return; }

        System.out.println("--- View Events ---");
        System.out.println("Sort by: 1. Name  2. Date  3. None");
        String sortChoice = sc.nextLine().trim();

        ArrayList<Event> display = new ArrayList<>(events);

        if (sortChoice.equals("1")) {
            for (int i = 0; i < display.size() - 1; i++) {
                for (int j = 0; j < display.size() - i - 1; j++) {
                    if (display.get(j).getEventName().compareTo(display.get(j + 1).getEventName()) > 0) {
                        Event temp = display.get(j);
                        display.set(j, display.get(j + 1));
                        display.set(j + 1, temp);
                    }
                }
            }
        } else if (sortChoice.equals("2")) {
            for (int i = 0; i < display.size() - 1; i++) {
                for (int j = 0; j < display.size() - i - 1; j++) {
                    if (display.get(j).getEventDate().compareTo(display.get(j + 1).getEventDate()) > 0) {
                        Event temp = display.get(j);
                        display.set(j, display.get(j + 1));
                        display.set(j + 1, temp);
                    }
                }
            }
        } else if (!sortChoice.equals("3")) {
            System.out.println("Invalid choice, showing unsorted events.");
        }

        for (Event e : display) {
            if (!e.isCancelled()) e.printSummary();
        }
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
            for (int i = 0; i < events.size() - 1; i++) {
                for (int j = 0; j < events.size() - i - 1; j++) {
                    if (events.get(j).getEventName().compareTo(events.get(j + 1).getEventName()) > 0) {
                        Event temp = events.get(j);
                        events.set(j, events.get(j + 1));
                        events.set(j + 1, temp);
                    }
                }
            }
            System.out.println("[OK] Sorted by name.");

        } else if (choice.equals("2")) {
            for (int i = 0; i < events.size() - 1; i++) {
                for (int j = 0; j < events.size() - i - 1; j++) {
                    if (events.get(j).getEventDate().compareTo(events.get(j + 1).getEventDate()) > 0) {
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
        viewAllEvents();
    }

    public void studentRegister(String studentID) {
        System.out.print("Enter Event ID to register: ");
        String input = sc.nextLine().trim();
        if (!Validator.isPositiveInt(input)) { System.out.println("[!] Invalid ID."); return; }
        Event e = findEventByID(Integer.parseInt(input));
        if (e == null) { System.out.println("Event not found."); return; }

        if (e.isCancelled()) { System.out.println("[!] This event has been cancelled."); return; }
        if (e.isRegistered(studentID)) { System.out.println("Already registered or waitlisted."); return; }
        if (e.isWaitlisted(studentID)) { System.out.println("Already registered or waitlisted."); return; }

        if (e.hasSpace()) {
            e.registerStudent(studentID);
            FileManager.saveEvents(events);
            System.out.println("Registered successfully.");
        } else {
            e.addToWaitlist(studentID);
            FileManager.saveEvents(events);
            System.out.println("Event full, added to waitlist.");
        }
    }

    public void studentCancel(String studentID) {
        System.out.print("Enter Event ID to cancel registration: ");
        String input = sc.nextLine().trim();
        if (!Validator.isPositiveInt(input)) { System.out.println("[!] Invalid ID."); return; }
        Event e = findEventByID(Integer.parseInt(input));
        if (e == null) { System.out.println("Event not found."); return; }

        if (e.removeRegistered(studentID)) {
            FileManager.saveEvents(events);

            WaitlistPromoter promoter = new WaitlistPromoter(e, studentID);
            promoter.start();

            try { promoter.join(); } catch (InterruptedException ex) { }

            FileManager.saveEvents(events);
            System.out.println("Cancellation processed.");

        } else if (e.removeFromWaitlist(studentID)) {
            FileManager.saveEvents(events);
            System.out.println("Cancellation processed.");
        } else {
            System.out.println("You are not registered for this event.");
        }
    }
    //Displays all events the student is currently registered or waitlisted for.

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
    //Searches for non-canceled events matching a name keyword or date string.

    public void searchEvents() {
        System.out.print("Enter Event Name or Date (YYYY-MM-DD): ");
        String term = sc.nextLine().trim().toLowerCase();

        boolean found = false;
        for (Event e : events) {
            boolean match = e.getEventName().toLowerCase().contains(term)
                    || e.getEventDate().contains(term);

            if (match && !e.isCancelled()) { e.printSummary(); found = true; }
        }

        if (!found) System.out.println("No events match your search.");
    }
    //Searches the events list for an event with the given ID.

    private Event findEventByID(int id) {
        for (Event e : events) {
            if (e.getEventID() == id) return e;
        }
        return null;
    }
    //Helper method that reads an Event ID that is entered by a user and gives back the corresponding event.

    private Event getEventByInput() {
        System.out.print("Enter Event ID: ");
        String input = sc.nextLine().trim();

        if (!Validator.isPositiveInt(input)) { System.out.println("[!] Invalid ID."); return null; } //The found event if input is invalid or event doesn't exist

        Event e = findEventByID(Integer.parseInt(input));
        if (e == null) System.out.println("[!] Event not found.");
        return e;
    }
}