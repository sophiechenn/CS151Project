import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.event.ChangeListener;

public class ManagerModel {

	private GregorianCalendar cal;
	
	private ArrayList<ChangeListener> listeners;
	private ArrayList<Room> rooms;
	private ArrayList<Reservation> reservations;
	private ArrayList<Guest> guests;
	
	public ManagerModel()
	{
		cal = new GregorianCalendar();
		listeners = new ArrayList<ChangeListener>();
		rooms = new ArrayList<Room>();
		reservations = new ArrayList<Reservation>();
		guests = new ArrayList<Guest>();
		
		Room one = new Room();
		one.setCurrentStatus(true);
		LocalDate eDate = LocalDate.now();
		one.setStartDate(eDate);
		one.setEndDate(eDate.plusDays(7));
		one.setRoomNumber(101);
		one.setGuest(new Guest(1,"1","1"));
		
		Room two = new Room();
		two.setCurrentStatus(true);
		two.setStartDate(eDate);
		two.setEndDate(eDate.plusDays(8));
		two.setRoomNumber(102);
		two.setGuest(new Guest(1,"1","1"));
		
		Room three = new Room();
		three.setCurrentStatus(true);
		three.setStartDate(eDate);
		three.setEndDate(eDate.plusDays(7));
		three.setRoomNumber(103);
		three.setGuest(new Guest(1,"1","1"));
		
		rooms.add(one);
		rooms.add(two);
		rooms.add(three);
			
		
	}
	
	public void load()
	{
		File file = new File ("reservations.txt");
		Scanner scan = new Scanner(file);
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		while (scan.hasNextLine())
		{
			int roomNum = scan.nextInt();
			
			String eventInfo = scan.nextLine();
			String[] split = eventInfo.split(" ");
			LocalDate startDate = LocalDate.parse(split[0], dateFormat);
			LocalDate endDate = LocalDate.parse(split[1], dateFormat);
			
			int userID = scan.nextInt();
			
			int charges = scan.nextInt();
			
			Reservation r = new Reservation(startDate, endDate, userID, roomNum, charges);
			reservations.add(r);
		
	}

	
	public void save()
	{
		
	}
	
	
	
	public void attach (ChangeListener l)
	{
		listeners.add(l);
	}
}
