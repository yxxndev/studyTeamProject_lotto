//package num_1;
//// 추첨 결과 확인 창 GUI
//
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//class LotteryConfirmation extends JFrame {
////	static JButton btn1; // 생성해서 리턴을 하는거면 꼭 필드로 지정하지 않아도 돼요
////	static JButton btn2;
////	DataBase dataBase; // CMR에서 받아오려고 주석처리함
//
//	// 버튼1(다시하기) 생성
//	JButton againBtn() {
//		ImageIcon img1 = new ImageIcon(LotteryConfirmation.class.getResource("/image/again.png"));
//		ImageIcon img3 = new ImageIcon(LotteryConfirmation.class.getResource("/image/againClick.png"));
//		JButton btn1 = btn1 = new JButton(img1);
//		btn1.setRolloverIcon(img3);
//		btn1.setBorderPainted(false);
//		btn1.setContentAreaFilled(false);
//		btn1.setBounds(120, 130, 150, 70);
//
//		btn1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				DataBase dataBase = new DataBase();
//				new LottoCMR(dataBase);
//				setVisible(false);
//			}
//		});
//		return btn1;
//	}
//
//	// 버튼2(종료) 생성
//	JButton exitBtn() {
//		ImageIcon img2 = new ImageIcon(LotteryConfirmation.class.getResource("/image/exit.png"));
//		ImageIcon img4 = new ImageIcon(LotteryConfirmation.class.getResource("/image/exitClick.png"));
//		JButton btn2 = new JButton(img2);
//		btn2.setRolloverIcon(img4);
//		btn2.setBorderPainted(false);
//		btn2.setContentAreaFilled(false);
//		btn2.setBounds(320, 130, 150, 70);
//
//		btn2.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				System.exit(0); // 완전히 종료
//			}
//		});
//		return btn2;
//	}
//
//	// 배경깔기
//	static JPanel bg = new JPanel() {
//		Image background = new ImageIcon(LotteryConfirmation.class.getResource("/image/background.png")).getImage();
//
//		public void paint(Graphics g) {
//			g.drawImage(background, 0, 0, null);
//		}
//	};
//
//	// 섹션1 생성 : "추첨 결과" 텍스트
//	static JLabel section1 = new JLabel() {
//		Image section1 = new ImageIcon(LotteryConfirmation.class.getResource("/image/headerTest.png")).getImage();
//
//		public void paintComponent(Graphics g) {
//			g.drawImage(section1, 0, 50, null);
//		}
//	};
//
//	// 섹션2 생성: 당첨번호 출력
//	static JLabel section2 = new JLabel() {
//		Image section2Test = new ImageIcon(LotteryConfirmation.class.getResource("/image/testSection2.png")).getImage();
////		Image sectionNum1 = new ImageIcon(LotteryConfirmation.class.getResource("../image/1_50px.png")).getImage();
////		Image sectionNum2 = new ImageIcon(LotteryConfirmation.class.getResource("../image/2_50px.png")).getImage();
////		Image sectionNum3 = new ImageIcon(LotteryConfirmation.class.getResource("../image/3_50px.png")).getImage();
////		Image sectionNum4 = new ImageIcon(LotteryConfirmation.class.getResource("../image/1_50px.png")).getImage();
////		Image sectionNum5 = new ImageIcon(LotteryConfirmation.class.getResource("../image/2_50px.png")).getImage();
////		Image sectionNum6 = new ImageIcon(LotteryConfirmation.class.getResource("../image/3_50px.png")).getImage();
////		Image sectionPlus = new ImageIcon(LotteryConfirmation.class.getResource("../image/plus.png")).getImage();
////		Image sectionNumB = new ImageIcon(LotteryConfirmation.class.getResource("../image/7_50px.png")).getImage();
//
//		public void paintComponent(Graphics g) {
//			g.drawImage(section2Test, 0, 0, null);
////			g.drawImage(sectionNum1,  60 , 90,  null);
////			g.drawImage(sectionNum2,  120 , 90,  null);
////			g.drawImage(sectionNum3,  180 , 90,  null);
////			g.drawImage(sectionNum4,  240 , 90,  null);
////			g.drawImage(sectionNum5,  300 , 90,  null);
////			g.drawImage(sectionNum6,  360 , 90,  null);
////			g.drawImage(sectionPlus,  420 , 90,  null);
////			g.drawImage(sectionNumB,  480 , 90,  null);
//		}
//	};
//
//	// 섹션3 생성: 당첨 최고 등수 + 당첨 총 금액 출력
//	static JLabel section3 = new JLabel() {
//		Image section3 = new ImageIcon(LotteryConfirmation.class.getResource("/image/reword.png")).getImage();
//
//		public void paintComponent(Graphics g) {
//			g.drawImage(section3, 0, 0, null);
//		}
//	};
//
//	// 섹션4 생성: 유저 번호 출력 (A~E)
//	static JLabel section4 = new JLabel() {
//		Image section4 = new ImageIcon(LotteryConfirmation.class.getResource("/image/result.png")).getImage();
//
//		public void paintComponent(Graphics g) {
//			g.drawImage(section4, 0, 0, null);
//		}
//	};
//
//	// 섹션5 생성:
////	public JLabel section5 = new JLabel() { // 테스트를 위해 임시 주석처리
////	};
//
//	public LotteryConfirmation(DataBase dataBase) {
//		resultframe(dataBase);
//	}
//
//	public void resultframe(DataBase dataBase) {
//		JPanel pnlUserNum = new JPanel();
//		PrintPanel p = new PrintPanel(dataBase); // PrintPanel 참조하려고 객체생성
//		pnlUserNum = p.userNumsArea;
//		add(pnlUserNum);
//		Result result = new Result(dataBase);
//		JPanel resultPnl = result.lotteryNums();
//		
//		add(resultPnl);
//		
//		
//		JButton btn1 = againBtn();
//		JButton btn2 = exitBtn();
//
//		add(btn1); // 임시 다시시작 버튼 추가
//		add(btn2);
//
//		
//		// 섹션1 추가
//		section1.setLayout(null);
//		section1.setBounds(0, 0, 600, 110);
//		add(section1);
//
//		// 섹션2 추가
//		section2.setLayout(null);
//		section2.setBounds(0, 150, 600, 100);
//		add(section2);
//
//		// 섹션3 추가
//		section3.setLayout(null);
//		section3.setBounds(0, 235, 600, 70);
//		add(section3);
//
//		// 섹션4 추가
//		section4.setLayout(null);
//		section4.setBounds(50, 320, 600, 350);
//		add(section4);
//
//		// 섹션5 추가
////		section5.add(btn1); // 테스트를 위해 임시 주석처리
////		section5.add(btn2);
////		section5.setLayout(null);
////		section5.setBounds(0, 550, 600, 200);
////		add(section5);
//
//		// 배경이미지
//		bg.setLayout(null);
//		bg.setBounds(0, 0, 600, 800);
//		add(bg);
//
//		setTitle("추첨 결과");
//		setSize(600, 800);
//		setResizable(false);
//		setLocationRelativeTo(null);
//		setLayout(null);
//		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//	}
//}
