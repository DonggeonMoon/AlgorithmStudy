import javax.swing.text.DateFormatter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class test {
    public static void main(String[] args) {
        String yearMonthPattern = "2022년 02월.";
        TemporalAccessor temporalAccessor = DateTimeFormatter.ofPattern("yyyy년 MM월.").parse(yearMonthPattern);

        int year = temporalAccessor.get(ChronoField.YEAR);
        int month = temporalAccessor.get(ChronoField.MONTH_OF_YEAR);

        YearMonth yearMonth = YearMonth.of(year,month);
        LocalDateTime startDateTime = yearMonth.atDay(1).atTime(LocalTime.of(0, 0));
        LocalDateTime endDateTime = yearMonth.atEndOfMonth().atTime(23, 59, 59,999999999);
        System.out.println(startDateTime);
        System.out.println(endDateTime);
    }
}
