package ExFactory;

public class Array<T> implements Collection<T> {
    private final T[] array;
    private int currentIndex;
    
    public Array(int size) {
        array = (T[]) new Object[size];
    }
    
    @Override
    public void add(T object) {
        if (currentIndex == array.length)
            throw new RuntimeException("Array plein.");
        
        array[currentIndex] = object;
        currentIndex++;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }
    
    private class ArrayIterator implements Iterator<T> {
        private int index;
        
        @Override
        public T next() {
            if (!hasNext())
                throw new RuntimeException("Il n'y a pas d'élément suivant!");
            
            T element = array[index];
            index++;
            return element;
        }
        
        @Override
        public boolean hasNext() {
            return index < array.length;
        }
    }
}
