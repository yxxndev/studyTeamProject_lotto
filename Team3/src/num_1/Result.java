package num_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.Timer;

// 당첨결과 관련 로직 

class Result extends JFrame {
	PrintBallNumber pBN = new PrintBallNumber();
	ArrayList<Integer> lotteryNums = new ArrayList<Integer>();
	int bonusNum;
	int totalMoney;
	ArrayList<UserSelectNum> aList;
	ArrayList<UserSelectNum> bList;
	ArrayList<UserSelectNum> cList;
	ArrayList<UserSelectNum> dList;
	ArrayList<UserSelectNum> eList;
	ArrayList<String> scores = new ArrayList<>();

	int count = 1;

	private int x;
	private int y;
	private int R = 50;
	private double alpha = 0;

	private final int SPEED = 1;
	private final int BALL_COUNT = 45; // 공 갯수
	private final int BALL_DISTANCE = 35; // 원과의 거리
	private final int VIRTUAL_CIRCLE_RADIUS = 80; // 가상의 원의 반지름
	private final ImageIcon[] BALL_IMAGES = new ImageIcon[BALL_COUNT];
	private JPanel drawPnl = new JPanel();
	private int timerX;
	private int timerY;
	private Timer timer;
	private int timerI;

	public Result(DataBase data) {
		
		aList = data.map.get("A");
		bList = data.map.get("B");
		cList = data.map.get("C");
		dList = data.map.get("D");
		eList = data.map.get("E");

		Collections.sort(aList);
		Collections.sort(bList);
		Collections.sort(cList);
		Collections.sort(dList);
		Collections.sort(eList);

		// 당첨번호 숫자조정용
		lotteryNumRan();
//		lotteryNums.add(1);
//		lotteryNums.add(2);
//		lotteryNums.add(3);
//		lotteryNums.add(4);
//		lotteryNums.add(5);
//		lotteryNums.add(7);
//		bonusNum = 6;
		
		JPanel bigPnl = new JPanel();
		bigPnl.setBounds(0, 0, 2000, 2000);
		bigPnl.setBackground(new Color(255, 0, 0, 0));
		add(bigPnl);
		JLayeredPane layeredPane = new JLayeredPane();
		
		// 추첨 이미지
		JPanel pnlBallImage = loadBallImages();
		pnlBallImage.setLayout(null);
		pnlBallImage.setBounds(470, 100, 800, 600);
		pnlBallImage.setBackground(new Color(255, 0, 0, 0));
		add(pnlBallImage);
		
		RotateImage rotateImage = new RotateImage();
		JLabel lbl = new JLabel();
		lbl.setBounds(911, 254, 54, 54);
		layeredPane.setComponentZOrder(lbl, 0);
		bigPnl.add(lbl);
		ImageIcon[] moveCircles = rotateImage.moveAngle();
		timerX = 911;
		timerY = 254;
		timerI = 0;
		timer = new Timer(40, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ImageIcon icon = moveCircles[timerI];
				timerI++;
				if (timerI == 34)
					timerI = 0;
				lbl.setIcon(icon);
				lbl.setBounds(timerX, timerY, 54, 54);
				System.out.println(lbl.getBounds());
				if (timerY >= 125)
					timerY -= 10;
				if (timerY ==124)
					timerX -= 10;
				if (timerX < 77) {
					if (count < 7) {
						printDrawNumber();
						count++;
					} else if (count == 7) {
						drawBounsNumber();
						count++;
					}
//					try {
//						Thread.sleep(100); // drawPnl.revalidate();를 돕기 위한 딜레이를 줌. 안주면 그림에 잔상이 남아서 이상하게 출력되는 거 처럼 보인다.
//						} 
//					catch (InterruptedException e) {
//							e.printStackTrace();
//						}
					timer.stop();
				}
			}
		});
		
