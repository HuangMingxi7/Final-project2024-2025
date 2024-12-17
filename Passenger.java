public class Passenger extends Person {
    private String ticketId;

    public Passenger(String name, String contactNumber, String ticketId) {
        super(name, contactNumber);
        this.ticketId = ticketId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void bookTicket(BusSchedule schedule) {
        System.out.println(getName() + " booked a ticket for Bus " 
                           + schedule.getBusNumber() + " at " + schedule.getDepartureTime());
    }

    public void cancelTicket() {
        System.out.println(getName() + " canceled their ticket.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Ticket ID: " + ticketId;
    }
}
