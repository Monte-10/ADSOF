package intents;

import java.util.List;

/**
 * Clase de utilidad para la definición de Intents.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
 * 
 */
public class IntentHelper {
    /**
     * Método que comprueba si un String está contenido en un array de Strings.
     * 
     * @param s
     * @param values
     * @return Lista de Strings.
     * 
     */
    public static boolean containsIgnoreCase(String s,Object[] values) {
        return List.of(values).stream().anyMatch(e -> s.toUpperCase().equals(e.toString()));
    }
    }