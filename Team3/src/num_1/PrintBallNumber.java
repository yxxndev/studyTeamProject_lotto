package num_1;


// 미완 - 로또번호 ↔ 이미지 매치 클래스

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

<<<<<<< HEAD
class PrintBallNumber extends JFrame {
	ImageIcon[] numImg;
	Image circle10 = new ImageIcon(LotteryConfirmation.class.getResource("/image/ten.png")).getImage();
	Image circle20 = new ImageIcon(LotteryConfirmation.class.getResource("/image/twenty.png")).getImage();
	Image circle30 = new ImageIcon(LotteryConfirmation.class.getResource("/image/thirty.png")).getImage();
	Image circle40 = new ImageIcon(LotteryConfirmation.class.getResource("/image/forty.png")).getImage();
	Image circle50 = new ImageIcon(LotteryConfirmation.class.getResource("/image/fifty.png")).getImage();
	Image auto = new ImageIcon(LotteryConfirmation.class.getResource("/image/auto.png")).getImage();
=======
class PrintBallNumber {
	ImageIcon[] numImg = new ImageIcon[45];
	ImageIcon circle10 = new ImageIcon(PrintBallNumber.class.getResource("/image/ten.png"));
	ImageIcon circle20 = new ImageIcon(PrintBallNumber.class.getResource("/image/twenty.png"));
	ImageIcon circle30 = new ImageIcon(PrintBallNumber.class.getResource("/image/thirty.png"));
	ImageIcon circle40 = new ImageIcon(PrintBallNumber.class.getResource("/image/forty.png"));
	ImageIcon circle50 = new ImageIcon(PrintBallNumber.class.getResource("/image/fifty.png"));
	ImageIcon auto = new ImageIcon(PrintBallNumber.class.getResource("/image/auto.png"));
>>>>>>> branch 'master' of https://github.com/0gon/Lotto3.git

	public PrintBallNumber() {
<<<<<<< HEAD
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
=======
		for (int i = 0; i < numImg.length; i++) {
//			numImg[i] = new ImageIcon(numImg[i+1]+".png");
			String str = String.valueOf((i + 1));
			numImg[i] = new ImageIcon(PrintBallNumber.class.getResource("/image/" + str + ".png"));
>>>>>>> branch 'master' of https://github.com/0gon/Lotto3.git
		}
	}
<<<<<<< HEAD

	add pnl
	setSize(1500, 1500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

	}
=======
>>>>>>> branch 'master' of https://github.com/0gon/Lotto3.git
}
