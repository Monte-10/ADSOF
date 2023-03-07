package grafos;

public class TesterOperaciones {
    public static void main(String[] args) {
        testGrafo(new GrafoDirigido("Carreteras"));
        System.out.println("---------------------------------");
        testGrafo(new GrafoNoDirigido("Carreteras"));
    }

    private static void testGrafo(Grafo gr) {
        gr.addVertices("Madrid", "Barcelona", "Bilbao");
        gr.addArco("Madrid", "Barcelona", "506 km");
        gr.addArco("Barcelona", "Bilbao", "350 km");
        gr.addArco("Barcelona", "Madrid", "506 km");
        gr.concatena(gr.getArco("Madrid", "Barcelona"), gr.getArco("Barcelona", "Bilbao"));
        if (!gr.concatena(gr.getArco("Madrid", "Barcelona"), gr.getArco("Barcelona", "Madrid")))
            System.out.println("Los arcos no se pueden concatenar");
        System.out.println(gr);
        System.out.println("Grado de Madrid: " + gr.grado("Madrid"));
        System.out.println("Es regular: " + gr.esRegular());
        System.out.println("Es regular: " + gr.borraArco("Barcelona", "Madrid").esRegular());
    }
}    