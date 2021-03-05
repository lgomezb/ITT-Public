/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf2_2;

/**
 * Clase que permite almacemar la informacion de un coche y que puede ser
 * serializable
 *
 * @author Laura
 */
public class Persona {

    private int id = 0;
    private String nombre = null;
    private int edad;
    private float peso;
    private int fk = 0;

    /**
     * Constructor de la clase Persona
     *
     * @param identificador numerico de la persona
     * @param nombre String que almacena el nombre de la persona
     * @param edad Int que almacenala edad de la persona
     * @param peso Float que almacena el peso de la persona
     * @param fk Int que almacena a que coche se encuentra asignada la persona
     */
    public Persona(int id, String nombre, int edad, float peso, int fk) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.fk = fk;
    }

    /**
     * Método que retorna el fk de la persona
     *
     * @return el int fk
     */
    public int getFk() {
        return fk;
    }
/**
 * 
 * @param fk 
 */
    public void setFk(int fk) {
        this.fk = fk;
    }

    /**
     * Constructor de la Persona vacio
     */
    public Persona() {

    }

    /**
     * Método que retorna el id de la persona
     *
     * @return el int id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que retorna el nombre de la persona
     *
     * @return el String nombre
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que retorna la edad de la persona
     *
     * @return el int Edad
     */
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Método que retorna el peso de la persona
     *
     * @return el float peso
     */
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
