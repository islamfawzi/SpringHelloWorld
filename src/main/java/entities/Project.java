package entities;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Project {
   
	private int id;
	
	// inputs
	private String name;
	
	@Email
	private String email;
	
	// select
	private String type;
	
	// checkbox
	private boolean special;
	
	// radio btn
	private String unitOfMeasure;
	
	// checkboxes
	private String[] indicators;
	
	// textArea
	@NotBlank(message="the notes are required")
	private String notes;
	
	// composition
	private Sponser sponser;
	
	private List<String> contacts;
	
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
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public String[] getIndicators() {
		return indicators;
	}
	public void setIndicators(String[] indicators) {
		this.indicators = indicators;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Sponser getSponser() {
		return sponser;
	}
	public void setSponser(Sponser sponser) {
		this.sponser = sponser;
	}
	public List<String> getContacts() {
		return contacts;
	}
	public void setContacts(List<String> contacts) {
		this.contacts = contacts;
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", email=" + email + ", type=" + type + ", special=" + special
				+ ", unitOfMeasure=" + unitOfMeasure + ", indicators=" + Arrays.toString(indicators) + ", notes="
				+ notes + ", sponser=" + sponser + ", contacts=" + contacts + "]";
	}
}
