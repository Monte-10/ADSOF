package grafos;

public class GrafoNoDirigido extends Grafo{
    public GrafoNoDirigido(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Grafo no dirigido " + super.toString();
    }
}
