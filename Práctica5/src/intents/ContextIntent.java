package intents;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Clase que representa un intento de contexto.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 */
public class ContextIntent<T> extends Intent{

    private T object;
    private Map<String,Parameter> parameters = new HashMap<>();
    private Function<ContextIntent<T>,T> objectCreator;
   
    /**
     * Constructor de la clase ContextIntent.
     * 
     * @param nombre Nombre del intento.
     * @param sPhrases Lista de frases estructuradas.
     */
    public ContextIntent(String nombre,List<StructuredPhrase> sPhrases)
    {
        super(nombre, sPhrases);
    }

    /**
     * Metodo que añade un parametro al intent.
     * 
     * @param parameterName Nombre del parametro.
     * @param detectParam Funcion que detecta si el parametro esta en la frase.
     * @param setParam Funcion que asigna el valor del parametro.
     * 
     * @return ContextIntent<T> El intento de contexto.
     */
    public ContextIntent<T> withParameter(String parameterName,Predicate<String> detectParam,Function<String,Object> setParam)
    {
       
        parameters.put(parameterName,new Parameter(detectParam, setParam));
        return this;


    }

    /**
     * Metodo que obtiene el valor de un parametro.
     * 
     * @param nombre Nombre del parametro.
     * 
     * @return <S> El valor del parametro.
     */
    public <S> S getParam(String nombre) {

        Parameter p = parameters.get(nombre);
        Object value = p.getParametervalue();
       
        if(p.getDetectParam().test(value.toString())){
            return (S)p.getParserParam().apply(value.toString());
        }

        return null;
        
        
    }

    /**
     * Metodo que procesa la frase de entrada.
     * 
     * @param st Frase de entrada.
     * 
     * @return ContextIntent<T> El intento de contexto.
    */
    public ContextIntent<T> process(String st)
    {

        List<String> sparam = new ArrayList<>();
        String inputString = this.replyUnprocessed;
        

        
        String[] substrings = inputString.split("#");
        for (int i = 1; i < substrings.length; i += 2) 
        {
            sparam.add(substrings[i]);
        }

        if(matches(st) && this.sPmatch != null)
        {
            for(String pname: sparam){
                this.replyUnprocessed = this.replyUnprocessed.replaceAll("#"+pname+"#",sPmatch.getValue(pname).toString());
                this.parameters.get(pname).setParametervalue(sPmatch.getValue(pname));;
            }

            this.reply = this.replyUnprocessed;
            this.object = objectCreator.apply(this);
            return this;
        }
        else
        {
            this.object = objectCreator.apply(this);
            return this;
        }

    }

    /**
     * Metodo que obtiene la respuesta del intento.
     * 
     * @return String La respuesta del intento.
     */
    public String getReply()
    {
        return this.reply;
    }

    /**
     * Metodo que obtiene el objeto del intento.
     * 
     * @return T El objeto del intento.
     */
    public T getObject()
    {
        return object;
    }

    /**
     * Metodo que obtiene el mapa de parametros del intento.
     * 
     * @return propio objeto.
     */
    public ContextIntent<T> resultObject(Function<ContextIntent<T>,T> objectCreator) {
        this.objectCreator = objectCreator;
        return this;
    }

    /**
     * Metodo que obtiene la respuesta del intent.
     * 
     * @return propio objeto.
     */
    public ContextIntent<T> replies(String replyString)
    {
        this.replyUnprocessed = replyString;
        return this;
    }

    


   
    
}
