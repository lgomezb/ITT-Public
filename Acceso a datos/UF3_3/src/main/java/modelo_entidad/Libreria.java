/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_entidad;

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

    @ManyToMany(cascade = CascadeType.PERSIST)
    //tabla de union Many to Many
    @JoinTable(name = "librerias_libros",
            joinColumns = {
                @JoinColumn(name = "fk_id_libreria", referencedColumnName = "id")}, //FK que aporta Libreria
            inverseJoinColumns = {
                @JoinColumn(name = "fk_id_libro", referencedColumnName = "id")}) //FKs que aportan el resto de entidades
    private List<Libro> libros;

    //This is not valid, only one side can be the owner of the relationship. 
    //Therefore, specify a mappedBy value only on the non-owning side of the relationship.
    public Libreria() {
        super();
    }

    public Libreria(Integer id, String nombre, String dueño, Direccion direccion, List<Libro> libros) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.dueño = dueño;
        this.direccion = direccion;
        this.libros = libros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
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

}
