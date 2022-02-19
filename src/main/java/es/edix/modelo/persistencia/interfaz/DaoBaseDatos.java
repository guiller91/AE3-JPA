package es.edix.modelo.persistencia.interfaz;


public interface DaoBaseDatos {

   
	public void drop();    
	public long comprobarTablas() ;
	public void rellenarTablas();
    
    

}
