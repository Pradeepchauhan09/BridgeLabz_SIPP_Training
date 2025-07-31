import java.util.Scanner;

public class AnagramCheck {

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

    public static boolean areAnagrams(String text1, String text2) {
        int len1 = stringLength(text1);
        int len2 = stringLength(text2);
        if (len1 != len2) {
            return false;
        }
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        for (int i = 0; i < len1; i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        boolean result = areAnagrams(input1, input2);
        System.out.println("Are the two texts anagrams? " + result);

        scanner.close();
    }
}
