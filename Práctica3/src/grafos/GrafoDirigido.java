package grafos;

public class GrafoDirigido extends Grafo{
    public GrafoDirigido(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Grafo dirigido " + super.toString();
    }
}
