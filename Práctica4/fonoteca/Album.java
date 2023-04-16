package fonoteca;

import java.util.*;
import valoraciones.*;

/**
 * Clase que representa un album de musica
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 */
public class Album implements IRecomendable{
    private String titulo;
    private String artista;
    private final ArrayList<Cancion> canciones;
    private EstiloMusical estilo;
    private int minutos;
    private int segundos;

    /**
     * Constructor de la clase Album
     * 
     * @param titulo titulo del album
     * @param artista artista del album
     * @param estilo estilo del album
     * @param canciones canciones del album
     */
    Album(String titulo, String artista, EstiloMusical estilo, Cancion... canciones) {
        this.titulo = titulo;
        this.artista = artista;
        this.estilo = estilo;
        this.canciones = new ArrayList<Cancion>(Arrays.asList(canciones));
        setDuracion(canciones);
    }

    /**
     * Constructor de la clase Album
     * 
     * @param titulo titulo del album
     * @param artista artista del album
     * @param canciones canciones del album
     */
    Album(String titulo, String artista, Cancion... canciones) {
        this.titulo = titulo;
        this.artista = artista;
        this.canciones = new ArrayList<Cancion>(Arrays.asList(canciones));
        setDuracion(canciones);
    }

    /**
     * Metodo que devuelve el titulo del album
     * 
     * @return titulo del album
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo que devuelve el artista del album
     * 
     * @return artista del album
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Metodo que devuelve el estilo del album
     * 
     * @return estilo del album
     */
    public EstiloMusical getEstilo() {
        return estilo;
    }

    /**
     * Metodo que devuelve la duracion de minutos del album
     * 
     * @return duracion del album
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * Metodo que devuelve la duracion de segundos del album
     * 
     * @return duracion del album
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * Metodo que devuelve las canciones del album
     * 
     * @return canciones del album
     */
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Metodo que modifica el titulo del album
     * 
     * @param titulo nuevo titulo del album
     */
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

    /**
     * Metodo que devuelve toString del album
     * 
     * @return toString del album
     */
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

    /**
     * Metodo que devuelve la descripcion del album
     * 
     * @return descripcion del album
     */
    @Override
    public String getDescripcion() {
        return "ALBUM: " + titulo;
    }


}