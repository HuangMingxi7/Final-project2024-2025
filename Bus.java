public class Bus {
    private String busNumber;
    private int capacity;

    
    public Bus(String busNumber, int capacity) {
        this.busNumber = busNumber;
        this.capacity = capacity;
    }

    
    public Bus(String busNumber) {
        this.busNumber = busNumber;
        this.capacity = 0; 
    }

    public String getBusNumber() {
        return busNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bus Number: " + busNumber + ", Capacity: " + capacity;
    }
}
