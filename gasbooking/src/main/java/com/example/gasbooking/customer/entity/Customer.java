package com.example.gasbooking.customer.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.gasbooking.entity.AbstractAuditingEntity;

@Entity
@Table(name = "customer")
public class Customer extends AbstractAuditingEntity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "Integer(5)")
	private int customerId;

	@Column(name = "customer_name", unique = true)
	@NotNull
	@NotBlank(message = "customername is mandatory")
	private String customerName;

	@Column(name = "customer_address")
	@NotNull
	@NotBlank(message = "customeraddress is mandatory")
	private String customerAddress;

	private boolean isEnabled;

	private boolean adminEnabled;

	@Column(name = "customer_phoneno")
	@NotNull
	@NotBlank(message = "customerphoneno is mandatory")
	private Long customerPhoneno;

	@Column(name = "customer_email", unique = true)
	@NotNull
	@NotBlank(message = "customeremail is mandatory")
	private String customerEmail;

	@Column(name = "customer_password")
	@NotNull
	@NotBlank(message = "customerpassword is mandatory")
	private String customerPassword;

	@Column(name = "file_name")
	@NotNull
	@NotBlank(message = "filename is mandatory")
	private String fileName;

	@Column(name = "file_type")
	@NotNull
	@NotBlank(message = "filetype is mandatory")
	private String fileType;

	@Lob
	private byte[] data;

	@Column(name = "connection_type")
	@NotNull
	@NotBlank(message = "connectiontype is mandatory")
	private String connectionType;


	@Column(name = "customer_total_cylinder")
	@NotNull
	@NotBlank(message = "customertotalcylinder is mandatory")
	private int customerTotalCylinder = 12;

	@Column(name = "roles", nullable = false, columnDefinition = "varchar(255) default 'ROLE_USER'")
	private String roles = "ROLE_USER";

	@Column(name = "confirmation_token")
	@NotNull
	@NotBlank(message = "confirmationtoken is mandatory")
	private String confirmationToken = UUID.randomUUID().toString();

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Long getCustomerPhoneno() {
		return customerPhoneno;
	}

	public void setCustomerPhoneno(Long customerPhoneno) {
		this.customerPhoneno = customerPhoneno;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public int getCustomerTotalCylinder() {
		return customerTotalCylinder;
	}

	public void setCustomerTotalCylinder(int customerTotalCylinder) {
		this.customerTotalCylinder = customerTotalCylinder;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public boolean isAdminEnabled() {
		return adminEnabled;
	}

	public void setAdminEnabled(boolean adminEnabled) {
		this.adminEnabled = adminEnabled;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public Customer(int customerId, String customerName, String customerAddress, boolean isEnabled,boolean adminEnabled,
			Long customerPhoneno, String customerEmail, String customerPassword, String fileName, String fileType,
			byte[] data, int customerTotalCylinder, String confirmationToken, String roles) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.isEnabled = isEnabled;
		this.customerPhoneno = customerPhoneno;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.customerTotalCylinder = customerTotalCylinder;
		this.roles = roles;
		this.confirmationToken = confirmationToken;
		this.adminEnabled=adminEnabled;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

}
