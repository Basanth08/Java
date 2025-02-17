package unit06;

public interface BinarySearchTree <E extends Comparable<E>> {
    void insert (E value);

    boolean search(E target);

    int size();
    
}
