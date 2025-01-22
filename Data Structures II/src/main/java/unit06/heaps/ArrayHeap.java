package unit06.heaps;

import java.util.Arrays;

public class ArrayHeap implements Heap {
    private int[] array;
    private int size;

    public ArrayHeap(){
        array = new int[3];
        size = 0;

    }

    private void swap(int a , int b){
        if(a != b){
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }

    }

    @Override
    public String toString() {
        return size + " " + Arrays.toString(array);
    }
    
    @Override
    public int remove(){
        int value = array [0];
        swap(0,size - 1);
        array [size - 1] = 0;

        int parent = 0;
        while(parent < size){
            int left = parent  * 2 + 1;
            int right = parent * 2 + 2;
            int smaller =left;
            if(right < size){
                if(right < size && array [right] < array [left]){
                    smaller = right;
                }
                if (smaller < size){
                    if (array[parent] < array[smaller]){
                        swap(parent, smaller);
                    }
                    else{
                        break;
                    }
                }
                parent = smaller;
            }
        }

        size--;
        return value;
    }

    @Override
    public void add(int value){
        if (size == array.length){
            array = Arrays.copyOf(array, size*2);
        }

        array[size] = value;
        int child = size;
        int parent = (child - 1)/2;
        while (parent >=0 && array[child] < array[parent]){
            swap(child, parent);
            child = parent;
            parent = (child - 1) / 2;
        }

        size++;
    }

    @Override
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        Heap heap = new ArrayHeap();
        System.out.println(heap);
        heap.add(23);
        heap.add(12);
        heap.add(76);
        heap.add(8);
        heap.add(9);
        System.out.println(heap);
        System.out.println(heap.remove() + " " + heap);
        System.out.println(heap.remove() + " " + heap);
        System.out.println(heap.remove() + " " + heap);
        System.out.println(heap.remove() + " " + heap);
        System.out.println(heap.remove() + " " + heap);
    }

}
