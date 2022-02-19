package es.edix.modelo.entidad;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "editoriales")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    
    @Embedded
    private Direccion direccion;
    
    @OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL)
    private List<Libro> libros;

    
    public Editorial() {
        super();
        libros=new ArrayList<>();
    }

   
    public Editorial(String nombre, Direccion direccion) {
        super();
        try {
            libros=new ArrayList<>();
            this.nombre = nombre;
            this.direccion = direccion;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

    
    public Editorial(int id, List<Libro> libros) {
        super();
        try {
            libros=new ArrayList<>();
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
        return "Editorial{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }

}