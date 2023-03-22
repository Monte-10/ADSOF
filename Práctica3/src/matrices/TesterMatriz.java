package matrices;

import grafos.*;

public class TesterMatriz {
    public static void main(String[] args) {
        GrafoDirigido gd = new GrafoDirigido("Carreteras");
        testearGrafo(gd);
        System.out.println("===============================");
        GrafoNoDirigido gnd = new GrafoNoDirigido("Carreteras");
        testearGrafo(gnd);
    }

    private static void testearGrafo(Grafo gd) {
        crearGrafo(gd);
        System.out.println("Caminos de long. 2 Madrid-Bilbao: "+gd.camino(2, "Madrid", "Bilbao"));
        System.out.println("Caminos de long. 2 Bilbao-Madrid: "+gd.camino(2, "Bilbao", "Madrid"));
        System.out.println(gd.matricesPotencia()); // devuelve el objeto PotenciaMatriz asociado
    }

    private static void crearGrafo(Grafo gr) {
        gr.addVertices("Madrid", "Barcelona", "Bilbao");
        gr.addArco("Madrid", "Barcelona", "506 km");
        gr.addArco("Barcelona", "Bilbao", "350 km");
    }
    }