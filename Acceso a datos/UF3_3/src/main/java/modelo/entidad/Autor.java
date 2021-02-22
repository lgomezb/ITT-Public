package modelo.entidad;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Clase que permite almacenar la informacion de un autor
 * @author Laura Gomez
 * @Author Pilar Lobon
 */
@Entity

@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    @Temporal(TemporalType.DATE)
    private Calendar fecha_nac;
    
    //MAPEAMOS DESDE EL ATRIBUTO AUTOR LA LISTA DE LIBROS libros
    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL)
    private List<Libro> libros;

    /*
     * The attribute [libros] in entity class [class modelo.entidad.Autor] 
     * has a mappedBy value of [autores] 
     * which does not exist in its owning entity class [class modelo.entidad.Libro]. 
     * If the owning entity class is a @MappedSuperclass, 
     * this is invalid, and your attribute should reference the correct subclass.
     */
    
    
    /*
     * Constructor vacio de la clase Autor
     */
    public Autor() {
    }
    
    /*
     * Constructor de la clase Autor
     * @param nombre String que almacena el nombre del autor
     * @param apellido String que almacena el apellido del autor
     */
	public Autor(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	/*
	 * Metodo que retorna el nombre del autor
	 * @return el String nombre
	 */
    public String getNombre() {
        return nombre;
    }

    /*
     * Metodo que establece el nombre del autor
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	/*
	 * Metodo que retorna el apellido del autor
	 * @return el String apellido
	 */
    public String getApellidos() {
        return apellidos;
    }

    /*
     * Metodo que establece el apellido del autor
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
	/*
	 * Metodo que establece la fecha de nacimiento del autor
	 * @param fecha_nac
	 */
    public void setFecha_nac(Calendar fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

	/*
	 * Metodo que retorna la lista de libros libros
	 * @return la Lista libros
	 */
    public List<Libro> getLibros() {
        return libros;
    }

	/*
	 * Metodo que establece la lista de libros libros
	 * @param libros
	 */
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }



}