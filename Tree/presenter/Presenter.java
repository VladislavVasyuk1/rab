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
        service.addChild(parentId, childId);
    }
    public void getHumanListInfo() {
        String info = service.getInfo();
        view.printAnswer(info);
}

    public void addFather(long fatherId, long childId) {
        service.addFather(fatherId, childId);
    }

    public void addMather(long matherId, long childId) {
       service.addMather(matherId, childId);
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void sortByDayOfBerthday() {
       service.sortByDob();
        getHumanListInfo();
    }
}
