package nodos;

/**
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 * Esta clase representa un vértice de un grafo. 
 */
public class Vertice {
    private String nombre;
    private static int numVertices;
    private int id;

    /**
     * Constructor de la clase Vertice
     * @param nombre
     */
    public Vertice(String nombre) {this.nombre = nombre; this.id=numVertices; numVertices++;}

    /**
     * Método toString que devuelve el nombre de la ciudad con su id
     * @return Nombre de la ciudad e id
     */
    public String toString() {
        return nombre + "(" + id + ")";
    }

    /**
     * 
     * Getter de nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    
}