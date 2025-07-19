package abstraction;

public class Cat extends Animal{
    @Override
    void eat() {
        System.out.println("cat eats");
    }

    @Override
    void sleep() {
        System.out.println("cat sleeps");
    }
}
