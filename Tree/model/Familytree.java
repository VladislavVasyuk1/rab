package model;// Васюк Влаислав Сергеевич

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Familytree<T extends TreeOb<T>> implements Serializable, Iterable<T> {

    private List<T> familytree;
    private long humanId;

    public Familytree() {
        familytree = new ArrayList<T>();
    }

    public void addHuman(T human)
    {
        familytree.add(human);
        human.setId(++humanId);
        addToChild(human);
        addToParent(human);
    }

    public T findByHuman(long humanId) {
        for (T human : familytree) {
            if (human.getId() == humanId) {
                return human;
            }
        }
        return null;
    }

    private void addToParent(T child) {
        if (child.getFather() != null) {
            child.getFather().addChild(child);
        }
        if (child.getMather() != null) {
            child.getMather().addChild(child);
        }
    }

    private void addToChild(T parent) {
        for (T child : parent.getChildren()) {
            if (parent.getGender() == Gender.Male) {
                child.addFather(parent);
            } else
                child.addMather(parent);
        }
    }

    public boolean addChild(long parantsID, long childId) {
        if (findByHuman(parantsID).getChildren().contains(findByHuman(childId)))
            return false;
        else {
            findByHuman(parantsID).addChild(findByHuman(childId));
            addToChild(findByHuman(parantsID));
            if (findByHuman(parantsID).getGender() == Gender.Male) {addFather(parantsID, childId);}
            else {addMather(parantsID, childId);}
            return true;
        }
    }

    public void addFather(long fatherID, long childId) {
        findByHuman(childId).addFather(findByHuman(fatherID));
        addToParent(findByHuman(childId));
    }

    public void addMather(long matherID, long childId) {
        findByHuman(childId).addMather(findByHuman(matherID));
        addToParent(findByHuman(childId));
    }


    public void sortByName() {
        familytree.sort(new SortComparatorByName<>());
    }

    public void sortByDob() {
        familytree.sort(new SortComparatorByDob<>());
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В древе находится ");
        sb.append(familytree.size() + " человек:");
        sb.append("\n");
        for (T people : familytree) {
            sb.append(people);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator(familytree);
    }
}
