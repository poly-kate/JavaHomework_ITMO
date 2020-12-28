package exam3;

import java.io.IOException;

public class StartGame implements Command {

    //начать игру=запустить первый шаг
    Step firstStep;

    @Override
    public void execute() throws IOException {
        System.out.println("Старт игры");
        firstStep = new Step("firstFox");
    }
}






