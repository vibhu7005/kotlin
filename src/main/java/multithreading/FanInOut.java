package multithreading;


import kt.A;

import java.util.ArrayList;

public class FanInOut {

    public static void main(String[] args) throws InterruptedException {
        Cxo cxo = new Cxo();
        cxo.i = 0;

        ArrayList<Thread> threadList = new ArrayList<>();

        for (int j = 0; j < 4; j++) {
            threadList.add(new Thread(cxo::exec));
        }

        threadList.forEach(thread -> {
            try {
                thread.start();
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        for (Thread thread : threadList) {
            thread.join();
        }
    }
}

class Cxo {
    int i = 0;
    void exec() {
        while (i < 40) {
            readAndWrite();
        }
    }

    synchronized void readAndWrite() {
        System.out.println(i);
        i++;
    }
}
