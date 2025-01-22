package unit11.activities;

public class NameThread implements Runnable {
    private final String word;
    private final int index;
    private final Thread previous;

    public NameThread (String word, int index, Thread previous) {
        this.word = word;
        this.index = index;
        this.previous = previous;
    }

    @Override
    public void run() {
        try {
            if (previous != null) {
                previous.join ();
            }
        } catch (InterruptedException ie) {}
        System.out.print (word.charAt (index));
    }

    public static void main(String[] args) {
        String name = "Bruce";
        Thread previous = null;
        for (int i = 0; i < name.length(); i++) {
            previous = new Thread (new NameThread (name, i, previous));
            previous.start ();
        }
    }
}
