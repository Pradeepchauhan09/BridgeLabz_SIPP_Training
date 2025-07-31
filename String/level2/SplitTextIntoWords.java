import java.util.Scanner;

public class SplitTextIntoWords {

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

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] userDefinedWords = splitUsingCharAt(input);
        String[] builtInWords = input.split(" ");

        System.out.println("User-defined split:");
        for (String word : userDefinedWords) {
            System.out.println(word);
        }

        System.out.println("Built-in split:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        boolean areEqual = compareStringArrays(userDefinedWords, builtInWords);
        System.out.println("Are both splits equal? " + areEqual);

        scanner.close();
    }
}
