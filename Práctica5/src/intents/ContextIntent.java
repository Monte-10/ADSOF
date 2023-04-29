package intents;

import java.util.*;

public class ContextIntent<T> {

    String nombre;
    List<StructuredPhrase> sPhrases = new ArrayList<>();
    String respuesta;

    public ContextIntent(String nombre,List<StructuredPhrase> sPhrases)
    {
        this.nombre = nombre;
        this.sPhrases = sPhrases;
    }

    
    public ContextIntent<T> withParameter(String parameterName,IDetectParam detectParam,ISetParam setParam)
    {
        
    }

    
}
