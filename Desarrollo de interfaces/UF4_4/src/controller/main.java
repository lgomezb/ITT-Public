package controller;

import java.awt.EventQueue;

import view.Window;

public class main {

	public static void main(String[] args) { //método principal
		
		Window myWindow = new Window();		//Crea un objeto Window para poder trabajar con él
		EventsManager manager = new EventsManager(myWindow);//Crea un nuevo objeto EventsManager para poder trabajar con él
		myWindow.stablishManager(manager); // Inicializ2  la funcion stablishManager que se encuentra dentro de la clase myWindow pasando por parametro el objeto manager

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		

	}

}
