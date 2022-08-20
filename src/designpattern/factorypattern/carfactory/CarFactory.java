package designpattern.factorypattern.carfactory;

import designpattern.factorypattern.car.Car;
import designpattern.factorypattern.car.Hyundai;
import designpattern.factorypattern.car.Kia;

public class CarFactory {
    public Car createCar(String brandName) {
        switch (brandName) {
            case "Hyundai":
                return new Hyundai();
            case "Kia":
                return new Kia();
            default:
                return null;
        }
    }
}
