package valoraciones;

import java.util.*;

public interface IRecomendador extends IAlmacenValoraciones {
    Collection<Recomendacion> getRecomendaciones(IUsuario usuario);
    void setCorte(double corte);
}