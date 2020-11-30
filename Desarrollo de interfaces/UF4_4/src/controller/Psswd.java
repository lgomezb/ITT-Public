package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Window;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JButton;

public class Psswd extends JFrame {

	private JPanel WindowPsswd;
	private JPasswordField passwordField;
	private JButton continuar;
	private Window window;
	private double nb1;
	
	/**
	 * Create the frame.
	 */
	public Psswd(Window window, double nb1) {
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 380, 200);
		setLocationRelativeTo(null);
		WindowPsswd = new JPanel();
		WindowPsswd.setBackground(new Color(255, 255, 240));
		WindowPsswd.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(WindowPsswd);
		WindowPsswd.setLayout(null);
		
		setPasswordField(new JPasswordField());
		getPasswordField().setBackground(new Color(192, 192, 192));
		getPasswordField().setEchoChar('*');
		getPasswordField().setHorizontalAlignment(SwingConstants.CENTER);
		getPasswordField().setBounds(65, 87, 234, 34);
		WindowPsswd.add(getPasswordField());
		
		JLabel One = new JLabel("Introduzca la contrase\u00F1a ");
		One.setFont(new Font("Cooper Black", Font.PLAIN, 16));
		One.setHorizontalAlignment(SwingConstants.CENTER);
		One.setBounds(42, 23, 274, 34);
		WindowPsswd.add(One);
		
		JLabel Two = new JLabel("para realizar la acci\u00F3n");
		Two.setHorizontalAlignment(SwingConstants.CENTER);
		Two.setFont(new Font("Cooper Black", Font.PLAIN, 16));
		Two.setBounds(40, 54, 274, 34);
		WindowPsswd.add(Two);
		
		continuar = new JButton("Continuar");
		continuar.setBounds(137, 127, 89, 23);
		WindowPsswd.add(continuar);
		
		
		this.window = window;
		this.nb1 = nb1;
		initComponents();

	}
	
	public void initComponents() {
		continuar.addMouseListener(new MouseListener() {
			double aux1 = 0;
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(passwordField.getText().equals("calculadora")) {
					aux1 = Math.cbrt(nb1);
					window.getResult().setText("El resultado es: " + aux1);	
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}


	public JPasswordField getPasswordField() {
		return passwordField;
	}


	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
}
