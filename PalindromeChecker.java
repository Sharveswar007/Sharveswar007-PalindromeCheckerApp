import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * UC13 - Performance Comparison
 * 
 * Goal: Compare the performance of different palindrome approaches.
 * 
 * Key Concepts:
 * - System.nanoTime(): High-resolution timer for measuring execution time.
 * - Algorithm Comparison: Running multiple algorithms on the same input and comparing times.
 * - Benchmarking: Measuring performance to identify the most efficient approach.
 * 
 * Algorithms Compared:
 * 1. String Reverse (Loop + Concatenation)
 * 2. Two-Pointer (char[])
 * 3. Stack-Based (LIFO)
 * 4. Queue + Stack (FIFO vs LIFO)
 * 5. Deque-Based (Double Ended)
 * 6. Recursive
 */
public class PalindromeChecker {

    // =========================================================
    // Algorithm 1: String Reverse (Loop + Concatenation)
    // =========================================================
    static boolean stringReverseCheck(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }
        return input.equals(reversed);
    }

    // =========================================================
    // Algorithm 2: Two-Pointer (char[])
    // =========================================================
    static boolean twoPointerCheck(String input) {
        char[] chars = input.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // =========================================================
    // Algorithm 3: Stack-Based (LIFO)
    // =========================================================
    static boolean stackCheck(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) return false;
        }
        return true;
    }

    // =========================================================
    // Algorithm 4: Queue + Stack (FIFO vs LIFO)
    // =========================================================
    static boolean queueStackCheck(String input) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            queue.add(input.charAt(i));
            stack.push(input.charAt(i));
        }
        while (!queue.isEmpty()) {
            if (queue.poll() != stack.pop()) return false;
        }
        return true;
    }

    // =========================================================
    // Algorithm 5: Deque-Based (Double Ended)
    // =========================================================
    static boolean dequeCheck(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // =========================================================
    // Algorithm 6: Recursive
    // =========================================================
    static boolean recursiveCheck(String input) {
        return recursiveHelper(input, 0, input.length() - 1);
    }

    static boolean recursiveHelper(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursiveHelper(str, start + 1, end - 1);
    }

    // =========================================================
    // Benchmark helper - runs an algorithm multiple times
    // =========================================================
    static long benchmark(String input, int iterations, String algorithmName) {
        boolean result = false;

        // Warm-up run (JVM JIT optimization)
        for (int i = 0; i < 100; i++) {
            switch (algorithmName) {
                case "String Reverse": stringReverseCheck(input); break;
                case "Two-Pointer":    twoPointerCheck(input); break;
                case "Stack":          stackCheck(input); break;
                case "Queue+Stack":    queueStackCheck(input); break;
                case "Deque":          dequeCheck(input); break;
                case "Recursive":      recursiveCheck(input); break;
            }
        }

        // Timed run
        long startTime = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            switch (algorithmName) {
                case "String Reverse": result = stringReverseCheck(input); break;
                case "Two-Pointer":    result = twoPointerCheck(input); break;
                case "Stack":          result = stackCheck(input); break;
                case "Queue+Stack":    result = queueStackCheck(input); break;
                case "Deque":          result = dequeCheck(input); break;
                case "Recursive":      result = recursiveCheck(input); break;
            }
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // =========================================================
    // Main method - Performance Comparison
    // =========================================================
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("   Palindrome Checker - UC13");
        System.out.println("   Performance Comparison of All Algorithms");
        System.out.println("==========================================================");

        // Test string - a long palindrome for meaningful performance measurement
        String testInput = "abcdefghijklmnopqrstuvwxyzzyxwvutsrqponmlkjihgfedcba";
        int iterations = 10000;

        System.out.println("Test Input: \"" + testInput + "\"");
        System.out.println("Input Length: " + testInput.length());
        System.out.println("Iterations: " + iterations);
        System.out.println();

        // Algorithm names
        String[] algorithms = {
            "String Reverse",
            "Two-Pointer",
            "Stack",
            "Queue+Stack",
            "Deque",
            "Recursive"
        };

        // Store results
        long[] times = new long[algorithms.length];
        boolean[] results = new boolean[algorithms.length];

        // Run benchmarks
        System.out.println("Running benchmarks...\n");

        results[0] = stringReverseCheck(testInput);
        times[0] = benchmark(testInput, iterations, algorithms[0]);

        results[1] = twoPointerCheck(testInput);
        times[1] = benchmark(testInput, iterations, algorithms[1]);

        results[2] = stackCheck(testInput);
        times[2] = benchmark(testInput, iterations, algorithms[2]);

        results[3] = queueStackCheck(testInput);
        times[3] = benchmark(testInput, iterations, algorithms[3]);

        results[4] = dequeCheck(testInput);
        times[4] = benchmark(testInput, iterations, algorithms[4]);

        results[5] = recursiveCheck(testInput);
        times[5] = benchmark(testInput, iterations, algorithms[5]);

        // Display results table
        System.out.println("==========================================================");
        System.out.printf("%-20s | %-12s | %-15s | %s%n", "Algorithm", "Result", "Time (ms)", "Time (ns)");
        System.out.println("----------------------------------------------------------");

        // Find the fastest time for highlighting
        long fastest = Long.MAX_VALUE;
        int fastestIndex = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i] < fastest) {
                fastest = times[i];
                fastestIndex = i;
            }
        }

        for (int i = 0; i < algorithms.length; i++) {
            double timeMs = times[i] / 1_000_000.0;
            String marker = (i == fastestIndex) ? " << FASTEST" : "";
            System.out.printf("%-20s | %-12s | %-15.3f | %,d%s%n",
                algorithms[i],
                results[i] ? "Palindrome" : "Not Palin.",
                timeMs,
                times[i],
                marker);
        }

        System.out.println("==========================================================");

        // Performance Analysis
        System.out.println("\n--- Performance Analysis ---");
        System.out.println("Fastest Algorithm: " + algorithms[fastestIndex]);
        System.out.println();
        System.out.println("Expected Rankings (best to worst):");
        System.out.println("  1. Two-Pointer   - O(n/2) time, O(1) extra space");
        System.out.println("  2. Deque          - O(n/2) time, O(n) extra space");
        System.out.println("  3. Recursive      - O(n/2) time, O(n) call stack space");
        System.out.println("  4. Stack          - O(n) time, O(n) extra space");
        System.out.println("  5. Queue+Stack    - O(n) time, O(2n) extra space");
        System.out.println("  6. String Reverse - O(n) time, O(n^2) due to immutable String concat");

        System.out.println("\n--- Key Takeaway ---");
        System.out.println("Two-Pointer approach is generally the most efficient as it");
        System.out.println("uses O(1) extra space and only compares n/2 characters.");
        System.out.println("String Reverse with concatenation is the slowest due to");
        System.out.println("String immutability creating new objects in every iteration.");

        System.out.println("\nProgram exiting...");
    }
}
