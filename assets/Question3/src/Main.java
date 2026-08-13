//import java.util.Scanner;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//import java.util.Date;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.List;
//import java.util.ArrayList;
//import java.text.SimpleDateFormat;
//
//class TrainSchedule {
//    private String trainId;
//    private String trainName;
//    private String departureStation;
//    private String arrivalStation;
//    private Date departureTime;
//    private Date arrivalTime;
//    private int platform;
//    private boolean isCancelled;
//
//    public TrainSchedule(String trainId, String trainName, String departureStation,
//                         String arrivalStation, Date departureTime, Date arrivalTime,
//                         int platform) {
//        this.trainId = trainId;
//        this.trainName = trainName;
//        this.departureStation = departureStation;
//        this.arrivalStation = arrivalStation;
//        this.departureTime = departureTime;
//        this.arrivalTime = arrivalTime;
//        this.platform = platform;
//        this.isCancelled = false;
//    }
//
//    // Getters and setters
//    public String getTrainId() { return trainId; }
//    public String getTrainName() { return trainName; }
//    public String getDepartureStation() { return departureStation; }
//    public String getArrivalStation() { return arrivalStation; }
//    public Date getDepartureTime() { return departureTime; }
//    public Date getArrivalTime() { return arrivalTime; }
//    public int getPlatform() { return platform; }
//    public boolean isCancelled() { return isCancelled; }
//    public void cancel() { isCancelled = true; }
//
//    @Override
//    public String toString() {
//        return String.format("%-8s %-20s %-15s %-15s %-20tT %-20tT %-8d %-8s",
//                trainId, trainName, departureStation, arrivalStation,
//                departureTime, arrivalTime, platform, isCancelled ? "Yes" : "No");
//    }
//}
//
//class Station {
//    private String stationName;
//    private int totalPlatforms;
//    private Map<Integer, List<TrainSchedule>> platformSchedules;
//    private List<TrainSchedule> allSchedules;
//
//    public Station(String stationName, int totalPlatforms) {
//        this.stationName = stationName;
//        this.totalPlatforms = totalPlatforms;
//        this.platformSchedules = new HashMap<>();
//        this.allSchedules = new ArrayList<>();
//
//        for (int i = 1; i <= totalPlatforms; i++) {
//            platformSchedules.put(i, new ArrayList<>());
//        }
//    }
//
//    public synchronized boolean addSchedule(TrainSchedule schedule) {
//        int platform = schedule.getPlatform();
//
//        // Check if platform exists
//        if (platform < 1 || platform > totalPlatforms) {
//            return false;
//        }
//
//        // Check for platform availability
//        for (TrainSchedule existing : platformSchedules.get(platform)) {
//            if (!existing.isCancelled() &&
//                    ((schedule.getDepartureTime().after(existing.getDepartureTime()) &&
//                            schedule.getDepartureTime().before(existing.getArrivalTime())) ||
//                            (schedule.getArrivalTime().after(existing.getDepartureTime()) &&
//                                    schedule.getArrivalTime().before(existing.getArrivalTime())) ||
//                            (schedule.getDepartureTime().equals(existing.getDepartureTime()) ||
//                                    schedule.getArrivalTime().equals(existing.getArrivalTime())))) {
//                return false;
//            }
//        }
//
//        platformSchedules.get(platform).add(schedule);
//        allSchedules.add(schedule);
//        return true;
//    }
//
//    public synchronized boolean cancelSchedule(String trainId) {
//        for (TrainSchedule schedule : allSchedules) {
//            if (schedule.getTrainId().equals(trainId)) {
//                schedule.cancel();
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public List<TrainSchedule> getAllSchedules() {
//        return new ArrayList<>(allSchedules);
//    }
//
//    public List<TrainSchedule> getPlatformSchedules(int platform) {
//        return new ArrayList<>(platformSchedules.getOrDefault(platform, new ArrayList<>()));
//    }
//
//    public String getStationName() {
//        return stationName;
//    }
//
//    public int getTotalPlatforms() {
//        return totalPlatforms;
//    }
//}
//
//class TrainSimulator implements Runnable {
//    private TrainSchedule schedule;
//    private Station departureStation;
//    private Station arrivalStation;
//
//    public TrainSimulator(TrainSchedule schedule, Station departureStation, Station arrivalStation) {
//        this.schedule = schedule;
//        this.departureStation = departureStation;
//        this.arrivalStation = arrivalStation;
//    }
//
//    @Override
//    public void run() {
//        try {
//            // Simulate train arrival at departure station
//            long currentTime = System.currentTimeMillis();
//            long departureTime = schedule.getDepartureTime().getTime();
//            long arrivalTime = schedule.getArrivalTime().getTime();
//
//            if (currentTime < departureTime) {
//                long waitTime = departureTime - currentTime;
//                System.out.printf("[%tT] Train %s (%s) waiting to depart from %s platform %d\n",
//                        new Date(), schedule.getTrainId(), schedule.getTrainName(),
//                        departureStation.getStationName(), schedule.getPlatform());
//                Thread.sleep(waitTime);
//            }
//
//            // Departure
//            System.out.printf("[%tT] Train %s (%s) DEPARTING from %s platform %d to %s\n",
//                    new Date(), schedule.getTrainId(), schedule.getTrainName(),
//                    departureStation.getStationName(), schedule.getPlatform(),
//                    arrivalStation.getStationName());
//
//            // Travel time
//            long travelTime = arrivalTime - departureTime;
//            if (travelTime > 0) {
//                Thread.sleep(travelTime / 1000); // Scale down for simulation
//            }
//
//            // Arrival
//            System.out.printf("[%tT] Train %s (%s) ARRIVING at %s\n",
//                    new Date(), schedule.getTrainId(), schedule.getTrainName(),
//                    arrivalStation.getStationName());
//
//        } catch (InterruptedException e) {
//            System.out.printf("Train %s (%s) simulation interrupted\n",
//                    schedule.getTrainId(), schedule.getTrainName());
//        }
//    }
//}
//
// class PRASATrainScheduler {
//    private Map<String, Station> stations;
//    private List<TrainSchedule> allSchedules;
//    private ScheduledExecutorService executorService;
//    private Scanner scanner;
//
//    public PRASATrainScheduler() {
//        this.stations = new HashMap<>();
//        this.allSchedules = new ArrayList<>();
//        this.executorService = Executors.newScheduledThreadPool(10);
//        this.scanner = new Scanner(System.in);
//
//        // Initialize with some stations
//        initializeStations();
//    }
//
//    private void initializeStations() {
//        addStation("Cape Town", 12);
//        addStation("Johannesburg", 15);
//        addStation("Pretoria", 10);
//        addStation("Durban", 8);
//        addStation("Port Elizabeth", 6);
//    }
//
//    public void addStation(String name, int platforms) {
//        stations.put(name, new Station(name, platforms));
//        System.out.println("Added station: " + name + " with " + platforms + " platforms");
//    }
//
//    public void addTrainSchedule() {
//        System.out.println("\n--- Add New Train Schedule ---");
//
//        System.out.print("Enter Train ID: ");
//        String trainId = scanner.nextLine();
//
//        System.out.print("Enter Train Name: ");
//        String trainName = scanner.nextLine();
//
//        System.out.print("Departure Station: ");
//        String departureStation = scanner.nextLine();
//        if (!stations.containsKey(departureStation)) {
//            System.out.println("Station not found!");
//            return;
//        }
//
//        System.out.print("Arrival Station: ");
//        String arrivalStation = scanner.nextLine();
//        if (!stations.containsKey(arrivalStation)) {
//            System.out.println("Station not found!");
//            return;
//        }
//
//        System.out.print("Departure Time (yyyy-MM-dd HH:mm): ");
//        String departureStr = scanner.nextLine();
//        Date departureTime = parseDateTime(departureStr);
//
//        System.out.print("Arrival Time (yyyy-MM-dd HH:mm): ");
//        String arrivalStr = scanner.nextLine();
//        Date arrivalTime = parseDateTime(arrivalStr);
//
//        if (departureTime == null || arrivalTime == null || arrivalTime.before(departureTime)) {
//            System.out.println("Invalid date/time input!");
//            return;
//        }
//
//        System.out.print("Platform Number at " + departureStation + ": ");
//        int platform = Integer.parseInt(scanner.nextLine());
//
//        TrainSchedule schedule = new TrainSchedule(trainId, trainName, departureStation,
//                arrivalStation, departureTime, arrivalTime,
//                platform);
//
//        if (stations.get(departureStation).addSchedule(schedule)) {
//            allSchedules.add(schedule);
//            System.out.println("Train schedule added successfully!");
//
//            // Start train simulation thread
//            long delay = departureTime.getTime() - System.currentTimeMillis();
//            if (delay > 0) {
//                executorService.schedule(
//                        new TrainSimulator(schedule, stations.get(departureStation),
//                                stations.get(arrivalStation)),
//                        delay, TimeUnit.MILLISECONDS);
//            }
//        } else {
//            System.out.println("Failed to add schedule. Platform may be occupied at that time.");
//        }
//    }
//
//    public void cancelTrainSchedule() {
//        System.out.println("\n--- Cancel Train Schedule ---");
//        System.out.print("Enter Train ID to cancel: ");
//        String trainId = scanner.nextLine();
//
//        boolean cancelled = false;
//        for (Station station : stations.values()) {
//            if (station.cancelSchedule(trainId)) {
//                cancelled = true;
//            }
//        }
//
//        if (cancelled) {
//            System.out.println("Train schedule cancelled successfully!");
//        } else {
//            System.out.println("Train schedule not found!");
//        }
//    }
//
//    public void viewAllSchedules() {
//        System.out.println("\n--- All Train Schedules ---");
//        System.out.printf("%-8s %-20s %-15s %-15s %-20s %-20s %-8s %-8s\n",
//                "TrainID", "Train Name", "Departure", "Arrival",
//                "Departure Time", "Arrival Time", "Platform", "Cancelled");
//
//        for (TrainSchedule schedule : allSchedules) {
//            System.out.println(schedule);
//        }
//    }
//
//    public void viewStationSchedules() {
//        System.out.println("\n--- Station Schedules ---");
//        System.out.print("Enter Station Name: ");
//        String stationName = scanner.nextLine();
//
//        if (!stations.containsKey(stationName)) {
//            System.out.println("Station not found!");
//            return;
//        }
//
//        Station station = stations.get(stationName);
//        System.out.println("\nSchedules for " + stationName + " station:");
//        System.out.printf("%-8s %-20s %-15s %-15s %-20s %-20s %-8s %-8s\n",
//                "TrainID", "Train Name", "Departure", "Arrival",
//                "Departure Time", "Arrival Time", "Platform", "Cancelled");
//
//        for (TrainSchedule schedule : station.getAllSchedules()) {
//            System.out.println(schedule);
//        }
//
//        // Show platform-wise schedules
//        System.out.println("\nPlatform-wise schedules:");
//        for (int i = 1; i <= station.getTotalPlatforms(); i++) {
//            List<TrainSchedule> platformSchedules = station.getPlatformSchedules(i);
//            if (!platformSchedules.isEmpty()) {
//                System.out.println("\nPlatform " + i + ":");
//                for (TrainSchedule schedule : platformSchedules) {
//                    System.out.println("  " + schedule);
//                }
//            }
//        }
//    }
//
//    private Date parseDateTime(String dateTimeStr) {
//        try {
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//            return formatter.parse(dateTimeStr);
//        } catch (Exception e) {
//            System.out.println("Error parsing date. Using current time instead.");
//            return new Date(); // Fallback to current time
//        }
//    }
//
//    public void shutdown() {
//        executorService.shutdown();
//        try {
//            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
//                executorService.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            executorService.shutdownNow();
//        }
//        scanner.close();
//    }
//
//    public static void main(String[] args) {
//        PRASATrainScheduler scheduler = new PRASATrainScheduler();
//
//        boolean running = true;
//        while (running) {
//            System.out.println("\n=== PRASA Train Scheduling System ===");
//            System.out.println("1. Add Train Schedule");
//            System.out.println("2. Cancel Train Schedule");
//            System.out.println("3. View All Schedules");
//            System.out.println("4. View Station Schedules");
//            System.out.println("5. Exit");
//            System.out.print("Enter your choice: ");
//
//            try {
//                int choice = Integer.parseInt(scheduler.scanner.nextLine());
//
//                switch (choice) {
//                    case 1:
//                        scheduler.addTrainSchedule();
//                        break;
//                    case 2:
//                        scheduler.cancelTrainSchedule();
//                        break;
//                    case 3:
//                        scheduler.viewAllSchedules();
//                        break;
//                    case 4:
//                        scheduler.viewStationSchedules();
//                        break;
//                    case 5:
//                        running = false;
//                        break;
//                    default:
//                        System.out.println("Invalid choice!");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Please enter a valid number!");
//            }
//        }
//
//        scheduler.shutdown();
//        System.out.println("System shutdown completed.");
//    }
//}

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

class TrainSchedule {
    private String trainId;
    private String trainName;
    private String departureStation;
    private String arrivalStation;
    private Date departureTime;
    private Date arrivalTime;
    private int platform;
    private boolean isCancelled;

    public TrainSchedule(String trainId, String trainName, String departureStation,
                         String arrivalStation, Date departureTime, Date arrivalTime,
                         int platform) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.platform = platform;
        this.isCancelled = false;
    } // End TrainSchedule constructor

    // Getters and setters
    public String getTrainId() { return trainId; }
    public String getTrainName() { return trainName; }
    public String getDepartureStation() { return departureStation; }
    public String getArrivalStation() { return arrivalStation; }
    public Date getDepartureTime() { return departureTime; }
    public Date getArrivalTime() { return arrivalTime; }
    public int getPlatform() { return platform; }
    public boolean isCancelled() { return isCancelled; }
    public void cancel() { isCancelled = true; }

    @Override
    public String toString() {
        return String.format("%-8s %-20s %-15s %-15s %-20tT %-20tT %-8d %-8s",
                trainId, trainName, departureStation, arrivalStation,
                departureTime, arrivalTime, platform, isCancelled ? "Yes" : "No");
    } // End toString method
} // End TrainSchedule class

