package view;

import view.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new AddChild(consoleUI));
        commands.add(new AddFather(consoleUI));
        commands.add(new AddMather(consoleUI));
        commands.add(new SortByname(consoleUI));
        commands.add(new SortByDayOfBerthday(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Меню: \n");
        for (int i = 0; i < commands.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commands.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice) {
        Command command = commands.get(choice-1);
        command.execute();
    }
    public int size(){
        return commands.size();
    }
}
