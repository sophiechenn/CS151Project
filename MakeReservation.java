import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MakeReservation {
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	
	public MakeReservation()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Reservation");
		
		
		/*JPanel checkinPanel = new JPanel();
		JPanel checkoutPanel = new JPanel();
		JLabel in = new JLabel("Check in");
		JLabel out = new JLabel("Check out");
		checkinPanel.setBackground(new Color(136, 189, 188));
		JTextField checkin = new JTextField();
		JTextField checkout = new JTextField();
		checkinPanel.add(in);
		checkinPanel.add(checkin);
		checkoutPanel.add(out);
		checkoutPanel.add(checkout);*/
		JButton button = new JButton();
		frame.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    if (shouldFill) {
	    //natural height, maximum width
	    c.fill = GridBagConstraints.HORIZONTAL;
	    }
	 
	    JLabel lb = new JLabel("Check in");
	    if (shouldWeightX) {
	    c.weightx = 0.5;
	    }
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 0;
	    frame.add(lb, c);
	 
	    JLabel lb2 = new JLabel("Check out");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 1;
	    c.gridy = 0;
	    frame.add(lb2, c);
	 
	    button = new JButton("Button 3");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 2;
	    c.gridy = 0;
	    frame.add(button, c);
	    
	    LocalDate localDate = LocalDate.now();//For reference
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
	    String formattedString = localDate.format(formatter);
	    
	    JTextField jf = new JTextField(formattedString);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 0;
	    c.gridy = 1;
	    frame.add(jf, c);
	    
	    JTextField jf2 = new JTextField(formattedString);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 1;
	    c.gridy = 1;
	    frame.add(jf2, c);
	 
	   /* button = new JButton("Long-Named Button 4");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 40;      //make this component tall
	    c.weightx = 0.0;
	    c.gridwidth = 3;
	    c.gridx = 0;
	    c.gridy = 1;
	    frame.add(button, c);*/
	 
	    button = new JButton("Reserve");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.weighty = 1.0;   //request any extra vertical space
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    //c.insets = new Insets(10,0,0,0);  //top padding
	    c.gridx = 0;       //aligned with button 2
	    c.gridwidth = 3;   //2 columns wide
	    c.gridy = 2;       //third row
	    frame.add(button, c);
		
/*		checkin.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						//new MakeReservation();
					}
				});
		checkout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//new ViewReservation();
			}
		});
		
		frame.add(checkinPanel, BorderLayout.NORTH);
		frame.add(checkoutPanel, BorderLayout.CENTER);*/
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

}
