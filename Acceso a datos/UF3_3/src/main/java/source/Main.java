package source;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.entidad.*;

public class Main {

	// METODO PARA CREAR OBJETO CALENDAR INTRODUCIENDO LA FECHA
	public static Calendar crearfecha(int year, int month, int day) {
		Calendar c = new GregorianCalendar();
		// En calendar los meses empiezan en 00
		month = month - 1;
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);
		return c;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		//////// DESCLARACIÓN DE VARIABLES

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistenciaaa"); // CLASE QUE ABRE LA
																								// CONEXION A LA BBDD
		EntityManager em = emf.createEntityManager(); // OBJETO QUE GESTIONA UN CONJUNTO DE ENTIDADES

		// Scanner scan = new Scanner(System.in);
		// String option;

		// ESTABLECE LA FECHA DE NACIMIENTO
		Calendar fechanac = new GregorianCalendar();

		//////// CREAMOS LOS OBJETOS AUTOR
		Autor autor1 = new Autor("George", "Orwell");
		Autor autor2 = new Autor("J.K", "Rowling");
		Autor autor3 = new Autor("Laura", "Gallego");
		Autor autor4 = new Autor("Mark", "Twain");
		Autor autor5 = new Autor("Virginia", "Woolf");

		/////// CREAMOS LOS OBJETOS LIBRO
		Libro l1 = new Libro("1984", 14.95);
		Libro l2 = new Libro("The Ickabog", 16.20);
		Libro l3 = new Libro("Orlando", 22.00);
		Libro l4 = new Libro("Las aventuras de Tom Sawyer", 32.45);
		Libro l5 = new Libro("Donde los arboles cantan", 12.99);
		Libro l6 = new Libro("Cronicas de la Torre", 30.25);
		Libro l7 = new Libro("Traicion", 20);
		Libro l8 = new Libro("Perfeccion", 7.88);
		Libro l9 = new Libro("Cumbres Borrascosas", 9.99);
		Libro l10 = new Libro("Memorias de Idhun", 10.88);
		Libro l11 = new Libro("El pasado nunca vuelve", 8.99);
		Libro l12 = new Libro("Espionaje", 9.99);

		/////// CREAMOS LOS OBJETOS EDITORIAL
		Editorial e1 = new Editorial("Alfaguara");
		Editorial e2 = new Editorial("Tauro");
		Editorial e3 = new Editorial("El barco de Vapor");

		/////// CREAMOS LOS OBJETOS LIBRERIA
		Libreria libreria1 = new Libreria("Lapiceros", "Milagros");
		Libreria libreria2 = new Libreria("MilesdeLibros", "Juan Perez");

		/////// CREAMOS LOS OBJETOS DIRECCION
		Direccion d1 = new Direccion();
		Direccion d2 = new Direccion();
		Direccion d3 = new Direccion();
		Direccion d4 = new Direccion();
		Direccion d5 = new Direccion();

		// CREAMOS UNA LISTA POR CADA AUTOR -------LIBA = LIBRO DE AUTOR
		List<Libro> liba1 = new ArrayList<Libro>();
		List<Libro> liba2 = new ArrayList<Libro>();
		List<Libro> liba3 = new ArrayList<Libro>();
		List<Libro> liba4 = new ArrayList<Libro>();
		List<Libro> liba5 = new ArrayList<Libro>();

		// CREAMOS UNA LISTA POR CADA EDITORIAL -------LIBE = LIBROS EN EDITORIAL
		List<Libro> libe1 = new ArrayList<Libro>();
		List<Libro> libe2 = new ArrayList<Libro>();
		List<Libro> libe3 = new ArrayList<Libro>();

		// CREAMOS UNA LISTA POR CADA LIBRERIA
		List<Libro> librosEnLibreria1 = new ArrayList<Libro>(); // Lista de libros de libreria
		List<Libro> librosEnLibreria2 = new ArrayList<Libro>(); // Lista de libros de libreria

		// CREAMOS UNA LISTA POR CADA LIBRO -------LIBRE = LIBROS EN CADA LIBRERIA
		List<Libreria> libre1 = new ArrayList<Libreria>();
		List<Libreria> libre2 = new ArrayList<Libreria>();
		List<Libreria> libre3 = new ArrayList<Libreria>();
		List<Libreria> libre4 = new ArrayList<Libreria>();
		List<Libreria> libre5 = new ArrayList<Libreria>();
		List<Libreria> libre6 = new ArrayList<Libreria>();
		List<Libreria> libre7 = new ArrayList<Libreria>();
		List<Libreria> libre8 = new ArrayList<Libreria>();
		List<Libreria> libre9 = new ArrayList<Libreria>();
		List<Libreria> libre10 = new ArrayList<Libreria>();
		List<Libreria> libre11 = new ArrayList<Libreria>();
		List<Libreria> libre12 = new ArrayList<Libreria>();

		// CREAMOS UNA FECHA DE NACIMIENTO PARA CADA AUTOR Y SE LA ESTABLECEMOS
		fechanac = crearfecha(1903, 06, 25);
		autor1.setFecha_nac(fechanac);
		fechanac = crearfecha(1965, 06, 30);
		autor2.setFecha_nac(fechanac);
		fechanac = crearfecha(1977, 10, 11);
		autor3.setFecha_nac(fechanac);
		fechanac = crearfecha(1835, 11, 30);
		autor4.setFecha_nac(fechanac);
		fechanac = crearfecha(1882, 01, 25);
		autor5.setFecha_nac(fechanac);

		// CREAMOS DIRECCIONES Y LAS ASIGNAMOS DONDE CORRESPONDAN (eX-> EDITORIAL -----
		// libreriaX-> LIBRERIA)
		d1.setTipoVia("Avenida");
		d1.setNombreVia("de America");
		d1.setCiudad("Valencia");

