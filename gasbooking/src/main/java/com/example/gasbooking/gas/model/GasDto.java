package com.example.gasbooking.gas.model;

import javax.validation.constraints.NotNull;

public class GasDto {
	private int gasId;
	private String gasType;
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

	public GasDto() {

	}

	public GasDto(int gasId, String gasType, Integer gasAmount, boolean gasStatus) {
		super();
		this.gasId = gasId;
		this.gasType = gasType;
		this.gasAmount = gasAmount;
		this.gasStatus = gasStatus;
	}
}
