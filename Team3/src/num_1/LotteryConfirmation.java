package num_1;
// 추첨 결과 확인 창 GUI

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class LotteryConfirmation extends JFrame {
	JButton btn1;
	JButton btn2;
	ImageIcon img1 = new ImageIcon(LotteryConfirmation.class.getResource("../image/again.png"));
	ImageIcon img2 = new ImageIcon(LotteryConfirmation.class.getResource("../image/exit.png"));
	
	static JPanel bg = new JPanel() {
		Image background = new ImageIcon(LotteryConfirmation.class.getResource("../image/background.png")).getImage();
		
		public void paint(Graphics g) {
			g.drawImage(background,  0 , 0,  null);
		}
	};
	
	static JLabel section1 = new JLabel() {
		Image section1 = new ImageIcon(LotteryConfirmation.class.getResource("../image/headerTest.png")).getImage();
		
		public void paintComponent(Graphics g) {
			g.drawImage(section1,  0 , 50,  null);
		}
	};
	
	static JLabel section2 = new JLabel() {
		Image section2Test = new ImageIcon(LotteryConfirmation.class.getResource("../image/testSection2.png")).getImage();
//		Image sectionNum1 = new ImageIcon(LotteryConfirmation.class.getResource("../image/1_50px.png")).getImage();
//		Image sectionNum2 = new ImageIcon(LotteryConfirmation.class.getResource("../image/2_50px.png")).getImage();
//		Image sectionNum3 = new ImageIcon(LotteryConfirmation.class.getResource("../image/3_50px.png")).getImage();
//		Image sectionNum4 = new ImageIcon(LotteryConfirmation.class.getResource("../image/1_50px.png")).getImage();
//		Image sectionNum5 = new ImageIcon(LotteryConfirmation.class.getResource("../image/2_50px.png")).getImage();
//		Image sectionNum6 = new ImageIcon(LotteryConfirmation.class.getResource("../image/3_50px.png")).getImage();
//		Image sectionPlus = new ImageIcon(LotteryConfirmation.class.getResource("../image/plus.png")).getImage();
//		Image sectionNumB = new ImageIcon(LotteryConfirmation.class.getResource("../image/7_50px.png")).getImage();
		
		public void paintComponent(Graphics g) {
			g.drawImage(section2Test,  0 , 0,  null);
//			g.drawImage(sectionNum1,  60 , 90,  null);
//			g.drawImage(sectionNum2,  120 , 90,  null);
//			g.drawImage(sectionNum3,  180 , 90,  null);
//			g.drawImage(sectionNum4,  240 , 90,  null);
//			g.drawImage(sectionNum5,  300 , 90,  null);
//			g.drawImage(sectionNum6,  360 , 90,  null);
//			g.drawImage(sectionPlus,  420 , 90,  null);
//			g.drawImage(sectionNumB,  480 , 90,  null);
		}
	};
	
	static JLabel section3 = new JLabel() {
		Image section3 = new ImageIcon(LotteryConfirmation.class.getResource("../image/reword.png")).getImage();
		
		public void paintComponent(Graphics g) {
			g.drawImage(section3,  0 , 0,  null);
		}
	};

	static JLabel section4 = new JLabel() {
		Image section4 = new ImageIcon(LotteryConfirmation.class.getResource("../image/result.png")).getImage();
		
		public void paintComponent(Graphics g) {
			g.drawImage(section4,  0 , 0,  null);
		}
	};
	

	public JLabel section5 = new JLabel() {


//		Image sectionBtn1 = new ImageIcon(LotteryConfirmation.class.getResource("../image/again.png")).getImage();
//		Image sectionBtn2 = new ImageIcon(LotteryConfirmation.class.getResource("../image/exit.png")).getImage();
//		
//		
//		public void paintComponent(Graphics g) {
//			g.drawImage(sectionBtn1,  120 , 120,  null);
//			g.drawImage(sectionBtn2,  320 , 120,  null);
//		}
	};
	
	public LotteryConfirmation(DataBase dataBase) {
		resultframe(dataBase);
	}

	public void resultframe(DataBase dataBase) {
		// 헤더 ("추첨 결과")
		section1.setLayout(null);
		section1.setBounds(0, 0, 600, 110);
		add(section1);

		// 당첨 번호 섹션
		section2.setLayout(null);
		section2.setBounds(0, 150, 600, 100);
		add(section2);

		// 당첨 등수 + 당첨 총 금액 안내 섹션
		section3.setLayout(null);
		section3.setBounds(0, 235, 600, 70);
		add(section3);

		// 내 추첨 번호 결과 표 섹션
		section4.setLayout(null);
		section4.setBounds(50, 320, 600, 350);
		add(section4);
		
		// 다시하기 버튼1 + 종료 버튼2 + 툴팁 1개
		
		
		btn1 = new JButton(img1);
		btn1.setBorderPainted(false);
		btn1.setContentAreaFilled(false);
		btn1.setBounds(120, 130, 150, 70);
		btn2 = new JButton(img2);
		btn2.setBorderPainted(false);
		btn2.setContentAreaFilled(false);
		btn2.setBounds(320, 130, 150, 70);
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LottoCMR(dataBase);
				setVisible(false);
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		section5.add(btn1);
		section5.add(btn2);
		section5.setLayout(null);
		section5.setBounds(0, 550, 600, 200);
		add(section5);
		
		// 배경이미지
		bg.setLayout(null);
		bg.setBounds(0, 0, 600, 800);
		add(bg);
		
		
		setTitle("추첨 결과");
		setSize(600, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

//	public static void main(String[] args) {
//		new LotteryConfirmation();
//	}
}
