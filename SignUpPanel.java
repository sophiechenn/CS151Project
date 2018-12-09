import java.awt.Color;
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
 * The Sign Up Panel that allows users to sign up for an account with their user name
 */
public class SignUpPanel{
	private HotelReservationSystem s;
	/**
	 * Construct a panel with JTextField to enter user name and a button that generate an automated ID
	 * @param hotel the hotel model to switch frames
	 * @param guestData the guest model to store data and create a new user
	 */
	public SignUpPanel(HotelReservationSystem s) {
		this.s = s;
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new GridLayout(4, 1));
		panel.setBackground(new Color(136, 189, 188));
		
		JLabel username = new JLabel("Username:");
		username.setFont(new Font("", Font.BOLD, 20));
		username.setForeground(Color.WHITE);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField usernameinput = new JTextField();
		
		JLabel userID = new JLabel("User ID:");
		userID.setFont(new Font("", Font.BOLD, 20));
		userID.setForeground(Color.WHITE);
		userID.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField userIDinput = new JTextField();
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("", Font.BOLD, 20));
		password.setForeground(Color.WHITE);
		password.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField passwordinput = new JTextField();
		
		JLabel space = new JLabel("");
		JButton createAccount = new JButton("Create an account!");
		createAccount.setFont(new Font("", Font.PLAIN, 15));
		
		/*username.setBounds(100, 125, 150, 100);
		usernameinput.setBounds(200, 125, 300, 100);
		createAccount.setBounds(250, 250, 200, 75);*/

		panel.add(username);
		panel.add(usernameinput);
		panel.add(userID);
		panel.add(userIDinput);
		panel.add(password);
		panel.add(passwordinput);
		panel.add(space);
		panel.add(createAccount);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createAccount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int userID = Integer.parseInt(userIDinput.getText());
				String name = usernameinput.getText();
				String input = passwordinput.getText();
				for(Guest g: s.getGuests())
				{
					if(g.getUserID() == userID)
					{
						JOptionPane.showMessageDialog(null, "Please enter unique ID");
						return;
					}
				}
				Guest gg = new Guest(userID, name, input);
				s.addGuest(gg);
				frame.dispose();
				s.setCurrentGuest(gg);
				new ReservationGUI();
			}
		});
	}
}