class Station {
    private String stationName;
    private int totalPlatforms;
    private Map<Integer, List<TrainSchedule>> platformSchedules;
    private List<TrainSchedule> allSchedules;

    public Station(String stationName, int totalPlatforms) {
        this.stationName = stationName;
        this.totalPlatforms = totalPlatforms;
        this.platformSchedules = new HashMap<>();
        this.allSchedules = new ArrayList<>();

        for (int i = 1; i <= totalPlatforms; i++) {
            platformSchedules.put(i, new ArrayList<>());
        }
    } // End Station constructor

    public synchronized boolean addSchedule(TrainSchedule schedule) {
        int platform = schedule.getPlatform();

        // Check if platform exists
        if (platform < 1 || platform > totalPlatforms) {
            return false;
        }

        // Check for platform availability
        for (TrainSchedule existing : platformSchedules.get(platform)) {
            if (!existing.isCancelled() &&
                    ((schedule.getDepartureTime().after(existing.getDepartureTime()) &&
                            schedule.getDepartureTime().before(existing.getArrivalTime())) ||
                            (schedule.getArrivalTime().after(existing.getDepartureTime()) &&
                                    schedule.getArrivalTime().before(existing.getArrivalTime())) ||
                            (schedule.getDepartureTime().equals(existing.getDepartureTime()) ||
                                    schedule.getArrivalTime().equals(existing.getArrivalTime())))) {
                return false;
            }
        }

        platformSchedules.get(platform).add(schedule);
        allSchedules.add(schedule);
        return true;
    } // End addSchedule method

