package abstraction;

public interface HuntingBehaviour {
    default void hunt() {
        System.out.println("hunt");
    }
}
