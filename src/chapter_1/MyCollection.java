package chapter_1;

import java.util.Iterator;

public class MyCollection implements Iterable<String>{
    private String[] container;
    private int size;

    public MyCollection(int size){
        container = new String[size];
        size = 0;
    }

    public void addValue(String val){
        container[size++] = val;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<String>{
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < container.length && container[index] != null;
        }

        @Override
        public String next() {
            return container[index++];
        }
    }
}
