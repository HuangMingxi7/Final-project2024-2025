import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<BusSchedule> schedules = new ArrayList<>();
        ArrayList<Passenger> passengers = new ArrayList<>();
        ArrayList<Technician> technicians = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Manager manager = new Manager("MatthewHuang", "123456789", "Office101");
        schedules.add(new BusSchedule("1", "08:00 AM", "10:00 AM", "B1"));
        technicians.add(new Technician("Louis Tech", "555555555", "Engine Specialist"));

        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View Schedules");
            System.out.println("2. Add Schedule (Manager)");
            System.out.println("3. Book Ticket (Passenger)");
            System.out.println("4. Repair Bus (Technician)");
            System.out.println("5. View All Data");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    viewSchedules(schedules);
                    break;

                case 2:
                    addSchedule(schedules, manager, scanner);
                    break;

                case 3:
                    bookTicket(schedules, passengers, scanner);
                    break;

                case 4:
                    repairBus(technicians, schedules, scanner);
                    break;

                case 5:
                    viewAllData(schedules, passengers, technicians);
                    break;

                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void viewSchedules(ArrayList<BusSchedule> schedules) {
        System.out.println("Available Schedules:");
        for (BusSchedule schedule : schedules) {
            System.out.println(schedule);
        }
    }

    private static void addSchedule(ArrayList<BusSchedule> schedules, Manager manager, Scanner scanner) {
        System.out.print("Enter Schedule ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Departure Time: ");
        String departure = scanner.nextLine();
        System.out.print("Enter Arrival Time: ");
        String arrival = scanner.nextLine();
        System.out.print("Enter Bus Number: ");
        String busNumber = scanner.nextLine();

        BusSchedule newSchedule = new BusSchedule(id, departure, arrival, busNumber);
        manager.addSchedule(schedules, newSchedule);
    }

    private static void bookTicket(ArrayList<BusSchedule> schedules, ArrayList<Passenger> passengers, Scanner scanner) {
        if (schedules.isEmpty()) {
            System.out.println("No schedules available for booking.");
            return;
        }

        System.out.println("Choose a schedule to book a ticket:");
        for (int i = 0; i < schedules.size(); i++) {
            System.out.println((i + 1) + ". " + schedules.get(i));
        }

        try {
            System.out.print("Enter schedule number: ");
            int choice = Integer.parseInt(scanner.nextLine());

            BusSchedule chosenSchedule = schedules.get(choice - 1);
            System.out.print("Enter Passenger Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Contact Number: ");
            String contact = scanner.nextLine();
            System.out.print("Enter Ticket ID: ");
            String ticketId = scanner.nextLine();

            Passenger passenger = new Passenger(name, contact, ticketId);
            passenger.bookTicket(chosenSchedule);
            passengers.add(passenger);
        } catch (Exception e) {
            System.out.println("Invalid input! Returning to main menu.");
        }
    }

    private static void repairBus(ArrayList<Technician> technicians, ArrayList<BusSchedule> schedules, Scanner scanner) {
        if (technicians.isEmpty()) {
            System.out.println("No technicians available.");
            return;
        }

        System.out.println("Available Technicians:");
        for (int i = 0; i < technicians.size(); i++) {
            System.out.println((i + 1) + ". " + technicians.get(i));
        }

        System.out.println("Available Schedules:");
        for (int i = 0; i < schedules.size(); i++) {
            System.out.println((i + 1) + ". " + schedules.get(i));
        }

        try {
            System.out.print("Choose a technician (number, we only have 1 right now): ");
            int techChoice = Integer.parseInt(scanner.nextLine());
            System.out.print("Choose a schedule (number): ");
            int scheduleChoice = Integer.parseInt(scanner.nextLine());

            Technician tech = technicians.get(techChoice - 1);
            BusSchedule schedule = schedules.get(scheduleChoice - 1);

            tech.repairBus(new Bus(schedule.getBusNumber()));
        } catch (Exception e) {
            System.out.println("Invalid input! Returning to main menu.");
        }
    }

    private static void viewAllData(ArrayList<BusSchedule> schedules, ArrayList<Passenger> passengers,
                                    ArrayList<Technician> technicians) {
        System.out.println("\n--- All Schedules ---");
        for (BusSchedule s : schedules) System.out.println(s);

        System.out.println("\n--- All Passengers ---");
        for (Passenger p : passengers) System.out.println(p);

        System.out.println("\n--- All Technicians ---");
        for (Technician t : technicians) System.out.println(t);
    }
}
