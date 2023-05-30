package num_1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TestLottery extends JFrame {
	Result result;

	public String lotteryNum(DataBase dataBase, String key) {
		String lotteryNum = "";

		for (int i = 0; i < dataBase.map.get(key).size(); i++) {
			lotteryNum += dataBase.map.get(key).get(i).getLotteryNum() + " ";
		}

		return lotteryNum;
	}

	public TestLottery(DataBase dataBase) {
		result = new Result(dataBase);

		JPanel pnl = new JPanel();
		getContentPane().add(pnl);
		pnl.setLayout(null);

		JPanel winNum = new JPanel();
		winNum.add(result.lotteryNums());
		winNum.setBounds(34, 32, 318, 30);
		pnl.add(winNum);

		JLabel paperA = new JLabel(lotteryNum(dataBase, "A"));
		paperA.setBounds(34, 71, 318, 30);
		pnl.add(paperA);

		JLabel paperB = new JLabel(lotteryNum(dataBase, "B"));
		paperB.setBounds(34, 117, 318, 30);
		pnl.add(paperB);

		JLabel paperC = new JLabel(lotteryNum(dataBase, "C"));
		paperC.setBounds(34, 161, 318, 30);
		pnl.add(paperC);

		JLabel paperD = new JLabel(lotteryNum(dataBase, "D"));
		paperD.setBounds(34, 211, 318, 30);
		pnl.add(paperD);

		JLabel paperE = new JLabel(lotteryNum(dataBase, "E"));
		paperE.setBounds(34, 258, 318, 30);
		pnl.add(paperE);

		JButton replay = new JButton("다시하기");
		replay.setBounds(56, 340, 97, 23);
		pnl.add(replay);
		replay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DataBase dataBase = new DataBase();
				new LottoCMR(dataBase);
				setVisible(false);
			}
		});

		JButton finish = new JButton("종료");
		finish.setBounds(227, 340, 97, 23);
		pnl.add(finish);
		finish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		setSize(409, 438);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
