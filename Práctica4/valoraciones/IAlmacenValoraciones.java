package valoraciones;

import java.util.*;

public interface IAlmacenValoraciones {
    boolean addUsuario(IUsuario usuario);
    boolean addRecomendable(IRecomendable elemento);
    void addValoracion(IUsuario usuario, IRecomendable elemento, Valoracion valoracion);
    boolean haValorado(IUsuario usuario, IRecomendable elemento);
    Collection<IRecomendable> elementosValorados(IUsuario usuario);
    Valoracion valoracion(IUsuario usuario, IRecomendable elemento);
}