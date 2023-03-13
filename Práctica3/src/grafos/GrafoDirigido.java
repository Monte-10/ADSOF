package grafos;
import java.util.*;
import nodos.*;
import java.io.*;

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
                if (a.getOrigen().getNombre().equals(origen) && a.getDestino().getNombre().equals(destino)) {
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
    public void borraArco(String origen, String destino) {
        List<Arco> arcos;
        arcos = super.getArcos();

        for (Arco a : arcos) {
            if (a.getOrigen().getNombre().equals(origen) && a.getDestino().getNombre().equals(destino)) {
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
            if (a.getOrigen().getNombre().equals(nombre)) {
                grado++;
            }

            if (a.getDestino().getNombre().equals(nombre)) {
                grado++;
            }
        }
        return grado;
    }

    
    public static GrafoDirigido desdeFichero(String nombreFichero) throws FileNotFoundException {
        File fichero = new File(nombreFichero);
        FileReader fr = new FileReader(fichero);
        
        try (BufferedReader br = new BufferedReader(fr)) {
            String tipoGrafo = br.readLine().trim();
            if (tipoGrafo.equals("Dirigido")) {
                String nombre = br.readLine().trim();
                System.out.println(nombre);
                GrafoDirigido grafo = new GrafoDirigido(nombre);
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

            } else {
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error de lectura");
        }
        return null;
    }

    @Override
    public void salvar(String nombreFichero) throws IOException{
        List<Arco> arcos;

        try(FileWriter fw = new FileWriter(nombreFichero)) {
            String tipoGrafo = "Dirigido";
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
