import java.util.ArrayList;

public class User {
	private String name;
	private String password;
	private int id;
	private ArrayList<String> reservations;
	
	public User(String name, String password, int id, ArrayList<String> reservations)
	{
		this.name  = name;
		this.password = password;
		this.id = id;
		this.reservations = reservations;
	}

}
