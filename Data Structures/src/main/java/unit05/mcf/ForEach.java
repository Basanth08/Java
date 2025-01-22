package unit05.mcf;

public class ForEach {
    public static void forArray (String[] array) {
        for (String element : array) {
            System.out.println (element);
        }
    }

    public static void forList (List<String> list) {
        for (String element : list) {
            System.out.println (element);
        }
    }

    public static void forQueue (Queue<String> queue) {
        for (String element : queue) {
            System.out.println (element);
        }
    }

    public static void main(String[] args) {
        forArray (new String[] {"One", "Two", "Three", "For"});

        List<String> list = new ArrayList<> ();
        list.append ("One");
        list.append ("Two");
        list.append ("Three");
        list.append ("For");
        forList (list);

        Queue<String> queue = new NodeQueue<> ();
        queue.enqueue ("One");
        queue.enqueue ("Two");
        queue.enqueue ("Three");
        queue.enqueue ("For");
        forQueue (queue);

        queue = new ArrayQueue<> ();
        queue.enqueue ("One");
        queue.enqueue ("Two");
        queue.enqueue ("Three");
        queue.enqueue ("For");
        forQueue (queue);
    }
}