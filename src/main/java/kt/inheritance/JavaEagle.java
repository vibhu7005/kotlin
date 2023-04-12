package inheritance;

public class JavaEagle extends JavaBird {
    String name;
    public JavaEagle() {
        super("df");
        System.out.println("primary eagle const");
    }

    public JavaEagle(String name) {
        super("df",45);
        this.name = name;
        System.out.println("secondary eagle const");
    }
}
