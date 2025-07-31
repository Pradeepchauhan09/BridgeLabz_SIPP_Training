package Level2;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int tempNumber = number;
        int count = 0;

        while (tempNumber != 0) {
            count++;
            tempNumber /= 10;
        }

        int[] digits = new int[count];
        int[] reversed = new int[count];

        tempNumber = number;
        for (int i = 0; i < count; i++) {
            digits[i] = tempNumber % 10;
            tempNumber /= 10;
        }

        for (int i = 0; i < count; i++) {
            reversed[i] = digits[count - 1 - i];
        }

        System.out.println("Digits in reverse order:");
        for (int i = 0; i < count; i++) {
            System.out.print(reversed[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
