package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.EventsManager;
import controller.Psswd;
/**
 * 
 * Window contiene etiquetas,campos de texto y botones; todos ellos privados
 * @author Laura
 */
public class Window extends JFrame {

	private JLabel numberOne, numberTwo, result, image, light, lighton;
	private JTextField boxOne, boxTwo;
	private JButton addition, subtraction, multiplication, division, sqRoot, cbRoot;
	private boolean clickeda = false;
	private boolean clickeds = false;
	private boolean clickedm = false;
	private boolean clickedd = false;
	private boolean clickedq = false;
	private boolean clickedc = false;



	public Window() {
		setSize(500,550); 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 
		setTitle("Calculadora"); 
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/currency-calculator.png")); //AÒadimos el icono de la ventana
		setLayout(null);
		initComponents();
		setVisible(true);
		
	}
	/**
	 * Funcion que elimina el color a los botones (Fondo y Color de letra)
	 */
	public void colorsToNull() { 
		addition.setBackground(null); 
		addition.setForeground(Color.BLACK); 
		subtraction.setBackground(null);
		subtraction.setForeground(Color.BLACK);
		multiplication.setBackground(null);
		multiplication.setForeground(Color.BLACK);
		division.setBackground(null);
		division.setForeground(Color.BLACK);
		
	}


