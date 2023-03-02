package ciudades;

public class Arco {
    private Vertice origen;
    private Vertice destino;
    private String distancia;
    private static int numArcos;
    private int id;

    public Arco(Vertice origen, Vertice destino, String distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.id = numArcos;
        numArcos++;
    }

    public String toString() {
        return distancia + "(" + id +"): " + origen.getNombre() + " -- " + destino.getNombre();
    }

}
