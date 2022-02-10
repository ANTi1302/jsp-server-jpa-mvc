package iuh.fit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
	private int userID;
	@Column(name = "Username", columnDefinition = "nvarchar(500)")
	private String userName;
	@Column(name = "Password", columnDefinition = "nvarchar(1000)")
	private String password;
	private String access_tokenID;
	private int isSaller;
	private int isAdmin;
	private String email;
	@OneToMany(mappedBy = "sellerID")
	private List<Product> products;

	public int getUserID() {
		return userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Users(String userName, String password, String access_tokenID, int isSaller, int isAdmin, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.access_tokenID = access_tokenID;
		this.isSaller = 0;
		this.isAdmin = 0;
		this.email= email;
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
				+ access_tokenID + ", isSaller=" + isSaller + ", isAdmin=" + isAdmin + ", email=" + email + "]";
	}

}
