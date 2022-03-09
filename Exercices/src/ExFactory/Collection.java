package ExFactory;

public interface Collection<T> {
    void add(T object);
    
    Iterator<T> iterator();
}
