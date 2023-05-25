package num_1;
// 추첨 결과 확인 창 GUI

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LotteryConfirmation {
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
}
