import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        HotelManagement hotel = new HotelManagement();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Hotel Reservation System ===");
            System.out.println("1. Search Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter room type (Standard/Deluxe/Suite): ");
                    String type = sc.nextLine();
                    hotel.searchRooms(type);
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter room type (Standard/Deluxe/Suite): ");
                    type = sc.nextLine();
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    String checkIn = sc.nextLine();
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    String checkOut = sc.nextLine();
                    hotel.bookRoom(name, type, checkIn, checkOut);
                    break;
                case 3:
                    System.out.print("Enter Booking ID to cancel: ");
                    int id = sc.nextInt();
                    hotel.cancelBooking(id);
                    break;
                case 4:
                    hotel.viewBookings();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
