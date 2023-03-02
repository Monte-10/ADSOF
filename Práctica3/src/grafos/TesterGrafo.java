package grafos;

import nodos.*;

public class TesterGrafo {
    public static void main(String[] args) {
        testGrafo(new GrafoDirigido("Carreteras"));
            System.out.println("---------------------------------");
            testGrafo(new GrafoNoDirigido("Carreteras"));
    }
    
    private static void testGrafo(Grafo gr) {
        if (!gr.addVertices("Madrid", "Barcelona", "Bilbao", "Madrid", "Lugo, Avila"))
            System.out.println("Vertice(s) invalidos(s)"); // Madrid se repite, no admitimos ','
        
        Vertice madrid = gr.getVertice("Madrid");
        System.out.println(madrid);

        gr.addArco("Madrid", "Barcelona", "506 km");
        gr.addArco("Toledo", "Madrid", "70km"); // no lo añade: Toledo no es vertice
        gr.addArco("Barcelona", "Bilbao", "350 km");
        gr.addArco("Barcelona", "Barcelona", "0 km");
        System.out.println(gr);
        
        Arco madBar = gr.getArco("Madrid", "Barcelona");
        System.out.println(madBar);
        System.out.println(gr.getArco("Toledo", "Madrid")); // este arco no existe
    }
}