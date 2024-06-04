import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, TreeOb<Human>{

    private String name ;
    private String surname;
    private LocalDate dob, dod;
    private List<Human> children;
    private Human father, mather;
    private Gender gender;
    private long id;


    public Human( String name, String surname, LocalDate dob, LocalDate dod, Human father, Human mather, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.father = father;
        this.mather = mather;
        children = new ArrayList<>();

    }

    public Human(String name, String surname, LocalDate dob, Gender gender) {
        this(name, surname,dob, null, null, null, gender);
       
    }


    public boolean addChild(Human child){
        if (children.contains(child)) return false;
        else {
            children.add(child);
            return true;
        }
    }

    public void addFather(Human father) {
        this.father = father;
    }

    public void addMather(Human mather) {
        this.mather = mather;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getAge(){
        if (dod == null)
            return getPeriod(dob, LocalDate.now());
        else 
            return getPeriod(dob, dod);
    }

    private int getPeriod(LocalDate dob, LocalDate dod){
        Period diff = Period.between(dob, dod);
        return diff.getYears();
    }


    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append(id + ". Имя: " + name);
            sb.append(", Фамилия: " + surname);
            sb.append(", пол: " + getGender());
            sb.append(", возраст: " + getAge() + " лет, ");
            sb.append(getFatherInf());
            sb.append(", ");
            sb.append(getMAtherInf());
            sb.append(", ");
            sb.append(getChildInf());
            return sb.toString();
    }

    public String getMAtherInf(){
        String res = "мать: ";
        Human mather = getMather();
        if (mather != null){
            res += mather.getName();
            res += " ";
            res += mather.getSurname();
        }
        else res += "-";
        return res;
    }

    public String getFatherInf(){
        String res = "отец: ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
            res += " ";
            res += father.getSurname();
        }
        else res += "-";
        return res;
    }

    public String getChildInf(){
        StringBuffer res = new StringBuffer();
        res.append("дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            res.append(" ");
            res.append(children.get(0).getSurname());
            for (int i =1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(0).getName());
                res.append(" ");
                res.append(children.get(0).getSurname());
            }
        }
        else res.append("-");
        return res.toString();
    }

}
