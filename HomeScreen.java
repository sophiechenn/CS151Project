import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeScreen {
	private HotelReservationSystem s;
	
	public HomeScreen(HotelReservationSystem s)
	{
		this.s = s;
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Hotel Reservation");
		frame.setVisible(true);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(136, 189, 188));
		
		JButton mButton = new JButton("Manager");
		mButton.addActionListener(new
				ActionListener()
				{
					public void actionPerformed (ActionEvent e)
					{
						frame.dispose();
						new ManagerHome(s);
						
					}
				});
		
		JButton gButton = new JButton("Guest");
		gButton.addActionListener(new
				ActionListener()
				{
					public void actionPerformed (ActionEvent e)
					{
						frame.dispose();
						new UserPanel(s);
					}
				});
		
		buttonPanel.add(mButton);
		buttonPanel.add(gButton);
		
		HomeScreenDesign design = new HomeScreenDesign();
		design.setBackground(new Color(136, 189, 188));
		design.add(buttonPanel, BorderLayout.SOUTH);

		frame.add(design);
		frame.setSize(500, 500);
	}
	
}
