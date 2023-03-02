package grafos;

import java.util.*;
import nodos.*;

public abstract class Grafo {
    private String nombre;
    private List<Vertice> vertices = new ArrayList<>();
    private List<Arco> arcos = new ArrayList<>();

    public Grafo(String nombre) {
        this.nombre = nombre;
    }

    public boolean addVertices(String ... nombres) {
        /* Comprobamos que el nombre no contenga , y que no se repita */
        for (String nombre : nombres) {
            if (nombre.contains(",") || getVertice(nombre) != null) {
                return false;
            }
            vertices.add(new Vertice(nombre));
        }

        return true;
        
    }

    public Vertice getVertice(String nombre) {
        for (Vertice v : vertices) {
            if (v.getNombre().equals(nombre))
                return v;
        }
        return null;
    }

    /* El método addArco recibe las etiquetas del vértice origen y destino, y la del propio arco. Si los vértices origen y destino
    existen, y la etiqueta del arco no contiene ‘,’ el método crea internamente el arco y lo añade al grafo (y si no, no lo añade). */
    public void addArco(String origen, String destino, String etiqueta) {
        if (getVertice(origen) != null && getVertice(destino) != null && !etiqueta.contains(",") && origen != destino) {
            arcos.add(new Arco(getVertice(origen), getVertice(destino), etiqueta));
        }
    }

    public Arco getArco(String origen, String destino) {
        for (Arco a : arcos) {
            if (a.getOrigen().getNombre().equals(origen) && a.getDestino().getNombre().equals(destino)) {
                return a;
            }
        }
        return null;
    }

    public String toString() {
        return nombre + "\n" + "Vertices: " + vertices + "\n" + "Arcos: " + arcos;
    }
}
