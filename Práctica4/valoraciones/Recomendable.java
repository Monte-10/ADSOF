package valoraciones;

import java.util.*;
import fonoteca.*;
import excepciones.*;

public class Recomendable implements IRecomendable{
    private String descripcion;
    private Valoracion valoracion;

    public Recomendable(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }
}