////My code
//import java.io.*;
//
//public class Main {
//    public static void main(String[] args) {
//
//        String filepath = "source.txt";
//        String textContent = "";
//        try(FileWriter writer = new FileWriter(filepath)){
//            writer.write(textContent);
//            System.out.println("File has been written");
//
//
//
//
//        } catch(FileNotFoundException e){
//            System.out.println("File cannot be found");
//
//        }
//        catch(IOException e){
//            System.out.println("Invalid input");
//        }
//
//        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
//            String line;
//            while ((line= reader.readLine()!=null)){
//                System.out.println(line);
//            }
//
//        }
//        catch(FileNotFoundException e){
//            System.out.println("Cannot locate file");
//        }
//        }
//    }

//CORRECT CODE

import java.io.*;

public  class Main {

    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";
        String sampleText = "Hello World!\nThis is a sample text file.\nIt contains multiple lines of text.\nUsed for demonstrating Java I/O operations.";

        // Step a: Create and write to source.txt using FileOutputStream
        writeToFile(sourceFile, sampleText);

        // Step b: Read contents of source.txt using FileInputStream
        System.out.println("\n--- Reading from source.txt using FileInputStream ---");
        readFromFile(sourceFile);

        // Step c: Copy contents to destination.txt using buffered streams
        copyFileWithBufferedStreams(sourceFile, destinationFile);

        // Step d: Verify destination.txt content
        System.out.println("\n--- Verifying destination.txt content ---");
        readFromFile(destinationFile);
    }

    /**
     * Creates a text file and writes sample text using FileOutputStream
     */
    public static void writeToFile(String filename, String content) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            // Convert string to bytes for OutputStream
            byte[] contentBytes = content.getBytes();
            fos.write(contentBytes);
            System.out.println("Successfully wrote content to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file " + filename + ": " + e.getMessage());
        }
    }

    /**
     * Reads file contents using FileInputStream and displays on console
     */
    public static void readFromFile(String filename) {
        try (FileInputStream fis = new FileInputStream(filename)) {
            int byteData;
            System.out.println("Content of " + filename + ":");
            // Read byte by byte and convert to character
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }
            System.out.println(); // Add newline at end
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading file " + filename + ": " + e.getMessage());
        }
    }

    /**
     * Copies file content using BufferedInputStream and BufferedOutputStream
     */
    public static void copyFileWithBufferedStreams(String sourceFile, String destinationFile) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            byte[] buffer = new byte[1024]; // Buffer for better performance
            int bytesRead;

            // Read chunks of data and write to destination
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println("Successfully copied " + sourceFile + " to " + destinationFile);

        } catch (FileNotFoundException e) {
            System.err.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}