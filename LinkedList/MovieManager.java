package LinkedList;
import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev;
    Movie next;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

class MovieList {
    private Movie head;
    private Movie tail;
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
        System.out.println("Movie added at beginning.");
    }
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
        System.out.println("Movie added at end.");
    }
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie current = head;
        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }
        newMovie.next = current.next;
        if (current.next != null) {
            current.next.prev = newMovie;
        } else {
            tail = newMovie;
        }
        current.next = newMovie;
        newMovie.prev = current;
        System.out.println("Movie added at position " + position + ".");
    }
    public void deleteByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Movie \"" + title + "\" deleted.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }
    public void search(String keyword) {
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(keyword) || String.valueOf(current.rating).equals(keyword)) {
                System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No matching movies found.");
    }
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for \"" + title + "\".");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("\nMovies (Forward):");
        Movie current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director +
                               ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("\nMovies (Reverse):");
        Movie current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director +
                               ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }
}

public class MovieManager {
    public static void main(String[] args) {
        MovieList list = new MovieList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Title");
            System.out.println("5. Search by Director or Rating");
            System.out.println("6. Update Rating by Title");
            System.out.println("7. Display All (Forward)");
            System.out.println("8. Display All (Reverse)");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            String title, director, keyword;
            int year, position;
            double rating;

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = sc.nextLine();
                    director = sc.nextLine();
                    year = sc.nextInt();
                    rating = sc.nextDouble();
                    list.addAtBeginning(title, director, year, rating);
                    break;
                case 2:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = sc.nextLine();
                    director = sc.nextLine();
                    year = sc.nextInt();
                    rating = sc.nextDouble();
                    list.addAtEnd(title, director, year, rating);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    position = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = sc.nextLine();
                    director = sc.nextLine();
                    year = sc.nextInt();
                    rating = sc.nextDouble();
                    list.addAtPosition(position, title, director, year, rating);
                    break;
                case 4:
                    System.out.print("Enter Title to Delete: ");
                    title = sc.nextLine();
                    list.deleteByTitle(title);
                    break;
                case 5:
                    System.out.print("Enter Director or Rating to Search: ");
                    keyword = sc.nextLine();
                    list.search(keyword);
                    break;
                case 6:
                    System.out.print("Enter Title to Update Rating: ");
                    title = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    rating = sc.nextDouble();
                    list.updateRating(title, rating);
                    break;
                case 7:
                    list.displayForward();
                    break;
                case 8:
                    list.displayReverse();
                    break;
                case 9:
                    System.out.println("Exiting Movie Manager.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 9);
    }
}
