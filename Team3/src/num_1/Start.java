package num_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Start extends JFrame {

	private JPanel contentPane;
	DataBase dataBase;

	public Start(DataBase dataBase) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("시작");
		btnNewButton.setBounds(83, 193, 97, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LottoCMR(dataBase);
				setVisible(false);
			}
		});
		
		JButton btnNewButton_1 = new JButton("종료");
		btnNewButton_1.setBounds(258, 193, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("로또게임");
		lblNewLabel.setBounds(181, 57, 57, 15);
		contentPane.add(lblNewLabel);
		setVisible(true);
	}
}
