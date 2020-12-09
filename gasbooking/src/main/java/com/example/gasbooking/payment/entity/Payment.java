package com.example.gasbooking.payment.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.gasbooking.customer.entity.Customer;
import com.example.gasbooking.entity.AbstractAuditingEntity;
import com.example.gasbooking.gas.entity.Gas;

@Entity
@Table(name = "payment")
public class Payment extends AbstractAuditingEntity implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -172679100300408756L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "Integer(5)")
	private int paymentId;

	@Column(name = "payment_descp")
	@NotNull
	@NotBlank(message = "paymentDescp is mandatory")
	private String paymentDescp;
	
	@Column(name = "payment_amount")
	@NotNull
	@NotBlank(message = "paymentAmount is mandatory")
	private int paymentAmount;
	
	private LocalDate paymentDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gas_id", referencedColumnName = "id")
    private Gas gas;
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentDescp() {
		return paymentDescp;
	}

	public void setPaymentDescp(String paymentDescp) {
		this.paymentDescp = paymentDescp;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Gas getGas() {
		return gas;
	}

	public void setGas(Gas gas) {
		this.gas = gas;
	}

	public Payment( String paymentDescp,LocalDate localDate,int paymentAmount, Gas gas) {
		super();
		this.paymentDescp = paymentDescp;
		this.paymentDate=localDate;
		this.paymentAmount = paymentAmount;
		this.gas = gas;
	}
	public Payment() {
		
	}
}
