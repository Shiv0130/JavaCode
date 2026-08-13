////First set of code
//class Animals {
//    public void speak(){
//        System.out.println("This animal speaks");
//    }
//    public void move(){
//        System.out.println("This animal moves foward");
//    }
//
//    class Goose extends Animals{
//        public void speak(){
//            System.out.println("This animal speaks");
//        }
//        public void move(){
//            System.out.println("This animal moves forward");
//        }
//    }
//
//    class Lynx extends Animals{
//        public void speak(){
//            System.out.println("This animal speaks");
//        }
//        public void move(){
//            System.out.println("This animal moves foward");
//        }
//
//    }
//}
// //Seperate class and call it if you want:
//
//class Main{
//    public static void main(String[] args){
//        Animals animals = new Animals();
//        Goose goose = new Goose();
//        Lynx lynx = new Lynx();
//
//        goose.speak();
//        goose.move();
//        lynx.speak();
//        lynx.move();
//
//    }
//}

// Correction without constructors
// Base class for all animals
//class Animal {
//    // Base methods with default implementations
//    public void speak() {
//        System.out.println("This animal speaks");
//    }
//
//    public void move() {
//        System.out.println("This animal moves forward");
//    }
//}
//
//// Flying class with methods for flying objects
//class Flying {
//    // Method for flying objects
//    public void fly() {
//        System.out.println("This object flies");
//    }
//}
//
//// Goose class that extends Animal and Flying
//class Goose extends Animal {
//    // Override speak method to customize output for Goose
//    @Override
//    public void speak() {
//        System.out.println("This goose speaks");
//    }
//
//    // Override move method to customize output for Goose
//    @Override
//    public void move() {
//        System.out.println("This goose moves forward");
//    }
//
//    // Method for flying specific to Goose
//    public void fly() {
//        System.out.println("This goose flies");
//    }
//}
//
//// Lynx class that extends Animal
//class Lynx extends Animal {
//    // Override speak method to customize output for Lynx
//    @Override
//    public void speak() {
//        System.out.println("This lynx speaks");
//    }
//
//    // Override move method to customize output for Lynx
//    @Override
//    public void move() {
//        System.out.println("This lynx moves forward");
//    }
//}
//
//// Airplane class that extends Flying
//class Airplane extends Flying {
//    // Override fly method to customize output for Airplane
//    @Override
//    public void fly() {
//        System.out.println("This airplane flies");
//    }
//}
//
//// Main class to demonstrate the functionality
//public class Main {
//    public static void main(String[] args) {
//        // Create instances
//        Animal animal = new Animal();
//        Goose goose = new Goose();
//        Lynx lynx = new Lynx();
//        Airplane airplane = new Airplane();
//
//        // Test Animal behaviors
//        System.out.println("--- Animal Behaviors ---");
//        animal.speak();
//        animal.move();
//        goose.speak();
//        goose.move();
//        lynx.speak();
//        lynx.move();
//
//        // Test Flying behaviors
//        System.out.println("\n--- Flying Behaviors ---");
//        goose.fly();
//        airplane.fly();
//    }
//}

    // With constructors
// Base class for all animals
class Animal {
    // Protected fields
    protected String name;

    // Constructor
    Animal(String name) {
        this.name = name;
    }

    // Default constructor
    Animal() {
        this.name = "Unknown";
    }

    // Base methods with default implementations
    public void speak() {
        System.out.println(this.name + " speaks");
    }

    public void move() {
        System.out.println(this.name + " moves forward");
    }
}

// Flying class for objects that can fly
class Flying {
    protected String flightType;

    // Constructor
    Flying(String flightType) {
        this.flightType = flightType;
    }

    // Default constructor
    Flying() {
        this.flightType = "standard";
    }

    // Method for flying
    public void fly() {
        System.out.println("This object flies with " + flightType + " flight");
    }
}

// Goose class that extends Animal and has flying capability
class Goose extends Animal {
    // Additional properties specific to Goose
    private double wingSpan;
    private String flightType;

    // Constructor
    Goose(String name, double wingSpan, String flightType) {
        super(name); // Call to parent constructor
        this.wingSpan = wingSpan;
        this.flightType = flightType;
    }

    // Default constructor
    Goose() {
        super();
        this.wingSpan = 100.0;
        this.flightType = "flapping";
    }

    // Override speak method to customize output for Goose
    @Override
    public void speak() {
        System.out.println(name + " honks");
    }

    // Override move method to customize output for Goose
    @Override
    public void move() {
        System.out.println(name + " waddles forward");
    }

    // Fly method for Goose
    public void fly() {
        System.out.println(name + " flies with a wingspan of " + wingSpan + " cm using " + flightType + " flight");
    }
}

// Lynx class that extends Animal
class Lynx extends Animal {
    // Additional properties specific to Lynx
    private int speed;

    // Constructor
    Lynx(String name, int speed) {
        super(name); // Call to parent constructor
        this.speed = speed;
    }

    // Default constructor
    Lynx() {
        super();
        this.speed = 50;
    }

    // Override speak method to customize output for Lynx
    @Override
    public void speak() {
        System.out.println(name + " growls");
    }

    // Override move method to customize output for Lynx
    @Override
    public void move() {
        System.out.println(name + " moves forward at " + speed + " km/h");
    }
}

// Airplane class that extends Flying
class Airplane extends Flying {
    // Properties
    private String model;
    private int maxAltitude;

    // Constructor
    Airplane(String model, int maxAltitude, String flightType) {
        super(flightType); // Call to parent constructor
        this.model = model;
        this.maxAltitude = maxAltitude;
    }

    // Default constructor
    Airplane() {
        super();
        this.model = "Generic";
        this.maxAltitude = 30000;
    }

    // Override fly method to customize output for Airplane
    @Override
    public void fly() {
        System.out.println("The " + model + " flies up to " + maxAltitude + " feet with " + flightType + " flight");
    }
}

// Main class to demonstrate the functionality
public class Main {
    public static void main(String[] args) {
        // Create instances with constructors
        Animal animal = new Animal("Generic Animal");
        Goose goose = new Goose("Canadian Goose", 150.5, "flapping");
        Lynx lynx = new Lynx("Eurasian Lynx", 70);
        Airplane airplane = new Airplane("Boeing 747", 35000, "jet");

        // Also create some with default constructors
        Goose wildGoose = new Goose();
        Airplane smallPlane = new Airplane();

        // Test Animal behaviors
        System.out.println("--- Animal Behaviors ---");
        animal.speak();
        animal.move();
        goose.speak();
        goose.move();
        lynx.speak();
        lynx.move();

        // Test Flying behaviors
        System.out.println("\n--- Flying Behaviors ---");
        goose.fly();
        wildGoose.fly();
        airplane.fly();
        smallPlane.fly();
    }
}



