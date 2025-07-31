import java.util.Scanner;

public class TocharArray {

    // Method to convert string to char array without using toCharArray()
    public static char[] stringToCharArray(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = scanner.next();

        char[] userDefinedArray = stringToCharArray(input);
        char[] builtInArray = input.toCharArray();

        System.out.println("User-defined char array: " + new String(userDefinedArray));
        System.out.println("Built-in toCharArray(): " + new String(builtInArray));

        boolean areEqual = compareCharArrays(userDefinedArray, builtInArray);
        System.out.println("Are both char arrays equal? " + areEqual);

        scanner.close();
    }
}
