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
 * Commodity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "commodity", catalog = "eshop")
public class Commodity implements java.io.Serializable {

	// Fields

	private Long commodityId;
	private Saler saler;
	private Category category;
	private String name;
	private Integer sales;
	private Double price;
	private Double discountPrice;
	private Boolean isRecommend;
	private Long rest;
	private String picture;
	private Double averageMark;
	private String introduction;
	private String start;
	private Double marketPrice;
	private Timestamp registerDate;
	private Set<UserOrder> userOrders = new HashSet<UserOrder>(0);
	private Set<ShopCar> shopCars = new HashSet<ShopCar>(0);

	// Constructors

	/** default constructor */
	public Commodity() {
	}

	/** minimal constructor */
	public Commodity(String name, Double price, Boolean isRecommend,
			String picture, Timestamp registerDate) {
		this.name = name;
		this.price = price;
		this.isRecommend = isRecommend;
		this.picture = picture;
		this.registerDate = registerDate;
	}

	/** full constructor */
	public Commodity(Saler saler, Category category, String name,
			Integer sales, Double price, Double discountPrice,
			Boolean isRecommend, Long rest, String picture, Double averageMark,
			String introduction, String start, Double marketPrice,
			Timestamp registerDate, Set<UserOrder> userOrders,
			Set<ShopCar> shopCars) {
		this.saler = saler;
		this.category = category;
		this.name = name;
		this.sales = sales;
		this.price = price;
		this.discountPrice = discountPrice;
		this.isRecommend = isRecommend;
		this.rest = rest;
		this.picture = picture;
		this.averageMark = averageMark;
		this.introduction = introduction;
		this.start = start;
		this.marketPrice = marketPrice;
		this.registerDate = registerDate;
		this.userOrders = userOrders;
		this.shopCars = shopCars;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Commodity_ID", unique = true, nullable = false)
	public Long getCommodityId() {
		return this.commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Saler_ID")
	public Saler getSaler() {
		return this.saler;
	}

	public void setSaler(Saler saler) {
		this.saler = saler;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Category_ID")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "Name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Sales")
	public Integer getSales() {
		return this.sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	@Column(name = "Price", nullable = false, precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "Discount_Price", precision = 22, scale = 0)
	public Double getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Column(name = "Is_Recommend", nullable = false)
	public Boolean getIsRecommend() {
		return this.isRecommend;
	}

	public void setIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
	}

	@Column(name = "Rest")
	public Long getRest() {
		return this.rest;
	}

	public void setRest(Long rest) {
		this.rest = rest;
	}

	@Column(name = "Picture", nullable = false, length = 256)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "Average_Mark", precision = 22, scale = 0)
	public Double getAverageMark() {
		return this.averageMark;
	}

	public void setAverageMark(Double averageMark) {
		this.averageMark = averageMark;
	}

	@Column(name = "Introduction", length = 65535)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "Start", length = 16)
	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Column(name = "Market_Price", precision = 22, scale = 0)
	public Double getMarketPrice() {
		return this.marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	@Column(name = "Register_Date", nullable = false, length = 19)
	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commodity")
	public Set<UserOrder> getUserOrders() {
		return this.userOrders;
	}

	public void setUserOrders(Set<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commodity")
	public Set<ShopCar> getShopCars() {
		return this.shopCars;
	}

	public void setShopCars(Set<ShopCar> shopCars) {
		this.shopCars = shopCars;
	}

}