//		무한클릭 안되게
		
		
		// 당첨번호 패널
		drawPnl.setLayout(new FlowLayout(FlowLayout.LEFT));
		drawPnl.setBackground(new Color(255, 0, 0, 0));
		drawPnl.setBounds(20, 120, 550, 80);
		add(drawPnl);
		
		
		// 추첨 버튼
		JButton btnTest = new JButton("테스트용 버튼");
		btnTest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (count != 8) {
					timerX = 911;
					timerY = 254;
					lbl.setVisible(true);
					timer.start();
				}
			}
		});
		btnTest.setBounds(500, 500, 100, 100);
		pnlBallImage.add(btnTest);

		// ---------------------------------------------

		JButton btnExit = exitBtn();
		add(btnExit);

		JButton btnAgain = againBtn();
		add(btnAgain);

		// pnl2 : 유저 선택 숫자 패널
		// lbl3 : 각 등수 라벨
		// A 항목 정보
		if (aList.size() == 6) {
			int correctCount = compareNum("A", aList);
			String score = whatScore(correctCount, "A", aList);
			JPanel pnl2 = printUserNumResult("A", aList, score);
			JLabel lbl3 = printScoreLabel(score);
			moneyPlus(score);

			pnl2.setBackground(new Color(255, 0, 0, 0));
			pnl2.setBounds(60, 315, 600, 80);
			add(pnl2);
			lbl3.setBounds(110, 315, 100, 50);
			lbl3.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
			add(lbl3);
			scores.add(lbl3.getText());
		}

		// B 항목 정보
		if (bList.size() == 6) {
			int correctCount = compareNum("B", bList);
			String score = whatScore(correctCount, "B", bList);
			JPanel pnl2 = printUserNumResult("B", bList, score);
			JLabel lbl3 = printScoreLabel(score);
			moneyPlus(score);

			pnl2.setBackground(new Color(255, 0, 0, 0));
			pnl2.setBounds(60, 380, 600, 110);
			add(pnl2);
			lbl3.setBounds(110, 380, 100, 50);
			lbl3.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
			add(lbl3);
			scores.add(lbl3.getText());
		}

		// C 항목 정보
		if (cList.size() == 6) {
			int correctCount = compareNum("C", cList);
			String score = whatScore(correctCount, "C", cList);
			JPanel pnl2 = printUserNumResult("C", cList, score);
			JLabel lbl3 = printScoreLabel(score);
			moneyPlus(score);

			pnl2.setBackground(new Color(255, 0, 0, 0));
			pnl2.setBounds(60, 445, 600, 110);
			add(pnl2);
			lbl3.setBounds(110, 445, 100, 50);
			lbl3.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
			add(lbl3);
			scores.add(lbl3.getText());
		}

		// D 항목 정보
		if (dList.size() == 6) {
			int correctCount = compareNum("D", dList);
			String score = whatScore(correctCount, "D", dList);
			JPanel pnl2 = printUserNumResult("D", dList, score);
			JLabel lbl3 = printScoreLabel(score);
			moneyPlus(score);

			pnl2.setBackground(new Color(255, 0, 0, 0));
			pnl2.setBounds(60, 510, 600, 110);
			add(pnl2);
			lbl3.setBounds(110, 510, 100, 50);
			lbl3.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
			add(lbl3);
			scores.add(lbl3.getText());
		}

		// E 항목 정보
		if (eList.size() == 6) {
			int correctCount = compareNum("E", eList);
			String score = whatScore(correctCount, "E", eList);
			JPanel pnl2 = printUserNumResult("E", eList, score);
			JLabel lbl3 = printScoreLabel(score);
			moneyPlus(score);

			pnl2.setBackground(new Color(255, 0, 0, 0));
			pnl2.setBounds(60, 580, 600, 110);
			add(pnl2);
			lbl3.setBounds(110, 580, 100, 50);
			lbl3.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
			add(lbl3);
			scores.add(lbl3.getText());
		}

		// 총 당첨금액 라벨
		JLabel lblMoney = totalMoneyLabel();
		lblMoney.setFont(new Font("Malgun Gothic", Font.BOLD, 30));

		// 등수 안내 라벨
		JLabel lblInfo = new JLabel(new ImageIcon(Result.class.getResource("/image/tooltip축소.png")));
		lblInfo.setToolTipText("1등: 128,000,000원 \n 2등: 50,000,000원 \n 3등: 1,500,000원 \n 4등: 50,000원 \n 5등: 5,000원");
		lblInfo.setBackground(new Color(255, 0, 0, 0));
		lblInfo.setBounds(440, 210, 80, 80);
		getContentPane().add(lblInfo);

		// 총 등수 라벨
		JLabel totalScore = new JLabel();
		if (scores.contains("1등")) {
			totalScore.setText("1");
		} else if (scores.contains("2등")) {
			totalScore.setText("2");
		} else if (scores.contains("3등")) {
			totalScore.setText("3");
		} else if (scores.contains("4등")) {
			totalScore.setText("4");
		} else if (scores.contains("5등")) {
			totalScore.setText("5");
		} else {
			totalScore.setText("-");
		}
		totalScore.setFont(new Font("Malgun Gothic", Font.BOLD, 30));

		// 총 등수 패널
		JPanel pnlTotScore = new JPanel(new FlowLayout());
		pnlTotScore.setBounds(250, 185, 200, 50);
		pnlTotScore.setBackground(new Color(255, 0, 0, 0));
		pnlTotScore.add(totalScore, "Left");
		add(pnlTotScore);

		// 총 가격 패널
		JPanel pnlTotMoney = new JPanel(new FlowLayout());
		pnlTotMoney.setBounds(250, 225, 200, 80);
		pnlTotMoney.setBackground(new Color(255, 0, 0, 0));
		pnlTotMoney.add(lblMoney, "Left");
		add(pnlTotMoney);

		// ---------------------------------------------------------------------------

		// 섹션1 생성 : "추첨 결과" 텍스트
		JLabel section1 = new JLabel(new ImageIcon(Result.class.getResource("/image/headerTest.png")));
		section1.setBounds(0, 0, 600, 110);
		add(section1);

