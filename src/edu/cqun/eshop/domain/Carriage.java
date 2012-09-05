package edu.cqun.eshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Carriage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "carriage", catalog = "eshop")
public class Carriage implements java.io.Serializable {

	// Fields

	private Long carriageId;
	private String start;
	private String destination;
	private String company;
	private Short cost;

	// Constructors

	/** default constructor */
	public Carriage() {
	}

	/** full constructor */
	public Carriage(String start, String destination, String company, Short cost) {
		this.start = start;
		this.destination = destination;
		this.company = company;
		this.cost = cost;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Carriage_ID", unique = true, nullable = false)
	public Long getCarriageId() {
		return this.carriageId;
	}

	public void setCarriageId(Long carriageId) {
		this.carriageId = carriageId;
	}

	@Column(name = "Start", nullable = false, length = 16)
	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Column(name = "Destination", nullable = false, length = 16)
	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Column(name = "Company", nullable = false, length = 64)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "Cost", nullable = false)
	public Short getCost() {
		return this.cost;
	}

	public void setCost(Short cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Carriage [carriageId=" + carriageId + ", start=" + start
				+ ", destination=" + destination + ", company=" + company
				+ ", cost=" + cost + "]";
	}
	
}