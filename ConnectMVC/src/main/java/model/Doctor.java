package model;
/*
 * TranThiAnhThu 19516531
 */
import java.io.Serializable;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor implements Serializable{

	@Id
	private String id;
	private String email;
	private String firstName;
	private String lastName;
	private String phone;
	private String specialty;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> certifications;
	
	@ManyToOne
	@JoinColumn(name = "departmentId")
	private Department department;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Set<String> getCertifications() {
		return certifications;
	}

	public void setCertifications(Set<String> certifications) {
		this.certifications = certifications;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Doctor(String id, String email, String firstName, String lastName, String phone, String specialty,
			Set<String> certifications, Department department) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.specialty = specialty;
		this.certifications = certifications;
		this.department = department;
	}

	public Doctor() {
		super();
	}

	public Doctor(String id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", specialty=" + specialty + ", certifications=" + certifications
				+ ", department=" + department + "]";
	}
	
	
}
