package Day2;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Flight {

    String flightNumber;
    String source;
    String destination;
    Double price;

    public Flight(String flightNumber, String source, String destination, Double price) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.price = price;
        
    }
     void displayFlight() {
        System.out.println("Flight Number: " + flightNumber + ", From: " + source + ", To: " + destination + ", Price: ₹" + price);
    }

}
class Booking {
    String username;
    Flight flight;

    Booking(String username, Flight flight) {
        this.username = username;
        this.flight = flight;
    }
    void displayBooking() {
        System.out.println("Passenger: " + username);
        flight.displayFlight();
    }
    
}
class BookingSystem {
    static Flight[] flights = {
        new Flight("AI101", "Delhi", "Mumbai", 4500.0),
        new Flight("AI202", "Mumbai", "Chennai", 5200.0),
        new Flight("AI303", "Delhi", "Bangalore", 6500.0),
        new Flight("AI404", "Kolkata", "Delhi", 4000.0)
    };
    static List<Booking> bookings = new ArrayList<>();

    public static void searchFlights(String source, String destination) {
        System.out.println("Available Flights:");
        boolean found = false;
        for (Flight flight : flights) {
            if (flight.source.equalsIgnoreCase(source) && flight.destination.equalsIgnoreCase(destination)) {
                flight.displayFlight();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found from " + source + " to " + destination + ".");
        }
    }
    
    public static void bookFlight(String userName, String flightNumber) {
        for (Flight flight : flights) {
            if (flight.flightNumber.equalsIgnoreCase(flightNumber)) {
                bookings.add(new Booking(userName, flight));
                System.out.println("Booking successful for " + userName + " on flight " + flightNumber);
                return;
            }
        }
        System.out.println("Flight with number " + flightNumber + " not found.");
    }
    public static void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            System.out.println("All Bookings:");
            for (Booking booking : bookings) {
                booking.displayBooking();
                System.out.println("-------------");
            }
        }
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Flight Booking System ---");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter source city: ");
                    String src = sc.nextLine();
                    System.out.print("Enter destination city: ");
                    String dest = sc.nextLine();
                    searchFlights(src, dest);
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter flight number to book: ");
                    String fNum = sc.nextLine();
                    bookFlight(name, fNum);
                    break;

                case 3:
                    displayBookings();
                    break;

                case 4:
                    System.out.println("Thank you for using the Flight Booking System!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

    }
}
