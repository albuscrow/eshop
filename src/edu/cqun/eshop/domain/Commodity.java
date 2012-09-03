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
	private String origin;
	private Double marketPrice;
	private Timestamp registerDate;
	private Boolean isSale;
	private String brand;
	private Set<OrderList> orderLists = new HashSet<OrderList>(0);
	private Set<SalesRecord> salesRecords = new HashSet<SalesRecord>(0);
	private Set<ImportList> importLists = new HashSet<ImportList>(0);

	// Constructors

	/** default constructor */
	public Commodity() {
	}

	/** minimal constructor */
	public Commodity(String name, Double price, Boolean isRecommend,
		String picture, Timestamp registerDate, String brand) {
		this.name = name;
		this.price = price;
		this.isRecommend = isRecommend;
		this.picture = picture;
		this.registerDate = registerDate;
		this.brand = brand;
	}

	/** full constructor */
	public Commodity(Category category, String name, Integer sales,
			Double price, Double discountPrice, Boolean isRecommend, Long rest,
			String picture, Double averageMark, String introduction,
			String origin, Double marketPrice, Timestamp registerDate,
			Boolean isSale, String brand, Set<OrderList> orderLists,
			Set<SalesRecord> salesRecords, Set<ImportList> importLists) {
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
		this.origin = origin;
		this.marketPrice = marketPrice;
		this.registerDate = registerDate;
		this.isSale = isSale;
		this.brand = brand;
		this.orderLists = orderLists;
		this.salesRecords = salesRecords;
		this.importLists = importLists;
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

	@Column(name = "Origin", length = 16)
	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
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

	@Column(name = "Is_SALE")
	public Boolean getIsSale() {
		return this.isSale;
	}

	public void setIsSale(Boolean isSale) {
		this.isSale = isSale;
	}

	@Column(name = "Brand", nullable = false, length = 64)
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commodity")
	public Set<OrderList> getOrderLists() {
		return this.orderLists;
	}

	public void setOrderLists(Set<OrderList> orderLists) {
		this.orderLists = orderLists;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commodity")
	public Set<SalesRecord> getSalesRecords() {
		return this.salesRecords;
	}

	public void setSalesRecords(Set<SalesRecord> salesRecords) {
		this.salesRecords = salesRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commodity")
	public Set<ImportList> getImportLists() {
		return this.importLists;
	}

	public void setImportLists(Set<ImportList> importLists) {
		this.importLists = importLists;
	}

}