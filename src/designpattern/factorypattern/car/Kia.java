package designpattern.factorypattern.car;

public class Kia implements Car {
    @Override
    public void startEngine() {
        System.out.println("Start Kia engine.");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerate Kia.");
    }

    @Override
    public void stop() {
        System.out.println("Stop Kia");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stop Kia engine");
    }
}
