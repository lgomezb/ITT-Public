package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Laura Gomez
 * @author Pilar Lobon 
 */

@Entity
@Table(name = "editoriales")
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	@Embedded
	private Direccion direccion;
	
	//CASCADE.ALL HACE QUE SI ELIMMINAMOS UNA EDITORIAL SE ELIMINARAN LOS LIBROS QUE SE ENCUENTREN EN EL
	@OneToMany(mappedBy="editorial", cascade=CascadeType.ALL) 
	private List<Libro> libros;

	
	
	/**
	 * Constructor de la clase Editorial vacia
	 */
	public Editorial() {
		super();
	}

	/**
	 * Constructor de la entidad Editorial
	 * @param nombre String que almacena el nombre de la editorial
	 */
	public Editorial(String nombre) {
		super();
		this.nombre = nombre;
	}

	/**
	 * Metodo que retorna el nombre de la editorial
	 * @return el String nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que establece el nombre de la editorial
	 * @param nombre 
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que establece la direccion de la editorial
	 * @param direccion 
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo que retorna la lista de objetos Libro libros
	 * @return la Lista libros
	 */
	public List<Libro> getLibros() {
		return libros;
	}

	/**
	 * Metodo que establece una lista de objetos Libro
	 * @param libros, 
	 */
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
	
	
	
	
	
	
}
