package kt.interoperability.javaFromKotlin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Car {
    private String name;
    private String color;
    private int year;

    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + ", color='" + color + '\'' + ", year=" + year + '}';
    }

    public Car(String name, String color, int year) {
        this.name = name;
        this.color = color;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void provideVariableArgs (String ... strings) {

    }

    public void requirePrimitiveArray(int array[]) {}

    public void requiresObject(Object object){}

    public void requireRunnable(Runnable r) {
        new Thread(r).start();
    }

    static int x = 4;
}
