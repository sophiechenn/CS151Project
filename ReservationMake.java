import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ReservationMake {
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	private Reservation res;
	private LocalDate startDate;
	private LocalDate endDate;
	private String roomType;
	private ArrayList<Reservation> reservations;
	
	private HotelReservationSystem s;
	public ReservationMake(HotelReservationSystem s)
	{
		reservations = new ArrayList<Reservation>();
		res = new Reservation(null,null,0,0,0,"");
		this.s = s;
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0,100,100));
		frame.setTitle("Reservation");

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

		JLabel lb3 = new JLabel("Room Type(100 or 300)");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		frame.add(lb3, c);

		LocalDate localDate = LocalDate.now();//For reference
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLLL/dd/yyyy");
		String formattedString = localDate.format(formatter);

		JTextArea jf = new JTextArea(formattedString);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		frame.add(jf, c);



		JTextArea jf2 = new JTextArea(formattedString);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		frame.add(jf2, c);



		JTextArea jf3 = new JTextArea("100");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		frame.add(jf3, c);



		/* button = new JButton("Long-Named Button 4");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 40;      //make this component tall
	    c.weightx = 0.0;
	    c.gridwidth = 3;
	    c.gridx = 0;
	    c.gridy = 1;
	    frame.add(button, c);*/
		
		

		JTextArea availableRooms = new JTextArea("Available Rooms");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 3;
		c.weightx = 2;
		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 100;
		c.ipadx = 100;

		availableRooms.setEditable(false);
		frame.add(availableRooms, c);
		
		JButton showme = new JButton("Show Me");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		//c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;       //aligned with button 2
		c.gridwidth = 1;   //2 columns wide
		c.gridy = 2;       //third row
		frame.add(showme, c);
		showme.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				startDate = LocalDate.parse(jf.getText(), formatter);
				endDate = LocalDate.parse(jf2.getText(), formatter);
				roomType = jf3.getText();
				if (startDate.isBefore(LocalDate.now()) || endDate.isBefore(LocalDate.now()))
				{
					availableRooms.setText("Check in and Check out date cannot be before today");
				}
				else if(endDate.minusDays(61).isAfter(startDate))
				{
					availableRooms.setText("Duration of stay max 60 nights");
				}
				else if(!jf3.getText().equals("100") && !jf3.getText().equals("300"))
				{
					availableRooms.setText("Select either 100 or 300 for room types");
				}
				else
				{
					String available = "";
					for(Reservation r: s.getReservations())
					{
						System.out.println(r.getRoomType());
						if (!r.noConflict(startDate, endDate))
						{
							//System.out.println(r.getRoomType());
							for(Room room: s.getRooms())
							{
								if (r.getRoomNumber() == room.getRoomNumber())
								{
									room.setAvailable(false);
								}
							}
						}
					}

					for(Room room: s.getRooms())
					{
						if (room.isAvailable())
						{
							available += room.getRoomNumber() + "\n";
						}
					}

					//for(Room room: s.get)
					availableRooms.setText(available);
				}
			}
		});

		
		

		JTextField desiredRoom = new JTextField("Enter your desired room number");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 3;
		c.ipady = 0;
		c.ipadx = 0;
		frame.add(desiredRoom, c);


		JButton confirm = new JButton("Confirm");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		//c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 0;       //aligned with button 2
		c.gridwidth = 1;   //2 columns wide
		c.gridy = 4;       //third row
		frame.add(confirm, c);

		JButton more = new JButton("More Reservations?");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		//c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;       //aligned with button 2
		c.gridwidth = 1;   //2 columns wide
		c.gridy = 4;       //third row
		frame.add(more, c);

		JButton done = new JButton("Done");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		//c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 2;       //aligned with button 2
		c.gridwidth = 1;   //2 columns wide
		c.gridy = 4;       //third row
		frame.add(done, c);





		/*DocumentListener documentlistener = new DocumentListener(){

			public void changedUpdate(DocumentEvent e) {
				warn();
			}
			public void removeUpdate(DocumentEvent e) {
				warn();
			}
			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn()
			{
				startDate = LocalDate.parse(jf.getText(), formatter);
				//res.setStartDate(startDate);
				endDate = LocalDate.parse(jf2.getText(), formatter);
				//res.setEndDate(endDate);
				roomType = jf3.getText();
				//res.setRoomType(roomType);
				if (startDate.isBefore(LocalDate.now()) || endDate.isBefore(LocalDate.now()))
				{
					availableRooms.setText("Check in and Check out date cannot be before today");
				}
				else if(endDate.minusDays(61).isAfter(startDate))
				{
					availableRooms.setText("Duration of stay max 60 nights");
				}
				else if(!jf3.getText().equals("100") && !jf3.getText().equals("300"))
				{
					availableRooms.setText("Select either 100 or 300 for room types");
				}
				else
				{
					String available = "";
					for(Reservation r: s.getReservations())
					{
						if (r.noConflict(startDate, endDate))
						{
							for(Room room: s.getRooms())
							{
								if (r.getRoomNumber() == room.getRoomNumber())
								{
									room.setAvailable(false);
								}
							}
						}
					}

					for(Room room: s.getRooms())
					{
						if (room.isAvailable())
						{
							available += room.getRoomNumber() + "\n";
						}
					}

					//for(Room room: s.get)
					availableRooms.setText(available);
				}
			}

		};

		jf.getDocument().addDocumentListener(documentlistener);
		jf2.getDocument().addDocumentListener(documentlistener);
		jf2.getDocument().addDocumentListener(documentlistener);*/

		ChangeListener change = new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				//LocalDate startDate = LocalDate.parse(jf.getText(), formatter);
				res.setStartDate(startDate);
				//LocalDate endDate = LocalDate.parse(jf2.getText(), formatter);
				res.setEndDate(endDate);
				//String roomType = jf3.getText();
				res.setRoomType(roomType);

			}
		};
		res.addChangeListener(change);
		
		confirm.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				int charge = ((Integer.parseInt(roomType))*((int)startDate.until(endDate, ChronoUnit.DAYS) + 1));
				Reservation ress = new Reservation(startDate, endDate, s.getCurrentGuest().getUserID(),
						Integer.parseInt(desiredRoom.getText()), charge, roomType );
				s.getCurrentGuest().addReservation(ress);
				reservations.add(ress);
				s.addReservation(ress);
				
			}
	
		});
		
		more.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				new ReservationMake(s);
				
			}
	
		});
		
		done.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						new Receipt(s, reservations);
						
					}
			
				});

		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	public void save()
	{
		try {
			FileWriter bw = new FileWriter("src/reservations.txt");
			BufferedWriter fw = new BufferedWriter(bw);
			for (Reservation r : s.getReservations())
			{
				fw.write(r.getRoomNumber() + "\n");
				fw.write(r.getRoomType() + "\n");
				fw.write(r.getStartDate() + " " + r.getEndDate() + "\n");
				fw.write(r.getUserId() + "\n");
				fw.write(r.getCharges() + "\n");
			}
			fw.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
