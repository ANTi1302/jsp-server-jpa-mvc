package iuh.fit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Catogory implements Serializable{

	@Id
	@Column(name = "CatogoryID",columnDefinition = "nvarchar(50)")
	private int catogoryID;
	@Column(name = "CatogoryName",columnDefinition = "nvarchar(500)")
	private String catogoryName;
	private String icon;
	
	@OneToMany(mappedBy = "categoryID")
	private List<Product> products;

	public int getCatogoryID() {
		return catogoryID;
	}

	public void setCatogoryID(int catogoryID) {
		catogoryID = catogoryID;
	}

	public String getCatogoryName() {
		return catogoryName;
	}

	public void setCatogoryName(String catogoryName) {
		catogoryName = catogoryName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Catogory(int catogoryID, String catogoryName, String icon) {
		super();
		catogoryID = catogoryID;
		catogoryName = catogoryName;
		this.icon = icon;
	}

	public Catogory(int catogoryID) {
		super();
		catogoryID = catogoryID;
	}

	public Catogory() {
		super();
	}

	@Override
	public String toString() {
		return "Catogory [catogoryID=" + catogoryID + ", catogoryName=" + catogoryName + ", icon=" + icon + "]";
	}

	
	
	
}
