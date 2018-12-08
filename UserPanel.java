import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		/*signup.setBounds(100, 50, 500, 150);
		signin.setBounds(100, 250, 500, 150);*/

		signup.setFont(new Font("Arial", Font.PLAIN, 20));
		signin.setFont(new Font("Arial", Font.PLAIN, 20));
		
		panel.add(signup);
		panel.add(signin);
		frame.add(panel);
		frame.setSize(new Dimension(500,500));
		frame.setVisible(true);
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