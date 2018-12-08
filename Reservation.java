import java.time.LocalDate;

public class Reservation {
	
	private LocalDate startDate;
	private LocalDate endDate;
	private int roomNumber;
	private int userId;
	private int charges;
	
	public Reservation(LocalDate start, LocalDate end, int userID, int room, int charge)
	{
		startDate = start;
		endDate = end;
		roomNumber = room;
		charges = charge;
		userId = userID;
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

}
