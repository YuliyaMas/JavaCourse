package java24Files;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;


public class DataTimeExercise {
    public static void main(String[] args) {
        System.out.println("Input the month of the current year using integer (from 1 or 01 to 12)");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        LocalDate localDate = LocalDate.now();
//        Source : https://www.tutorialspoint.com/javatime/javatime_localdate_withmonth.htm
        LocalDate firstDayOfMonth = localDate.withMonth(month).with(TemporalAdjusters.firstDayOfMonth());
//        Source : https://www.tabnine.com/code/java/classes/java.time.temporal.ChronoField
        while(firstDayOfMonth.get(ChronoField.MONTH_OF_YEAR) == month) {
            System.out.println(firstDayOfMonth.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
            firstDayOfMonth = firstDayOfMonth.plusDays(1);
        }
    }
}
