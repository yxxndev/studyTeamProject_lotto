package num_1;

import javax.swing.ImageIcon;

class PrintBallNumber {
	ImageIcon[] numImg = new ImageIcon[45];
	ImageIcon circle10 = new ImageIcon(PrintBallNumber.class.getResource("/image/ten.png"));
	ImageIcon circle20 = new ImageIcon(PrintBallNumber.class.getResource("/image/twenty.png"));
	ImageIcon circle30 = new ImageIcon(PrintBallNumber.class.getResource("/image/thirty.png"));
	ImageIcon circle40 = new ImageIcon(PrintBallNumber.class.getResource("/image/forty.png"));
	ImageIcon circle50 = new ImageIcon(PrintBallNumber.class.getResource("/image/fifty.png"));
	ImageIcon auto = new ImageIcon(PrintBallNumber.class.getResource("/image/auto.png"));

	public PrintBallNumber() {
		for (int i = 0; i < numImg.length; i++) {
//			numImg[i] = new ImageIcon(numImg[i+1]+".png");
			String str = String.valueOf((i + 1));
			numImg[i] = new ImageIcon(PrintBallNumber.class.getResource("/image/" + str + ".png"));
		}
	}
}
