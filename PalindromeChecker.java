import java.util.Stack;

/**
 * UC11 - Object-Oriented Palindrome Service
 * 
 * Goal: Encapsulate palindrome logic in a class following OOP principles.
 * 
 * Key Concepts (OOP):
 * - Encapsulation: Bundling data and methods that operate on that data within a class.
 *   The internal implementation is hidden; only checkPalindrome() is exposed.
 * - Single Responsibility Principle: The PalindromeService class has one job - palindrome checking.
 * - Private fields and methods: Internal state is not directly accessible from outside.
 * - Constructor: Initializes the object with the input string.
 * 
 * Data Structure: Internal (Stack / char[])
 */
public class PalindromeChecker {

    // =========================================================
    // Inner class: PalindromeService (Encapsulated Palindrome Logic)
    // =========================================================
    static class PalindromeService {

        // Private field - encapsulated, not accessible from outside
        private String input;
        private String normalizedInput;

        // Constructor - initializes the service with input string
        public PalindromeService(String input) {
            this.input = input;
            this.normalizedInput = normalize(input);
        }

        // Private method - internal implementation detail (encapsulation)
        private String normalize(String str) {
            return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        }

        // Private method - palindrome check using Stack (internal logic)
        private boolean checkUsingStack() {
            Stack<Character> stack = new Stack<>();

            // Push all characters onto stack
            for (int i = 0; i < normalizedInput.length(); i++) {
                stack.push(normalizedInput.charAt(i));
            }

            // Pop and compare
            for (int i = 0; i < normalizedInput.length(); i++) {
                if (normalizedInput.charAt(i) != stack.pop()) {
                    return false;
                }
            }
            return true;
        }

        // Private method - palindrome check using two-pointer (internal logic)
        private boolean checkUsingTwoPointer() {
            char[] chars = normalizedInput.toCharArray();
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

        // PUBLIC method - the only exposed API (Single Responsibility)
        public boolean checkPalindrome() {
            // Internally uses two-pointer approach (implementation can change
            // without affecting the caller - this is encapsulation!)
            return checkUsingTwoPointer();
        }

        // PUBLIC method - get the original input
        public String getInput() {
            return input;
        }

        // PUBLIC method - get the normalized input for display
        public String getNormalizedInput() {
            return normalizedInput;
        }
    }

    // =========================================================
    // Main method - demonstrates OOP usage
    // =========================================================
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Palindrome Checker - UC11");
        System.out.println("   Object-Oriented Palindrome Service");
        System.out.println("=========================================");

        // Test cases
        String[] testCases = {
            "madam",
            "Race Car",
            "A man a plan a canal Panama",
            "Hello World",
            "Was it a car or a cat I saw?"
        };

        for (String testCase : testCases) {
            System.out.println("\n--- Test ---");

            // Create an instance of PalindromeService (Object creation)
            PalindromeService service = new PalindromeService(testCase);

            System.out.println("Original:   \"" + service.getInput() + "\"");
            System.out.println("Normalized: \"" + service.getNormalizedInput() + "\"");

            // Call the public method - caller doesn't know about internal implementation
            boolean result = service.checkPalindrome();

            if (result) {
                System.out.println("Result:     PALINDROME!");
            } else {
                System.out.println("Result:     NOT a palindrome.");
            }
        }

        // OOP Concepts Summary
        System.out.println("\n=========================================");
        System.out.println("OOP Concepts Demonstrated:");
        System.out.println("  1. Encapsulation: Private fields (input, normalizedInput)");
        System.out.println("     and private methods (normalize, checkUsingStack, etc.)");
        System.out.println("     are hidden. Only checkPalindrome() is exposed.");
        System.out.println("  2. Single Responsibility: PalindromeService does only");
        System.out.println("     one thing - palindrome checking.");
        System.out.println("  3. Constructor: Initializes the object state.");
        System.out.println("=========================================");

        System.out.println("\nProgram exiting...");
    }
}
