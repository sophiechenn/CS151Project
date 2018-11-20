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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
