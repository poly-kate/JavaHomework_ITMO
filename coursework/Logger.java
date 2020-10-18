package coursework;

//вывод информации в консоль
public class Logger{


    private Fitness fitness;

    public Logger(Fitness fitness)
    {
        this.fitness=fitness;
    }

    void printAllInfo() //вывести информацию о всех посетителях
    {
        System.out.println("Посетители тренажерного зала:");
        if (fitness.countGym==0) System.out.println("(пусто)");
        else for (int i=0; i<fitness.countGym; i++) System.out.println((i+1) + ") "
                + fitness.gymAbonem[i].name + " " + fitness.gymAbonem[i].surname);

        System.out.println("\nПосетители бассейна:");
        if (fitness.countPool==0) System.out.println("(пусто)");
        else for (int i=0; i<fitness.countPool; i++) System.out.println((i+1) + ") "
                + fitness.poolAbonem[i].name + " " + fitness.poolAbonem[i].surname);

        System.out.println("\nПосетители групповых занятий:");
        if (fitness.countGroup==0) System.out.println("(пусто)");
        else for (int i=0; i<fitness.countGroup; i++) System.out.println((i+1) + ") "
                + fitness.groupAbonem[i].name + " " + fitness.groupAbonem[i].surname);
    }

}
