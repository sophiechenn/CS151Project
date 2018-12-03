import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ManagerView {

	private static CalendarView cal;
	private static GregorianCalendar g;
	
	public static void main(String[] args)
	{
		g = new GregorianCalendar();
		JFrame frame = new JFrame();
		cal =  new CalendarView(g);
		JPanel panel = cal.getMonth();
		
		cal.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent e) {
				//Change available rooms 
				
			}
			
		});
		frame.setLayout(new GridLayout(2,2));
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
