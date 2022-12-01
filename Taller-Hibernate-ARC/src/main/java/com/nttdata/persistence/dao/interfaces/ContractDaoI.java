package com.nttdata.persistence.dao.interfaces;

import com.nttdata.persistence.entities.Contract;

public interface ContractDaoI extends CommonDaoI<Contract> {

	// MÉTODOS CONCRETOS DE LA TABLA
	
	/**
	 * Obtiene contratos por nombre.
	 * 
	 * @param name
	 * @return List<Contract>
	 */
	public Contract searchByContract(final String contract);
}
