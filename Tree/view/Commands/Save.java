package view.Commands;

import view.ConsoleUI;

public class Save extends Command {

    public Save(ConsoleUI consoleUI) {
        super("Сохранить древо", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().save();
    }
}
