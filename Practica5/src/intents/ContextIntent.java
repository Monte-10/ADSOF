package intents;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class ContextIntent<T> extends Intent{

    
    private Map<String,Parameter<T>> parameters = new HashMap<>();
    

    public ContextIntent(String nombre,List<StructuredPhrase> sPhrases)
    {
        super(nombre, sPhrases);
    }

    
    public ContextIntent<T> withParameter(String parameterName,Predicate<String> detectParam,Function<String,T> setParam)
    {
       
        parameters.put(parameterName,new Parameter<T>(detectParam, setParam));
        return this;


    }

   
    
}
