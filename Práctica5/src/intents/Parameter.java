package intents;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Clase que representa un parametro.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */
public class Parameter {

    private Predicate<String> detectParam;
    private Function<String,Object> parserParam;
    private Object parametervalue;
    
    /**
     * Metodo que obtiene el valor del parametro.
     * 
     * @return Object Valor del parametro.
     */
    public Object getParametervalue() {
        return parametervalue;
    }

    /**
     * Metodo que asigna el valor del parametro.
     * 
     * @param parametervalue Valor del parametro.
     */
    public void setParametervalue(Object parametervalue) {
        this.parametervalue = parametervalue;
    }

    /**
     * Constructor de la clase Parameter.
     * 
     * @param detectParam Funcion que detecta si el parametro esta en la frase.
     * @param parserParam Funcion que asigna el valor del parametro.
     */
    public Parameter(Predicate<String> detectParam,Function<String, Object> parserParam) {
        this.detectParam = detectParam;
        this.parserParam = parserParam;
    }

    /**
     * Metodo que obtiene la funcion que detecta si el parametro esta en la frase.
     * 
     * @return Predicate<String> Funcion que detecta si el parametro esta en la frase.
     */
    public Predicate<String> getDetectParam() {
        return detectParam;
    }

    /**
     * Metodo que asigna la funcion que detecta si el parametro esta en la frase.
     * 
     * @param detectParam Funcion que detecta si el parametro esta en la frase.
     */
    public void setDetectParam(Predicate<String> detectParam) {
        this.detectParam = detectParam;
    }

    /**
     * Metodo que parsea el parametro.
     * 
     * @return Function Funcion que parsea el parametro.
     */
    public Function<String, Object> getParserParam() {
        return parserParam;
    }

    /**
     * Metodo que asigna la funcion que parsea el parametro.
     * 
     * @param parserParam Funcion que parsea el parametro.
     */
    public void setParserParam(Function<String, Object> parserParam) {
        this.parserParam = parserParam;
    }

    

}
