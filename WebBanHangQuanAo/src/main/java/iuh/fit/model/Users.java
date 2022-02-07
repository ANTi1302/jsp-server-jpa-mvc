package iuh.fit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users implements Serializable {

	@Id
	@Column(name = "UserID")
	private int userID;
	@Column(name = "Username", columnDefinition = "nvarchar(500)")
	private String userName;
	@Column(name = "Password", columnDefinition = "nvarchar(1000)")
	private String password;
	private String access_tokenID;
	private int isSaller;
	private int isAdmin;
	
	@OneToMany(mappedBy = "sellerID")
	private List<Product> products;

	public int getUserID() {
		return userID;
	}

	public String getAccess_tokenID() {
		return access_tokenID;
	}

	public void setAccess_tokenID(String access_tokenID) {
		this.access_tokenID = access_tokenID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsSaller() {
		return isSaller;
	}

	public void setIsSaller(int isSaller) {
		this.isSaller = isSaller;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Users(int userID, String userName, String password, int isSaller, int isAdmin, List<Product> products) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.isSaller = isSaller;
		this.isAdmin = isAdmin;
		this.products = products;
	}

	public Users(int userID) {
		super();
		this.userID = userID;
	}

	public Users() {
		super();
	}

	@Override
	public String toString() {
		return "Users [userID=" + userID + ", userName=" + userName + ", password=" + password + ", access_tokenID="
				+ access_tokenID + ", isSaller=" + isSaller + ", isAdmin=" + isAdmin + "]";
	}

//	@Override
//	public String toString() {
//		return "Users [userID=" + userID + ", userName=" + userName + ", password=" + password + ", isSaller="
//				+ isSaller + ", isAdmin=" + isAdmin + "]";
//	}

	
	
	
}
