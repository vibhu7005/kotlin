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


//        int a = 65538;
//        char c = (char)a;
//        System.out.println(c);
//        System.out.println((int) c);

        String s1 = "ans";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s1 = s1.concat("lobo");
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);


        long startTime1 = System.currentTimeMillis();
        StringBuffer s2 = new StringBuffer("ans");
        for (int i = 0; i < 100000; i++) {
            s2.append("lobo");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime1);







    }

    void foo(Integer i ) {
        i = i + 9;
        System.out.println("foo changed value to" + i);
    }




}
