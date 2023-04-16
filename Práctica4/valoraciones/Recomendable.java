package valoraciones;

import java.util.*;
import fonoteca.*;
import excepciones.*;

/**
 * Clase que representa una valoracion
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 */
public class Recomendable implements IRecomendable{
    private String descripcion;
    private Valoracion valoracion;

    /**
     * Constructor de la clase Recomendable
     * 
     * @param descripcion descripcion de la recomendacion
     */
    public Recomendable(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo que devuelve la descripcion de la recomendacion
     */
    @Override
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo que establece la valoracion de la recomendacion
     * 
     * @param valoracion valoracion de la recomendacion
     * 
     */
    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    /**
     * Metodo que devuelve la valoracion de la recomendacion
     * 
     * @return valoracion de la recomendacion
     */
    public Valoracion getValoracion() {
        return valoracion;
    }
}