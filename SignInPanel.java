import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * The Sign In Panel that allows users to enter their id to log in
 */
public class SignInPanel {
	private HotelReservationSystem s;
	/**
	 * Construct a panel with a JTextField to entire ID and a JButton to check ID and proceed to the next frame
	 * @param hotel the hotel model to switch frames
	 * @param guestdata the guest model to manipulate and check ID
	 */
	public SignInPanel(HotelReservationSystem s) {
		this.s = s;
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new GridLayout(3, 1));
		panel.setBackground(new Color(136, 189, 188));
		
		JLabel id = new JLabel("ID:");
		id.setFont(new Font("", Font.BOLD, 20));
		id.setForeground(Color.WHITE);
		id.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField idinput = new JTextField();
		
		JLabel pass = new JLabel("Password:");
		pass.setFont(new Font("", Font.BOLD, 20));
		pass.setForeground(Color.WHITE);
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField password = new JTextField();
		
		JLabel space = new JLabel("");
		JButton login = new JButton("Login!");
		login.setFont(new Font("", Font.PLAIN, 15));
		
	/*	id.setBounds(150, 75, 100, 100);
		idinput.setBounds(200, 75, 300, 100);
		login.setBounds(250, 200, 200, 75);*/

		panel.add(id);
		panel.add(idinput);
		panel.add(pass);
		panel.add(password);
		panel.add(space);
		panel.add(login);
		
		frame.add(panel);
		frame.setSize(new Dimension(400, 200));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idinput.getText();
				if (id.matches("[0-9]+") && id.length() > 0) {
					int idnum = Integer.parseInt(id);
					//guestdata.signIn(idnum);
					String word = password.getText();
					Guest g = findGuest(idnum, word);
					if (!(g == null))
					{
						frame.dispose();
						s.setCurrentGuest(g);
						new ReservationGUI(s);
					}
					else
						JOptionPane.showMessageDialog(null, "Please enter valid id and password");
					
				}else {
					JOptionPane.showMessageDialog(null, "Please enter numbers for id.");
				}
			}
		});

	}
	
	private Guest findGuest(int id, String pass)
	{
		for(Guest g: s.getGuests())
		{
			if(g.getUserID() ==  id && g.getPassword().equals(pass))
				return g;
		}
		return null;
	}
}