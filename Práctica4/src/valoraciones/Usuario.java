package valoraciones;

/**
 * Clase que representa un usuario
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 */
public class Usuario implements IUsuario {
    private String id;
    private String nombre;

    /**
     * Constructor de la clase Usuario
     * 
     * @param nombre nombre del usuario
     * @param id id del usuario
     */
    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Metodo que devuelve el nombre del usuario
     * 
     * @return nombre del usuario
     */
    @Override
    public String getId() {
        return id;
    }
}