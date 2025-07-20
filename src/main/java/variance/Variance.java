package variance;

import java.util.ArrayList;
import java.util.List;

public class Variance {
    public static void main(String[] args) {
        Truck<Goods> truck = new Truck<Goods>();
        Cement cement = new Cement();
        truck.insert(cement);
        List<Cement> bags = new ArrayList<>();
        bags.add(new Cement());
        bags.add(new Cement());
        truck.insertAll(bags);
    }
    static class Truck<T> {
        List<T> items;

        void insert (T item) {
            items.add(item);
        }

        void insertAll(List<? extends T> items) {
            this.items.addAll(items);
        }

    }

    static class Goods {}
    static class Cement extends Goods {}


//    class Vehicle<T> {
//
//
//    }

//    class Human {}
//    class Student extends Human {}
}


