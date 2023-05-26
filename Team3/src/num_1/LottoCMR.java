package num_1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class LottoCMR extends JFrame {

	ImageIcon icon = new ImageIcon("paper.png");
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LottoCMR frame = new LottoCMR();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LottoCMR() {
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
		
		JLabel lbl1 = new JLabel("New label");
		lbl1.setIcon(new ImageIcon("C:\\Users\\GGG\\git\\Lotto3\\Team3\\01.png"));
		lbl1.setBounds(263, 67, 20, 28);
		panel_3.add(lbl1);
		
		JLabel lblMarking = new JLabel("New label");
		lblMarking.setIcon(new ImageIcon("C:\\Users\\GGG\\git\\Lotto3\\Team3\\marking.png"));
		lblMarking.setBounds(263, 110, 20, 28);
		panel_3.add(lblMarking);
		
		JLabel lbl2 = new JLabel("New label");
		lbl2.setIcon(new ImageIcon("C:\\Users\\GGG\\git\\Lotto3\\Team3\\01.png"));
		lbl2.setBounds(263, 148, 20, 28);
		panel_3.add(lbl2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(326, 70, 20, 23);
		panel_3.add(chckbxNewCheckBox);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\GGG\\git\\Lotto3\\Team3\\paper.png"));
		label.setBounds(0, 0, 1254, 550);
		panel_3.add(label);
		
		JCheckBox checkBox = new JCheckBox("New check box");
		checkBox.setBounds(656, 70, 115, 23);
		panel_3.add(checkBox);
		
		
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setPreferredSize(new Dimension(100, 50));
		
		
		
	}
}
