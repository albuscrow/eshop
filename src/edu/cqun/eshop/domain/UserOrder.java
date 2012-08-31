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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * UserOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_order", catalog = "eshop")
public class UserOrder implements java.io.Serializable {

	// Fields

	private Long userOrderId;
	private Commend commend;
	private Delivery delivery;
	private Commodity commodity;
	private Carriage carriage;
	private Buyer buyer;
	private Short quantity;
	private Short payType;
	private Short state;
	private String logisticsState;
	private Timestamp registerDate;
	private Integer postType;
	private Set<Delivery> deliveries = new HashSet<Delivery>(0);
	private Set<Commend> commends = new HashSet<Commend>(0);

	// Constructors

	/** default constructor */
	public UserOrder() {
	}

	/** minimal constructor */
	public UserOrder(Short quantity, Short payType, Short state,
			Timestamp registerDate, Integer postType) {
		this.quantity = quantity;
		this.payType = payType;
		this.state = state;
		this.registerDate = registerDate;
		this.postType = postType;
	}

	/** full constructor */
	public UserOrder(Commend commend, Delivery delivery, Commodity commodity,
			Carriage carriage, Buyer buyer, Short quantity, Short payType,
			Short state, String logisticsState, Timestamp registerDate,
			Integer postType, Set<Delivery> deliveries, Set<Commend> commends) {
		this.commend = commend;
		this.delivery = delivery;
		this.commodity = commodity;
		this.carriage = carriage;
		this.buyer = buyer;
		this.quantity = quantity;
		this.payType = payType;
		this.state = state;
		this.logisticsState = logisticsState;
		this.registerDate = registerDate;
		this.postType = postType;
		this.deliveries = deliveries;
		this.commends = commends;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "User_Order_ID", unique = true, nullable = false)
	public Long getUserOrderId() {
		return this.userOrderId;
	}

	public void setUserOrderId(Long userOrderId) {
		this.userOrderId = userOrderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Commend_ID")
	public Commend getCommend() {
		return this.commend;
	}

	public void setCommend(Commend commend) {
		this.commend = commend;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Delivery_ID")
	public Delivery getDelivery() {
		return this.delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Commodity_ID")
	public Commodity getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Carriage_ID")
	public Carriage getCarriage() {
		return this.carriage;
	}

	public void setCarriage(Carriage carriage) {
		this.carriage = carriage;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Buyer_ID")
	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	@Column(name = "Quantity", nullable = false)
	public Short getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}

	@Column(name = "Pay_Type", nullable = false)
	public Short getPayType() {
		return this.payType;
	}

	public void setPayType(Short payType) {
		this.payType = payType;
	}

	@Column(name = "State", nullable = false)
	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	@Column(name = "Logistics_State", length = 1024)
	public String getLogisticsState() {
		return this.logisticsState;
	}

	public void setLogisticsState(String logisticsState) {
		this.logisticsState = logisticsState;
	}

	@Column(name = "Register_Date", nullable = false, length = 19)
	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	@Column(name = "Post_Type", nullable = false)
	public Integer getPostType() {
		return this.postType;
	}

	public void setPostType(Integer postType) {
		this.postType = postType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userOrder")
	public Set<Delivery> getDeliveries() {
		return this.deliveries;
	}

	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userOrder")
	public Set<Commend> getCommends() {
		return this.commends;
	}

	public void setCommends(Set<Commend> commends) {
		this.commends = commends;
	}

}