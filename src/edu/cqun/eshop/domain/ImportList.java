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
 * ImportList entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "import_list", catalog = "eshop")
public class ImportList implements java.io.Serializable {

	// Fields

	private Long importId;
	private Commodity commodity;
	private Short quantity;
	private Double price;
	private Timestamp importDate;

	// Constructors

	/** default constructor */
	public ImportList() {
	}

	/** minimal constructor */
	public ImportList(Short quantity, Double price, Timestamp importDate) {
		this.quantity = quantity;
		this.price = price;
		this.importDate = importDate;
	}

	/** full constructor */
	public ImportList(Commodity commodity, Short quantity, Double price,
			Timestamp importDate) {
		this.commodity = commodity;
		this.quantity = quantity;
		this.price = price;
		this.importDate = importDate;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Import_ID", unique = true, nullable = false)
	public Long getImportId() {
		return this.importId;
	}

	public void setImportId(Long importId) {
		this.importId = importId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
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

	@Column(name = "Price", nullable = false, precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "Import_Date", nullable = false, length = 19)
	public Timestamp getImportDate() {
		return this.importDate;
	}

	public void setImportDate(Timestamp importDate) {
		this.importDate = importDate;
	}

}