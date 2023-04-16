package fonoteca;

import java.util.*;
import valoraciones.*;

/**
 * Clase que representa un album de musica
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 */
public class Cancion implements IRecomendable{
    private String titulo;
    private int minutos;
    private int segundos;

    /**
     * Constructor de la clase Cancion
     * 
     * @param titulo titulo de la cancion
     * @param minutos minutos de la cancion
     * @param segundos segundos de la cancion
     */
    public Cancion(String titulo, int minutos, int segundos) {
        this.titulo = titulo;
        setDuracion(minutos,segundos);
    }

    /**
     * Metodo que devuelve el titulo de la cancion
     * 
     * @return titulo de la cancion
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo que devuelve los minutos de la cancion
     * 
     * @return minutos de la cancion
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * Metodo que devuelve los segundos de la cancion
     * 
     * @return segundos de la cancion
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * Metodo que establece la duracion de la cancion
     * 
     * @param minutos minutos de la cancion
     * @param segundos segundos de la cancion
     */
    public void setDuracion(int minutos, int segundos) {
        if (minutos < 0 || segundos < 0) {
            this.minutos = 0;
            this.segundos = 0;
        }
        else if (segundos > 59) {
            this.minutos = minutos + segundos / 60;
            this.segundos = segundos % 60;
        }

        else {
            this.minutos = minutos;
            this.segundos = segundos;
        }
    }

    /**
     * Metodo toString de la clase Cancion
     * 
     * @return String con la informacion de la cancion
     */
    @Override
    public String toString() {
        return titulo + " (" + minutos + ":" + String.format("%02d", segundos) + ")";
    }

    @Override
    public String getDescripcion() {
        return "CANCION: " + titulo;
    }

}