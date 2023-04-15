package valoraciones;

import java.util.*;
import fonoteca.*;

public class RecomendadorPopularidad implements IRecomendador {
    private double corte;
    private AlmacenValoraciones almacen;

    public RecomendadorPopularidad(AlmacenValoraciones almacen, double corte) {
        this.almacen = almacen;
        this.corte = corte;
    }

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

    public void setCorte(double corte) {
        this.corte = corte;
    }

    @Override
    public boolean addUsuario(IUsuario usuario) {
        return almacen.addUsuario(usuario);
    }
    @Override
    public boolean addRecomendable(IRecomendable elemento) {
        return almacen.addRecomendable(elemento);
    }
    @Override
    public void addValoracion(IUsuario usuario, IRecomendable elemento, Valoracion valoracion) {
        almacen.addValoracion(usuario, elemento, valoracion);
    }
    @Override
    public boolean haValorado(IUsuario usuario, IRecomendable elemento) {
        return almacen.haValorado(usuario, elemento);
    }
    @Override
    public Collection<IRecomendable> elementosValorados(IUsuario usuario) {
        return almacen.elementosValorados(usuario);
    }
    @Override
    public Valoracion valoracion(IUsuario usuario, IRecomendable elemento) {
        return almacen.valoracion(usuario, elemento);
    }

}