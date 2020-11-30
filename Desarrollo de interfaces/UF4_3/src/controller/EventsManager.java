package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Window;

/**
 * Clase EventsManager que implementa el método ActionListener de la biblioteca java swing.
 * Contiene el objeto Window
 * @author Laura
 *
 */
public class EventsManager implements ActionListener{
	
	private Window window;
	
	public EventsManager(Window window) { //Creamos el constructor de la clase
		
		this.window = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //Método que se ejecuta
		
		//Creamos variables para almacenar los número que se introducen y el resultado de estos
		float aux = 0;	
		float nb1 = 0;
		float nb2 = 0;
		
		try {
			nb1 = Float.parseFloat(window.getBoxOne().getText());
			nb2 = Float.parseFloat(window.getBoxTwo().getText());;

			
		}
		catch(Exception exc){ //Gestionamos los posibles errores que puedan surgir con 
			JOptionPane.showMessageDialog(null, "Introduce dos números", "Error", JOptionPane.WARNING_MESSAGE);
		}
		
		//Como para dar un resultado se debe pulsar un botón tenemos este if, cada uno con la fórmula matemática que debe implementar
		if(e.getSource() == window.getAddition()) {
			aux = nb1 + nb2;
			window.getResult().setText("El resultado es: " + aux);
		}
		
		//Como para dar un resultado se debe pulsar un botón tenemos este if, cada uno con la fórmula matemática que debe implementar
		if(e.getSource() == window.getAddition()) {
			aux = nb1 + nb2;
		}
		
		else if(e.getSource() == window.getSubtraction()) {
			aux = nb1 - nb2;
		}
		
		else if(e.getSource() == window.getMultiplication()) {
			aux = nb1 * nb2;
		}
		
		else if(e.getSource() == window.getDivision()) {
			aux = nb1 / nb2;
		}
		
		//Imprimimos en la etiqueta result nuestro resultado
		window.getResult().setText("El resultado es: " + aux);
	}
	
}


