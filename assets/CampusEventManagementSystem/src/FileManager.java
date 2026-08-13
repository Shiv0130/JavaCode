import java.io.*;
import java.util.ArrayList; //Reads and writes event data to plain text file.

public class FileManager {
    // URL to location of file in which event data is stored across sessions

    private static final String FILE_PATH = "src/events.txt";

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
    /**
     Adds all the events in the text file to an ArrayList.
     Returns a list of nothing, when the file is not present.
     Skips any blank lines to avoid parse errors.
     */

    public static ArrayList<Event> loadEvents() {
        ArrayList<Event> events = new ArrayList<>();
        File f = new File(FILE_PATH);

        // Empty file implies no data, then give out empty list.

        if (!f.exists()) return events;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) { // Skip blank lines
                    events.add(Event.fromFileString(line));
                }
            }
        } catch (IOException ex) {
            System.out.println("[ERROR] Could not load events: " + ex.getMessage());
        }

        return events;
    }
}
