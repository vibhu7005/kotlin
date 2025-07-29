import java.util.ArrayList;
import java.util.List;

public class Threads {
    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();

        Runnable runnable = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("count" + i +  "  " + Thread.currentThread().getName());
            }
        });

        for (int i =0 ; i < 20; i++)
            threadList.add(new Thread(runnable));

        threadList.forEach(Thread::start);
    }
}
