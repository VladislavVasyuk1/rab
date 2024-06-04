// Васюк Влаислав Сергеевич

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
public class Familytree<T extends TreeOb<T>> implements Serializable{
    
    private List<T> familytree;
    private long humanId;

    public Familytree(){
        familytree = new ArrayList<T>();
    }
    
    public void addHuman(T human){
        familytree.add(human);
        human.setId(++humanId);
        addToChild(human);
        addToParent(human);
    }

    

    public T findByHuman(String name, String surname){
        for (T human : familytree) {
            if (human.getName().equalsIgnoreCase(name) || human.getSurname().equalsIgnoreCase(surname)){
                return human;
            }
        }
        return null;
    }

    private void addToParent(T child){
        if (child.getFather() != null){
            child.getFather().addChild(child);
        }
        if (child.getMather() != null){
            child.getMather().addChild(child);
        }
    }

    private void addToChild(T parent){
        for (T child : parent.getChildren()) {
            if (parent.getGender() == Gender.Male){
                child.addFather(parent);
            }
            else child.addMather(parent);
        }
    }

    public void sortByName(){
        familytree.sort(new SortComparatorByName<>());
    }

    public void sortByDob(){
        familytree.sort(new SortComparatorByDob<>());
    }

        @Override
            public String toString(){
                return getInfo();
                }

        public String getInfo(){
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

        
}
