package num_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

// 당첨결과 관련 로직 
// 여기 로직이 잘 이동되어 작동되는지 테스트하기 위해 여기서 패널 붙이는 문구를 주석처리함.

class Result extends JFrame {
	ArrayList<Integer> lotteryNums = new ArrayList<Integer>();
	int bonusNum;
	int totalMoney;
	ArrayList<UserSelectNum> aList;
	ArrayList<UserSelectNum> bList;
	ArrayList<UserSelectNum> cList;
	ArrayList<UserSelectNum> dList;
	ArrayList<UserSelectNum> eList;
	JPanel pnl1;

	// ------------------------------------------------------

	public Result(DataBase data) {
		aList = data.map.get("A");
		bList = data.map.get("B");
		cList = data.map.get("C");
		dList = data.map.get("D");
		eList = data.map.get("E");

		// ---------------------------------------------------

		// 당첨번호 숫자조정용
		lotteryNumRan();
//		lotteryNums.add(1);
//		lotteryNums.add(2);
//		lotteryNums.add(3);
//		lotteryNums.add(4);
//		lotteryNums.add(5);
//		lotteryNums.add(7);
//		bonusNum = 6;

//		JPanel pnl = new JPanel();
//
		// 당첨번호 패널
		pnl1 = lotteryNums();
		add(pnl1);

		JButton btnExit = exitBtn();
		add(btnExit);
		
		JButton btnAgain = againBtn();
		add(btnAgain);
		
		// A 항목 정보
		if (aList.size() == 6) {
			int correctCount = compareNum("A", aList);
			JPanel pnl2 = printUserNumResult("A", aList);
			String score = whatScore(correctCount, "A", aList);
			JLabel lbl3 = printScoreLabel(score);
			moneyPlus(score);

			pnl1.setBackground(Color.WHITE);
			pnl1.setBounds(20, 120, 550, 100);

			pnl2.setBackground(new Color(255, 0, 0, 0));
			pnl2.setBounds(50, 320, 600, 110);
			add(pnl2);
			lbl3.setBounds(400, 500, 100, 50);
			add(lbl3);
		}

		// B 항목 정보
		if (bList.size() == 6) {

		}

		if (cList.size() == 6) {

		}

		if (dList.size() == 6) {

		}

		if (eList.size() == 6) {

		}

		// 총 당첨금액 라벨
		JLabel lblMoney = totalMoneyLabel();
		add(lblMoney);

		// 등수 안내 라벨
		JLabel lblInfo = new JLabel("?");
		lblInfo.setToolTipText("1등: 128,000,000원 \n 2등: 50,000,000원 \n 3등: 1,500,000원 \n 4등: 50,000원 \n 5등: 5,000원");
		add(lblInfo);

		// 다시하기 버튼

//		JPanel pnl = new JPanel();
//		pnl.setBounds(0, 0, 600, 800);
//		setBackground(Color.WHITE);

		// 섹션1 생성 : "추첨 결과" 텍스트
		JLabel section1 = new JLabel(new ImageIcon(Result.class.getResource("/image/headerTest.png")));
		section1.setBounds(0, 0, 600, 110);
		add(section1);

//		// 섹션2 생성: 당첨번호 출력
//		JLabel section2 = new JLabel(new ImageIcon(Result.class.getResource("/image/testSection2.png")));
//		section2.setBounds(0, 150, 600, 100);
//		add(section2);

		// 섹션3 생성: 당첨 최고 등수 + 당첨 총 금액 출력
		JLabel section3 = new JLabel(new ImageIcon(Result.class.getResource("/image/reword.png")));
		section3.setBounds(0, 235, 600, 70);
		add(section3);

		// 섹션4 생성: 유저 번호 출력 (A~E)
		JLabel section4 = new JLabel(new ImageIcon(Result.class.getResource("/image/result.png")));
		section4.setBounds(0, 320, 600, 350);
		add(section4);

		// 배경깔기
		JPanel bgPnl = new JPanel();
		JLabel bgLbl = new JLabel((new ImageIcon(Result.class.getResource("/image/background.png"))));
		bgPnl.add(bgLbl);
		bgPnl.setBounds(0, 0, 600, 800);
		add(bgPnl);

		setBackground(Color.WHITE);
		setTitle("추첨 결과");
		setSize(600, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/**
	 * (임시) 복권당 사용자가 선택한 번호 패널에 부착
	 * 
	 * @param key
	 * @return JPanel
	 */
	JPanel printUserNumResult(String key, ArrayList<UserSelectNum> arrList) {
		JPanel pnl = new JPanel();
		JLabel lblUserNum1 = new JLabel("");
		JLabel lblUserNum2 = new JLabel("");
		JLabel lblUserNum3 = new JLabel("");
		JLabel lblUserNum4 = new JLabel("");
		JLabel lblUserNum5 = new JLabel("");
		JLabel lblUserNum6 = new JLabel("");
		JLabel[] lbls = { lblUserNum1, lblUserNum2, lblUserNum3, lblUserNum4, lblUserNum5, lblUserNum6 };

		int i = 0;
		for (UserSelectNum elem : arrList) {
			int num = elem.getLotteryNum();

			// 이미지 1 ~ 45
			// 1.png
			// num = index+1

			String str = String.valueOf(num);
			lbls[i] = new JLabel(str + " ");
			lbls[i].setFont(new Font("Impact", Font.PLAIN, 40)); // 추가

//			int index = num - 1;
//			lbls[i].setIcon(a.iconArr.get(index)); // 번호당 아이콘 입력, iconArr은 1~45 숫자가 있음
//			lbls[i].setHorizontalTextPosition(JLabel.CENTER);

//			ImageIcon icon1 = new ImageIcon("testCircle.png");

			// 당첨 번호인가? (임시)
			if (elem.isWin()) {
				lbls[i].setForeground(Color.GREEN);
//				lbls[i].setIcon(icon1); 

			} else {
				if (elem.isAuto()) {
					lbls[i].setForeground(Color.RED);
//					lbls[i].setIcon(icon1);
//					lbls[i].setHorizontalTextPosition(JLabel.CENTER);
				} else {
					lbls[i].setForeground(Color.BLUE);
				}

			}
			pnl.add(lbls[i]);
			i++;
		}
		return pnl;
	}

	/**
	 * (임시)당첨번호와 보너스번호 라벨 생성해서 패널에 부착
	 * 
	 * @return JPanel
	 */
	JPanel lotteryNums() {
		JPanel pnl1 = new JPanel();
		JLabel lblLotteryNum1 = new JLabel("");
		JLabel lblLotteryNum2 = new JLabel("");
		JLabel lblLotteryNum3 = new JLabel("");
		JLabel lblLotteryNum4 = new JLabel("");
		JLabel lblLotteryNum5 = new JLabel("");
		JLabel lblLotteryNum6 = new JLabel("");
		JLabel lblPlusSymbol = new JLabel("+  ");
		JLabel lblLotteryNum7 = new JLabel("");
		JLabel[] lbls = { lblLotteryNum1, lblLotteryNum2, lblLotteryNum3, lblLotteryNum4, lblLotteryNum5,
				lblLotteryNum6 };

		int i = 0;
		for (Integer elem : lotteryNums) {
			String strPlus = String.valueOf(elem);
			lbls[i].setText(strPlus + "  ");
			lbls[i].setFont(new Font("Impact", Font.PLAIN, 40)); // 추가
			pnl1.add(lbls[i]);
			i++;
		}
		lblPlusSymbol.setFont(new Font("Impact", Font.PLAIN, 40)); // 추가
		lblLotteryNum7.setText(String.valueOf(bonusNum));
		lblLotteryNum7.setFont(new Font("Impact", Font.PLAIN, 40)); // 추가

		pnl1.add(lblPlusSymbol);
		pnl1.add(lblLotteryNum7);
		pnl1.setBackground(new Color(255, 0, 0, 0));
		pnl1.setBounds(20, 120, 550, 100);
		pnl1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0, 0), 3));
		return pnl1;
	}

	// ---------------------------------------------------------------------------------
	// 이 아래는 GUI 배치 관련이 아니라 굳이 안 건드려도 될 듯 합니다

	// 버튼2(종료) 생성
	JButton exitBtn() {
		ImageIcon img2 = new ImageIcon(Result.class.getResource("/image/exit.png"));
		ImageIcon img4 = new ImageIcon(Result.class.getResource("/image/exitClick.png"));
		JButton btn2 = new JButton(img2);
		btn2.setRolloverIcon(img4);
		btn2.setBorderPainted(false);
		btn2.setContentAreaFilled(false);
		btn2.setBounds(320, 680, 150, 70);

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
		btn1.setBounds(120, 680, 150, 70);

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
			int num7 = genNums.stream().findFirst().orElse(null);
			bonusNum = num7;
			genNums.remove(num7);
			lotteryNums = setToArr(genNums);
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

	public static void main(String[] args) {
		DataBase data = new DataBase();
		new Result(data);
	}
}
