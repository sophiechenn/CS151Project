import java.awt.Color;
import javax.swing.*;

public class ManagerHome {

	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBackground(new Color(36, 48, 94));
		JButton button1 = new JButton("Load");
		Color blue = new Color(168, 208, 230);
		button1.setBackground(blue);
		JButton button2 = new JButton("View");
		button2.setBackground(blue);
		JButton button3 = new JButton("Save");
		button3.setBackground(blue);
		JButton button4 = new JButton("Quit");
		button4.setBackground(blue);
		
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		
		frame.add(buttonPanel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
}
