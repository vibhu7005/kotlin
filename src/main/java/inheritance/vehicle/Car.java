package inheritance.vehicle;

import kt.academy.learnprogramming.challenge2.oop.C;


public class Car extends Vehicle {
    public String engine;

    public static void fooo(StringBuffer s) {
        s.append("fdfd");
    }

    public static void main(String[] args) {
        int x = 4;
        StringBuffer s = new StringBuffer("hulk");
        fooo(s);
        System.out.println(s);

    }



}
