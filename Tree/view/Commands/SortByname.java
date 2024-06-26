package view.Commands;

import view.ConsoleUI;

public class SortByname extends Command {

    public SortByname(ConsoleUI consoleUI) {
        super("Сортировка по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByname();
    }
}
