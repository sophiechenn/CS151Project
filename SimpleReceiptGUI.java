import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SimpleReceiptGUI implements ReceiptStrategy
{
    private JFrame receiptFrame;
    private JPanel userIdPanel;
    private JPanel namePanel;
    private JPanel reservedRoomsPanel;
    private JPanel totalDuesPanel;
    
    private String userId;
    private String name;
    private String roomNum;
    private int totalDue;
    
    private ArrayList<Reservation> reservations;   
    
    SimpleReceiptGUI(ArrayList<Reservation> reservations)
    {
    	receiptFrame = new JFrame("Simple Receipt");
    	userIdPanel = new JPanel();
    	namePanel = new JPanel();
    	reservedRoomsPanel = new JPanel();
    	totalDuesPanel = new JPanel();
    	
    	userIdPanel.add(new JLabel("User ID: ")); 	
    	JTextArea userId = new JTextArea(Integer.toString(reservations.get(0).getUserId().toString()));
    	userIdPanel.add(userId);
    	
    	namePanel.add(new JLabel("Guest Name: ")); 	
    	JTextArea name = new JTextArea(reservations.get(0).getName());
    	namePanel.add(name);
    	
    	reservedRoomsPanel.add(new JLabel("Rooms to be reserved: "));
    	JTextArea roomNum = new JTextArea(Integer.toString(reservations.get(reservations.size() - 1).getRoomNumber()));
    	reservedRoomsPanel.add(roomNum);
    	
    	totalDuesPanel.add(new JLabel("Total Dues:"));
    	this.getTotalDues();
    	totalDuesPanel.add(new JLabel("$" + Integer.toString(totalDue)));
    	this.printReceipt();
    }
    
    public void printReceipt()
    {
    	receiptFrame.setLayout(new BoxLayout(receiptFrame.getContentPane(),BoxLayout.Y_AXIS));
    	
    	receiptFrame.add(userIdPanel);
    	receiptFrame.add(namePanel);
    	receiptFrame.add(reservedRoomsPanel);
    	receiptFrame.add(totalDuesPanel);
    	
    	receiptFrame.pack();
    	receiptFrame.setVisible(true);
    }
    
    public void getTotalDues()
    {
        totalDue = reservations.get(reservations.size() - 1 ).getCharges;
    }

}
