package num_1;

import java.awt.Image;

import javax.swing.ImageIcon;

class PrintBallNumber {
	ImageIcon[] numImg = new ImageIcon[45];
//	Image circle10 = new ImageIcon(LotteryConfirmation.class.getResource("/image/ten.png")).getImage();
//	Image circle20 = new ImageIcon(LotteryConfirmation.class.getResource("/image/twenty.png")).getImage();
//	Image circle30 = new ImageIcon(LotteryConfirmation.class.getResource("/image/thirty.png")).getImage();
//	Image circle40 = new ImageIcon(LotteryConfirmation.class.getResource("/image/forty.png")).getImage();
//	Image circle50 = new ImageIcon(LotteryConfirmation.class.getResource("/image/fifty.png")).getImage();
//	Image auto = new ImageIcon(LotteryConfirmation.class.getResource("/image/auto.png")).getImage();
	
	
	public PrintBallNumber() {
		for (int i = 0; i < numImg.length; i++) {
			numImg[i] = new ImageIcon(numImg[i+1]+".png");
		}
	}
	
	
	

}
