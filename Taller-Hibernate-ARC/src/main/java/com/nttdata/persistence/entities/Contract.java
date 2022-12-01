package com.nttdata.persistence.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Taller de Hibernate
 * 
 * @author Alejandro Rebola Casquero
 *
 */
@Entity
@Table(name = "T_CONTRACT")
public class Contract extends AbstractEntity implements Serializable {

	/** SERIAL */
	private static final long serialVersionUID = 1L;

	/** PK */
	private Long contractId;

	/** Name */
	private String name;

	/** Date Vig */
	private String dvig;

	/** Date Cad */
	private String dcad;

	/** Precio mensual */
	private Double price;

	/** client */
	private List<Client> client;

	/**
	 * @return the contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "C_PK_CONTRACT_ID")
	public Long getContractId() {
		return contractId;
	}

	/**
	 * @param contractId the contractId to set
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
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
	 * @return the dvig
	 */
	@Column(name = "C_DVIG")
	public String getDvig() {
		return dvig;
	}

	/**
	 * @param dvig the dvig to set
	 */
	public void setDvig(String dvig) {
		this.dvig = dvig;
	}

	/**
	 * @return the dcad
	 */
	@Column(name = "C_DCAD")
	public String getDcad() {
		return dcad;
	}

	/**
	 * @param dcad the dcad to set
	 */
	public void setDcad(String dcad) {
		this.dcad = dcad;
	}

	/**
	 * @return the price
	 */
	@Column(name = "C_PRICE")
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the client
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "contract")
	public List<Client> getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(List<Client> client) {
		this.client = client;
	}

	@Transient
	@Override
	public Long getId() {
		return this.contractId;
	}

	/**
	 * Método para indicar que clase es.
	 * 
	 * @return Class<?>
	 */
	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

	/**
	 * Método toString
	 */
	@Override
	public String toString() {
		return "Contrato: [ID Contrato=" + contractId + ", Fecha Inicio=" + dvig + ", Fecha fin=" + dcad + ", Precio="
				+ price + "]";
	}

}
