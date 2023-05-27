package num_1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 당첨결과 관련 로직 
class Result extends JFrame {
	DataBase data = new DataBase();
	// 당첨번호 6개, 보너스 번호 1개
	ArrayList<Integer> lotteryNums = new ArrayList<Integer>();
	int bonusNum;
	Image[] num;

	public Result(DataBase data) {

		// 당첨번호 숫자조정용
		lotteryNumRan();
//		lotteryNums.add(1);
//		lotteryNums.add(2);
//		lotteryNums.add(3);
//		lotteryNums.add(4);
//		lotteryNums.add(5);
//		lotteryNums.add(7);
//		bonusNum = 10;

		JPanel pnl = new JPanel(new FlowLayout());

		String score = whatScore("A");
		System.out.println(whatPrice(score));

		JPanel pnl1 = lotteryNums();
		JPanel pnl2 = printUserNumResult("A");
		JLabel lbl3 = printScoreLabel("A");

		pnl.add(pnl1);
		pnl.add(pnl2);
		pnl.add(lbl3);

		add(pnl);

		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * (임시) 복권당 사용자가 선택한 번호 패널에 부착
	 * 
	 * @param key
	 * @return
	 */
	JPanel printUserNumResult(String key) {
		ArrayList<UserSelectNum> list = data.map.get(key);
		JPanel pnl = new JPanel();
		JLabel lblUserNum1 = new JLabel("");
		JLabel lblUserNum2 = new JLabel("");
		JLabel lblUserNum3 = new JLabel("");
		JLabel lblUserNum4 = new JLabel("");
		JLabel lblUserNum5 = new JLabel("");
		JLabel lblUserNum6 = new JLabel("");
		JLabel[] lbls = { lblUserNum1, lblUserNum2, lblUserNum3, lblUserNum4, lblUserNum5, lblUserNum6 };

		int i = 0;
		for (UserSelectNum elem : list) {
			int num = elem.getLotteryNum();

			// 이미지 1 ~ 45
			// 1.png
			// num = index+1

			String str = String.valueOf(num);
			lbls[i] = new JLabel(str);

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
		JLabel lblPlusSymbol = new JLabel("+");
		JLabel lblLotteryNum7 = new JLabel("");
		JLabel[] lbls = { lblLotteryNum1, lblLotteryNum2, lblLotteryNum3, lblLotteryNum4, lblLotteryNum5,
				lblLotteryNum6 };

		int i = 0;
		for (Integer elem : lotteryNums) {
			String strPlus = String.valueOf(elem);
			lbls[i].setText(strPlus);
			pnl1.add(lbls[i]);
			i++;
		}
		lblLotteryNum7.setText(String.valueOf(bonusNum));

		pnl1.add(lblPlusSymbol);
		pnl1.add(lblLotteryNum7);
		return pnl1;
	}

	// ---------------------------------------------------------------------------------
	// 이 아래는 GUI 배치 관련이 아니라 굳이 안 건드려도 될 듯 합니다

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
	int compareNum(String key) {
		int count = 0;
		ArrayList<UserSelectNum> list = data.map.get(key);
		for (UserSelectNum elem : list) {
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
	String whatScore(String key) {
		int correctCount = compareNum(key);
		if (correctCount == 6)
			return "1등";
		if (correctCount == 5) {
			if (compareBonus(key)) {
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
	JLabel printScoreLabel(String key) {
		JLabel lbl = new JLabel(whatScore(key));
		return lbl;
	}

	/**
	 * (임시)등수를 받아 당첨금액 반환
	 * 
	 * @param score
	 */
	String whatPrice(String score) {
		if (score.equals("1등"))
			return "128,000,000원";
		if (score.equals("2등"))
			return "50,000,000원";
		if (score.equals("3등"))
			return "1,500,000원";
		if (score.equals("4등"))
			return "50000원";
		if (score.equals("5등"))
			return "5000원";
		return "0원";
	}

	/**
	 * 보너스 번호와 사용자가 선택한 번호 비교
	 * 
	 * @param key
	 * @return boolean 보너스숫자와 선택한 번호와 맞는지 여부
	 */
	boolean compareBonus(String key) {
		ArrayList<UserSelectNum> list = data.map.get(key);
		for (UserSelectNum elem : list) {
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
