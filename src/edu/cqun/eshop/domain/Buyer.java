package edu.cqun.eshop.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Buyer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "buyer", catalog = "eshop")
public class Buyer implements java.io.Serializable {

	// Fields

	private Long buyerId;
	private String name;
	private String sex;
	private String user;
	private String password;
	private String email;
	private Timestamp registerDate;
	private Set<UserOrder> userOrders = new HashSet<UserOrder>(0);
	private Set<ShopCar> shopCars = new HashSet<ShopCar>(0);

	// Constructors

	/** default constructor */
	public Buyer() {
	}

	/** minimal constructor */
	public Buyer(String name, String user, String password,
			Timestamp registerDate) {
		this.name = name;
		this.user = user;
		this.password = password;
		this.registerDate = registerDate;
	}

	/** full constructor */
	public Buyer(String name, String sex, String user, String password,
			String email, Timestamp registerDate, Set<UserOrder> userOrders,
			Set<ShopCar> shopCars) {
		this.name = name;
		this.sex = sex;
		this.user = user;
		this.password = password;
		this.email = email;
		this.registerDate = registerDate;
		this.userOrders = userOrders;
		this.shopCars = shopCars;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Buyer_ID", unique = true, nullable = false)
	public Long getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	@Column(name = "Name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Sex", length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "User", nullable = false, length = 32)
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "Password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Email", length = 128)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Register_Date", nullable = false, length = 19)
	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buyer")
	public Set<UserOrder> getUserOrders() {
		return this.userOrders;
	}

	public void setUserOrders(Set<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buyer")
	public Set<ShopCar> getShopCars() {
		return this.shopCars;
	}

	public void setShopCars(Set<ShopCar> shopCars) {
		this.shopCars = shopCars;
	}

}