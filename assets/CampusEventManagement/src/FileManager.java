import java.io.*;        // imports for file reading and writing
import java.util.ArrayList; // ArrayList to hold the list of events

/* Handles saving and loading all event data to/from a flat text file
 * Each line in data/events.txt represents one complete event */
public class FileManager {

    private static final String DIR_PATH  = "data";             // folder where the file will be stored
    private static final String FILE_PATH = "src/data/events.txt";  // full relative path to the save file

    public static void saveEvents(ArrayList<Event> events) { // write all events to disk
        File dir = new File(DIR_PATH); // reference the data directory
        if (!dir.exists()) {           // create the folder if it does not already exist
            dir.mkdirs();              // mkdirs() also creates any missing parent directories
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) { // open file for writing; auto-closes
            for (Event e : events) { // loop through every event in the list
                bw.write(e.toFileString()); // convert event to pipe-delimited string and write it
                bw.newLine();              // each event goes on its own line
            }
        } catch (IOException ex) { // handle any file writing errors gracefully
            System.out.println("[ERROR] Could not save events: " + ex.getMessage());
        }
    }

    public static ArrayList<Event> loadEvents() { // read all saved events from disk on startup
        ArrayList<Event> events = new ArrayList<>(); // start with an empty list
        File f = new File(FILE_PATH);               // reference the save file

        if (!f.exists()) return events; // first run — no file yet, return empty list

        try (BufferedReader br = new BufferedReader(new FileReader(f))) { // open file for reading; auto-closes
            String line;
            while ((line = br.readLine()) != null) { // read line by line until the end of the file
                if (!line.trim().isEmpty()) {         // skip any blank lines
                    events.add(Event.fromFileString(line)); // rebuild the Event object from the line
                }
            }
        } catch (IOException ex) { // handle any file reading errors gracefully
            System.out.println("[ERROR] Could not load events: " + ex.getMessage());
        }
        return events; // return the restored list of events
    }
}