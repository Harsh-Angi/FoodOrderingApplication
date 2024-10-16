package pizzaProject;

public class User {
	private String username;
	private int pwd;
	private double bal;
	
	
	public User(String username,int pwd) {
		this.username=username;
		this.pwd=pwd;
	}
	
	public String getUser() {
		return this.username;
	}
	
	public int getPwd() {
		return this.pwd;
	}
	
	public void setUser(String username) {
		this.username=username;
	}
	
	public void setPwd(int pwd) {
		this.pwd=pwd;
	}
	
	public void addBal(double bal) {
		this.bal+=bal;
	}
	
	public double getBal() {
		return this.bal;
	}

}
