package Basic;
import java.util.Scanner;

class Student01{
	int score;
	String name;
	public Student01(String name, int scores) {
		this.name=name;
		this.score=score;
	}
}

public class Exercise09 {

	public Scanner scan;
	public Student01[] list;
	
	public Exercise09() {//생성자
		scan= new Scanner(System.in); 
	}
	
	public void addStudent() {
		for(int i=0; i<list.length;i++) {
			System.out.println("학생 이름 입력 : ");
			String name = inputStr();
			System.out.println("학생 점수 입력 : ");
			int scores = inputNum();
			list[i] = new Student01(name,scores);
		}
	}
	
	public int inputNum() {
		return scan.nextInt();
	}
	
	public String inputStr() {
		return scan.next();
	}
	
	public void execute() {
		
		do {
		System.out.println("==================================================");
		System.out.println("    1.학생수    |    2.점수입력    |    3.점수리스트    |    4.분석    |    5.종료   ");
		System.out.println("==================================================");
		System.out.print("선택>\t");
		
		switch(inputNum()) {
		
		case 1:
			System.out.println("학생수를 입력하세요.");
			int su = inputNum();
			list = new Student01[su];
			System.out.println(list.length + "명의 학생들을 추가해 주세요");
			addStudent();
			break;
			
		case 2:
			Student01 st = null;
			System.out.println("학생 이름을 입력하세요 : ");
			String name = inputStr();
			boolean checked = false;
			for(int i=0; i<list.length;i++) {
				st = list[i];
				if(st.name.equals(name)) {
					checked = true;
					break;
				}
			}
			if(checked) {
				System.out.println(name + "에 정수를 입력하세요 : ");
				st.score = inputNum();
			}else System.out.println("정보가 없습니다.");
			break;
			
		case 3:
			for(Student01 a : list) {
				System.out.println(a.score);
			}
			break;
		}
	}while(true);
		
	}
	public static void main(String[] args) {
		Exercise09 e = new Exercise09();
		e.execute();
	}
}
