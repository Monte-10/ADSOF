package intents;
import java.util.*;

/**
 * Clase que representa un intent.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */
public class Intent {
    
    protected String nombre;
    protected List<StructuredPhrase> sPhrases = new ArrayList<>();
    protected StructuredPhrase sPmatch;
    protected String reply;
    protected String replyUnprocessed;

    /**
     * Constructor de la clase Intent.
     * 
     * @param nombre Nombre del intent.
     * @param sPhrases Lista de frases estructuradas.
     */
    public Intent(String nombre,List<StructuredPhrase> sPhrases)
    {
        this.nombre = nombre;
        this.sPhrases = sPhrases;
    }

    /**
     * Metodo que obtiene el nombre del intent.
     * 
     * @return String Nombre del intent.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que asigna el nombre del intent.
     * 
     * @param nombre Nombre del intent.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene la lista de frases estructuradas.
     * 
     * @return List<StructuredPhrase> Lista de frases estructuradas.
     */
    public List<StructuredPhrase> getsPhrases() {
        return sPhrases;
    }

    /**
     * Metodo que asigna la lista de frases estructuradas.
     * 
     * @param sPhrases Lista de frases estructuradas.
     */
    public void setsPhrases(List<StructuredPhrase> sPhrases) {
        this.sPhrases = sPhrases;
    }

    /**
     * Metodo que obtiene la frase estructurada que coincide con la frase introducida.
     * 
     * @return StructuredPhrase Frase estructurada que coincide con la frase introducida.
     */
    public String getReply() {
        return reply;
    }

    /**
     * Metodo que procesa la frase introducida.
     * 
     * @param st Frase introducida.
     * 
     * @return Intent El intento procesado.
     */
    public Intent process(String st)
    {
        return this;
    }

    /**
     * Metodo que obtiene la respuesta del intent.
     * 
     * @return String Respuesta del intent.
     */
    public Intent replies(String replyString)
    {
        this.reply = replyString;
        return this;
    }

    /**
     * Metodo que establece la respuesta del intent.
     * 
     * @param respuesta Respuesta del intent.
     * 
     */
    public void setReply(String respuesta) {
        this.reply = respuesta;
    }

    /**
     * Metodo que comprueba si la frase introducida coincide con alguna de las frases estructuradas.
     * 
     * @param st Frase introducida.
     * 
     * @return boolean True si coincide, false si no.
     */
    public boolean matches(String st) {
         
        for (StructuredPhrase s : sPhrases) {
            
            String phrase = s.getPhrase().toLowerCase();

            if(phrase.matches(st.toLowerCase()))
            {
                sPmatch = s;
                return true;
            }

        }

        return false;
    }
   
}
