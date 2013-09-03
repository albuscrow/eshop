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
 * OrderList entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order_list", catalog = "eshop")
public class OrderList implements java.io.Serializable {

	// Fields

	private Long orderId;
	private Commodity commodity;
	private Comment comment;
	private Buyer buyer;
	private Short quantity;
	private Short payType;
	private Short state;
	private String logisticsState;
	private Timestamp registerDate;
	private Integer postType;
	private Integer postcode;
	private String address;
	private String phone;
	private Short carriageFee;
	private Set<Comment> comments = new HashSet<Comment>(0);

	// Constructors

	/** default constructor */
	public OrderList() {
	}

	/** minimal constructor */
	public OrderList(Short quantity, Short payType, Short state,
			Timestamp registerDate, Integer postType, Integer postcode,
			String address, String phone, Short carriageFee) {
		this.quantity = quantity;
		this.payType = payType;
		this.state = state;
		this.registerDate = registerDate;
		this.postType = postType;
		this.postcode = postcode;
		this.address = address;
		this.phone = phone;
		this.carriageFee = carriageFee;
	}

	/** full constructor */
	public OrderList(Commodity commodity, Comment comment, Buyer buyer,
			Short quantity, Short payType, Short state, String logisticsState,
			Timestamp registerDate, Integer postType, Integer postcode,
			String address, String phone, Short carriageFee,
			Set<Comment> comments) {
		this.commodity = commodity;
		this.comment = comment;
		this.buyer = buyer;
		this.quantity = quantity;
		this.payType = payType;
		this.state = state;
		this.logisticsState = logisticsState;
		this.registerDate = registerDate;
		this.postType = postType;
		this.postcode = postcode;
		this.address = address;
		this.phone = phone;
		this.carriageFee = carriageFee;
		this.comments = comments;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Order_ID", unique = true, nullable = false)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
	@JoinColumn(name = "Comment_ID")
	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
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

	@Column(name = "Postcode", nullable = false)
	public Integer getPostcode() {
		return this.postcode;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	@Column(name = "Address", nullable = false, length = 256)
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

	@Column(name = "Carriage_Fee", nullable = false)
	public Short getCarriageFee() {
		return this.carriageFee;
	}

	public void setCarriageFee(Short carriageFee) {
		this.carriageFee = carriageFee;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderList")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}