import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HotelReservationSystem {

	private ArrayList<Room> rooms;
	private ArrayList<Reservation> reservations;
	private ArrayList<Guest> guests;
	
	private Guest currentGuest;
	
	public HotelReservationSystem()
	{
		rooms = new ArrayList<Room>();
		reservations = new ArrayList<Reservation>();
		guests = new ArrayList<Guest>();
		Guest g1 = new Guest(1,"1","1");
		Guest g2 = new Guest(2,"2","2");
		Guest g3 = new Guest(3,"3","3");
		
		Room one = new Room();
		one.setAvailable(true);
		LocalDate eDate = LocalDate.now();
		one.setRoomNumber(101);
		
		Room two = new Room();
		two.setAvailable(true);
		two.setRoomNumber(102);

		
		Room three = new Room();
		three.setAvailable(true);
		
		three.setRoomNumber(103);
	
	
		guests.add(g1);
		guests.add(g2);
		guests.add(g3);
		rooms.add(one);
		rooms.add(two);
		rooms.add(three);
	}

	public Guest getCurrentGuest() {
		return currentGuest;
	}

	public void setCurrentGuest(Guest currentGuest) {
		this.currentGuest = currentGuest;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public ArrayList<Guest> getGuests() {
		return guests;
	}
	
	public void addGuest(Guest g)
	{
		guests.add(g);
	}
	
	public void addReservation(Reservation r)
	{
		reservations.add(r);
	}
}