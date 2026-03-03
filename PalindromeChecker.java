/**
 * UC9 - Recursive Palindrome Checker
 * 
 * Goal: Check palindrome using recursion.
 * 
 * Key Concepts:
 * - Recursion: A technique where a method calls itself to solve smaller subproblems.
 * - Base Condition: Prevents infinite recursion and terminates the recursive calls.
 * - Call Stack: Memory structure used to manage method calls during recursion.
 * 
 * Data Structure: Call Stack (implicit)
 */
public class PalindromeChecker {

    /**
     * Recursive method to check if a string is a palindrome.
     * 
     * @param str   The string to check
     * @param start The starting index
     * @param end   The ending index
     * @param depth The recursion depth (for visualization)
     * @return true if the string is a palindrome
     */
    static boolean isPalindromeRecursive(String str, int start, int end, int depth) {
        // Indentation for visualizing recursion depth
        String indent = "  ".repeat(depth);

        // Base Condition 1: If start crosses end, all characters matched
        if (start >= end) {
            System.out.println(indent + "Base case reached: start(" + start + ") >= end(" + end + ") -> TRUE");
            return true;
        }

        System.out.println(indent + "Comparing str[" + start + "]='" + str.charAt(start) 
                         + "' with str[" + end + "]='" + str.charAt(end) + "'");

        // If characters at start and end don't match, it's not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            System.out.println(indent + "MISMATCH -> FALSE");
            return false;
        }

        System.out.println(indent + "MATCH -> Recursing deeper...");

        // Recursive call: move start forward and end backward
        return isPalindromeRecursive(str, start + 1, end - 1, depth + 1);
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Palindrome Checker - UC9");
        System.out.println("   Recursive Approach");
        System.out.println("=========================================");

        String word = "racecar";
        System.out.println("Checking word: \"" + word + "\"");

        System.out.println("\n--- Recursive Call Trace ---");
        boolean result = isPalindromeRecursive(word, 0, word.length() - 1, 0);

        System.out.println();
        if (result) {
            System.out.println("Result: \"" + word + "\" IS a Palindrome!");
        } else {
            System.out.println("Result: \"" + word + "\" is NOT a Palindrome.");
        }

        // Demonstrate the call stack concept
        System.out.println("\n--- Call Stack Visualization ---");
        System.out.println("Each recursive call adds a new frame to the call stack:");
        System.out.println("  main() -> isPalindromeRecursive(0,6)");
        System.out.println("              -> isPalindromeRecursive(1,5)");
        System.out.println("                   -> isPalindromeRecursive(2,4)");
        System.out.println("                        -> isPalindromeRecursive(3,3) [Base Case]");
        System.out.println("As each call returns, frames are removed from the stack (LIFO).");

        // Test with a non-palindrome
        System.out.println("\n--- Testing with \"recursion\" ---");
        String word2 = "recursion";
        boolean result2 = isPalindromeRecursive(word2, 0, word2.length() - 1, 0);
        System.out.println("Result: \"" + word2 + "\" " + (result2 ? "IS" : "is NOT") + " a Palindrome.");

        System.out.println("\nProgram exiting...");
    }
}
