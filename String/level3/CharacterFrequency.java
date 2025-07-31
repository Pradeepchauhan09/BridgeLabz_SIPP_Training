import java.util.Scanner;

public class CharacterFrequency {

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

    public static String[][] charFrequency(String text) {
        int length = stringLength(text);
        int[] freq = new int[256];
        for (int i = 0; i < length; i++) {
            freq[text.charAt(i)]++;
        }
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) uniqueCount++;
        }
        String[][] result = new String[uniqueCount][2];
        int idx = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[idx][0] = Character.toString((char)i);
                result[idx][1] = Integer.toString(freq[i]);
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[][] freq = charFrequency(input);
        System.out.println("Character\tFrequency");
        for (int i = 0; i < freq.length; i++) {
            System.out.println(freq[i][0] + "\t\t" + freq[i][1]);
        }

        scanner.close();
    }
}
