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
		one.setRoomType("100");
		one.setRoomNumber(101);
		
		Room two = new Room();
		two.setAvailable(true);
		two.setRoomNumber(102);
		two.setRoomType("100");
		
		Room three = new Room();
		three.setAvailable(true);
		three.setRoomType("100");
		three.setRoomNumber(103);
	
	
		guests.add(g1);
		guests.add(g2);
		guests.add(g3);
		
		Reservation r = new Reservation(LocalDate.now(), LocalDate.now(), 1, 103, 100, "100");
		reservations.add(r);
		g1.addReservation(r);
		
		rooms.add(one);
		rooms.add(two);
		rooms.add(three);
	}

	public Guest getCurrentGuest() {
		return currentGuest;
	}
	
	public void reset()
	{
		for(Room r: rooms)
		{
			r.setAvailable(true);
		}
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
	
	
	public void delReservation(Reservation r)
	{
		for(Reservation res: reservations)
		{
			if(res.equals(r))
			{
				reservations.remove(r);
				return;
			}
		}
	}
}