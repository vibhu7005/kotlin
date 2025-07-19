package abstraction;

public interface Sata {
    default void hunt() {
        System.out.println("hunt");
    }
}
