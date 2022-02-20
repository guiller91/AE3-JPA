package es.edix.modelo.persistencia.interfaz;

import java.util.List;

import es.edix.modelo.entidad.Libro;

public interface DaoLibro {

	/**
	 * Abrir conexion con la bbdd mediante JPALibrerias
	 * @return true - se ha conectado correctamente<p>false - en caso contrario</p>
	 */
	public boolean abrirConexion();
	
	/**
	 * Cerrar la conexion con la bbdd
	 * @return true - se ha desconectado correctamente<p>false - en caso contrario</p>
	 */
    public boolean cerrarConexion();
    
    /**
     * Nos devolvera la informacion de la tabla Libreria
     * @return list<Libreria> 
     */
    public List<Libro> list();
}
