package kt.interoperability.kotlinFromJava;

import java.io.IOException;
import java.sql.SQLOutput;

public class JavaCar {
    public static void main(String[] args) {
//        String a = "hulk";
//        String b = "hulkman";
//        String s = a + "man";
//        String v = new String("hulkman");
//        System.out.println(s == b);


        int a = 65538;
        char c = (char)a;
        System.out.println(c);
        System.out.println((int) c);

    }

    void foo(Integer i ) {
        i = i + 9;
        System.out.println("foo changed value to" + i);
    }




}
