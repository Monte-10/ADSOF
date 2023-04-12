package fonoteca;

import java.util.*;

public class Fonoteca {
    private List<Album> albums;
    private List<ListaMusica> listas;

    public Fonoteca() {
        albums = new ArrayList<>();
        listas = new ArrayList<>();
    }

    public Album crearAlbum(String titulo, String artista, EstiloMusical estilo, Cancion... canciones) {

        if (canciones.length == 0) {
            return null;
        }

        Album album = new Album(titulo, artista, estilo, canciones);
        albums.add(album);
        return album;
    }

    public Album crearAlbum(String titulo, String artista, Cancion... canciones) {

        if (canciones.length == 0) {
            return null;
        }

        Album album = new Album(titulo, artista, canciones);
        albums.add(album);
        return album;
    }

    public ListaMusica crearListaMusica(String titulo) {
        ListaMusica lista = new ListaMusica(titulo);
        listas.add(lista);
        return lista;
    }

    public Fonoteca aniadirMusicaALista(ListaMusica lista, Cancion[] canciones) {
        if (canciones.length == 0) {
            System.out.println("La lista de canciones está vacía.");
            return this;
        }
    
        List<Cancion> listaCanciones = Arrays.asList(canciones);
        lista.addElemento(listaCanciones);
        return this;
    }

    public Fonoteca aniadirMusicaALista(ListaMusica lista, Cancion cancion) {
        if (cancion == null) {
            System.out.println("La canción está vacía.");
            return this;
        }
    
        lista.addElemento(cancion);
        return this;
    }

    public Fonoteca aniadirMusicaALista(ListaMusica lista, Album album) {
        if (album == null) {
            System.out.println("El album está vacío.");
            return this;
        }
    
        lista.addElemento(album);
        return this;
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