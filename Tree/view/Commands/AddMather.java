package view.Commands;

import view.ConsoleUI;

public class AddMather extends Command {

    public AddMather(ConsoleUI consoleUI) {
        super("Добавить маму", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addMather();
    }
}
