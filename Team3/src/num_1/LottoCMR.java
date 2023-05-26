package num_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class LottoCMR extends JFrame {

	ImageIcon icon = new ImageIcon("paper.png");
	private JPanel contentPane;
	DataBase dataBase;
	
	public LottoCMR(DataBase dataBase) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		panel_3.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(259, 10, 165, 522);
		panel_3.add(panel);
		panel.setLayout(null);
		
		int x = 4;
		int y = 55;
		JLabel[] lbls = new JLabel[45];
		
		for (int i = 0; i < 45; i++) {
			JLabel numberlbl = new JLabel("");
			numberlbl.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/marking.png")));
			numberlbl.setBounds(x, y, 20, 28);
			panel.add(numberlbl);
			lbls[i] = numberlbl;
			if ((i + 1) % 7 == 0 && i != 0) {
				y += 43;
				x = 4;
			}else x += 23;
			if ((i + 1) % 7 == 4)
				x += 1;
		}
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paperA.png")));
		lblNewLabel_1.setBounds(0, 0, 165, 522);
		panel.add(lblNewLabel_1);
		
		JLabel paper = new JLabel("New label");
		paper.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paper.png")));
		paper.setBounds(0, 0, 1254, 550);
		panel_3.add(paper);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setPreferredSize(new Dimension(100, 50));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" 총 구매금액 0원");
		lblNewLabel.setBounds(517, 10, 182, 30);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("구매");
		btnNewButton.setBounds(890, 10, 97, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LotteryConfirmation(dataBase);
				setVisible(false);
			}
		});
		
		setVisible(true);
		
	}
}
