/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos.interfaces;

import java.util.ArrayList;
import objetos.CocheDao;
import uf2_2.Coche;

/**
 *
 * @author Laura
 */
public interface CocheInterfaz {
	boolean alta(Coche coche);
	boolean baja(int id);
	Coche modificar(int id, Coche coche);
	Coche obtener(int id);
        int obtenerId();
	ArrayList<Coche> listar();
}