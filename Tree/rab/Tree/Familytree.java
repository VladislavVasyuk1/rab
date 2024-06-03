// Васюк Влаислав Сергеевич

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
public class Familytree implements Serializable{
    
    private static List<Human> familytree;

    public Familytree(){
        familytree = new ArrayList<>();
    }
    
    public void addHuman(Human human){
        familytree.add(human);

        addToChild(human);
        addToParent(human);
    }

    

    public Human findByHuman(String name, String surname){
        for (Human human : familytree) {
            if (human.getName().equalsIgnoreCase(name) || human.getName().equalsIgnoreCase(surname)){
                return human;
            }
        }
        return null;
    }

    private void addToParent(Human child){
        if (child.getFather() != null){
            child.getFather().addChild(child);
        }
        if (child.getMather() != null){
            child.getMather().addChild(child);
        }
    }

    private void addToChild(Human parent){
        for (Human child : parent.getChildren()) {
            if (parent.getGender() == Gender.Male){
                child.addFather(parent);
            }
            else child.addMather(parent);
        }
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
            for (Human people : familytree) {
                sb.append(people);
                sb.append("\n");
            }
            return sb.toString();
        }    
}
