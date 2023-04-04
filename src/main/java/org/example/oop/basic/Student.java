package org.example.oop.basic;

public class Student {
    String name;
    int rollNo;
    Batch batch;
    double psp;

    void attendClass() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", batch=" + batch +
                ", psp=" + psp +
                '}';
    }

    void chooseMentor(String mentorName) {
        System.out.println(name + "mentor name is " + mentorName);
    }
}
