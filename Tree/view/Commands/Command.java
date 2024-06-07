package view.Commands;

import view.ConsoleUI;

public abstract class Command {

    private String description;
    private ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public abstract void execute();

    public String getDescription() {
        return description;
    }

    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

}
