import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExplanation {
    
    // Instance variable - stored on HEAP, SHARED across threads
    private AtomicInteger instanceCounter = new AtomicInteger(0);
    
    // Static variable - stored on HEAP, SHARED across threads
    private static AtomicInteger staticCounter = new AtomicInteger(0);
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("=== WHY AtomicInteger WON'T HELP IN Threads.java EXAMPLE ===\n");
        
        // ===== THE ORIGINAL CODE PROBLEM =====
        System.out.println("1. THE ORIGINAL CODE ISSUE:\n");
        
        List<Thread> threadList = new ArrayList<>();
        
        // NOTE: There's also a bug here - Runnable should not be new Thread()
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {  // This 'i' is LOCAL to each thread execution
                System.out.println("count " + i + "  " + Thread.currentThread().getName());
            }
        };
        
        System.out.println("   In the original code:");
        System.out.println("   - Variable 'i' is LOCAL to each thread's execution");
        System.out.println("   - Each thread creates its OWN 'i' variable (0 to 4)");
        System.out.println("   - These 'i' variables are NOT shared between threads");
        System.out.println("   - Each thread independently counts 0, 1, 2, 3, 4\n");
        
        // ===== CLARIFICATION: Instance Variable IS Shared =====
        System.out.println("2. CLARIFICATION: Instance Variable AtomicInteger IS Shared!\n");
        
        System.out.println("   You're CORRECT: If AtomicInteger is an instance variable,");
        System.out.println("   it IS stored on HEAP and IS shared across threads.\n");
        
        AtomicIntegerExplanation obj = new AtomicIntegerExplanation();
        
        System.out.println("   Example: Instance variable on heap (SHARED):");
        System.out.println("   private AtomicInteger instanceCounter = new AtomicInteger(0);");
        System.out.println("   → Stored on HEAP");
        System.out.println("   → All threads can access it");
        System.out.println("   → It IS shared!\n");
        
        // ===== THE REAL ISSUE: Not Using the Shared Counter =====
        System.out.println("3. THE REAL ISSUE: Not Using the Shared Counter!\n");
        
        System.out.println("   Even if we have a shared AtomicInteger instance variable,");
        System.out.println("   AtomicInteger won't help if we DON'T USE IT!\n");
        
        System.out.println("   Original code:");
        System.out.println("   Runnable runnable = () -> {");
        System.out.println("       for (int i = 0; i < 5; i++) {  // Using LOCAL 'i'");
        System.out.println("           // instanceCounter exists but is IGNORED!");
        System.out.println("       }");
        System.out.println("   };\n");
        
        System.out.println("   Problem: We're using local variable 'i', not the shared counter!");
        System.out.println("   The shared AtomicInteger exists but is never used.\n");
        
        // Demonstrate: Even with instance variable, if we don't use it
        Runnable wrongRunnable = () -> {
            for (int i = 0; i < 5; i++) {  // Still using local 'i'
                // obj.instanceCounter exists on heap and is shared,
                // but we're not using it - we're using local 'i'!
                System.out.println("count " + i + " (instanceCounter exists but unused: " + obj.instanceCounter.get() + ")");
            }
        };
        
        System.out.println("   Demonstration:");
        Thread t1 = new Thread(wrongRunnable);
        Thread t2 = new Thread(wrongRunnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println("\n   Result: instanceCounter stayed at 0 because we never used it!");
        System.out.println("   We used local 'i' instead, which is NOT shared.\n");
        
        // ===== CORRECT USAGE: Using the Shared Instance Variable =====
        System.out.println("4. CORRECT USAGE: Actually Using the Shared Instance Variable\n");
        
        AtomicIntegerExplanation obj2 = new AtomicIntegerExplanation();
        
        System.out.println("   Now we'll USE the instance variable:");
        Runnable correctRunnable = () -> {
            // Use the shared instance counter, not a local variable
            for (int i = 0; i < 5; i++) {
                int count = obj2.instanceCounter.incrementAndGet();  // Use shared counter!
                System.out.println("count " + count + "  " + Thread.currentThread().getName());
            }
        };
        
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            threads.add(new Thread(correctRunnable));
        }
        
        System.out.println("   Creating 3 threads, each incrementing shared instance counter 5 times:");
        System.out.println("   Expected: 15 total increments (3 threads × 5)\n");
        
        threads.forEach(Thread::start);
        for (Thread t : threads) {
            t.join();
        }
        
        System.out.println("\n   Final instance counter value: " + obj2.instanceCounter.get());
        System.out.println("   ✓ AtomicInteger works when you actually USE the shared variable!\n");
        
        // ===== THE KEY DIFFERENCE =====
        System.out.println("=== THE KEY DIFFERENCE ===\n");
        
        System.out.println("LOCAL VARIABLE (original code):");
        System.out.println("  for (int i = 0; i < 5; i++) { ... }");
        System.out.println("  • 'i' is created NEW for each thread execution");
        System.out.println("  • Each thread has its own 'i'");
        System.out.println("  • No sharing = No race condition");
        System.out.println("  • AtomicInteger won't help (nothing to share)\n");
        
        System.out.println("SHARED VARIABLE (if you wanted it):");
        System.out.println("  AtomicInteger counter = new AtomicInteger(0);");
        System.out.println("  for (int i = 0; i < 5; i++) {");
        System.out.println("      counter.incrementAndGet();  // Use shared counter");
        System.out.println("  }");
        System.out.println("  • All threads access the SAME counter");
        System.out.println("  • Sharing = Potential race condition");
        System.out.println("  • AtomicInteger WOULD help here!\n");
        
        // ===== VISUAL EXPLANATION =====
        System.out.println("=== VISUAL EXPLANATION ===\n");
        
        System.out.println("Original Code (Local 'i'):");
        System.out.println("  Thread 1: i = 0, 1, 2, 3, 4  (its own 'i')");
        System.out.println("  Thread 2: i = 0, 1, 2, 3, 4  (its own 'i')");
        System.out.println("  Thread 3: i = 0, 1, 2, 3, 4  (its own 'i')");
        System.out.println("  → No sharing, no conflict\n");
        
        System.out.println("If Using Shared Counter:");
        System.out.println("  Thread 1: counter = 1, 2, 3, 4, 5");
        System.out.println("  Thread 2: counter = 6, 7, 8, 9, 10");
        System.out.println("  Thread 3: counter = 11, 12, 13, 14, 15");
        System.out.println("  → All threads modify SAME counter");
        System.out.println("  → AtomicInteger ensures thread-safety\n");
        
        // ===== SUMMARY =====
        System.out.println("=== SUMMARY ===");
        System.out.println("\nYou're CORRECT: Instance variable AtomicInteger IS shared (on heap)!");
        System.out.println("\nBut AtomicInteger won't help in the original Threads.java because:");
        System.out.println("  1. Even if AtomicInteger is an instance variable (shared on heap)");
        System.out.println("  2. The code uses LOCAL variable 'i' instead");
        System.out.println("  3. The shared AtomicInteger exists but is NEVER USED");
        System.out.println("  4. Each thread uses its own local 'i' (0 to 4)");
        System.out.println("  5. No sharing of the counter = No race condition on counter");
        System.out.println("\nThe key insight:");
        System.out.println("  • Instance variable AtomicInteger = SHARED ✓");
        System.out.println("  • But if you don't USE it, it doesn't matter!");
        System.out.println("  • You must actually USE the shared counter for AtomicInteger to help");
        System.out.println("\nTo make AtomicInteger help:");
        System.out.println("  • Declare AtomicInteger as instance/static variable (shared)");
        System.out.println("  • Actually USE it: counter.incrementAndGet()");
        System.out.println("  • Don't use local variable 'i' for counting");
        System.out.println("  • Then AtomicInteger ensures thread-safety!");
    }
}
