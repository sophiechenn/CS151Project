import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

public class CalendarView {

	private JPanel month;
	private JButton[] days;
	
	public CalendarView()
	{
		month = new JPanel();
		month.setLayout(new GridLayout(7, 7));
		
		printCalendarDays();
	}
	
	public void printCalendarDays()
	{
		String[] daysOfWeek = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
		for (int i = 0; i < 7; i++)
		{
			month.add(new JLabel(daysOfWeek[i]));
		}
	}
	
	public ArrayList<String> getDays(GregorianCalendar cal)
	{
		ArrayList<String> days = new ArrayList<String>();
		
		GregorianCalendar x = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		int dayOfWeek = x.get(Calendar.DAY_OF_WEEK);
		
		return days;
	}
	
}
