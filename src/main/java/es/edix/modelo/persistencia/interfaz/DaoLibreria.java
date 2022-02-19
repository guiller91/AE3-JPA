package es.edix.modelo.persistencia.interfaz;

import java.util.List;


import es.edix.modelo.entidad.Libreria;

public interface DaoLibreria {
	
	public boolean abrirConexion();
    public boolean cerrarConexion();
    public List<Libreria> list();

}
