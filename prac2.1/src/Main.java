import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Create Car");
            System.out.println("2. Create Bike");
            System.out.println("3. Create Truck");
            System.out.println("4. Start Vehicle");
            System.out.println("5. Stop Vehicle");
            System.out.println("6. Refuel Vehicle");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> createVehicle("Car");
                case 2 -> createVehicle("Bike");
                case 3 -> createVehicle("Truck");
                case 4 -> operateVehicle("start");
                case 5 -> operateVehicle("stop");
                case 6 -> refuelVehicle();
                case 7 -> System.exit(0);
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createVehicle(String type) {
        System.out.println("Enter name:");
        String make = scanner.nextLine();
        System.out.println("Enter model:");
        String model = scanner.nextLine();
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Vehicle vehicle;
        switch (type) {
            case "Car" -> vehicle = new Car(make, model, year);
            case "Bike" -> vehicle = new Bike(make, model, year);
            case "Truck" -> vehicle = new Truck(make, model, year);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        vehicles.add(vehicle);
        System.out.println(type + " created: " + vehicle.getDetails());
    }

    private static void operateVehicle(String action) {
        Vehicle vehicle = selectVehicle();
        if (vehicle != null) {
            if ("start".equals(action)) {
                vehicle.start();
            } else {
                vehicle.stop();
            }
        }
    }

    private static void refuelVehicle() {
        Vehicle vehicle = selectVehicle();
        if (vehicle instanceof Refuelable refuelable) {
            refuelable.refuel();
        } else {
            System.out.println("This vehicle cannot be refueled.");
        }
    }

    private static Vehicle selectVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return null;
        }

        System.out.println("Select a vehicle:");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + ". " + vehicles.get(i).getDetails());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        if (choice < 1 || choice > vehicles.size()) {
            System.out.println("Invalid selection.");
            return null;
        }
        return vehicles.get(choice - 1);
    }
}