package embarcaciones;

/**
 * Esta clase representa a una embarcación de motor, que es una embarcación de recreo.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */
public class EmbarcacionMotor extends Embarcacion {
	public static final double COSTE_MOTOR = 20.0;
	private int numMotores;
	private TipoMotor tipoMotor;
	
	/**
	 * Constructor de la clase EmbarcacionMotor
	 * Crear una embarcacion de motor con un nombre, capacidad, dimensiones, número de motores y tipo de motor
	 * 
	 * @param nombre Nombre de la embarcacion de motor
	 * @param capacidad Capacidad de la embarcacion de motor
	 * @param dimensiones Dimensiones de la embarcacion de motor
	 * @param numMotores Número de motores de la embarcacion de motor
	 * @param motor Tipo de motor de la embarcacion de motor
	 */
	public EmbarcacionMotor (String nombre, int capacidad, double dimensiones, 
								  int numMotores, TipoMotor motor) {
		super(nombre, capacidad, dimensiones);
		this.numMotores = numMotores;
		this.tipoMotor = motor;
	}
	
	/**
	 * Método que devuelve el número de motores de la embarcación de motor más el tipo de motor y la información de la clase padre
	 * 
	 * @return String con la información de la embarcación de motor
	 */
	@Override 
	public String toString() {
		return "Barco a motor: "+super.toString()+ ", motores: " + this.numMotores + ", tipo: " + this.tipoMotor;
	}
	
	/**
	 * Método que devuelve el coste de la embarcación de motor más el coste de la clase padre
	 * 
	 * @return Coste de la embarcación de motor
	 */
	@Override 
	public double getCoste() {
		return super.getCoste()+EmbarcacionMotor.COSTE_MOTOR*this.numMotores*this.tipoMotor.factorMotor();
	}
}

