package com.example.gasbooking.delievery.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.gasbooking.entity.AbstractAuditingEntity;
import com.example.gasbooking.gas.entity.Gas;

@Entity
@Table(name = "delievery")
public class Delievery extends AbstractAuditingEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6980640397441265327L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "Integer(5)")
	private int delieveryId;

	@Column(name = "delievery_title")
	@NotNull
	@NotBlank(message = "delieverytitle is mandatory")
	private String delieveryTitle;

	private LocalDate delieveryDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gas_id", referencedColumnName = "id")
	private Gas gas;

	private boolean delieveryStatus;

	public boolean isDelieveryStatus() {
		return delieveryStatus;
	}

	public void setDelieveryStatus(boolean delieveryStatus) {
		this.delieveryStatus = delieveryStatus;
	}

	public int getDelieveryId() {
		return delieveryId;
	}

	public void setDelieveryId(int delieveryId) {
		this.delieveryId = delieveryId;
	}

	public String getDelieveryTitle() {
		return delieveryTitle;
	}

	public void setDelieveryTitle(String delieveryTitle) {
		this.delieveryTitle = delieveryTitle;
	}

	public LocalDate getDelieveryDate() {
		return delieveryDate;
	}

	public void setDelieveryDate(LocalDate delieveryDate) {
		this.delieveryDate = delieveryDate;
	}

	public Gas getGas() {
		return gas;
	}

	public void setGas(Gas gas) {
		this.gas = gas;
	}

	public Delievery() {

	}

	public Delievery(String delieveryTitle, LocalDate delieveryDate, Gas gas,boolean delieveryStatus) {
		super();
		this.delieveryTitle = delieveryTitle;
		this.delieveryDate = delieveryDate;
		this.gas = gas;
		this.delieveryStatus=delieveryStatus;
	}

}
