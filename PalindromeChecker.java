import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * UC6 - Queue + Stack Based Palindrome Check
 * 
 * Goal: Demonstrate FIFO vs LIFO using Queue and Stack to validate a palindrome.
 * 
 * Key Concepts:
 * - Queue: A linear data structure that follows First In First Out (FIFO) principle.
 * - Enqueue & Dequeue Operations: Insert and remove elements from the queue.
 * - Stack vs Queue: Demonstrates the behavioural difference between LIFO and FIFO.
 * - Logical Comparison: Matching dequeue (Queue) output with pop (Stack) output to validate palindrome.
 * 
 * Data Structures: Queue, Stack
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Palindrome Checker - UC6");
        System.out.println("   Queue + Stack Approach (FIFO vs LIFO)");
        System.out.println("=========================================");

        String word = "racecar";
        System.out.println("Checking word: \"" + word + "\"");

        // Create a Queue (FIFO) and a Stack (LIFO)
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enqueue characters into Queue and Push characters into Stack
        System.out.println("\n--- Loading characters into Queue (FIFO) and Stack (LIFO) ---");
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            queue.add(ch);       // Enqueue - adds to the rear
            stack.push(ch);      // Push - adds to the top
            System.out.println("  Added '" + ch + "' -> Queue: " + queue + " | Stack: " + stack);
        }

        // Compare: Dequeue from Queue (FIFO order) vs Pop from Stack (LIFO order)
        System.out.println("\n--- Comparing Queue (FIFO) vs Stack (LIFO) ---");
        boolean isPalindrome = true;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            char fromQueue = queue.poll();   // Dequeue - removes from the front (FIFO)
            char fromStack = stack.pop();    // Pop - removes from the top (LIFO)

            System.out.println("  Queue (front): '" + fromQueue + "' vs Stack (top): '" + fromStack + "'"
                             + (fromQueue == fromStack ? " -> MATCH" : " -> MISMATCH"));

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        System.out.println();
        if (isPalindrome) {
            System.out.println("Result: \"" + word + "\" IS a Palindrome!");
            System.out.println("Explanation: FIFO order matches LIFO order, confirming palindrome.");
        } else {
            System.out.println("Result: \"" + word + "\" is NOT a Palindrome.");
            System.out.println("Explanation: FIFO order does NOT match LIFO order.");
        }

        // Test with a non-palindrome
        System.out.println("\n--- Testing with \"queue\" ---");
        String word2 = "queue";
        Queue<Character> q2 = new LinkedList<>();
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < word2.length(); i++) {
            q2.add(word2.charAt(i));
            s2.push(word2.charAt(i));
        }
        boolean isPalin2 = true;
        while (!q2.isEmpty() && !s2.isEmpty()) {
            if (q2.poll() != s2.pop()) {
                isPalin2 = false;
                break;
            }
        }
        System.out.println("Result: \"" + word2 + "\" " + (isPalin2 ? "IS" : "is NOT") + " a Palindrome.");

        System.out.println("\nProgram exiting...");
    }
}
