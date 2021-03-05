
package uf2_2;

import java.io.Serializable;

/**
 * Clase que permite almacenar la informacion de un coche y que puede ser serializable
 * @author Laura
 */
public class Coche{
    private int id = 0;
    private String matricula = null;
    private String marca = null;
    private String modelo = null;
    private String color = null;
    
    /**
     * Constructor de la clase coche
     * @param id identificador numerico del coche
     * @param matricula String que almacena la matricula del coche
     * @param marca String que almacena la marca del coche
     * @param modelo String que almacena el modelo del coche
     * @param color  String que almacena el color del coche
     */
    public Coche(int id, String matricula, String marca, String modelo, String color) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }    
    
    /**
     * Constructor del coche vacio
     */
    public Coche() {
        
    }

    /**
     * Método que retorna el id del coche
     * @return el int id
     */
    public int getId() {
        return id;
    }

    /**
     * Método que establece el id del coche
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que retorna la matricula del coche
     * @return la String matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Método que establece la matricula del coche
     * @param matricula 
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Método que retorna la Marca del coche
     * @return la String Marca
     */
    public String getMarca() {
        return marca;
    }
    
    /**
     * Método que establece la Marca del coche
     * @param marca 
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método que retorna el Modelo del coche
     * @return la String modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método que establece el Modelo del coche
     * @param modelo 
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Método que retorna el Color del coche
     * @return la String color
     */
    public String getColor() {
        return color;
    }

    /**
     * Método que establece el Color del coche
     * @param color 
     */
    public void setColor(String color) {
        this.color = color;
    }
}
