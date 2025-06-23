package kt.interoperability.kotlinFromJava;

import java.io.IOException;
import java.sql.SQLOutput;

public class JavaCar {
    public static void main(String[] args) {
       String a = "gyanendra";
       String b = new String("gyanendra");
       String c = b;
        System.out.println(b == c);
    }
}
