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
    public void addChild(long parentId, long childId){
        familytree.addChild(parentId, childId);
    }

    public void addFather(long fatherId, long childId) {
        familytree.addFather(fatherId, childId);
    }

    public void addMather(long matherId, long childId) {
        familytree.addMather(matherId, childId);
    }

    public void sortByName() {
        familytree.sortByName();
    }

    public void sortByDob() {
        familytree.sortByDob();
    }

 public Familytree load(Writeble writeble) {
        return (Familytree) writeble.read();
 }

 public void save(Writeble writeble) {
        writeble.save(familytree);
 }

}
