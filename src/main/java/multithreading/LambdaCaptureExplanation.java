public class LambdaCaptureExplanation {
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("=== WHY LOCAL VARIABLES CAN'T BE MODIFIED IN LAMBDAS ===\n");
        
        // ===== THE PROBLEM: Pass-by-Value and Copies =====
        System.out.println("1. THE PROBLEM WITH ALLOWING MODIFICATION:");
        System.out.println("   Java is PASS-BY-VALUE, so lambda gets a COPY of the variable");
        System.out.println("   If we could modify it, we'd have INCONSISTENT behavior:\n");
        
        // Demonstrate the copy behavior
        int localVar = 10;
        System.out.println("   Original value in main: " + localVar);
        
        // Lambda captures a COPY of the value
        Runnable lambda = () -> {
            // If we could modify here, it would only change the COPY
            // localVar++;  // ❌ Not allowed, but imagine if it was...
            System.out.println("   Lambda sees copy: " + localVar);  // Reads the copy
        };
        
        // If we could modify in main after lambda creation:
        // localVar = 20;  // This would change main's copy
        
        // When lambda runs, which value should it see?
        // - The original value (10)?
        // - The modified value (20)?
        // This creates CONFUSION and INCONSISTENCY!
        
        System.out.println("\n2. WHAT WOULD HAPPEN IF IT WAS ALLOWED:");
        System.out.println("   Scenario: Lambda captures i=10, then main changes i=20");
        System.out.println("   Problem: Lambda has a COPY, main has ORIGINAL");
        System.out.println("   Result: Two different values exist simultaneously!");
        System.out.println("   This is why Java requires 'effectively final'\n");
        
        // ===== DEMONSTRATING THE COPY BEHAVIOR =====
        System.out.println("3. DEMONSTRATING COPY BEHAVIOR:\n");
        
        // Example with object reference (also pass-by-value!)
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("   Original StringBuilder: " + sb);
        
        Runnable lambda2 = () -> {
            // We can modify the OBJECT's contents (not the reference itself)
            sb.append(" World");  // ✓ This works! We're modifying the object
            System.out.println("   Lambda modifies object: " + sb);
        };
        
        lambda2.run();
        System.out.println("   After lambda: " + sb);
        System.out.println("   ✓ Object modification works because we modify the shared object");
        
        // But we can't reassign the reference
        // Runnable lambda3 = () -> {
        //     sb = new StringBuilder("New");  // ❌ ERROR! Can't reassign reference
        // };
        
        System.out.println("\n4. WHY INSTANCE VARIABLES WORK:");
        System.out.println("   Instance variables are stored on HEAP (shared memory)");
        System.out.println("   All threads/lambdas access the SAME memory location");
        System.out.println("   No copy is made - direct access to shared variable\n");
        
        LambdaCaptureExplanation obj = new LambdaCaptureExplanation();
        obj.instanceVar = 10;
        System.out.println("   Instance variable before: " + obj.instanceVar);
        
        Runnable lambda4 = () -> {
            obj.instanceVar++;  // ✓ Works! Modifying shared memory
            System.out.println("   Lambda modifies instance var: " + obj.instanceVar);
        };
        
        lambda4.run();
        System.out.println("   Instance variable after: " + obj.instanceVar);
        System.out.println("   ✓ Same memory location, so changes are visible everywhere");
        
        // ===== THE REAL REASON =====
        System.out.println("\n=== THE REAL REASON ===");
        System.out.println("\nJava prevents modification of local variables because:");
        System.out.println("  1. Pass-by-value means lambda gets a COPY");
        System.out.println("  2. Modifying copy wouldn't affect original (confusing!)");
        System.out.println("  3. If main modifies original, lambda's copy becomes stale");
        System.out.println("  4. This creates INCONSISTENT and CONFUSING behavior");
        System.out.println("  5. 'Effectively final' ensures consistent value across all uses");
        
        // ===== VISUAL EXPLANATION =====
        System.out.println("\n=== VISUAL EXPLANATION ===");
        System.out.println("\nLocal Variable (Stack):");
        System.out.println("  Main method stack:");
        System.out.println("    i = 10  ← Original");
        System.out.println("  Lambda closure:");
        System.out.println("    i = 10  ← COPY (separate memory!)");
        System.out.println("  If we could modify:");
        System.out.println("    Main: i = 20  (original changed)");
        System.out.println("    Lambda: i = 11  (copy changed)");
        System.out.println("    ❌ Two different values! Confusing!");
        
        System.out.println("\nInstance Variable (Heap):");
        System.out.println("  Heap memory:");
        System.out.println("    obj.instanceVar = 10  ← SHARED location");
        System.out.println("  Main method:");
        System.out.println("    → points to heap");
        System.out.println("  Lambda:");
        System.out.println("    → points to SAME heap location");
        System.out.println("  When modified:");
        System.out.println("    Both see the same updated value!");
        System.out.println("    ✓ Consistent behavior!");
        
        // ===== CONCRETE EXAMPLE: What if it was allowed? =====
        System.out.println("\n=== CONCRETE EXAMPLE: What if modification was allowed? ===");
        System.out.println("\nImagine this code was allowed:");
        System.out.println("  int i = 10;");
        System.out.println("  Runnable r = () -> { i++; };  // Lambda modifies COPY");
        System.out.println("  i = 20;  // Main modifies ORIGINAL");
        System.out.println("  r.run();  // Lambda runs");
        System.out.println("  System.out.println(i);  // What value? 20? 11? Confusing!");
        
        System.out.println("\nThe problem:");
        System.out.println("  • Lambda's i (copy) = 11");
        System.out.println("  • Main's i (original) = 20");
        System.out.println("  • Which one is 'correct'? Both exist!");
        System.out.println("  • This violates the principle of least surprise");
        
        System.out.println("\nJava's solution:");
        System.out.println("  • Make i 'effectively final'");
        System.out.println("  • Lambda captures the VALUE (10)");
        System.out.println("  • Value never changes, so no confusion");
        System.out.println("  • Consistent behavior guaranteed!");
        
        // ===== SUMMARY =====
        System.out.println("\n=== SUMMARY ===");
        System.out.println("Your understanding is CORRECT!");
        System.out.println("Java prevents modification because:");
        System.out.println("  • Lambda holds a COPY (pass-by-value)");
        System.out.println("  • Updating copy doesn't change original");
        System.out.println("  • This creates INCONSISTENT behavior");
        System.out.println("  • Java enforces 'effectively final' to prevent this confusion");
        System.out.println("\nKey insight: It's not about thread safety (that's a bonus),");
        System.out.println("it's about preventing confusing behavior from pass-by-value copies!");
    }
    
    private int instanceVar = 0;
}
