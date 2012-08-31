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
 * Saler entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "saler", catalog = "eshop")
public class Saler implements java.io.Serializable {

	// Fields

	private Long salerId;
	private String name;
	private String address;
	private String phone;
	private String email;
	private Double averageMark;
	private String user;
	private String password;
	private String introduction;
	private Timestamp registerDate;
	private Set<Commodity> commodities = new HashSet<Commodity>(0);

	// Constructors

	/** default constructor */
	public Saler() {
	}

	/** minimal constructor */
	public Saler(String name, String phone, String email, String user,
			String password, Timestamp registerDate) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.user = user;
		this.password = password;
		this.registerDate = registerDate;
	}

	/** full constructor */
	public Saler(String name, String address, String phone, String email,
			Double averageMark, String user, String password,
			String introduction, Timestamp registerDate,
			Set<Commodity> commodities) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.averageMark = averageMark;
		this.user = user;
		this.password = password;
		this.introduction = introduction;
		this.registerDate = registerDate;
		this.commodities = commodities;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Saler_ID", unique = true, nullable = false)
	public Long getSalerId() {
		return this.salerId;
	}

	public void setSalerId(Long salerId) {
		this.salerId = salerId;
	}

	@Column(name = "Name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Address", length = 256)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Phone", nullable = false, length = 32)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Email", nullable = false, length = 128)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Average_Mark", precision = 22, scale = 0)
	public Double getAverageMark() {
		return this.averageMark;
	}

	public void setAverageMark(Double averageMark) {
		this.averageMark = averageMark;
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

	@Column(name = "Introduction", length = 65535)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "Register_Date", nullable = false, length = 19)
	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saler")
	public Set<Commodity> getCommodities() {
		return this.commodities;
	}

	public void setCommodities(Set<Commodity> commodities) {
		this.commodities = commodities;
	}

}