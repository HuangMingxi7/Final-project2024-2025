import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<BusSchedule> schedules = new ArrayList<>();
        ArrayList<Passenger> passengers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Sample Data
        Manager manager = new Manager("Alice", "123-456-7890", "101");
        Bus bus = new Bus("B1", 50);
        BusSchedule schedule = new BusSchedule("S1", "08:00 AM", "10:00 AM", "B1");
        schedules.add(schedule);

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View Schedules");
            System.out.println("2. Add Schedule (Manager)");
            System.out.println("3. Book Ticket (Passenger)");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available Schedules:");
                    for (BusSchedule sched : schedules) {
                        System.out.println(sched);
                    }
                    break;

                case 2:
                    System.out.print("Enter Schedule ID: ");
                    String newId = scanner.nextLine();
                    System.out.print("Enter Departure Time: ");
                    String depTime = scanner.nextLine();
                    System.out.print("Enter Arrival Time: ");
                    String arrTime = scanner.nextLine();
                    System.out.print("Enter Bus Number: ");
                    String busNum = scanner.nextLine();
                    BusSchedule newSchedule = new BusSchedule(newId, depTime, arrTime, busNum);
                    manager.addSchedule(schedules, newSchedule);
                    break;

                case 3:
                    System.out.print("Enter Passenger Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Ticket ID: ");
                    String ticket = scanner.nextLine();
                    Passenger passenger = new Passenger(name, contact, ticket);
                    passengers.add(passenger);
                    passenger.bookTicket(schedule);
                    break;

                case 4:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
