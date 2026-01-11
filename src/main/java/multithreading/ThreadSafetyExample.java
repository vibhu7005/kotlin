public class ThreadSafetyExample {
    
    // Instance variable - can be modified from threads
    private int counter = 0;
    
    // Instance variable with synchronization
    private int safeCounter = 0;
    
    // Method without synchronization - NOT thread-safe
    public void incrementUnsafe() {
        counter++;  // This is NOT atomic! Multiple operations happen:
                    // 1. Read counter value
                    // 2. Increment it
                    // 3. Write back
                    // Two threads can interfere with each other
    }
    
    // Method with synchronization - thread-safe
    public synchronized void incrementSafe() {
        safeCounter++;  // Only one thread can execute this at a time
    }
    
    public int getCounter() {
        return counter;
    }
    
    public int getSafeCounter() {
        return safeCounter;
    }
    
    public static void main(String[] args) throws InterruptedException {
        ThreadSafetyExample example = new ThreadSafetyExample();
        
        System.out.println("=== DEMONSTRATING THREAD SAFETY ISSUE ===\n");
        
        // Create 10 threads that each increment 1000 times
        Thread[] threads = new Thread[10];
        
        // UNSAFE INCREMENT
        System.out.println("Running UNSAFE increment (10 threads, 1000 increments each)...");
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    example.incrementUnsafe();
                }
            });
            threads[i].start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }
        
        System.out.println("Expected value: 10,000");
        System.out.println("Actual value (UNSAFE): " + example.getCounter());
        System.out.println("Lost increments: " + (10000 - example.getCounter()));
        
        // SAFE INCREMENT
        System.out.println("\nRunning SAFE increment (10 threads, 1000 increments each)...");
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    example.incrementSafe();
                }
            });
            threads[i].start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }
        
        System.out.println("Expected value: 10,000");
        System.out.println("Actual value (SAFE): " + example.getSafeCounter());
        System.out.println("Lost increments: " + (10000 - example.getSafeCounter()));
        
        System.out.println("\n=== KEY TAKEAWAY ===");
        System.out.println("Instance variables CAN be modified from threads,");
        System.out.println("but you NEED synchronization to avoid race conditions!");
    }
}
