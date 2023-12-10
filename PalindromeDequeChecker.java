import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeDequeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("True. The string is a palindrome.");
        } else {
            System.out.println("False. The string is not a palindrome.");
        }
    }

    private static boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        // Adding characters to the rear of the deque
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        // Checking if the string is a palindrome
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}
