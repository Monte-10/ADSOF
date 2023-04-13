package tester;

import fonoteca.*;
import excepciones.*;

public class FonotecaTesterErrores {
    protected Album album1; // protected porque extenderemos esta clase en los próximos apartados
    protected Cancion[] canciones ={ 
        new Cancion("Radio ga ga", 5, 48),
        new Cancion("Tear it up", 3, 28),
        new Cancion("It's a hard life", 4, 8),
        new Cancion("Resistire", 4, 4),
        new Cancion("Dos corazones", 3, 6)
    };
    
    public static void main(String[] args) throws ExcepcionFonoteca {
        FonotecaTesterErrores main = new FonotecaTesterErrores();
        Fonoteca fonoteca = new Fonoteca();
        main.crearMusica(fonoteca);
        fonoteca.mostrar();
    }
    
    public void crearMusica(Fonoteca fonoteca) throws ExcepcionFonoteca {
        try {
            this.album1 = fonoteca.crearAlbum("The Works", "Queen", EstiloMusical.ROCK, canciones[0], canciones[1], canciones[2]);
            fonoteca.crearAlbum("Resistire", "Duo dinamico",canciones[3], new Cancion("Resistire", 4, 4)); // cancion repetida
        } catch (ExcepcionCancionRepetida cr) {
            System.err.println(cr);
        }
        
        ListaMusica favoritas = fonoteca.crearListaMusica("Mis favoritas");
        
        try {
            fonoteca.aniadirMusicaALista(favoritas, album1).aniadirMusicaALista(favoritas, canciones[1]);
        } catch (ExcepcionFonoteca e) {
            System.err.println(e);
        }
    }
}
