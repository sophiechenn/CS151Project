import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;

public class CalendarView {

	private JPanel month;
	private JButton[] days;
	
	public CalendarView(GregorianCalendar c)
	{
		JFrame jeff = new JFrame();
		month = new JPanel();
		month.setLayout(new GridLayout(7, 7));
		
		printCalendarDays(c);
		
		jeff.add(month);
		jeff.setVisible(true);
		jeff.setSize(500, 500);
		jeff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void printCalendarDays(GregorianCalendar g)
	{
		String[] daysOfWeek = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
		for (int i = 0; i < 7; i++)
		{
			month.add(new JLabel(daysOfWeek[i]));
		}
		int day = 1;
		
		while (day != getDays(g))
		{
			month.add(new JLabel(" "));
			day++;
		}
		day = 1;
		int last = g.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		while (day != last + 1)
		{
			month.add(new JLabel(Integer.toString(day)));
			day++;
		}
	}
	
	public int getDays(GregorianCalendar cal)
	{
		
		GregorianCalendar x = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		return x.get(Calendar.DAY_OF_WEEK);
		
	}
	
}
