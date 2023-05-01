package intents;

import java.util.HashMap;
import java.util.Map;


public class StructuredPhrase {

    private StringBuilder phraseBuilder;
    private Map<String, Object> parameters;

    public StructuredPhrase() {
        phraseBuilder = new StringBuilder();
        parameters = new HashMap<>();
    }

    public StructuredPhrase with(String text) {
        if(phraseBuilder.length() == 0)
        {
            phraseBuilder.append(text);
            return this;
        }
        phraseBuilder.append(" " + text);
        return this;
    }

    public StructuredPhrase with(String parameterName, Object value) {
        parameters.put(parameterName, value);
        phraseBuilder.append(" [" + parameterName + ":" + value.getClass().getSimpleName() + "(" + value + ")]");
        return this;
    }

    public StructuredPhrase setting(String parameterName, Object value) {
        parameters.put(parameterName, value);
        return this;
    }

    public Object getValue(String parameterName) {
        return parameters.get(parameterName);
    }

    @Override
    public String toString() {
        return phraseBuilder.toString();
    }
}