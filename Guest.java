import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Guest stores user data such as id, username, check in date, and check out date
 */

public class Guest implements Comparable<Guest>, Serializable{
    private int userID;
    private String username;
    private String password;
    private ArrayList<Reservation> reservations;
    
    //testing purposes.
    public Guest(int ID, String user, String pass) {
        userID = ID;
        username = user;
        reservations = new ArrayList<Reservation>();
        password = pass;
    }
    
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	/**
	 * Returns the guest user's ID
	 * @return userID of the guest
	 */
    public int getUserID() {
        return userID;
    }
    
	/**
	 * Returns the guest's username
	 * @return the username of the guest
	 */
    public String getUsername() {
        return username;
    }
    
	/**
	 * Sets the user ID of the guest
	 * @param ID the new user ID
	 * @postcondition: user ID of the guest is set to the new user ID
	 */
    public void setUserID(int ID) {
        userID = ID;
    }
    
    
	/**
	 * Sets the username of the guest
	 * @param user the new username
	 * @postcondition: username of the guest is set to the new username
	 */
    public void setUsername(String user) {
        username = user;
    }
    
	/**
	 * Overrides compareTo method, comparing guest to another by username
	 * @param g the guest to compare to
	 * @returns -1, 0, 1, for less than, equal to, and greater than, respectively
	 */
    public int compareTo(Guest g) {
        return username.compareTo(g.getUsername());
    }
    
}