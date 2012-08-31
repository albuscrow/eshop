package edu.cqun.eshop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ShopCarId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ShopCarId implements java.io.Serializable {

	// Fields

	private Long commodityId;
	private Long buyerId;

	// Constructors

	/** default constructor */
	public ShopCarId() {
	}

	/** full constructor */
	public ShopCarId(Long commodityId, Long buyerId) {
		this.commodityId = commodityId;
		this.buyerId = buyerId;
	}

	// Property accessors

	@Column(name = "Commodity_ID", nullable = false)
	public Long getCommodityId() {
		return this.commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	@Column(name = "Buyer_ID", nullable = false)
	public Long getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ShopCarId))
			return false;
		ShopCarId castOther = (ShopCarId) other;

		return ((this.getCommodityId() == castOther.getCommodityId()) || (this
				.getCommodityId() != null && castOther.getCommodityId() != null && this
				.getCommodityId().equals(castOther.getCommodityId())))
				&& ((this.getBuyerId() == castOther.getBuyerId()) || (this
						.getBuyerId() != null && castOther.getBuyerId() != null && this
						.getBuyerId().equals(castOther.getBuyerId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCommodityId() == null ? 0 : this.getCommodityId()
						.hashCode());
		result = 37 * result
				+ (getBuyerId() == null ? 0 : this.getBuyerId().hashCode());
		return result;
	}

}