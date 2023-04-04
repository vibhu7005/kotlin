package org.example.oop.basic;

import java.util.List;

public class Batch {
    List<Class> classes;
    String batchName;
    String topperName;
    List<Student> students;

    void startBatch() {
        System.out.println(batchName + " batch started");
    }
}
