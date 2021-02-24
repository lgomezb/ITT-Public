package source;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Autor;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class Peticiones {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistenciaaa");

		EntityManager em = emf.createEntityManager();
		Scanner scan = new Scanner(System.in);
		String option;

		System.out.println("Bienvenido, seleccione una opción");

		do {
			System.out.println("////////////////////////////////////////////////////////////////////////");
			System.out.println("1.Mostrar todos los libros dados de alta, con su editorial y su autor");
			System.out.println("2.Mostrar todos los autores dados de alta, con sus libros asociados");
			System.out.println("3.Mostrar todas las librerías, con solamente sus libros asociados");
			System.out.println("4.Mostrar todos los libros dados de alta, y en la librería en la que están");
			System.out.println("5.Cerrar el programa");
			System.out.println("////////////////////////////////////////////////////////////////////////");

			option = scan.nextLine();

			if (option.equals("1")) {

				// SQL PARA SACAR EL LIBRO CON SU AUTOR Y LA EDITORIAL EN LA QUE SE ENCUENTRA
				// PUBLICADO
				List<Libro> consulta1 = em.createQuery("from Libro l").getResultList();
				for (Libro l : consulta1) {
					System.out.println("El libro: " + l.getTitulo() + " tiene como autor a: " + l.getAutor().getNombre()
							+ " " + l.getAutor().getApellidos() + " y se encuentra publicado en la editorial: "
							+ l.getEditorial().getNombre());
				}
			} else if (option.equals("2")) {

				// COMANDO PARA OBTENER LOS AUTORES CON LOS LIBROS QUE CADA UNO HA ESCRITO
				List<Autor> consulta2 = em.createQuery("from Autor a").getResultList();
				for (Autor a : consulta2) {
					System.out.println("El autor: " + a.getNombre() + " " + a.getApellidos()
							+ " ha escrito los siguientes libros: ");

					for (Libro aux : a.getLibros()) {
						System.out.println("- " + aux.getTitulo());
					}
				}
			} else if (option.contentEquals("3")) {

				// COMANDO PARA OBTENER LAS LIBRERIAS CON SUS LIBROS ASOCIADOS
				List<Libreria> consulta3 = em.createQuery("from Libreria lr").getResultList();
				for (Libreria lr : consulta3) {
					System.out.println("La libreria: " + lr.getNombre() + " tiene disponibles los libros: ");
					for (Libro aux : lr.getLibros()) {
						System.out.println("- " + aux.getTitulo());
					}
				}
			} else if (option.equals("4")) {

				// COMANDO PARA OBTENER LOS LIBROS DADOS DE ALTA Y LA LIBRERIA EN LA QUE LOS
				// PODEMOS ENCONTRAR
				List<Libro> consulta4 = em.createQuery("from Libro l").getResultList();
				for (Libro l : consulta4) {
					System.out.println("El libro: " + l.getTitulo() + " se puede encontrar en la/s libreria/s: ");
					for (Libreria aux : l.getLibrerias()) {
						System.out.println("- " + aux.getNombre());
					}
				}
			} else if (!option.equals("5")) {
				System.out.println("Usted ha marcado una opción incorrecta, por favor, marque una opcion valida.");
			}
		} while (!option.equals("5"));

		if (option.equals("5")) {
			System.out.println("Se va a cerrar el programa...");
			scan.close();

		}

		em.close();
		emf.close();
	}

}
