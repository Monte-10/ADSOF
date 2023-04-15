package valoraciones;

public class Recomendacion implements Comparable<Recomendacion> {
    private IRecomendable elemento;
    private double confianza;

    public Recomendacion(IRecomendable elemento, double confianza) {
        this.elemento = elemento;
        this.confianza = confianza;
    }

    public IRecomendable getElemento() {
        return elemento;
    }

    public double getConfianza() {
        return confianza;
    }

    @Override
    public String toString() {
        return elemento.getDescripcion() + " [" + confianza + "]";
    }

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