		d2.setTipoVia("Calle");
		d2.setNombreVia("del Tornillo Suelto");
		d2.setCiudad("Albacete");

		d3.setTipoVia("Via");
		d3.setNombreVia("en honor a Laura y Pilar");
		d3.setCiudad("Barcelona");

		d4.setTipoVia("Paseo");
		d4.setNombreVia("de la Pantera Rosa");
		d4.setCiudad("Murcia");

		d5.setTipoVia("Urbanizacion");
		d5.setNombreVia("MataBlanca");
		d5.setCiudad("Segovia");

		e1.setDireccion(d1);
		e2.setDireccion(d2);
		e3.setDireccion(d3);

		libreria1.setDireccion(d4);
		libreria2.setDireccion(d5);

		// ASIGNAMOS CADA LIBRO A SU AUTOR
		l1.setAutor(autor1);
		l2.setAutor(autor2);
		l3.setAutor(autor5);
		l4.setAutor(autor4);
		l5.setAutor(autor3);
		l6.setAutor(autor3);
		l7.setAutor(autor1);
		l8.setAutor(autor2);
		l9.setAutor(autor3);
		l10.setAutor(autor4);
		l11.setAutor(autor5);
		l12.setAutor(autor1);

		// SE AÑADE CADA LIBRO A LA LISTA DE LIBROS (LISTA POR AUTOR) A LA QUE
		// PERTENEZCA
		liba1.add(l7);// lista de libros de autor1
		liba1.add(l12);
		liba1.add(l1);
		liba2.add(l8);// lista de libros de autor2
		liba2.add(l2);
		liba3.add(l9);// lista de libros de autor3
		liba3.add(l5);
		liba3.add(l6);
		liba4.add(l10);// lista de libros de autor4
		liba4.add(l6);
		liba5.add(l11);// lista de libros de autor5
		liba5.add(l3);

		// SE ASIGNA UNA LISTA DE LIBROS A CADA AUTOR (AUTOR ESCRIBE LIBROS QUE SE
		// PRESENTAN EN UNA LISTA)
		autor1.setLibros(liba1);
		autor2.setLibros(liba2);
		autor3.setLibros(liba3);
		autor4.setLibros(liba4);
		autor5.setLibros(liba5);

		// ASIGNAMOS CADA LIBRO LA EDITORIAL EN LA QUE SE ENCUENTRE PUBLICADO
		l1.setEditorial(e3);
		l2.setEditorial(e1);
		l3.setEditorial(e2);
		l4.setEditorial(e2);
		l5.setEditorial(e1);
		l6.setEditorial(e1);
		l7.setEditorial(e1);
		l8.setEditorial(e2);
		l9.setEditorial(e3);
		l10.setEditorial(e1);
		l11.setEditorial(e2);
		l12.setEditorial(e3);

		// AÑADIMOS CADA LIBRO A LA LISTA QUE CORRESPONDA (CADA EDITORIAL TIENE MUCHOS
		// LIBROS QUE ESTAN EN UNA LISTA)
		libe1.add(l7);// ed1
		libe1.add(l2);
		libe1.add(l5);
		libe1.add(l6);
		libe1.add(l10);
		libe2.add(l8);// ed2
		libe2.add(l11);
		libe2.add(l3);
		libe2.add(l4);
		libe3.add(l12);// ed3
		libe3.add(l1);
		libe3.add(l9);

		// ASIGNAMOS CADA LISTA DE LIBROS A SU EDITORIAL
		e1.setLibros(libe1);
		e2.setLibros(libe2);
		e3.setLibros(libe3);

		// AÑADIMOS CADA LIBRO A LA LIBRERIA EN LA QUE SE ENCUENTRE (CADA LIBRERIA TIENE
		// UNA LISTA DE LIBROS CON LOS QUE TRABAJA)
		librosEnLibreria1.add(l1);
		librosEnLibreria1.add(l2);
		librosEnLibreria1.add(l3);
		librosEnLibreria1.add(l4);
		librosEnLibreria1.add(l5);
		librosEnLibreria1.add(l6);
		librosEnLibreria2.add(l7);
		librosEnLibreria2.add(l8);
		librosEnLibreria2.add(l9);
		librosEnLibreria2.add(l10);
		librosEnLibreria2.add(l11);
		librosEnLibreria2.add(l12);

		// ASINAMOS CADA LISTA A SU LIBRERIA CORRESPONDIENTE
		libreria1.setLibros(librosEnLibreria1);
		libreria2.setLibros(librosEnLibreria2);

		// AÑADIMOS CADA LIBRERIA A CADA LIBRO (UN LIBRO SE PUEDE ENCONTRAR EN
		// LIBRERIAS)
		libre1.add(libreria1);
		libre2.add(libreria1);
		libre3.add(libreria1);
		libre4.add(libreria1);
		libre5.add(libreria1);
		libre6.add(libreria1);
		libre7.add(libreria2);
		libre8.add(libreria2);
		libre9.add(libreria2);
		libre10.add(libreria2);
		libre11.add(libreria2);
		libre12.add(libreria2);

		em.getTransaction().begin();

		// PERSISTEN EDITORIALES
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);

		// PERSISTEN AUTORES
		em.persist(autor1);
		em.persist(autor2);
		em.persist(autor3);
		em.persist(autor4);
		em.persist(autor5);

		// PERSISTEN LIBRERIAS
		em.persist(libreria1);
		em.persist(libreria2);

		System.out.println(" ----- Dando de alta las editoriales, autores y libros ----- ");
		em.getTransaction().commit(); // DEVUELVE LA TRANSACCION ACTUAL Y LA HACE COMMIT

		em.close();

		emf.close();
	}
}
