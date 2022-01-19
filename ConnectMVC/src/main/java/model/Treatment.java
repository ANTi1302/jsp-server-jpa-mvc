package model;
/*
 * TranThiAnhThu 19516531
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
@IdClass(TreatmentPk.class)
public class Treatment implements Serializable{

	private String description;
	private Date startDate;
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name = "doctorID")
	private Doctor doctor;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Treatment(String description, Date startDate, Date endDate, Doctor doctor) {
		super();
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.doctor = doctor;
	}

	public Treatment() {
		super();
	}

	@Override
	public String toString() {
		return "Treatment [description=" + description + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", doctor=" + doctor + "]";
	}
	
	
	
}
