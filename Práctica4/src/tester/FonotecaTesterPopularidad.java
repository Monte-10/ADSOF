package tester;

import fonoteca.*;
import valoraciones.*;
import excepciones.*;

public class FonotecaTesterPopularidad extends FonotecaTesterErrores {
    private Album album2;
    public static void main(String[] args) {
        FonotecaTesterPopularidad main = new FonotecaTesterPopularidad();
        Fonoteca fonoteca = new Fonoteca(0.4); // corte 0.4 para el recomendador
        main.crearMusica(fonoteca);
        main.recomendaciones(fonoteca);
    }
    public void crearMusica(Fonoteca fonoteca) {
        try {
            super.crearMusica(fonoteca);
            this.album2 = fonoteca.crearAlbum("Resistire", "Duo dinamico", canciones[3], canciones[4]);
        } catch (ExcepcionCancionRepetida e) {
            e.printStackTrace();
        } catch (ExcepcionFonoteca e) {
            System.out.println(e);
        }
    }
    protected void recomendaciones(Fonoteca fonoteca) {
        try {
        Usuario[] usuarios = { fonoteca.registrarUsuario("Sonia Melero Vegas", "smelero"),
            fonoteca.registrarUsuario("Miguel Cuevas Alonso", "mcuevas"),
            fonoteca.registrarUsuario("Lucas Varas Peinado", "lvaras")};
        fonoteca.valorar(usuarios[0], album1, Valoracion.LIKE);
        fonoteca.valorar(usuarios[0], canciones[3], Valoracion.LIKE);
        fonoteca.valorar(usuarios[1], canciones[0], Valoracion.LIKE);
        fonoteca.valorar(usuarios[1], canciones[1], Valoracion.LIKE);
        fonoteca.valorar(usuarios[1], album2, Valoracion.LIKE);
        fonoteca.valorar(usuarios[2], canciones[2], Valoracion.LIKE);
        fonoteca.valorar(usuarios[2], canciones[3], Valoracion.LIKE);
        fonoteca.valorar(usuarios[2], canciones[1], Valoracion.DISLIKE);
        for (Usuario u: usuarios) {
            System.out.println("---------------------------");
            fonoteca.mostrarRecomendaciones(u);
        }
        } catch (ExcepcionFonoteca e) {
            e.printStackTrace();
        }
    }
}
