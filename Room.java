import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Room {
	private boolean available;
	private String roomType;
	private int roomNumber;
	

	/**
	 * Return the current status of the room
	 *
	 * @return the current status of the room
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Return the room type
	 *
	 * @return the room type
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * Return the room number
	 *
	 * @return the room number
	 */
	public int getRoomNumber() {
		return roomNumber;
	}


	/**
	 * Set the current status of the room
	 *
	 * @param status
	 *            the new status of the room
	 */
	public void setAvailable(boolean status) {
		available = status;
	}

	/**
	 * Set the room type
	 *
	 * @param rType
	 *            the new room type
	 */
	public void setRoomType(String rType) {
		roomType = rType;
	}

	/**
	 * Set the room number
	 * @param rNumber the new room number
	 */
	public void setRoomNumber(int rNumber) {
		roomNumber = rNumber;
	}

	
}