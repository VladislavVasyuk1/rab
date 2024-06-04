import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeOb<T> extends Serializable, Comparable<T>{
    void setId(long id);
    String getName();
    String getSurname();
    T getFather();
    T getMather();
    boolean addChild(T child);
    List<T> getChildren();
    void addFather(T father);
    void addMather(T mather);
    Gender getGender();
    LocalDate getDob();
    LocalDate getDod();
}
