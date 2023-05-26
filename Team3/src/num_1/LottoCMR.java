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
		
		JLabel lbl1 = new JLabel("1");
		lbl1.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/01.png")));
		lbl1.setBounds(263, 67, 20, 28);
		panel_3.add(lbl1);
		
		JLabel lblMarking = new JLabel("New label");
		lblMarking.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/marking.png")));
		lblMarking.setBounds(166, 111, 20, 28);
		panel_3.add(lblMarking);
		
		JLabel lbl3 = new JLabel("3");
		lbl3.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/03.png")));
		lbl3.setBounds(307, 67, 20, 28);
		panel_3.add(lbl3);
		
		JLabel lbl2 = new JLabel("2");
		lbl2.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/02.png")));
		lbl2.setBounds(285, 67, 20, 28);
		panel_3.add(lbl2);
		
		JLabel lbl4 = new JLabel("4");
		lbl4.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/04.png")));
		lbl4.setBounds(331, 67, 20, 28);
		panel_3.add(lbl4);
		
		JLabel lbl5 = new JLabel("5");
		lbl5.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/05.png")));
		lbl5.setBounds(355, 67, 20, 28);
		panel_3.add(lbl5);
		
		JLabel lbl6 = new JLabel("6");
		lbl6.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/06.png")));
		lbl6.setBounds(385, 67, 20, 28);
		panel_3.add(lbl6);
		
		JLabel lbl7 = new JLabel("7");
		lbl7.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/07.png")));
		lbl7.setBounds(404, 67, 20, 28);
		panel_3.add(lbl7);
		
		JLabel lbl1_1 = new JLabel("1");
		lbl1_1.setBounds(263, 110, 20, 28);
		panel_3.add(lbl1_1);
		
		JLabel paper = new JLabel("New label");
		paper.setIcon(new ImageIcon(LottoCMR.class.getResource("/image/paper.png")));
		paper.setBounds(0, 0, 1254, 550);
		panel_3.add(paper);
		
		JLabel[] A = new JLabel[]{lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7};
		
		
		
		
		
		
		for (int i = 0; i < A.length; i++) {
			A[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					JLabel lbl = (JLabel) e.getSource();
					System.out.println(lbl.getText());
				}
			});
		}
		
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
