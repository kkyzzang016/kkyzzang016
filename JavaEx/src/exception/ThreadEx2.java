
public class ThreadEx2 implements Runnable{

	public ThreadEx2() {
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		try {
			while(true){
				System.out.println("ÀÛ¾÷ Áß...");
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			
		}
	}
	
	public static void main(String[] args) {
		new ThreadEx2();
	}
}
