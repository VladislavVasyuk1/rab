import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;

public class Human {
    private String name ;
    private String surname;
    private LocalDate dob, dod;
    private List<Human> children;
    private Human father, mather;
    private Gender gender;

    public Human(String name, String surname, LocalDate dob, LocalDate dod, Human father, Human mather, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.dod = dod;
        this.father = father;
        this.mather = mather;
        this.gender = gender;
    }

    public Human(String name, String surname, LocalDate dob, Human father, Human mather, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.father = father;
        this.mather = mather;
        this.gender = gender;
    }

    public addChildren(String name, String surname){
        Human human = Familytree.findByHuman(name,surname);
        if(human == null){
            return null;
        }
        for (Human human1 : children) {
            if (human.equals(human1)) {
                return null;           
            }
        }
        return children.add(human);
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public LocalDate getDob() {
        return dob;
    }
    public LocalDate getDod() {
        return dod;
    }
    public List<Human> getChildren() {
        return children;
    }
    public Human getFather() {
        return father;
    }
    public Human getMather() {
        return mather;
    }
    public Gender getGender() {
        return gender;
    }

    public Age(){
        if (Human.getDob == nuul)
            return Human.getDod - YearMonth.now().getYear();
        else 
            return Human.getDod - Human.getDob;
    }


    
    @Override
    public String toString() {
        return String.format("%s %s %s года родения. Возраст %s летб, пол %s. Дети : %s",surname,name,dob,Human.Age(),gender, children);
    }
}
