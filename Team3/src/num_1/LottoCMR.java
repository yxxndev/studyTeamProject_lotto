package num_1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LottoCMR extends JFrame {

	ImageIcon icon = new ImageIcon("paper.png");
	private JPanel contentPane;
	private JLabel paylbl; // 금액 변경을 위해
//	private JLabel[] lbls; // 마킹을 위해
	private JPanel panelA;
	private JPanel panelB;
	private JPanel panelC;
	private JPanel panelD;
	private JPanel panelE;
	private JLabel lblNewLabel_1;
	private JPanel panel_3;
	private ArrayList<UserSelectNum> copyList = new ArrayList<>();
	private JButton btnAllAuto = new JButton("");
	private JButton btnAllCancle = new JButton("");

	public LottoCMR(DataBase dataBase) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 50, 1290, 735);
		setLocationRelativeTo(null); // 중앙 위치
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		panel_3.setLayout(null);

		btnAllAuto.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/allAuto.png")));
		btnAllAuto.setRolloverIcon(new ImageIcon(LottoCMR.class.getResource("/image/allAutoClick.png")));
		btnAllAuto.setBorderPainted(false);
		btnAllAuto.setContentAreaFilled(false);
		btnAllAuto.setBounds(630, 625, 247, 45);
		panel_3.add(btnAllAuto);

//		전체 자동 작동 메소드 삽입 // 2차추가
		btnAllAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] keys = { "A", "B", "C", "D", "E" };

				for (int i = 0; i < keys.length; i++) {
					allAuto(dataBase.mapLbls.get(keys[i]), dataBase, keys[i]);
				}
				btnAllCancle.setEnabled(true);
			}
		});

		btnAllCancle.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/allCancle.png")));
		btnAllCancle.setRolloverIcon(new ImageIcon(LottoCMR.class.getResource("/image/allCancleClick.png")));
		btnAllCancle.setBorderPainted(false);
		btnAllCancle.setContentAreaFilled(false);
		btnAllCancle.setBounds(888, 625, 138, 45);
		btnAllCancle.setEnabled(false); // 버튼 비활성화 메소드

		panel_3.add(btnAllCancle);
