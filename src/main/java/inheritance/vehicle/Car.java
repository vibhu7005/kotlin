package inheritance.vehicle;


import kt.A;

import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle {
    public String engine;

    public static void fooo(Integer i) {
        System.out.println(i);
    }

    public static void main(String[] args) {
//        StringBuffer s = new StringBuffer("hulk");
//        Integer i =12;
//        fooo(i);
//        i = 13;
//        System.out.println(i);
//        ArrayList<Integer> x = new ArrayList<>();
//        x.add(4);
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Student());

        List<String> strings = new ArrayList<>();
        strings.add("RAMA");
        List<Object> objects = new ArrayList<>();
        objects.add(4);
        strings.addAll((List)objects);
        System.out.println(strings.size());
    }



}


