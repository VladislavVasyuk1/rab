package view.Commands;

import view.ConsoleUI;

public class SortByDayOfBerthday extends Command {

    public SortByDayOfBerthday(ConsoleUI consoleUI) {
        super("Сортировка по дню рождения", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByDayOfBerthday();
    }
}
