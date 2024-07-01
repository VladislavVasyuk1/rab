package view.Commands;

import view.ConsoleUI;

public class Load extends Command{

    public Load(ConsoleUI consoleUI) {
        super("Загрузить древо", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().load();
    }
}
