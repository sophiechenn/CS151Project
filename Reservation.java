import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Reservation {
	
	private LocalDate startDate;
	private LocalDate endDate;
	private int roomNumber;
	private int userId;
	private int charges;
	private String roomType;
	private ArrayList<ChangeListener> changes;
	
	public Reservation(LocalDate start, LocalDate end, int userID, int room, int charge, String roomType)
	{
		startDate = start;
		endDate = end;
		roomNumber = room;
		charges = charge;
		userId = userID;
		this.roomType = roomType;
		changes = new ArrayList<ChangeListener>();
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
		for(ChangeListener listener: changes)
		{
			listener.stateChanged(new ChangeEvent(this));
		}
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCharges() {
		return charges;
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}

	public LocalDate getStartDate() {
		return startDate;
		
	}

	public LocalDate getEndDate() {
		return endDate;
	}
	
	public void updateData(LocalDate s, LocalDate e)
	{
		startDate = s;
		endDate = e;
	}
	
	public boolean noConflict(LocalDate start, LocalDate end)
	{
		if(end.isAfter(startDate) && end.isBefore(endDate))
		{
			return false;
		}
		else if(start.isAfter(startDate) && start.isBefore(endDate))
		{
			return false;
		}
		else if(start.isEqual(startDate) || end.isEqual(endDate))
		{
			return false;
		}
		return true;
	}
	
	public void addChangeListener(ChangeListener c)
	{
		changes.add(c);
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
		for(ChangeListener listener: changes)
		{
			listener.stateChanged(new ChangeEvent(this));
		}
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
		for(ChangeListener listener: changes)
		{
			listener.stateChanged(new ChangeEvent(this));
		}
	}
	
}
