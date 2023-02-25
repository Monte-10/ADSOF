/**
 * Esta aplicación permite gestionar un puerto con embarcaciones de distinto tipo.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */

package puerto;

import embarcaciones.*;

/**
 * Clase principal que gestiona el puerto
 * Crea un array de embarcaciones y muestra su información y coste
 * 
 * @param args Argumentos de la línea de comandos
 */
public class ControladorPuerto {
	/**
	 * Método main para ejecutar la aplicación
	 * Este método crea un array de embarcaciones y muestra su información y coste
	 * 
	 * @param args Argumentos de la línea de comandos
	 */
	public static void main(String[] args) {
		Embarcacion[] barcos = { 
				new EmbarcacionMotor("New Titanic", 20, 55.5, 2, TipoMotor.ELECTRICO),
				new Velero("Mini Lusitania", 30, 65, 4.5, 2),
				new EmbarcacionMotor("Nautilus", 3, 26.5, 1, TipoMotor.GASOLINA),
				new EmbarcacionMotor("Bismark pro", 10, 32.7, 3, TipoMotor.DIESEL),
				new LanchaCompeticion("Victory", true)
		};
		
		double costeTotal = 0;
		for (Embarcacion e : barcos) {			
			System.out.println(e + "\n  - Coste: "+e.getCoste()+" euros/dia");
			costeTotal += e.getCoste();
		}
		System.out.println("\nCoste total: "+costeTotal+" euros");
	}
}
