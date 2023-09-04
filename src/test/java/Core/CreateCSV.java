package Core;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CreateCSV extends BasePage{
        public void createFileCSV(List list) throws IOException {

//            DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
//            Date date = new Date();
//            dateFormat.format(date)

            File file = new File("C:\\QA\\Find_on_HH\\src\\test\\resources\\data.csv");
            try (PrintWriter pw = new PrintWriter(file)){
                list.stream().forEach(pw::println);

            }
        }

    public void addToCSV() throws IOException, InterruptedException {
        List a = getVacanciesURL.getUrlVacancies();
        System.out.println(a.size());
        createFileCSV(a);
    }


}
