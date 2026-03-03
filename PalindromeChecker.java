/**
 * UC10 - Case-Insensitive & Space-Ignored Palindrome
 * 
 * Goal: Ignore spaces, special characters, and case while checking a palindrome.
 * 
 * Key Concepts:
 * - String Pre-processing: Normalize the string before checking.
 * - Regular Expressions: Used to remove non-alphanumeric characters.
 * - toLowerCase(): Converts string to lowercase for case-insensitive comparison.
 * - replaceAll(): Uses regex to strip unwanted characters.
 * 
 * Data Structure: String / char[]
 */
public class PalindromeChecker {

    /**
     * Normalize the input string:
     * - Remove all non-alphanumeric characters using regex
     * - Convert to lowercase for case-insensitive comparison
     */
    static String normalize(String input) {
        // [^a-zA-Z0-9] matches any character that is NOT alphanumeric
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "");
        return cleaned.toLowerCase();
    }

    /**
     * Check palindrome using two-pointer technique on normalized string.
     */
    static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Palindrome Checker - UC10");
        System.out.println("   Case-Insensitive & Space-Ignored");
        System.out.println("=========================================");

        // Test cases with spaces, mixed case, and special characters
        String[] testCases = {
            "A man a plan a canal Panama",
            "Race Car",
            "Was it a car or a cat I saw?",
            "No lemon, no melon",
            "Hello World",
            "Madam, I'm Adam!"
        };

        for (String testCase : testCases) {
            System.out.println("\n--- Test ---");
            System.out.println("Original:   \"" + testCase + "\"");

            // Step 1: Normalize the string
            String normalized = normalize(testCase);
            System.out.println("Normalized: \"" + normalized + "\"");

            // Step 2: Check palindrome
            boolean result = isPalindrome(normalized);

            if (result) {
                System.out.println("Result:     PALINDROME!");
            } else {
                System.out.println("Result:     NOT a palindrome.");
            }
        }

        // Demonstrate regex behavior
        System.out.println("\n=========================================");
        System.out.println("Regex Explanation:");
        System.out.println("  [^a-zA-Z0-9] -> Matches any non-alphanumeric character");
        System.out.println("  replaceAll() -> Removes all matched characters");
        System.out.println("  toLowerCase() -> Makes comparison case-insensitive");
        System.out.println("=========================================");

        System.out.println("\nProgram exiting...");
    }
}
