/**
 * UC8 - Linked List Based Palindrome Checker
 * 
 * Goal: Check palindrome using a singly linked list.
 * 
 * Key Concepts:
 * - Singly Linked List: A dynamic data structure where elements are connected using node references.
 * - Node Traversal: Sequential access to elements using next references.
 * - Fast and Slow Pointer Technique: Used to find the middle of the linked list efficiently.
 * - In-Place Reversal: Reverses the second half of the list without extra memory.
 * 
 * Data Structure: Singly Linked List
 */
public class PalindromeChecker {

    // Inner class representing a Node in the Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Convert a string to a singly linked list
    static Node stringToLinkedList(String str) {
        if (str == null || str.length() == 0) return null;

        Node head = new Node(str.charAt(0));
        Node current = head;
        for (int i = 1; i < str.length(); i++) {
            current.next = new Node(str.charAt(i));
            current = current.next;
        }
        return head;
    }

    // Print the linked list
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.data + "]");
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Reverse a linked list and return the new head
    static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Check if the linked list is a palindrome using fast/slow pointer technique
    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle using fast and slow pointers
        Node slow = head;
        Node fast = head;

        System.out.println("\n--- Finding middle using Fast & Slow Pointers ---");
        while (fast != null && fast.next != null) {
            slow = slow.next;        // Moves 1 step
            fast = fast.next.next;   // Moves 2 steps
        }
        System.out.println("  Middle node: '" + slow.data + "'");

        // Step 2: Reverse the second half of the linked list
        System.out.println("\n--- Reversing second half ---");
        Node secondHalfHead = reverseList(slow);

        // Step 3: Compare first half and reversed second half
        System.out.println("\n--- Comparing halves ---");
        Node firstHalf = head;
        Node secondHalf = secondHalfHead;
        boolean result = true;

        while (secondHalf != null) {
            System.out.println("  Comparing: '" + firstHalf.data + "' vs '" + secondHalf.data + "'"
                             + (firstHalf.data == secondHalf.data ? " -> MATCH" : " -> MISMATCH"));

            if (firstHalf.data != secondHalf.data) {
                result = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Palindrome Checker - UC8");
        System.out.println("   Linked List Based Approach");
        System.out.println("=========================================");

        String word = "madam";
        System.out.println("Checking word: \"" + word + "\"");

        // Convert string to linked list
        Node head = stringToLinkedList(word);

        System.out.println("\nLinked List representation:");
        printList(head);

        // Check palindrome
        boolean result = isPalindrome(head);

        System.out.println();
        if (result) {
            System.out.println("Result: \"" + word + "\" IS a Palindrome!");
        } else {
            System.out.println("Result: \"" + word + "\" is NOT a Palindrome.");
        }

        // Test with a non-palindrome
        System.out.println("\n--- Testing with \"linked\" ---");
        String word2 = "linked";
        Node head2 = stringToLinkedList(word2);
        printList(head2);
        boolean result2 = isPalindrome(head2);
        System.out.println("Result: \"" + word2 + "\" " + (result2 ? "IS" : "is NOT") + " a Palindrome.");

        System.out.println("\nProgram exiting...");
    }
}
