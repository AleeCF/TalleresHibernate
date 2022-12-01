package com.nttdata;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.entities.Client;
import com.nttdata.persistence.entities.Contract;
import com.nttdata.services.impl.GestionDualServiceImpl;
import com.nttdata.services.interfaces.GestionDualServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Taller de Hibernate
 * 
 * @author Alejandro Rebola Casquero
 *
 */
public class MainHibernate {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Llamada a la clase Logger
		Logger logger = LoggerFactory.getLogger(MainHibernate.class);

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inyección de servicio.
		final GestionDualServiceI dualService = new GestionDualServiceImpl(session);

		final String updatedUser = "AlejandroRC";
		final Date updatedDate = new Date();

		// Generación del primer cliente.
		final Client client = new Client();
		client.setDNI("44354562J");
		client.setName("Maria");
		client.setSurname1("Juarez");
		client.setSurname2("Carmona");
		client.setUpdatedDate(updatedDate);
		client.setUpdatedUser(updatedUser);

		// Generación de contrato.
		final Contract contract = new Contract();
		contract.setName("NTT Data");
		contract.setDvig("23/04/2021");
		contract.setDcad("21/06/2022");
		contract.setPrice(17543.46);
		contract.setUpdatedUser(updatedUser);
		contract.setUpdatedDate(updatedDate);

		// Generación de cliente-2.
		final Client client1 = new Client();
		client1.setDNI("45345678Y");
		client1.setName("Ramiro");
		client1.setSurname1("Juarez");
		client1.setSurname2("De Mostoles");
		client1.setUpdatedDate(updatedDate);
		client1.setUpdatedUser(updatedUser);

		// Generación de contrato-2.
		final Contract contract1 = new Contract();
		contract1.setName("Onyx");
		contract1.setDvig("13/07/2021");
		contract1.setDcad("24/03/2022");
		contract1.setPrice(14543.46);
		contract1.setUpdatedUser(updatedUser);
		contract1.setUpdatedDate(updatedDate);

		// Asignacion del cliente al contrato
		client.setContract(contract);
		client1.setContract(contract1);

		// Alta de cliente.
		dualService.insertNewContract(contract);
		dualService.insertNewContract(contract1);
		dualService.insertNewClient(client);
		dualService.insertNewClient(client1);

		// Debido al metodo ToString el retorno del logger unicamente mostrara la ultima consulta.

		// Muestra el nombre del cliente buscado.
//		List<Client> clients = dualService.searchByName("%o%");

		// Muestra el nombre del cliente buscado.
		List<Client> clients = dualService.searchByContractId("%i%", 1L);

		// Retorna el nombre del cliente junto con el contrato de empresa y su ID

		for (final Client clientt : clients) {
			logger.info(("Name client: " + clientt.getName() + " " + clientt.getSurname1() + " " + clientt.getSurname2()
					+ " | Contract with: " + clientt.getContract().getName() + " | " + " Contract ID: "
					+ clientt.getContract().getContractId()));
		}

		// Cierre de la sesión.
		session.close();

	}

}
