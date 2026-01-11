public class VariableCapture {
    
    // ===== INSTANCE VARIABLE (Class-level) =====
    // Can be modified from different threads
    private int instanceCounter = 0;
    
    // ===== STATIC VARIABLE (Class-level) =====
    // Can be modified from different threads
    private static int staticCounter = 0;
    
    public static void main(String[] args) throws InterruptedException {
        
        // ===== CASE 1: LOCAL VARIABLE IN MAIN METHOD =====
        System.out.println("=== CASE 1: Local Variable in main() ===");
        
        // This is a LOCAL VARIABLE - must be effectively final
        int localCounter = 0;
        
        // ❌ This would cause COMPILE ERROR if uncommented:
        // Thread thread1 = new Thread(() -> {
        //     localCounter++;  // ERROR: localCounter must be effectively final
        // });
        
        // ✓ This works - we can READ localCounter
        Thread thread1 = new Thread(() -> {
            System.out.println("Reading localCounter: " + localCounter);  // OK - reading is fine
        });
        
        // ❌ This would cause COMPILE ERROR:
        // localCounter++;  // ERROR: Cannot modify localCounter after it's used in lambda
        
        thread1.start();
        thread1.join();
        
        // ===== CASE 2: INSTANCE VARIABLE (Class-level) =====
        System.out.println("\n=== CASE 2: Instance Variable (Class-level) ===");
        
        VariableCapture obj = new VariableCapture();
        
        // ✓ This WORKS - instance variables CAN be modified from threads
        Thread thread2 = new Thread(() -> {
            obj.instanceCounter++;  // OK - modifying instance variable
            System.out.println("Thread 2: instanceCounter = " + obj.instanceCounter);
        });
        
        Thread thread3 = new Thread(() -> {
            obj.instanceCounter++;  // OK - modifying instance variable
            System.out.println("Thread 3: instanceCounter = " + obj.instanceCounter);
        });
        
        thread2.start();
        thread3.start();
        thread2.join();
        thread3.join();
        
        System.out.println("Final instanceCounter: " + obj.instanceCounter);
        
        // ===== CASE 3: STATIC VARIABLE =====
        System.out.println("\n=== CASE 3: Static Variable (Class-level) ===");
        
        Thread thread4 = new Thread(() -> {
            staticCounter++;  // OK - modifying static variable
            System.out.println("Thread 4: staticCounter = " + staticCounter);
        });
        
        Thread thread5 = new Thread(() -> {
            staticCounter++;  // OK - modifying static variable
            System.out.println("Thread 5: staticCounter = " + staticCounter);
        });
        
        thread4.start();
        thread5.start();
        thread4.join();
        thread5.join();
        
        System.out.println("Final staticCounter: " + staticCounter);
        
        // ===== CASE 4: ARRAY ELEMENT (Workaround for local variables) =====
        System.out.println("\n=== CASE 4: Array Element (Workaround) ===");
        
        // Array reference is final, but array contents can be modified
        final int[] arrayCounter = {0};  // Array reference is final
        
        Thread thread6 = new Thread(() -> {
            arrayCounter[0]++;  // OK - modifying array element
            System.out.println("Thread 6: arrayCounter[0] = " + arrayCounter[0]);
        });
        
        Thread thread7 = new Thread(() -> {
            arrayCounter[0]++;  // OK - modifying array element
            System.out.println("Thread 7: arrayCounter[0] = " + arrayCounter[0]);
        });
        
        thread6.start();
        thread7.start();
        thread6.join();
        thread7.join();
        
        System.out.println("Final arrayCounter[0]: " + arrayCounter[0]);
        
        // ===== EXPLANATION =====
        System.out.println("\n=== WHY THE DIFFERENCE? ===");
        System.out.println("\nLOCAL VARIABLES (in main method):");
        System.out.println("  ✗ Must be 'effectively final' (cannot be modified)");
        System.out.println("  ✗ Cannot modify from lambda/anonymous class");
        System.out.println("  Reason: Local variables are stored on STACK (thread-specific)");
        System.out.println("  Reason: Lambda might outlive the method, causing issues");
        
        System.out.println("\nINSTANCE/STATIC VARIABLES (class-level):");
        System.out.println("  ✓ Can be modified from threads");
        System.out.println("  ✓ Stored on HEAP (shared across threads)");
        System.out.println("  ⚠️  WARNING: Need synchronization for thread safety!");
        
        System.out.println("\nARRAY WORKAROUND:");
        System.out.println("  ✓ Array reference is final, but contents can be modified");
        System.out.println("  ⚠️  WARNING: Also needs synchronization for thread safety!");
    }
}
