package presenter;

import model.Familytree;
import model.Gender;
import model.Human;
import model.Service;
import view.View;

import java.security.Provider;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Familytree familytree;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        familytree = new Familytree();
        service = new Service();
    }

    public void addHuman(String name, String surname, LocalDate dob, Gender gender) {
        service.addHuman(name, surname, dob, gender);
    }

    public void addChild(long parentId, long childId) {
        familytree.addChild(parentId, childId);
    }
    public void getHumanListInfo() {
        String info = service.getInfo();
        view.printAnswer(info);
}

    public void addFather(long fatherId, long childId) {
        familytree.addFather(fatherId, childId);
    }

    public void addMather(long matherId, long childId) {
        familytree.addMather(matherId, childId);
    }

    public void sortByName() {
        familytree.sortByName();
        getHumanListInfo();
    }

    public void sortByDayOfBerthday() {
        familytree.sortByDob();
        getHumanListInfo();
    }
}
