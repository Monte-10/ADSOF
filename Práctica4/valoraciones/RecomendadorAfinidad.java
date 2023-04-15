package valoraciones;

import java.util.*;
import fonoteca.*;

public class RecomendadorAfinidad implements IRecomendador {
    double corte;
    AlmacenValoraciones almacen;

    public RecomendadorAfinidad(double corte) {
        this.corte = corte;
    }

    public Collection<Recomendacion> getRecomendaciones(IUsuario usuario) {
        
        Collection<Recomendacion> recomendaciones = new TreeSet<Recomendacion>(java.util.Collections.reverseOrder());
        Collection<IUsuario> usuarios = almacen.getUsuarios();

        for (IUsuario usuario2 : usuarios) {
            if (usuario.getId() != usuario2.getId()) {
                double afinidad = almacen.getValoracionMediaAfinidad(usuario, usuario2);
                if (afinidad >= corte) {
                    Collection<IRecomendable> elementos = almacen.getRecomendables();
                    for (IRecomendable elemento : elementos) {
                        if (!almacen.haValorado(usuario, elemento) && almacen.haValorado(usuario2, elemento)) {
                            if (almacen.valoracion(usuario2, elemento) == Valoracion.LIKE) {
                                Recomendacion recomendacion = new Recomendacion(elemento, afinidad);
                                recomendaciones.add(recomendacion);
                            }
                        }
                    }
                }
            }
        }
        return recomendaciones;
    }

    public void setCorte(double corte) {
        this.corte = corte;
    }

    public void setAlmacen(AlmacenValoraciones almacen) {
        this.almacen = almacen;
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