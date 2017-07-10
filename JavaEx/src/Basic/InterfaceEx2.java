package Basic;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class InterfaceEx2 extends Frame implements WindowListener{

	public InterfaceEx2() {
		setSize(300,300);
		setVisible(true);
		addWindowListener(this);
	}
	public void windowClosing(WindowEvent e) {
		System.exit(0);}
	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	
	
	public static void main(String[] args) {
		InterfaceEx2 ie =new InterfaceEx2();
		
	}
}
