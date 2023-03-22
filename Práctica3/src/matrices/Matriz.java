package matrices;

import java.util.*;

import nodos.*;
import grafos.*;


/**
 * Clase que representa una matriz del grafo.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */
public class Matriz
{

    private Grafo gr;
    private int[][] matriz;


     /**
     * Constructor de la clase Matriz
     * Crea una matriz apartir de los vertices y arcos de un grafo gr
     * 
     * @param gr
     */
    public Matriz(Grafo gr)
    {
        List<Vertice> vertices;
        List<Arco> arcos;
        this.gr = gr;
        int i = 0;
        int j = 0;
        vertices = gr.getVertices();
        arcos = gr.getArcos();
        
        matriz = new int[vertices.size()][vertices.size()];

        for(i = 0;i<vertices.size();i++)
        {
        
           for(j = 0;j<arcos.size();j++)
           {
                if(arcos.get(j).getOrigen().getNombre().equals(vertices.get(i).getNombre()))
                {
                    matriz[i][vertices.indexOf(arcos.get(j).getDestino())] = 1;
                   
                }

           }


        }

        for(i = 0;i<vertices.size();i++)
        {
            for(j = 0;j<vertices.size();j++)
            {

                if(matriz[i][j] != 1)
                {
                    matriz[i][j] = 0;
                }
            
            }

        }

    }

    /**
     * Constructor de la clase Matriz
     * Crea una matriz con unos valores introducidos en matriz, asociada a grafo gr
     * 
     * @param matriz
     * @param gr
     */
    public Matriz(int[][] matriz,Grafo gr)
    {
        this.gr = gr;
        this.matriz = matriz;
    }

    /**
     * Getter de la matriz de el objeto Matriz
     * 
     * 
     * 
     * @return matriz
     */
    public int[][] getMatriz()
    {


        return matriz;


    }

    /**
     * Multiplica la matriz m1 por la matriz m2 
     * 
     * @param m1
     * @param m2
     * 
     * @return resultado de la multiplicacion
     */
    public int[][] matrizmult(Matriz m1,Matriz m2)
    {
        int[][] matr1 = m1.getMatriz();
        int[][] matr2 = m2.getMatriz();
        int[][] result = new int[matr1.length][matr2[0].length];;

        int i;
        int j;
        int k;

        for(i=0;i<matr1.length;i++)
        {
            for(j=0;j<matr2[0].length;j++)
            {
                for (k = 0; k < matr1[0].length; k++) { 
                    result[i][j] += matr1[i][k] * matr2[k][j];
                }
            }
        }

        return result;



    }

    /**
     * Método toString
     * 
     * @return String con la matriz con sus vertices correspondientes
     */
    public String toString(){

        List<Vertice> vertices;
        List<String> rets = new ArrayList<String>();
        
        int i = 0;
        int biggest;
        vertices = gr.getVertices();
        String ret = "";

        biggest = vertices.get(0).getNombre().length();

        for(Vertice v1:vertices)
        {
            if(biggest < v1.getNombre().length())
            {
                biggest = v1.getNombre().length();
            }
        }

        for(i=0;i<vertices.size();i++)
        {
            ret = vertices.get(i).getNombre() + ":";
            for(Vertice vj:vertices)
            {
                
                ret += " "+ matriz[i][vertices.indexOf(vj)];
               
            }
            
            ret = String.format("|%"+(biggest+1+(2*vertices.size()))+"s|",ret);
            
            ret += "\n";
            
            rets.add(ret);


          
            
        }

        ret = "";
        
        
        for(i=0;i<rets.size();i++)
        {

            ret += rets.get(i);

        }

        return ret;
        
        
    }







}
