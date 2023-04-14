package fonoteca;

import java.util.*;
import valoraciones.*;

public class ListaMusica implements IRecomendable{
    private String titulo;
    private List<Object> elementos;
    private int minutos;
    private int segundos;

    ListaMusica(String titulo) {
        this.titulo = titulo;
        elementos = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Object> getElementos() {
        return elementos;
    }

    void setElementos(List<Object> elementos) {
        this.elementos = elementos;
        setDuracion();
    }

    void addElemento(Cancion cancion) {
        elementos.add(cancion);
        setDuracion();
    }

    void addElemento(List<Cancion> canciones) {
        elementos.addAll(canciones);
        setDuracion();
    }

    void addElemento(Album album) {
        elementos.add(album);
        setDuracion();
    }

    void addElemento(ListaMusica lista) {
        elementos.add(lista);
        setDuracion();
    }

    public int setDuracion() {
        minutos = 0;
        segundos = 0;
        for (Object elemento : elementos) {
            if (elemento instanceof Cancion) {
                Cancion cancion = (Cancion) elemento;
                minutos += cancion.getMinutos();
                segundos += cancion.getSegundos();
            } else if (elemento instanceof Album) {
                Album album = (Album) elemento;
                minutos += album.getMinutos();
                segundos += album.getSegundos();
            } else if (elemento instanceof ListaMusica) {
                ListaMusica lista = (ListaMusica) elemento;
                minutos += lista.getMinutos();
                segundos += lista.getSegundos();
            }
        }

        if (segundos > 59) {
            minutos += segundos / 60;
            segundos = segundos % 60;
        }
        return minutos * 60 + segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LISTA: ").append(titulo).append(", ");
        sb.append("DURACION: ").append(minutos).append(":").append(segundos).append("\n");
        int contador = 1;
        int subcontador = 1;
        for (Object elemento : elementos) {
            if (elemento instanceof Cancion) {
                sb.append(contador).append(".").append(((Cancion) elemento).toString()).append("\n");
            } else if (elemento instanceof Album) {
                sb.append("\n").append(subcontador).append(".").append(((Album) elemento).toString());
                subcontador++;
            } else if (elemento instanceof ListaMusica) {
                sb.append(((ListaMusica) elemento).toString());
            }
            contador++;
        }
        return sb.toString();
    }
    
    @Override
    public String getDescripcion() {
        return toString();
    }

}
