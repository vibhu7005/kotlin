package kt.interoperability.kotlinFromJava;

import java.io.IOException;
import java.sql.SQLOutput;

public class JavaCar {
    public static void main(String[] args) {

        Integer a = Integer.valueOf(1008);
        Integer i = Integer.valueOf(1008);
        if (a == i) System.out.println(true);
        else System.out.println("false");
    }

    void foo(Integer i ) {
        i = i + 9;
        System.out.println("foo changed value to" + i);
    }

}
