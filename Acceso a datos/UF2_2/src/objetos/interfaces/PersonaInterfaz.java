/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos.interfaces;

import java.util.ArrayList;
import uf2_2.Persona;

/**
 *
 * @author Laura
 */
public interface PersonaInterfaz {
    boolean alta(Persona p);
    boolean baja(int id);
    Persona obtener(int id);
    int obtenerId();
    ArrayList<Persona> listar();
    boolean altaEnCoche(int id, int fk);
    boolean bajaEnCoche(int id);
    ArrayList<Persona> listarEnCoche(int fk);

}
