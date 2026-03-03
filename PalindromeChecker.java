import java.util.ArrayDeque;
import java.util.Deque;

/**
 * UC7 - Deque-Based Optimized Palindrome Checker
 * 
 * Goal: Use a Deque (Double Ended Queue) to compare front and rear elements.
 * 
 * Key Concepts:
 * - Deque (Double Ended Queue): Allows insertion and deletion from both front and rear ends.
 * - Front and Rear Access: Enables direct comparison of first and last characters.
 * - Optimized Data Handling: Eliminates the need for separate reversal data structures.
 * 
 * Data Structure: Deque
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Palindrome Checker - UC7");
        System.out.println("   Deque-Based Approach (Double Ended)");
        System.out.println("=========================================");

        String word = "level";
        System.out.println("Checking word: \"" + word + "\"");

        // Create a Deque and insert all characters
        Deque<Character> deque = new ArrayDeque<>();

        System.out.println("\n--- Inserting characters into Deque ---");
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
            System.out.println("  Added '" + word.charAt(i) + "' to rear -> Deque: " + deque);
        }

        // Compare front and rear elements
        System.out.println("\n--- Comparing Front and Rear ---");
        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();   // Remove from front
            char rear = deque.removeLast();     // Remove from rear

            System.out.println("  Front: '" + front + "' vs Rear: '" + rear + "'"
                             + (front == rear ? " -> MATCH" : " -> MISMATCH"));

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        // If one character remains in the middle, it doesn't affect palindrome check
        if (!deque.isEmpty()) {
            System.out.println("  Middle character: '" + deque.peek() + "' (no comparison needed)");
        }

        // Display result
        System.out.println();
        if (isPalindrome) {
            System.out.println("Result: \"" + word + "\" IS a Palindrome!");
        } else {
            System.out.println("Result: \"" + word + "\" is NOT a Palindrome.");
        }

        // Test with a non-palindrome
        System.out.println("\n--- Testing with \"deque\" ---");
        String word2 = "deque";
        Deque<Character> deque2 = new ArrayDeque<>();
        for (int i = 0; i < word2.length(); i++) {
            deque2.addLast(word2.charAt(i));
        }
        boolean isPalin2 = true;
        while (deque2.size() > 1) {
            if (deque2.removeFirst() != deque2.removeLast()) {
                isPalin2 = false;
                break;
            }
        }
        System.out.println("Result: \"" + word2 + "\" " + (isPalin2 ? "IS" : "is NOT") + " a Palindrome.");

        System.out.println("\nProgram exiting...");
    }
}
