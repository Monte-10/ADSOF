package fonoteca;

import java.util.*;
import excepciones.*;

public class Fonoteca {
    private List<Album> albums;
    private List<ListaMusica> listas;
    // Guarda titulos en forma de String para comprobar que canciones no se repitan
    private ArrayList<String> todasCanciones;

    public Fonoteca() {
        albums = new ArrayList<>();
        listas = new ArrayList<>();
        todasCanciones = new ArrayList<>();
    }

    public Album crearAlbum(String titulo, String artista, EstiloMusical estilo, Cancion... canciones) throws ExcepcionCancionRepetida, ExcepcionFonoteca{

        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new ExcepcionFonoteca("El título del álbum no puede ser nulo o vacío.");
            }
            ArrayList<String> copiaTodasCanciones = new ArrayList<>(todasCanciones);
            for (Cancion cancion : canciones) {
                if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                    throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " ya existe.");
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

    public Album crearAlbum(String titulo, String artista, Cancion... canciones) throws ExcepcionCancionRepetida, ExcepcionFonoteca{

        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new ExcepcionFonoteca("El título del álbum no puede ser nulo o vacío.");
            }
            ArrayList<String> copiaTodasCanciones = new ArrayList<>(todasCanciones);
            for (Cancion cancion : canciones) {
                if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                    throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " ya existe.");
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

    public ListaMusica crearListaMusica(String titulo) throws ExcepcionCancionRepetida, ExcepcionFonoteca{
        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new ExcepcionFonoteca("El título de la lista de música no puede ser nulo o vacío.");
            }
            ArrayList<String> copiaTodasCanciones = new ArrayList<>(todasCanciones);
            for (ListaMusica lista : listas) {
                if (lista.getTitulo().equals(titulo)) {
                    throw new ExcepcionFonoteca("La lista de música " + titulo + " ya existe.");
                }

                for (Object elemento : lista.getElementos()) {
                    if (elemento instanceof Cancion) {
                        Cancion cancion = (Cancion) elemento;
                        if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                            throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " ya existe.");
                        }
                        copiaTodasCanciones.add(cancion.getTitulo());
                    }
                    else if (elemento instanceof Album) {
                        Album album = (Album) elemento;
                        for (Cancion cancion : album.getCanciones()) {
                            if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                                throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " ya existe.");
                            }
                            copiaTodasCanciones.add(cancion.getTitulo());
                        }
                    }
                    else if (elemento instanceof ListaMusica) {
                        ListaMusica listaMusica = (ListaMusica) elemento;
                        for (Object elementoLista : listaMusica.getElementos()) {
                            if (elementoLista instanceof Cancion) {
                                Cancion cancion = (Cancion) elementoLista;
                                if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                                    throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " ya existe.");
                                }
                                copiaTodasCanciones.add(cancion.getTitulo());
                            }
                            else if (elementoLista instanceof Album) {
                                Album album = (Album) elementoLista;
                                for (Cancion cancion : album.getCanciones()) {
                                    if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                                        throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " ya existe.");
                                    }
                                    copiaTodasCanciones.add(cancion.getTitulo());
                                }
                            }
                        }
                    }
                }
            }

            todasCanciones = copiaTodasCanciones;
            ListaMusica lista = new ListaMusica(titulo);
            listas.add(lista);
            return lista;
        } catch (ExcepcionCancionRepetida cr) {
            throw cr;
        } catch (ExcepcionFonoteca e) {
            throw e;
        }
    }

    public Fonoteca aniadirMusicaALista(ListaMusica lista, Cancion[] canciones) throws ExcepcionCancionRepetida, ExcepcionFonoteca{
        try {
            if (canciones == null) {
                throw new ExcepcionFonoteca("La canción está vacía.");
            }
            ArrayList<String> copiaTodasCanciones = new ArrayList<>(todasCanciones);
            for (Cancion cancion : canciones) {
                if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                    throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " ya existe.");
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

    public Fonoteca aniadirMusicaALista(ListaMusica lista, Cancion cancion) throws ExcepcionCancionRepetida, ExcepcionFonoteca{
        try {
            if (cancion == null) {
                throw new ExcepcionFonoteca("La canción está vacía.");
            }
            if (todasCanciones.contains(cancion.getTitulo())) {
                throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " ya existe.");
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

    public Fonoteca aniadirMusicaALista(ListaMusica lista, Album album) throws ExcepcionCancionRepetida, ExcepcionFonoteca{
        try {
            if (album == null) {
                throw new ExcepcionFonoteca("El álbum está vacío.");
            }
            ArrayList<String> copiaTodasCanciones = new ArrayList<>(todasCanciones);
            for (Cancion cancion : album.getCanciones()) {
                if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                    throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " ya existe.");
                }
                copiaTodasCanciones.add(cancion.getTitulo());
            }
            for (Cancion cancion : album.getCanciones()) {
                todasCanciones.add(cancion.getTitulo());
            }
            lista.addElemento(album);
            return this;
        } catch (ExcepcionCancionRepetida cr) {
            throw cr;
        } catch (ExcepcionFonoteca e) {
            throw e;
        }
    }

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
                        throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " ya existe.");
                    }
                    copiaTodasCanciones.add(cancion.getTitulo());
                }
                else if (elemento instanceof Album) {
                    Album album = (Album) elemento;
                    for (Cancion cancion : album.getCanciones()) {
                        if (copiaTodasCanciones.contains(cancion.getTitulo())) {
                            throw new ExcepcionCancionRepetida("La canción " + cancion.getTitulo() + " ya existe.");
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
    
    public String getTituloCancion(Cancion cancion) {
        return cancion.getTitulo();
    }

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
}