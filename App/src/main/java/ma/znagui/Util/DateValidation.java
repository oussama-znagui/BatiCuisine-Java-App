package ma.znagui.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateValidation {
    public static Scanner scanner = new Scanner(System.in);
    public static LocalDate validationDate(String message){

        do {
            System.out.println(message);
            String s = scanner.nextLine();
            try {
                return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));


            }catch (Exception e){
                System.out.println("format (YYYY-MM-DD)");
            }
        }while (true);

    }
}
