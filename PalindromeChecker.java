import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * UC12 - Strategy Pattern for Palindrome Algorithms
 * 
 * Goal: Choose a palindrome algorithm dynamically using the Strategy Pattern.
 * 
 * Key Concepts:
 * - Interface: Defines a contract (PalindromeStrategy) that all strategies must follow.
 * - Polymorphism: Different strategy implementations can be used interchangeably.
 * - Strategy Pattern: A behavioral design pattern that lets you define a family of algorithms,
 *   put each of them into a separate class, and make their objects interchangeable.
 * - Runtime Injection: The strategy is selected and injected at runtime.
 * 
 * Data Structure: Varies per strategy (Stack, Deque, char[])
 */
public class PalindromeChecker {

    // =========================================================
    // Strategy Interface - defines the contract
    // =========================================================
    interface PalindromeStrategy {
        boolean isPalindrome(String input);
        String getStrategyName();
    }

    // =========================================================
    // Strategy 1: Stack-Based Strategy (LIFO)
    // =========================================================
    static class StackStrategy implements PalindromeStrategy {

        @Override
        public boolean isPalindrome(String input) {
            String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < normalized.length(); i++) {
                stack.push(normalized.charAt(i));
            }

            for (int i = 0; i < normalized.length(); i++) {
                if (normalized.charAt(i) != stack.pop()) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String getStrategyName() {
            return "Stack-Based Strategy (LIFO)";
        }
    }

    // =========================================================
    // Strategy 2: Deque-Based Strategy (Double Ended)
    // =========================================================
    static class DequeStrategy implements PalindromeStrategy {

        @Override
        public boolean isPalindrome(String input) {
            String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            Deque<Character> deque = new ArrayDeque<>();

            for (int i = 0; i < normalized.length(); i++) {
                deque.addLast(normalized.charAt(i));
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String getStrategyName() {
            return "Deque-Based Strategy (Double Ended)";
        }
    }

    // =========================================================
    // Strategy 3: Two-Pointer Strategy (char[])
    // =========================================================
    static class TwoPointerStrategy implements PalindromeStrategy {

        @Override
        public boolean isPalindrome(String input) {
            String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            char[] chars = normalized.toCharArray();
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

        @Override
        public String getStrategyName() {
            return "Two-Pointer Strategy (char[])";
        }
    }

    // =========================================================
    // Strategy 4: Recursive Strategy
    // =========================================================
    static class RecursiveStrategy implements PalindromeStrategy {

        @Override
        public boolean isPalindrome(String input) {
            String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            return checkRecursive(normalized, 0, normalized.length() - 1);
        }

        private boolean checkRecursive(String str, int start, int end) {
            if (start >= end) return true;
            if (str.charAt(start) != str.charAt(end)) return false;
            return checkRecursive(str, start + 1, end - 1);
        }

        @Override
        public String getStrategyName() {
            return "Recursive Strategy (Call Stack)";
        }
    }

    // =========================================================
    // Context class - uses a strategy (Polymorphism in action)
    // =========================================================
    static class PalindromeContext {
        private PalindromeStrategy strategy;

        // Inject strategy at runtime
        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean executeStrategy(String input) {
            if (strategy == null) {
                throw new IllegalStateException("No strategy set! Please set a strategy first.");
            }
            return strategy.isPalindrome(input);
        }

        public String getActiveStrategyName() {
            return strategy != null ? strategy.getStrategyName() : "None";
        }
    }

    // =========================================================
    // Main method - demonstrates Strategy Pattern
    // =========================================================
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Palindrome Checker - UC12");
        System.out.println("   Strategy Pattern");
        System.out.println("=========================================");

        String testWord = "A man a plan a canal Panama";
        System.out.println("Test Input: \"" + testWord + "\"\n");

        // Create context
        PalindromeContext context = new PalindromeContext();

        // Array of all available strategies
        PalindromeStrategy[] strategies = {
            new StackStrategy(),
            new DequeStrategy(),
            new TwoPointerStrategy(),
            new RecursiveStrategy()
        };

        // Dynamically switch strategies at runtime (Polymorphism)
        for (PalindromeStrategy strategy : strategies) {
            // Inject strategy at runtime
            context.setStrategy(strategy);

            System.out.println("Strategy: " + context.getActiveStrategyName());
            boolean result = context.executeStrategy(testWord);
            System.out.println("Result:   " + (result ? "PALINDROME" : "NOT a palindrome"));
            System.out.println();
        }

        // Design Pattern Summary
        System.out.println("=========================================");
        System.out.println("Strategy Pattern Concepts:");
        System.out.println("  1. Interface (PalindromeStrategy): Defines the contract.");
        System.out.println("  2. Concrete Strategies: StackStrategy, DequeStrategy,");
        System.out.println("     TwoPointerStrategy, RecursiveStrategy.");
        System.out.println("  3. Context (PalindromeContext): Uses a strategy via interface.");
        System.out.println("  4. Polymorphism: All strategies are interchangeable.");
        System.out.println("  5. Runtime Injection: Strategy is set dynamically.");
        System.out.println("=========================================");

        System.out.println("\nProgram exiting...");
    }
}
