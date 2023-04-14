package tester;

import valoraciones.*;
import java.util.*;
import fonoteca.*;
import excepciones.*;

public class FonotecaTesterValoraciones extends FonotecaTesterErrores{
    public static void main(String[] args) throws ExcepcionFonoteca{
        FonotecaTesterValoraciones main = new FonotecaTesterValoraciones();
        Fonoteca fonoteca = new Fonoteca();
        main.crearMusica(fonoteca);
        main.valoraciones(fonoteca);
    }
    
    public void valoraciones(Fonoteca fonoteca) throws ExcepcionFonoteca{

        try {
        Usuario usuario1 = fonoteca.registrarUsuario("Sonia Melero Vegas", "smelero");
        Usuario usuario2 = fonoteca.registrarUsuario("Miguel Cuevas Alonso", "mcuevas");
        fonoteca.valorar(usuario1, this.canciones[0], Valoracion.DISLIKE);
        fonoteca.valorar(usuario1, this.album1, Valoracion.LIKE);
        fonoteca.valorar(usuario1, this.canciones[3], Valoracion.DISLIKE);
        fonoteca.valorar(usuario2, this.canciones[1], Valoracion.DISLIKE);
        fonoteca.mostrarValoraciones(usuario1);
        fonoteca.mostrarValoraciones(usuario2);
        } catch (ExcepcionFonoteca e) {
            System.err.println(e);
        }
    }

}
