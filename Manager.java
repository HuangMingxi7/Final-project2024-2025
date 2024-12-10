import java.util.ArrayList;

public class Manager extends Person {
    private String officeNumber;

    public Manager(String name, String contactNumber, String officeNumber) {
        super(name, contactNumber);
        this.officeNumber = officeNumber;
    }

    public void addSchedule(ArrayList<BusSchedule> schedules, BusSchedule schedule) {
        schedules.add(schedule);
        System.out.println("Schedule added: " + schedule.getScheduleId());
    }

    public void removeSchedule(ArrayList<BusSchedule> schedules, String scheduleId) {
        schedules.removeIf(schedule -> schedule.getScheduleId().equals(scheduleId));
        System.out.println("Schedule removed: " + scheduleId);
    }

    @Override
    public String toString() {
        return super.toString() + ", Office: " + officeNumber;
    }
}
