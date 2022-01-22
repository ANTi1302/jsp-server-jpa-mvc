package iuh.fit.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CartPK implements Serializable{

	private int userID;
	private int productID;
	
	
	public CartPK() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(productID, userID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartPK other = (CartPK) obj;
		return productID == other.productID && userID == other.userID;
	}
	
	
}
