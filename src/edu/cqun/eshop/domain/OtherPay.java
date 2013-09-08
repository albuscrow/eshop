package edu.cqun.eshop.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OtherPay entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "other_pay", catalog = "eshop")
public class OtherPay implements java.io.Serializable {

	// Fields

	private Long opayId;
	private User user;
	private String note;
	private Timestamp opayDate;
	private Double amount;

	// Constructors

	/** default constructor */
	public OtherPay() {
	}

	/** minimal constructor */
	public OtherPay(Timestamp opayDate) {
		this.opayDate = opayDate;
	}

	/** full constructor */
	public OtherPay(User user, String note, Timestamp opayDate) {
		this.user = user;
		this.note = note;
		this.opayDate = opayDate;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "OPay_ID", unique = true, nullable = false)
	public Long getOpayId() {
		return this.opayId;
	}

	public void setOpayId(Long opayId) {
		this.opayId = opayId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "User_ID")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "Note", length = 1024)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "OPay_Date", nullable = false, length = 19)
	public Timestamp getOpayDate() {
		return this.opayDate;
	}

	public void setOpayDate(Timestamp opayDate) {
		this.opayDate = opayDate;
	}

	@Column(name = "Amount", nullable = false, precision = 22, scale = 0)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}