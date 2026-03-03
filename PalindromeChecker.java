/**
 * UC1 - Application Entry & Welcome Message
 * 
 * Goal: Display a welcome message and application information
 *       when the PalindromeChecker App starts.
 * 
 * Key Concepts:
 * - Class: Acts as a container for the Palindrome Checker application logic.
 * - Main Method: Entry point of the Java application (public static void main(String[] args)).
 * - Static Keyword: Allows the JVM to invoke main() without creating an object.
 * - Console Output: System.out.println() displays messages on the console.
 * - Application Flow Control: Defines startup behavior before palindrome processing begins.
 * 
 * Data Structure: None (Console based execution)
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        // Display application name
        System.out.println("=========================================");
        System.out.println("   Welcome to Palindrome Checker App");
        System.out.println("=========================================");

        // Display application version
        System.out.println("Version: 1.0.0");
        System.out.println("Author: Sharveswar");
        System.out.println();

        // Application information
        System.out.println("This application checks whether a given string is a palindrome.");
        System.out.println("A palindrome reads the same forward and backward.");
        System.out.println();

        System.out.println("Application started successfully!");
        System.out.println("Program exiting...");
    }
}
