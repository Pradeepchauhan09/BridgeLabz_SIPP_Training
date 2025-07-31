import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    // Method to generate IllegalArgumentException
    public static void generateException(String str) {
        // start index greater than end index to generate exception
        System.out.println(str.substring(5, 2));
    }

    // Method to handle IllegalArgumentException
    public static void handleException(String str) {
        try {
            System.out.println(str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.next();

        // Call method to generate exception (will cause program to crash if not handled)
        try {
            generateException(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception generated: " + e.getMessage());
        }

        // Call method to handle exception gracefully
        handleException(input);

        scanner.close();
    }
}
