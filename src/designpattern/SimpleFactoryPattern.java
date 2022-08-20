package designpattern;

import designpattern.factorypattern.car.Car;
import designpattern.factorypattern.carfactory.CarFactory;

public class SimpleFactoryPattern {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car car = carFactory.createCar("Hyundai");

        car.startEngine();
        car.accelerate();
        car.stop();
        car.stopEngine();
    }
}
