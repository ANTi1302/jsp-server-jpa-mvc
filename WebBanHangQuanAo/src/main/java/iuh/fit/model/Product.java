package iuh.fit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@Column(name = "ProductID",nullable = false)
	private int productID;
	@Column(name = "ProductName", columnDefinition = "nvarchar(1000)")
	private String productName;
	@Column(name = "Description")
	private String description;
	@Column(name = "Price")
	private double price;
	@Column(name = "imageLink", columnDefinition = "nvarchar(1000)")
	private String imageLink;
	@ManyToOne
	@JoinColumn(name = "CategoryID")
	private Catogory categoryID;
	
	@ManyToOne
	@JoinColumn(name = "SellerID")
	private Users sellerID;
	private int amount;
	
	@OneToMany(mappedBy = "productsID")
	private List<Cart> carts;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	

	public Catogory getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Catogory categoryID) {
		this.categoryID = categoryID;
	}

	public Users getSellerID() {
		return sellerID;
	}


	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	



	public Product(int productID, String productName, String description, Double price, String imageLink,
			Catogory categoryID, Users sellerID, int amount) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.imageLink = imageLink;
		this.categoryID = categoryID;
		this.sellerID = sellerID;
		this.amount = amount;
	}

	public Product() {
		super();
	}

	public Product(int productID) {
		super();
		this.productID = productID;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", imageLink=" + imageLink + ", categoryID=" + categoryID + ", sellerID="
				+ sellerID + ", amount=" + amount + "]";
	}

	
	
	
	
	
}
