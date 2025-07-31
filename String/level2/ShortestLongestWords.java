import java.util.Scanner;

public class ShortestLongestWords {

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

    public static String[] splitUsingCharAt(String text) {
        int length = stringLength(text);
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        int[] spaceIndexes = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }
        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount - 1; i++) {
            int end = spaceIndexes[i];
            StringBuilder sb = new StringBuilder();
            for (int j = start; j < end; j++) {
                sb.append(text.charAt(j));
            }
            words[i] = sb.toString();
            start = end + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = start; j < length; j++) {
            sb.append(text.charAt(j));
        }
        words[wordCount - 1] = sb.toString();
        return words;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(stringLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestLongest(String[][] wordsLengths) {
        int shortestIndex = 0;
        int longestIndex = 0;
        int shortestLength = Integer.parseInt(wordsLengths[0][1]);
        int longestLength = Integer.parseInt(wordsLengths[0][1]);

        for (int i = 1; i < wordsLengths.length; i++) {
            int length = Integer.parseInt(wordsLengths[i][1]);
            if (length < shortestLength) {
                shortestLength = length;
                shortestIndex = i;
            }
            if (length > longestLength) {
                longestLength = length;
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] words = splitUsingCharAt(input);
        String[][] wordsLengths = wordsWithLengths(words);
        int[] shortestLongest = findShortestLongest(wordsLengths);

        System.out.println("Shortest word: " + wordsLengths[shortestLongest[0]][0] + " Length: " + Integer.parseInt(wordsLengths[shortestLongest[0]][1]));
        System.out.println("Longest word: " + wordsLengths[shortestLongest[1]][0] + " Length: " + Integer.parseInt(wordsLengths[shortestLongest[1]][1]));

        scanner.close();
    }
}
