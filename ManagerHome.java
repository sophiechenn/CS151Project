import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ManagerHome {
	private HotelReservationSystem s;

	private ManagerModel m;
	
	public ManagerHome(HotelReservationSystem s)
	{
		this.s = s;
		JFrame frame = new JFrame();
		m = new ManagerModel(s);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		Color blue = new Color(168, 208, 230);
		
		buttonPanel.setBackground(new Color(36, 48, 94));
		
		JButton button1 = new JButton("Load");	
		button1.setBackground(blue);
		button1.addActionListener(new
				ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						try {
							m.load();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		
		JButton button2 = new JButton("View");
		button2.setBackground(blue);
		button2.addActionListener(new
				ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//frame.dispose();
						m.view();
					}
				});
		
		JButton button3 = new JButton("Save");
		button3.setBackground(blue);
		button3.addActionListener(new
				ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						m.save();
					}
				});
		
		JButton button4 = new JButton("Quit");
		button4.setBackground(blue);
		button4.addActionListener(new
				ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);
					}
				});
		
		
		
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		
		frame.add(buttonPanel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
}
