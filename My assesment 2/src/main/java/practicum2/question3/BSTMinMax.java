package practicum2.question3;

import practicum2.ds.BinarySearchTree;
import practicum2.ds.BinaryNode;

public class BSTMinMax<T extends Comparable<T>> extends BinarySearchTree<T> {
    
    public BSTMinMax(T initialValue) {
        super(initialValue);
    }
    
    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root);
    }
    
    private T getMin(BinaryNode<T> node) {
        if (node.getLeft() == null) {
            return node.getData();
        }
        return getMin(node.getLeft());
    }
    
    public T getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }
    
    private T getMax(BinaryNode<T> node) {
        if (node.getRight() == null) {
            return node.getData();
        }
        return getMax(node.getRight());
    }
}