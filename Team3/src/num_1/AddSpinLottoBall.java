package num_1;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddSpinLottoBall {
	private int x;
	private int y;
	private int R = 30;
	private double alpha = 0;

	private final int SPEED = 1;
	private final int BALL_COUNT = 45; // 공 갯수
	private final int BALL_DISTANCE = 30; // 원과의 거리
	private final int VIRTUAL_CIRCLE_RADIUS = 80; // 가상의 원의 반지름
	private final ImageIcon[] BALL_IMAGES = new ImageIcon[BALL_COUNT];

	public AddSpinLottoBall() {
		loadBallImages();
	}

	public void buildWindow() {
		JFrame frame = new JFrame("Rotation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.add(new DrawPanel());
		while (true) {
			try {
				Thread.sleep(60);
				alpha += SPEED;
				frame.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int[] addRandom() {
		int[] numbers = new int[45];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}

		Random random = new Random();
		for (int i = numbers.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
		return numbers;
	}

	private void loadBallImages() {
	    int[] randomOrder = addRandom();

	    for (int i = 0; i < BALL_COUNT; i++) {
	        int ran = randomOrder[i];
        	
            String imagePath = "/image/ball_" + i + ".png";
            BALL_IMAGES[ran] = new ImageIcon(getClass().getResource(imagePath));
        }
    }

	@SuppressWarnings("serial")
	class DrawPanel extends JPanel {
		 private ImageIcon backgroundImage;

		    public DrawPanel() {
		        String imagePath = "/image/그림3.png";
		        backgroundImage = new ImageIcon(getClass().getResource(imagePath));
		    }
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage.getImage(), -38, -55, getWidth(), getHeight(), null);

			for (int i = 0; i < BALL_COUNT; i++) {
				double angle = (2 * Math.PI * i) / BALL_COUNT;
				double offsetX = VIRTUAL_CIRCLE_RADIUS * Math.sin(angle);
				double offsetY = VIRTUAL_CIRCLE_RADIUS * Math.cos(angle);
				double randomAngle = Math.random() * 2 * Math.PI;

				x = (int) (this.getWidth() / 2
						+ Math.round(offsetX + Math.min(BALL_DISTANCE, 35) * Math.sin(randomAngle)));
				y = (int) (this.getHeight() / 2
						+ Math.round(offsetY + Math.min(BALL_DISTANCE, 35) * Math.cos(randomAngle)));

				ImageIcon ballImage = BALL_IMAGES[i];

				g.drawImage(ballImage.getImage(), x - R / 2, y - R / 2, R, R, null);
			}
		}
	}
}