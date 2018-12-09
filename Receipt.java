import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class Receipt {
	private HotelReservationSystem s;

	public Receipt(HotelReservationSystem s, ArrayList<Reservation> reservations)
	{
		this.s = s;
		//Create two buttons
		JFrame frame = new JFrame();
		JButton signup = new JButton("Simple Receipt");
		JButton signin = new JButton("Comprehensive Receipt");
		JPanel panel = new JPanel();

		panel.setBackground(new Color(136, 189, 188));
		panel.setLayout(new BorderLayout());
		/*signup.setBounds(100, 50, 500, 150);
				signin.setBounds(100, 250, 500, 150);*/

		JLabel label = new JLabel("Welcome Guest!");
		label.setFont(new Font("Impact", Font.PLAIN, 40));
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(label, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(136, 189, 188));
		buttonPanel.add(signup);
		buttonPanel.add(signin);
		panel.add(buttonPanel, BorderLayout.SOUTH);

		frame.add(panel);
		frame.setSize(new Dimension(500,500));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		signup.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new HomeScreen(s);
				new SimpleReceiptGUI(reservations);
				
			}

		});

		signin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new HomeScreen(s);
				new ComprehensiveReceiptGUI(s.getCurrentGuest().getReservations());
			}

		});
	}
}
