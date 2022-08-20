package designpattern.factorypattern.car;

public class Hyundai implements Car {
    @Override
    public void startEngine() {
        System.out.println("Start Hyundai engine.");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerate Hyundai.");
    }

    @Override
    public void stop() {
        System.out.println("Stop Hyundai");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stop Hyundai engine");
    }
}
