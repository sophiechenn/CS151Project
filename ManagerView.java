import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ManagerView {

	private static CalendarView cal;
	private static GregorianCalendar g;
	private ManagerModel m;
	
	public static void main(String[] args)
	{
		g = new GregorianCalendar();
		cal =  new CalendarView(g);
		JFrame frame = new JFrame();
		JPanel control1 = cal.getMonth();
		
		cal.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent e) {
				//Change available rooms 
				
			}
			
		});
		
		JPanel view1 = new JPanel();
		view1.setBackground(Color.BLUE);
		JPanel control2 = new JPanel();
		control2.setBackground(Color.BLACK);
		JPanel view2 = new JPanel();
		view2.setBackground(Color.RED);
		frame.setLayout(new GridLayout(2,2));
		frame.add(control1);
		frame.add(view1);
		frame.add(control2);
		frame.add(view2);
		frame.setVisible(true);
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
