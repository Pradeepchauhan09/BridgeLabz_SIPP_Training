import java.util.Scanner;

public class ToUpperCaseDemo {

    // Method to convert string to uppercase using charAt()
    public static String toUpperCaseUsingCharAt(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - ('a' - 'A'));
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

        String upperBuiltIn = input.toUpperCase();
        String upperCharAt = toUpperCaseUsingCharAt(input);

        System.out.println("Built-in toUpperCase(): " + upperBuiltIn);
        System.out.println("User-defined toUpperCase(): " + upperCharAt);

        boolean areEqual = compareUsingCharAt(upperBuiltIn, upperCharAt);
        System.out.println("Are both uppercase strings equal? " + areEqual);

        scanner.close();
    }
}
