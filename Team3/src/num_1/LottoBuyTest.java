package num_1;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LottoBuyTest extends JFrame {

	public LottoBuyTest() {
		JPanel pnl = new JPanel();

		JCheckBox[] checkBoxes = new JCheckBox[45];
		for (int i = 0; i < checkBoxes.length; i++) {
		    checkBoxes[i] = new JCheckBox(String.valueOf(i + 1));
		    pnl.add(checkBoxes[i]);
		}
		
		add(pnl);

		setSize(500, 530);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LottoBuyTest();
	}
}