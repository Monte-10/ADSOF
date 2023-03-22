package matrices;
import java.util.*;

/**
 * Clase que guarda Matrices hasta una cierta potencia para ahorrarse calculos.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */
public class MatrizPotencia {
    

    private List<Matriz> matrices;
    private int potencia;
    private boolean dirty;

    /**
     * Constructor de la clase MatrizPotencia
     * Crea un ArrayList llamado matrices donde se guardaran las matrices
     * Establece dirty a false y potencia a 0
     * 
     * 
     */
    public MatrizPotencia()
    {

        matrices = new ArrayList<Matriz>();
        potencia = 0;
        dirty = false;


    }

     /**
     * Añade una matriz m a el ArrayList y se incrementa potencia para indicar el cambio
     * 
     * @param m
     */
    public void addPotencia(Matriz m)
    {
        if(this.dirty == false)
        {
            matrices.add(m);
            this.potencia++;

            return;

        }
        else
        {
            matrices = new ArrayList<Matriz>();
            matrices.add(m);
            this.potencia++;
            this.dirty = false;

            return;


        }
        

    }

     /**
     * Establecer Dirty como verdadero
     * 
     * 
     * 
     * 
     */
    public void setDirty()
    {

        this.dirty = true;

    }

    /**
     * Getter de el flag dirty
     * 
     * 
     * 
     * @return flag dirty
     */
    public boolean getDirty()
    {

        return this.dirty;

    }

    /**
     * Getter de el objeto Matriz en la posicion i
     * 
     * 
     * 
     * @return Objeto Matriz
     */
    public Matriz getMatriz(int i)
    {
        return matrices.get(i);

    }

    /**
     * Getter de la potencia hasta que se ha calculado las matrices ya
     * 
     * 
     * 
     * @return potencia
     */
    public int getPotencia()
    {

        return potencia;

    }

    /**
     * Método toString
     * 
     * @return String con la matrices indicando la potencia a la que corresponde cada una
     */    
    public String toString()
    {
        String ret = "";
        for(Matriz m:matrices)
        {
            ret += "[potencia "+(matrices.indexOf(m)+1)+"]=\n";
            ret += m.toString();

        }

        return ret;


    }

}
