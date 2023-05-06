package intents;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa una frase estructurada.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
*/
public class StructuredPhrase {

    private StringBuilder phraseBuilder;
    private String phrase = "";
    private Map<String, Object> parameters;

    /**
     * Constructor de la clase StructuredPhrase.
     */
    public StructuredPhrase() {
        phraseBuilder = new StringBuilder();
        parameters = new HashMap<>();
    }

    /**
     * Metodo que añade una palabra a la frase.
     * 
     * @param text
     * @return StructuredPhrase
     */
    public StructuredPhrase with(String text) {
        if(phraseBuilder.length() == 0)
        {
            phraseBuilder.append(text);
            phrase += text;
            return this;
        }
        phrase += " " + text;
        phraseBuilder.append(" " + text);
        return this;
    }

    /**
     * Metodo que añade un parametro a la frase.
     * 
     * @param parameterName Nombre del parametro.
     * @param value Valor del parametro.
     * @return StructuredPhrase
     */
    public StructuredPhrase with(String parameterName,Object value) {
        parameters.put(parameterName, value);
        phrase += " " + value;
        phraseBuilder.append(" [" + parameterName + ":" + value.getClass().getSimpleName() + "(" + value + ")]");
        return this;
    }

    /**
     * Metodo que se encarga de asignar un valor a un parametro.
     * 
     * @param parameterName
     * @param value
     * @return StructuredPhrase
     */
    public StructuredPhrase setting(String parameterName,Object value) {
        parameters.put(parameterName, value);
        return this;
    }

    /**
     * Metodo que obtiene el valor de un parametro.
     * 
     * @param parameterName Nombre del parametro.
     * @return Object Valor del parametro.
     */
    public Object getValue(String parameterName) {
        return parameters.get(parameterName);
    }

    /**
     * Metodo que obtiene la frase.
     * 
     * @return String La frase.
     */
    public String getPhrase() {
        return phrase;
    }

    /**
     * Metodo toString de la clase StructuredPhrase.
     * 
     * @return String La frase.
     */
    @Override
    public String toString() {
        return phraseBuilder.toString();
    }
}