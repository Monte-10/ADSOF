package nodos;

/**
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 * Esta clase representa un arco de un grafo. 
 */
public class Arco {
    private Vertice origen;
    private Vertice destino;
    private String distancia;
    private static int numArcos;
    private int id;

    /**
     * Constructor de la clase Arco
     * 
     * @param origen
     * @param destino
     * @param distancia
     */
    public Arco(Vertice origen, Vertice destino, String distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.id = numArcos;
        numArcos++;
    }

    /**
     * Método toString que devuelve la distancia entre dos ciudades
     * @return Distancia entre dos cuidades
     */
    public String toString() {
        return distancia + "(" + id +"): " + origen.getNombre() + " -- " + destino.getNombre();
    }

    /**
     * Método que devuelve el vértice origen del arco
     * @return origen
     */
    public Vertice getOrigen() {
        return origen;
    }

    /**
     * Método que devuelve el vértice destino del arco
     * @return destino
     */
    public Vertice getDestino() {
        return destino;
    }

    /**
     * Método que devuelve la etiqueta del arco
     * @return distancia
     */
    public String getEtiqueta() {
        return distancia;
    }

    /**
     * Método que devuelve establece la etiqueta del arco
     * @return 
     */
    public void setEtiqueta(String etiqueta) {
        this.distancia = etiqueta;
    }

}
