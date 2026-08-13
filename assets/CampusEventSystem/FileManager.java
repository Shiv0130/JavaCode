import java.io.*;
import java.util.ArrayList;

/*
 * Handles saving and loading events to/from a flat text file.
 * Each line in the file = one event (pipe-delimited).
 */
public class FileManager {

    private static final String FILE_PATH = "events.txt";

    /* Save all events to disk */
    public static void saveEvents(ArrayList<Event> events) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Event e : events) {
                bw.write(e.toFileString());
                bw.newLine();
            }
        } catch (IOException ex) {
            System.out.println("[ERROR] Could not save events: " + ex.getMessage());
        }
    }

    /* Load events from disk — returns empty list if file not found */
    public static ArrayList<Event> loadEvents() {
        ArrayList<Event> events = new ArrayList<>();
        File f = new File(FILE_PATH);

        if (!f.exists()) return events; // first run, nothing saved yet

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    events.add(Event.fromFileString(line));
                }
            }
        } catch (IOException ex) {
            System.out.println("[ERROR] Could not load events: " + ex.getMessage());
        }
        return events;
    }
}
