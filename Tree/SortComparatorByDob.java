import java.util.Comparator;

public class SortComparatorByDob<T extends TreeOb<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getDob().compareTo(o2.getDob());
    }
    
}
