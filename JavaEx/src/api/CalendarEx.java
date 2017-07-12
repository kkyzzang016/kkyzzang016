package api;

import java.util.Calendar;

public class CalendarEx {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = (cal.get(Calendar.MONTH)+1);
						//1월이 0을 기억한다.
		int date = cal.get(Calendar.DATE);
		
		System.out.println("년 : "+year);
		System.out.println("월 : "+month);
		System.out.println("일 : "+ date);
		
		int day1 = cal.get(Calendar.DAY_OF_YEAR);
		int day2 = cal.get(Calendar.DAY_OF_MONTH);
		int day3 = cal.get(Calendar.DAY_OF_WEEK);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		int hour = (cal.get(Calendar.HOUR)+12);
		int minute = cal.get(Calendar.MINUTE);
		int cho = cal.get(Calendar.SECOND);
		
		System.out.println("오늘은 올해의 : "+day1+"날 입니다.");
		System.out.println("오늘은 이번달 : "+day2+"일 입니다."	);
		System.out.println("오늘은 이번주 : "+day3+"번째 날 입니다.");
		System.out.println("오늘은 올해의 : "+week+"주 입니다.\n");
		
		String[] yoil = {"일","월","화","수","목","금","토"};
		
		System.out.println();
		
		System.out.println("지금은 "+yoil[day3-1]+"요일 "+hour+"시 "+minute+"분 "+cho+"초 입니다.");
		
		//달력 만들기
		/*cal.set(year, month, date);
		cal.getActualMaximum(field);
		int dateCal = Calendar.DAY_OF_WEEK;
		System.out.println("일\t월\t화\t수\t목\t금\t토");*/
		
		year = 2017;
		month = 7;
		cal.set(year, month-1,1);
		int startday = cal.get(Calendar.DAY_OF_WEEK);
		int lastday = cal.getActualMaximum(Calendar.DATE);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i=1;i<lastday+startday;i++) {
			if(i<startday) {
				System.out.print("\t");
			continue;
			}
			System.out.print((i-startday+1) +"\t");
			if(i%7 ==0) System.out.println();
			
		}
	}
}
