package coursework;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


abstract class Person {
    protected String name;
    protected String surname;
    protected int yearBirth;

    public Person(String name, String surname, int yearBirth) {
        if(name==null || surname==null || yearBirth<=1920)
            throw new IllegalArgumentException("Неверные персональные данные");
        this.name=name;
        this.surname=surname;
        this.yearBirth=yearBirth;
    }
}

public class Abonement extends Person{

    private int type;//1 - разовый, 2 - дневной, 3 - полный
    private LocalDate startAbonem; //дата начала абонемента
    private LocalDate endAbonem; //дата окончания абонемента
    private int trainingZone;//текущая зона тренировки
    protected int needZone;//зона, в которую хочет попасть клиент

    public Abonement(int type, String startAbonemStr, String endAbonemStr, int needZone,
                     String name, String surname, int yearBirth) throws ParseException {

        super(name, surname, yearBirth);

        startAbonem=LocalDate.parse(startAbonemStr);
        endAbonem=LocalDate.parse(endAbonemStr);

        checkAbonem(type, startAbonem, endAbonem, needZone);
        this.type=type;
        this.needZone=needZone;
    }


    public void checkAbonem(int type, LocalDate startAbonem, LocalDate endAbonem, int needZone)//полная проверка абонемента
    {
        LocalDate today = LocalDate.now();

        if (type==0 || (today.isBefore(startAbonem)&& !today.isEqual(startAbonem)) ||
                        (today.isAfter(endAbonem)&& !today.isEqual(startAbonem)) || needZone<=0 || needZone>3)
            throw new IllegalArgumentException("Недействительный абонемент");

        if ((type==1 && needZone==3) || (type==2 && needZone==1))
            throw new IllegalArgumentException("Нет доступа в данную зону");

        LocalTime currentTime = LocalTime.now();
        //LocalTime currentTime = LocalTime.of(17, 30);//для проверки

        LocalTime startTime = LocalTime.of(8, 0);   //08:00
        LocalTime middleTime = LocalTime.of(16, 0); //16:00
        LocalTime endTime = LocalTime.of(22, 00);   //22:00

        if(currentTime.isBefore(startTime) || currentTime.isAfter(endTime) ||
                (type==2 && currentTime.isAfter(middleTime)))
        {
            throw new IllegalArgumentException("В текущее время проход запрещен");
        }
    }


    public void getTrainingZone(){//абонемент получил доступ в желаемую зону

        trainingZone=needZone;
        needZone=0;
        if (type==1) type=0;//обнуляем разовый абонемент

        //вывод информации о новом посетителе
        System.out.print("Посетитель: " + name + " " + surname + "\nЗона: ");
        switch (trainingZone){
            case 1:
                System.out.print("бассейн\n");
                break;
            case 2:
                System.out.print("тренажерный зал\n");
                break;
            case 3:
                System.out.print("групповое занятие\n");
                break;
        }
        System.out.println("Дата и время: " + LocalDateTime.now() + "\n");

    }


    public void leaveTrainingZone() { //абонемент покинул зону тренировок
        trainingZone=0;
    }




}