public class BusSchedule {
    private String scheduleId;
    private String departureTime;
    private String arrivalTime;
    private String busNumber;

   
    public BusSchedule(String scheduleId, String departureTime, String arrivalTime, String busNumber) {
        this.scheduleId = scheduleId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.busNumber = busNumber;
    }

    
    public String getScheduleId() {
        return scheduleId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getBusNumber() {
        return busNumber;
    }

    @Override
    public String toString() {
        return "Schedule ID: " + scheduleId + ", Departure: " + departureTime
               + ", Arrival: " + arrivalTime + ", Bus: " + busNumber;
    }
}
