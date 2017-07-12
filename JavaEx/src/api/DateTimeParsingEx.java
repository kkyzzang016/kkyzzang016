package api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateTimeParsingEx {

	public static void main(String[] args) {
		DateTimeFormatter fm;
		LocalDate ld;
		LocalDateTime dt;
		
		
		/*ld = LocalDate.parse("2024-05-21");
		System.out.println(ld);
		
		fm = DateTimeFormatter.ISO_LOCAL_DATE;
		ld = LocalDate.parse("2024-05-21",fm);
		System.out.println(ld);
		
		fm = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		ld = LocalDate.parse("2024/05/21",fm);
		System.out.println(ld);
		
		fm = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		ld = LocalDate.parse("2024.05.21",fm);
		System.out.println(ld);*/
		
		fm =DateTimeFormatter.ofPattern("yyyy/MM/dd HH/mm");
		dt = LocalDateTime.of(1956, Month.APRIL,8,12,30);
		String formattedDateTime = dt.format(fm);
		formattedDateTime = dt.format(fm);
		
		System.out.println(formattedDateTime);
	}
}
