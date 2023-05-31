package num_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LottoCMR extends JFrame {

	ImageIcon icon = new ImageIcon("paper.png");
	private JPanel contentPane;
	private JLabel lblNewLabel; // 금액 변경을 위해
	private JLabel[] lbls; // 마킹을 위해
	private JPanel panelA;
	private JPanel panelB;
	private JPanel panelC;
	private JPanel panelD;
	private JPanel panelE;
	private JLabel lblNewLabel_1;
	private JPanel panel_3;

	public LottoCMR(DataBase dataBase) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		panel_3.setLayout(null);

		panelA = new JPanel();
		panelA.setBounds(259, 10, 165, 522);
		panel_3.add(panelA);
		panelA.setLayout(null);

		panelB = new JPanel();
		panelB.setBounds(445, 10, 165, 522);
		panel_3.add(panelB);
		panelB.setLayout(null);

		panelC = new JPanel();
		panelC.setBounds(630, 10, 165, 522);
		panel_3.add(panelC);
		panelC.setLayout(null);

		panelD = new JPanel();
		panelD.setBounds(817, 10, 165, 522);
		panel_3.add(panelD);
		panelD.setLayout(null);

		panelE = new JPanel();
		panelE.setBounds(1000, 10, 165, 522);
		panel_3.add(panelE);
		panelE.setLayout(null);

		String keyA = "A";
		String keyB = "B";
		String keyC = "C";
		String keyD = "D";
		String keyE = "E";

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setPreferredSize(new Dimension(100, 50));
		panel_1.setLayout(null);

		addLabel(panelA, keyA, dataBase);
		addLabel(panelB, keyB, dataBase);
		addLabel(panelC, keyC, dataBase);
		addLabel(panelD, keyD, dataBase);
		addLabel(panelE, keyE, dataBase);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paperA.png")));
		lblNewLabel_1.setBounds(0, 0, 165, 522);
		panelA.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paperB.png")));
		lblNewLabel_2.setBounds(0, 0, 165, 522);
		panelB.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paperC.png")));
		lblNewLabel_3.setBounds(0, 0, 165, 522);
		panelC.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paperD.png")));
		lblNewLabel_4.setBounds(0, 0, 165, 522);
		panelD.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paperE.png")));
		lblNewLabel_5.setBounds(0, 0, 165, 522);
		panelE.add(lblNewLabel_5);

		JLabel paper = new JLabel("New label");
		paper.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paper.png")));
		paper.setBounds(0, 0, 1254, 550);
		panel_3.add(paper);

		lblNewLabel = new JLabel(" 총 구매금액 0원");
		lblNewLabel.setBounds(517, 10, 182, 30);
		panel_1.add(lblNewLabel);

		JButton btnNewButton = new JButton("구매");
		btnNewButton.setBounds(890, 10, 97, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (purchaseRules(dataBase)) {
					new Result(dataBase);
					setVisible(false);
				}
			}
		});

		setVisible(true);
	}

	public void addLabel(JPanel panel, String key, DataBase dataBase) {
		createLabels(panel, key, dataBase);
	}

	private void createLabels(JPanel panel, String key, DataBase dataBase) { // panel, key
		int x = 4;
		int y = 55;
		lbls = new JLabel[45];

		for (int i = 0; i < 45; i++) {
			JLabel numberlbl = new JLabel("");
			numberlbl.setBounds(x, y, 20, 28);
			panel.add(numberlbl);
			lbls[i] = numberlbl;

			if ((i + 1) % 7 == 0 && i != 0) {
				y += 43;
				x = 4;
			} else
				x += 23;
			if ((i + 1) % 7 == 4)
				x += 1;
		}

		// --------------------------------------------------------
		JButton autoBtn = new JButton("");
		autoBtn.setBounds(140, 442, 20, 28);
		panel.add(autoBtn);
		// --------------------------------------------------------

		JButton cancelButton = new JButton("");
		cancelButton.setBounds(140, 485, 20, 28);
		panel.add(cancelButton);

		autoBtn.setBorderPainted(false);
		autoBtn.setContentAreaFilled(false);

		cancelButton.setBorderPainted(false);
		cancelButton.setContentAreaFilled(false);

		// ----------------------------------------------------------------
		addMouseListener(lbls, key, dataBase, autoBtn);
		cancleMarking(key, lbls, cancelButton, dataBase, autoBtn);
		autoMarking(lbls, dataBase, key, autoBtn);
		// ----------------------------------------------------------------

	}

	private void addMouseListener(JLabel[] lbls, String key, DataBase dataBase, JButton btn) {
		for (int i = 0; i < lbls.length; i++) {
			int index = i;
			lbls[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					markingLabelClieked(lbls, index, key, dataBase, btn);
					
					// 마킹을 누를 때마다 따짐
					// 해당 리스트의 숫자가 6이 아니면 체크 해제
					if (dataBase.map.get(key).size() < 6) {
						btn.setIcon(null);
					}
				}
			});
		}
	}

	public void markingLabelClieked(JLabel[] lbls, int index, String key, DataBase dataBase, JButton btn) {
		int indexNum = index + 1;
		if (dataBase.map.get(key).contains(new UserSelectNum(indexNum, false))) { // 같은게 있다면
			int arrayListIndex = dataBase.map.get(key).indexOf(new UserSelectNum(indexNum, false)); // index
																									// 번호 호출
			dataBase.map.get(key).remove(arrayListIndex); // 제거
			lbls[index].setIcon(null); // 마킹 제거

		} else { // 같은게 없을때
			if (dataBase.map.get(key).size() < 6) { // 크기가 6이하면
				dataBase.map.get(key).add(new UserSelectNum(indexNum, false)); // 추가
				lbls[index].setIcon(new ImageIcon(LottoCMR.class.getResource("/image/marking.png"))); // 마킹
			}
		}
		lblNewLabel.setText(" 총 구매금액 " + getPrice(dataBase) + "원");

		if (!autoChecking(dataBase, key)) {
			btn.setIcon(null);
		}
	}

	public void cancleMarking(String key, JLabel[] lbls, JButton cancelBtn, DataBase dataBase, JButton autoBtn) {
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataBase.map.get(key).clear(); // key값 받아서 전체 삭제

				for (JLabel lbl : lbls) {
					lbl.setIcon(null); // 아이콘 제거
				}

				lblNewLabel.setText(" 총 구매금액 " + getPrice(dataBase) + "원"); // 금액 변경
				if (!autoChecking(dataBase, key)) {
					autoBtn.setIcon(null);
				}
			}
		});
	}

	public int getPrice(DataBase dataBase) { // 총 구매 금액 출력
		int price = 0;
		Set<String> keys = dataBase.map.keySet();

		for (String key : keys) {
			if (dataBase.map.get(key).size() == 6) { // key값 전체 돌려서
				price += 1000;
			}
		}
		return price;
	}

	public void autoMarking(JLabel[] lbls, DataBase dataBase, String key, JButton btn) {
		Random random = new Random(); // 랜덤생성
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				while (true) { // 자동 번호 배열
					if (dataBase.map.get(key).size() == 6) { // 크기가 6이면 종료
						break;
					}
					int ran = random.nextInt(45) + 1; // 1~45 번호 생성
					if (!dataBase.map.get(key).contains(new UserSelectNum(ran, true))) { // 숫자가 같지 않으면 true
						dataBase.map.get(key).add(new UserSelectNum(ran, true)); // 숫자저장
						lbls[ran - 1].setIcon(new ImageIcon(LottoCMR.class.getResource("/image/marking.png"))); // 마킹
					}
				}
				lblNewLabel.setText(" 총 구매금액 " + getPrice(dataBase) + "원"); // 금액 변경
				btn.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/marking.png")));
			}
		});
	}

	public boolean autoChecking(DataBase dataBase, String key) {
		for (int i = 0; i < dataBase.map.get(key).size(); i++) {
			if (dataBase.map.get(key).get(i).isAuto()) {
				return true;
			}
		}
		return false;
	}

	// 구매 규칙(안내메시지)
	// 6개가 SELECTED된 게 하나도 없을 때 "최소 1개 이상의 게임이 선택되어야 합니다."
	// SELECTED가 완료된 복권이 있고, 1 ~ 5 SELECTED 된 복권이 있을 때 "[B] 복권의 번호 입력이 3개 부족합니다."
	// 테스트를 위해 배열 하나 더 생성 필요
	public boolean purchaseRules(DataBase dataBase) {
		int fullNum = 6;
		int finishMarking = 0;
		String[] key = new String[] { "A", "B", "C", "D", "E" };
		String message = "";

		for (String keys : key) {
			int markedNum = dataBase.map.get(keys).size();

			if (markedNum == 6) {
				finishMarking += 1;
			}

			if (markedNum > 0 && markedNum < 6) { // 조건 마다 메시지 한 줄 씩 추가
				if (message.equals("")) {
					message += "[" + keys + "] 복권의 번호 입력이 " + (fullNum - markedNum) + "개 부족합니다.";
				} else {
					message += "\n[" + keys + "] 복권의 번호 입력이 " + (fullNum - markedNum) + "개 부족합니다.";
				}
			}

		}
		if (finishMarking == 0) {
			if (message.equals("")) {
				message += "최소 한 개 이상의 게임이 선택되어야 합니다.";
			} else {
				message += "\n최소 한 개 이상의 게임이 선택되어야 합니다.";
			}
		}

		if (!message.equals("")) { // 메시지가 있으면 출력
			JOptionPane.showMessageDialog(null, message, "테스트용 경고 창", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
}