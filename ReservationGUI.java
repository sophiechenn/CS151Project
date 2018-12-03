import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReservationGUI {
	
	public static void main (String[] args)
	{
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
						new MakeReservation();
					}
				});
		vButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new ViewReservation();
			}
		});
		
		frame.add(buttonPanel, BorderLayout.CENTER);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

}
