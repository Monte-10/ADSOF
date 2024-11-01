package valoraciones;

import java.util.*;
import fonoteca.*;

/**
 * Clase que representa un recomendador de popularidad
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 */
public class RecomendadorPopularidad implements IRecomendador {
    private double corte;
    private AlmacenValoraciones almacen;

    /**
     * Constructor de la clase RecomendadorPopularidad
     * 
     * @param almacen almacen de valoraciones
     * @param corte corte de afinidad
     */
    public RecomendadorPopularidad(AlmacenValoraciones almacen, double corte) {
        this.almacen = almacen;
        this.corte = corte;
    }

    /**
     * Metodo que devuelve las recomendaciones de un usuario
     * 
     * @param usuario usuario del que se quieren obtener las recomendaciones
     * 
     * @return recomendaciones del usuario
     */
    public Collection<Recomendacion> getRecomendaciones(IUsuario usuario) {
        Collection<Recomendacion> recomendaciones = new TreeSet<Recomendacion>(java.util.Collections.reverseOrder());
        Collection<IRecomendable> elementos = almacen.getRecomendables();
        for (IRecomendable elemento : elementos) {
            double confianza = almacen.getValoracionMedia(elemento);
            if (confianza >= corte) {
                if (!almacen.haValorado(usuario, elemento)) {

                    Recomendacion recomendacion = new Recomendacion(elemento, confianza);
                    recomendaciones.add(recomendacion);
                }
                else {
                }
            }
        }
        return recomendaciones;
    }

    /**
     * Metodo que modifica el corte de afinidad
     * 
     * @param corte nuevo corte de afinidad
     */
    public void setCorte(double corte) {
        this.corte = corte;
    }



    /**
     * Método que establece el almacen de valoraciones
     * 
     * @param almacen almacen de valoraciones
     */
    public void setAlmacen(AlmacenValoraciones almacen) {
        this.almacen = almacen;
    }

    /**
     * Método que añade un usuario al almacen de valoraciones
     * 
     * @param usuario usuario a añadir
     * @return true si se ha añadido correctamente, false en caso contrario
     */
    @Override
    public boolean addUsuario(IUsuario usuario) {
        return almacen.addUsuario(usuario);
    }

    /**
     * Método que añade un elemento recomendable al almacen de valoraciones
     * 
     * @param elemento elemento recomendable a añadir
     * @return true si se ha añadido correctamente, false en caso contrario
     */
    @Override
    public boolean addRecomendable(IRecomendable elemento) {
        return almacen.addRecomendable(elemento);
    }

    /**
     * Método que añade una valoracion al almacen de valoraciones
     * 
     * @param usuario usuario que realiza la valoracion
     * @param elemento elemento recomendable valorado
     * @param valoracion valoracion realizada
     */
    @Override
    public void addValoracion(IUsuario usuario, IRecomendable elemento, Valoracion valoracion) {
        almacen.addValoracion(usuario, elemento, valoracion);
    }

    /**
     * Método que devuelve si un usuario ha valorado un elemento recomendable
     * 
     * @param usuario usuario que realiza la valoracion
     * @param elemento elemento recomendable valorado
     * 
     * @return true si el usuario ha valorado el elemento, false en caso contrario
     */
    @Override
    public boolean haValorado(IUsuario usuario, IRecomendable elemento) {
        return almacen.haValorado(usuario, elemento);
    }

    /**
     * Método que devuelve los elementos recomendables valorados por un usuario
     * 
     * @param usuario usuario que realiza la valoracion
     * 
     * @return elementos recomendables valorados por el usuario
     */
    @Override
    public Collection<IRecomendable> elementosValorados(IUsuario usuario) {
        return almacen.elementosValorados(usuario);
    }

    /**
     * Método que devuelve la valoracion de un usuario a un elemento recomendable
     * 
     * @param usuario usuario que realiza la valoracion
     * @param elemento elemento recomendable valorado
     * 
     * @return valoracion realizada
     */
    @Override
    public Valoracion valoracion(IUsuario usuario, IRecomendable elemento) {
        return almacen.valoracion(usuario, elemento);
    }

}