	private void initComponents() {
		getContentPane().setBackground(Color.BLACK);
		
		////LABELS & TEXTFILES////
		numberOne = new JLabel("Numero 1: ");
		numberOne.setBounds(80, 30, 90, 30); 
		numberOne.setFont(new Font("Cooper Black", Font.PLAIN, 16)); // .setFont Establecer la fuente de la caja. 1.Tipo de letra, 2.Estilo de letra, 3.Tama√±o de letra
		numberOne.setForeground(Color.BLACK); // .setForeground Metodo que da color a las letras
		add(numberOne); 

		numberTwo = new JLabel("Numero 2: ");
		numberTwo.setBounds(80, 70, 90, 30);
		numberTwo.setForeground(Color.BLACK);
		add(numberTwo);
		
		boxOne = new JTextField(); 
		boxOne.setBounds(210,30,110,30);
		boxOne.setFont(new Font("Cooper Black", Font.PLAIN, 16));
		boxOne.setBackground(Color.BLACK);  // .setBackground Metodo que cambia el fondo
		boxOne.setForeground(getBackground());
		boxOne.setBorder(null); // .setBorder Metodo que establece los bordes del componente
		add(boxOne);
		
		boxTwo = new JTextField();
		boxTwo.setBounds(210,70,110,30);
		boxTwo.setFont(new Font("Cooper Black", Font.PLAIN, 16));
		boxTwo.setBackground(Color.BLACK);
		boxTwo.setForeground(getBackground());
		boxTwo.setBorder(null);
		add(boxTwo);
		
		result = new JLabel("El resultado es: ");
		result.setBounds(30, 450, 350, 30);
		result.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		result.setForeground(Color.BLACK);
		add(result);
		
		image = new JLabel(new ImageIcon("src/judy1.png"));
		image.setBounds(200,250,400,300);
		image.setVisible(false);
		add(image);
		
		light = new JLabel(new ImageIcon("src/bombilla.png"));
		light.setBounds(400,0,100,100);
		add(light);
		
		lighton = new JLabel(new ImageIcon("src/bombilla (1).png"));
		lighton.setBounds(400,0,100,100);


		
		/////////////ADDITION/////////
		addition = new JButton("Sumar"); 
		addition.setBounds(80, 135, 110, 60);
		addition.setFont(new Font("Cooper Black", Font.PLAIN, 12)); 
		addition.setForeground(Color.BLACK);
		addition.setBackground(getForeground());
		addition.setBorder(null);
		add(addition);
		
		
		///////SUBTRACTION////////
		subtraction = new JButton("Restar");
		subtraction.setBounds(200,135,110,60);
		subtraction.setBorder(null);
		subtraction.setFont(new Font("Cooper Black", Font.PLAIN, 12)); 
		subtraction.setForeground(Color.BLACK);
		subtraction.setBackground(getForeground());
		add(subtraction);


		///////MULTIPLICATION////////
		multiplication = new JButton("Multiplicar");
		multiplication.setBounds(80, 210, 110, 60);
		multiplication.setFont(new Font("Cooper Black", Font.PLAIN, 12)); 
		multiplication.setForeground(Color.BLACK);
		multiplication.setBackground(getForeground());
		multiplication.setBorder(null);
		add(multiplication);
		

		
		/////////DIVISION/////////
		division = new JButton("Dividir");
		division.setBounds(200, 210, 110, 60);
		division.setFont(new Font("Cooper Black", Font.PLAIN, 12)); 
		division.setForeground(Color.BLACK);
		division.setBackground(null);
		division.setBorder(null);
		add(division);
		
		/////////SQROOT/////////
		sqRoot = new JButton("Raiz Cuadrada");
		sqRoot.setBounds(80, 285, 220, 60);
		sqRoot.setFont(new Font("Cooper Black", Font.PLAIN, 12)); 
		sqRoot.setForeground(Color.BLACK);
		sqRoot.setBackground(null);
		sqRoot.setBorder(null);
		add(sqRoot);
		
		////CBROOT////
		cbRoot = new JButton ("Raiz Cubica");
		cbRoot.setBounds(80, 360, 220, 60);
		cbRoot.setFont(new Font("Cooper Black", Font.PLAIN, 12)); 
		cbRoot.setForeground(Color.BLACK);
		cbRoot.setBackground(null);
		cbRoot.setBorder(null);
		add(cbRoot);
		
	
		/**
		 * Metodo que se pone a la espera de acciones realizadas por el cursor del raton
		 */
		light.addMouseListener(new MouseListener() {

			/**
			 * Se invoca cuando el raton clica sobre el objeto JLabel light
			 */
			@Override
			public void mouseClicked(MouseEvent e) { 
				////IMAGE////
				add(lighton);
				remove(light);
				/////FRAME////
				getContentPane().setBackground(new Color(149, 125, 173));
				/////ADDITION////
				addition.addMouseListener(new MouseListener() {
					/**
					 * Se invoca cuando el raton clica sobre el objeto JButton addition
					 */
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(!clickeda) {
							clickeda = true;
							clickeds = false;
							clickedm = false;
							clickedd = false;
							clickedq = false;
							clickedc = false;
							colorsToNull();
							addition.setForeground(new Color(178, 88, 4));
							addition.setBackground(new Color(250, 217, 215));
							getContentPane().setBackground(new Color(149, 125, 173));
							
						}
						else {
							clickeda = false;
							
						}

						
					}
					/**
					 *  Se invoca cuando el puntero se posiciona sobre el boton Addition
					 */
					@Override
					public void mouseEntered(MouseEvent e) {
						if(!clickeda) {
							addition.setForeground(new Color(178, 88, 4));
							addition.setBackground(new Color(250, 217, 215));
						}

					}
					/**
					 *  Se invoca cuando el puntero se posiciona fuera de el boton Addition 
					 */
					@Override
					public void mouseExited(MouseEvent e) {
						if(!clickeda) {
						addition.setBackground(null);
						addition.setForeground(Color.BLACK);								
						}
					}
					/**
					 * Se invoca cuando el raton se mantiene presionado el boton addition
					 */
					@Override
					public void mousePressed(MouseEvent e) {				
					}
					/**
					 * Se invoca cuando se suelta despuos de haber mantenido pulsado el boton addition
					 */
					@Override
					public void mouseReleased(MouseEvent e) {				
					} 
					
				});
				////SUBTRACTION////
				subtraction.addMouseListener(new MouseListener() {
					/**
					 *  Se invoca cuando el puntero se posiciona sobre el boton subtraction
					 */
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(!clickeds) {
							clickeda = false;
							clickeds = true;
							clickedm = false;
							clickedd = false;
							clickedq = false;
							clickedc = false;
							colorsToNull();
							subtraction.setBackground(new Color(193, 227, 254));
							subtraction.setForeground(new Color(40, 55, 71));
							getContentPane().setBackground(new Color(149, 125, 173));
						}
						else {
							clickeds = false;
						}
						
					}
					/**
                     *  Se invoca cuando el puntero se posiciona sobre el boton subtraction
                     */
					@Override
					public void mouseEntered(MouseEvent arg0) {	
						if(!clickeds) {
							subtraction.setBackground(new Color(193, 227, 254));
							subtraction.setForeground(new Color(40, 55, 71));
						}
					}
					/**
                     *  Se invoca cuando el puntero se posiciona fuera de el boton subtraction 
                     */
					@Override
					public void mouseExited(MouseEvent arg0) {	
						if(!clickeds) {
							subtraction.setBackground(null);
							subtraction.setForeground(Color.BLACK);	
						}
					}
					/**
                     * Se invoca cuando el raton se mantiene presionado el boton subtraction
                     */
					@Override
					public void mousePressed(MouseEvent arg0) {						
					}
					/**
                     * Se invoca cuando se suelta despuos de haber mantenido pulsado el boton subtraction
                     */
					@Override
					public void mouseReleased(MouseEvent arg0) {						
					}
					
				});
				////MULTIPLICATION////
				multiplication.addMouseListener(new MouseListener() {
					/**
					 *  Se invoca cuando el puntero se posiciona sobre el boton Multiplication
					 */
					@Override
					public void mouseClicked(MouseEvent e) {
						if(!clickedm) {
							clickeda = false;
							clickeds = false;
							clickedm = true;
							clickedd = false;
							clickedq = false;
							clickedc = false;
							colorsToNull();
							multiplication.setBackground(new Color(247, 238, 207));							
							multiplication.setForeground(new Color(164, 138, 85));
							getContentPane().setBackground(new Color(149, 125, 173));
						}
						else {
							clickedm = false;
						}

					}
					/**
                     *  Se invoca cuando el puntero se posiciona sobre el boton Multiplication
                     */
					@Override
					public void mouseEntered(MouseEvent e) {
						if(!clickedm) {
							multiplication.setBackground(new Color(247, 238, 207));
							multiplication.setForeground(new Color(164, 138, 85));
							getContentPane().setBackground(new Color(149, 125, 173));
						}
					}
					/**
                     *  Se invoca cuando el puntero se posiciona fuera de el boton Multiplication 
                     */
					@Override
					public void mouseExited(MouseEvent e) {
						if(!clickedm) {
							multiplication.setBackground(null);
							multiplication.setForeground(Color.BLACK);
						}
					}
					/**
                     * Se invoca cuando el raton se mantiene presionado el boton multiplication
                     */
					@Override
					public void mousePressed(MouseEvent e) {
						
					}
					/**
                     * Se invoca cuando se suelta despuos de haber mantenido pulsado el boton multiplication
                     */
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				////DIVISION////
				division.addMouseListener(new MouseListener() {
					/**
					 *  Se invoca cuando el puntero se posiciona sobre el boton Division
					 */
					@Override
					public void mouseClicked(MouseEvent e) {
						if(!clickedd) {
							clickeda = false;
							clickeds = false;
							clickedm = false;
							clickedd = true;
							clickedq = false;
							clickedc = false;
							colorsToNull();
							division.setBackground(new Color(201, 222, 206));
							division.setForeground(new Color(40, 71, 51));
						}
						else {
							clickedd = false;
						}
					}
					/**
                     *  Se invoca cuando el puntero se posiciona sobre el boton division
                     */
					@Override
					public void mouseEntered(MouseEvent e) {
						if(!clickedd) {
							division.setBackground(new Color(201, 222, 206));
							division.setForeground(new Color(40, 71, 51));	
						}
					}
					/**
                     *  Se invoca cuando el puntero se posiciona fuera de el boton Division 
                     */
					@Override
					public void mouseExited(MouseEvent e) {
						if(!clickedd) {
							division.setBackground(null);
							division.setForeground(Color.BLACK);
						}

						
					}
					/**
                     * Se invoca cuando el raton se mantiene presionado el boton Division
                     */
					@Override
					public void mousePressed(MouseEvent e) {
						
					}
					/**
                     * Se invoca cuando se suelta despuos de haber mantenido pulsado el boton division
                     */
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
					
				////SQROOT////
				sqRoot.addMouseListener(new MouseListener() {
					/**
					 *  Se invoca cuando el puntero se posiciona sobre el boton Division
					 */
					@Override
					public void mouseClicked(MouseEvent e) {
						if(!clickedd) {
							clickeda = false;
							clickeds = false;
							clickedm = false;
							clickedd = false;
							clickedq = true;
							clickedc = false;
							colorsToNull();
							sqRoot.setBackground(new Color(244, 143, 177));
							sqRoot.setForeground(new Color(233, 30, 99));
							JOptionPane.showMessageDialog(null, "Funcionalidad no disponible", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/katie1.gif"));
						}
						else {
							clickedq = false;
						}
					}
					/**
                     *  Se invoca cuando el puntero se posiciona sobre el boton division
                     */
					@Override
					public void mouseEntered(MouseEvent e) {
						if(!clickedd) {
							sqRoot.setBackground(new Color(244, 143, 177));
							sqRoot.setForeground(new Color(233, 30, 99));
						}
					}
					/**
                     *  Se invoca cuando el puntero se posiciona fuera de el boton Division 
                     */
					@Override
					public void mouseExited(MouseEvent e) {
						if(!clickedd) {
							sqRoot.setBackground(null);
							sqRoot.setForeground(Color.BLACK);
						}

						
					}
					/**
                     * Se invoca cuando el raton se mantiene presionado el boton Division
                     */
					@Override
					public void mousePressed(MouseEvent e) {
						
					}
					/**
                     * Se invoca cuando se suelta despuos de haber mantenido pulsado el boton division
                     */
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				////CBROOT////
				cbRoot.addMouseListener(new MouseListener() {
					/**
					 *  Se invoca cuando el puntero se posiciona sobre el boton Division
					 */
					@Override
					public void mouseClicked(MouseEvent e) {
						if(!clickedd) {
							clickeda = false;
							clickeds = false;
							clickedm = false;
							clickedd = false;
							clickedq = false;
							clickedc = true;
							colorsToNull();
							cbRoot.setBackground(new Color(238, 238, 238));
							cbRoot.setForeground(new Color(117, 117, 117));
						}
						else {
							clickedc = false;
						}
					}
					/**
                     *  Se invoca cuando el puntero se posiciona sobre el boton division
                     */
					@Override
					public void mouseEntered(MouseEvent e) {
						if(!clickedd) {
							cbRoot.setBackground(new Color(238, 238, 238));
							cbRoot.setForeground(new Color(117, 117, 117));
						}
					}
					/**
                     *  Se invoca cuando el puntero se posiciona fuera de el boton Division 
                     */
					@Override
					public void mouseExited(MouseEvent e) {
						if(!clickedd) {
							cbRoot.setBackground(null);
							cbRoot.setForeground(Color.BLACK);
						}

						
					}
					/**
                     * Se invoca cuando el raton se mantiene presionado el boton Division
                     */
					@Override
					public void mousePressed(MouseEvent e) {
						
					}
					/**
                     * Se invoca cuando se suelta despuos de haber mantenido pulsado el boton division
                     */
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				////IMAGE////
				image.setVisible(true);
				////LIGHT////
				light = new JLabel(new ImageIcon("src/bombilla(1).png"));
				
				////OTHERS////
				boxOne.setForeground(new Color(40, 55, 71));
				boxOne.setBackground(new Color(255, 165, 219));
				numberOne.setForeground(new Color(40, 55, 71)); 
				numberTwo.setFont(new Font("Cooper Black", Font.PLAIN, 16)); 
				numberTwo.setForeground(new Color(40, 55, 71));
				boxTwo.setForeground(new Color(40, 55, 71));
				boxTwo.setBackground(new Color(28, 217, 252));
				result.setForeground(new Color(40, 55, 71));


			}
			/**
             *  Se invoca cuando el puntero se posiciona sobre la etiqueta light
             */
			@Override
			public void mouseEntered(MouseEvent e) {				
			}
			/**
             *  Se invoca cuando el puntero se posiciona fuera de la etiqueta light 
             */
			@Override
			public void mouseExited(MouseEvent e) {				
			}
			/**
             * Se invoca cuando el raton se mantiene presionado la etiqueta light
             */
			@Override
			public void mousePressed(MouseEvent e) {				
			}
			/**
             * Se invoca cuando se suelta despuos de haber mantenido pulsado la etiqueta light
             */
			@Override
			public void mouseReleased(MouseEvent e) {
			}});
		}

	public void stablishManager(EventsManager manager) {
		addition.addActionListener(manager); 
		subtraction.addActionListener(manager);
		multiplication.addActionListener(manager);
		division.addActionListener(manager);
		cbRoot.addActionListener(manager);
	}
	/**
	 *Metodo que retorna la caja de texto boxOne
	 *
	 * @return boxOne
	 */
	public JTextField getBoxOne() {
		return boxOne;
	}
	
	/**
	 * Metodo que retorna la caja de texto boxTwo
	 * 
	 * @return boxTwo
	 */
	public JTextField getBoxTwo() {
		return boxTwo;
	}
	
	/**
	 * Metodo que retorna el boton addition
	 * 
	 * @return addition
	 */
	public JButton getAddition() {
		return addition;
	}
	
	/**
	 * Metodo que retorna el boton subtraction
	 * 
	 * @return subtraction
	 */
	public JButton getSubtraction() {
		return subtraction;
	}

	/**
	 * Metodo que retorna el boton multiplication
	 * 
	 * @return multiplication
	 */
	public JButton getMultiplication() {
		return multiplication;
	}

	/**
	 * Metodo que retorna el boton division
	 * 
	 * @return division
	 */
	public JButton getDivision() {
		return division;
	}
	
	/**
	 * Metodo que retorna la etiqueta result
	 * 
	 * @return result
	 */
	public JLabel getResult() {
		return result;
	}
	public JButton getSqRoot() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getCbRoot() {
		// TODO Auto-generated method stub
		return cbRoot;
	}
}


