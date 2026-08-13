//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//Theory
//1. What is networking?
//1.Networking refers to the process of connecting two or more computers or devices together
// so they can share resources, such as files, applications, or internet access.
// Networks allow communication between devices using protocols (rules for communication) like TCP/IP,
// enabling data exchange efficiently and securely.

//2. Define the Networking Classes.
//2.Networking classes are categories of IP addresses used to define the size and purpose of a network.
// They are mainly used in IPv4 and are classified as:
//Class A:
//First octet: 1–126
//Supports very large networks (16 million hosts per network)
//Example: 10.0.0.1

//Class B:
//First octet: 128–191
//Supports medium-sized networks (65,000 hosts per network)
//Example: 172.16.0.1

//Class C:
//First octet: 192–223
//Supports small networks (254 hosts per network)
//Example: 192.168.1.1

//Class D:
//First octet: 224–239
//Used for multicast addresses

//Class E:
//First octet: 240–255
//Reserved for experimental use

//3.What is a Datagram Packet?
//A datagram packet is a basic unit of data sent over a network using connectionless protocols like
// UDP (User Datagram Protocol).
// Each packet contains the source and destination address, data, and error-checking information.
// Unlike TCP, datagrams do not guarantee delivery, order, or error correction—they are sent independently.

//4.What is InetAddress Class?
//In Java, the InetAddress class (from java.net package) represents an IP address of a device on a network. It provides methods to:
//Get the IP address of a host: InetAddress.getByName("www.google.com")
//Get the local host address: InetAddress.getLocalHost()
//Check if an address is reachable: isReachable(timeout)
//This class is essential for establishing network connections in Java programs.
    }
}