package edu.cqun.eshop.domain;

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
 * StockOut entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "stock_out", catalog = "eshop")
public class StockOut implements java.io.Serializable {

	// Fields

	private Long stId;
	private Commodity commodity;
	private Short needQuantity;
	private Set<Commodity> commodities = new HashSet<Commodity>(0);

	// Constructors

	/** default constructor */
	public StockOut() {
	}

	/** full constructor */
	public StockOut(Commodity commodity, Short needQuantity,
			Set<Commodity> commodities) {
		this.commodity = commodity;
		this.needQuantity = needQuantity;
		this.commodities = commodities;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ST_ID", unique = true, nullable = false)
	public Long getStId() {
		return this.stId;
	}

	public void setStId(Long stId) {
		this.stId = stId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Commodity_ID")
	public Commodity getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Column(name = "Need_Quantity")
	public Short getNeedQuantity() {
		return this.needQuantity;
	}

	public void setNeedQuantity(Short needQuantity) {
		this.needQuantity = needQuantity;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "stockOut")
	public Set<Commodity> getCommodities() {
		return this.commodities;
	}

	public void setCommodities(Set<Commodity> commodities) {
		this.commodities = commodities;
	}

}