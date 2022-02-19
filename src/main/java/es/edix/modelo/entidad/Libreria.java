package es.edix.modelo.entidad;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "librerias")
public class Libreria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String propietario;
   
    @Embedded
    private Direccion direccion;
    
    @ManyToMany(mappedBy = "librerias", cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Libro> libros;

    
    public Libreria() {
        super();
    }

    
    public Libreria(String nombre, String propietario, Direccion direccion) {
        super();
        try {
            this.nombre = nombre;
            this.propietario = propietario;
            this.direccion = direccion;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }

    }

    
    public Libreria(int id, List<Libro> libros) {
        super();
        try {
            this.id = id;
            this.libros = libros;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getNombre() {
        return nombre;
    }

   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getPropietario() {
        return propietario;
    }

    
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    
    public Direccion getDireccion() {
        return direccion;
    }

    
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    
    public List<Libro> getLibros() {
        return libros;
    }

    
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    
    public void setLibro(Libro libro) {
        this.libros.add(libro);
    }
    
    
    @Override
    public String toString() {
        return "Id " + id + ": "
                + nombre + ", "
                + "Direccion: " + direccion.getCalle()
                + ", "  + direccion.getCiudad() 
                + ", " + direccion.getPais()
                + ", cp: " + direccion.getCp()
                + ", Dueño: " + propietario;
    }

}
