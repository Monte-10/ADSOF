package fonoteca;

import java.util.*;
import valoraciones.*;

/**
 * Clase que representa una lista de musica
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 */
public class ListaMusica implements IRecomendable{
    private String titulo;
    private List<Object> elementos;
    private int minutos;
    private int segundos;

    /**
     * Constructor de la clase ListaMusica
     * 
     * @param titulo titulo de la lista
     */
    ListaMusica(String titulo) {
        this.titulo = titulo;
        elementos = new ArrayList<>();
    }

    /**
     * Metodo que devuelve el titulo de la lista
     * 
     * @return titulo de la lista
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo que establece el titulo de la lista
     * 
     * @param titulo titulo de la lista
     * 
     */
    void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Metodo que devuelve los elementos de la lista
     * 
     * @return elementos de la lista
     */
    public List<Object> getElementos() {
        return elementos;
    }

    /**
     * Metodo que establece los elementos de la lista
     * 
     * @param elementos elementos de la lista
     * 
     */
    void setElementos(List<Object> elementos) {
        this.elementos = elementos;
        setDuracion();
    }

    /**
     * Metodo que añade un elemento a la lista
     * 
     * @param cancion cancion a añadir
     * 
     */
    void addElemento(Cancion cancion) {
        elementos.add(cancion);
        setDuracion();
    }

    /**
     * Metodo que añade una lista de canciones a la lista
     * 
     * @param canciones lista de canciones a añadir
     * 
     */
    void addElemento(List<Cancion> canciones) {
        elementos.addAll(canciones);
        setDuracion();
    }

    /**
     * Metodo que añade un album a la lista
     * 
     * @param album album a añadir
     * 
     */
    void addElemento(Album album) {
        elementos.add(album);
        setDuracion();
    }

    /**
     * Metodo que añade una lista de albumes a la lista
     * 
     * @param albumes lista de albumes a añadir
     * 
     */
    void addElemento(ListaMusica lista) {
        elementos.add(lista);
        setDuracion();
    }

    /**
     * Metodo que establece la duracion de la lista
     * 
     * @return duracion de la lista
     */
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

    /**
     * Metodo que devuelve la duracion de minutos de la lista
     * 
     * @return duracion de la lista
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * Metodo que devuelve la duracion de segundos de la lista
     * 
     * @return duracion de la lista
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * Método toString de la clase ListaMusica
     * 
     * @return String con la informacion de la lista
     */
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
    
    /**
     * Metodo que devuelve la descripcion de la lista
     * 
     * @return descripcion de la lista
     */
    @Override
    public String getDescripcion() {
        return toString();
    }

}
