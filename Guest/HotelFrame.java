import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Models a JFrame class for hotel.
 */
public class HotelFrame extends JFrame implements ChangeListener{
	private HotelModel components;
	private JPanel contentPanel;
	private final int FRAME_WIDTH = 700;
	private final int FRAME_HEIGHT =500;
	
	/**
	 * Constructs a hotel frame.
	 * @param model
	 */
	public HotelFrame(HotelModel model){			 
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		
		components = model;
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		contentPanel.add(model.getData());
		
		
		this.setContentPane(contentPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		JComponent a = components.getData();
		contentPanel.removeAll();
		contentPanel.add(a);
		this.setContentPane(contentPanel);
	}
}