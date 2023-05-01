package intents;

public interface ICreateObject<T> {
    
    public T createObject(ContextIntent<T> c);

}
