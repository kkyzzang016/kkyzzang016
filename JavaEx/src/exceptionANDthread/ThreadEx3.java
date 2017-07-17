package exceptionANDthread;
import java.awt.Toolkit;

public class ThreadEx3 {

	public ThreadEx3() {
		Thread t = new Thread(worker);
		Thread s = new Thread(sound);
		t.start();
		s.start();
	}
	
	Runnable worker = new Runnable() {
		public void run() {
			try {
				while(true) {
					System.out.println("�۾� ��...");
					Thread.sleep(1000);
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	};
	
	Runnable sound = new Runnable() {
		public void run() {
			try {
				while(true) {
					Toolkit tk = Toolkit.getDefaultToolkit();
					tk.beep();
					Thread.sleep(1000);
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	};
	
	
	public static void main(String[] args) {
		new ThreadEx3();
	}
}