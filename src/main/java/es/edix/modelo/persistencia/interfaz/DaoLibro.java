package es.edix.modelo.persistencia.interfaz;

import java.util.List;

import es.edix.modelo.entidad.Libro;

public interface DaoLibro {

	public boolean abrirConexion();
    public boolean cerrarConexion();
    public List<Libro> list();
}
