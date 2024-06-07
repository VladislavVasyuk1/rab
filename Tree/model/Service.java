package model;

import java.time.LocalDate;

public class Service {
    private Familytree<Human> familytree;

    public Service() {
        familytree = new Familytree<>();
    }

    public void addHuman(String name, String surname, LocalDate dob, Gender gender){
        Human human = new Human(name, surname, dob, gender);
        familytree.addHuman(human);
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Древо: \n");
        for (TreeOb<Human> human : familytree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
