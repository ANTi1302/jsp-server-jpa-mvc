package iuh.fit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@IdClass(CartPK.class)
public class Cart implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "UserID")
	private Users usersID;

	@ManyToOne
	@JoinColumn(name = "ProductID")
	private Product productsID;

	private int amount;

	

	

	
	public Cart(int amount) {
		super();
		this.amount = amount;
	}

	public Cart() {
		super();
	}

	public Cart(Users usersID, Product productsID) {
		super();
		this.usersID = usersID;
		this.productsID = productsID;
	}

	public Cart(Users usersID, Product productsID, int amount) {
		super();
		this.usersID = usersID;
		this.productsID = productsID;
		this.amount = amount;
	}

	public Users getUsersID() {
		return usersID;
	}

	public void setUsersID(Users usersID) {
		this.usersID = usersID;
	}

	public Product getProductsID() {
		return productsID;
	}

	public void setProductsID(Product productsID) {
		this.productsID = productsID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}



	

	@Override
	public String toString() {
		return "Cart [usersID=" + usersID + ", productsID=" + productsID + ", amount=" + amount + "]";
	}

	
}
