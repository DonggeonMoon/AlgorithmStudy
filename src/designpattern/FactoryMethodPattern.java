package designpattern;

import designpattern.factorypattern.car.Car;
import designpattern.factorypattern.carfactory.HyundaiCarFactory;

public class FactoryMethodPattern {
    public static void main(String[] args) {
        HyundaiCarFactory hyundaiCarFactory = new HyundaiCarFactory();
        Car car = hyundaiCarFactory.createCar();

        car.startEngine();
        car.accelerate();
        car.stop();
        car.stopEngine();
    }
}
