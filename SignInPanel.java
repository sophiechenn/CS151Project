import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		JPanel panel = new JPanel();
		JLabel id = new JLabel("ID:");
		JTextField idinput = new JTextField();
		JLabel pass = new JLabel("Password");
		JTextField password = new JTextField();
		JButton login = new JButton("Log In");

	/*	id.setBounds(150, 75, 100, 100);
		idinput.setBounds(200, 75, 300, 100);
		login.setBounds(250, 200, 200, 75);*/

		id.setFont(new Font("Arial", Font.PLAIN, 20));
		idinput.setFont(new Font("Arial", Font.PLAIN, 20));
		login.setFont(new Font("Arial", Font.PLAIN, 20));
		password.setFont(new Font("Arial", Font.PLAIN, 20));

		panel.add(id);
		panel.add(idinput);
		panel.add(pass);
		panel.add(password);
		panel.add(login);
		
		frame.add(panel);
		frame.setSize(new Dimension(500,500));
		frame.setVisible(true);

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
			{
				return g;
			}
		}
		return null;
	}
}