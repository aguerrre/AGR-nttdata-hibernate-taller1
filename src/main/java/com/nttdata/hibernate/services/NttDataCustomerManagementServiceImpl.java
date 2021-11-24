package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttDataCustomer;
import com.nttdata.hibernate.persistence.NttDataCustomerDaoI;
import com.nttdata.hibernate.persistence.NttDataCustomerDaoImpl;

/**
 * Implementación del servicio de clientes.
 * 
 * @author aguerrre
 *
 */
public class NttDataCustomerManagementServiceImpl implements NttDataCustomerManagementServiceI {

	/** DAO: NTTDATA_TH1_CUSTOMER */
	private NttDataCustomerDaoI customerDao;

	/**
	 * Método constructor.
	 */
	public NttDataCustomerManagementServiceImpl(final Session session) {
		this.customerDao = new NttDataCustomerDaoImpl(session);
	}

	@Override
	public void insertNewCustomer(NttDataCustomer newCustomer) {

		// Verificación de nulidad e inexistencia.
		if (newCustomer != null && newCustomer.getId() == null) {

			// Insercción del nuevo cliente.
			customerDao.insert(newCustomer);
		}

	}

	@Override
	public void updateCustomer(NttDataCustomer updatedCustomer) {

		// Verificación de nulidad e inexistencia.
		if (updatedCustomer != null && updatedCustomer.getId() == null) {

			// Actualización del nuevo cliente.
			customerDao.update(updatedCustomer);
		}

	}

	@Override
	public void deleteCustomer(NttDataCustomer deletedCustomer) {

		// Verificación de nulidad e inexistencia.
		if (deletedCustomer != null && deletedCustomer.getId() != null) {

			// Borrado del nuevo cliente.
			customerDao.delete(deletedCustomer);
		}

	}

	@Override
	public NttDataCustomer searchById(Long customerId) {

		// Resultado.
		NttDataCustomer customer = null;

		// Verificación de nulidad.
		if (customerId != null) {

			// Obtención del cliente por ID.
			customer = customerDao.searchById(customerId);
		}

		return customer;

	}

	@Override
	public List<NttDataCustomer> searchAll() {

		// Resultado.
		List<NttDataCustomer> list = new ArrayList<NttDataCustomer>();

		// Obtención de clientes.
		list = customerDao.searchAll();

		return list;

	}

	@Override
	public List<NttDataCustomer> searchByName(String name, String firstSurname, String secondSurname) {

		// Resultado.
		List<NttDataCustomer> list = new ArrayList<NttDataCustomer>();

		// Obtención de clientes.
		list = customerDao.searchByNameAndSurname(name, firstSurname, secondSurname);

		return list;

	}

}
