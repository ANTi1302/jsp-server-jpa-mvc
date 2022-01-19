package model;
/*
 * TranThiAnhThu 19516531
 */
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class TreatmentPk implements Serializable{

	private String doctor;
	private String description;
	private Date startDate;
	private Date endDate;
	public TreatmentPk() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, doctor, endDate, startDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreatmentPk other = (TreatmentPk) obj;
		return Objects.equals(description, other.description) && Objects.equals(doctor, other.doctor)
				&& Objects.equals(endDate, other.endDate) && Objects.equals(startDate, other.startDate);
	}
	@Override
	public String toString() {
		return "TreatmentPk [doctor=" + doctor + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
}
