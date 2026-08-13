//1.My code
//import java.net.InetAddress;
//
//public class InetAddressExample {
//    public static void main(String[] args) throws Exception {
//        // ================== 1. LOCALHOST INFO ==================
//        //Get the InetAddress object
//
//        InetAddress localHost = InetAddress.getLocalHost();
//        System.out.println("===localhost Information===");
//        System.out.println("localhost Name:" + localHost.getHostName());
//        System.out.println("localhost IP Address" + localHost.getHostAddress());
//        System.out.println();
//
//        // ================== 2. Richfield Website INFO ==================
//        // Get the InetAddress object for the Richfield website
//
//        InetAddress richfield = InetAddress.getByName("https://www.richfield.ac.za/");
//        System.out.println("=== Richfield Website Information===");
//        System.out.println("Richfield Host Name:" +richfield.getHostName());
//        System.out.println("Richfield IP address:" + richfield.getHostAddress());
//        System.out.println();
//
//        // ================== 3. Facebook Multiple IPs ==================
//        // Facebook uses multiple IPs for load balancing (CDN)
//        InetAddress[]  facebookAddress = InetAddress.getAllByName("https://www.facebook.com/");
//        System.out.println("===Facebook Active IP address");
//        for(InetAddress fb : facebookAddress){
//            System.out.println("Facebook host name:" + fb.getHostName() + "IP address:" + fb.getHostAddress());
//        }
//
//    }
//}

//1. Corrected code
import java.net.InetAddress; // Import the InetAddress class used for IP/host lookups

public class InetAddressExample { // Declare a public class named InetAddressExample
    public static void main(String[] args) throws Exception { // Main entry point;
        // 'throws Exception' follows your lecturer's style (no try-catch)

        // ================== 1. LOCALHOST INFO ==================
        // Get the InetAddress object for the local machine
        InetAddress localHost = InetAddress.getLocalHost(); // Resolve the current computer's InetAddress (hostname + IP)
        System.out.println("=== Localhost Information ==="); // Header for readability
        System.out.println("Localhost Name: " + localHost.getHostName()); // Print the local machine's hostname
        System.out.println("Localhost IP Address: " + localHost.getHostAddress()); // Print the local machine's primary IP address
        System.out.println(); // Blank line for spacing

        // ================== 2. Richfield Website INFO ==================
        // NOTE: Only hostname, no "https://"
        InetAddress richfield = InetAddress.getByName("www.richfield.ac.za"); // DNS-lookup Richfield's hostname to an InetAddress
        System.out.println("=== Richfield Website Information ==="); // Header for readability
        System.out.println("Richfield Host Name: " + richfield.getHostName()); // Print the (possibly canonical) host name
        System.out.println("Richfield IP Address: " + richfield.getHostAddress()); // Print the resolved IPv4/IPv6 address as a string
        System.out.println(); // Blank line for spacing

        // ================== 3. Facebook Multiple IPs ==================
        // Get all IPs because Facebook uses multiple servers/CDNs
        InetAddress[] facebookAddress = InetAddress.getAllByName("www.facebook.com"); // Resolve all A/AAAA records for Facebook
        System.out.println("=== Facebook Active IP Addresses ==="); // Header for readability
        for (InetAddress fb : facebookAddress) { // Iterate over each resolved InetAddress
            System.out.println("Facebook Host Name: " + fb.getHostName() + // Print the host name associated with this address
                    " | IP Address: " + fb.getHostAddress()); // Print the corresponding IP address for this entry
        } // End for-each loop
    } // End main method
} // End class

