package LinkedList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}

class Library {
    private Book head = null;
    private Book tail = null;

    // Add at beginning
    public void addAtBeginning(String title, String author, String genre, int id, boolean avail) {
        Book newBook = new Book(title, author, genre, id, avail);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        System.out.println("Book added at beginning.");
    }

    // Add at end
    public void addAtEnd(String title, String author, String genre, int id, boolean avail) {
        Book newBook = new Book(title, author, genre, id, avail);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        System.out.println("Book added at end.");
    }

    // Add at specific position (1-based)
    public void addAtPosition(int position, String title, String author, String genre, int id, boolean avail) {
        if (position <= 1 || head == null) {
            addAtBeginning(title, author, genre, id, avail);
            return;
        }

        Book newBook = new Book(title, author, genre, id, avail);
        Book current = head;
        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        newBook.next = current.next;
        newBook.prev = current;

        if (current.next != null) {
            current.next.prev = newBook;
        } else {
            tail = newBook;
        }

        current.next = newBook;
        System.out.println("Book added at position " + position);
    }

    // Remove by Book ID
    public void removeById(int id) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    // Search by title or author
    public void search(String keyword) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword)) {
                System.out.println("Found Book - ID: " + temp.bookId + ", Title: " + temp.title +
                        ", Author: " + temp.author + ", Genre: " + temp.genre +
                        ", Available: " + (temp.isAvailable ? "Yes" : "No"));
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No book found with that Title or Author.");
    }

    // Update availability
    public void updateAvailability(int id, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = newStatus;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    // Display forward
    public void displayForward() {
        Book temp = head;
        if (temp == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\n--- Library Books (Forward) ---");
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        Book temp = tail;
        if (temp == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\n--- Library Books (Reverse) ---");
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    // Count total books
    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }

    private void printBook(Book book) {
        System.out.println("ID: " + book.bookId + ", Title: " + book.title + ", Author: " + book.author +
                ", Genre: " + book.genre + ", Available: " + (book.isAvailable ? "Yes" : "No"));
    }
}

public class LibraryManagement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n--- Library Management ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title/Author");
            System.out.println("6. Update Book Availability");
            System.out.println("7. Display Books (Forward)");
            System.out.println("8. Display Books (Reverse)");
            System.out.println("9. Count Books");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            int id, position;
            String title, author, genre;
            boolean avail;

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    avail = sc.nextBoolean();

                    if (choice == 1)
                        library.addAtBeginning(title, author, genre, id, avail);
                    else if (choice == 2)
                        library.addAtEnd(title, author, genre, id, avail);
                    else {
                        System.out.print("Enter Position: ");
                        position = sc.nextInt();
                        library.addAtPosition(position, title, author, genre, id, avail);
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to Remove: ");
                    id = sc.nextInt();
                    library.removeById(id);
                    break;

                case 5:
                    System.out.print("Enter Title or Author to Search: ");
                    String keyword = sc.nextLine();
                    library.search(keyword);
                    break;

                case 6:
                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();
                    System.out.print("New Availability (true/false): ");
                    avail = sc.nextBoolean();
                    library.updateAvailability(id, avail);
                    break;

                case 7:
                    library.displayForward();
                    break;

                case 8:
                    library.displayReverse();
                    break;

                case 9:
                    library.countBooks();
                    break;

                case 10:
                    System.out.println("Exiting Library System...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 10);
    }
}
