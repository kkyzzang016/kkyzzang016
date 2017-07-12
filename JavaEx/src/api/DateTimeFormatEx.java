package api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatEx {
   public static void main(String[] args) {
      LocalDateTime now = LocalDateTime.now();
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy�� M�� d�� a h�� m�� ");
      String nowString = now.format(dateTimeFormatter);
      System.out.println(nowString);
   }

}