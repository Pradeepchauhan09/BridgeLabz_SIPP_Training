package LinkedList;

import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

class TicketSystem {
    private Ticket tail = null;
    public void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, customer, movie, seat, time);
        if (tail == null) {
            newTicket.next = newTicket;
            tail = newTicket;
        } else {
            newTicket.next = tail.next;
            tail.next = newTicket;
            tail = newTicket;
        }
        System.out.println("Ticket booked successfully!");
    }
    public void removeTicket(int id) {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = tail.next;
        Ticket prev = tail;
        boolean found = false;

        do {
            if (current.ticketId == id) {
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);

        if (!found) {
            System.out.println("Ticket ID not found.");
            return;
        }

        if (current == tail && current == tail.next) {
            tail = null;
        } else {
            prev.next = current.next;
            if (current == tail) {
                tail = prev;
            }
        }

        System.out.println("Ticket with ID " + id + " removed.");
    }
    public void displayTickets() {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = tail.next;
        System.out.println("\n--- Current Tickets ---");
        do {
            printTicket(current);
            current = current.next;
        } while (current != tail.next);
    }
    public void searchTicket(String keyword) {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = tail.next;
        boolean found = false;

        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                printTicket(current);
                found = true;
            }
            current = current.next;
        } while (current != tail.next);

        if (!found) {
            System.out.println("No matching ticket found.");
        }
    }
    public void countTickets() {
        if (tail == null) {
            System.out.println("Total tickets: 0");
            return;
        }

        int count = 0;
        Ticket current = tail.next;
        do {
            count++;
            current = current.next;
        } while (current != tail.next);

        System.out.println("Total tickets booked: " + count);
    }

    private void printTicket(Ticket t) {
        System.out.println("ID: " + t.ticketId + ", Customer: " + t.customerName + ", Movie: " + t.movieName +
                ", Seat: " + t.seatNumber + ", Time: " + t.bookingTime);
    }
}
public class TicketReservationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketSystem system = new TicketSystem();
        int choice;

        do {
            System.out.println("\n--- Online Ticket Reservation ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Count Booked Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            int id;
            String name, movie, seat, time;

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    id = sc.nextInt();
                    system.removeTicket(id);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer Name or Movie Name: ");
                    String keyword = sc.nextLine();
                    system.searchTicket(keyword);
                    break;

                case 5:
                    system.countTickets();
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 6);

    }
}

