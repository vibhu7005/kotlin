package multithreading;

public class Synchronous {

    final String i1 = "s1";
    final String i2 = "s2";





    void task1(final String object) {
        synchronized (object) {
            System.out.println(object + "task 1 start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(object + "task 1 end");
        }
    }

    void task2(final String object) {
        synchronized (object) {
            System.out.println(object + "task 2 start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(object + "task 2 end");
        }
    }

    public static void main(String[] args) {
        Synchronous s = new Synchronous();

        Thread t1 = new Thread(() -> {
            s.task1(s.i1);
        });

        Thread t2 = new Thread(() -> {
            s.task1(s.i2);
        });



        Thread t3 = new Thread(() -> {
            s.task2(s.i1);
        });

        Thread t4 = new Thread(() -> {
            s.task2(s.i2);
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
