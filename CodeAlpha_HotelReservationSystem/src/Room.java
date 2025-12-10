import java.io.Serializable;

public class Room implements Serializable {
    private int roomNumber;
    private String type; // Standard, Deluxe, Suite
    private boolean isAvailable;
    private double price;

    public Room(int roomNumber, String type, boolean isAvailable, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    // Getters and Setters
    public int getRoomNumber() { return roomNumber; }
    public String getType() { return type; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Room " + roomNumber + " [" + type + "] - " + (isAvailable ? "Available" : "Booked") + " - $" + price;
    }
}
