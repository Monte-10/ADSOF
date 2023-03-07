package grafos;
import java.util.*;
import nodos.*;
public class GrafoNoDirigido extends Grafo{

    public GrafoNoDirigido(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Grafo no dirigido " + super.toString();
    }

    public void addArco(String origen, String destino, String etiqueta) {
        List<Arco> arcos;
        arcos = super.getArcos();

        if (getVertice(origen) != null && getVertice(destino) != null && !etiqueta.contains(",") && origen != destino) {
            Arco arco1 = new Arco(getVertice(origen), getVertice(destino), etiqueta);
            Arco arco2 = new Arco(getVertice(destino), getVertice(origen), etiqueta);
            arcos.add(arco1);
            arcos.add(arco2);
        }
}
}
