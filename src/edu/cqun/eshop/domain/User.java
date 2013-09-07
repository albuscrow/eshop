package edu.cqun.eshop.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "eshop")
public class User implements java.io.Serializable {

	// Fields

	private Long userId;
	private RoleList roleList;
	private String user;
	private String password;
	private Set<OtherPay> otherPaies = new HashSet<OtherPay>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String user, String password) {
		this.user = user;
		this.password = password;
	}

	/** full constructor */
	public User(RoleList roleList, String user, String password,
			Set<OtherPay> otherPaies) {
		this.roleList = roleList;
		this.user = user;
		this.password = password;
		this.otherPaies = otherPaies;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "User_ID", unique = true, nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Role_ID")
	public RoleList getRoleList() {
		return this.roleList;
	}

	public void setRoleList(RoleList roleList) {
		this.roleList = roleList;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<OtherPay> getOtherPaies() {
		return this.otherPaies;
	}

	public void setOtherPaies(Set<OtherPay> otherPaies) {
		this.otherPaies = otherPaies;
	}

}