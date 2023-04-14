package valoraciones;

import java.util.*;
import fonoteca.*;

public class AlmacenValoraciones implements IAlmacenValoraciones {
    private List<IRecomendable> recomendables;
    private Map<IUsuario, Map<IRecomendable, Valoracion>> valoraciones;

    public AlmacenValoraciones() {
        valoraciones = new HashMap<>();
        recomendables = new ArrayList<>();
    }

    @Override
    public boolean addUsuario(IUsuario usuario) {
        if (valoraciones.containsKey(usuario)) {
            return false;
        }
        valoraciones.put(usuario, new HashMap<>());
        return true;
    }

    @Override
    public boolean addRecomendable(IRecomendable elemento) {
        if (recomendables.contains(elemento)) {
            return false;
        }
        recomendables.add(elemento);
        for (Map<IRecomendable, Valoracion> valoracion : valoraciones.values()) {
            valoracion.put(elemento, null);
        }
        return true;
    }

    @Override
    public void addValoracion(IUsuario usuario, IRecomendable elemento, Valoracion valoracion) {
        if (!valoraciones.containsKey(usuario)) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        if (!valoraciones.get(usuario).containsKey(elemento)) {
            // Comprueba si elemento es un album y si lo es, añade las canciones
            if (elemento instanceof Album) {
                for (Cancion cancion : ((Album) elemento).getCanciones()) {
                    valoraciones.get(usuario).put(cancion, valoracion);
                }
            }
        } else {
            valoraciones.get(usuario).put(elemento, valoracion);
        }
    }


    @Override
    public boolean haValorado(IUsuario usuario, IRecomendable elemento) {
        if (!valoraciones.containsKey(usuario)) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        if (!valoraciones.get(usuario).containsKey(elemento)) {
            throw new IllegalArgumentException("El elemento no existe");
        }
        return valoraciones.get(usuario).get(elemento) != null;
    }

    @Override
    public Collection<IRecomendable> elementosValorados(IUsuario usuario) {
        if (!valoraciones.containsKey(usuario)) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        Collection<IRecomendable> elementos = new ArrayList<>();
        for (Map.Entry<IRecomendable, Valoracion> valoracion : valoraciones.get(usuario).entrySet()) {
            if (valoracion.getValue() != null) {
                elementos.add(valoracion.getKey());
            }
        }
        return elementos;
    }

    @Override
    public Valoracion valoracion(IUsuario usuario, IRecomendable elemento) {
        if (!valoraciones.containsKey(usuario)) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        if (!valoraciones.get(usuario).containsKey(elemento)) {
            throw new IllegalArgumentException("El elemento no existe");
        }
        return valoraciones.get(usuario).get(elemento);
    }

    public void mostrarValoraciones(IUsuario usuario) {
        if (!valoraciones.containsKey(usuario)) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        Map<IRecomendable, Valoracion> valoracionesUsuario = valoraciones.get(usuario);
        System.out.println("Valoraciones de " + usuario.getId());
        
        for (Map.Entry<IRecomendable, Valoracion> entry : valoracionesUsuario.entrySet()) {
            
            IRecomendable recomendable = entry.getKey();
            Valoracion valoracion = entry.getValue();

            if (valoracion != null) {
                if (recomendable instanceof Cancion) {
                    Cancion cancion = (Cancion) recomendable;
                    System.out.println("CANCION: " + cancion.getTitulo() + " [" + valoracion + "]");
                } else if (recomendable instanceof Album) {
                    Album album = (Album) recomendable;
                    System.out.println("Álbum: " + album.getTitulo() + ", ARTISTA: " + album.getArtista() + ", DURACION: " + album.getMinutos() + ":" + album.getSegundos() + ", ESTILO: "+ album.getEstilo() + " [" + valoracion + "]");
                }
            }
        }
}
    
}