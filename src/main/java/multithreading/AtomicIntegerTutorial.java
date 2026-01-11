import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTutorial {
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("=== WHAT IS AtomicInteger? ===\n");
        
        System.out.println("AtomicInteger is a thread-safe wrapper for int");
        System.out.println("It ensures operations like increment/decrement are ATOMIC");
        System.out.println("(Atomic = happens completely or not at all, no partial execution)\n");
        
        // ===== THE PROBLEM: Race Condition with Regular int =====
        System.out.println("=== THE PROBLEM: Race Condition ===\n");
        
        System.out.println("Regular int increment is NOT atomic:");
        System.out.println("  int count = 0;");
        System.out.println("  count++;  // This is actually 3 steps:");
        System.out.println("    1. Read count value (e.g., 5)");
        System.out.println("    2. Increment it (5 + 1 = 6)");
        System.out.println("    3. Write back (count = 6)");
        System.out.println("\n  Problem: Two threads can interfere!");
        System.out.println("    Thread 1: Read (5) → Increment (6) → Write (6)");
        System.out.println("    Thread 2: Read (5) → Increment (6) → Write (6)");
        System.out.println("    Result: Both read 5, both write 6. Lost one increment!\n");
        
        demonstrateRaceCondition();
        
        // ===== THE SOLUTION: AtomicInteger =====
        System.out.println("\n=== THE SOLUTION: AtomicInteger ===\n");
        
        System.out.println("AtomicInteger makes operations ATOMIC:");
        System.out.println("  AtomicInteger count = new AtomicInteger(0);");
        System.out.println("  count.incrementAndGet();  // This is ONE atomic operation");
        System.out.println("  All 3 steps happen together - no interruption!\n");
        
        demonstrateAtomicInteger();
        
        // ===== HOW IT WORKS: Compare-And-Swap (CAS) =====
        System.out.println("\n=== HOW AtomicInteger WORKS: Compare-And-Swap (CAS) ===\n");
        
        System.out.println("AtomicInteger uses Compare-And-Swap (CAS) algorithm:");
        System.out.println("  1. Read current value");
        System.out.println("  2. Calculate new value");
        System.out.println("  3. Compare: Is value still what we read?");
        System.out.println("     - If YES: Write new value (success!)");
        System.out.println("     - If NO: Retry from step 1 (another thread changed it)");
        System.out.println("\n  This is lock-free and very fast!");
        System.out.println("  No blocking, no waiting - just retry if needed\n");
        
        demonstrateCAS();
        
        // ===== COMPARISON: Regular int vs AtomicInteger =====
        System.out.println("\n=== COMPARISON: Regular int vs AtomicInteger ===\n");
        
        compareApproaches();
        
        // ===== COMMON METHODS =====
        System.out.println("\n=== COMMON AtomicInteger METHODS ===\n");
        
        AtomicInteger counter = new AtomicInteger(10);
        
        System.out.println("Initial value: " + counter.get());
        
        System.out.println("\n1. incrementAndGet(): " + counter.incrementAndGet());
        System.out.println("   Increments and returns new value");
        
        System.out.println("\n2. getAndIncrement(): " + counter.getAndIncrement());
        System.out.println("   Returns old value, then increments");
        System.out.println("   Current value: " + counter.get());
        
        System.out.println("\n3. addAndGet(5): " + counter.addAndGet(5));
        System.out.println("   Adds 5 and returns new value");
        
        System.out.println("\n4. compareAndSet(17, 100): " + counter.compareAndSet(17, 100));
        System.out.println("   If current value is 17, set to 100");
        System.out.println("   Result: " + counter.get());
        
        System.out.println("\n5. getAndSet(50): " + counter.getAndSet(50));
        System.out.println("   Sets to 50, returns old value");
        System.out.println("   Current value: " + counter.get());
        
        // ===== WHEN TO USE AtomicInteger =====
        System.out.println("\n=== WHEN TO USE AtomicInteger ===\n");
        
        System.out.println("✓ Use AtomicInteger when:");
        System.out.println("  • Simple operations (increment, decrement, add)");
        System.out.println("  • High performance needed (lock-free)");
        System.out.println("  • Single variable needs thread-safety");
        System.out.println("  • No complex logic needed\n");
        
        System.out.println("✗ Don't use AtomicInteger when:");
        System.out.println("  • Multiple variables need atomic updates together");
        System.out.println("  • Complex operations need synchronization");
        System.out.println("  • Need to coordinate multiple operations");
        System.out.println("  • Use synchronized blocks or locks instead\n");
        
        // ===== SUMMARY =====
        System.out.println("=== SUMMARY ===\n");
        
        System.out.println("AtomicInteger:");
        System.out.println("  • Thread-safe wrapper for int");
        System.out.println("  • Makes operations atomic (all-or-nothing)");
        System.out.println("  • Uses Compare-And-Swap (CAS) - lock-free");
        System.out.println("  • Fast and efficient");
        System.out.println("  • Perfect for counters and simple operations");
        System.out.println("  • Prevents race conditions");
    }
    
    // ===== DEMONSTRATE RACE CONDITION =====
    private static void demonstrateRaceCondition() throws InterruptedException {
        System.out.println("Demonstrating race condition with regular int:");
        
        int regularCounter = 0;
        List<Thread> threads = new ArrayList<>();
        
        // Create 10 threads, each incrementing 1000 times
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    regularCounter++;  // NOT atomic - race condition!
                }
            }));
        }
        
        threads.forEach(Thread::start);
        for (Thread t : threads) {
            t.join();
        }
        
        System.out.println("Expected: 10,000 (10 threads × 1000 increments)");
        System.out.println("Actual: " + regularCounter);
        System.out.println("Lost increments: " + (10000 - regularCounter));
        System.out.println("→ Race condition caused lost updates!");
    }
    
    // ===== DEMONSTRATE AtomicInteger =====
    private static void demonstrateAtomicInteger() throws InterruptedException {
        System.out.println("Demonstrating AtomicInteger (thread-safe):");
        
        AtomicInteger atomicCounter = new AtomicInteger(0);
        List<Thread> threads = new ArrayList<>();
        
        // Create 10 threads, each incrementing 1000 times
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicCounter.incrementAndGet();  // Atomic - no race condition!
                }
            }));
        }
        
        threads.forEach(Thread::start);
        for (Thread t : threads) {
            t.join();
        }
        
        System.out.println("Expected: 10,000 (10 threads × 1000 increments)");
        System.out.println("Actual: " + atomicCounter.get());
        System.out.println("Lost increments: " + (10000 - atomicCounter.get()));
        System.out.println("→ AtomicInteger prevents race conditions!");
    }
    
    // ===== DEMONSTRATE CAS =====
    private static void demonstrateCAS() {
        System.out.println("Demonstrating Compare-And-Swap:");
        
        AtomicInteger counter = new AtomicInteger(10);
        
        System.out.println("Current value: " + counter.get());
        
        // Try to set to 20 only if current value is 10
        boolean success1 = counter.compareAndSet(10, 20);
        System.out.println("compareAndSet(10, 20): " + success1);
        System.out.println("New value: " + counter.get());
        
        // Try again - should fail because value is now 20, not 10
        boolean success2 = counter.compareAndSet(10, 30);
        System.out.println("compareAndSet(10, 30): " + success2);
        System.out.println("Value unchanged: " + counter.get());
        
        System.out.println("\nThis is how incrementAndGet() works internally:");
        System.out.println("  - Read current value");
        System.out.println("  - Calculate new value");
        System.out.println("  - compareAndSet(current, new)");
        System.out.println("  - If fails, retry until success");
    }
    
    // ===== COMPARE APPROACHES =====
    private static void compareApproaches() throws InterruptedException {
        System.out.println("Comparing different approaches:\n");
        
        // Approach 1: Regular int (unsafe)
        System.out.println("1. Regular int (UNSAFE):");
        int unsafeCounter = 0;
        List<Thread> threads1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            threads1.add(new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    unsafeCounter++;
                }
            }));
        }
        threads1.forEach(Thread::start);
        for (Thread t : threads1) {
            t.join();
        }
        System.out.println("   Result: " + unsafeCounter + " (may be incorrect due to race condition)");
        
        // Approach 2: AtomicInteger (safe, lock-free)
        System.out.println("\n2. AtomicInteger (SAFE, lock-free):");
        AtomicInteger atomicCounter = new AtomicInteger(0);
        List<Thread> threads2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            threads2.add(new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    atomicCounter.incrementAndGet();
                }
            }));
        }
        threads2.forEach(Thread::start);
        for (Thread t : threads2) {
            t.join();
        }
        System.out.println("   Result: " + atomicCounter.get() + " (always correct)");
        System.out.println("   Advantage: Fast, lock-free, no blocking");
        
        // Approach 3: Synchronized (safe, but slower)
        System.out.println("\n3. Synchronized (SAFE, but slower):");
        int syncCounter = 0;
        Object lock = new Object();
        List<Thread> threads3 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            threads3.add(new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    synchronized (lock) {
                        syncCounter++;
                    }
                }
            }));
        }
        threads3.forEach(Thread::start);
        for (Thread t : threads3) {
            t.join();
        }
        System.out.println("   Result: " + syncCounter + " (always correct)");
        System.out.println("   Disadvantage: Slower, threads block waiting for lock");
        
        System.out.println("\nWinner: AtomicInteger - fast, safe, lock-free!");
    }
}
