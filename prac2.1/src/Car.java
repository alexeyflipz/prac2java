public class Car extends Vehicle implements Refuelable {
    public Car(String make, String model, int year) {
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