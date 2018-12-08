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
	private HotelReservationSystem s;
	
	public ManagerModel(HotelReservationSystem s)
	{
		this.s=s;
		cal = new GregorianCalendar();
		listeners = new ArrayList<ChangeListener>();
		
	}
	
	public void load() throws FileNotFoundException
	{
		File file = new File ("src/reservations.txt");
		Scanner scan = new Scanner(file);
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		while (scan.hasNextLine())
		{
			//int roomNum = scan.nextInt();
			String roomNum = scan.nextLine();
			
			String eventInfo = scan.nextLine();
			String[] split = eventInfo.split(" ");
			LocalDate startDate = LocalDate.parse(split[0], dateFormat);
			LocalDate endDate = LocalDate.parse(split[1], dateFormat);
			
			//int userID = scan.nextInt();
			String userID = scan.nextLine();
			
			//int charges = scan.nextInt();
			String charges = scan.nextLine();
			
			Reservation r = new Reservation(startDate, endDate, Integer.parseInt(userID), Integer.parseInt(roomNum), Integer.parseInt(charges));
			s.addReservation(r);
			
		}
		scan.close();
		for(Reservation a: s.getReservations())
		{
			System.out.println(a.getRoomNumber());
		}
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
