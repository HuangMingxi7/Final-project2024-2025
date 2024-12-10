public class Technician extends Person {
    private String specialization;

    public Technician(String name, String contactNumber, String specialization) {
        super(name, contactNumber);
        this.specialization = specialization;
    }

    public void repairBus(Bus bus) {
        System.out.println(getName() + " repaired Bus " + bus.getBusNumber());
    }

    @Override
    public String toString() {
        return super.toString() + ", Specialization: " + specialization;
    }
}
