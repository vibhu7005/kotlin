package variance;

import kt.A;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Exec exec = new Exec();
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());
        List<Dog> dogList = new ArrayList<>();
        exec.doo(dogList);
    }

    static class Animal{void eat(){}}
    static class Dog extends Animal{void bak(){}}
    static class Cat extends Animal{}
    static class Puppy extends Dog{}

    static class Exec {
        void doo(List<? super Dog> list) {
//            list.add(new

        }
    }

}

