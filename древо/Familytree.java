// Васюк Влаислав Сергеевич

import java.util.ArrayList;
import java.util.List;

public class Familytree {
    private List<Human> familytree;

    public void addHuman(Human human){
        familytree.add(human);
    }

    public Familytree(){
        familytree = new ArrayList<>();
    }

    public Human findByHuman(String name, String surname){
        for (Human human : familytree) {
            if (human.getName().equalsIgnoreCase(name) || human.getName().equalsIgnoreCase(surname)){
                return human;
            }
        }
        return null;
    }
}
