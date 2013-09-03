package edu.cqun.eshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Delivery entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "delivery", catalog = "eshop")
public class Delivery implements java.io.Serializable {

	// Fields

	private Long deliveryId;
	private Buyer buyer;
	private Integer postcode;
	private String address;
	private String phone;

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
	public Delivery(Buyer buyer, Integer postcode, String address, String phone) {
		this.buyer = buyer;
		this.postcode = postcode;
		this.address = address;
		this.phone = phone;
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
	@JoinColumn(name = "Buyer_ID")
	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
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

}