    public synchronized boolean cancelSchedule(String trainId) {
        for (TrainSchedule schedule : allSchedules) {
            if (schedule.getTrainId().equals(trainId)) {
                schedule.cancel();
                return true;
            }
        }
        return false;
    } // End cancelSchedule method

    public List<TrainSchedule> getAllSchedules() {
        return new ArrayList<>(allSchedules);
    } // End getAllSchedules method

    public List<TrainSchedule> getPlatformSchedules(int platform) {
        return new ArrayList<>(platformSchedules.getOrDefault(platform, new ArrayList<>()));
    } // End getPlatformSchedules method

    public String getStationName() {
        return stationName;
    } // End getStationName method

    public int getTotalPlatforms() {
        return totalPlatforms;
    } // End getTotalPlatforms method
} // End Station class

class TrainSimulator implements Runnable {
    private TrainSchedule schedule;
    private Station departureStation;
    private Station arrivalStation;

    public TrainSimulator(TrainSchedule schedule, Station departureStation, Station arrivalStation) {
        this.schedule = schedule;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
    } // End TrainSimulator constructor

    @Override
    public void run() {
        try {
            // Simulate train arrival at departure station
            long currentTime = System.currentTimeMillis();
            long departureTime = schedule.getDepartureTime().getTime();
            long arrivalTime = schedule.getArrivalTime().getTime();

            if (currentTime < departureTime) {
                long waitTime = departureTime - currentTime;
                System.out.printf("[%tT] Train %s (%s) waiting to depart from %s platform %d\n",
                        new Date(), schedule.getTrainId(), schedule.getTrainName(),
                        departureStation.getStationName(), schedule.getPlatform());
                Thread.sleep(waitTime);
            }

            // Departure
            System.out.printf("[%tT] Train %s (%s) DEPARTING from %s platform %d to %s\n",
                    new Date(), schedule.getTrainId(), schedule.getTrainName(),
                    departureStation.getStationName(), schedule.getPlatform(),
                    arrivalStation.getStationName());

            // Travel time
            long travelTime = arrivalTime - departureTime;
            if (travelTime > 0) {
                Thread.sleep(travelTime / 1000); // Scale down for simulation
            }

            // Arrival
            System.out.printf("[%tT] Train %s (%s) ARRIVING at %s\n",
                    new Date(), schedule.getTrainId(), schedule.getTrainName(),
                    arrivalStation.getStationName());

        } catch (InterruptedException e) {
            System.out.printf("Train %s (%s) simulation interrupted\n",
                    schedule.getTrainId(), schedule.getTrainName());
        }
    } // End run method
} // End TrainSimulator class

