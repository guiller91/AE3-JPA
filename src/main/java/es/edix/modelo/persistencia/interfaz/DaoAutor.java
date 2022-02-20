package es.edix.modelo.persistencia.interfaz;

import java.util.List;

import es.edix.modelo.entidad.Autor;

public interface DaoAutor {
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
     * Añadiremos toda la informacion a la bbdd a traves del autor y su cascadeType.ALL
     * @param autor
     * @return true - Se ha añadido correctamente<p>false - en caso contrario</p>
     */
    public boolean añadir(Autor autor);
    
    /**
     * Nos devolvera toda la informacion de la tabla Autor
     * @return list<Autor> 
     */
    public List<Autor> list();
}
