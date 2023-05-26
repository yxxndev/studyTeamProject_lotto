package num_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LottoBuyTest extends JFrame {
	DataBase data;
	private JPanel pnl;
	private JLabel lbl;

	public LottoBuyTest() {
		pnl = new JPanel();
		lbl = new JLabel("가격: ");

		pnl.add(lbl);

		addLabelNumber(); // 체크박스 호출

		add(pnl);

		setSize(500, 530);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void testtt() {
		data.map.get("A").add(new UserSelectNum(5, true));
	}
	
//	5     6

	public void addLabelNumber() { // 레이블 추가
		JLabel[] JLabelNumber1 = new JLabel[45]; // 레이블 배열 생성
		JLabel[] JLabelNumber2 = new JLabel[45]; // 레이블 배열 생성
		
		for (int i = 0; i < JLabelNumber1.length; i++) { // 1 ~ 45 까지의 이름을 가진 레이블 생성
			JLabelNumber1[i] = new JLabel(String.valueOf(i + 1));
			pnl.add(JLabelNumber1[i]);
		}
		
		for (int i = 0; i < JLabelNumber2.length; i++) { // 1 ~ 45 까지의 이름을 가진 레이블 생성
			JLabelNumber2[i] = new JLabel(String.valueOf(i + 1));
			pnl.add(JLabelNumber2[i]);
		}
		String key1 = "A"; 
		String key2 = "B"; 
		String key3 = "C"; 
		String key4 = "D"; 
		String key5 = "E"; 

//		labelNumberMouseListener(JLabelNumber1, key1); // 레이블 마우스액션 (체크)
//		labelNumberMouseListener(JLabelNumber2, key2); // 레이블 마우스액션 (체크)
		// getPrice(checkBoxes);
		// addButton(checkBoxes); // 자동/반자동 버튼
	}

	// 수동
	public void labelNumberMouseListener(JLabel[] JLabelNumber, String key, DataBase database) {
		
		
		
		for (JLabel number : JLabelNumber) {
			number.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JLabel lbl = (JLabel) e;
					String labelText = number.getText();
					if (database.getMap().get(key).get) { // 배열에 값이 존재하면
						set.remove(labelText); // 삭제
					} else { // 아니라면
						if (NumberMouseListenerRule(set)) { // 규칙 메서드 true면
							set.add(labelText); // 추가
						}
					}
					for (String test : set) { // 테스트용
						System.out.println(test);
					}
				}
			});
		}
	}

	public boolean NumberMouseListenerRule(Set<String> set) {
		if (set.size() == 6) {
			return false;
		}
		return true;
	}
	

	/*
	 * ItemListener itemListener = new ItemListener() { int count = 0; // select되면
	 * 카운트
	 * 
	 * @Override public void itemStateChanged(ItemEvent e) { if (e.getStateChange()
	 * == ItemEvent.SELECTED) { count++; } else if (e.getStateChange() ==
	 * ItemEvent.DESELECTED) { count--; }
	 * 
	 * if (count > 6) { ((JCheckBox) e.getItem()).setSelected(false); // 선택 상태 변경 취소
	 * } int price = getPrice(checkBoxes); lbl.setText(("가격: " + price)); } };
	 * 
	 * for (JLabel number : JLabelNumber) { number.addItemListener(itemListener); //
	 * 각 체크박스에 ItemListener 설정 }
	 */

	// 버튼 비활성화?
	public void addButton(JCheckBox[] checkBoxes) { // 버튼추가
		JButton btn1 = new JButton("자동반자동테스트");
		pnl.add(btn1);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				autoNumber(checkBoxes);
			}
		});
	}

	public int getPrice(JCheckBox[] checkBoxes) { // 총 구매 금액 출력
		int count = 0;
		int price = 0;

		for (JCheckBox checkBox : checkBoxes) {
			if (checkBox.isSelected()) {
				count++;
			}
		}
		if (count == 6) {
			price += 1000;
		}
		return price;
	}

	public void purchaseRules() {
		// 구매 규칙(안내메시지)
		// 6개가 SELECTED된 게 하나도 없을 때 "최소 1개 이상의 게임이 선택되어야 합니다."
		// SELECTED가 완료된 복권이 있고, 1 ~ 5 SELECTED 된 복권이 있을 때 "[B] 복권의 번호 입력이 3개 부족합니다."
		// 테스트를 위해 배열 하나 더 생성
	}

	public void autoNumber(JCheckBox[] checkBoxes) { // 랜덤 번호 생성, 자동/반자동 설정
		Set<UserSelectNum> testSet = new HashSet<>(); // 임시생성
		Set<Integer> set = new HashSet<>(); // 숫자배열
		Random random = new Random(); // 랜덤생성
		int count = 0;

		for (JCheckBox checkBox : checkBoxes) { // 수동 번호 배열
			if (checkBox.isSelected()) {
				count++;
				int test = Integer.parseInt(checkBox.getText());
				set.add(test);
				testSet.add(new UserSelectNum(test, false));
			}
		}

		while (true) { // 자동 번호 배열
			if (set.size() == 6) {
				break;
			}
			int ran = random.nextInt(45) + 1;
			set.add(ran);
			testSet.add(new UserSelectNum(ran, true));

			for (JCheckBox checkBox : checkBoxes) { // 자동 번호 체크박스 체크
				if (Integer.parseInt(checkBox.getText()) == ran) {
					checkBox.setSelected(true);
				}
			}
		}

		for (UserSelectNum qwe : testSet) { // 테스트용 출력
			System.out.println(qwe.getLotteryNum());
		}
	}

	public void resetMarking() { // 복권 번호 선택 초기화

		// 체크
		// 배열
		// index = select number
		// mouse acction = 배열 생성 , 수동
		// 이미지 add

		// 체크해제
		// 원소 remove
		// 이미지 remove
	}

	public static void main(String[] args) {
		new LottoBuyTest();
	}
}
