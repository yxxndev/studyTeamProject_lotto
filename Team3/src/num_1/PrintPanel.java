package num_1;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PrintPanel extends JPanel {
	private static final long serialVersionUID = 0;
	JPanel userNumsArea; // 임시로 LotteryComfirmation에서 쓰려고 default로 변경
//	private DataBase data = new DataBase(); // CMR에서 받아오려고 주석처리함
	private List<?> list;
	int x = 50;
	int y = 50;

	// 기본 출력 틀 생성
	public void init(List<Integer> list) {
//		this.setLayout(null);
		this.setSize(370, 100); // 확인하려고 해제
//		this.setLocation(null); // 정중앙 위치에 배치
		userNumsArea = new JPanel();
		userNumsArea.setSize(370, 66);
		userNumsArea.setLayout(new GridLayout(1, 6));
		userNumsArea.setBorder(new EmptyBorder(5, 5, 5, 5));
		userNumsArea.setBackground(new Color(255, 0, 0, 0));
		this.add(userNumsArea);
		this.list = list;
		this.initComp();
		this.setVisible(true); // setVisible을 이곳에서 실행
		
	}

	public PrintPanel(DataBase data) { // CMR에서  data 받아옴
		String key = "A";
		List<UserSelectNum> tempArr = new ArrayList<>(data.map.get(key)); // 입력받은 key값에 대한 value를 새로운 리스트로 저장
		List<Integer> numsList = tempArr.stream().map(UserSelectNum::getLotteryNum).collect(Collectors.toList()); // 새로운
		init(numsList); // 최종적으로 출력할 리스트 전달
//		System.out.println(numsList.toString());
	}

	// 받은 숫자값으로 새 출력
	public void initComp() {
		int num;
		for (int i = 0; i < list.size(); i++) {
			num = (int) list.get(i);
			JLabel lbl = new JLabel("");

			if (num == 0) {
				lbl.setBackground(Color.WHITE);
			} else {
				lbl.setText("" + num + "");
			}
			lbl.setBounds(x, y, 50, 50);;
			lbl.setFont(new Font("Impact", Font.PLAIN, 22));
			lbl.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0, 0), 3));
			userNumsArea.add(lbl);
			x += 55;
		}
	}

	

//	public static void main(String[] args) {
////		new PrintPanel("");
//		new PrintPanel("B");
//	}
}
