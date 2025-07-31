package Level1;
import java.util.Scanner;

public class FootballTeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
                System.out.print("Enter height of player " + (i + 1) + ": ");
            }
            heights[i] = scanner.nextDouble();
        }

        for (double height : heights) {
            sum += height;
        }

        double mean = sum / heights.length;
        System.out.println("Mean height of the football team: " + mean);

        scanner.close();
    }
}
