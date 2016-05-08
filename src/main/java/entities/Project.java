package entities;

public class Project {
   
	private int id;
	private String name;
	private String email;
	private String type;
	private boolean special;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setting name with DataBinding");
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isSpecial() {
		return special;
	}
	public void setSpecial(boolean special) {
		this.special = special;
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name +
			   ", email=" + email + ", type=" + type +
			   ", special=" + special + "]";
	}
	
	
}
