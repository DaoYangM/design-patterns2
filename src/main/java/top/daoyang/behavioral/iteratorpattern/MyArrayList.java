package top.daoyang.behavioral.iteratorpattern;

import java.util.Iterator;

public class MyArrayList  implements Iterable<Integer> {

    private int[] elementData;

    private int size;

    public MyArrayList(int size) {
        this.elementData = new int[size];
    }

    public void add(int i) {
        elementData[size++] = i;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Integer> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Integer next() {
            return elementData[index++];
        }
    }
}
