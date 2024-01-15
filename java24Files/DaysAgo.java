package java24Files;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DaysAgo {
    public static void main(String[] args) {
        ZoneId zoneErevan = ZoneId.of("Asia/Yerevan");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of days (in integer) to count back to from nom : ");
        int daysNum = scanner.nextInt();
        LocalDateTime localDate = LocalDateTime.now(zoneErevan);
        LocalDateTime dateAgo = localDate.minusDays(daysNum);
        String dateAgoFormatted = dateAgo.format(DateTimeFormatter.ofPattern("d MMMM uuuu HH:mm"));
        System.out.println("It was the date : " + dateAgoFormatted);
    }
}
