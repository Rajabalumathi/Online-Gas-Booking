package com.example.gasbooking.gas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.gasbooking.entity.AbstractAuditingEntity;

@Entity
@Table(name = "gas")
public class Gas extends AbstractAuditingEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "Integer(5)")
	private int gasId;
	@Column(name = "gas_type")
	@NotNull
	private String gasType;
	@Column(name = "gas_amount")
	@NotNull
	private Integer gasAmount;
	
	private boolean gasStatus;

	public int getGasId() {
		return gasId;
	}

	public void setGasId(int gasId) {
		this.gasId = gasId;
	}

	public String getGasType() {
		return gasType;
	}

	public void setGasType(String gasType) {
		this.gasType = gasType;
	}

	public Integer getGasAmount() {
		return gasAmount;
	}

	public void setGasAmount(Integer gasAmount) {
		this.gasAmount = gasAmount;
	}

	public boolean getGasStatus() {
		return gasStatus;
	}

	public void setGasStatus(boolean gasStatus) {
		this.gasStatus = gasStatus;
	}

	public Gas() {

	}

	public Gas(int gasId, String gasType,Integer gasAmount, boolean gasStatus) {
		super();
		this.gasId = gasId;
		this.gasType = gasType;
		this.gasAmount = gasAmount;
		this.gasStatus = gasStatus;
	}

}