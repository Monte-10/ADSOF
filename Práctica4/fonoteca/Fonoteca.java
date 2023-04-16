package fonoteca;

import java.util.*;
import excepciones.*;
import valoraciones.*;

/**
 * Clase que representa una fonoteca
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 */
public class Fonoteca {
    private List<Album> albums;
    private List<ListaMusica> listas;
    // Guarda titulos en forma de String para comprobar que canciones no se repitan
    private ArrayList<String> todasCanciones;
    private AlmacenValoraciones almacenValoraciones;
    private List<IUsuario> usuarios;
    private RecomendadorPopularidad recomendadorPopularidad;
    private RecomendadorAfinidad recomendadorAfinidad;

    /**
     * Constructor de la clase Fonoteca
     */
    public Fonoteca() {
        albums = new ArrayList<>();
        listas = new ArrayList<>();
        todasCanciones = new ArrayList<>();
        almacenValoraciones = new AlmacenValoraciones();
        usuarios = new ArrayList<>();
        this.recomendadorPopularidad = new RecomendadorPopularidad(almacenValoraciones, 0.0);
    }

    /**
     * Constructor de la clase Fonoteca
     * 
     * @param corte corte para el recomendador de popularidad
     */
    public Fonoteca(double corte) {
        albums = new ArrayList<>();
        listas = new ArrayList<>();
        todasCanciones = new ArrayList<>();
        almacenValoraciones = new AlmacenValoraciones();
        usuarios = new ArrayList<>();
        this.recomendadorPopularidad = new RecomendadorPopularidad(almacenValoraciones, corte);
    }

    /**
     * Constructor de la clase Fonoteca
     * 
     * @param recomendadorAfinidad recomendador de afinidad
     */
    public Fonoteca(RecomendadorAfinidad recomendadorAfinidad) {
        albums = new ArrayList<>();
        listas = new ArrayList<>();
        todasCanciones = new ArrayList<>();
        almacenValoraciones = new AlmacenValoraciones();
        usuarios = new ArrayList<>();
        this.recomendadorPopularidad = new RecomendadorPopularidad(almacenValoraciones, 0.0);
        this.recomendadorAfinidad = recomendadorAfinidad;
        recomendadorAfinidad.setAlmacen(almacenValoraciones);
    }

