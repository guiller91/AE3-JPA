package es.edix.modelo.persistencia;

import es.edix.modelo.entidad.Autor;
import es.edix.modelo.persistencia.interfaz.DaoAutor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DaoAutorMySql implements DaoAutor {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	@Override
	public boolean abrirConexion() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("JPALibrerias");
			entityManager = entityManagerFactory.createEntityManager();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getLocalizedMessage());
			return false;
		}

	}

	@Override
	public boolean cerrarConexion() {
		try {
			entityManager.close();
			entityManagerFactory.close();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getLocalizedMessage());
			return false;
		}

	}

	@Override
	public boolean añadir(Autor autor) {
		try {
			System.out.println("Conexion abierta = " + abrirConexion());
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(autor);
			entityTransaction.commit();
			System.out.println("Conexion cerrada = " + cerrarConexion());
			return true;
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getLocalizedMessage());
			System.err.println("Conexion cerrada = " + cerrarConexion());
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Autor> list() {
		try {
			List<Autor> autores = entityManager.createQuery("from Autor a" ).getResultList();
			return autores;
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getLocalizedMessage());
			System.out.println("Conexion cerrada = " + cerrarConexion());
			return null;
		}

	}

	

}
