package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5,5,1 , TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

    }
}
