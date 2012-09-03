package edu.cqun.eshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PayWay entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pay_way", catalog = "eshop")
public class PayWay implements java.io.Serializable {

	// Fields

	private Long payId;
	private String name;
	private String company;
	private String url;

	// Constructors

	/** default constructor */
	public PayWay() {
	}

	/** full constructor */
	public PayWay(String name, String company, String url) {
		this.name = name;
		this.company = company;
		this.url = url;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Pay_ID", unique = true, nullable = false)
	public Long getPayId() {
		return this.payId;
	}

	public void setPayId(Long payId) {
		this.payId = payId;
	}

	@Column(name = "Name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Company", nullable = false, length = 64)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "URL", nullable = false, length = 1024)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}