    /**
     * Crea un album y lo añade a la fonoteca
     * 
     * @param titulo titulo del album
     * @param artista artista del album
     * @param estilo estilo del album
     * @param canciones canciones del album
     * 
     * @return album creado
     * 
     * @throws ExcepcionCancionRepetida si la cancion esta repetida
     * @throws ExcepcionFonoteca si el titulo del album es nulo o vacio
     */
    public Album crearAlbum(String titulo, String artista, EstiloMusical estilo, Cancion... canciones) throws ExcepcionCancionRepetida, ExcepcionFonoteca{

        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new ExcepcionFonoteca("El título del álbum no puede ser nulo o vacío.");
            }
            ArrayList<String> copiaTodasCanciones = new ArrayList<>(todasCanciones);
            for (Cancion cancion : canciones) {
                if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                    throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " esta repetida.");
                }
                copiaTodasCanciones.add(cancion.getTitulo());
            }

            Album album = new Album(titulo, artista, estilo, canciones);
            albums.add(album);
            for (Cancion cancion : canciones) {
                todasCanciones.add(cancion.getTitulo());
            }
            return album;
        } catch (ExcepcionCancionRepetida cr) {
            throw cr;
        } catch (ExcepcionFonoteca e) {
            throw e;
        }
    }

    /**
     * Crea un album y lo añade a la fonoteca
     * 
     * @param titulo titulo del album
     * @param artista artista del album
     * @param canciones canciones del album
     * 
     * @return album creado
     * 
     * @throws ExcepcionCancionRepetida si la cancion esta repetida
     * @throws ExcepcionFonoteca si el titulo del album es nulo o vacio
     */
    public Album crearAlbum(String titulo, String artista, Cancion... canciones) throws ExcepcionCancionRepetida, ExcepcionFonoteca{

        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new ExcepcionFonoteca("El título del álbum no puede ser nulo o vacío.");
            }
            ArrayList<String> copiaTodasCanciones = new ArrayList<>(todasCanciones);
            for (Cancion cancion : canciones) {
                if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                    throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " esta repetida.");
                }
                copiaTodasCanciones.add(cancion.getTitulo());
            }

            Album album = new Album(titulo, artista, canciones);
            albums.add(album);
            for (Cancion cancion : canciones) {
                todasCanciones.add(cancion.getTitulo());
            }
            return album;
        } catch (ExcepcionCancionRepetida cr) {
            throw cr;
        } catch (ExcepcionFonoteca e) {
            throw e;
        }
    }

    /**
     * Crea una lista de musica y la añade a la fonoteca
     * 
     * @param titulo titulo de la lista
     * 
     * @return lista de musica creada
     * 
     * @throws ExcepcionCancionRepetida si la canción ya está en la lista
     * @throws ExcepcionFonoteca si la canción está vacía
     */
    public ListaMusica crearListaMusica(String titulo) throws ExcepcionCancionRepetida, ExcepcionFonoteca{
        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new ExcepcionFonoteca("El título de la lista no puede ser nulo o vacío.");
            }
            ListaMusica lista = new ListaMusica(titulo);
            listas.add(lista);
            return lista;
        } catch (ExcepcionFonoteca e) {
            throw e;
        }
    }

    /**
     * Añade canciones a una lista de musica
     * 
     * @param lista lista de musica
     * @param canciones canciones a añadir
     * 
     * @return lista de musica con las canciones añadidas
     * 
     * @throws ExcepcionCancionRepetida si la canción ya está en la lista
     * @throws ExcepcionFonoteca si la canción está vacía
     */
    public Fonoteca aniadirMusicaALista(ListaMusica lista, Cancion[] canciones) throws ExcepcionCancionRepetida, ExcepcionFonoteca{
        try {
            if (canciones == null) {
                throw new ExcepcionFonoteca("La canción está vacía.");
            }
            ArrayList<String> copiaTodasCanciones = new ArrayList<>(todasCanciones);
            for (Cancion cancion : canciones) {
                if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                    throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " esta repetida.");
                }
                copiaTodasCanciones.add(cancion.getTitulo());
            }
            for (Cancion cancion : canciones) {
                todasCanciones.add(cancion.getTitulo());
            }
            List<Cancion> listaCanciones = Arrays.asList(canciones);
            lista.addElemento(listaCanciones);
            return this;
        } catch (ExcepcionCancionRepetida cr) {
            throw cr;
        } catch (ExcepcionFonoteca e) {
            throw e;
        }
    }

    /**
     * Añade una cancion a una lista de musica
     * 
     * @param lista lista de musica
     * @param cancion cancion a añadir
     * 
     * @return lista de musica con la cancion añadida
     * 
     * @throws ExcepcionCancionRepetida
     * @throws ExcepcionFonoteca
     */
    public Fonoteca aniadirMusicaALista(ListaMusica lista, Cancion cancion) throws ExcepcionCancionRepetida, ExcepcionFonoteca{
        try {
            if (cancion == null) {
                throw new ExcepcionFonoteca("La canción está vacía.");
            }
            if (todasCanciones.contains(cancion.getTitulo())) {
                throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " esta repetida.");
            }
            todasCanciones.add(cancion.getTitulo());
            lista.addElemento(cancion);
            return this;
        } catch (ExcepcionCancionRepetida cr) {
            throw cr;
        } catch (ExcepcionFonoteca e) {
            throw e;
        }
    }

    /**
     * Añade un album a una lista de musica
     * 
     * @param lista lista de musica
     * @param album album a añadir
     * 
     * @return lista de musica con el album añadido
     * 
     * @throws ExcepcionCancionRepetida
     * @throws ExcepcionFonoteca
     */
    public Fonoteca aniadirMusicaALista(ListaMusica lista, Album album) throws ExcepcionCancionRepetida, ExcepcionFonoteca {
        try {
            if (album == null) {
                throw new ExcepcionFonoteca("El álbum está vacío.");
            }
            lista.addElemento(album);
            return this;
        } catch (ExcepcionFonoteca e) {
            throw e;
        }
    }

    /**
     * Añade una lista de musica a una lista de musica
     * 
     * @param lista lista de musica
     * @param listaMusica lista de musica a añadir
     * 
     * @return lista de musica con la lista de musica añadida
     * 
     * @throws ExcepcionCancionRepetida
     * @throws ExcepcionFonoteca
     */
    public Fonoteca aniadirMusicaALista(ListaMusica lista, ListaMusica listaMusica) throws ExcepcionCancionRepetida, ExcepcionFonoteca{
        try {
            ArrayList<String> copiaTodasCanciones = new ArrayList<>(todasCanciones);
            if (listaMusica == null) {
                throw new ExcepcionFonoteca("La lista de música está vacía.");
            }
            for (Object elemento : listaMusica.getElementos()) {
                if (elemento instanceof Cancion) {
                    Cancion cancion = (Cancion) elemento;
                    if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                        throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " esta repetida.");
                    }
                    copiaTodasCanciones.add(cancion.getTitulo());
                }
                else if (elemento instanceof Album) {
                    Album album = (Album) elemento;
                    for (Cancion cancion : album.getCanciones()) {
                        if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                            throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " esta repetida.");
                        }
                        copiaTodasCanciones.add(cancion.getTitulo());
                    }
                }
            }
            todasCanciones = copiaTodasCanciones;
            lista.addElemento(listaMusica);
            return this;
        } catch (ExcepcionCancionRepetida cr) {
            throw cr;
        } catch (ExcepcionFonoteca e) {
            throw e;
        }
    }
    
    /**
     * Obtiene el titulo de una cancion
     * 
     * @param cancion cancion
     * 
     * @return titulo de la cancion
     */
    public String getTituloCancion(Cancion cancion) {
        return cancion.getTitulo();
    }

    /**
     * Muestra el contenido de la fonoteca
     */
    public void mostrar() {
        for (Album album : albums) {
            System.out.println(album);
            System.out.println("--------------\n");
        }

        for (ListaMusica lista : listas) {
            System.out.println(lista);
            System.out.println("--------------\n");
        }
    }

    /**
     * Registra un usuario en la fonoteca
     * 
     * @param nombre nombre del usuario
     * @param id id del usuario
     * 
     * @return usuario registrado
     */
    public Usuario registrarUsuario(String nombre, String id) {
        Usuario usuario = new Usuario(nombre, id);
        usuarios.add(usuario);
        this.almacenValoraciones.addUsuario(usuario);
        return usuario;
    }

    /**
     * Valora un elemento de la fonoteca
     * 
     * @param usuario usuario que valora
     * @param elemento elemento a valorar
     * @param valoracion valoracion
     * 
     * @throws ExcepcionFonoteca si el usuario no está registrado
     */
    public void valorar(IUsuario usuario, IRecomendable elemento, Valoracion valoracion) throws ExcepcionFonoteca{
        if (usuarios.contains(usuario)) {
            this.almacenValoraciones.addRecomendable(elemento);
            this.almacenValoraciones.addValoracion(usuario, elemento, valoracion);
        }

        else {
            throw new ExcepcionFonoteca("El usuario no está registrado.");
        }
    }

    /**
     * Muestra las valoraciones de un usuario
     * 
     * @param usuario usuario
     */
    public void mostrarValoraciones(IUsuario usuario) {
        this.almacenValoraciones.mostrarValoraciones(usuario);
    }

    /**
     * Muestra las recomendaciones de un usuario
     * 
     * @param usuario usuario
     */
    public void mostrarRecomendaciones(IUsuario usuario) {
        Collection<Recomendacion> recomendaciones = this.recomendadorPopularidad.getRecomendaciones(usuario);
        Collection<Recomendacion> recomendaciones2 = this.recomendadorAfinidad.getRecomendaciones(usuario);

        System.out.println("RECOMENDACIONES PARA: " + usuario.getId());

        for (Recomendacion recomendacion : recomendaciones) {
            System.out.println(recomendacion);
        }

        for (Recomendacion recomendacion : recomendaciones2) {
            System.out.println(recomendacion);
        }
    }

    /**
     * Obtiene el almacen de valoraciones
     * 
     * @return almacen de valoraciones
     */
    public AlmacenValoraciones getAlmacenValoraciones() {
        return almacenValoraciones;
    }
}