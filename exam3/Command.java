package exam3;

//общий интерфейс для команд меню

import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}
