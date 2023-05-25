package num_1;
// 추첨 결과 확인 창 GUI

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LotteryConfirmation extends JFrame{
	// 당첨번호 6개, 보너스번호 1개
	Set<Integer> lotteryNums = new HashSet<Integer>();
	int bonusNum;

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
		JPanel pnl = new JPanel();
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
			pnl.add(lbls[i]);
			i++;
		}
		lblLotteryNum7.setText(String.valueOf(bonusNum));
		
		pnl.add(lblPlusSymbol);
		pnl.add(lblLotteryNum7);

		add(pnl);

		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
