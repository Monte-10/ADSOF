package valoraciones;

import java.util.*;
import fonoteca.*;

public class AlmacenValoraciones implements IAlmacenValoraciones {
    private List<IRecomendable> recomendables;
    private Map<IUsuario, Map<IRecomendable, Valoracion>> valoraciones;

    public AlmacenValoraciones() {
        valoraciones = new LinkedHashMap<>();
        recomendables = new ArrayList<>();
    }

    public List<IRecomendable> getRecomendables() {
        return this.recomendables;
    }

    @Override
    public boolean addUsuario(IUsuario usuario) {
        if (valoraciones.containsKey(usuario)) {
            return false;
        }
        valoraciones.put(usuario, new LinkedHashMap<>());
        return true;
    }

    @Override
    public boolean addRecomendable(IRecomendable elemento) {
        if (recomendables.contains(elemento)) {
            return false;
        }
        recomendables.add(elemento);
        if (elemento instanceof Album) {
            Album album = (Album) elemento;
            for (Cancion cancion : album.getCanciones()) {
                recomendables.add(cancion);
            }
        }
        else {
            Cancion cancion = (Cancion) elemento;
            recomendables.add(cancion);
        }
        return true;
    }

    @Override
    public void addValoracion(IUsuario usuario, IRecomendable elemento, Valoracion valoracion) {
        // System.out.println("Añadiendo valoración " + valoracion + " de " + usuario + " a " + elemento);
        if (!valoraciones.containsKey(usuario)) {
            throw new IllegalArgumentException("El usuario no existe");
        }

        addRecomendable(elemento);

        if (!recomendables.contains(elemento)) {
            throw new IllegalArgumentException("El elemento no existe");
        }
        
        if (elemento instanceof Album) {
            Album album = (Album) elemento;
            valoraciones.get(usuario).put(album, valoracion);
            for (Cancion cancion : album.getCanciones()) {
                // System.out.println("ESTA CANCION? " + cancion.getTitulo());
                if (!valoraciones.get(usuario).containsKey(cancion)) {
                    // System.out.println("Añadiendo canción " + cancion.getTitulo());
                    valoraciones.get(usuario).put(cancion, valoracion);
                }
            }
        }
        else {
            // System.out.println("Añadiendo canción " + elemento);
            valoraciones.get(usuario).put(elemento, valoracion);
        }
    }


    @Override
    public boolean haValorado(IUsuario usuario, IRecomendable elemento) {
        if (!valoraciones.containsKey(usuario)) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        if (!valoraciones.get(usuario).containsKey(elemento)) {
            return false;
        }
        if (valoraciones.get(usuario).get(elemento) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Collection<IRecomendable> elementosValorados(IUsuario usuario) {
        if (!valoraciones.containsKey(usuario)) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        
        Collection<IRecomendable> elementos = new LinkedHashSet<>();

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
        
        Collection<IRecomendable> elem = elementosValorados(usuario);

        for (IRecomendable recomendable : elem) {
            if (recomendable instanceof Cancion) {
                Cancion cancion = (Cancion) recomendable;
                System.out.println("CANCION: " + cancion.getTitulo() + " [" + valoracion(usuario, cancion) + "]");
            } else if (recomendable instanceof Album) {
                Album album = (Album) recomendable;
                System.out.println("ALBUM: " + album.getTitulo() + ", ARTISTA: " + album.getArtista() + ", DURACION: " + album.getMinutos() + ":" + album.getSegundos() + ", ESTILO: "+ album.getEstilo() + " [" + valoracion(usuario, album) + "]");
            }
        }
    }

    public double getValoracionMedia(IRecomendable elemento) {
        double suma = 0;
        int numUsuarios = valoraciones.size();
        for (Map<IRecomendable, Valoracion> valoracionesUsuario : valoraciones.values()) {
            if (valoracionesUsuario.containsKey(elemento)) {
                Valoracion valoracion = valoracionesUsuario.get(elemento);
                if (valoracion != null) {
                    if (valoracion == Valoracion.LIKE) {
                        suma += 1;
                    }
                    else if (valoracion == Valoracion.DISLIKE) {
                        suma -= 0.5;
                    }
                }
            }
        }
        double media = suma / numUsuarios;
        media = Math.round(media * 100.0) / 100.0;
        return media;
    }

    
    public double getValoracionMediaAfinidad(IUsuario usuario, IUsuario usuario2) {
        double suma = 0;
        int numUsuarios = valoraciones.size();

        for (Map.Entry<IRecomendable, Valoracion> valoracion : valoraciones.get(usuario).entrySet()) {
            System.out.println("VALORACION: " + valoracion.getKey() + " [" + valoracion.getValue() + "]");
            if (valoracion.getValue() != null) {
                if (valoraciones.get(usuario2).containsKey(valoracion.getKey()) && valoraciones.get(usuario2).get(valoracion.getKey()) != null) {
                    if (valoracion.getValue() == valoraciones.get(usuario2).get(valoracion.getKey()) && valoracion.getValue() == Valoracion.LIKE) {
                        System.out.println("A " + usuario.getId() + " le gusta " + valoracion.getKey() + " y a " + usuario2.getId() + " también");
                        suma += 1;
                    }
                    else if (valoracion.getValue() == valoraciones.get(usuario2).get(valoracion.getKey()) && valoracion.getValue() == Valoracion.DISLIKE) {
                        System.out.println("A " + usuario.getId() + " no le gusta " + valoracion.getKey() + " y a " + usuario2.getId() + " tampoco");
                        suma += 0.5;
                    }
                    else if (valoracion.getValue() != valoraciones.get(usuario2).get(valoracion.getKey())) {
                        System.out.println("A " + usuario.getId() + " le gusta " + valoracion.getKey() + " y a " + usuario2.getId() + " no");
                        suma -= 0.5;
                    }
                }
            }
        }
        System.out.println("Suma: " + suma);
        double media = suma / numUsuarios;
        System.out.println("Media: " + media);
        media = Math.round(media * 100.0) / 100.0;

        return media;
    }

    public Collection<IUsuario> getUsuarios() {
        return valoraciones.keySet();
    }

}