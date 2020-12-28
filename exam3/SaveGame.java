package exam3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

//сохранить текущую позицию игры
public class SaveGame implements Command{

    static Step saveStep;
    private static File file = null;

    @Override
    public void execute() {

        //имя файла - текущая дата и время
        Date date = new Date();
        SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
        file = new File("src/exam3/save/"+ formatForDate.format(date) +".ser");

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(file))){
            outFile.writeObject(saveStep);
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Игра сохранена!");

    }

    public void setSaveStep(Step saveStep) {
        this.saveStep = saveStep;
    }
}
