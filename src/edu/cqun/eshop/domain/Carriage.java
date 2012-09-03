package edu.cqun.eshop.domain;

<<<<<<< HEAD
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
>>>>>>> 8c3b95de00c9d4919d17c095832bc7e702567392
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
<<<<<<< HEAD
	private String affordType;
	private Double amount;
	private Set<UserOrder> userOrders = new HashSet<UserOrder>(0);
=======
	private String company;
	private Short cost;
>>>>>>> 8c3b95de00c9d4919d17c095832bc7e702567392

	// Constructors

	/** default constructor */
	public Carriage() {
	}

<<<<<<< HEAD
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
=======
	/** full constructor */
	public Carriage(String start, String destination, String company, Short cost) {
		this.start = start;
		this.destination = destination;
		this.company = company;
		this.cost = cost;
>>>>>>> 8c3b95de00c9d4919d17c095832bc7e702567392
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

<<<<<<< HEAD
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
=======
	@Column(name = "Company", nullable = false, length = 64)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "Cost", nullable = false)
	public Short getCost() {
		return this.cost;
	}

	public void setCost(Short cost) {
		this.cost = cost;
>>>>>>> 8c3b95de00c9d4919d17c095832bc7e702567392
	}

}