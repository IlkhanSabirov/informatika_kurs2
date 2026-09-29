package collection;

import java.util.Iterator;

public class MyArrayList implements Iterable<Integer> {

    private final static int DEFAULT_MAX_SIZE = 10;

    private int elements[];
    private int count;

    public MyArrayList() {
        this.elements = new int[DEFAULT_MAX_SIZE];
        this.count = 0;
    }

    public void add(int element) {
        this.elements[count] = element;
        this.count++;
    }

    private class MyArrayListIterator implements Iterator<Integer> {

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < count;
        }

        @Override
        public Integer next() {
            int value = elements[currentIndex];
            currentIndex++;
            return value;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayListIterator();
    }
}
