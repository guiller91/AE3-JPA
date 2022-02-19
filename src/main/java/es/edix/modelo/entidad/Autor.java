package es.edix.modelo.entidad;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellidos;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;

   
    public Autor() {
        super();
        libros= new ArrayList<>();
    }

    
	public Autor(String nombre, String apellidos, String fechaNacimiento) {
		super();
		try {
			libros = new ArrayList<>();
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento);
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getLocalizedMessage());
		}
	}

    
    public Autor(int id, List<Libro> libros) {
        super();
        try {
            this.id = id;
            this.libros = libros;
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
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

   
    public String getApellidos() {
        return apellidos;
    }

    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

   
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
        return "Id " + id + ": " + nombre + " " + apellidos + ", nacido el " + fechaNacimiento;
    }

}
