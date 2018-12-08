import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

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
		
		Guest g1 = new Guest(1,"1","1");
		Guest g2 = new Guest(2,"2","2");
		Guest g3 = new Guest(3,"3","3");
		
		Room one = new Room();
		one.setCurrentStatus(true);
		LocalDate eDate = LocalDate.now();
		one.setStartDate(eDate);
		one.setEndDate(eDate.plusDays(7));
		one.setRoomNumber(101);
		one.setGuest(g1);
		
		Room two = new Room();
		two.setCurrentStatus(true);
		two.setStartDate(eDate);
		two.setEndDate(eDate.plusDays(8));
		two.setRoomNumber(102);
		two.setGuest(g2);
		
		Room three = new Room();
		three.setCurrentStatus(true);
		three.setStartDate(eDate);
		three.setEndDate(eDate.plusDays(7));
		three.setRoomNumber(103);
		three.setGuest(g3);
		
		rooms.add(one);
		rooms.add(two);
		rooms.add(three);
			
		
	}
	
	public void load() throws FileNotFoundException
	{
		File file = new File ("src/reservations.txt");
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
		scan.close();
	}

	
	public void save()
	{
		
	}
	
	public void view()
	{
		new ManagerView();
	}
	
	
	
	public void attach (ChangeListener l)
	{
		listeners.add(l);
	}
}
