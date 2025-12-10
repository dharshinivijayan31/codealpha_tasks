# 🏨 Java Programming Task 2 — Hotel Reservation System
### Internship Project — CodeAlpha

This project is a **Hotel Reservation System** developed using **Core Java**.  
It allows users to **search rooms, book rooms, cancel bookings, and view all bookings** using a simple **console-based interface**.

The project demonstrates important Java concepts such as:
- Classes & Objects  
- ArrayLists  
- File Handling (Serialization)  
- Methods  
- Conditional Logic  
- Console-based UI  

---

## 🚀 How to Run

1. Download or clone the repository  
2. Open the project in **IntelliJ IDEA** (recommended) or VS Code with Java extension  
3. Ensure Java 8 or above is installed  
4. Locate the main file:

```
src/Main.java
```

5. Run the program:
- Right–click → **Run Main.main()**  
- OR click the **Run ▶ button** inside your IDE  

---

## 🧠 Features

### 🔍 **Room Search**
Search for available rooms based on room type:  
- Standard  
- Deluxe  
- Suite  

### 🛏 **Room Booking**
- Enter customer details  
- System assigns the first available room  
- Generates booking ID  
- Calculates room price  
- Stores all booking records permanently  

### ❌ **Cancel Booking**
- Cancel using Booking ID  
- Room becomes available again  
- Updated data is saved  

### 📋 **View Bookings**
Shows list of all existing bookings with:
- Booking ID  
- Customer name  
- Room number  
- Check-in / Check-out dates  
- Total amount  

---

## 💾 File Handling (Persistence)

The system automatically saves and loads data using serialization:

```
rooms.dat      → Stores room details  
bookings.dat   → Stores all bookings
```

This ensures booking information is **not lost** even after restarting the program.

---

## 📂 File Structure

```
/src
 ├── Room.java              (Room model class)
 ├── Booking.java           (Booking model class)
 ├── HotelManagement.java   (Main system operations)
 └── Main.java              (Program entry point)
README.md                   (Documentation)
```

---

## 📝 Notes

- Fully console-based project  
- Ideal for Java beginners learning OOP + file handling  
- No external libraries required  
- Simple, user-friendly menu system  
- Data persists between program runs  

---

## 🎯 Task Completion Status

✔ Task fully completed  
✔ Console output working perfectly  
✔ Includes file storage (rooms + bookings)  
✔ Suitable for internship submission  
✔ Ready for GitHub deployment  
