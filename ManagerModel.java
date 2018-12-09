import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-LLLL-dd");

		while (scan.hasNextLine())
		{
			//int roomNum = scan.nextInt();
			String roomNum = scan.nextLine();
			String roomType = scan.nextLine();
			String eventInfo = scan.nextLine();
			String[] split = eventInfo.split(" ");
			LocalDate startDate = LocalDate.parse(split[0], dateFormat);
			LocalDate endDate = LocalDate.parse(split[1], dateFormat);
			
			//int userID = scan.nextInt();
			String userID = scan.nextLine();
			
			//int charges = scan.nextInt();
			String charges = scan.nextLine();
			
			Reservation r = new Reservation(startDate, endDate, Integer.parseInt(userID), Integer.parseInt(roomNum), Integer.parseInt(charges), roomType);
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
		try {
			FileWriter fw = new FileWriter("src/reservations.txt");
			for (Reservation r : s.getReservations())
			{
				fw.write(r.getRoomNumber() + "\n");
				fw.write(r.getRoomType() + "\n");
				fw.write(r.getStartDate() + " " + r.getEndDate() + "\n");
				fw.write(r.getUserId() + "\n");
				fw.write(r.getCharges() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void view()
	{
		new ManagerView(s);
	}
	
	
	
	public void attach (ChangeListener l)
	{
		listeners.add(l);
	}
}
