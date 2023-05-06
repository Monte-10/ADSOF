package coffee;

/**
 * Clase que representa un pedido de café.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 */
public class CoffeeOrder {
    private int num;
    private CoffeeType ct;

    /**
     * Constructor de la clase CoffeeOrder.
     * 
     * @param num Número de cafés.
     * @param ct Tipo de café.
     */
    public CoffeeOrder(int num,CoffeeType ct) {
        this.num = num;
        this.ct = ct;
    }

    /**
     * Método toString de la clase CoffeeOrder.
     * 
     * @return String con el número de cafés y el tipo de café.
     */
    @Override public String toString() { return "CoffeeOrder[" + num + ", " + this.ct +"]"; }
    }