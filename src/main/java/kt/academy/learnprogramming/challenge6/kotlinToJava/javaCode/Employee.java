package kt.academy.learnprogramming.challenge6.kotlinToJava.javaCode;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;

public class Employee {
    private String firstName;
    private String lastName;
    private int startYear;

    @JvmStatic
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalaryLast3Years(float[] salaryLast3Years) {
        this.salaryLast3Years = salaryLast3Years;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStartYear() {
        return startYear;
    }

    public float[] getSalaryLast3Years() {
        return salaryLast3Years;
    }

    private float[] salaryLast3Years;

    public Employee(String firstName, String lastName, int startYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startYear = startYear;
        this.salaryLast3Years = new float[3];
    }
}
