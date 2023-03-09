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

    public String toString() {
        return nombre + "\n" + "Vertices: " + vertices + "\n" + "Arcos: " + arcos;
    }

    public boolean addVertices(String ... nombres) {
        boolean flag = true;
        boolean status = true;

        /* Comprobamos que el nombre no contenga , y que no se repita */
        for (String nombre : nombres) {
            flag = true;
            if (nombre.contains(",") || getVertice(nombre) != null) {
                flag = false;
                status = false;
            }
            if (flag) vertices.add(new Vertice(nombre));
        }
        
        return status;
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
        return;
    }

    public Arco getArco(String origen, String destino) {
        for (Arco a : arcos) {
            if (a.getOrigen().getNombre().equals(origen) && a.getDestino().getNombre().equals(destino)) {
                return a;
            }
        }
        return null;
    }

    public List<Arco> getArcos() {
        return arcos;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public boolean concatena(Arco arco1, Arco arco2) {
        return false;
    }

    public void borraArco(String origen, String destino) {
        return;
    }

    public int grado(String nombre) {
        return 0;
    }

    public String esRegular() {
        int grado = grado(vertices.get(0).getNombre());
        for (Vertice v : vertices) {
            if (grado(v.getNombre()) != grado) {
                return "false";
            }
        }
        return "true";
    }
}
