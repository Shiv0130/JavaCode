
//My version
//class Vehicles{
//    protected String brand;
//    protected int year;
//
//    Vehicles(String brand, int year){
//        this.brand = brand;
//        this.year = year;
//    }
//    public void startEngine(){
//        System.out.println("Starting Vehicles Engine");
//    }
//    public void display(){
//        System.out.println("The Brand: " + brand + " The year manufactured: " + year);
//    }
//}
//
////Single Level inheritence
//class Cars extends Vehicles{
//    protected int numdoors;
//    Cars(String brand, int year,int numdoors){
//        super(brand, year);
//        this.numdoors = numdoors;
//    }
//    @Override
//    public void startEngine(){
//        System.out.println("Starting Engine for Car");
//    }
//
//    @Override
//    public void display(){
//        System.out.println("The Brand: " + brand + " The year manufactured: " + year);
//    }
//
//    // Multi-level
//    class ElectricVehicles extends Cars{
//        private int carbatter;
//        super(brand,year,numdoors);
//        this.carbatter = carbatter;
//    }
//    @Override
//    public void startEngine(){
//        System.out.println("Starting Engine for Electric Vehicle");
//    }
//    @Override
//    public void display(){
//        System.out.println("The Brand: " + brand + " The year manufactured: " + year + "Number of doors: " + numdoors + "Charging batt" + carbatter + "KWH");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//     Vehicles v = new Vehicles("VW Polo", 2005);
//     Cars c = new Cars("VW Polo Sedan",2019,4);
//     Cars.ElectricVehicles e = new ElectricVehicles("VW Electric",2025,2.1);
//
//     Vehicles[] = vehicles{v,c,ev};
//     for(Vehicles vehicle:vehicles){
//         System.out.println("Car information about VW Industries\n");
//         vehicle.display();
//         vehicle.startEngine();
//     }
//    }
//}

//Correct version

// Base class for all vehicles
class Vehicles {
    // Protected variables accessible to subclasses
    protected String brand;
    protected int year;

    // Constructor to initialize base vehicle properties
    Vehicles(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Base method that can be overridden by subclasses
    public void startEngine() {
        System.out.println("Starting Vehicle Engine");
    }

    // Base display method that can be overridden by subclasses
    public void display() {
        System.out.println("The Brand: " + brand + " The year manufactured: " + year);
    }
}

// Single level inheritance - Cars extends Vehicles
class Cars extends Vehicles {
    // Additional property specific to Cars
    protected int numdoors;

    // Constructor that calls the parent constructor using super()
    Cars(String brand, int year, int numdoors) {
        super(brand, year);  // Call to parent constructor
        this.numdoors = numdoors;
    }

    // Method override - specialized implementation for Cars
    @Override
    public void startEngine() {
        System.out.println("Starting Engine for Cars");
    }

    // Method override - includes numdoors in display
    @Override
    public void display() {
        System.out.println("The Brand: " + brand + " The year manufactured: " + year + " Number of doors: " + numdoors);
    }
}

// Multi-level inheritance - ElectricVehicles extends Cars (which extends Vehicles)
class ElectricVehicles extends Cars {
    // Additional property specific to ElectricVehicles
    private int carrbatter;

    // Constructor that calls the parent (Cars) constructor
    ElectricVehicles(String brand, int year, int numdoors, int carrbatter) {
        super(brand, year, numdoors);  // Call to Cars constructor
        this.carrbatter = carrbatter;
    }

    // Method override - specialized implementation for electric vehicles
    @Override
    public void startEngine() {
        System.out.println("Starting Engine for Electric Vehicle");
    }

    // Method override - includes all properties from the inheritance chain
    @Override
    public void display() {
        System.out.println("The Brand: " + brand + " The year manufactured: " + year +
                " Number of doors: " + numdoors + " Charging batt: " + carrbatter + " KWH");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create instances of each vehicle type
        Vehicles v = new Vehicles("VW Polo", 2005);
        Cars c = new Cars("VW Polo Sedan", 2019, 4);
        ElectricVehicles ev = new ElectricVehicles("VW Electric", 2025, 2, 1);

        // Store all vehicle types in an array of the base type (polymorphism)
        Vehicles[] vehicles = {v, c, ev};

        // Loop through each vehicle and call its methods
        // Demonstrates polymorphism - the correct overridden method is called based on actual object type
        for(Vehicles vehicle : vehicles) {
            System.out.println("Car Information For VW Industries\n");
            vehicle.display();  // Will call the appropriate display() method for each object type
            vehicle.startEngine();  // Will call the appropriate startEngine() method for each object type
        }
    }
}