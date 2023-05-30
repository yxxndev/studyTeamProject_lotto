package num_1;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestLottery extends JFrame{
	Result result;
	
	public TestLottery(DataBase dataBase) {
		result = new Result(dataBase);
		PrintPanel panel = new PrintPanel(dataBase);
		
		JPanel pnl = new JPanel();
		pnl.add(panel.userNumsArea, "North");
		pnl.add(result.lotteryNums(), "South");
		add(pnl);
		
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
