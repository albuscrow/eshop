package edu.cqun.eshop.domain;

<<<<<<< HEAD
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
=======
>>>>>>> 8c3b95de00c9d4919d17c095832bc7e702567392
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
<<<<<<< HEAD
import javax.persistence.OneToMany;
=======
>>>>>>> 8c3b95de00c9d4919d17c095832bc7e702567392
import javax.persistence.Table;

/**
 * Delivery entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "delivery", catalog = "eshop")
public class Delivery implements java.io.Serializable {

	// Fields

	private Long deliveryId;
<<<<<<< HEAD
	private UserOrder userOrder;
	private Integer postcode;
	private String address;
	private String phone;
	private Set<UserOrder> userOrders = new HashSet<UserOrder>(0);
=======
	private Buyer buyer;
	private Integer postcode;
	private String address;
	private String phone;
>>>>>>> 8c3b95de00c9d4919d17c095832bc7e702567392

	// Constructors

	/** default constructor */
	public Delivery() {
	}

	/** minimal constructor */
	public Delivery(Integer postcode, String address, String phone) {
		this.postcode = postcode;
		this.address = address;
		this.phone = phone;
	}

	/** full constructor */
<<<<<<< HEAD
	public Delivery(UserOrder userOrder, Integer postcode, String address,
			String phone, Set<UserOrder> userOrders) {
		this.userOrder = userOrder;
		this.postcode = postcode;
		this.address = address;
		this.phone = phone;
		this.userOrders = userOrders;
=======
	public Delivery(Buyer buyer, Integer postcode, String address, String phone) {
		this.buyer = buyer;
		this.postcode = postcode;
		this.address = address;
		this.phone = phone;
>>>>>>> 8c3b95de00c9d4919d17c095832bc7e702567392
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Delivery_ID", unique = true, nullable = false)
	public Long getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
<<<<<<< HEAD
	@JoinColumn(name = "User_Order_ID")
	public UserOrder getUserOrder() {
		return this.userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
=======
	@JoinColumn(name = "Buyer_ID")
	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
>>>>>>> 8c3b95de00c9d4919d17c095832bc7e702567392
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

<<<<<<< HEAD
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "delivery")
	public Set<UserOrder> getUserOrders() {
		return this.userOrders;
	}

	public void setUserOrders(Set<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}

=======
>>>>>>> 8c3b95de00c9d4919d17c095832bc7e702567392
}