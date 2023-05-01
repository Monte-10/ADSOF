package intents;

import java.util.function.Function;
import java.util.function.Predicate;

public class Parameter<T> {

    Predicate<String> detectParam;
    Function<String,T> parserParam;
    
    public Parameter(Predicate<String> detectParam, Function<String, T> parserParam) {
        this.detectParam = detectParam;
        this.parserParam = parserParam;
    }

    public Predicate<String> getDetectParam() {
        return detectParam;
    }

    public void setDetectParam(Predicate<String> detectParam) {
        this.detectParam = detectParam;
    }

    public Function<String, T> getParserParam() {
        return parserParam;
    }

    public void setParserParam(Function<String, T> parserParam) {
        this.parserParam = parserParam;
    }

    

}
