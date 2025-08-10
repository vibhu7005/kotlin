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
//                thread.join();
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }
}

class Cxo {
    int i = 0;
    synchronized void exec() {
        while (i < 40) {
            i++;
            System.out.println(i);
        }
    }
}
