import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.event.ChangeListener;

public class Manager {

	private GregorianCalendar cal;
	
	private ArrayList<ChangeListener> listeners;
	
	public Manager()
	{
		cal = new GregorianCalendar();
		listeners = new ArrayList<ChangeListener>();
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
