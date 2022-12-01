package com.nttdata.persistence.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.dao.interfaces.ContractDaoI;
import com.nttdata.persistence.entities.Contract;

/**
 * Taller de Hibernate
 * 
 * @author Alejandro Rebola Casquero
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override

	public Contract searchByContract(final String contract) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza equipo en función del nombre.
		final List<Contract> contractList = session.createQuery("FROM Contract WHERE name=" + contract).list();

		// Resultado.
		Contract contract1 = null;
		if (contractList != null && contractList.size() > 0) {
			contract1 = contractList.get(0);
		}

		return contract1;
	}

}
