/**
 * UC4 - Character Array Based Palindrome Check
 * 
 * Goal: Convert string to character array and compare characters
 *       using a two-pointer approach.
 * 
 * Key Concepts:
 * - Character Array (char[]): Primitive array to store individual characters for index-based access.
 * - Array Indexing: Accessing elements using index positions starting from 0.
 * - Two-Pointer Technique: One pointer starts from beginning, other from end.
 * - Time Complexity Awareness: Efficient comparison without creating extra objects.
 * 
 * Data Structure: char[]
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Palindrome Checker - UC4");
        System.out.println("   Character Array & Two-Pointer");
        System.out.println("=========================================");

        String word = "level";
        System.out.println("Checking word: \"" + word + "\"");

        // Convert string to character array
        char[] charArray = word.toCharArray();

        System.out.println("Character Array: ");
        for (int i = 0; i < charArray.length; i++) {
            System.out.println("  Index " + i + " -> '" + charArray[i] + "'");
        }

        // Two-pointer approach
        int start = 0;                      // Pointer at the beginning
        int end = charArray.length - 1;     // Pointer at the end
        boolean isPalindrome = true;

        System.out.println("\n--- Two-Pointer Comparison ---");
        while (start < end) {
            System.out.println("Comparing charArray[" + start + "]='" + charArray[start] 
                             + "' with charArray[" + end + "]='" + charArray[end] + "'");

            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break;
            }
            start++;    // Move start pointer forward
            end--;      // Move end pointer backward
        }

        // Display result
        if (isPalindrome) {
            System.out.println("\nResult: \"" + word + "\" IS a Palindrome!");
        } else {
            System.out.println("\nResult: \"" + word + "\" is NOT a Palindrome.");
        }

        // Test with a non-palindrome
        System.out.println("\n--- Testing with \"java\" ---");
        String word2 = "java";
        char[] charArray2 = word2.toCharArray();
        int s = 0, e = charArray2.length - 1;
        boolean isPalin2 = true;

        while (s < e) {
            if (charArray2[s] != charArray2[e]) {
                isPalin2 = false;
                break;
            }
            s++;
            e--;
        }

        if (isPalin2) {
            System.out.println("Result: \"" + word2 + "\" IS a Palindrome!");
        } else {
            System.out.println("Result: \"" + word2 + "\" is NOT a Palindrome.");
        }

        System.out.println("\nProgram exiting...");
    }
}
