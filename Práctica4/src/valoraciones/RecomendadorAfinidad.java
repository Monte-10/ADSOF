package valoraciones;

import java.util.*;
import fonoteca.*;

/**
 * Clase que representa un recomendador de afinidad
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */
public class RecomendadorAfinidad implements IRecomendador {
    double corte;
    AlmacenValoraciones almacen;

    /**
     * Constructor de la clase
     * 
     * @param corte corte de afinidad
     */
    public RecomendadorAfinidad(double corte) {
        this.corte = corte;
    }

    public RecomendadorAfinidad() {
        this.corte = 0;
    }

    /**
     * Metodo que devuelve las recomendaciones de un usuario
     * 
     * @param usuario usuario del que se quieren obtener las recomendaciones
     * @return recomendaciones del usuario
     */
    public Collection<Recomendacion> getRecomendaciones(IUsuario usuario) {
        
        List<Recomendacion> recomendaciones = new ArrayList<Recomendacion>();
        Collection<IUsuario> usuarios = almacen.getUsuarios();
        

        for (IUsuario usuario2 : usuarios) {
            if (usuario.getId() != usuario2.getId()) {
                double afinidad = almacen.getValoracionMediaAfinidad(usuario, usuario2);
                
                Collection<IRecomendable> elementos = almacen.getRecomendables();
                for (IRecomendable elemento : elementos) {
                    double confianza = 0;
                    if (!almacen.haValorado(usuario, elemento) && almacen.haValorado(usuario2, elemento)) {
                        if (almacen.valoracion(usuario2, elemento) == Valoracion.LIKE) {
                            
                            
                            double confianzanew = afinidad/almacen.getRecomendables().size();
                            if(confianzanew >= corte)
                            {
                                confianzanew = Math.round(confianzanew * 100.0) / 100.0;
                                if(confianzanew > confianza)
                                {
                                    confianza = confianzanew;
                                }
                            
                                
                                Recomendacion recomendacion = new Recomendacion(elemento, confianza);
                                recomendaciones.add(recomendacion);
                            }
                           
                                
                        }
                    }
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