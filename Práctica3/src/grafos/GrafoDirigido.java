package grafos;
import java.util.*;
import nodos.*;

public class GrafoDirigido extends Grafo {
    public GrafoDirigido(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Grafo dirigido " + super.toString();
    }

    @Override
    public void addArco(String origen, String destino, String etiqueta) {
        List<Arco> arcos;
        arcos = super.getArcos();

        if (getVertice(origen) != null && getVertice(destino) != null && !etiqueta.contains(",") && origen != destino) {
            Arco arco1 = new Arco(getVertice(origen), getVertice(destino), etiqueta);
            arcos.add(arco1);
        }
    }

    @Override
    public Arco concatena(Arco arco1, Arco arco2) {
        Vertice origen = arco1.getOrigen();
        Vertice destino = arco2.getDestino();
        String etiqueta = arco1.getEtiqueta() + "--" + arco2.getEtiqueta();

        if (!arco1.getDestino().equals(arco2.getOrigen())) {
            System.out.println("Los arcos no se pueden concatenar");
            return null;
        }
        
        return this.addArco(origen.getNombre(), destino.getNombre(), etiqueta);
    }

}
