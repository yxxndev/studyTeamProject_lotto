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
		setBounds(100, 100, 950, 700);
		setLocationRelativeTo(null); // 중앙 위치
		setResizable(false);  // 크기 변경 불가능하게
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		JLabel LotPicture = new JLabel(new ImageIcon(Start.class.getResource("/image/임시로또배경.jpg")));
		LotPicture.setBounds(100, 100, 760, 400);
		contentPane.add(LotPicture);
		
		JButton btnNewButton = new JButton("시작");
		btnNewButton.setBounds(250, 550, 150, 50);
		
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LottoCMR(dataBase);
				setVisible(false);
			}
		});
		
		ImageIcon img2 = new ImageIcon(Start.class.getResource("/image/exit.png"));
		ImageIcon img4 = new ImageIcon(Start.class.getResource("/image/exitClick.png"));
		JButton btnNewButton_1 = new JButton(img2);
		btnNewButton_1.setRolloverIcon(img4);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBounds(550, 550, 150, 70);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				System.exit(0);
			}
		});
		
		contentPane.add(btnNewButton_1);
		
//		JLabel lblNewLabel = new JLabel("로또게임");
//		lblNewLabel.setBounds(181, 57, 57, 15);
//		contentPane.add(lblNewLabel);
		setVisible(true);
	}
}
