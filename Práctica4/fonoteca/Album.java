package fonoteca;

import java.util.*;
import valoraciones.*;

public class Album implements IRecomendable{
    private String titulo;
    private String artista;
    private final ArrayList<Cancion> canciones;
    private EstiloMusical estilo;
    private int minutos;
    private int segundos;

    Album(String titulo, String artista, EstiloMusical estilo, Cancion... canciones) {
        this.titulo = titulo;
        this.artista = artista;
        this.estilo = estilo;
        this.canciones = new ArrayList<Cancion>(Arrays.asList(canciones));
        setDuracion(canciones);
    }

    Album(String titulo, String artista, Cancion... canciones) {
        this.titulo = titulo;
        this.artista = artista;
        this.canciones = new ArrayList<Cancion>(Arrays.asList(canciones));
        setDuracion(canciones);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public EstiloMusical getEstilo() {
        return estilo;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setDuracion(Cancion... canciones) {
        minutos = 0;
        segundos = 0;
        for (Cancion cancion : canciones) {
            minutos += cancion.getMinutos();
            segundos += cancion.getSegundos();
        }
        if (segundos > 59) {
            minutos += segundos / 60;
            segundos = segundos % 60;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ALBUM: ").append(titulo).append(", ARTISTA: ").append(artista).append(", DURACION: ").append(getMinutos()).append(":").append(String.format("%02d", getSegundos()));
        if (estilo != null) {
            sb.append(", ESTILO: ").append(estilo);
        } else {
            sb.append(", ESTILO: SIN ESTILO");
        }
        sb.append("\n");
        int i = 1;
        for (Cancion cancion : canciones) {
            sb.append("\t").append(i++).append(".").append(cancion.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getDescripcion() {
        return "ALBUM: " + titulo;
    }


}