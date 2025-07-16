package kt.interoperability.kotlinFromJava;

import java.io.IOException;
import java.sql.SQLOutput;

public class JavaCar {
    public static void main(String[] args) {
        char ch = 'a';
        double a = ch + 2;

        ch = (char) a;
        System.out.println(ch);
        boolean b = true;
        int f = b;

    }
}
