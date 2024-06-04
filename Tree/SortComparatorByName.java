import java.util.Comparator;

public class SortComparatorByName<T extends TreeOb<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        if(o1.getName().compareTo(o2.getName()) == 0){
            return o1.getSurname().compareTo(o2.getSurname());
        }
        else{
            return o1.getName().compareTo(o2.getName());
        }
    }
    
    
}