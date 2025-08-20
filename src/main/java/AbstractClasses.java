abstract class Eating {
    void eat() {
        System.out.println("eat");
    }

    abstract void jump();
}


interface EatingBehaviour {
    default void eat() {
        System.out.println("eat");
    }
}

class def {

}


//public class AbstractClasses extends Eating {
//}

