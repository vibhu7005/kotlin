package multithreading;

import java.util.ArrayList;
import java.util.List;

public class FanInOut {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            list.add(i);
        }

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(list.get(i));
                }
            }
        };



        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i < 20; i++) {
                    System.out.println(list.get(i));
                }
            }
        };

        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                for (int i = 20; i < 30; i++) {
                    System.out.println(list.get(i));
                }
            }
        };

        Runnable r4 = new Runnable() {
            @Override
            public void run() {
                for (int i = 30; i < 40; i++) {
                    System.out.println(list.get(i));
                }
            }
        };
        Runnable r5 = new Runnable() {
            @Override
            public void run() {
                for (int i = 40; i < 50; i++) {
                    System.out.println(list.get(i));
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        Thread t5 = new Thread(r1);

        t1.start();


        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        System.out.println("next");

        t2.start();
        t3.start();
        t4.start();

        try {

            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (int i = 40; i < 50; i++) {
            System.out.println(list.get(i));
        }


    }
}
