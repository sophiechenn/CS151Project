import java.awt.*;
import javax.swing.*;

public class HomeScreen {

	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Hotel Reservation");
		
		//JPanel panel = new JPanel(new BorderLayout());
		//panel.setBackground(new Color(136, 189, 188));
		
		HomeScreenDesign design = new HomeScreenDesign();
		//text.setForeground(Color.WHITE);
		design.setBackground(new Color(136, 189, 188));
		
		/*JLabel label = new JLabel("HOTEL RESERVATION SYSTEM", JLabel.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Impact", Font.PLAIN, 40));
		
		JLabel space = new JLabel();*/
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(136, 189, 188));
		JButton mButton = new JButton("Manager");
		JButton gButton = new JButton("Guest");
		buttonPanel.add(mButton);
		buttonPanel.add(gButton);
		
		design.add(buttonPanel, BorderLayout.SOUTH);
		//panel.add(space, BorderLayout.NORTH);
		//panel.add(label, BorderLayout.CENTER);
		
		//panel.add(text);
		///panel.add(buttonPanel);
		
		//frame.add(panel);
		frame.add(design);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
}
