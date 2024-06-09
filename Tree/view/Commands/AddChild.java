package view.Commands;

import view.ConsoleUI;

public class AddChild extends Command {

    public AddChild(ConsoleUI consoleUI) {
        super("Добавить ребёнка", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addChild();
    }
}
