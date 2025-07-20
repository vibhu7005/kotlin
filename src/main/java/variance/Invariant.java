package variance;

import java.util.ArrayList;
import java.util.List;

public class Invariant {

    List<Dog> dogs = new ArrayList<>();
//    List<Animal> animals = dogs;
//    animals.add(new Cat())

    static class Dog extends Animal{}
    static class Cat extends Animal{}
    static class Animal{}
}
