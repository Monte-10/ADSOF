package embarcaciones;

/**
 * Esta clase representa a una embarcación.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */
public abstract class Embarcacion {
	public static final double COSTE_BASE = 5.0;
	private String nombre;
	private int    capacidad;
	private double dimensiones;

	/**
	 * Constructor de la clase Embarcacion
	 * Crear una embarcacion con un nombre, capacidad y dimensiones
	 * 
	 * @param nombre Nombre de la embarcacion
	 * @param capacidad Capacidad de la embarcacion
	 * @param dimensiones Dimensiones de la embarcacion
	 */
	public Embarcacion (String nombre, int capacidad, double dimensiones) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.dimensiones = dimensiones;	
	}

	/**
	 * Método que devuelve la información de la embarcación
	 * 
	 * @return String con la información de la embarcación
	 */
	@Override public String toString() {		
		return this.nombre + ", capacidad: " + this.capacidad+ ", dimensiones " +this.dimensiones;
	}

	/**
	 * Método que devuelve el coste de la embarcación
	 * 
	 * @return Coste de la embarcación
	 */
	public double getCoste() {
		return Embarcacion.COSTE_BASE+this.dimensiones+this.capacidad;
	}
}