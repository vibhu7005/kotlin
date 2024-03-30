package kt.academy.learnprogramming.challenge5;

import kotlin.collections.CollectionsKt;
import kt.academy.learnprogramming.challenge2.Array;
import kt.academy.learnprogramming.challenge2.oop.A;

import java.util.*;

public class Main {

    public static void main(String[] args) {
    }


    static void doSomething(List<Animala> animalas) {
        animalas.add(new Animala());
    }
}

class Animala {
    void foo() {
        System.out.println("lol");
    }
}

class Doga extends Animala implements Cloneable {
    int s;

    Doga() {
    }

    void foo() {
        System.out.println(s);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


//class
