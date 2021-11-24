package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * DAO de tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author aguerrre
 * @param <T>
 *
 */
public class NttDataCustomerDaoImpl implements NttDataCustomerDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor.
	 * 
	 * @param session
	 */
	public NttDataCustomerDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public void insert(NttDataCustomer cliente) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.save(cliente);
		session.flush();

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public void update(NttDataCustomer cliente) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.saveOrUpdate(cliente);

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public void delete(NttDataCustomer cliente) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.delete(cliente);

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public NttDataCustomer searchById(Long id) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por PK.
		NttDataCustomer result = (NttDataCustomer) session.get(NttDataCustomer.class, id);

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NttDataCustomer> searchAll() {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		List<NttDataCustomer> list = session.createQuery("FROM NttDataCustomer").list();

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NttDataCustomer> searchByNameAndSurname(String name, String firstSurname, String secondSurname) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza clientes en función del nombre, primer apellido y segundo apellido.
		final List<NttDataCustomer> playersList = session
		        .createQuery("FROM NttDataCustomer WHERE NOMBRE= :nombre AND PRIMER_APELLIDO = :primer AND SEGUNDO_APELLIDO= :segundo")
		        .setParameter("nombre", name).setParameter("primer", firstSurname).setParameter("segundo", secondSurname).list();

		return playersList;

	}

}
