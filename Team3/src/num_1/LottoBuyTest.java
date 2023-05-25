package num_1;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LottoBuyTest extends JFrame {
    private JPanel pnl;

    public LottoBuyTest() {
        pnl = new JPanel();

        addCheckBox(); // 체크박스 호출
        add(pnl);

        setSize(500, 530);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addCheckBox() { // 체크박스 추가
        JCheckBox[] checkBoxes = new JCheckBox[45]; // 첫 번째 체크박스 배열 생성
        for (int i = 0; i < checkBoxes.length; i++) { // 1 ~ 45 까지의 이름을 가진 체크박스 생성
            checkBoxes[i] = new JCheckBox(String.valueOf(i + 1));
            pnl.add(checkBoxes[i]);
        }
        checkBoxItemListener(checkBoxes); // 체크박스 규칙 호출 (7개 이상 클릭 x)
    }

    public void checkBoxItemListener(JCheckBox[] checkBoxes) {	// 체크박스 규칙 (7개 이상 클릭 x)
        ItemListener itemListener = new ItemListener() {
            int count = 0;	// select되면 카운트

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	count++;
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                	count--;
                }

                if (count > 6) {
                    ((JCheckBox) e.getItem()).setSelected(false); // 선택 상태 변경 취소
                }
            }
        };

        for (JCheckBox checkBox : checkBoxes) {
            checkBox.addItemListener(itemListener); // 각 체크박스에 ItemListener 설정
        }
    }
    
    public void ButtonAdd() {
    	// 버튼추가
    }
    
    public void getPrice() {
    	// 총 구매 금액 출력
    }
    
    public void purchaseRules() {
    	// 구매 규칙(안내메시지)
    	// 6개가 SELECTED된 게 하나도 없을 때 "최소 1개 이상의 게임이 선택되어야 합니다."
    	// SELECTED가 완료된 복권이 있고, 1 ~ 5 SELECTED 된 복권이 있을 때 "[B] 복권의 번호 입력이 3개 부족합니다."
    	// 테스트를 위해 배열 하나 더 생성
    }
    
    public void autoNumber() {
    	// 랜덤 번호 생성, 자동/반자동 설정
    }

    public static void main(String[] args) {
        new LottoBuyTest();
    }
}
