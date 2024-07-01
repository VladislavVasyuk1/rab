package view;

import model.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Добрый день!");
        System.out.println("Выберите один из следующий пунктов!");

        while (work) {
            System.out.println(mainMenu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            mainMenu.execute(choice);
        }
    }

    public void sortByDayOfBerthday() {
        presenter.sortByDayOfBerthday();
    }

    public void sortByname() {
        presenter.sortByName();
    }

    public void addChild() {
        getHumanListInfo();
        System.out.println("Введите ID родителя");
        long parentId = Long.parseLong(scanner.nextLine());
        System.out.println("Введите ID ребёнка");
        long childId = Long.parseLong(scanner.nextLine());
        presenter.addChild(parentId, childId);
    }

    public void addFather() {
        getHumanListInfo();
        System.out.println("Введите ID отца");
        long fatherId = Long.parseLong(scanner.nextLine());
        System.out.println("Введите ID ребёнка");
        long childId = Long.parseLong(scanner.nextLine());
        presenter.addFather(fatherId, childId);
    }

    public void addMather() {
        getHumanListInfo();
        System.out.println("Введите ID матери");
        long matherId = Long.parseLong(scanner.nextLine());
        System.out.println("Введите ID ребёнка");
        long childId = Long.parseLong(scanner.nextLine());
        presenter.addMather(matherId, childId);
    }

    public void addHuman() {
        System.out.println("Введите имя ");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию ");
        String surname = scanner.nextLine();
        String formatDate = "dd-MM-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatDate);
        System.out.println("Введите дату рождения образца dd-MM-yyyy");
        LocalDate dob = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Введите пол (Male или Female)");
        Gender gender = Gender.valueOf(scanner.nextLine());
        presenter.addHuman(name, surname, dob, gender);
        getHumanListInfo();
    }

    public void finish() {
        work = false;
        System.out.println("Досвидания.");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public  void save(){
        presenter.save();
    }

    public  void load(){
        presenter.load();
    }

}
