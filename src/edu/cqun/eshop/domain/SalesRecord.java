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
 * SalesRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sales_record", catalog = "eshop")
public class SalesRecord implements java.io.Serializable {

	// Fields

	private Long recordId;
	private Commodity commodity;
	private Short quantity;
	private Double amount;
	private Timestamp recordDate;

	// Constructors

	/** default constructor */
	public SalesRecord() {
	}

	/** minimal constructor */
	public SalesRecord(Short quantity, Double amount, Timestamp recordDate) {
		this.quantity = quantity;
		this.amount = amount;
		this.recordDate = recordDate;
	}

	/** full constructor */
	public SalesRecord(Commodity commodity, Short quantity, Double amount,
			Timestamp recordDate) {
		this.commodity = commodity;
		this.quantity = quantity;
		this.amount = amount;
		this.recordDate = recordDate;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Record_ID", unique = true, nullable = false)
	public Long getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Commodity_ID")
	public Commodity getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Column(name = "Quantity", nullable = false)
	public Short getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}

	@Column(name = "Amount", nullable = false, precision = 22, scale = 0)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "Record_Date", nullable = false, length = 19)
	public Timestamp getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(Timestamp recordDate) {
		this.recordDate = recordDate;
	}

}