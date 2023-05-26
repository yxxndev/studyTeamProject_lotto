package num_1;
// 추첨 결과 확인 창 GUI

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class LotteryConfirmation extends JFrame {
	// 임시 맵 선언
	Map<String, HashSet<UserSelectNum>> map = new HashMap();
	// 당첨번호 6개, 보너스번호 1개
	Set<Integer> lotteryNums = new HashSet<Integer>();
	int bonusNum;

	public LotteryConfirmation() {
		// 테스트용 객체, 메소드 호출 ---------------------------------------------------
		temporaryMapKey();
		HashSet<UserSelectNum> a = new HashSet<UserSelectNum>();
		lotteryNumRan();

		a.add(new UserSelectNum(1, false));
		a.add(new UserSelectNum(2, false));
		a.add(new UserSelectNum(3, false));
		a.add(new UserSelectNum(4, true));
		a.add(new UserSelectNum(5, true));
		a.add(new UserSelectNum(6, true));
		map.put("A", a);
		compareNum("A");
		printlotteryNums();
		// --------------------------------------------------------------------
	}

	// 임시 키
	void temporaryMapKey() {
		map.put("A", new HashSet<UserSelectNum>());
		map.put("B", new HashSet<UserSelectNum>());
		map.put("C", new HashSet<UserSelectNum>());
		map.put("D", new HashSet<UserSelectNum>());
		map.put("E", new HashSet<UserSelectNum>());
	}

	// 유저가 입력한 번호와 당첨번호 6개와 비교하여 겹치는 숫자가 있는지 확인
	void compareNum(String key) {
		Set<UserSelectNum> listUser = map.get(key);
		Set<Integer> userNumOnly = new HashSet<>();
		for (UserSelectNum numOb : listUser) {
			userNumOnly.add(numOb.getLotteryNum());
		}
		System.out.println(userNumOnly);
		System.out.println(lotteryNums + " + " + bonusNum);
		Set<Integer> duplicate = new HashSet<>();
		duplicate.addAll(lotteryNums);
		duplicate.retainAll(lotteryNums);

//			int count = 0;
		for (UserSelectNum numOb : listUser) {
			for (Integer num : duplicate) {
				if (numOb.getLotteryNum() == num) {
					numOb.setWin(true);
//						count++;
				}
			}
		}
	}

	// 복권당 사용자가 선택한 번호 출력
	JPanel printUserNumResult(String key, JPanel pnl) {
		HashSet<UserSelectNum> list = map.get(key);
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

	// Set으로 7개의 랜덤숫자를 중복없이 생성하고,
	// 보너스 번호를 하나 따로 필드값에 저장하고, Set은 보너스 번호를 삭제하고 6개로 만드는 메소드
	void lotteryNumRan() {
		while (true) {
			if (lotteryNums.size() == 7) {
				int num7 = lotteryNums.stream().findFirst().orElse(null);
				bonusNum = num7;
				lotteryNums.remove(num7);
				return;
			} else {
				lotteryNums.add(generateRanNum());
			}
		}
	}

	// 랜덤 번호 하나 생성 후 리턴
	int generateRanNum() {
		Random r = new Random();
		return r.nextInt(45) + 1;
	}

	// 당첨번호 출력(임시)
	void printlotteryNums() {
		JPanel pnl = new JPanel(new BorderLayout());
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

		JPanel pnl2 = new JPanel();
		pnl2 = printUserNumResult("A", pnl2);

		pnl.add(pnl1, BorderLayout.NORTH);
		pnl.add(pnl2, BorderLayout.CENTER);

		add(pnl);

		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
