package fonoteca;

import java.util.*;

public class Cancion {
    private String titulo;
    private int minutos;
    private int segundos;

    public Cancion(String titulo, int minutos, int segundos) {
        this.titulo = titulo;
        setDuracion(minutos,segundos);
    }

    public String getTitulo() {
        return titulo;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

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

    @Override
    public String toString() {
        return titulo + " (" + minutos + ":" + String.format("%02d", segundos) + ")";
    }
}