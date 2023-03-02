package ciudades;

public class Vertice {
    private String nombre;
    private static int numVertices;
    private int id;

    public Vertice(String nombre) {this.nombre = nombre; this.id=numVertices; numVertices++;}

    public String toString() {
        return nombre + "(" + id + ")";
    }

    public String getNombre() {
        return nombre;
    }
    
}