import java.util.Stack;

/**
 * UC5 - Stack-Based Palindrome Checker
 * 
 * Goal: Use a Stack to reverse characters and validate palindrome.
 * 
 * Key Concepts:
 * - Stack: A linear data structure that follows Last In First Out (LIFO) principle.
 * - Push Operation: Inserts characters into the stack.
 * - Pop Operation: Removes characters from the stack in reverse order.
 * - Reversal Logic: Stack naturally reverses the order of elements.
 * 
 * Data Structure: Stack
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Palindrome Checker - UC5");
        System.out.println("   Stack-Based Approach (LIFO)");
        System.out.println("=========================================");

        String word = "madam";
        System.out.println("Checking word: \"" + word + "\"");

        // Create a Stack to hold characters
        Stack<Character> stack = new Stack<>();

        // Push each character of the string onto the stack
        System.out.println("\n--- Pushing characters onto Stack ---");
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
            System.out.println("  Pushed: '" + word.charAt(i) + "' -> Stack: " + stack);
        }

        // Pop characters and build the reversed string
        System.out.println("\n--- Popping characters from Stack ---");
        String reversed = "";
        for (int i = 0; i < word.length(); i++) {
            char popped = stack.pop();
            reversed = reversed + popped;
            System.out.println("  Popped: '" + popped + "' -> Reversed so far: \"" + reversed + "\"");
        }

        // Compare original with reversed
        System.out.println("\nOriginal: \"" + word + "\"");
        System.out.println("Reversed: \"" + reversed + "\"");

        if (word.equals(reversed)) {
            System.out.println("Result: \"" + word + "\" IS a Palindrome!");
        } else {
            System.out.println("Result: \"" + word + "\" is NOT a Palindrome.");
        }

        // Test with a non-palindrome
        System.out.println("\n--- Testing with \"stack\" ---");
        String word2 = "stack";
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < word2.length(); i++) {
            stack2.push(word2.charAt(i));
        }
        String reversed2 = "";
        while (!stack2.isEmpty()) {
            reversed2 = reversed2 + stack2.pop();
        }
        if (word2.equals(reversed2)) {
            System.out.println("Result: \"" + word2 + "\" IS a Palindrome!");
        } else {
            System.out.println("Result: \"" + word2 + "\" is NOT a Palindrome.");
        }

        System.out.println("\nProgram exiting...");
    }
}
