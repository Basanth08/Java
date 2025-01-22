package unit06;

public class BinaryNode <E>{
    private E value;
    private BinaryNode <E> left;
    private BinaryNode <E> right;

    public BinaryNode (E value, BinaryNode <E> left, BinaryNode <E> right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public BinaryNode (E value) {
        this (value, null, null);
    }

    public BinaryNode <E> getLeft() {
        return left;
    }

    public BinaryNode <E> getRight() {
        return right;
    }

    public E getValue() {
        return value;
    }

    public void setLeft(BinaryNode <E> left) {
        this.left = left;
    }

    public void setRight(BinaryNode <E> right) {
        this.right = right;
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinaryNode{value=" + value + ", left=" + left + ", right=" + right +"}";
    }

    public String infixTraversal () {
        String traversal = "";
        
        if (left != null) {
            traversal += left.infixTraversal ();
        }
        traversal += value + " ";
        if (right != null) {
            traversal += right.infixTraversal ();
        }

        return traversal;
    }

    public boolean search (E target) {
        if (value == target) {
            return true;
        }
        else if (left != null && left.search (target)) {
            return true;
        }
        else if (right != null && right.search (target)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main (String[] args) {
        BinaryNode <Integer> nine = new BinaryNode <>(9);
        BinaryNode <Integer> four = new BinaryNode <> (4);
        BinaryNode <Integer> one = new BinaryNode <> (1);
        BinaryNode <Integer> six = new BinaryNode <> (6);
        BinaryNode <Integer> three = new BinaryNode <> (3, nine, four);
        BinaryNode <Integer> seven = new BinaryNode <> (7, one, six);
        BinaryNode <Integer> two = new BinaryNode <> (2, three, seven);
        
        System.out.println (two);
        System.out.println (two.infixTraversal());

        System.out.println (two.search (2));
        System.out.println (two.search (9));
        System.out.println (two.search (1));
        System.out.println (two.search (8));
    }
}