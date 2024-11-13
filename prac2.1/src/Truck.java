public class Truck extends Vehicle implements Refuelable {
    public Truck(String make, String model, int year) {
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

    @Override
    public void refuel() {
        System.out.println(getDetails() + " is being refueled.");
    }
}