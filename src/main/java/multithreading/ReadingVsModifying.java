import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadingVsModifying {
    
    // Shared variable - stored on heap
    private static int sharedCounter = 0;
    private static AtomicInteger atomicCounter = new AtomicInteger(0);
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("=== READING vs MODIFYING: When AtomicInteger Helps ===\n");
        
        // ===== CASE 1: Only Reading (No Modification) =====
        System.out.println("=== CASE 1: Only Reading (No Modification Needed) ===\n");
        
        System.out.println("Scenario: Multiple threads only READING a shared variable");
        System.out.println("Example: Reading a configuration value, constant, etc.\n");
        
        final int readOnlyValue = 100;  // Shared constant
        
        List<Thread> readers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            final int threadNum = i;
            readers.add(new Thread(() -> {
                // Multiple threads reading the same value
                int value = readOnlyValue;  // Just reading
                System.out.println("Thread " + threadNum + " read: " + value);
            }));
        }
        
        readers.forEach(Thread::start);
        for (Thread t : readers) {
            t.join();
        }
        
        System.out.println("\n✓ Reading is SAFE - no race condition!");
        System.out.println("✓ No AtomicInteger needed for read-only operations\n");
        
        // ===== CASE 2: Reading + Modifying Shared Variable =====
        System.out.println("=== CASE 2: Reading + Modifying Shared Variable ===\n");
        
        System.out.println("Scenario: Multiple threads READ and MODIFY the same variable");
        System.out.println("Example: Counter, accumulator, shared state\n");
        
        System.out.println("Problem with regular int:");
        System.out.println("  Operation: count++ involves:");
        System.out.println("    1. READ count (e.g., 5)");
        System.out.println("    2. MODIFY (5 + 1 = 6)");
        System.out.println("    3. WRITE count (6)");
        System.out.println("  → READ-MODIFY-WRITE is NOT atomic!\n");
        
        demonstrateReadModifyWrite();
        
        // ===== CASE 3: Local Variables (Not Shared) =====
        System.out.println("\n=== CASE 3: Local Variables (Not Shared) ===\n");
        
        System.out.println("Scenario: Each thread has its own local variable");
        System.out.println("Example: Loop counter 'i' in Threads.java\n");
        
        List<Thread> localThreads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            final int threadNum = i;
            localThreads.add(new Thread(() -> {
                // Each thread has its own local 'i'
                for (int j = 0; j < 5; j++) {
                    System.out.println("Thread " + threadNum + " local j: " + j);
                }
            }));
        }
        
        localThreads.forEach(Thread::start);
        for (Thread t : localThreads) {
            t.join();
        }
        
        System.out.println("\n✓ Each thread has its own 'j' variable");
        System.out.println("✓ No sharing = No race condition");
        System.out.println("✓ No AtomicInteger needed (nothing shared to protect)\n");
        
        // ===== CASE 4: Reading Shared Variable While Others Modify =====
        System.out.println("=== CASE 4: Reading While Others Modify ===\n");
        
        System.out.println("Scenario: Some threads read, others modify same variable");
        System.out.println("Question: Do readers need AtomicInteger?\n");
        
        System.out.println("Answer: It depends on what you need:\n");
        
        System.out.println("Option A: Readers don't care about exact value");
        System.out.println("  → Regular int is OK (may read stale value)");
        System.out.println("  → No AtomicInteger needed for readers\n");
        
        demonstrateStaleReads();
        
        System.out.println("\nOption B: Readers need latest value");
        System.out.println("  → Use AtomicInteger or volatile");
        System.out.println("  → Ensures visibility of latest writes\n");
        
        demonstrateFreshReads();
        
        // ===== SUMMARY =====
        System.out.println("\n=== SUMMARY ===\n");
        
        System.out.println("AtomicInteger helps when:");
        System.out.println("  ✓ Multiple threads MODIFY the same variable");
        System.out.println("  ✓ READ-MODIFY-WRITE operations need to be atomic");
        System.out.println("  ✓ Example: counter++, count += 5, etc.\n");
        
        System.out.println("AtomicInteger NOT needed when:");
        System.out.println("  ✓ Only READING (no modification)");
        System.out.println("  ✓ Each thread has its own local variable");
        System.out.println("  ✓ No shared state being modified\n");
        
        System.out.println("Key insight:");
        System.out.println("  • Reading alone = Safe (no race condition)");
        System.out.println("  • Modifying = Needs protection (race condition possible)");
        System.out.println("  • READ-MODIFY-WRITE = Needs atomicity (AtomicInteger)");
    }
    
    // ===== DEMONSTRATE READ-MODIFY-WRITE =====
    private static void demonstrateReadModifyWrite() throws InterruptedException {
        System.out.println("Demonstrating READ-MODIFY-WRITE problem:\n");
        
        // Regular int - unsafe
        System.out.println("1. Regular int (UNSAFE):");
        sharedCounter = 0;
        List<Thread> modifiers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            modifiers.add(new Thread(() -> {
                // READ-MODIFY-WRITE operation
                sharedCounter++;  // Read, modify, write - NOT atomic!
            }));
        }
        modifiers.forEach(Thread::start);
        for (Thread t : modifiers) {
            t.join();
        }
        System.out.println("   Result: " + sharedCounter + " (may be incorrect)");
        System.out.println("   Problem: Lost updates due to race condition\n");
        
        // AtomicInteger - safe
        System.out.println("2. AtomicInteger (SAFE):");
        atomicCounter.set(0);
        List<Thread> atomicModifiers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            atomicModifiers.add(new Thread(() -> {
                // READ-MODIFY-WRITE operation - ATOMIC!
                atomicCounter.incrementAndGet();  // Atomic - no race condition!
            }));
        }
        atomicModifiers.forEach(Thread::start);
        for (Thread t : atomicModifiers) {
            t.join();
        }
        System.out.println("   Result: " + atomicCounter.get() + " (always correct)");
        System.out.println("   Solution: AtomicInteger makes READ-MODIFY-WRITE atomic!");
    }
    
    // ===== DEMONSTRATE STALE READS =====
    private static void demonstrateStaleReads() throws InterruptedException {
        System.out.println("Demonstrating stale reads (readers don't care):");
        
        int regularCounter = 0;
        
        // Writer thread
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                regularCounter++;  // Modifying
            }
        });
        
        // Reader thread
        Thread reader = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                int value = regularCounter;  // Reading (may be stale)
                System.out.println("   Reader saw: " + value);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        writer.start();
        reader.start();
        writer.join();
        reader.join();
        
        System.out.println("   Final value: " + regularCounter);
        System.out.println("   → Reader may see stale values, but that's OK if not critical");
    }
    
    // ===== DEMONSTRATE FRESH READS =====
    private static void demonstrateFreshReads() throws InterruptedException {
        System.out.println("Demonstrating fresh reads (readers need latest value):");
        
        AtomicInteger freshCounter = new AtomicInteger(0);
        
        // Writer thread
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                freshCounter.incrementAndGet();  // Modifying
            }
        });
        
        // Reader thread
        Thread reader = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                int value = freshCounter.get();  // Reading (always fresh)
                System.out.println("   Reader saw: " + value);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        writer.start();
        reader.start();
        writer.join();
        reader.join();
        
        System.out.println("   Final value: " + freshCounter.get());
        System.out.println("   → Reader sees latest values (visibility guaranteed)");
    }
}
