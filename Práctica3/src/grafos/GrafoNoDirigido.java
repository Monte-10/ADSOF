package grafos;
import java.util.*;
import nodos.*;
import java.io.*;

/**
 * Clase que representa un grafo no dirigido.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */
public class GrafoNoDirigido extends Grafo{

    /**
     * Constructor de la clase GrafoNoDirigido
     * 
     * @param nombre
     */
    public GrafoNoDirigido(String nombre) {
        super(nombre);
    }

    /**
     * Método toString que devuelve el grafo no dirigido
     * 
     * @return Grafo no dirigido
     */
    @Override
    public String toString() {
        return "Grafo no dirigido " + super.toString();
    }

    /**
     * Método que añade un arco al grafo no dirigido
     * 
     * @param origen
     * @param destino
     * @param etiqueta
     * 
     * @return
     */
    @Override
    public void addArco(String origen, String destino, String etiqueta) {
        List<Arco> arcos;
        arcos = super.getArcos();

        if (getVertice(origen) != null && getVertice(destino) != null && !etiqueta.contains(",") && origen != destino) {
            
            for (Arco a : arcos) {

                if (a.getOrigen().getNombre().equals(destino) && a.getDestino().getNombre().equals(origen)) {
                    return;
                }

                if (a.getOrigen().getNombre().equals(origen) && a.getDestino().getNombre().equals(destino)) {
                    return;
                }
            }

            Arco arco1 = new Arco(getVertice(origen), getVertice(destino), etiqueta);
            Arco arco2 = new Arco(getVertice(destino), getVertice(origen), etiqueta);
            arcos.add(arco1);
            arcos.add(arco2);
        }
    }

    /**
     * Método que concatena dos arcos
     * 
     * @param arco1
     * @param arco2
     * 
     * @return true si se ha podido concatenar, false en caso contrario
     */
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

    /**
     * Método que borra un arco del grafo no dirigido
     * 
     * @param origen
     * @param destino
     * 
     * @return Arco borrado
     */
    @Override
    public Arco borraArco(String origen, String destino) {
        List<Arco> arcos;
        arcos = super.getArcos();

        for (Arco a : arcos) {
            if (a.getOrigen().getNombre().equals(origen) && a.getDestino().getNombre().equals(destino)) {
                Arco arco = a;
                arcos.remove(a);
                for (Arco b : arcos) {
                    if (b.getOrigen().getNombre().equals(destino) && b.getDestino().getNombre().equals(origen)) {
                        arcos.remove(b);
                        return arco;
                    }
                }
                break;
            }
        }
        return null;
    }

    /**
     * Método que devuelve el grado de un vértice
     * 
     * @param nombre
     * 
     * @return Grado del vértice
     */
    @Override
    public int grado(String nombre) {
        int grado = 0;
        List<Arco> arcos;
        arcos = super.getArcos();

        for (Arco a : arcos) {
            if (a.getOrigen().getNombre().equals(nombre)) {
                grado++;
            }
        }

        return grado;
    }

    /**
     * Método que carga un grafo no dirigido desde un fichero
     * 
     * @param nombreFichero
     * @return Grafo no dirigido
     * @throws FileNotFoundException
     */
    public static GrafoNoDirigido desdeFichero(String nombreFichero) throws FileNotFoundException {
        File fichero = new File(nombreFichero);
        FileReader fr = new FileReader(fichero);

        try (BufferedReader br = new BufferedReader(fr)) {
            String tipoGrafo = br.readLine().trim();
            if (tipoGrafo.equals("NoDirigido")) {
                String nombre = br.readLine().trim();
                GrafoNoDirigido grafo = new GrafoNoDirigido(nombre);
                String vertices = br.readLine().trim();
                String[] verticesArray = vertices.split(",");
                grafo.addVertices(verticesArray);
                String linea = br.readLine();
                while (linea != null) {
                    String[] arco = linea.split(",");
                    grafo.addArco(arco[0], arco[1], arco[2]);
                    linea = br.readLine();
                }
                return grafo;

            }

            else {
                return null;
            }
        } catch (IOException e) {
            System.out.println("Error de lectura del fichero");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Método que guarda un grafo no dirigido en un fichero
     * 
     * @param nombreFichero
     * @throws IOException
     */
    @Override
    public void salvar(String nombreFichero) throws IOException {
        List<Arco> arcos;

        try(FileWriter fw = new FileWriter(nombreFichero)) {
            String tipoGrafo = "No Dirigido";
            fw.write(tipoGrafo+"\n");
            String nombre = super.getNombre();
            fw.write(nombre+"\n");
            fw.write(String.join(",", super.getEtiquetasVertices())+"\n");
            arcos = super.getArcos();
            for (Arco a: arcos) {
                fw.write(a.getOrigen().getNombre() + "," + a.getDestino().getNombre() + "," + a.getEtiqueta() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error de escritura");
        }
    }
}
