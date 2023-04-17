package valoraciones;

/**
 * Clase que representa una recomendacion
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es 
 */
public class Recomendacion implements Comparable<Recomendacion> {
    private IRecomendable elemento;
    private double confianza;

    /**
     * Constructor de la clase Recomendacion
     * 
     * @param elemento elemento recomendado
     * @param confianza confianza de la recomendacion
     */
    public Recomendacion(IRecomendable elemento, double confianza) {
        this.elemento = elemento;
        this.confianza = confianza;
    }

    /**
     * Metodo que devuelve el elemento recomendado
     * 
     * @return elemento recomendado
     */
    public IRecomendable getElemento() {
        return elemento;
    }

    /**
     * Metodo que devuelve la confianza de la recomendacion
     * 
     * @return confianza de la recomendacion
     */
    public double getConfianza() {
        return confianza;
    }

    /**
     * Método toString de la clase Recomendacion
     * 
     * @return String con la descripcion del elemento y la confianza de la recomendacion
     */
    @Override
    public String toString() {
        return elemento.getDescripcion() + " [" + confianza + "]";
    }

    /**
     * Método que compara dos recomendaciones
     * 
     * @param otra recomendacion a comparar
     * @return -1 si la confianza de la recomendacion es mayor que la de otra, 1 si es menor y 0 si son iguales
     */
    @Override
    public int compareTo(Recomendacion otra) {
        if (this.confianza > otra.confianza) {
            return -1;
        }
        else if (this.confianza < otra.confianza) {
            return 1;
        }
        else {
            return 0;
        }
    }
}