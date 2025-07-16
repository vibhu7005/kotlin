package kt.interoperability.kotlinFromJava;

import java.io.IOException;
import java.sql.SQLOutput;

public class JavaCar {
    public static void main(String[] args) {
        char ch = 'a';
        double a = ch + 2;

        ch = (char) a;
        System.out.println(ch);
        Integer i = 15;
        JavaCar car = new JavaCar();
        car.foo(i);
        System.out.println("value of i is" + i);
    }

    void foo(Integer i ) {
        i = i + 9;
        System.out.println("foo changed value to" + i);
    }

}
