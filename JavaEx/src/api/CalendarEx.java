package api;

import java.util.Calendar;

public class CalendarEx {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = (cal.get(Calendar.MONTH)+1);
						//1���� 0�� ����Ѵ�.
		int date = cal.get(Calendar.DATE);
		
		System.out.println("�� : "+year);
		System.out.println("�� : "+month);
		System.out.println("�� : "+ date);
		
		int day1 = cal.get(Calendar.DAY_OF_YEAR);
		int day2 = cal.get(Calendar.DAY_OF_MONTH);
		int day3 = cal.get(Calendar.DAY_OF_WEEK);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		int hour = (cal.get(Calendar.HOUR)+12);
		int minute = cal.get(Calendar.MINUTE);
		int cho = cal.get(Calendar.SECOND);
		
		System.out.println("������ ������ : "+day1+"�� �Դϴ�.");
		System.out.println("������ �̹��� : "+day2+"�� �Դϴ�."	);
		System.out.println("������ �̹��� : "+day3+"��° �� �Դϴ�.");
		System.out.println("������ ������ : "+week+"�� �Դϴ�.\n");
		
		String[] yoil = {"��","��","ȭ","��","��","��","��"};
		
		System.out.println();
		
		System.out.println("������ "+yoil[day3-1]+"���� "+hour+"�� "+minute+"�� "+cho+"�� �Դϴ�.");
		
		//�޷� �����
		/*cal.set(year, month, date);
		cal.getActualMaximum(field);
		int dateCal = Calendar.DAY_OF_WEEK;
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");*/
		
		year = 2017;
		month = 7;
		cal.set(year, month-1,1);
		int startday = cal.get(Calendar.DAY_OF_WEEK);
		int lastday = cal.getActualMaximum(Calendar.DATE);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
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
