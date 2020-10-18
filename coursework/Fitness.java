package coursework;

import java.time.LocalTime;


public class Fitness {

        Boolean status;
        protected Abonement[] poolAbonem = new Abonement[20]; //зона 1
        protected Abonement[] gymAbonem = new Abonement[20]; //зона 2
        protected Abonement[] groupAbonem = new Abonement[20]; //зона 3

        protected int countPool = 0;
        protected int countGym = 0;
        protected int countGroup = 0;


    public Fitness(){
        setStatus();
    }

    public void setStatus() //устанавливаем открыт или закрыт фитнес относительно текущего времени, если закрыт - посетители уходят
    {
        LocalTime currentTime = LocalTime.now();
        if(currentTime.isBefore(LocalTime.of(8, 0)) || currentTime.isAfter(LocalTime.of(22, 0))) {
            status = false;
            leaveClients();
        }
        else status=true;
    }

    public void addClient (Abonement abonement){ //добавляем клиента в желаемую зону, если возможно
        
        switch(abonement.needZone){
            case 1:
                if(countPool<20) {
                    poolAbonem[countPool++]=abonement;
                    abonement.getTrainingZone();
                }
                else System.out.println("Доступа нет. Бассейн заполнен.");
                break;
            case 2:
                if(countGym<20) {
                    gymAbonem[countGym++]=abonement;
                    abonement.getTrainingZone();
                }
                else System.out.println("Доступа нет. Тренажерный зал заполнен.");
                break;
            case 3:
                if(countGroup<20) {
                    groupAbonem[countGroup++]=abonement;
                    abonement.getTrainingZone();
                }
                else System.out.println("Доступа нет. Групповой зал заполнен.");
                break;
        }

    }

    public void leaveClients(){//все клиенты покидают фитнесс

        if (countPool!=0) {
            for (int i = 0; i < countPool; i++) poolAbonem[i].leaveTrainingZone();
            countPool=0;
        }
        if (countGym!=0) {
            for (int i = 0; i < countGym; i++) gymAbonem[i].leaveTrainingZone();
            countGym=0;
        }
        if (countGroup!=0) {
            for (int i = 0; i < countGroup; i++) groupAbonem[i].leaveTrainingZone();
            countGroup=0;
        }
    }



}
