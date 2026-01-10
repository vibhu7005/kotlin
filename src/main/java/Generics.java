import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Xyz obj = new Xyz("abc", 34);
        modify(obj);
        System.out.println(obj.second);
        List<Dog> dogList = new ArrayList<>();
        Dog dog = new Dog();
        acceptAnimals(dogList);
        acceptAnimal(dog);
    }

    static void modify(Xyz x) {
        x.second = "lop";
    }

    //covariance
    static void acceptAnimals(List<? extends Animal> animalList) {
        Animal dog = new Animal();
    }

    static void acceptAnimal(Animal animal) {

    }



}

class Cat extends Animal{}


class Xyz<T,E> {
    final T first;
    E second;
    public Xyz(T first, E second) {
        this.first = first;
        this.second = second;
    }


    void calc() {
        Integer a = Integer.valueOf(45);
        Runnable run = new Runnable() {

            @Override
            public void run() {
                 ;//1908
            }
        };

        Thread thread = new Thread(run);
        thread.start();
    }
}




