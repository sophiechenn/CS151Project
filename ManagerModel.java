import java.io.File;
import java.util.ArrayList;
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
		
	}
	
	public void load()
	{
		File file = new File ("reservations.txt");
		
	}
	
	public void view()
	{
		
	}
	
	public void save()
	{
		
	}
	
	public void quit()
	{
		
	}
	
	
	public void attach (ChangeListener l)
	{
		listeners.add(l);
	}
}
