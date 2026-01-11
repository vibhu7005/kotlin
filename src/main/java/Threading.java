import java.util.ArrayList;
import java.util.List;

public class Threading {
    public static void main(String[] args) {
        FaniNinExecttion exec = new FaniNinExecttion();
        exec.execute();
    }
}


class FaniNinExecttion {
    int i = 1;

    void execute() {
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        List<Thread> threadList = new ArrayList<>();
        for (
                int k = 1;
                k <= 4; k++) {
            Thread thread = new Thread(this::getAndUpdate);
            threadList.add(thread);
            thread.start();
        }

        for (
                Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        while (i <= 50) {
            System.out.println(i);
            i++;
        }
    }


    synchronized void getAndUpdate() {
        while (i <= 40) {
            System.out.println(i);
            i++;
        }
    }
}
