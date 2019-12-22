package pharmacy.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GetCurrentDate {

    private LocalDate localDate = LocalDate.now();


    public String getCurrentDate() {
        return DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
    }


}
