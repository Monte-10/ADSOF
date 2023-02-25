package embarcaciones;

/**
 * Esta clase representa a un velero, que es una embarcación de recreo.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */
public class Velero extends Embarcacion {
	private int numMastil;
	private double longMastil;
	
	/**
	 * Constructor de la clase Velero
	 * Crear un velero con un nombre, capacidad, dimensiones, longitud del mastil y número de mastiles
	 * 
	 * @param nombre Nombre del velero
	 * @param capacidad Capacidad del velero
	 * @param dimensiones Dimensiones del velero
	 * @param longMastil Longitud del mastil del velero
	 * @param numMastil Número de mastiles del velero
	 */
	public Velero (String nombre, int capacidad, double dimensiones, 
								  double longMastil, int numMastil) {
		super(nombre, capacidad, dimensiones);
		this.longMastil = longMastil;
		this.numMastil = numMastil;
	}
	
	/**
	 * Método que devuelve la longitud del mastil del velero más el número de mastiles y la información de la clase padre
	 * 
	 * @return String con la información del velero
	 */
	@Override 
	public String toString() {
		return "Velero: "+super.toString() + numMastil + " mastiles, de " + longMastil;
	}
	
	/**
	 * Método que devuelve el coste del velero más la información de la clase padre
	 * 
	 * @return Coste del velero
	 */
	@Override 
	public double getCoste() {
		return super.getCoste()+ (this.numMastil*this.longMastil);
	}
}