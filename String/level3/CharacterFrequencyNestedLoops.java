import java.util.Scanner;

public class CharacterFrequencyNestedLoops {

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

    public static String[][] charFrequencyNestedLoops(String text) {
        int length = stringLength(text);
        char[] chars = new char[length];
        int[] freq = new int[length];

        for (int i = 0; i < length; i++) {
            chars[i] = text.charAt(i);
            freq[i] = 1;
        }

        for (int i = 0; i < length; i++) {
            if (chars[i] == '0') continue;
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int uniqueCount = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') uniqueCount++;
        }

        String[][] result = new String[uniqueCount][2];
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                result[idx][0] = Character.toString(chars[i]);
                result[idx][1] = Integer.toString(freq[i]);
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[][] freq = charFrequencyNestedLoops(input);
        System.out.println("Character\tFrequency");
        for (int i = 0; i < freq.length; i++) {
            System.out.println(freq[i][0] + "\t\t" + freq[i][1]);
        }

        scanner.close();
    }
}
