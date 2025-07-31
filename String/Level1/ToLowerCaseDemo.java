import java.util.Scanner;

public class ToLowerCaseDemo {

    // Method to convert string to lowercase using charAt()
    public static String toLowerCaseUsingCharAt(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + ('a' - 'A'));
            }
            result.append(ch);
        }
        return result.toString();
    }

    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String input = scanner.nextLine();

        String lowerBuiltIn = input.toLowerCase();
        String lowerCharAt = toLowerCaseUsingCharAt(input);

        System.out.println("Built-in toLowerCase(): " + lowerBuiltIn);
        System.out.println("User-defined toLowerCase(): " + lowerCharAt);

        boolean areEqual = compareUsingCharAt(lowerBuiltIn, lowerCharAt);
        System.out.println("Are both lowercase strings equal? " + areEqual);

        scanner.close();
    }
}
