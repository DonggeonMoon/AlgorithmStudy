package designpattern;

import designpattern.factorypattern.car.Car;
import designpattern.factorypattern.carfactory.CarFactoryInterface;
import designpattern.factorypattern.carfactory.HyundaiCarFactory;

public class AbstactFactoryPattern {
    public static void main(String[] args) {
        CarFactoryInterface carFactoryInterface = new HyundaiCarFactory();
        Car car = carFactoryInterface.createCar();

        car.startEngine();
        car.accelerate();
        car.stop();
        car.stopEngine();
    }
}
