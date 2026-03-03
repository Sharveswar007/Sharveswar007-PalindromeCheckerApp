/**
 * UC2 - Print a Hardcoded Palindrome Result
 * 
 * Goal: Display whether a hardcoded string is a palindrome.
 * 
 * Key Concepts:
 * - Class: Even the simplest program must be written inside a class.
 * - Main Method: Entry point (public static void main(String[] args)).
 * - Static Keyword: Allows JVM to invoke main() without creating an object.
 * - String: Built-in Java class to store and manipulate textual data.
 * - String Literal: Text enclosed in double quotes, stored in the String constant pool.
 * - Conditional Statement (if-else): Evaluates whether the string satisfies palindrome condition.
 * - Console Output: System.out.println() displays the result.
 * 
 * Data Structure: String
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Palindrome Checker - UC2");
        System.out.println("   Hardcoded Palindrome Check");
        System.out.println("=========================================");

        // Hardcoded string to check
        String word = "madam";
        System.out.println("Checking word: \"" + word + "\"");

        // Reverse the string manually using charAt
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        // Check if the original string equals the reversed string
        if (word.equals(reversed)) {
            System.out.println("\"" + word + "\" is a Palindrome!");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome.");
        }

        System.out.println("\nProgram exiting...");
    }
}
