package kt.interoperability.kotlinFromJava;

import java.io.IOException;
import java.sql.SQLOutput;

public class JavaCar {
    public static void main(String[] args) {
        Car car = new Car("blue", "bmw", 2011);
        System.out.println(car.getModel());
//        car.setColor("black");
        System.out.println(car.getColor());
        car.ride();
        StaticCar.topLevel();
        StaticCar.topLevel();
        StaticCar.printIt("looper");
        System.out.println(Car.getDoorCount());
        Car.Singelton.res();
        System.out.println(!Car.Singelton.isAuto);
//        try {
        try {
            car.doIo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        car.defaultArgs("fdf");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }
}
