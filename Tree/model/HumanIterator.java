package model;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> {

    private int curID;
    private List<T> familytree;

    public HumanIterator(List<T> familytree) {
        this.familytree = familytree;
    }

    @Override
    public boolean hasNext() {
        return familytree.size() > curID;
    }

    @Override
    public T next() {
        return familytree.get(curID++);
    }
}