class PRASATrainScheduler {
    private Map<String, Station> stations;
    private List<TrainSchedule> allSchedules;
    private ScheduledExecutorService executorService;
    private Scanner scanner;

    public PRASATrainScheduler() {
        this.stations = new HashMap<>();
        this.allSchedules = new ArrayList<>();
        this.executorService = Executors.newScheduledThreadPool(10);
        this.scanner = new Scanner(System.in);

        // Initialize with some stations
        initializeStations();
    } // End PRASATrainScheduler constructor

    private void initializeStations() {
        addStation("Cape Town", 12);
        addStation("Johannesburg", 15);
        addStation("Pretoria", 10);
        addStation("Durban", 8);
        addStation("Port Elizabeth", 6);
    } // End initializeStations method

    public void addStation(String name, int platforms) {
        stations.put(name, new Station(name, platforms));
        System.out.println("Added station: " + name + " with " + platforms + " platforms");
    } // End addStation method

    public void addTrainSchedule() {
        System.out.println("\n--- Add New Train Schedule ---");

        System.out.print("Enter Train ID: ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Train Name: ");
        String trainName = scanner.nextLine();

        System.out.print("Departure Station: ");
        String departureStation = scanner.nextLine();
        if (!stations.containsKey(departureStation)) {
            System.out.println("Station not found!");
            return;
        }

        System.out.print("Arrival Station: ");
        String arrivalStation = scanner.nextLine();
        if (!stations.containsKey(arrivalStation)) {
            System.out.println("Station not found!");
            return;
        }

        System.out.print("Departure Time (yyyy-MM-dd HH:mm): ");
        String departureStr = scanner.nextLine();
        Date departureTime = parseDateTime(departureStr);

        System.out.print("Arrival Time (yyyy-MM-dd HH:mm): ");
        String arrivalStr = scanner.nextLine();
        Date arrivalTime = parseDateTime(arrivalStr);

        if (departureTime == null || arrivalTime == null || arrivalTime.before(departureTime)) {
            System.out.println("Invalid date/time input!");
            return;
        }

        System.out.print("Platform Number at " + departureStation + ": ");
        int platform = Integer.parseInt(scanner.nextLine());

        TrainSchedule schedule = new TrainSchedule(trainId, trainName, departureStation,
                arrivalStation, departureTime, arrivalTime,
                platform);

        if (stations.get(departureStation).addSchedule(schedule)) {
            allSchedules.add(schedule);
            System.out.println("Train schedule added successfully!");

            // Start train simulation thread
            long delay = departureTime.getTime() - System.currentTimeMillis();
            if (delay > 0) {
                executorService.schedule(
                        new TrainSimulator(schedule, stations.get(departureStation),
                                stations.get(arrivalStation)),
                        delay, TimeUnit.MILLISECONDS);
            }
        } else {
            System.out.println("Failed to add schedule. Platform may be occupied at that time.");
        }
    } // End addTrainSchedule method

