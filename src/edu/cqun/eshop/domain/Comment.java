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
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment", catalog = "eshop")
public class Comment implements java.io.Serializable {

	// Fields

	private Long commentId;
	private OrderList orderList;
	private String comment;
	private Short isMatched;
	private Short logisticsSpeed;
	private Short attitude;
	private Timestamp commentDate;
	private Double total;
	private Set<OrderList> orderLists = new HashSet<OrderList>(0);

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Short isMatched, Short logisticsSpeed, Short attitude,
			Timestamp commentDate, Double total) {
		this.isMatched = isMatched;
		this.logisticsSpeed = logisticsSpeed;
		this.attitude = attitude;
		this.commentDate = commentDate;
		this.total = total;
	}

	/** full constructor */
	public Comment(OrderList orderList, String comment, Short isMatched,
			Short logisticsSpeed, Short attitude, Timestamp commentDate,
			Double total, Set<OrderList> orderLists) {
		this.orderList = orderList;
		this.comment = comment;
		this.isMatched = isMatched;
		this.logisticsSpeed = logisticsSpeed;
		this.attitude = attitude;
		this.commentDate = commentDate;
		this.total = total;
		this.orderLists = orderLists;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Comment_ID", unique = true, nullable = false)
	public Long getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Order_ID")
	public OrderList getOrderList() {
		return this.orderList;
	}

	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}

	@Column(name = "Comment", length = 1024)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	@Column(name = "Comment_Date", nullable = false, length = 19)
	public Timestamp getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	@Column(name = "Total", nullable = false, precision = 22, scale = 0)
	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comment")
	public Set<OrderList> getOrderLists() {
		return this.orderLists;
	}

	public void setOrderLists(Set<OrderList> orderLists) {
		this.orderLists = orderLists;
	}

}