//		// 섹션2 생성: 당첨번호 출력
//		JLabel section2 = new JLabel(new ImageIcon(Result.class.getResource("/image/testSection2.png")));
//		section2.setBounds(0, 150, 600, 100);
//		add(section2);

		// 섹션3 생성: 당첨 최고 등수 + 당첨 총 금액 출력
		JLabel section3 = new JLabel(new ImageIcon(Result.class.getResource("/image/reword수정.png")));
		section3.setBounds(0, 200, 600, 70);
		add(section3);

		// 섹션4 생성: 유저 번호 출력 (A~E)
		JLabel section4 = new JLabel(new ImageIcon(Result.class.getResource("/image/result.png")));
		section4.setBounds(0, 300, 600, 350);
		add(section4);

		


		// 배경깔기
		JPanel bgPnl = new JPanel();
		JLabel bgLbl = new JLabel((new ImageIcon(Result.class.getResource("/image/background.png"))));
		bgPnl.setBounds(0, 0, 600, 800);
		bgPnl.add(bgLbl);

		JPanel bgPnl2 = new JPanel();
		JLabel bgLbl2 = new JLabel((new ImageIcon(Result.class.getResource("/image/background.png"))));
		bgPnl2.setBounds(600, 0, 600, 800);
		bgPnl2.add(bgLbl2);

		add(bgPnl);
		add(bgPnl2);

		setBackground(Color.WHITE);
		setTitle("추첨 결과");
		setSize(1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// ---------------------------------------------------------------------
	// 아래는 번호 패널, 라벨 관련 메소드
	/**
	 * 복권당 사용자가 선택한 번호 패널에 부착
	 * 
	 * @param key, arrList, score
	 * @return JPanel
	 */
	JPanel printUserNumResult(String key, ArrayList<UserSelectNum> arrList, String score) {
		JPanel pnl = new JPanel(new FlowLayout());
		JPanel pnl1 = new JPanel();
		pnl1.setLayout(new OverlayLayout(pnl1));
		JPanel pnl2 = new JPanel();
		pnl2.setLayout(new OverlayLayout(pnl2));
		JPanel pnl3 = new JPanel();
		pnl3.setLayout(new OverlayLayout(pnl3));
		JPanel pnl4 = new JPanel();
		pnl4.setLayout(new OverlayLayout(pnl4));
		JPanel pnl5 = new JPanel();
		pnl5.setLayout(new OverlayLayout(pnl5));
		JPanel pnl6 = new JPanel();
		pnl6.setLayout(new OverlayLayout(pnl6));

		JPanel[] pnls = { pnl1, pnl2, pnl3, pnl4, pnl5, pnl6 };

		int i = 0;
		for (UserSelectNum elem : arrList) {
			int num = elem.getLotteryNum();
			int index = num - 1;

			// 숫자 아이콘 라벨
			JLabel lblNumIcon = new JLabel();
			lblNumIcon.setIcon(pBN.numImg[index]);
			lblNumIcon.setHorizontalTextPosition(JLabel.CENTER);
			lblNumIcon.setBackground(new Color(255, 0, 0, 0));
			pnls[i].add(lblNumIcon);
			pnls[i].setBackground(new Color(255, 0, 0, 0));

			// auto 라벨
			if (elem.isAuto()) {
				JLabel lblAuto = new JLabel();
				lblAuto.setIcon(new ImageIcon(Result.class.getResource("/image/auto수정.png")));
				lblAuto.setHorizontalTextPosition(JLabel.CENTER);
				lblAuto.setBackground(new Color(255, 0, 0, 0));
				pnls[i].add(lblAuto);
			}

			// 2등전용 보너스번호 공 라벨
			if (score.equals("2등") && num == bonusNum) {
				JLabel lblSecond = new JLabel();
				if (num <= 10) {
					lblSecond.setIcon(pBN.circle10);
				} else if (num <= 20) {
					lblSecond.setIcon(pBN.circle20);
				} else if (num <= 30) {
					lblSecond.setIcon(pBN.circle30);
				} else if (num <= 40) {
					lblSecond.setIcon(pBN.circle40);
				} else if (num <= 50) {
					lblSecond.setIcon(pBN.circle50);
				}
				lblSecond.setHorizontalTextPosition(JLabel.CENTER);
				lblSecond.setBackground(new Color(255, 0, 0, 0));
				pnls[i].add(lblSecond);
			}

			// 당첨 공 라벨
			if (elem.isWin()) {
				JLabel lblCorrect = new JLabel();
				if (num <= 10) {
					lblCorrect.setIcon(pBN.circle10);
				} else if (num <= 20) {
					lblCorrect.setIcon(pBN.circle20);
				} else if (num <= 30) {
					lblCorrect.setIcon(pBN.circle30);
				} else if (num <= 40) {
					lblCorrect.setIcon(pBN.circle40);
				} else if (num <= 50) {
					lblCorrect.setIcon(pBN.circle50);
				}
				lblCorrect.setHorizontalTextPosition(JLabel.CENTER);
				lblCorrect.setBackground(new Color(255, 0, 0, 0));
				pnls[i].add(lblCorrect);
			}

			pnl.add(pnls[i]);
			i++;
		}

		return pnl;
	}

	/**
	 * 당첨번호와 보너스번호 라벨 생성해서 패널에 부착
	 * 
	 * 
	 */
	void printDrawNumber() {
		switch (count) {
		case 1:
			JPanel pnl1 = new JPanel();
			pnl1.setLayout(new OverlayLayout(pnl1)); // 각 숫자 Panel
			addDrawNumber(pnl1, lotteryNums.get(0));
			break;
		case 2:
			JPanel pnl2 = new JPanel();
			pnl2.setLayout(new OverlayLayout(pnl2));
			addDrawNumber(pnl2, lotteryNums.get(1));
			break;
		case 3:
			JPanel pnl3 = new JPanel();
			pnl3.setLayout(new OverlayLayout(pnl3));
			addDrawNumber(pnl3, lotteryNums.get(2));
			break;
		case 4:
			JPanel pnl4 = new JPanel();
			pnl4.setLayout(new OverlayLayout(pnl4));
			addDrawNumber(pnl4, lotteryNums.get(3));
			break;
		case 5:
			JPanel pnl5 = new JPanel();
			pnl5.setLayout(new OverlayLayout(pnl5));
			addDrawNumber(pnl5, lotteryNums.get(4));
			break;
		case 6:
			JPanel pnl6 = new JPanel();
			pnl6.setLayout(new OverlayLayout(pnl6));
			addDrawNumber(pnl6, lotteryNums.get(5));
			break;
		}

		try {
			Thread.sleep(100); // drawPnl.revalidate();를 돕기 위한 딜레이를 줌. 안주면 그림에 잔상이 남아서 이상하게 출력되는 거 처럼 보인다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// revalidate: repaint 작동전에 호출하여 패널을 다시 그리도록 하여 레이아웃을 재구성하도록 돕는 메서드.
		drawPnl.revalidate();
		// repaint: drawPnl을 다시 그리도록 요청하는 메서드
		drawPnl.repaint();
	}

	void addDrawNumber(JPanel addPnl, int index) {
		// 숫자아이콘 라벨
		JLabel lblNum = new JLabel(); // Label에 숫자 아이콘 입력
		int elem = index + 1;
		lblNum.setIcon(pBN.numImg[index]); // 번호당 아이콘 입력, iconArr은 1~45 숫자가 있음
		lblNum.setHorizontalTextPosition(JLabel.CENTER);
		lblNum.setBackground(new Color(255, 0, 0, 0));
		addPnl.setBackground(new Color(255, 0, 0, 0));
		addPnl.add(lblNum);

		// 공 아이콘
		JLabel lblBall = new JLabel(); // Label
		if (elem <= 10) {
			lblBall.setIcon(pBN.circle10);
		} else if (elem <= 20) {
			lblBall.setIcon(pBN.circle20);
		} else if (elem <= 30) {
			lblBall.setIcon(pBN.circle30);
		} else if (elem <= 40) {
			lblBall.setIcon(pBN.circle40);
		} else if (elem <= 50) {
			lblBall.setIcon(pBN.circle50);
		}
		lblBall.setHorizontalTextPosition(JLabel.CENTER);
		lblBall.setBackground(new Color(255, 0, 0, 0));
		addPnl.add(lblBall);

		drawPnl.add(addPnl);
	}

	void drawBounsNumber() {
		JPanel pnlPlusNum = new JPanel(); // 보너스 숫자 Panel
		pnlPlusNum.setLayout(new OverlayLayout(pnlPlusNum));
		pnlPlusNum.setBackground(new Color(255, 0, 0, 0));

		JLabel lblPlus = new JLabel(); // + 아이콘 Label
		lblPlus.setIcon(new ImageIcon(Result.class.getResource("/image/plus.png")));
		lblPlus.setBackground(new Color(255, 0, 0, 0));
		drawPnl.add(lblPlus);

		// bonusNum 숫자아이콘 라벨
		JLabel lblPlusNum = new JLabel();
		lblPlusNum.setIcon(pBN.numImg[bonusNum - 1]); // 번호당 아이콘 입력, iconArr은 1~45 숫자가 있음
		lblPlusNum.setHorizontalTextPosition(JLabel.CENTER);
		lblPlusNum.setBackground(new Color(255, 0, 0, 0));
		pnlPlusNum.add(lblPlusNum);

		// plus 공 아이콘 라벨
		JLabel lblPlusBall = new JLabel();
		int elem = bonusNum;
		if (elem <= 10) {
			lblPlusBall.setIcon(pBN.circle10);
		} else if (elem <= 20) {
			lblPlusBall.setIcon(pBN.circle20);
		} else if (elem <= 30) {
			lblPlusBall.setIcon(pBN.circle30);
		} else if (elem <= 40) {
			lblPlusBall.setIcon(pBN.circle40);
		} else if (elem <= 50) {
			lblPlusBall.setIcon(pBN.circle50);
		}
		lblPlusBall.setHorizontalTextPosition(JLabel.CENTER);
		lblPlusBall.setBackground(new Color(255, 0, 0, 0));
		pnlPlusNum.add(lblPlusBall);
		drawPnl.add(pnlPlusNum);
		
		try {
			Thread.sleep(100); // drawPnl.revalidate();를 돕기 위한 딜레이를 주는 키워드
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		drawPnl.revalidate();
		// repaint 작동전에 호출하여 패널을 다시 그리도록 하여 레이아웃을 재구성하도록 돕는 키워드.
		drawPnl.repaint();
	}

	// ---------------------------------------------------------------------------------

	// 버튼2(종료) 생성
	JButton exitBtn() {
		ImageIcon img2 = new ImageIcon(Result.class.getResource("/image/exit.png"));
		ImageIcon img4 = new ImageIcon(Result.class.getResource("/image/exitClick.png"));
		JButton btn2 = new JButton(img2);
		btn2.setRolloverIcon(img4);
		btn2.setBorderPainted(false);
		btn2.setContentAreaFilled(false);
		btn2.setBounds(320, 670, 150, 70);

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0); // 완전히 종료
			}
		});
		return btn2;
	}

	// 버튼1(다시하기) 생성
	JButton againBtn() {
		ImageIcon img1 = new ImageIcon(Result.class.getResource("/image/again.png"));
		ImageIcon img3 = new ImageIcon(Result.class.getResource("/image/againClick.png"));
		JButton btn1 = new JButton(img1);
		btn1.setRolloverIcon(img3);
		btn1.setBorderPainted(false);
		btn1.setContentAreaFilled(false);
		btn1.setBounds(120, 670, 150, 70);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DataBase dataBase = new DataBase();
				new LottoCMR(dataBase);
				setVisible(false);
			}
		});
		return btn1;
	}

	// ----------------------------------------------------------------------
	// 아래는 번호 판별, 등수, 금액 관련 메소드

	/**
	 * 총 당첨금액 라벨 반환
	 * 
	 * @return JLabel
	 */
	JLabel totalMoneyLabel() {
		String formattedNumber = String.format("%,d", totalMoney);
		JLabel lbl = new JLabel(formattedNumber);
		return lbl;
	}

	/**
	 * 금액 저장
	 * 
	 * @param score 등수
	 */
	void moneyPlus(String score) { // 추가
		int money = whatPrice(score);
		totalMoney += money;
	}

	/**
	 * 당첨번호 6자리, 보너스번호 1자리 생성, 필드에 저장
	 */
	void lotteryNumRan() {
		Random r = new Random();
		HashSet<Integer> genNums = new HashSet<>();
		while (true) {
			if (genNums.size() != 7) {
				genNums.add(r.nextInt(45) + 1);
				continue;
			}
//			int num7 = genNums.stream().findLast().orElse(null);
//			int num7 = genNums.stream().
//			bonusNum = num7;
//			genNums.remove(num7);
			lotteryNums = setToArr(genNums);
			Collections.sort(lotteryNums);
			bonusNum = lotteryNums.get(6);
			lotteryNums.remove(6);
			return;
		}
	}

	/**
	 * HashSet > ArrayList 변환 (Integer)
	 * 
	 * @param set
	 * @return list
	 */
	ArrayList<Integer> setToArr(HashSet<Integer> set) {
		ArrayList<Integer> list = new ArrayList<>();
		for (Integer elem : set) {
			list.add(elem);
		}
		return list;
	}

	/**
	 * 유저가 입력한 번호와 당첨번호 6개와 비교하여 겹치는 숫자가 있는지 확인하는 메소드
	 * 
	 * @param key
	 * @return int 당첨번호와 겹치는 숫자 개수 반환
	 */
	int compareNum(String key, ArrayList<UserSelectNum> arrlist) {
		int count = 0;
		for (UserSelectNum elem : arrlist) {
			if (lotteryNums.contains(elem.getLotteryNum())) {
				elem.setWin(true);
				count++;
			}
		}
		return count;
	}

	/**
	 * 각 복권당 몇등인지 확인하는 메소드
	 * 
	 * @param key
	 * @return String 등수
	 */
	String whatScore(int correctCount, String key, ArrayList<UserSelectNum> arrList) {
		if (correctCount == 6)
			return "1등";
		if (correctCount == 5) {
			if (compareBonus(key, arrList)) {
				return "2등";
			}
			return "3등";
		}
		if (correctCount == 4)
			return "4등";
		if (correctCount == 3)
			return "5등";
		return "낙첨";
	}

	/**
	 * 등수를 알아내 JLabel에 넣고, JLabel을 반환
	 * 
	 * @param key
	 * @return JLabel
	 */
	JLabel printScoreLabel(String score) {
		JLabel lbl = new JLabel(score);
		return lbl;
	}

	/**
	 * (임시)등수를 받아 당첨금액 반환
	 * 
	 * @param score
	 * @return money
	 */
	int whatPrice(String score) {
		if (score.equals("1등"))
			return 128000000;
		if (score.equals("2등"))
			return 50000000;
		if (score.equals("3등"))
			return 1500000;
		if (score.equals("4등"))
			return 50000;
		if (score.equals("5등"))
			return 5000;
		return 0;
	}

	/**
	 * 보너스 번호와 사용자가 선택한 번호 비교
	 * 
	 * @param key
	 * @return boolean 보너스숫자와 선택한 번호와 맞는지 여부
	 */
	boolean compareBonus(String key, ArrayList<UserSelectNum> arrlist) {
		for (UserSelectNum elem : arrlist) {
			if (elem.getLotteryNum() == bonusNum) {
				elem.setWin(true);
				return true;
			}
		}
		return false;
	}

