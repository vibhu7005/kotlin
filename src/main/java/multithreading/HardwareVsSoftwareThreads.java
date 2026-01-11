public class HardwareVsSoftwareThreads {
    public static void main(String[] args) {
        System.out.println("=== HARDWARE THREADS vs SOFTWARE THREADS ===\n");
        
        // ===== HARDWARE THREADS =====
        System.out.println("1. HARDWARE THREADS (Physical CPU Cores/Threads):");
        System.out.println("   - Also called: CPU cores, physical threads, execution units");
        System.out.println("   - These are ACTUAL physical resources on your CPU");
        System.out.println("   - Limited by your hardware (e.g., 4 cores, 8 threads)");
        System.out.println("   - Can execute instructions SIMULTANEOUSLY");
        
        // Get hardware thread count
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("\n   Your CPU has: " + availableProcessors + " available processors");
        
        // ===== SOFTWARE THREADS =====
        System.out.println("\n2. SOFTWARE THREADS (Java Threads):");
        System.out.println("   - Also called: OS threads, application threads, logical threads");
        System.out.println("   - These are CREATED BY YOUR PROGRAM");
        System.out.println("   - Can create MANY more than hardware threads");
        System.out.println("   - Managed by the Operating System");
        System.out.println("   - OS schedules them onto hardware threads");
        
        // Demonstrate creating many software threads
        System.out.println("\n   Creating 100 software threads...");
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            final int threadNum = i;
            threads[i] = new Thread(() -> {
                System.out.println("   Software Thread #" + threadNum + " running on: " + Thread.currentThread().getName());
            });
            threads[i].start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // ===== KEY DIFFERENCES =====
        System.out.println("\n=== KEY DIFFERENCES ===");
        System.out.println("\nHARDWARE THREADS:");
        System.out.println("  ✓ Physical CPU cores/threads");
        System.out.println("  ✓ Limited by hardware (fixed number)");
        System.out.println("  ✓ True parallel execution");
        System.out.println("  ✓ Example: 4-core CPU with 8 threads (hyperthreading)");
        
        System.out.println("\nSOFTWARE THREADS:");
        System.out.println("  ✓ Created by your program");
        System.out.println("  ✓ Can create thousands");
        System.out.println("  ✓ Scheduled by OS onto hardware threads");
        System.out.println("  ✓ Example: You can create 1000 Java threads on a 4-core CPU");
        
        // ===== HOW THEY WORK TOGETHER =====
        System.out.println("\n=== HOW THEY WORK TOGETHER ===");
        System.out.println("1. Your program creates SOFTWARE THREADS (e.g., 100 threads)");
        System.out.println("2. Operating System schedules these onto HARDWARE THREADS (e.g., 4 cores)");
        System.out.println("3. OS uses TIME-SLICING: rapidly switches between software threads");
        System.out.println("4. Multiple software threads share the limited hardware threads");
        System.out.println("5. This creates the illusion of parallel execution");
        
        // ===== PRACTICAL EXAMPLE =====
        System.out.println("\n=== PRACTICAL EXAMPLE ===");
        System.out.println("Scenario: 4-core CPU, creating 8 software threads");
        
        int hardwareThreads = availableProcessors;
        int softwareThreads = 8;
        
        System.out.println("\nHardware threads available: " + hardwareThreads);
        System.out.println("Software threads created: " + softwareThreads);
        System.out.println("\nWhat happens:");
        System.out.println("  - All 8 software threads are created");
        System.out.println("  - OS schedules them onto " + hardwareThreads + " hardware threads");
        System.out.println("  - At any moment, only " + hardwareThreads + " threads run simultaneously");
        System.out.println("  - OS rapidly switches between all 8 threads");
        System.out.println("  - This is called 'time-slicing' or 'context switching'");
        
        // ===== PERFORMANCE IMPLICATIONS =====
        System.out.println("\n=== PERFORMANCE IMPLICATIONS ===");
        System.out.println("Creating MORE software threads than hardware threads:");
        System.out.println("  ✓ Can improve throughput for I/O-bound tasks");
        System.out.println("  ✗ Can hurt performance for CPU-bound tasks (too much context switching)");
        System.out.println("  ✓ Rule of thumb: For CPU-bound tasks, use ~number of hardware threads");
        System.out.println("  ✓ Rule of thumb: For I/O-bound tasks, can use many more threads");
        
        // ===== SUMMARY =====
        System.out.println("\n=== SUMMARY ===");
        System.out.println("HARDWARE THREADS = Physical CPU cores (limited, expensive)");
        System.out.println("SOFTWARE THREADS = Program-created threads (unlimited, managed by OS)");
        System.out.println("OS bridges the gap by scheduling software threads onto hardware threads");
    }
}
