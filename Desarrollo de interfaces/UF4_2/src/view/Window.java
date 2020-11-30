package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.EventsManager;
/**
 * 
 * Window contiene etiquetas,campos de texto y botones; todos ellos privados
 * @author Laura
 */
public class Window extends JFrame {

	private JLabel numberOne, numberTwo, result;
	private JTextField boxOne, boxTwo;
	private JButton addition, subtraction, multiplication, division;

	public Window() {
		setSize(500,400); //Establecemos el ancho(500px) y el alto(400px) de la ventana
		setLocationRelativeTo(null); //Establecemos el lugar donde aparecerá (null->centro de la pantalla)
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Al cerrar la ventana cierra el programa
		setResizable(false); //Hace que la ventana no se pueda hacer más grande/pequeña
		setTitle("Calculadora"); //Añadimos un nombre/título a la ventana
		setLayout(null); //Informamos de que no tiene Layouts
		initComponents(); //Inicializamos la función initComponents
		setVisible(true); //Hacemos la ventana visible
	}

	private void initComponents() {
		//Creamos una etiqueta llamada numberOne que va a hacer que ponga "Número 1: " en el lugar que corresponda
		numberOne = new JLabel("Número 1: ");
		numberOne.setBounds(80, 30, 90, 30); //Establecemos los parámetros (px de inicio eje x, px de inicio eje y, ancho, alto)
		add(numberOne); //Añadimos a la ventana
		
		numberTwo = new JLabel("Número 2: ");
		numberTwo.setBounds(80, 70, 90, 30);
		add(numberTwo);
		
		boxOne = new JTextField(); //Creamos un campo de texto
		boxOne.setBounds(210,30,110,30);
		add(boxOne);
		
		boxTwo = new JTextField();
		boxTwo.setBounds(210,70,110,30);
		add(boxTwo);
		
		addition = new JButton("Sumar"); //Creamos un botón
		addition.setBounds(80, 135, 110, 60);
		add(addition);
		
		subtraction = new JButton("Restar");
		subtraction.setBounds(220,135,110,60);
		add(subtraction);
		
		multiplication = new JButton("Multiplicar");
		multiplication.setBounds(80, 210, 110, 60);
		add(multiplication);
		
		division = new JButton("Dividir");
		division.setBounds(220, 210, 110, 60);
		add(division);
		
		result = new JLabel("El resultado es: ");
		result.setBounds(100, 285, 150, 30);
		add(result);
	}

	public void stablishManager(EventsManager manager) { //método manejador de eventos
		addition.addActionListener(manager); //Se pone a la escucha de clickar sobre el botón addition
		subtraction.addActionListener(manager); //Se pone a la escucha de clickar sobre el botón subtraction
		multiplication.addActionListener(manager); //Se pone a la escucha de clickar sobre el botón multiplication
		division.addActionListener(manager); //Se pone a la escucha de clickar sobre el botón division
	}
	/**
	 *Método que retorna la caja de texto boxOne
	 *
	 * @return boxOne
	 */
	public JTextField getBoxOne() {
		return boxOne;
	}
	
	/**
	 * Método que retorna la caja de texto boxTwo
	 * 
	 * @return boxTwo
	 */
	public JTextField getBoxTwo() {
		return boxTwo;
	}
	
	/**
	 * Método que retorna el botón addition
	 * 
	 * @return addition
	 */
	public JButton getAddition() {
		return addition;
	}
	
	/**
	 * Método que retorna el botón subtraction
	 * 
	 * @return subtraction
	 */
	public JButton getSubtraction() {
		return subtraction;
	}

	/**
	 * Método que retorna el botón multiplication
	 * 
	 * @return multiplication
	 */
	public JButton getMultiplication() {
		return multiplication;
	}

	/**
	 * Método que retorna el botón division
	 * 
	 * @return division
	 */
	public JButton getDivision() {
		return division;
	}
	
	/**
	 * Método que retorna la etiqueta result
	 * 
	 * @return result
	 */
	public JLabel getResult() {
		return result;
	}
}


