import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewReservation {
	private HotelReservationSystem s;
	public ViewReservation(HotelReservationSystem s)
	{
		JFrame jeff = new JFrame();
		this.s = s;
		JPanel panel = new JPanel();
		for (Reservation r: s.getCurrentGuest().getReservations())
		{
			
			JLabel label = new JLabel(r.getRoomNumber() + " " + r.getStartDate() + " to " + r.getEndDate());
			JButton button = new JButton("Cancel this reservation");
			button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					s.delReservation(r);
					panel.remove(label);
					panel.remove(button);
					panel.revalidate();
					panel.repaint();
				}
				
			});
			panel.add(label);
			panel.add(button);
			
		}
		jeff.add(panel);
		jeff.setVisible(true);
		jeff.setSize(500, 500);
	}

}
