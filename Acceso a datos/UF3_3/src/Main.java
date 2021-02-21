
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo_entidad.Autor;
import modelo_entidad.Direccion;
import modelo_entidad.Editorial;
import modelo_entidad.Libreria;
import modelo_entidad.Libro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laura
 */
public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_libros");

        EntityManager em = null;

        Autor autor1 = new Autor(null, "George", "Orwell", null);
        autor1.setFecha_nac(new Date(1903 - 6 - 25));//fecha de hoy

        Autor autor2 = new Autor(null, "J.K", "Rowling", null);
        autor2.setFecha_nac(new Date(1965 - 06 - 31));

        Autor autor3 = new Autor(null, "Laura", "Gallego", null);
        autor3.setFecha_nac(new Date(1977 - 10 - 11));

        Autor autor4 = new Autor(null, "Mark", "Twain", null);
        autor4.setFecha_nac(new Date(1835 - 11 - 30));

        Autor autor5 = new Autor(null, "Virginia", "Woolf", null);
        autor5.setFecha_nac(new Date(1882 - 1 - 25));

        Editorial e1 = new Editorial(null, "Alfaguara", null);
        Editorial e2 = new Editorial(null, "Tauro", null);
        Editorial e3 = new Editorial(null, "El barco de Vapor", null);

        Direccion d1 = new Direccion();
        Direccion d2 = new Direccion();
        Direccion d3 = new Direccion();

        d1.setTipoVia("Avenida");
        d1.setNombreVia("de America");
        d1.setCiudad("Valencia");

        d2.setTipoVia("Calle");
        d2.setNombreVia("del Tornillo Suelto");
        d2.setCiudad("Albacete");

        d3.setTipoVia("Via");
        d3.setNombreVia("en honor a Laura y Pilar");
        d3.setCiudad("Barcelona");

        e1.setDireccion(d1);
        e2.setDireccion(d2);
        e3.setDireccion(d3);

        Libro l1 = new Libro(null, "1984", 14.95, null, null, null);
        l1.setEscritor(autor1);
        l1.setEditoriales(e3);

        Libro l2 = new Libro(null, "The Ickabog", 16.20, null, null, null);
        l2.setEscritor(autor2);
        l2.setEditoriales(e1);

        Libro l3 = new Libro(null, "Orlando", 22.00, null, null, null);
        l3.setEscritor(autor5);
        l3.setEditoriales(e2);

        Libro l4 = new Libro(null, "Las aventuras de Tom Sawyer", 32.45, null, null, null);
        l4.setEscritor(autor4);
        l4.setEditoriales(e2);

        Libro l5 = new Libro(null, "Donde los arboles cantan", 12.99, null, null, null);
        l5.setEscritor(autor3);
        l5.setEditoriales(e1);

        Libro l6 = new Libro(null, "Cronicas de la Torre", 30.25, null, null, null);
        l6.setEscritor(autor3);
        l6.setEditoriales(e1);

        Libro l7 = new Libro(null, "Traicion", 20, null, null, null);
        Libro l8 = new Libro(null, "Perfeccion", 7.88, null, null, null);
        Libro l9 = new Libro(null, "Cumbres Borrascosas", 9.99, null, null, null);
        Libro l10 = new Libro(null, "Memorias de Idhun", 10.88, null, null, null);
        Libro l11 = new Libro(null, "El pasado nunca vuelve", 8.99, null, null, null);
        Libro l12 = new Libro(null, "Espionaje", 9.99, null, null, null);

        l7.setEditoriales(e1);
        l8.setEditoriales(e2);
        l9.setEditoriales(e3);
        l10.setEditoriales(e1);
        l11.setEditoriales(e2);
        l12.setEditoriales(e3);

        l7.setEscritor(autor1);
        l8.setEscritor(autor2);
        l9.setEscritor(autor3);
        l10.setEscritor(autor4);
        l11.setEscritor(autor5);
        l12.setEscritor(autor1);

        Libreria libreria1 = new Libreria(null, "Lapiceros", "Milagros", null, null);
        Direccion d4 = new Direccion();
        d4.setTipoVia("Paseo");
        d4.setNombreVia("de la Pantera Rosa");
        d4.setCiudad("Murcia");
        libreria1.setDireccion(d4);
        List<Libro> lista_libro1 = new ArrayList<Libro>();
        lista_libro1.add(l1);
        lista_libro1.add(l2);
        lista_libro1.add(l3);
        lista_libro1.add(l4);
        lista_libro1.add(l5);
        lista_libro1.add(l6);
        libreria1.setLibros(lista_libro1);
        
        Libreria libreria2 = new Libreria (null, "MilesdeLibros","Juan Perez",null,null);

        Direccion d5 = new Direccion();
        d5.setTipoVia("Urbanizacion");
        d5.setNombreVia("MataBlanca");
        d5.setCiudad("Segovia");

        libreria2.setDireccion(d5);
        List<Libro> lista_libro2 = new ArrayList<Libro>();
        lista_libro2.add(l7);
        lista_libro2.add(l8);
        lista_libro2.add(l9);
        lista_libro2.add(l10);
        lista_libro2.add(l11);
        lista_libro2.add(l12);
        libreria2.setLibros(lista_libro2);

        System.out.println("==============================================");
        em = emf.createEntityManager();
        em.getTransaction().begin();

        //salvamos y observamos como la direccion se ha guardado
        //dentro de la tabla clientes(ya que direccion esta embebida)
        em.persist(autor1);
        em.persist(autor2);
        em.persist(autor3);
        em.persist(autor4);
        em.persist(autor5);
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);

        em.getTransaction().commit();
        em.close();

        emf.close();
    }
}
