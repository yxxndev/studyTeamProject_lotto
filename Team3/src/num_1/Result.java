package num_1;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


// 당첨결과 관련 로직 메소드
class ResultFrame2 extends JFrame {
	DataBase data = new DataBase();
	// 당첨번호 6개, 보너스 번호 1개
	Set<Integer> lotteryNums = new HashSet<Integer>();
	int bonusNum;
	Image[] num ;
	
	
	
	public ResultFrame2(DataBase data) {
		// 테스트용 객체, 메소드 호출 ---------------------------------------------------
		
		// 당첨번호 숫자조정용
		lotteryNumRan();
//		lotteryNums.add(1);
//		lotteryNums.add(2);
//		lotteryNums.add(3);
//		lotteryNums.add(4);
//		lotteryNums.add(5);
//		lotteryNums.add(7);
//		bonusNum = 10;
		
		String score = whatScore("A");
		System.out.println(whatPrice(score));
		printlotteryNums();

		// --------------------------------------------------------------------
	}

	// 임시 컴포넌트 선언, 초기화
//	void temporaryComponent() {
//		JButton restartBtn = new JButton("다시하기");
//		JButton exitBtn = new JButton("종료");
//		JLabel gradeLbl = new JLabel("N등");
//		JLabel moneylbl = new JLabel("당첨 총 금액: N원");
//	}

	/**
	 * 유저가 입력한 번호와 당첨번호 6개와 비교하여 겹치는 숫자가 있는지 확인하는 메소드
	 * 
	 * @param key
	 * @return int 당첨번호와 겹치는 숫자 개수 반환
	 */
	int compareNum(String key) {
		Set<UserSelectNum> listUser = data.map.get(key);
		Set<Integer> userNumOnly = new HashSet<>();
		for (UserSelectNum numOb : listUser) {
			userNumOnly.add(numOb.getLotteryNum());
		}
		Set<Integer> duplicate = new HashSet<>();
		duplicate.addAll(lotteryNums);
		duplicate.retainAll(lotteryNums);

		int count = 0;
		for (UserSelectNum numOb : listUser) {
			for (Integer num : duplicate) {
				if (numOb.getLotteryNum() == num) {
					numOb.setWin(true);
					count++;
				}
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
		if (correctCount <= 2) {
			return "낙첨";
		} else if (correctCount == 3) {
			return "5등";
		} else if (correctCount == 4) {
			return "4등";
		} else if (correctCount == 5) {
			if (compareBonus(key)) {
				return "2등";
			} else {
				return "3등";
			}
		} else {
			return "1등";
		}
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
		if (score.equals("5등")) {
			return "5000원";
		} else if (score.equals("4등")) {
			return "50000원";
		} else if (score.equals("3등")) {
			return "1,500,000원";
		} else if (score.equals("2등")) {
			return "50,000,000원";
		} else if (score.equals("1등")) {
			return "128,000,000원";
		} else {
			return "0원";
		}
	}

	// 당첨금액
	void priceLabel(String score) {

	}

	/**
	 * 보너스 번호와 사용자가 선택한 번호 비교
	 * 
	 * @param key
	 * @return boolean 보너스숫자와 선택한 번호와 맞는지 여부
	 */
	boolean compareBonus(String key) {
		Set<UserSelectNum> listUser = data.map.get(key);

		for (UserSelectNum numOb : listUser) {
			if (numOb.getLotteryNum() == bonusNum) {
				numOb.setWin(true);
				return true;
			}
		}
		return false;
	}

	/**
	 * (임시) 복권당 사용자가 선택한 번호 패널에 부착
	 * 
	 * @param key
	 * @return
	 */
	JPanel printUserNumResult(String key) {
		HashSet<UserSelectNum> list = data.map.get(key);
		JPanel pnl = new JPanel();
		JLabel lblUserNum1 = new JLabel("");
		JLabel lblUserNum2 = new JLabel("");
		JLabel lblUserNum3 = new JLabel("");
		JLabel lblUserNum4 = new JLabel("");
		JLabel lblUserNum5 = new JLabel("");
		JLabel lblUserNum6 = new JLabel("");
		JLabel[] lbls = { lblUserNum1, lblUserNum2, lblUserNum3, lblUserNum4, lblUserNum5, lblUserNum6 };
		int i = 0;
		for (UserSelectNum numOb : list) {
			int num = numOb.getLotteryNum();
			// 이미지 1 ~ 45 
			// 1.png
			// num = index+1 
			
			String str = String.valueOf(num);
			lbls[i] = new JLabel(str);

			// 당첨 번호인가? (임시)
			if (numOb.isWin()) {
				lbls[i].setForeground(Color.GREEN);
			} else {

				if (numOb.isAuto()) {
					lbls[i].setForeground(Color.RED);
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
	 * 당첨번호 6자리, 보너스번호 1자리 생성, 필드에 저장
	 */
	void lotteryNumRan() {
		Random r = new Random();
		while (true) {
			if (lotteryNums.size() == 7) {
				int num7 = lotteryNums.stream().findFirst().orElse(null);
				bonusNum = num7;
				lotteryNums.remove(num7);
				return;
			} else {
				lotteryNums.add(r.nextInt(45) + 1);
			}
		}
	}

	/**
	 * 당첨번호와 보너스번호 라벨 생성해서 패널에 부착
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

	/**
	 * (임시) 화면 표시
	 */
	void printlotteryNums() {
		JPanel pnl = new JPanel(new FlowLayout());

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
}

public class Result {
	public static void main(String[] args) {
		DataBase data = new DataBase();
		ResultFrame2 r = new ResultFrame2(data);
	}
}