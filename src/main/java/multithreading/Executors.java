package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Executors {

    public static void main(String[] args) {
        ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(5);
        Runnable r = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Count" + i + " "+ Thread.currentThread().getName());
            }
        };
        for (int i = 0; i < 20; i++)
            executor.execute(r);

        executor.shutdown();
    }
}
