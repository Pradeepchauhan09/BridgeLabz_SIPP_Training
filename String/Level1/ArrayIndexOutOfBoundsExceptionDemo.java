import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names, int index) {
        System.out.println("Accessing index: " + index);
        System.out.println("Name: " + names[index]);
    }

    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names, int index) {
        try {
            System.out.println("Accessing index: " + index);
            System.out.println("Name: " + names[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = {"Alice", "Bob", "Charlie", "Diana"};

        System.out.print("Enter an index to access in the names array: ");
        int index = scanner.nextInt();

        // Call method to generate exception (will cause program to crash if not handled)
        try {
            generateException(names, index);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception generated: " + e.getMessage());
        }

        // Call method to handle exception gracefully
        handleException(names, index);

        scanner.close();
    }
}
