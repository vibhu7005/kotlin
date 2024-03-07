package kt.academy.learnprogramming.challenge5;

import kotlin.collections.CollectionsKt;
import kt.academy.learnprogramming.challenge2.Array;
import kt.academy.learnprogramming.challenge2.oop.A;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Animala> animalas = new ArrayList<>();
        animalas.add(new Animala());
        animalas.add(new Doga());
        List<Doga> dogList = new ArrayList<>();
//        doSomething(dogList);
    }


    static void doSomething(List<Animala> animalas) {
        animalas.add(new Animala());
    }
}

class Animala {
    void foo(){
        System.out.println("lol");
    }
}

class Doga extends Animala {
    void foo() {
        System.out.println("l2l");
    }
}




//class
