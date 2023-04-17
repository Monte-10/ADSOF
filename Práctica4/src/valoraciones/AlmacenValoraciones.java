package valoraciones;

import java.util.*;
import fonoteca.*;

/**
 * Clase que representa un almacen de valoraciones
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 */
public class AlmacenValoraciones implements IAlmacenValoraciones {
    private List<IRecomendable> recomendables;
    private Map<IUsuario, Map<IRecomendable, Valoracion>> valoraciones;

    /**
     * Constructor de la clase AlmacenValoraciones
     * 
     */
    public AlmacenValoraciones() {
        valoraciones = new LinkedHashMap<>();
        recomendables = new ArrayList<>();
    }

    /**
     * Metodo que devuelve las valoraciones del almacen
     * 
     * @return valoraciones guardadas en el almacen
     */
    public List<IRecomendable> getRecomendables() {
        return this.recomendables;
    }

    /**
     * Metodo que añade un usuario al almacen
     * 
     * @param usuario usuario a añadir
     * 
     * @return true si se ha añadido correctamente, false en caso contrario
     */
    @Override
    public boolean addUsuario(IUsuario usuario) {
        if (valoraciones.containsKey(usuario)) {
            return false;
        }
        valoraciones.put(usuario, new LinkedHashMap<>());
        return true;
    }

    /**
     * Metodo que añaade un recomendable al almacen
     * 
     * @param elemento elemento a añadir
     * 
     * @return true si se ha añadido correctamente, false en caso contrario
     */
    @Override
    public boolean addRecomendable(IRecomendable elemento) {
        if (recomendables.contains(elemento)) {
            return false;
        }
        recomendables.add(elemento);
        if (elemento instanceof Album) {
            Album album = (Album) elemento;
            for (Cancion cancion : album.getCanciones()) {
                if (!recomendables.contains(cancion)) {
                    recomendables.add(cancion);
                }
                
            }
        }
       
        return true;
    }

    /**
     * Metodo que añade una valoracion a un usuario
     * 
     * @param usuario usuario al que se le añade la valoracion
     * @param elemento elemento valorado
     * @param valoracion valoracion del elemento
     * 
     * @throws IllegalArgumentException si el usuario no existe
     * @throws IllegalArgumentException si el elemento no existe
     */
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

    /**
     * Metodo que devuelve si un usuario ha valorado un elemento
     * 
     * @param usuario usuario que se quiere comprobar
     * @param elemento elemento que se quiere comprobar
     * 
     * @return true si el usuario ha valorado el elemento, false en caso contrario
     * 
     * @throws IllegalArgumentException si el usuario no existe
     */
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

    /**
     * Metodo que devuelve los elementos valorados por un usuario
     * 
     * @param usuario usuario del que se quieren obtener los elementos valorados
     * 
     * @return elementos valorados por el usuario
     * 
     * @throws IllegalArgumentException si el usuario no existe
     */
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
    
    /**
     * Metodo que devuelve las valoraciones de un usuario
     * 
     * @param usuario usuario del que se quieren obtener las valoraciones
     * @param elemento elemento valorado
     * 
     * @return valoraciones del usuario
     * 
     * @throws IllegalArgumentException si el usuario no existe
     */
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

    /**
     * Metodo que muestra las valoraciones de un usuario
     * 
     * @param usuario usuario del que se quieren obtener las valoraciones
     * 
     * @throws IllegalArgumentException si el usuario no existe
     */
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

    /**
     * Metodo que devuelve la valoracion media de un elemento
     * 
     * @param elemento elemento del que se quiere obtener la valoracion media
     * 
     * @return valoracion media del elemento
     */
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

    /**
     * Metodo que devuelve la valoracion media de afinidad entre dos usuarios
     * 
     * @param usuario usuario del que se quiere obtener la valoracion media
     * @param usuario2 usuario del que se quiere obtener la valoracion media
     * 
     * @return valoracion media de afinidad entre los dos usuarios
     */
    public double getValoracionMediaAfinidad(IUsuario usuario, IUsuario usuario2) {
        double suma = 0;
        
        int numUsuarios = valoraciones.size();

        for (Map.Entry<IRecomendable, Valoracion> valoracion : valoraciones.get(usuario).entrySet()) {
            if (valoracion.getValue() != null) {
                if (valoraciones.get(usuario2).containsKey(valoracion.getKey()) && valoraciones.get(usuario2).get(valoracion.getKey()) != null) {
                    if (valoracion.getValue() == valoraciones.get(usuario2).get(valoracion.getKey()) && valoracion.getValue() == Valoracion.LIKE) {
                        suma += 1;
                        
                    }
                    else if (valoracion.getValue() == valoraciones.get(usuario2).get(valoracion.getKey()) && valoracion.getValue() == Valoracion.DISLIKE) {
                        suma += 0.5;
                        
                    }
                    else if (valoracion.getValue() != valoraciones.get(usuario2).get(valoracion.getKey())) {
                        suma -= 0.5;
                        
                    }
                    
                }
                  
            }
            
        }

        
        

        return suma;
    }

    /**
     * Método que devuelve los usuarios del almacen
     * 
     * @return usuarios del almacen
     */
    public Collection<IUsuario> getUsuarios() {
        return valoraciones.keySet();
    }

}