//		전체취소 작동메소드 삽입
		btnAllCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] keys = { "A", "B", "C", "D", "E" };
				for (int i = 0; i < keys.length; i++) {
					allCancel(keys[i], dataBase.mapLbls.get(keys[i]), dataBase);

				}
				btnAllCancle.setEnabled(false);
			}
		});

		paylbl = new JLabel("0");
		paylbl.setBounds(1058, 581, 82, 30);
		paylbl.setFont(new Font("Impact", Font.PLAIN, 18));
		paylbl.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(paylbl);

		panelA = new JPanel();
		panelA.setBounds(259, 10, 167, 519);
		panel_3.add(panelA);
		panelA.setLayout(null);

		panelB = new JPanel();
		panelB.setBounds(445, 10, 167, 519);
		panel_3.add(panelB);
		panelB.setLayout(null);

		panelC = new JPanel();
		panelC.setBounds(630, 10, 167, 519);
		panel_3.add(panelC);
		panelC.setLayout(null);

		panelD = new JPanel();
		panelD.setBounds(817, 10, 167, 519);
		panel_3.add(panelD);
		panelD.setLayout(null);

		panelE = new JPanel();
		panelE.setBounds(1000, 10, 167, 519);
		panel_3.add(panelE);
		panelE.setLayout(null);

		String keyA = "A";
		String keyB = "B";
		String keyC = "C";
		String keyD = "D";
		String keyE = "E";

		addLabel(panelA, keyA, dataBase);
		addLabel(panelB, keyB, dataBase);
		addLabel(panelC, keyC, dataBase);
		addLabel(panelD, keyD, dataBase);
		addLabel(panelE, keyE, dataBase);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paperAfinal.png")));
		lblNewLabel_1.setBounds(0, 0, 167, 519);
		panelA.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paperBfinal.png")));
		lblNewLabel_2.setBounds(0, 0, 167, 519);
		panelB.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paperCfinal.png")));
		lblNewLabel_3.setBounds(0, 0, 167, 519);
		panelC.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paperDfinal.png")));
		lblNewLabel_4.setBounds(0, 0, 167, 519);
		panelD.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paperEfinal.png")));
		lblNewLabel_5.setBounds(0, 0, 167, 519);
		panelE.add(lblNewLabel_5);

		JButton btnBuy = new JButton("");
		btnBuy.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/purchase.png")));
		btnBuy.setRolloverIcon(new ImageIcon(LottoCMR.class.getResource("/image/purchaseClick.png")));
		btnBuy.setBorderPainted(false);
		btnBuy.setContentAreaFilled(false);
		btnBuy.setBounds(1039, 625, 126, 45);
		panel_3.add(btnBuy);
		btnBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (purchaseRules(dataBase)) {
					new Result(dataBase);
					setVisible(false);
				}
			}
		});

		JLabel paper = new JLabel("New label");
		paper.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/bgImg2final.png")));
		paper.setBounds(0, 0, 1280, 700);
		panel_3.add(paper);

		setVisible(true);
	}

	public void addLabel(JPanel panel, String key, DataBase dataBase) {
		createLabels(panel, key, dataBase);
	}

	private void createLabels(JPanel panel, String key, DataBase dataBase) { // panel, key
		int x = 4;
		int y = 55;
		JLabel[] lbls = new JLabel[45];
		dataBase.mapLbls.put(key, lbls); // 추가

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

		JButton copyBtn = new JButton();
		copyBtn.setBounds(140, 356, 20, 28);
		panel.add(copyBtn);

		JButton pasteBtn = new JButton();
		pasteBtn.setBounds(140, 399, 20, 28);
		panel.add(pasteBtn);

		// 게임당 자동 및 반자동 선택 버튼 + 이미지(자동 및 반자동 선택, 취소)------
		JButton autoBtn = new JButton("");
		JLabel autoBtnImg = new JLabel((new ImageIcon(LottoCMR.class.getResource("/image/isAuto.png"))));
		JLabel cancleBtnImg = new JLabel((new ImageIcon(LottoCMR.class.getResource("/image/isCancle.png"))));
		autoBtn.setBounds(140, 442, 20, 28);
		autoBtnImg.setBounds(-42, 444, 250, 26);
		cancleBtnImg.setBounds(8, 487, 250, 26);

		panel.add(autoBtn);
		panel.add(autoBtnImg);
		panel.add(cancleBtnImg);

		// --------------------------------------------------------

		JButton cancelButton = new JButton("");
		cancelButton.setBounds(140, 485, 20, 28);
		panel.add(cancelButton);

		copyBtn.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/empty.png")));
		copyBtn.setBorderPainted(false);
		copyBtn.setContentAreaFilled(false);

		pasteBtn.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/empty.png")));
		pasteBtn.setBorderPainted(false);
		pasteBtn.setContentAreaFilled(false);

		autoBtn.setBorderPainted(false);
		autoBtn.setContentAreaFilled(false);

		cancelButton.setBorderPainted(false);
		cancelButton.setContentAreaFilled(false);

		JLabel copyedlbl = new JLabel();
		copyedlbl.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/copyed.png")));
		copyedlbl.setBounds(107, 352, 32, 37);
		panel.add(copyedlbl);

		JLabel pastedlbl = new JLabel();
		pastedlbl.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/pasted.png")));
		pastedlbl.setBounds(77, 392, 61, 44);
		panel.add(pastedlbl);

		// ----------------------------------------------------------------
		addMouseListener(lbls, key, dataBase, autoBtn);
		cancleMarking(key, lbls, cancelButton, dataBase, autoBtn);
		autoMarking(lbls, dataBase, key, autoBtn);
		copyMarking(lbls, dataBase, key, copyBtn); // 임시추가
		pasteMarking(lbls, dataBase, key, pasteBtn); // 임시추가
		// ----------------------------------------------------------------

	}

	// 복사버튼 액션 추가
	private void copyMarking(JLabel[] lbls, DataBase dataBase, String key, JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				copyList.clear();
				copyList.addAll(dataBase.map.get(key));
				btn.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/marking.png")));

				dataBase.mapCopy.put(key, btn); // 추가

				String[] keys = { "A", "B", "C", "D", "E" };
				ArrayList<String> keysList = new ArrayList<>();
				Collections.addAll(keysList, keys);
				keysList.remove(key);

				for (int i = 0; i < keysList.size(); i++) {
					if (dataBase.mapCopy.get(keysList.get(i)) != null) {
						dataBase.mapCopy.get(keysList.get(i))
								.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/empty.png")));
					}
				}
			}
		});
	}

	// 붙여넣기 버튼 액션 추가
	private void pasteMarking(JLabel[] lbls, DataBase dataBase, String key, JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<UserSelectNum> list = new ArrayList<>();
				for (UserSelectNum elem : copyList) {
					list.add(elem);
				}
				dataBase.map.put(key, list);

				for (int i = 0; i < lbls.length; i++) {
					lbls[i].setIcon(null);
				}

				for (UserSelectNum elem : dataBase.map.get(key)) {
					int num = elem.getLotteryNum();
					int index = num - 1;
					lbls[index].setIcon(new ImageIcon(LottoCMR.class.getResource("/image/marking.png")));
				}

				if (copyList.size() != 0) {
					btnAllCancle.setEnabled(true);
				}

				paylbl.setText(getPrice(dataBase) + ""); // 금액 변경
//				}
			}
		});
	}

	// 복사를 했는데 그 패널의 번호가 변경이 되면
	// 복사버튼이 해제되게
	// 번호 라벨들을 클릭할 때마다 작동
	private void addMouseListener(JLabel[] lbls, String key, DataBase dataBase, JButton btn) {
		for (int i = 0; i < lbls.length; i++) {
			int index = i;
			lbls[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);

					markingLabelClieked(lbls, index, key, dataBase, btn);

					if (dataBase.map.get(key).size() < 6) {
						btn.setIcon(null);
						btnAllCancle.setEnabled(true);
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
			dataBase.mapCopy.get(key).setIcon(new ImageIcon(LottoCMR.class.getResource("/image/empty.png")));
		} else { // 같은게 없을때
			if (dataBase.map.get(key).size() < 6) { // 크기가 6이하면
				dataBase.map.get(key).add(new UserSelectNum(indexNum, false)); // 추가
				lbls[index].setIcon(new ImageIcon(LottoCMR.class.getResource("/image/marking.png"))); // 마킹
				dataBase.mapCopy.get(key).setIcon(new ImageIcon(LottoCMR.class.getResource("/image/empty.png")));
				btnAllCancle.setEnabled(true);
			}
		}
		btnAllAuto.setEnabled(true);
		paylbl.setText(getPrice(dataBase) + "");

		if (!autoChecking(dataBase, key)) {
			btn.setIcon(null);
		}
	}

	public void cancleMarking(String key, JLabel[] lbls, JButton cancelBtn, DataBase dataBase, JButton autoBtn) {
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataBase.map.get(key).clear(); // key값 받아서 전체 삭제
				copyList.clear();

				// 추가
				dataBase.mapCopy.get(key).setIcon(new ImageIcon(LottoCMR.class.getResource("/image/empty.png")));

				for (JLabel lbl : lbls) {
					lbl.setIcon(null); // 아이콘 제거
				}
				
				String[] keys = { "A", "B", "C", "D", "E" };
				ArrayList<String> keysList = new ArrayList<>();
				Collections.addAll(keysList, keys);
				keysList.remove(key);
				int count = 0;
				
				for (int i = 0; i < keysList.size(); i++) {
					if (dataBase.map.get(keysList.get(i)).size() != 0) {
						count++;
					}
				}

				if (count == 0) {
					btnAllCancle.setEnabled(false);
				}

				paylbl.setText(getPrice(dataBase) + ""); // 금액 변경
				if (!autoChecking(dataBase, key)) {
					autoBtn.setIcon(null);
				}

				btnAllAuto.setEnabled(true);
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
					} else {
						int ran = random.nextInt(45) + 1; // 1~45 번호 생성
						if (!dataBase.map.get(key).contains(new UserSelectNum(ran, true))) { // 숫자가 같지 않으면 true
							dataBase.map.get(key).add(new UserSelectNum(ran, true)); // 숫자저장
							lbls[ran - 1].setIcon(new ImageIcon(LottoCMR.class.getResource("/image/marking.png"))); // 마킹
							dataBase.mapCopy.get(key)
									.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/empty.png")));
							btnAllCancle.setEnabled(true);
							btnAllAuto.setEnabled(true);
						}
					}
				}
				paylbl.setText(getPrice(dataBase) + ""); // 금액 변경
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

	private void allAuto(JLabel[] lbls, DataBase dataBase, String key) {
		Random random = new Random(); // 랜덤생성

		while (true) { // 자동 번호 배열
			if (dataBase.map.get(key).size() == 6) { // 크기가 6이면 종료
				break;
			} else {
				int ran = random.nextInt(45) + 1; // 1~45 번호 생성
				if (!dataBase.map.get(key).contains(new UserSelectNum(ran, true))) { // 숫자가 같지 않으면 true
					dataBase.map.get(key).add(new UserSelectNum(ran, true)); // 숫자저장
					lbls[ran - 1].setIcon(new ImageIcon(LottoCMR.class.getResource("/image/marking.png"))); // 마킹
					btnAllCancle.setEnabled(true);
					btnAllAuto.setEnabled(false);
				}
			}
		}
		paylbl.setText(getPrice(dataBase) + ""); // 금액 변경
	}

	private void allCancel(String key, JLabel[] lbls, DataBase dataBase) {
		dataBase.map.get(key).clear(); // key값 받아서 전체 삭제
		copyList.clear();

		// 추가
		dataBase.mapCopy.get(key).setIcon(new ImageIcon(LottoCMR.class.getResource("/image/empty.png")));

		for (JLabel lbl : lbls) {
			lbl.setIcon(null); // 아이콘 제거
		}

		paylbl.setText(getPrice(dataBase) + ""); // 금액 변경
		btnAllAuto.setEnabled(true);
		btnAllCancle.setEnabled(false);
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
		int markedNum;

		for (String keys : key) {
			markedNum = dataBase.map.get(keys).size();

			if (markedNum == 6) {
				finishMarking += 1;
			}

			if (markedNum > 0 && markedNum < 6) { // 조건 마다 메시지 한 줄 씩 추가
				if (message.equals("")) {
					message += "[!] 복권의 번호는 [총 6개]가 되어야 합니다.\n번호가 부족한 게임: " + "[" + keys + "] ";
				} else {
					message += "[" + keys + "] ";
				}
			}
		}

		if (message.equals("") && finishMarking == 0) {
			message += "\n[!] 최소 한 개 이상의 게임이 선택되어야 합니다.";
		}

		if (!message.equals("")) { // 메시지가 있으면 출력
			JOptionPane.showMessageDialog(null, message, "테스트용 경고 창", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
}
