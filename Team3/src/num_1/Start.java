package num_1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Start extends JFrame {

	private JPanel contentPane;
	DataBase dataBase;

	public Start(DataBase dataBase) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 700);
		setLocationRelativeTo(null); // 중앙 위치
		setResizable(false);  // 크기 변경 불가능하게
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1274, 671);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnStart = new JButton();
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LottoCMR(dataBase);
				setVisible(false);
			}
		});
		btnStart.setIcon(new ImageIcon(Start.class.getResource("/image/start.png")));
		btnStart.setRolloverIcon(new ImageIcon(Start.class.getResource("/image/startClick.png")));
		btnStart.setBorderPainted(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setFocusPainted(false);
		
		btnStart.setBounds(387, 339, 190, 69);
		panel.add(btnStart);
		
		JButton btnExit = new JButton();
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
<<<<<<< HEAD
		btnExit.setIcon(new ImageIcon(Start.class.getResource("/image/exit.png")));
		btnExit.setRolloverIcon(new ImageIcon(Start.class.getResource("/image/exitClick.png")));
=======
		btnExit.setIcon(new ImageIcon(Start.class.getResource("/image/cancleBtn2.png")));
		btnExit.setRolloverIcon(new ImageIcon(LottoCMR.class.getResource("/image/cancleBtn2Click.png")));
>>>>>>> branch 'master' of https://github.com/0gon/Lotto3.git
		btnExit.setBorderPainted(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBounds(702, 339, 190, 69);
		panel.add(btnExit);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Start.class.getResource("/image/bgStart.png")));
		background.setBounds(0, 0, 1280, 671);
		panel.add(background);
		
		ImageIcon img2 = new ImageIcon(Start.class.getResource("/image/exit.png"));
		ImageIcon img4 = new ImageIcon(Start.class.getResource("/image/exitClick.png"));
		
		setVisible(true);
	}
}
