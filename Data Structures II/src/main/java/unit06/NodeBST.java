package unit06;

public class NodeBST<E extends Comparable<E>> implements BinarySearchTree <E> {
    private BinaryNode <E> root;
    private int size;

    public NodeBST () {
        root = null;
        size = 0;
    }

    private void binaryInsert(BinaryNode<E> node, E value) {
        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryNode<>(value));
            } else {
                binaryInsert(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryNode<>(value));
            } else {
                binaryInsert(node.getRight(), value);
            }
        }
    }

    @Override
    public void insert(E value) {
        if (root == null) {
            root = new BinaryNode <> (value);
        }
        else {
            binaryInsert (root, value);
        }
        size++;
    }

    private boolean binarySearch(BinaryNode<E> node, E target) {
        int cmp = target.compareTo(node.getValue());
        if (cmp == 0) {
            return true;
        } else if (cmp < 0 && node.getLeft() != null) {
            return binarySearch(node.getLeft(), target);
        } else if (cmp > 0 && node.getRight() != null) { 
            return binarySearch(node.getRight(), target);
        } else {
            return false;
        }
    }

    @Override
    public boolean search(E target) {
        if (root == null) {
            return false;
        }
        return binarySearch (root, target);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "<empty>";
        }
        else {
            return root.infixTraversal ();
        }
    }

    public static void main(String[] args) {
        BinarySearchTree <Integer> bst = new NodeBST<> ();
        System.out.println (bst);

        bst.insert (4);
        bst.insert (2);
        bst.insert (6);
        bst.insert (1);
        bst.insert (3);
        bst.insert (5);
        bst.insert (7);

        System.out.println (bst);

        System.out.println (bst.search (4));
        System.out.println (bst.search (7));
        System.out.println (bst.search (0));
        System.out.println (bst.search (8));
    }
}
