public class Bike extends Vehicle {
    public Bike(String make, String model, int year) {
        super(make, model, year);
    }

    @Override
    public void start() {
        System.out.println(getDetails() + " is starting.");
    }

    @Override
    public void stop() {
        System.out.println(getDetails() + " is stopping.");
    }
}