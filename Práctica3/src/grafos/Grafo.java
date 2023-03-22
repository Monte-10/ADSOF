package grafos;

import java.util.*;
import nodos.*;
import java.io.*;
import matrices.*;

/**
 * Esta clase representa un grafo dirigido o no dirigido
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 */
public abstract class Grafo {
    private String nombre;
    private List<Vertice> vertices = new ArrayList<>();
    private List<Arco> arcos = new ArrayList<>();
    private MatrizPotencia mp;

    /**
     * Constructor de la clase Grafo
     * Crea un grafo con un nombre
     * 
     * @param nombre
     */
    public Grafo(String nombre) {
        this.nombre = nombre;
        this.mp = new MatrizPotencia();
    }
     /**
     *  Devuelve MatrizPotencia con las matrices hasta la potencia mas alta que se haya introducido.
     *
     * 
     * @return Objeto MatrizPotencia asociado al grafo
     */
    public MatrizPotencia matricesPotencia()
    {
        return mp;

    } 


    /**
     *  Calcula numero de caminos de una potencia determinada entre dos vertices
     *
     * @param potencia 
     * @param e1
     * @param e2
     * @return Objeto MatrizPotencia asociado al grafo
     */
    public int camino(int potencia,String e1,String e2)
    {
        int i;
        Matriz m = new Matriz(this);
        Matriz m1 = new Matriz(this);
        int[][] resultado;

        if(mp.getPotencia() >= potencia && mp.getDirty() == false)
        {
            m1 = mp.getMatriz(potencia-1);
            return m1.getMatriz()[this.vertices.indexOf(getVertice(e1))][this.vertices.indexOf(getVertice(e2))];

        }

        for(i=0;i<potencia;i++)
        {
            if(i == 0)
            {
                mp.addPotencia(m1);
            }
            else
            {
                resultado = m.matrizmult(m1,m);
                m1 = new Matriz(resultado,this);
                mp.addPotencia(m1);
               
            }
            
    
        }
        
        
        
        return m1.getMatriz()[this.vertices.indexOf(getVertice(e1))][this.vertices.indexOf(getVertice(e2))];
        
      


    }
    /**
     * Método toString
     * 
     * @return String con el nombre del grafo, los vértices y los arcos
     */
    public String toString() {
        return nombre + "\n" + "Vertices: " + vertices + "\n" + "Arcos: " + arcos;
    }

    /**
     * Método que añade vértices al grafo
     * @param nombres
     * @return true si se han añadido correctamente, false si no
     */
    public boolean addVertices(String ... nombres) {
        boolean flag = true;
        boolean status = true;

        /* Comprobamos que el nombre no contenga , y que no se repita */
        for (String nombre : nombres) {
            flag = true;
            if (nombre.contains(",") || getVertice(nombre) != null) {
                flag = false;
                status = false;
            }
            if (flag) vertices.add(new Vertice(nombre));
        }
        
        return status;
    }

    /**
     * Método que devuelve un vértice dado su nombre
     * 
     * @param nombre
     * @return Vertice
     */
    public Vertice getVertice(String nombre) {
        for (Vertice v : vertices) {
            if (v.getNombre().equals(nombre))
                return v;
        }
        return null;
    }

    /**
     * Método que añade arcos al grafo
     * 
     * @param origen
     * @param destino
     * @param etiqueta
     */
    public void addArco(String origen, String destino, String etiqueta) {
        return;
    }

    /**
     * Método que devuelve un arco dado su origen y su destino
     * 
     * @param origen
     * @param destino
     * @return Arco
     */
    public Arco getArco(String origen, String destino) {
        for (Arco a : arcos) {
            if (a.getOrigen().getNombre().equals(origen) && a.getDestino().getNombre().equals(destino)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Método que devuelve una lista con los arcos del grafo
     * 
     * @return List<Arco>
     */
    public List<Arco> getArcos() {
        return arcos;
    }

    /**
     * Método que devuelve una lista con los vértices del grafo
     * 
     * @return List<Vertice>
     */
    public List<Vertice> getVertices() {
        return vertices;
    }

    /**
     * Método que devuelve el nombre del grafo
     * 
     * @return String con el nombre del grafo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que devuelve una lista de los nombres de los vértices del grafo
     * 
     * @param nombre
     * @return String de los nombres de los vértices
     */
    public String getEtiquetasVertices() {
        String etiquetas = "";
        for (Vertice v : vertices) {
            etiquetas += v.getNombre() + ",";
        }
        return etiquetas.substring(0, etiquetas.length() - 1);
    }

    /**
     * Método que concatena dos arcos
     * 
     * @param arco1
     * @param arco2
     * 
     * @return false
     */
    public boolean concatena(Arco arco1, Arco arco2) {
        return false;
    }

    /**
     * Método que borra un arco del grafo
     * 
     * @param origen
     * @param destino
     * 
     * @return null
     */
    public Arco borraArco(String origen, String destino) {
        return null;
    }

    /**
     * Método que devuelve el grado de un vértice
     * 
     * @param nombre
     * @return 0
     */
    public int grado(String nombre) {
        return 0;
    }

    /**
     * Método que devuelve si un grafo es regular o no
     * 
     * @return
     */
    public String esRegular() {
        int grado = grado(vertices.get(0).getNombre());
        for (Vertice v : vertices) {
            if (grado(v.getNombre()) != grado) {
                return "false";
            }
        }
        return "true";
    }
    
    /**
     * Método que carga un grafo desde un fichero
     * 
     * @param nombreFichero
     * @return
     * @throws FileNotFoundException
     */
    public static Grafo desdeFichero(String nombreFichero) throws FileNotFoundException{
        return null;
    }

    /**
     * Método que salva un grafo en un fichero
     * 
     * @param nombreFichero
     * @throws IOException
     */
    public void salvar(String nombreFichero) throws IOException{
        return;
    }
}
