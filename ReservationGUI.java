import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReservationGUI {
	private HotelReservationSystem s;
	public ReservationGUI(HotelReservationSystem s)
	{
		this.s = s;
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Reservation");
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(136, 189, 188));
		JButton mButton = new JButton("Make a reservation");
		JButton vButton = new JButton("View reservations");
		buttonPanel.add(mButton);
		buttonPanel.add(vButton);
		
		mButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						new ReservationMake(s);
					}
				});
		vButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new ViewReservation(s);
			}
		});
		
		frame.add(buttonPanel, BorderLayout.CENTER);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

}
