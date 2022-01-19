package entity;

import java.util.Date;

public class Student {

	private int id;
	private String name;
	private boolean gender;
	private Date dob;
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
		this.name = name;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public Student(int id, String name, boolean gender, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
	}
	public Student(int id) {
		super();
		this.id = id;
	}
	public Student() {
		super();
	}
	
	public Student(String name, boolean gender, Date dob) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + "]";
	}
	
}
