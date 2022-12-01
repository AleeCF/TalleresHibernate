package com.nttdata.persistence.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Taller de Hibernate
 * 
 * @author Alejandro Rebola Casquero
 *
 */
@Entity
@Table(name = "T_CLIENT")
public class Client extends AbstractEntity implements Serializable {

	/** SERIAL */
	private static final long serialVersionUID = 1L;

	/** PK */
	private Long clientId;

	/** Name */
	private String name;

	/** Surname1 */
	private String surname1;

	/** Surname2 */
	private String surname2;

	/** DNI */
	private String DNI;

	/** Contrato asociada */
	private Contract contract;

	/**
	 * @return the clientId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "C_PK_client_ID")
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "C_NAME")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname1
	 */
	@Column(name = "C_SURNAME1")
	public String getSurname1() {
		return surname1;
	}

	/**
	 * @param name the surname1 to set
	 */
	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	/**
	 * @return the surname2
	 */
	@Column(name = "C_SURNAME2")
	public String getSurname2() {
		return surname2;
	}

	/**
	 * @param name the surname2 to set
	 */
	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	/**
	 * @return the DNI
	 */
	@Column(name = "C_DNI")
	public String getDNI() {
		return DNI;
	}

	/**
	 * @param name the DNI to set
	 */
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	/**
	 * @return the contract
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_FK_CONTRACT_ID", referencedColumnName = "C_PK_CONTRACT_ID")
	public Contract getContract() {
		return contract;
	}

	/**
	 * @param contract the contract to set
	 */
	public void setContract(Contract contract) {
		this.contract = contract;
	}

	@Transient
	@Override
	public Long getId() {
		return this.clientId;
	}

	/**
	 * Método para indicar que clase es.
	 * 
	 * @return Class<?>
	 */
	@Transient
	public Class<?> getClase() {
		return Client.class;
	}

	/**
	 * Método toString
	 */
	@Override
	public String toString() {
		return "Cliente: [ID Cliente=" + clientId + ", Nombre=" + name + ", Primer Apellido=" + surname1
				+ ", Segundo Apellido=" + surname2 + ", DNI=" + DNI + "]";
	}

}
