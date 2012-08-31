package edu.cqun.eshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SystemUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "system_user", catalog = "eshop")
public class SystemUser implements java.io.Serializable {

	// Fields

	private Long userId;
	private String user;
	private String password;
	private Integer role;

	// Constructors

	/** default constructor */
	public SystemUser() {
	}

	/** full constructor */
	public SystemUser(String user, String password, Integer role) {
		this.user = user;
		this.password = password;
		this.role = role;
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

	@Column(name = "Role", nullable = false)
	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}