import java.util.Scanner;

public class StringLengthWithoutLengthMethod {

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int lengthUserDefined = stringLength(input);
        int lengthBuiltIn = input.length();
        System.out.println("User-defined length: " + lengthUserDefined);
        System.out.println("Built-in length: " + lengthBuiltIn);
        scanner.close();
    }
}
