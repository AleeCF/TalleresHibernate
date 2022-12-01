package com.nttdata.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.persistence.dao.impl.ClientDaoImpl;
import com.nttdata.persistence.dao.impl.ContractDaoImpl;
import com.nttdata.persistence.dao.interfaces.ClientDaoI;
import com.nttdata.persistence.dao.interfaces.ContractDaoI;
import com.nttdata.persistence.entities.Client;
import com.nttdata.persistence.entities.Contract;
import com.nttdata.services.interfaces.GestionDualServiceI;

/**
 * Taller de Hibernate
 * 
 * @author Alejandro Rebola Casquero
 *
 */
public class GestionDualServiceImpl implements GestionDualServiceI {

	private ClientDaoI clientDao;

	public ClientDaoI getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDaoI clientDao) {
		this.clientDao = clientDao;
	}

	/* Inyección DAO de t_contrato */
	private ContractDaoI contractDao;

	public void setContractDao(ContractDaoI contractDao) {
		this.contractDao = contractDao;
	}

	/**
	 * Metodo constructor.
	 */
	public GestionDualServiceImpl(final Session session) {
		this.clientDao = new ClientDaoImpl(session);
		this.contractDao = new ContractDaoImpl(session);
	}

	/* Inserccion de nuevo Cliente */

	@Override
	public void insertNewClient(final Client newClient) {

		// Verificación de nulidad e inexistencia.
		if (newClient != null && newClient.getClientId() == null) {
			// Insercción del nuevo contrato.
			clientDao.insert(newClient);
		}
	}

	/* Update del Cliente */

	@Override
	public void updateClient(final Client updatedClient) {
		// Verificación de nulidad y existencia.
		if (updatedClient != null && updatedClient.getClientId() != null) {
			// Actualización del contrato.
			clientDao.update(updatedClient);
		}
	}

	/* Borra el Cliente */

	@Override
	public void deleteClient(final Client deletedClient) {
		// Verificación de nulidad y existencia.
		if (deletedClient != null && deletedClient.getClientId() != null) {
			// Eliminación del contrato.
			clientDao.delete(deletedClient);
		}
	}

	/* Busca el Cliente por ID */

	@Override
	public Client searchById(final Long clientId) {
		// Resultado.
		Client client = null;
		// Verificación de nulidad.
		if (clientId != null) {
			// Obtención del contrato por ID.
			client = clientDao.searchById(clientId);
		}
		return client;
	}

	/* Buscar cliente por Nombre */

	@Override
	public List<Client> searchByName(final String name) {

		// Resultado.
		List<Client> clientsList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name)) {

			// Obtención del jugador por nombre.
			clientsList = clientDao.searchByName(name);
		}
		return clientsList;
	}
	/* Buscar todo del Cliente */

	@Override
	public List<Client> searchAll() {
		// Resultado.
		List<Client> clientList = new ArrayList<>();
		// Obtención de contratos.
		clientList = clientDao.searchAll();
		return clientList;
	}

	/* Buscar Cliente por Id del contrato */

	@Override
	public List<Client> searchByContractId(String namePattern, Long contractId) {

		// Resultado.
		List<Client> clientList = new ArrayList<>();
		// Obtención de jugadores.
		clientList = clientDao.searchByNameAndContractId(namePattern, contractId);
		return clientList;
	}

	/* Insertar nuevo Contrato */

	@Override
	public void insertNewContract(final Contract newContract) {

		// Verificación de nulidad e inexistencia.
		if (newContract != null && newContract.getContractId() == null) {
			// Insercción del nuevo contrato.
			contractDao.insert(newContract);
		}
	}

	/* Update del Contrato */

	@Override
	public void updateContract(final Contract updateContract) {
		// Verificación de nulidad y existencia.
		if (updateContract != null && updateContract.getContractId() != null) {
			// Actualización del contrato.
			contractDao.update(updateContract);
		}
	}

	/* Borra el Contrato */

	@Override
	public void deleteContract(Contract deleteContract) {
		// Verificación de nulidad y existencia.
		if (deleteContract != null && deleteContract.getContractId() != null) {
			// Eliminación del contrato.
			contractDao.delete(deleteContract);
		}
	}

	/* Buscar el contrato por su ID */

	@Override
	public Contract searchByContractId(final Long contractId) {
		// Resultado.
		Contract contract = null;
		// Verificación de nulidad.
		if (contractId != null) {
			// Obtención del contrato por ID.
			contract = contractDao.searchById(contractId);
		}
		return contract;
	}

	/* Buscar todo del contrato */

	@Override
	public List<Contract> searchAllContract() {
		// Resultado.
		List<Contract> contractList = new ArrayList<>();

		// Obtención de contrato.
		contractList = contractDao.searchAll();

		return contractList;
	}

}
