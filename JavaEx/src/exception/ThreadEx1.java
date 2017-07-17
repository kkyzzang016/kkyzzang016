
public class ThreadEx1 extends Thread{

	public ThreadEx1() {
		super("ù��° ������");
	}
	public void run() {
		
		
		try {
			while(true) {
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
