package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Laura
 *
 */
@Entity

@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private double precio;
  
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_autor", referencedColumnName = "id")
    private Autor autor; 

    @ManyToMany(mappedBy ="libros", cascade = CascadeType.PERSIST) //Este cascade es una aberracion
    private List<Libreria> librerias;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_editorial", referencedColumnName = "id")
    private Editorial editorial;
    
    
    /**
     * Constructor vacio de la clase Libro
     */
    public Libro() {

    }


	/**
	 * Constructor de la clase Libro
	 * @param titulo String que almacena el titulo del libro
	 * @param precio double que almacena el precio del libro
	 */
	public Libro(String titulo, double precio) {
		super();
		this.titulo = titulo;
		this.precio = precio;

	}
	

	/**
	 * Metodo que retorna el titulo de un libro
	 * @return el String titulo
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * Metodo que establece el titulo de un libro
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	/**
	 * Metodo que retorna el precio de un libro
	 * @return el double precio
	 */
	public double getPrecio() {
		return precio;
	}


	/**
	 * Metodo que establece el precio de un libro
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}


	/**
	 * Metodo que retorna el autor de un libro
	 * @return el objeto Autor autor
	 */
	public Autor getAutor() {
		return autor;
	}


	/**
	 * Metodo que establece el escritor de un libro
	 * @param escritor
	 */
	public void setAutor(Autor escritor) {
		this.autor = escritor;
	}


	/**
	 * Metodo que retorna la Lista librerias
	 * @return la Lista de Objetos Libreria librerias
	 */
	public List<Libreria> getLibrerias() {
		return librerias;
	}


	/**
	 * Metodo que establece la lista de librerias
	 * @param librerias
	 */
	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}


	/**
	 * Metodo que retorna la editorial de un libro
	 * @return el Objeto Editorial editorial
	 */
	public Editorial getEditorial() {
		return editorial;
	}


	/**
	 * Metodo que establece la editorial de un libro
	 * @param editorial
	 */
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

    
}

	

