package edu.cqun.eshop.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ShopCar entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shop_car", catalog = "eshop")
public class ShopCar implements java.io.Serializable {

	// Fields

	private ShopCarId id;
	private Commodity commodity;
	private Buyer buyer;

	// Constructors

	/** default constructor */
	public ShopCar() {
	}

	/** full constructor */
	public ShopCar(ShopCarId id, Commodity commodity, Buyer buyer) {
		this.id = id;
		this.commodity = commodity;
		this.buyer = buyer;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "commodityId", column = @Column(name = "Commodity_ID", nullable = false)),
			@AttributeOverride(name = "buyerId", column = @Column(name = "Buyer_ID", nullable = false)) })
	public ShopCarId getId() {
		return this.id;
	}

	public void setId(ShopCarId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Commodity_ID", nullable = false, insertable = false, updatable = false)
	public Commodity getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Buyer_ID", nullable = false, insertable = false, updatable = false)
	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

}