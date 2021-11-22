package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * DAO de tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author aguerrre
 *
 */
public interface NttDataCustomerDaoI {

	/**
	 * Inserta un nuevo Cliente
	 * 
	 * @param cliente
	 *            - el cliente a insertar
	 */
	public void insert(final NttDataCustomer cliente);

	/**
	 * Actualiza los registros de un Cliente
	 * 
	 * @param cliente
	 *            - el cliente a actualizar
	 */
	public void update(final NttDataCustomer cliente);

	/**
	 * Borra un Cliente
	 * 
	 * @param cliente
	 *            - el cliente a borrar
	 */
	public void delete(final NttDataCustomer cliente);

	/**
	 * Busca un Cliente por el ID dado
	 * 
	 * @param id
	 *            - el ID del cliente que queremos buscar
	 * 
	 * @return NttDataCustomer
	 */
	public NttDataCustomer searchById(final Long id);

	/**
	 * Devuelve a todos los Clientes en la BD
	 * 
	 * @return List<NttDatacustomer> - Lista de Clientes
	 */
	public List<NttDataCustomer> searchAll();

	/**
	 * 
	 * Busca un Cliente por nombre y dos apellidos
	 * 
	 * @param name
	 *            - nombre del Cliente
	 * @param firstSurname
	 *            - primer apellido del Cliente
	 * @param secondSurname
	 *            - segundo apelldio del Cliente
	 * 
	 * @return List<NttDatacustomer> - Lista de Clientes
	 */
	public List<NttDataCustomer> searchByNameAndSurname(final String name, final String firstSurname, final String secondSurname);

}
