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
            for (Arco a : arcos) {
                if (a.getOrigen().getNombre() == origen && a.getDestino().getNombre() == destino) {
                    return;
                }
            }
            Arco arco1 = new Arco(getVertice(origen), getVertice(destino), etiqueta);
            arcos.add(arco1);
        }
    }

    @Override
    public boolean concatena(Arco arco1, Arco arco2) {
        Vertice origen = arco1.getOrigen();
        Vertice destino = arco2.getDestino();
        String etiqueta = arco1.getEtiqueta() + "--" + arco2.getEtiqueta();

        if (!arco1.getDestino().equals(arco2.getOrigen()) || arco1.getOrigen().equals(arco2.getDestino())) {
            return false;
        }
        
        this.addArco(origen.getNombre(), destino.getNombre(), etiqueta);
        return true;
    }

    @Override
    public void borraArco (String origen, String destino) {
        List<Arco> arcos;
        arcos = super.getArcos();

        for (Arco a : arcos) {
            if (a.getOrigen().getNombre() == origen && a.getDestino().getNombre() == destino) {
                arcos.remove(a);
            }
        }
    }

    @Override
    public int grado(String nombre) {
        int grado = 0;
        List<Arco> arcos;
        arcos = super.getArcos();

        for (Arco a : arcos) {
            if (a.getOrigen().getNombre() == nombre) {
                grado++;
            }

            if (a.getDestino().getNombre() == nombre) {
                grado++;
            }
        }
        return grado;
    }
}
