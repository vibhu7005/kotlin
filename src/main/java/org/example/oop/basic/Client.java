package org.example.oop.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static java.util.Arrays.*;

public class Client {
    public static void main(String [] args) {
//        Student student = new Student();
//        student.name = "Alok";
//        student.psp = 90;
//
//        Student bestStudent = new Student();
//        bestStudent.name = "Rahul";
//        bestStudent.psp = 88;
        //System.out.println(bestStudent);
        Integer x = 34;
        Double c = (double) x;
        System.out.println(c.getClass().getName());
        int arr [] = {1,3,5,7,9,0};
        System.out.println(arr[3]);
        List<Integer> list = Arrays.asList(3,4,5);
        int numerator = 45;
        int denominator = 34;
        System.out.println(numerator + "divided by " + denominator + "is" + numerator/denominator);
        char k = 65;
        char f = 'a';
        int y = f;
        System.out.println("hi " + y);
    }
}
