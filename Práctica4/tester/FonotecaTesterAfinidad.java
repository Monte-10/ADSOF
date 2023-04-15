package tester;

import fonoteca.*;
import valoraciones.*;
import excepciones.*;
import java.util.*;

public class FonotecaTesterAfinidad extends FonotecaTesterPopularidad {
    public static void main(String[] args) {
        FonotecaTesterAfinidad main = new FonotecaTesterAfinidad();
        Fonoteca fonoteca = new Fonoteca(new RecomendadorAfinidad(0.2)); // Con rec. afinidad de corte 0.2
        main.crearMusica(fonoteca);
        main.recomendaciones(fonoteca);
    }
}
