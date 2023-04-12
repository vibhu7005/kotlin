package inheritance;

public class JavaBird {
    String name;
    int weight;
    public JavaBird(String name) {
        System.out.println("primary bird const");
        this.name = name;
    }

    public JavaBird(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}
