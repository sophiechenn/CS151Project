import javax.swing.*;
import java.util.*;

public class ComprehensiveReceiptGUI implements ReceiptStrategy
{
    private JFrame receiptFrame;
    private JPanel userIdPanel;
    //private JPanel namePanel;
    private JPanel reservedRoomsPanel;
    private JPanel totalDuesPanel;    
    private JPanel detailPanel;
    
    private String userId;
    //private String name;
    private String roomNum;
    private int totalDue;
    
    private String detailRooms;
    
    private ArrayList<Reservation> reservations;  
    
    //ComprehensiveReceiptGUI(user.getReservations());
    ComprehensiveReceiptGUI(ArrayList<Reservation> reservations)
    {
    	this.reservations = reservations;
    	receiptFrame = new JFrame("Comprehensive Receipt");
    	
    	userIdPanel = new JPanel();
    	//namePanel = new JPanel();
    	reservedRoomsPanel = new JPanel();
    	totalDuesPanel = new JPanel();
    	detailPanel = new JPanel();
    	
    	userIdPanel.add(new JLabel("User ID: ")); 	
    	JTextArea userId = new JTextArea(Integer.toString(reservations.get(0).getUserId()));
    	userIdPanel.add(userId);
    	/*
    	namePanel.add(new JLabel("Guest Name: ")); 	
    	JTextArea name = new JTextArea(reservations.get(0).getName());
    	namePanel.add(name);
    	*/
    	reservedRoomsPanel.add(new JLabel("Rooms to be reserved currently : "));
    	/*JTextArea roomNum = new JTextArea(Integer.toString(reservations.get(reservations.size() - 1).getRoomNumber()));
    	reservedRoomsPanel.add(roomNum);
    	*/for(Reservation r: reservations)
    	{
    		JLabel roomNum = new JLabel(Integer.toString(r.getRoomNumber()));
        	reservedRoomsPanel.add(roomNum);
    	}
    	
    	totalDuesPanel.add(new JLabel("Total Dues for all reservations:"));
    	this.getTotalDues();
    	totalDuesPanel.add(new JLabel("$" + Integer.toString(totalDue)));
    	detailPanel.add(new JLabel("Rooms reservation history"));
    	JTextArea detailRoomsArea = new JTextArea(detailRooms);
    	detailPanel.add(detailRoomsArea);
    	this.printReceipt();
    	
    	
    }
    
    public void printReceipt()
    {
    	receiptFrame.setLayout(new BoxLayout(receiptFrame.getContentPane(),BoxLayout.Y_AXIS));	
    	//receiptFrame.add(namePanel);
    	receiptFrame.add(userIdPanel);
    	receiptFrame.add(reservedRoomsPanel);
    	receiptFrame.add(totalDuesPanel);
    	receiptFrame.add(detailPanel);
    	receiptFrame.pack();
    	receiptFrame.setVisible(true);
    }
    
    public void getTotalDues()
    {
    	for (int i=0; i < reservations.size(); i++)
    	{
    		int reservedCharges = reservations.get(i).getCharges();
        	totalDue += reservedCharges;
    	}
    }

}
