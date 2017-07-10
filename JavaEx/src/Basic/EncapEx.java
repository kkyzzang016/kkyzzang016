package Basic;
public class EncapEx {

	/* 접근제어자
	 		- 객체의 사용을 제어하기 위한 제어자
	 	종류)
	 		-private = 클래스 내에서만 사용가능
	 		 default  = 같은 패키지 안에서만 사용가능
	 		 protected = 상속관계(extends)라면 외부 패키지 것도 사용가능
	 		 public = 모두 사용가능
	 		
	 	형식)
	 		-클래스 표현
	 			[접근지정자]		class	클래스
	 			
	 		-메서드 표현
	 			[접근지정자]		[자료형]	메서드명	(인자들){
	 			}
	 		-변수 표현
	 			[접근지정자]		[자료형]	변수명 = 데이터;
	 			
	 		-생성자 표현
	 			[접근지정자]		클래스명(인자들){
	 			}*/
	
	public static void main(String[] args) {
		Encap ec = new Encap();
		ec.setA(50);
		int su1 = ec.getA();  // 해당 클래스만 접근가능
		int su2 = ec.b;	   // 같은 패키지
		int su3 = ec.c;	   // 같은 패키지, 상속
		int su4 = ec.d;    // 전체 접근(공유)
	}
}

class Encap {
	private int a=10;
	int b=20;
	protected int c=30;
	public int d=40;
	public void setA(int a) {
		this.a=a;
	}
	public int getA() {
		return this.a;
	}
	
}