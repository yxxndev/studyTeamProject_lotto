package num_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;

public class LottoCMR extends JFrame {

	ImageIcon icon = new ImageIcon("paper.png");
	private JPanel contentPane;
	private JLabel lblNewLabel; // 금액 변경을 위해
	private JLabel[] lbls; // 마킹을 위해

	public LottoCMR(DataBase dataBase) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		panel_3.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(259, 10, 165, 522);
		panel_3.add(panel);
		panel.setLayout(null);

		int x = 4;
		int y = 55;
		lbls = new JLabel[45];

		/*
		 * 현재 DataBase 클래스에서 테스트를 위해 UserSelectNum에 15를 미리 집어 넣었기 때문에 처음에 아무 숫자를 누르면 15가
		 * 같이 출력되는게 정상이에요.
		 */

		for (int i = 0; i < 45; i++) {
			int index = i;
			JLabel numberlbl = new JLabel("");

			numberlbl.setBounds(x, y, 20, 28);
			panel.add(numberlbl);
			lbls[i] = numberlbl;
			lbls[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					int indexNum = index + 1;
					if (dataBase.map.get("A").contains(new UserSelectNum(indexNum, false))) { // 같은게 있다면
						int arrayListIndex = dataBase.map.get("A").indexOf(new UserSelectNum(indexNum, false)); // index
																												// 번호 호출
						dataBase.map.get("A").remove(arrayListIndex); // 제거
						lbls[index].setIcon(null); // 마킹 제거
						
					} else { // 같은게 없을때
						if (dataBase.map.get("A").size() < 6) { // 크기가 6이하면
							dataBase.map.get("A").add(new UserSelectNum(indexNum, false)); // 추가
							lbls[index].setIcon(new ImageIcon(LottoCMR.class.getResource("/image/marking.png"))); // 마킹
						}
					}
					lblNewLabel.setText(" 총 구매금액 " + getPrice(dataBase) + "원");

					for (int i = 0; i < dataBase.map.get("A").size(); i++) { // 테스트용 UserSelectNum 객체 출력
						System.out.println("UserSelectNum: " + dataBase.map.get("A").get(i).getLotteryNum());
					}
					System.out.println("-------------");
				}
			});

			if ((i + 1) % 7 == 0 && i != 0) {
				y += 43;
				x = 4;
			} else
				x += 23;
			if ((i + 1) % 7 == 4)
				x += 1;
		}

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paperA.png")));
		lblNewLabel_1.setBounds(0, 0, 165, 522);
		panel.add(lblNewLabel_1);

		JLabel paper = new JLabel("New label");
		paper.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paper.png")));
		paper.setBounds(0, 0, 1254, 550);
		panel_3.add(paper);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setPreferredSize(new Dimension(100, 50));
		panel_1.setLayout(null);

		lblNewLabel = new JLabel(" 총 구매금액 0원");
		lblNewLabel.setBounds(517, 10, 182, 30);
		panel_1.add(lblNewLabel);

		JButton btnNewButton = new JButton("구매");
		btnNewButton.setBounds(890, 10, 97, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LotteryConfirmation(dataBase);
				setVisible(false);
			}
		});

		JButton btn1 = new JButton("초기화테스트");
		btn1.setBounds(290, 10, 97, 23);
		panel_1.add(btn1);

		JButton btn2 = new JButton("다음 초기화");
		btn2.setBounds(690, 10, 97, 23);
		panel_1.add(btn2);

		cancleMarking(dataBase, btn1);
		cancleMarking(dataBase, btn2);

		JButton btn3 = new JButton("자동/반자동 테스트");
		btn3.setBounds(390, 10, 97, 23);
		panel_1.add(btn3);

		autoMarking(dataBase, btn3);

		setVisible(true);

	}

	public void cancleMarking(DataBase dataBase, JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataBase.map.get("A").clear(); // key값 받아서 전체 삭제
				
				for (JLabel lbl : lbls) {
	                lbl.setIcon(null); // 아이콘 제거
	            }
				
				lblNewLabel.setText(" 총 구매금액 " + getPrice(dataBase) + "원"); // 금액 변경
			}
		});
	}

	public int getPrice(DataBase dataBase) { // 총 구매 금액 출력
		int price = 0;

		if (dataBase.map.get("A").size() == 6) { // key값 전체 돌려서
			price = 1000;
		} else {
			price = 0;
		}
		return price;
	}

	public void autoMarking(DataBase dataBase, JButton btn) {
		Random random = new Random(); // 랜덤생성
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				while (true) { // 자동 번호 배열
					if (dataBase.map.get("A").size() == 6) { // 크기가 6이면 종료
						break;
					}
					int ran = random.nextInt(45) + 1; // 1~45 번호 생성
					if (!dataBase.map.get("A").contains(new UserSelectNum(ran, true))) { // 숫자가 같지 않으면 true
						dataBase.map.get("A").add(new UserSelectNum(ran, true)); // 숫자저장
						lbls[ran - 1].setIcon(new ImageIcon(LottoCMR.class.getResource("/image/marking.png"))); // 마킹
					}
				}
				lblNewLabel.setText(" 총 구매금액 " + getPrice(dataBase) + "원"); // 금액 변경

				for (int i = 0; i < dataBase.map.get("A").size(); i++) { // 테스트용 UserSelectNum 객체 출력
					System.out.println("UserSelectNum: " + dataBase.map.get("A").get(i).getLotteryNum());
				}
				System.out.println("-------------");
			}
		});
	}

	// 구매 규칙(안내메시지)
	// 6개가 SELECTED된 게 하나도 없을 때 "최소 1개 이상의 게임이 선택되어야 합니다."
	// SELECTED가 완료된 복권이 있고, 1 ~ 5 SELECTED 된 복권이 있을 때 "[B] 복권의 번호 입력이 3개 부족합니다."
	// 테스트를 위해 배열 하나 더 생성 필요
	public void purchaseRules(DataBase dataBase) {
		int fullNum = 6;
		int MarkedNum = dataBase.map.get("A").size();
		int finishMarking = 0;
		if (MarkedNum > 0 && MarkedNum < 6) {
			System.out.println("[A] 복권의 번호 입력이 " + (fullNum - MarkedNum) + "개 부족합니다.");
		}
		
		if (MarkedNum == 6) {
			finishMarking += 1;
		}
		
		if (finishMarking == 0) {
			System.out.println("최소 한 개 이상의 게임이 선택되어야 합니다.");
		}
	}
}