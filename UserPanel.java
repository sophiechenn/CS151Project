import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * The Panel that asks user to sign up or sign in
 */
public class UserPanel{
	private HotelReservationSystem s;
	/**
	 * Construct a new panel with 2 buttons 
	 * @param hotel the hotel model to switch frames
	 * @param guestData the guest model to store data
	 */
	public UserPanel(HotelReservationSystem s){
		this.s = s;
		//Create two buttons
		JFrame frame = new JFrame();
		JButton signup = new JButton("Sign Up");
		JButton signin = new JButton("Sign In");
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
				SignUpPanel signup = new SignUpPanel(s);
				//hotel.update(signup);
			}
			
		});
		
		signin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SignInPanel signin = new SignInPanel(s);
				//hotel.update(signin);
			}

		});
	}

}