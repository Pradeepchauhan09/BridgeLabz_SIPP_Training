import java.util.Scanner;

public class TrimString {

    public static int[] trimIndices(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    public static String substringUsingCharAt(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

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
        String input = scanner.nextLine();

        int[] indices = trimIndices(input);
        String trimmedUserDefined = substringUsingCharAt(input, indices[0], indices[1]);
        String trimmedBuiltIn = input.trim();

        System.out.println("User-defined trim: '" + trimmedUserDefined + "'");
        System.out.println("Built-in trim: '" + trimmedBuiltIn + "'");

        boolean areEqual = compareUsingCharAt(trimmedUserDefined, trimmedBuiltIn);
        System.out.println("Are both trimmed strings equal? " + areEqual);

        scanner.close();
    }
}
