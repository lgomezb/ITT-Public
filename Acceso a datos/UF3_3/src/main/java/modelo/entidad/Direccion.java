package modelo.entidad;

import javax.persistence.Embeddable;

/*
 * @author Laura Gomez
 * @author Pilar Lobon
 */

/*
 * Entidad embebida en la entidad Editorial y la entidad Libreria
 */
@Embeddable
public class Direccion {
	private String tipoVia;
	private String nombreVia;
	private String ciudad;
	
	public Direccion() {
		
	}
	
	/**
	 * Metodo que establece el String Tipo de via de la direccion
	 * @param tipoVia
	 */
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	/**
	 * Metodo que establece que String nombre de 
	 * la vida de la direccion
	 * @param nombreVia
	 */
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	/**
	 * Metodo que establece el String ciudad de la direccion
	 * @param ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	

	
	
	
}
