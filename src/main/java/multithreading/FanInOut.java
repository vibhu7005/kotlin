package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static javax.print.attribute.standard.MediaSizeName.A;

public class FanInOut {
    private int i;

    FanInOut(int i) {
        this.i = i;
    }

    public static void main(String[] args) {

        int i = 0;
        Exec exec = new Exec();
        exec.foo();
    }


    static class Exec {
        List<Integer> list = new ArrayList<>();

        int i = 0;

        synchronized void getAnd() {
            if (i >39) return;
            System.out.println(list.get(i));
            i++;
        }

        void foo() {

            synchronized (this) {
                for (int j = 1; j <= 50; j++) {
                    list.add(j);
                }
            }

            while (i < 10) {
                System.out.println(list.get(i));
                i++;
            }

            ArrayList<Thread> threads = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                threads.add(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (i < 40) {
                            getAnd();
                        }
                    }
                }));
            }

            threads.forEach(Thread::start);
            threads.forEach(thread -> {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

//            while (i < 50) {
//                System.out.println(list.get(i));
//                i++;
//            }

        }
    }
}
