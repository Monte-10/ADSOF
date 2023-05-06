package intents;

/**
 * Interfaz que representa la creacion de un objeto.
 * 
 * @param <T> Tipo de objeto.
 * 
 * @author Álvaro Mendez y Alejandro Monterrubio // alvaro.mendezl@estudiante.uam.es alejandro.monterrubio@estudiante.uam.es
*/
public interface ICreateObject<T> {
    
    public T createObject(ContextIntent<T> c);

}
