package edu.cqun.eshop.domain;

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
 * RoleList entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role_list", catalog = "eshop")
public class RoleList implements java.io.Serializable {

	// Fields

	private Long roleId;
	private Integer role;
	private String authority;
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public RoleList() {
	}

	/** minimal constructor */
	public RoleList(Integer role, String authority) {
		this.role = role;
		this.authority = authority;
	}

	/** full constructor */
	public RoleList(Integer role, String authority, Set<User> users) {
		this.role = role;
		this.authority = authority;
		this.users = users;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Role_ID", unique = true, nullable = false)
	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "Role", nullable = false)
	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Column(name = "Authority", nullable = false, length = 256)
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleList")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}