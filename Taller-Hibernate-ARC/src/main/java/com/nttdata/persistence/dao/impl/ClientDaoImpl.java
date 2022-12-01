package com.nttdata.persistence.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nttdata.persistence.dao.interfaces.ClientDaoI;
import com.nttdata.persistence.entities.Client;
import com.nttdata.persistence.entities.Contract;

/**
 * Taller de Hibernate
 * 
 * @author Alejandro Rebola Casquero
 *
 */
public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByName(final String name) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza jugadores en función del nombre.
		return session.createQuery("FROM Client WHERE name='" + name + "'").list();
	}

	@Override
	public List<Client> searchByNameAndContractId(final String namePattern, final Long contractId) {

		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Client> cquery = cb.createQuery(Client.class);
		final Root<Client> rootP = cquery.from(Client.class);
		final Join<Client, Contract> pJoinT = rootP.join("contract");

		// Where.
		final Predicate pr1 = cb.like(pJoinT.getParent().<String>get("name"), namePattern);
		final Predicate pr2 = cb.gt(pJoinT.<Long>get("contractId"), contractId);

		// Consulta.
		cquery.select(rootP).where(cb.and(pr1, pr2));

		// Ejecución de consulta.
		return session.createQuery(cquery).getResultList();
	}

}
