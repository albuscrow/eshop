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
 * Carriage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "carriage", catalog = "eshop")
public class Carriage implements java.io.Serializable {

	// Fields

	private Long carriageId;
	private String start;
	private String destination;
	private String affordType;
	private Double amount;
	private Set<UserOrder> userOrders = new HashSet<UserOrder>(0);

	// Constructors

	/** default constructor */
	public Carriage() {
	}

	/** minimal constructor */
	public Carriage(String start, String destination, String affordType,
			Double amount) {
		this.start = start;
		this.destination = destination;
		this.affordType = affordType;
		this.amount = amount;
	}

	/** full constructor */
	public Carriage(String start, String destination, String affordType,
			Double amount, Set<UserOrder> userOrders) {
		this.start = start;
		this.destination = destination;
		this.affordType = affordType;
		this.amount = amount;
		this.userOrders = userOrders;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Carriage_ID", unique = true, nullable = false)
	public Long getCarriageId() {
		return this.carriageId;
	}

	public void setCarriageId(Long carriageId) {
		this.carriageId = carriageId;
	}

	@Column(name = "Start", nullable = false, length = 16)
	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Column(name = "Destination", nullable = false, length = 16)
	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Column(name = "Afford_Type", nullable = false, length = 64)
	public String getAffordType() {
		return this.affordType;
	}

	public void setAffordType(String affordType) {
		this.affordType = affordType;
	}

	@Column(name = "Amount", nullable = false, precision = 22, scale = 0)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "carriage")
	public Set<UserOrder> getUserOrders() {
		return this.userOrders;
	}

	public void setUserOrders(Set<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}

}