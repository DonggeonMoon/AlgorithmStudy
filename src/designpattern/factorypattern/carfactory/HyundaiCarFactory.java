package designpattern.factorypattern.carfactory;

import designpattern.factorypattern.car.Car;
import designpattern.factorypattern.car.Hyundai;

public class HyundaiCarFactory implements CarFactoryInterface{
    @Override
    public Car createCar() {
        return new Hyundai();
    }
}
