package designpattern.factorypattern.carfactory;

import designpattern.factorypattern.car.Car;
import designpattern.factorypattern.car.Kia;

public class KiaCarFactory implements CarFactoryInterface {
    @Override
    public Car createCar() {
        return new Kia();
    }
}
