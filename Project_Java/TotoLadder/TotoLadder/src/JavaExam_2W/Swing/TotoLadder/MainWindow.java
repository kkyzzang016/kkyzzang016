package JavaExam_2W.Swing.TotoLadder;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MainWindow extends JFrame implements ActionListener{


	static String conid;
	static String conpw;
	static int conpo;
	static int betCoin=0;
	static int ls,rs,tl,fl,hol,jjak=3;
	static int betRs;
	static boolean flag;
	
	Container cp;
	JLabel lblName, lblName2, lblPoint, lblPoint2 , lblMain;
	JLabel lblGame[] = new JLabel[4];
	JButton btnCharge , btnReturn ;
	MainWindowMethod mm = new MainWindowMethod();
	
	JCheckBox cbdeal1ls;
	JCheckBox cbdeal1rs;
	JCheckBox cbdeal2tl;
	JCheckBox cbdeal2fl;
	JCheckBox cbdeal3hol;
	JCheckBox cbdeal3jjak;
	
	JCheckBox cbgame1, cbgame2, cbgame3;
	JButton btnDeal, btnCheck;
	ButtonGroup bg1 = new ButtonGroup();
	ButtonGroup bg2 = new ButtonGroup();
	ButtonGroup bg3 = new ButtonGroup();
	 
	
	ImageIcon icon1 = new ImageIcon(
			"media\\logo2.png");
	ImageIcon icon3 = new ImageIcon(
			"media\\Ladder1.PNG");
	
	ImageIcon []images = new ImageIcon[4];
	
	public MainWindow(String title) {

		super(title); // JFrame 클래스로 생성자를 통해서 제목을 보냄
		// Swing에서는 프레임의 컴포넌트를 삽입하기 위해서는 프레임에서 Container를 얻어와야 한다.

		betCoin=0;
		ls=3;
		rs=3;
		tl=3;
		fl=3;
		hol=3;
		jjak=3;
		betRs=0;
		cp = this.getContentPane(); // 프레임에 기본페널이 있음
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 닫기
		// 프레임 크기, 위치와 함께
		this.setBounds(0, 0, 1100, 730);
		// 프레임 색상지정
		// this.setBackground(new Color(255, 255, 155));
		cp.setBackground(new Color(0,0,0));
		// 프레임 보이도록 설정, 항상 마지막에 와야한다.
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign() {
		this.setLayout(null);
		mm.poCheck();
		// 0. 상단 디자인
		JLabel logoLbl = new JLabel("", icon1, JLabel.CENTER);
		logoLbl.setBounds(40, 10, 250, 60);
		this.add(logoLbl);
		
		// 1. 회원 정보창 및 금액 충전칸
		
		lblName = new JLabel("회원");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(30, 100, 50, 30);
		this.add(lblName);
		
		lblName2 = new JLabel(conid); //아이디 소스 추가
		TitledBorder bord = new TitledBorder(new LineBorder(Color.yellow));
		lblName2.setBorder(bord);
		lblName2.setForeground(Color.WHITE);
		lblName2.setBounds(65, 100, 80, 30);
		this.add(lblName2);
		
		lblPoint = new JLabel("포인트");
		lblPoint.setForeground(Color.WHITE);
		lblPoint.setBounds(200, 100, 50, 30);
		this.add(lblPoint);
		
		lblPoint2 = new JLabel(String.valueOf(conpo)); //포인트 추가
		lblPoint2.setBorder(bord);
		lblPoint2.setForeground(Color.WHITE);
		lblPoint2.setBounds(250, 100, 100, 30);
		this.add(lblPoint2);
		
		btnCharge = new JButton("포인트충전");
		btnCharge.setBorder(bord);
		btnCharge.setBackground(Color.BLACK);
		btnCharge.setForeground(Color.WHITE);
		btnCharge.setBounds(400, 100, 80, 30);
		btnCharge.addActionListener(this);
		this.add(btnCharge);
		
		btnReturn = new JButton("포인트반환");
		btnReturn.setBorder(bord);
		btnReturn.setBackground(Color.BLACK);
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setBounds(500, 100, 80, 30);
		btnReturn.addActionListener(this);
		this.add(btnReturn);
		
		
		// 2. 메인 화면(사다리 게임 화면)
		lblMain = new JLabel(icon3);
		lblMain.setBounds(10, 150, 660, 530);
		lblMain.setBorder(bord);
		lblMain.setBackground(Color.WHITE);
		lblMain.setForeground(Color.WHITE);
		this.add(lblMain);
		
		images[0]=new ImageIcon("media\\Ladder-1.gif");
		images[1]=new ImageIcon("media\\Ladder-2.gif");
		images[2]=new ImageIcon("media\\Ladder-3.gif");
		images[3]=new ImageIcon("media\\Ladder-4.gif");
	
		for(int i=0;i<lblGame.length;i++){
		lblGame[i] = new JLabel(images[i]);
		lblGame[i].setBounds(10, 150, 660, 530);//---------------------------------------------
		lblGame[i].setBorder(bord);
		lblGame[i].setBackground(Color.WHITE);
		lblGame[i].setForeground(Color.WHITE);
		this.add(lblGame[i]);
		}
		
		// 3. 딜 창
		

		cbdeal1ls = new JCheckBox("좌\t출");
		cbdeal1ls.setBackground(Color.BLACK);
		cbdeal1ls.setForeground(Color.WHITE);
		cbdeal1ls.setBounds(850, 150, 60, 30);
		this.add(cbdeal1ls);
		cbdeal1ls.addActionListener(this);
		cbdeal1ls.setVisible(false);
		bg1.add(cbdeal1ls);
		
		//=========================================
		
		cbdeal1rs = new JCheckBox("우\t출");
		
		cbdeal1rs.setBackground(Color.BLACK);
		cbdeal1rs.setForeground(Color.WHITE);
		
		cbdeal1rs.setBounds(1000, 150, 60, 30);//___-----------------------------------------------
		this.add(cbdeal1rs);
		cbdeal1rs.addActionListener(this);
		cbdeal1rs.setVisible(false);
		bg1.add(cbdeal1rs);
		
		//=========================================
		cbdeal2tl = new JCheckBox("3\t줄");
		
		cbdeal2tl.setBackground(Color.BLACK);
		cbdeal2tl.setForeground(Color.WHITE);
		
		cbdeal2tl.setBounds(850, 300, 60, 30);
		this.add(cbdeal2tl);
		cbdeal2tl.addActionListener(this);
		cbdeal2tl.setVisible(false);
		bg2.add(cbdeal2tl);
		
		//=========================================
		cbdeal2fl = new JCheckBox("4\t줄");
		
		cbdeal2fl.setBackground(Color.BLACK);
		cbdeal2fl.setForeground(Color.WHITE);
		
		cbdeal2fl.setBounds(1000, 300, 60, 30);
		this.add(cbdeal2fl);
		cbdeal2fl.addActionListener(this);
		cbdeal2fl.setVisible(false);
		bg2.add(cbdeal2fl);
		
		//=========================================
		cbdeal3hol = new JCheckBox("  홀");
		
		cbdeal3hol.setBackground(Color.BLACK);
		cbdeal3hol.setForeground(Color.WHITE);
		
		cbdeal3hol.setBounds(850, 450, 60, 30);
		this.add(cbdeal3hol);
		cbdeal3hol.addActionListener(this);
		cbdeal3hol.setVisible(false);
		bg3.add(cbdeal3hol);
		
		//=========================================
		cbdeal3jjak = new JCheckBox("  짝");
		
		cbdeal3jjak.setBackground(Color.BLACK);
		cbdeal3jjak.setForeground(Color.WHITE);
		
		cbdeal3jjak.setBounds(1000, 450, 60, 30);
		this.add(cbdeal3jjak);
		cbdeal3jjak.addActionListener(this);
		cbdeal3jjak.setVisible(false);
		bg3.add(cbdeal3jjak);
		
		//=========================================
		
		cbgame1 = new JCheckBox("GAME 1");
		cbgame1.setBounds(700,150, 80, 30);
		cbgame1.setBackground(Color.BLACK);
		cbgame1.setForeground(Color.WHITE);
		cbgame1.addActionListener(this);
		this.add(cbgame1);
		cbgame2 = new JCheckBox("GAME 2");
		cbgame2.setBounds(700, 300, 80, 30);
		cbgame2.setBackground(Color.BLACK);
		cbgame2.setForeground(Color.WHITE);
		cbgame2.addActionListener(this);
		this.add(cbgame2);
		cbgame3 = new JCheckBox("GAME 3");
		cbgame3.setBounds(700, 450, 80, 30);
		cbgame3.setBackground(Color.BLACK);
		cbgame3.setForeground(Color.WHITE);
		cbgame3.addActionListener(this);
		this.add(cbgame3);
		
		btnDeal = new JButton("걸기");
		btnDeal.setBounds(700,550,150,120);
		btnDeal.addActionListener(this);
		this.add(btnDeal);
		
		btnCheck = new JButton("확인");
		btnCheck.setBounds(900,550,150,120);
		btnCheck.addActionListener(this);
		this.add(btnCheck);
		
	}
	public void betting(){
		
		int bet=(int)(Math.random()*4)+1;
		
		if(bet==1){
			lblMain.setVisible(false);
			lblGame[0].setVisible(true);
			lblGame[1].setVisible(false);
			lblGame[2].setVisible(false);
			lblGame[3].setVisible(false);
			betRs =1;
		}
		else if(bet==2){
			lblMain.setVisible(false);
			lblGame[0].setVisible(false);
			lblGame[1].setVisible(true);
			lblGame[2].setVisible(false);
			lblGame[3].setVisible(false);
			betRs =2;
		}
		else if(bet==3){
			lblMain.setVisible(false);
			lblGame[0].setVisible(false);
			lblGame[1].setVisible(false);
			lblGame[2].setVisible(true);
			lblGame[3].setVisible(false);
			betRs =3;
		}
		else if(bet==4){
			lblMain.setVisible(false);
			lblGame[0].setVisible(false);
			lblGame[1].setVisible(false);
			lblGame[2].setVisible(false);
			lblGame[3].setVisible(true);
			betRs =4;
		}
	}
	
	// =========================== 액션 메소드 =============================//
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(cbgame1 == ob){
			// 버튼클릭시 라디오버튼 그룹 1이 활성화 그전까지 비활성화
			if(!cbgame1.isSelected()){
				cbdeal1ls.setVisible(false);
				cbdeal1rs.setVisible(false);
				cbdeal1ls.disable();;
				cbdeal1rs.disable();
				ls=3;
				rs=3;
				
			}
			else {
				cbdeal1ls.setVisible(true);
				cbdeal1rs.setVisible(true);
				ls=2;
				rs=2;
			}
		}
		else if(cbgame2 == ob){
			// 버튼클릭시 라디오버튼 그룹 2가 활성화 그전까지 비활성화
			if(!cbgame2.isSelected()){
				cbdeal2tl.setVisible(false);
				cbdeal2fl.setVisible(false);
				cbdeal2tl.disable();
				cbdeal2fl.disable();
				tl=3;
				fl=3;
			}
			else {
				cbdeal2tl.setVisible(true);
				cbdeal2fl.setVisible(true);
				tl=2;
				fl=2;
			}
		}
		else if(cbgame3 == ob){
			// 버튼클릭시 라디오버튼 그룹 3이 활성화 그전까지 비활성화
			if(!cbgame3.isSelected()){
				cbdeal3hol.setVisible(false);
				cbdeal3jjak.setVisible(false);
				cbdeal3hol.disable();
				cbdeal3jjak.disable();
				hol=3;
				jjak=3;
			}
			else {
				cbdeal3hol.setVisible(true);
				cbdeal3jjak.setVisible(true);
				hol=2;
				jjak=2;
			}
		}
		else if(ob ==btnCharge){
			String num = JOptionPane.showInputDialog("충전 할 금액을 입력하세요.");
			int point = Integer.parseInt(num);
			mm.charge(point);
			this.setVisible(false);
			new MainWindow("메인");
			
			// 입력하는 숫자를 포인트에 더하여 추가
		}
		else if(btnReturn == ob){
			String num = JOptionPane.showInputDialog("환전 할 금액을 입력하세요.");
			int point = Integer.parseInt(num);
			mm.returPo(point);
			this.setVisible(false);
			new MainWindow("메인");
			// 환전할 금액을 포인트에서 차감
			// if 포인트보다 많은 금액을 환전을 원할시 오류메세지
			// else 포인트 차감 후 환전 메세지
		}
		
		else if(cbdeal1ls==ob){
			ls=1;
			rs=2;
		}
		else if(cbdeal1rs==ob){
			ls=2;
			rs=1;
		}
		else if(cbdeal2tl==ob){
			tl=1;
			fl=2;
		}
		else if(cbdeal2fl==ob){
			tl=2;
			fl=1;
		}
		else if(cbdeal3hol==ob){
			hol=1;
			jjak=2;
		}
		else if(cbdeal3jjak==ob){
			hol=2;
			jjak=1;
		}
		else if (btnDeal == ob) {
			// 클릭하면 딜이 저장되면서 x초 후 사다리게임 실행
			
			if(!flag){
			String num = JOptionPane.showInputDialog("베팅 할 금액을 입력하세요.");
			betCoin = Integer.parseInt(num);
			betting();
			
			mm.result(mm.gg(betCoin));
			System.out.println(betCoin);
			flag=true;
			}
			else JOptionPane.showMessageDialog(null, "확인버튼을 눌러주세요!");
			
		}
		else if(btnCheck==ob){
			flag=false;
			this.setVisible(false);
			new MainWindow("메인");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow mw = new MainWindow("메인화면");
		
	}


}
