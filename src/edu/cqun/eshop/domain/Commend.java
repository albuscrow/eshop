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
 * Commend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "commend", catalog = "eshop")
public class Commend implements java.io.Serializable {

	// Fields

	private Long commendId;
	private UserOrder userOrder;
	private String commend;
	private Short isMatched;
	private Short logisticsSpeed;
	private Short attitude;
	private Timestamp commendDate;
	private Double total;
	private Set<UserOrder> userOrders = new HashSet<UserOrder>(0);

	// Constructors

	/** default constructor */
	public Commend() {
	}

	/** minimal constructor */
	public Commend(Short isMatched, Short logisticsSpeed, Short attitude,
			Timestamp commendDate, Double total) {
		this.isMatched = isMatched;
		this.logisticsSpeed = logisticsSpeed;
		this.attitude = attitude;
		this.commendDate = commendDate;
		this.total = total;
	}

	/** full constructor */
	public Commend(UserOrder userOrder, String commend, Short isMatched,
			Short logisticsSpeed, Short attitude, Timestamp commendDate,
			Double total, Set<UserOrder> userOrders) {
		this.userOrder = userOrder;
		this.commend = commend;
		this.isMatched = isMatched;
		this.logisticsSpeed = logisticsSpeed;
		this.attitude = attitude;
		this.commendDate = commendDate;
		this.total = total;
		this.userOrders = userOrders;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Commend_ID", unique = true, nullable = false)
	public Long getCommendId() {
		return this.commendId;
	}

	public void setCommendId(Long commendId) {
		this.commendId = commendId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_Order_ID")
	public UserOrder getUserOrder() {
		return this.userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	@Column(name = "Commend", length = 1024)
	public String getCommend() {
		return this.commend;
	}

	public void setCommend(String commend) {
		this.commend = commend;
	}

	@Column(name = "Is_Matched", nullable = false)
	public Short getIsMatched() {
		return this.isMatched;
	}

	public void setIsMatched(Short isMatched) {
		this.isMatched = isMatched;
	}

	@Column(name = "Logistics_Speed", nullable = false)
	public Short getLogisticsSpeed() {
		return this.logisticsSpeed;
	}

	public void setLogisticsSpeed(Short logisticsSpeed) {
		this.logisticsSpeed = logisticsSpeed;
	}

	@Column(name = "Attitude", nullable = false)
	public Short getAttitude() {
		return this.attitude;
	}

	public void setAttitude(Short attitude) {
		this.attitude = attitude;
	}

	@Column(name = "Commend_Date", nullable = false, length = 19)
	public Timestamp getCommendDate() {
		return this.commendDate;
	}

	public void setCommendDate(Timestamp commendDate) {
		this.commendDate = commendDate;
	}

	@Column(name = "total", nullable = false, precision = 22, scale = 0)
	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commend")
	public Set<UserOrder> getUserOrders() {
		return this.userOrders;
	}

	public void setUserOrders(Set<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}

}