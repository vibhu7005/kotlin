package abstraction;


//there is a commonality between cat and animal
public class Cat extends Animal implements Sata,HuntingBehaviour{
    @Override
    void eat() {
        System.out.println("cat eats");
    }

    @Override
    void sleep() {
        System.out.println("cat sleeps");

    }

    @Override
    public void hunt() {
        Sata.super.hunt();
    }
}
