package valoraciones;

public class Usuario implements IUsuario {
    private String id;
    private String nombre;


    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}