    public void cancelTrainSchedule() {
        System.out.println("\n--- Cancel Train Schedule ---");
        System.out.print("Enter Train ID to cancel: ");
        String trainId = scanner.nextLine();

        boolean cancelled = false;
        for (Station station : stations.values()) {
            if (station.cancelSchedule(trainId)) {
                cancelled = true;
            }
        }

        if (cancelled) {
            System.out.println("Train schedule cancelled successfully!");
        } else {
            System.out.println("Train schedule not found!");
        }
    } // End cancelTrainSchedule method

    public void viewAllSchedules() {
        System.out.println("\n--- All Train Schedules ---");
        System.out.printf("%-8s %-20s %-15s %-15s %-20s %-20s %-8s %-8s\n",
                "TrainID", "Train Name", "Departure", "Arrival",
                "Departure Time", "Arrival Time", "Platform", "Cancelled");

        for (TrainSchedule schedule : allSchedules) {
            System.out.println(schedule);
        }
    } // End viewAllSchedules method

    public void viewStationSchedules() {
        System.out.println("\n--- Station Schedules ---");
        System.out.print("Enter Station Name: ");
        String stationName = scanner.nextLine();

        if (!stations.containsKey(stationName)) {
            System.out.println("Station not found!");
            return;
        }

        Station station = stations.get(stationName);
        System.out.println("\nSchedules for " + stationName + " station:");
        System.out.printf("%-8s %-20s %-15s %-15s %-20s %-20s %-8s %-8s\n",
                "TrainID", "Train Name", "Departure", "Arrival",
                "Departure Time", "Arrival Time", "Platform", "Cancelled");

        for (TrainSchedule schedule : station.getAllSchedules()) {
            System.out.println(schedule);
        }

        // Show platform-wise schedules
        System.out.println("\nPlatform-wise schedules:");
        for (int i = 1; i <= station.getTotalPlatforms(); i++) {
            List<TrainSchedule> platformSchedules = station.getPlatformSchedules(i);
            if (!platformSchedules.isEmpty()) {
                System.out.println("\nPlatform " + i + ":");
                for (TrainSchedule schedule : platformSchedules) {
                    System.out.println("  " + schedule);
                }
            }
        }
    } // End viewStationSchedules method

    private Date parseDateTime(String dateTimeStr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return formatter.parse(dateTimeStr);
        } catch (Exception e) {
            System.out.println("Error parsing date. Using current time instead.");
            return new Date(); // Fallback to current time
        }
    } // End parseDateTime method

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        scanner.close();
    } // End shutdown method

    public static void main(String[] args) {
        PRASATrainScheduler scheduler = new PRASATrainScheduler();

        boolean running = true;
        while (running) {
            System.out.println("\n=== PRASA Train Scheduling System ===");
            System.out.println("1. Add Train Schedule");
            System.out.println("2. Cancel Train Schedule");
            System.out.println("3. View All Schedules");
            System.out.println("4. View Station Schedules");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scheduler.scanner.nextLine());

                switch (choice) {
                    case 1:
                        scheduler.addTrainSchedule();
                        break;
                    case 2:
                        scheduler.cancelTrainSchedule();
                        break;
                    case 3:
                        scheduler.viewAllSchedules();
                        break;
                    case 4:
                        scheduler.viewStationSchedules();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }

        scheduler.shutdown();
        System.out.println("System shutdown completed.");
    } // End main method
} // End PRASATrainScheduler class5
