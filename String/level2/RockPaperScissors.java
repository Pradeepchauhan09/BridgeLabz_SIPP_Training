import java.util.Scanner;

public class RockPaperScissors {

    public static String getComputerChoice() {
        double rand = Math.random();
        if (rand < 1.0/3) {
            return "rock";
        } else if (rand < 2.0/3) {
            return "paper";
        } else {
            return "scissors";
        }
    }

    public static String findWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Draw";
        }
        if (userChoice.equals("rock")) {
            return computerChoice.equals("scissors") ? "User" : "Computer";
        } else if (userChoice.equals("paper")) {
            return computerChoice.equals("rock") ? "User" : "Computer";
        } else if (userChoice.equals("scissors")) {
            return computerChoice.equals("paper") ? "User" : "Computer";
        }
        return "Invalid";
    }

    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        double userPercent = (userWins * 100.0) / totalGames;
        double computerPercent = (computerWins * 100.0) / totalGames;
        String[][] stats = {
            {"User Wins", String.valueOf(userWins)},
            {"Computer Wins", String.valueOf(computerWins)},
            {"User Win %", String.format("%.2f", userPercent)},
            {"Computer Win %", String.format("%.2f", computerPercent)}
        };
        return stats;
    }

    public static void displayResults(String[][] results) {
        System.out.println("Game\tUser Choice\tComputer Choice\tWinner");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i][0] + "\t" + results[i][1] + "\t\t" + results[i][2] + "\t\t" + results[i][3]);
        }
    }

    public static void displayStats(String[][] stats) {
        System.out.println("\nStatistics:");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + ": " + stats[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[][] results = new String[n][4];
        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Game " + (i+1) + " - Enter your choice (rock, paper, scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();
            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;

            results[i][0] = String.valueOf(i+1);
            results[i][1] = userChoice;
            results[i][2] = computerChoice;
            results[i][3] = winner;
        }

        displayResults(results);
        String[][] stats = calculateStats(userWins, computerWins, n);
        displayStats(stats);

        scanner.close();
    }
}
