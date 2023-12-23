import java.util.Stack;

public class PalindromeChecker {
    public static boolean isPalindrome(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string is null");
        }

        Stack<Character> stack = new Stack<>();

        // Push each character onto the stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // Pop characters from the stack and compare with the original string
        for (char ch : input.toCharArray()) {
            if (stack.isEmpty() || stack.pop() != ch) {
                return false; // Characters do not match, not a palindrome
            }
        }

        return stack.isEmpty(); // If the stack is empty, it's a palindrome
    }

    public static void main(String[] args) {
        String palindrome1 = "radar";
        String palindrome2 = "level";
        String notPalindrome = "hello";

        System.out.println(palindrome1 + " is a palindrome: " + isPalindrome(palindrome1));
        System.out.println(palindrome2 + " is a palindrome: " + isPalindrome(palindrome2));
        System.out.println(notPalindrome + " is a palindrome: " + isPalindrome(notPalindrome));
    }
}
