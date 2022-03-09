package ExFactory;

public class List<T> implements Collection<T> {
    private Element head;
    
    @Override
    public void add(T object) {
        head = new Element(object, head);
    }
    
    private class Element {
        private final T data;
        private final Element next;
        
        private Element(T data, Element next) {
            this.data = data;
            this.next = next;
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        return new ListIterator(head);
    }
    
    private class ListIterator implements Iterator<T> {
        private Element current;
        
        public ListIterator(Element head) {
            this.current = head;
        }
        
        @Override
        public T next() {
            if (!hasNext())
                throw new RuntimeException("Il n'y a pas d'élément suivant!");
            
            Element e = current;
            current = current.next;
            return e.data;
        }
        
        @Override
        public boolean hasNext() {
            return current != null;
        }
    }
}
