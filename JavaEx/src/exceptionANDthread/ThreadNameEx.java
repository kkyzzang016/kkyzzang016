package exceptionANDthread;

public class ThreadNameEx {

	public static void main(String[] args) {
		Thread maint = Thread.currentThread();
		System.out.println("프로그램 시작 스레드 이름 : "+maint.getName());
		
		ThreadA ta = new ThreadA();
		System.out.println("작업 스레드 이름 : "+ta.getName());
		ta.start();
		
		ThreadB tb = new ThreadB();
		System.out.println("작업 스레드 이름 : "+tb.getName());
		tb.start();
	}
}
class ThreadA extends Thread{
	public ThreadA() {
		setName("ThreadA");
		
	}
	public void run() {
		for(int i=0;i<2;i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
	}
}
class ThreadB extends Thread{
	@Override
	public void run() {
		for(int i=0; i<2;i++) {
			System.out.println(getName()+"가 출력한 내용");
		}
	}
}
