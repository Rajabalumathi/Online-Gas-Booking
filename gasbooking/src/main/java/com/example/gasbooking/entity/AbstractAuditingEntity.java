package com.example.gasbooking.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdDate", "updatedDate" }, allowGetters = true)
public abstract class AbstractAuditingEntity implements Serializable {

	/** The Serial version UID. */
	private static final long serialVersionUID = 1L;

	/** Entity/Record created date. */
	@Column(name = "created_date", updatable = false)
	
	@CreatedDate
	private LocalDateTime createdDate;

	/** Entity/Record updated date. */
	@Column(name = "updated_date")
	
	@LastModifiedDate
	private LocalDateTime updatedDate;
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
}
