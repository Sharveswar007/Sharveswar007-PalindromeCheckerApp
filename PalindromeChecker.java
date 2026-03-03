/**
 * UC3 - Palindrome Check Using String Reverse
 * 
 * Goal: Check whether a string is a palindrome by reversing it using a loop.
 * 
 * Key Concepts:
 * - Loop (for loop): Iterates through characters in reverse order.
 * - String Immutability: String objects are immutable; every modification creates a new String.
 * - String Concatenation (+): Builds the reversed string character by character.
 * - equals() Method: Compares actual content of two String objects instead of memory references.
 * 
 * Data Structure: String
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Palindrome Checker - UC3");
        System.out.println("   String Reverse Using Loop");
        System.out.println("=========================================");

        String original = "racecar";
        System.out.println("Original String: \"" + original + "\"");

        // Reverse the string using a for loop
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
            // Note: String concatenation creates a new String object each time
            // due to String immutability. This is inefficient for large strings.
        }

        System.out.println("Reversed String: \"" + reversed + "\"");

        // Compare original and reversed using equals() method
        // equals() compares the content, not the reference
        if (original.equals(reversed)) {
            System.out.println("Result: \"" + original + "\" IS a Palindrome!");
        } else {
            System.out.println("Result: \"" + original + "\" is NOT a Palindrome.");
        }

        // Demonstrate with a non-palindrome
        System.out.println("\n--- Testing with another word ---");
        String word2 = "hello";
        System.out.println("Original String: \"" + word2 + "\"");

        String reversed2 = "";
        for (int i = word2.length() - 1; i >= 0; i--) {
            reversed2 = reversed2 + word2.charAt(i);
        }

        System.out.println("Reversed String: \"" + reversed2 + "\"");

        if (word2.equals(reversed2)) {
            System.out.println("Result: \"" + word2 + "\" IS a Palindrome!");
        } else {
            System.out.println("Result: \"" + word2 + "\" is NOT a Palindrome.");
        }

        System.out.println("\nProgram exiting...");
    }
}
