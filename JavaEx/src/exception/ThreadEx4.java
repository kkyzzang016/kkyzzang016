
public class ThreadEx4 extends Thread {

	public void run() {
		for(int i=0; i<10;i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("작업중(일)...");
		}
		System.out.println("작업이 완료 되었습니다.");
	}
	public static void main(String[] args) {
		ThreadEx4 te = new ThreadEx4();
		te.start();
		
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("main 작업중(일)");
		}
		
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("main2 작업중(일)");
		}
	}
}
