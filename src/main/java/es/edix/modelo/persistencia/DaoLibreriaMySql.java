package es.edix.modelo.persistencia;

import es.edix.modelo.entidad.Libreria;
import es.edix.modelo.persistencia.interfaz.DaoLibreria;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoLibreriaMySql implements DaoLibreria {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public boolean abrirConexion() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("JPALibrerias");
			entityManager = entityManagerFactory.createEntityManager();
			return true;
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getLocalizedMessage());
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
			System.out.println("ERROR: " + e.getLocalizedMessage());
			return false;
		}

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Libreria> list() {
		try {
			List<Libreria> librerias = entityManager.createQuery("from Libreria libreria").getResultList();

			return librerias;
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getLocalizedMessage());
			System.out.println("Conexion cerrada = " + cerrarConexion());
			return null;
		}

	}

}
