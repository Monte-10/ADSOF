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

    @Override
    public void addArco(String origen, String destino, String etiqueta) {
        List<Arco> arcos;
        arcos = super.getArcos();

        if (getVertice(origen) != null && getVertice(destino) != null && !etiqueta.contains(",") && origen != destino) {
            
            for (Arco a : arcos) {
                if (a.getOrigen().getNombre() == origen && a.getDestino().getNombre() == destino) {
                    return;
                }

                if (a.getOrigen().getNombre() == destino && a.getDestino().getNombre() == origen) {
                    return;
                }
            }

            Arco arco1 = new Arco(getVertice(origen), getVertice(destino), etiqueta);
            Arco arco2 = new Arco(getVertice(destino), getVertice(origen), etiqueta);
            arcos.add(arco1);
            arcos.add(arco2);
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
    public void borraArco(String origen, String destino) {
        List<Arco> arcos;
        arcos = super.getArcos();

        for (Arco a : arcos) {
            if (a.getOrigen().getNombre() == origen && a.getDestino().getNombre() == destino) {
                arcos.remove(a);
                for (Arco b : arcos) {
                    if (b.getOrigen().getNombre() == destino && b.getDestino().getNombre() == origen) {
                        arcos.remove(b);
                        break;
                    }
                }
                break;
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
        }

        return grado;
    }
}
