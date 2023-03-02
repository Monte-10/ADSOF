package ciudades;

public class Vertice {
    private String nombre;
    private static int id;

    public Vertice(String nombre) {this.nombre = nombre;}

    public String toString() {
        return nombre + "(" + id++ + ")";
    }

    
}