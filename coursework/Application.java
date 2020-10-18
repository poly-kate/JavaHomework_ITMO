package coursework;

import java.text.ParseException;
import java.time.LocalTime;


public class Application {

    public static void main(String[] args) throws ParseException {

        Fitness fitness = new Fitness();
        Logger log = new Logger(fitness);

        Abonement Masha = new Abonement(3,"2020-05-11", "2020-10-18", 2,
                "Мария", "Петрова", 1983);
        Abonement Dasha = new Abonement(1,"2019-10-01", "2020-12-28", 1,
                "Дарья", "Иванова", 1992);
        Abonement Maxim = new Abonement(3,"2020-09-14", "2022-11-22", 3,
                "Максим", "Сидоров", 1975);


        fitness.addClient(Masha);
        fitness.addClient(Dasha);
        fitness.addClient(Maxim);


        log.printAllInfo();//вывести информацию о всех посетителях

        //fitness.setStatus();//устанавливает текущий статус клуба (закрыт-открыт)

    }


}
