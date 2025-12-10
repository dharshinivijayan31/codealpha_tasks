import java.io.*;
import java.util.*;

public class HotelManagement {
    private List<Room> rooms;
    private List<Booking> bookings;
    private int bookingCounter = 1;

    private final String ROOMS_FILE = "rooms.dat";
    private final String BOOKINGS_FILE = "bookings.dat";

    public HotelManagement() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        loadData();
    }

    // Load rooms and bookings from files
    private void loadData() {
        try {
            // Load rooms
            File roomsFile = new File(ROOMS_FILE);
            if (roomsFile.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(roomsFile));
                rooms = (List<Room>) ois.readObject();
                ois.close();
            } else {
                // If file doesn't exist, create sample rooms
                rooms.add(new Room(101, "Standard", true, 100));
                rooms.add(new Room(102, "Standard", true, 100));
                rooms.add(new Room(201, "Deluxe", true, 200));
                rooms.add(new Room(202, "Deluxe", true, 200));
                rooms.add(new Room(301, "Suite", true, 300));
            }

            // Load bookings
            File bookingsFile = new File(BOOKINGS_FILE);
            if (bookingsFile.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bookingsFile));
                bookings = (List<Booking>) ois.readObject();
                ois.close();
                // Set bookingCounter
                if (!bookings.isEmpty()) {
                    bookingCounter = bookings.get(bookings.size() - 1).getBookingID() + 1;
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    // Save data to files
    private void saveData() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ROOMS_FILE));
            oos.writeObject(rooms);
            oos.close();

            oos = new ObjectOutputStream(new FileOutputStream(BOOKINGS_FILE));
            oos.writeObject(bookings);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Search available rooms by type
    public void searchRooms(String type) {
        System.out.println("Available " + type + " rooms:");
        boolean found = false;
        for (Room room : rooms) {
            if (room.getType().equalsIgnoreCase(type) && room.isAvailable()) {
                System.out.println(room);
                found = true;
            }
        }
        if (!found) System.out.println("No available rooms of this type.");
    }

    // Book a room
    public void bookRoom(String customerName, String type, String checkIn, String checkOut) {
        for (Room room : rooms) {
            if (room.getType().equalsIgnoreCase(type) && room.isAvailable()) {
                double total = room.getPrice();
                Booking booking = new Booking(bookingCounter++, customerName, room.getRoomNumber(), checkIn, checkOut, total);
                bookings.add(booking);
                room.setAvailable(false);
                saveData();
                System.out.println("Booking successful!");
                System.out.println(booking);
                System.out.println("Payment of $" + total + " simulated successfully.");
                return;
            }
        }
        System.out.println("No available rooms of this type.");
    }

    // Cancel a booking
    public void cancelBooking(int bookingID) {
        Booking toRemove = null;
        for (Booking b : bookings) {
            if (b.getBookingID() == bookingID) {
                toRemove = b;
                break;
            }
        }
        if (toRemove != null) {
            bookings.remove(toRemove);
            // Mark room as available
            for (Room room : rooms) {
                if (room.getRoomNumber() == toRemove.getRoomNumber()) {
                    room.setAvailable(true);
                    break;
                }
            }
            saveData();
            System.out.println("Booking canceled successfully!");
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    // View all bookings
    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }
        System.out.println("All bookings:");
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }
}