//	public static void main(String[] args) {
//		DataBase data = new DataBase();
//		new Result(data);
//	}

	public int[] randomShake() {
		int[] numbers = new int[45];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		Random random = new Random();
		for (int i = numbers.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
		return numbers;
	}

	private JPanel loadBallImages() {
		int[] randomOrder = randomShake();

		for (int i = 0; i < BALL_COUNT; i++) {
			int ran = randomOrder[i];

			String imagePath = "/image/ball_" + i + ".png";
			BALL_IMAGES[ran] = new ImageIcon(getClass().getResource(imagePath));
			setSize(600, 600);
		}

		Timer timer = new Timer(40, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        repaint();
		    }
		});
		timer.start();

		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				String imagePath = "/image/그림3.png";
				ImageIcon backgroundImage = new ImageIcon(getClass().getResource(imagePath));
				g.drawImage(backgroundImage.getImage(), -38, -55, getWidth(), getHeight(), null);

				for (int i = 0; i < BALL_COUNT; i++) {
					double angle = (2 * Math.PI * i) / BALL_COUNT;
					double offsetX = VIRTUAL_CIRCLE_RADIUS * Math.sin(angle);
					double offsetY = VIRTUAL_CIRCLE_RADIUS * Math.cos(angle);
					double randomAngle = Math.random() * 2 * Math.PI;

					x = (int) (getWidth() / 2
							+ Math.round(offsetX + Math.min(BALL_DISTANCE, 35) * Math.sin(randomAngle)));
					y = (int) (getHeight() / 2
							+ Math.round(offsetY + Math.min(BALL_DISTANCE, 35) * Math.cos(randomAngle)));

					ImageIcon ballImage = BALL_IMAGES[i];

					g.drawImage(ballImage.getImage(), x - R / 2, y - R / 2, R, R, null);
				}
			}
		};

		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(600, 600));

		return panel;
	}
}
//
