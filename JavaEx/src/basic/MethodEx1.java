package basic;
public class MethodEx1 {

	public static int intA() {
		int num= 10;
		System.out.println("intA 메소드 실행");
		return num;
	}
	
	public static void intB() {
		System.out.println("intB 메소드 실행");
	}
	
	public static int jjak(int su) {
		int jjaksum=0;
		for(int i=0;i<=su;i++) {
			if(i%2==0) {
				System.out.print(i+"\t");
				jjaksum+=i;
			}
		}
		System.out.println();
		return jjaksum;
	}
	
	public static int hol(int su) {
		int holsum=0;
		for(int i=0;i<=su;i++) {
			if(i%2==1) {
				System.out.print(i+"\t");
				holsum+=i;
			}
		}
		System.out.println();
		return holsum;
	}
	public static void main(String[] args) {
		//intA();
		//intB();
		
		//int result = intA();
		//System.out.println("result : "+ result);
		//intB();
		
		int su = Integer.parseInt(args[0]);
		System.out.println(args[0]);
		int jjakresult = hol(su);
		System.out.println("결과 : " + jjakresult);
		int holresult = jjak(su);
		System.out.println("결과 : " + holresult);

	}
}
