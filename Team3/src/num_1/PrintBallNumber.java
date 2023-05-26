package num_1;


// 미완 - 로또번호 ↔ 이미지 매치 클래스

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class PrintBallNumber extends JFrame {
	ImageIcon[] numImg;
	Image circle10 = new ImageIcon(LotteryConfirmation.class.getResource("/image/ten.png")).getImage();
	Image circle20 = new ImageIcon(LotteryConfirmation.class.getResource("/image/twenty.png")).getImage();
	Image circle30 = new ImageIcon(LotteryConfirmation.class.getResource("/image/thirty.png")).getImage();
	Image circle40 = new ImageIcon(LotteryConfirmation.class.getResource("/image/forty.png")).getImage();
	Image circle50 = new ImageIcon(LotteryConfirmation.class.getResource("/image/fifty.png")).getImage();
	Image auto = new ImageIcon(LotteryConfirmation.class.getResource("/image/auto.png")).getImage();

	public PrintBallNumber() {
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		JLabel lbl = new JLabel();
		

		for (int i = 0; i < 45; i++) {
			numImg[i] = new ImageIcon("/image/" + numImg[i + 1] + ".png");
		}
		
		
		static JPanel test = new JPanel() {
			Image img = new ImageIcon(LotteryConfirmation.class.getResource("/image/background.png")).getImage();
			
			public void paint(Graphics g) {
				g.drawImage(background,  0 , 0,  null);
			}
		};
		
		public void paint(Graphics g) {
			for (int i = 0; i < 45; i++) {
				g.drawImage(numImg[i].getImage(), 0, 0, null);
		}
	}

	add pnl
	setSize(1500, 1500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

	}
}
