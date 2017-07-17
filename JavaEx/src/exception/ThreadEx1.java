
public class ThreadEx1 extends Thread{

	public ThreadEx1() {
		super("첫번째 스레드");
	}
	public void run() {
		
		
		try {
			while(true) {
				System.out.println("작업 중...");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ThreadEx1 t = new ThreadEx1();
		t.start();
	}
}
