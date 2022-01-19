package model;
/*
 * TranThiAnhThu 19516531
 */
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient implements Serializable{

	@Id
	private String id;
	private int age;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;
	private String phone;
	
	 @Embedded
		@ElementCollection(fetch = FetchType.EAGER)
	 List<Treatment> treatments;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	public Patient() {
		super();
	}

	public Patient(String id, int age, String firstName, String lastName, String address, String gender, String phone,
			List<Treatment> treatments) {
		super();
		this.id = id;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
		this.phone = phone;
		this.treatments = treatments;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", gender=" + gender + ", phone=" + phone + ", treatments=" + treatments
				+ "]";
	}

	
	
}
