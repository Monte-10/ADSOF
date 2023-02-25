package embarcaciones;

/**
 * Esta clase representa a una lancha de competición, que es una embarcación de motor.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */
public class LanchaCompeticion extends EmbarcacionMotor {

    private boolean esCatamaran;

    /**
     * Constructor de la clase LanchaCompeticion
     * Crear una lancha de competición con un nombre, capacidad, dimensiones, número de motores, tipo de motor y si es catamaran
     * 
     * @param nombre Nombre de la lancha de competición
     * @param esCatamaran Si es catamaran
     */
    public LanchaCompeticion(String nombre, Boolean esCatamaran){

        super(nombre, 1, 49, 1, TipoMotor.GASOLINA);
        this.esCatamaran = esCatamaran;
    }

    /**
     * Método que devuelve si es catamaran y la información de la clase padre
     * 
     * @return String con la información de la lancha de competición
     */
    @Override 
	public String toString() {
		return super.toString() + ", de competición " + (esCatamaran ? "(catamaran)" : "");
    }
	
    /**
     * Método que devuelve el coste de la lancha de competición
     * 
     * @return Coste de la lancha de competición
     */
	public double getCoste() {
		return 200 + (esCatamaran ? 50 : 0);
	}
	
}