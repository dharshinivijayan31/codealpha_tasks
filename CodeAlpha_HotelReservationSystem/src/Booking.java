import java.io.Serializable;

public class Booking implements Serializable {
    private int bookingID;
    private String customerName;
    private int roomNumber;
    private String checkInDate;
    private String checkOutDate;
    private double totalAmount;

    public Booking(int bookingID, String customerName, int roomNumber, String checkInDate, String checkOutDate, double totalAmount) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;
    }

    public int getBookingID() { return bookingID; }
    public int getRoomNumber() { return roomNumber; }

    @Override
    public String toString() {
        return "Booking ID: " + bookingID +
                ", Name: " + customerName +
                ", Room: " + roomNumber +
                ", Check-In: " + checkInDate +
                ", Check-Out: " + checkOutDate +
                ", Total: $" + totalAmount;
    }
}
