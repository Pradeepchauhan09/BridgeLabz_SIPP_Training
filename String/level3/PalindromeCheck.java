import java.util.Scanner;

public class PalindromeCheck {

    public static int stringLength(String str) {
        int count = 0;
        try {
            while(true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    // Logic 1: Compare characters from start and end
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = stringLength(text) - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive method
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using character arrays and reverse
    public static boolean isPalindromeUsingArrays(String text) {
        int length = stringLength(text);
        char[] original = new char[length];
        char[] reverse = new char[length];
        for (int i = 0; i < length; i++) {
            original[i] = text.charAt(i);
            reverse[length - 1 - i] = text.charAt(i);
        }
        for (int i = 0; i < length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("Iterative check: " + isPalindromeIterative(input));
        System.out.println("Recursive check: " + isPalindromeRecursive(input, 0, stringLength(input) - 1));
        System.out.println("Array check: " + isPalindromeUsingArrays(input));

        scanner.close();
    }
}
