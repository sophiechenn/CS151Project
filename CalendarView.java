import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.event.ChangeListener;

public class CalendarView{

	public JPanel getMonth() {
		return month;
	}

	private JPanel month;
	private ArrayList<JButton> days;
	private String dateClicked;
	private ArrayList<ChangeListener> listeners;
	
	public CalendarView(GregorianCalendar c)
	{
		listeners = new ArrayList<ChangeListener>();
		dateClicked = "1";
		//JFrame jeff = new JFrame();
		month = new JPanel();
		month.setLayout(new GridLayout(7, 7));
		days = new ArrayList<JButton>();
		
		printCalendarDays(c);
		/*jeff.add(month);
		jeff.setVisible(true);
		jeff.setSize(400, 400);
		jeff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}
	
	public void addChangeListener(ChangeListener listener)
	{
		listeners.add(listener);
	}
	public String getDateClicked() {
		return dateClicked;
	}

	public ArrayList<JButton> getDays() {
		return days;
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
		
		ActionListener listeners = new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				JButton sourceButton = (JButton)e.getSource();
				dateClicked = sourceButton.getText();
				//System.out.println(dateClicked);
			}
		};
		
		day = 1;
		int last = g.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		JButton button;
		while (day != last + 1)
		{
			button = new JButton(Integer.toString(day));
			button.addActionListener(listeners);
			days.add(button);
			month.add(button);
			day++;
		}
		System.out.println(dateClicked);
	}
	
	public int getDays(GregorianCalendar cal)
	{
		
		GregorianCalendar x = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		return x.get(Calendar.DAY_OF_WEEK);
		
	}
	
}
