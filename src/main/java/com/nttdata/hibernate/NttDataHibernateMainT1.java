package com.nttdata.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttDataCustomer;
import com.nttdata.hibernate.services.NttDataCustomerManagementServiceI;
import com.nttdata.hibernate.services.NttDataCustomerManagementServiceImpl;

/**
 * Clase principal.
 * 
 * @author aguerrre
 *
 */
public class NttDataHibernateMainT1 {
	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NttDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final NttDataCustomerManagementServiceI service = new NttDataCustomerManagementServiceImpl(session);

		// Generación de clientes.
		final NttDataCustomer cust1 = new NttDataCustomer();
		cust1.setNombre("Agustín");
		cust1.setPrimerApellido("Guerrero");
		cust1.setSegundoApellido("Reyes");
		cust1.setDni("32165498E");

		final NttDataCustomer cust2 = new NttDataCustomer();
		cust2.setNombre("Tomás");
		cust2.setPrimerApellido("Mota");
		cust2.setSegundoApellido("Martínez");
		cust2.setDni("65498721P");

		service.insertNewCustomer(cust1);
		service.insertNewCustomer(cust2);

		// Listado de todos los clientes.
		List<NttDataCustomer> list = service.searchAll();
		System.out.println(list);

		// Búsqueda de un cliente por nombre y apellidos y modificación.
		List<NttDataCustomer> listUpdate = service.searchByName("Tomás", "Mota", "Martínez");
		NttDataCustomer cutUpdate = listUpdate.get(0);
		cutUpdate.setSegundoApellido("Sánchez");
		cutUpdate.setDni("78945632L");
		service.updateCustomer(cutUpdate);
		System.out.println("Cliente número " + cutUpdate.getId() + " actualizado.");

		// Listado de nuevo.
		list = service.searchAll();
		System.out.println(list);

		// Búsqueda de un cliente por nombre y apellidos para borrar.
		List<NttDataCustomer> listDelete = service.searchByName("Tomás", "Mota", "Sánchez");
		NttDataCustomer cutDelete = listDelete.get(0);
		System.out.println("Borrando cliente número " + cutDelete.getId());
		service.deleteCustomer(cutDelete);

		// Listado de nuevo de los clientes
		list = service.searchAll();
		System.out.println(list);

		// Cierre de sesión.
		session.close();

	}
}
