package Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}

public class CinemaTime {
    static List<String> movieTitles = new ArrayList<>();
    static List<String> showTimes = new ArrayList<>();

    public static void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTimeFormat(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        showTimes.add(time);
        System.out.println("Movie added successfully.");
    }

    public static boolean isValidTimeFormat(String time) {
        if (!time.matches("\\d{2}:\\d{2}"))
            return false;
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
    }

    public static void searchMovie(String keyword) {
        System.out.println("Search Results:");
        boolean found = false;
        for (int i = 0; i < movieTitles.size(); i++) {
            if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.printf("Index %d: %s at %s\n", i, movieTitles.get(i), showTimes.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movie found with keyword: " + keyword);
        }
    }

    public static void displayAllMovies() {
        System.out.println("All Scheduled Movies:");
        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(String.format("%d. %s - Show at %s", i + 1, movieTitles.get(i), showTimes.get(i)));
        }
    }

    public static void generateReport() {
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = showTimes.toArray(new String[0]);
        System.out.println("\nPrintable Report:");
        for (int i = 0; i < titlesArray.length; i++) {
            System.out.printf("Movie: %s | Showtime: %s\n", titlesArray[i], timesArray[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- CinemaTime: Movie Schedule Manager ---");
            System.out.println("1. Add Movie");
            System.out.println("2. Search Movie");
            System.out.println("3. Display All Movies");
            System.out.println("4. Generate Printable Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter movie title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter showtime (HH:MM): ");
                        String time = sc.nextLine();
                        addMovie(title, time);
                    } catch (InvalidTimeFormatException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();
                    searchMovie(keyword);
                    break;

                case 3:
                    displayAllMovies();
                    break;

                case 4:
                    generateReport();
                    break;

                case 5:
                    System.out.println("Goodbye from CinemaTime!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
