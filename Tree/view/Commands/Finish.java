package view.Commands;

import view.ConsoleUI;

public class Finish extends Command {

    public Finish(ConsoleUI consoleUI) {
        super("До встречи", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
