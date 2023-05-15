package kt.academy.learnprogramming.challenge6.JavaToKotlin;

public class Main {
    public static void main(String[] args) {
        KotlinCodeKt.sayHelloToJava("student");
        Employee employee = new Employee("John", "Smith", 2010);
        employee.setStartYear(2009);
        Challenge.INSTANCE.doMath(5, 4);
        employee.takesDefault("arg1", "arg2");
    }
}
