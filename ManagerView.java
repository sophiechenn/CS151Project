import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ManagerView {

	private static CalendarView cal;
	private static GregorianCalendar g;
	private ManagerModel m;
	private HotelReservationSystem s;
	
	public ManagerView(HotelReservationSystem s)
	{
		this.s =s ;
		g = new GregorianCalendar();
		cal =  new CalendarView(g);
		JFrame frame = new JFrame();
		JPanel control1 = cal.getPanel();
		JTextArea text = new JTextArea();
		s.reset();
		cal.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent e) {
				System.out.println("LOL");
				control1.repaint();
				String reserved = "Reserved: \n";
				for (Reservation r: s.getReservations())
				{
					LocalDate date = LocalDate.of(g.get(Calendar.YEAR), g.get(Calendar.MONTH), Integer.parseInt(cal.getDateClicked()));
					if (!r.noConflict(date, date))
					{
						
						for(Room room: s.getRooms())
						{
							if (r.getRoomNumber() == room.getRoomNumber())
							{
								room.setAvailable(false);
							}
						}
					}
				}
				String available = "Available:\n";
				for(Room room: s.getRooms())
				{
					if (room.isAvailable())
					{
						available += room.getRoomNumber() + "\n";
					}
					else
						reserved += room.getRoomNumber() + "\n";
				}

				//for(Room room: s.get)
				text.setText(available + "\n" + reserved);
			}
			
		});
		
		
		
		JPanel view1 = new JPanel();
		view1.add(text);
		JPanel control2 = new JPanel();
		JTextArea area = new JTextArea();
		for(Room r : s.getRooms())
		{
			JButton button = new JButton(Integer.toString(r.getRoomNumber()));
			button.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					String string = (r.getRoomNumber() + " ");
					for(Reservation res: s.getReservations())
					{
						if (res.getRoomNumber() == r.getRoomNumber())
						{
							string+= res.getCharges() + "\n";
							string += res.getStartDate() + " to " + res.getEndDate();
							string += "\n";
						}
					}
					area.setText(string);
					
				}
			});
			control2.add(button);
		}
		
		//control2.setBackground(Color.BLACK);
		JPanel view2 = new JPanel();
		view2.add(area);
		//view2.setBackground(Color.RED);
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
