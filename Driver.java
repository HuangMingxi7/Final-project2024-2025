public class Driver extends Person {
    private String licenseNumber;

    public Driver(String name, String contactNumber, String licenseNumber) {
        super(name, contactNumber);
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void assignBus(Bus bus) {
        System.out.println(getName() + " is assigned to Bus " + bus.getBusNumber());
    }

    @Override
    public String toString() {
        return super.toString() + ", License: " + licenseNumber;
    }
}
