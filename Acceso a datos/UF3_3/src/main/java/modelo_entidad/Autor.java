/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_entidad;

import java.util.Date;
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

@Entity

@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    @Temporal(TemporalType.DATE)
    private Date fecha_nac;

    //El atributo autor de la clase Libro es por el que se mapea
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;

    //The attribute [libros] in entity class [class modelo.entidad.Autor] 
    //has a mappedBy value of [autores] 
    //which does not exist in its owning entity class [class modelo.entidad.Libro]. 
    //If the owning entity class is a @MappedSuperclass, 
    //this is invalid, and your attribute should reference the correct subclass.
    public Autor() {
    }

    public Autor(Integer id, String nombre, String apellidos, List<Libro> libros) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.libros = libros;
    }

    public Autor(int id, String nombre, String apellidos, List<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.libros = libros;
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

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}