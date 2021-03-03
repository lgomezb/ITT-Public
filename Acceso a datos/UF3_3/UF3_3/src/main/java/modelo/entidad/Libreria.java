package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Laura
 *
 */
@Entity
@Table(name = "librerias")
public class Libreria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String dueño;
	@Embedded
	private Direccion direccion;

	@ManyToMany(cascade = CascadeType.ALL)
	// Tabla de union Many to Many
	@JoinTable(name = "librerias_libros", joinColumns = {
			@JoinColumn(name = "fk_id_libreria", referencedColumnName = "id") }, // FK que aporta Libreria
			inverseJoinColumns = { @JoinColumn(name = "fk_id_libro", referencedColumnName = "id") }) // FKs que aportan
																										// el resto de
																										// entidades
	private List<Libro> libros;

	/**
	 * Constructor de la entidad Libreria
	 */
	public Libreria() {
		super();
	}

	/**
	 * Clase que permite almacenar la informacion de una libreria
	 * 
	 * @param nombre String nombre de la libreria
	 * @param dueño  String nombre del dueño de la libreria
	 */
	public Libreria(String nombre, String dueño) {
		super();
		this.nombre = nombre;
		this.dueño = dueño;

	}

	/**
	 * Metodo que retorna el nombre de la libreria
	 * 
	 * @return el String nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que establece el nombre de la libreria
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que establece el dueño de la libreria
	 * 
	 * @param dueño
	 */
	public void setDueño(String dueño) {
		this.dueño = dueño;
	}

	/**
	 * Metodo que establece la direccion de la libreria
	 * 
	 * @param direccion
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo que establece la lista de Libros libros
	 * 
	 * @return la Lista libros
	 */
	public List<Libro> getLibros() {
		return libros;
	}

	/*
	 * Metodo que establece la lista de libros libros
	 * 
	 * @param libros
	 */
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

}
