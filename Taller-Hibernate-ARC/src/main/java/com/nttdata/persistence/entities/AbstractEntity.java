package com.nttdata.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL */
	private static final long serialVersionUID = 1L;

	/** Usuario de creación - AUDIT */
	private String updatedUser;

	/** Fecha de creación - AUDIT */
	private Date updatedDate;

	/**
	 * Método genérico para obtención de PK
	 * 
	 * @return Long
	 */
	@Transient
	public abstract Long getId();

	/**
	 * @return the createUser
	 */
	@Column(name = "C_CREATE_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param createUser the createUser to set
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updatedDate
	 */
	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
