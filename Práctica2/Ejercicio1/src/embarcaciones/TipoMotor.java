package embarcaciones;

/**
 * Esta clase representa a una enumeracion del tipo de motor.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */
public enum TipoMotor {
	// Cada objeto del enumerado inicializa el factor en el constructor
	GASOLINA(2), DIESEL(1.5), ELECTRICO (1);				
	
	private double factor; 		// factor de coste
	
	/**
	 * Constructor del enumerado
	 * @param multip
	 */
	TipoMotor(double multip) {	// constructor del enumerado
		this.factor = multip;
	}
	
	/**
	 * Método que devuelve el factor de coste del motor
	 * 
	 * @return Factor de coste del motor
	 */
	public double factorMotor() { // getter
		return this.factor;
	}
}
