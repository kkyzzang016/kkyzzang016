package uI;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MouseListenerEx2 extends Canvas implements MouseMotionListener{
   public JFrame f;
   public JTextField tf;
   public int x, y;
   public JButton b;
   public Button b2;
   
   public MouseListenerEx2() {
      b = new JButton("��ư(swing)");
      b2 = new Button("��ư(awt)");
      f = new JFrame();
      tf = new JTextField(0);
      f.add(new JLabel("���콺�� �����̰� drag �غ�����."),BorderLayout.NORTH);
      f.add(this, "Center");
      f.add(b, "East");
      f.add(b2, "West");
      f.add(tf, BorderLayout.SOUTH);
      addMouseMotionListener(this);
      f.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
         
      });
      f.setSize(500, 200);
      f.setVisible(true);
   }
   public void paint(Graphics g) {
      g.drawString("�ȳ��ϼ���", this.x, this.y);
   }
   public void setA(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   public static void main(String[] args) {
      new MouseListenerEx2();

   }
   @Override
   public void mouseDragged(MouseEvent e) {
      tf.setText("���콺 ������ �Ҹ�: �����..");
      
   }
   @Override
   public void mouseMoved(MouseEvent e) {
      tf.setText("���� ���콺�� ��ǥ:"+e.getX()+","+e.getY());
      setA(e.getX(),e.getY());
      this.repaint();
      
   }

}