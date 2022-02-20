package es.edix.modelo.persistencia;

import es.edix.modelo.entidad.Libro;
import es.edix.modelo.persistencia.interfaz.DaoLibro;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DaoLibroMySql implements DaoLibro {

    private String JPAEntityName = "JPALibrerias";

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    
    @Override
    public boolean abrirConexion() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(JPAEntityName);
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
    public List<Libro> list() {
        try {                  
			List<Libro> libros = entityManager.createQuery("from Libro libro").getResultList();			
            return libros;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return null;
        }

    }

    
    

}
