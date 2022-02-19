package es.edix.modelo.persistencia.interfaz;

import java.util.List;

import es.edix.modelo.entidad.Autor;

public interface DaoAutor {

	public boolean abrirConexion();
    public boolean cerrarConexion();
    public boolean añadir(Autor autor);
    public List<Autor> list();
}
