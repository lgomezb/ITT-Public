/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_entidad;

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

    @ManyToMany(mappedBy = "libros", cascade = CascadeType.PERSIST) //Este cascade es una aberracion
    private List<Libreria> librerias;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_editorial", referencedColumnName = "id")
    private Editorial editoriales;

    public Libro() {

    }

    public Libro(Integer id, String titulo, double precio, Autor escritor, List<Libreria> librerias,
            Editorial editoriales) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.autor = escritor;
        this.librerias = librerias;
        this.editoriales = editoriales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Autor getEscritor() {
        return autor;
    }

    public void setEscritor(Autor escritor) {
        this.autor = escritor;
    }

    public List<Libreria> getLibrerias() {
        return librerias;
    }

    public void setLibrerias(List<Libreria> librerias) {
        this.librerias = librerias;
    }

    public Editorial getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(Editorial editoriales) {
        this.editoriales = editoriales;
    }

}
