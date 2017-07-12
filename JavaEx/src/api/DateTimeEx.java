package api;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateTimeEx {

	public static void main(String[] args) {
		LocalDateTime startDateTime = LocalDateTime.of(2023,1,1,9,0,0);
		System.out.println("시작일 : "+startDateTime);
		
		LocalDateTime endDateTime = LocalDateTime.of(2024,3,31,18,0,0);
		System.out.println("종료일 : "+endDateTime+"\n");
		
		if(startDateTime.isBefore(endDateTime)) {
			System.out.println("진행 중입니다."+"\n");
		}
		else if(startDateTime.isEqual(endDateTime)) {
			System.out.println("종료합니다."+"\n");
		}
		else if(startDateTime.isAfter(endDateTime)) {
			System.out.println("종료했습니다."+"\n");
		}
		
		System.out.println("[ 종료까지 남은시간 ]");
		long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
		long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
		long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);
		long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
		long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);
		
		remainYear = ChronoUnit.YEARS.between(startDateTime, endDateTime);
		remainMonth = ChronoUnit.MONTHS.between(startDateTime, endDateTime);
		remainDay = ChronoUnit.DAYS.between(startDateTime, endDateTime);
		remainHour = ChronoUnit.HOURS.between(startDateTime, endDateTime);
		remainMinute = ChronoUnit.MINUTES.between(startDateTime, endDateTime);
		remainSecond = ChronoUnit.SECONDS.between(startDateTime, endDateTime);
		
		System.out.println("남은 해 : "+remainYear);
		System.out.println("남은 달 : "+remainMonth);
		System.out.println("남은 일 : "+remainDay);
		System.out.println("남은 시간 : "+remainHour);
		System.out.println("남은 분 : "+remainMinute);
		System.out.println("남은 초 : "+remainSecond);
		
		//------------------------------------------------------------------
		System.out.println("[ 남은 기간 ]");
		Period pr = Period.between(startDateTime.toLocalDate(),endDateTime.toLocalDate());
		System.out.println("남은 기간 : "+pr.getYears()+"년 ");
		System.out.println(pr.getMonths()+"달 ");
		System.out.println(pr.getDays()+"일 \n");
		//------------------------------------------------------------------
		Duration dr = Duration.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());
		System.out.println("남은 초 : "+dr.getSeconds());
	}
}
