package grafos;
import java.io.*;

public class TesterLecturaGrafo {
    public static void main(String[] args) throws IOException{
    GrafoDirigido gd = GrafoDirigido.desdeFichero ("carreteras-dirigido.txt");
    GrafoNoDirigido gnd = GrafoNoDirigido.desdeFichero("carreteras-nodirigido.txt");
    System.out.println(gd);
    System.out.println("--------------------");
    System.out.println(gnd);
    System.out.println("--------------------");
    // el fichero contiene un grafo no dirigido, así que devuelve null
    System.out.println(GrafoDirigido.desdeFichero("carreteras-nodirigido.txt"));
    gd.addVertices("Zaragoza");
    gd.salvar("carreteras-dirigido2.txt");
    }
    }