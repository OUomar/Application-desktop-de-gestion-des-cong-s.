package gestion_des_conges;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class AboutUsFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public AboutUsFrame() {
		aboutUsPanel();
	}
	
	public JPanel aboutUsPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 898, 694);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(255, 128, 64), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 64, 128));
		titlePanel.setBounds(0, 114, 898, 41);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("A propos de nous");
		titleLabel.setBounds(10, 0, 878, 35);
		titlePanel.add(titleLabel);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(255, 128, 64));
		titleLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		
		JLabel fsteLogo = new JLabel("");
		fsteLogo.setHorizontalAlignment(SwingConstants.CENTER);
		fsteLogo.setIcon(new ImageIcon(homeFrame.class.getResource("/res/fstee (1).png")));
		fsteLogo.setBounds(0, 20, 898, 77);
		contentPane.add(fsteLogo);
		
		JPanel containerPanel = new JPanel();
		containerPanel.setBackground(new Color(255, 255, 255));
		containerPanel.setForeground(new Color(255, 128, 64));
		containerPanel.setBounds(10, 165, 878, 519);
		contentPane.add(containerPanel);
		
		
        containerPanel.setLayout(null);
        
        JLabel aboutLabel = new JLabel("");
        aboutLabel.setIcon(new ImageIcon(AboutUsFrame.class.getResource("/res/about.png")));
        aboutLabel.setBounds(182, 0, 500, 487);
        containerPanel.add(aboutLabel);
        return contentPane;
	}

}
