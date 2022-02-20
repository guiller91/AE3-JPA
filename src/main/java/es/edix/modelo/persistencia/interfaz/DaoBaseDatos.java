package es.edix.modelo.persistencia.interfaz;


public interface DaoBaseDatos {

	/**
	 * Borrara la Base de datos Librerias_jpa
	 */
	public void drop();  
	
	/**
	 * Comprobacion de la tabla Autor para saber si hay informacion
	 * @return nRows - long 
	 */
	public long comprobarTablas();
	
	/**
	 * Añadiremos toda la informacion en la bbdd a traves del Autor.
	 */
	public void rellenarTablas();
    
    

}
