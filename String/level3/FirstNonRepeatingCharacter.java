import java.util.Scanner;

public class FirstNonRepeatingCharacter {

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

    public static char firstNonRepeatingChar(String text) {
        int length = stringLength(text);
        int[] freq = new int[256];
        for (int i = 0; i < length; i++) {
            freq[text.charAt(i)]++;
        }
        for (int i = 0; i < length; i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0'; // null char if none found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char result = firstNonRepeatingChar(input);
        if (result == '\0') {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println("First non-repeating character: " + result);
        }

        scanner.close();
    }
}
