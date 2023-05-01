package intents;
import java.util.*;

public class Intent {
    
    private String nombre;
    private List<StructuredPhrase> sPhrases = new ArrayList<>();
    private String respuesta;


    public Intent(String nombre,List<StructuredPhrase> sPhrases)
    {
        this.nombre = nombre;
        this.sPhrases = sPhrases;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<StructuredPhrase> getsPhrases() {
        return sPhrases;
    }

    public void setsPhrases(List<StructuredPhrase> sPhrases) {
        this.sPhrases = sPhrases;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    
   
}
