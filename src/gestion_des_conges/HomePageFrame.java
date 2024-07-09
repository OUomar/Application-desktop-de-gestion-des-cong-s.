package gestion_des_conges;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class HomePageFrame extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel accuielPanel;
	private JPanel personnelsPanel;
	private JPanel gcfPanel;
	private JPanel confsPanel;
	private JPanel aboutUsPanel;
	private JPanel statisticsPanel;
	/**
	 * Launch the application.
	 */

	public HomePageFrame() {
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1200, 800);
		setResizable(false);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBounds(0,0, 1200, 800);
		contentPane.setToolTipText("");
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 268, 800);
		menuPanel.setBackground(new Color(0, 64, 128));
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Gestion Des Congés");
		titleLabel.setLabelFor(titleLabel);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 24));
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setBounds(0, 0, 268, 49);
		menuPanel.add(titleLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 50, 268, 5);
		menuPanel.add(separator);
		separator.setForeground(new Color(255, 127, 80));
		separator.setBackground(new Color(255, 127, 80));
		
		JLabel usericonLabel = new JLabel("");
		usericonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usericonLabel.setIcon(new ImageIcon(HomePageFrame.class.getResource("/res/outline_account_circle_white_48dp.png")));
		usericonLabel.setBounds(0, 65, 268, 91);
		menuPanel.add(usericonLabel);
		
		JLabel bonjourLabel = new JLabel("Bonjour User");
		bonjourLabel.setForeground(new Color(255, 255, 255));
		bonjourLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		bonjourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bonjourLabel.setBounds(0, 149, 268, 36);
		menuPanel.add(bonjourLabel);
		
		JButton accueilBtn = new JButton("Accueil");
		accueilBtn.setForeground(new Color(255, 255, 255));
		accueilBtn.setBackground(new Color(128, 128, 255));
		accueilBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		accueilBtn.setBounds(10, 220, 248, 36);
		accueilBtn.setBorderPainted( false );
		accueilBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changerPanels(accuielPanel);
				
			}
			
		});
		menuPanel.add(accueilBtn);
		
		JButton personnelsBtn = new JButton("Gestion des personnels");
		personnelsBtn.setForeground(Color.WHITE);
		personnelsBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		personnelsBtn.setBorderPainted(false);
		personnelsBtn.setBackground(new Color(128, 128, 255));
		personnelsBtn.setBounds(10, 277, 248, 36);
		personnelsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changerPanels(personnelsPanel);
				
			}
			
		});
		menuPanel.add(personnelsBtn);
		
		JButton congesBtn = new JButton("Gestion des congés");
		congesBtn.setForeground(Color.WHITE);
		congesBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		congesBtn.setBorderPainted(false);
		congesBtn.setBackground(new Color(128, 128, 255));
		congesBtn.setBounds(10, 334, 248, 36);
		congesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changerPanels(gcfPanel);
			}
			
		});
		menuPanel.add(congesBtn);
		
		JButton confsBtn = new JButton("Configurations");
		confsBtn.setForeground(Color.WHITE);
		confsBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		confsBtn.setBorderPainted(false);
		confsBtn.setBackground(new Color(128, 128, 255));
		confsBtn.setBounds(10, 449, 248, 36);
		confsBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changerPanels(confsPanel);
				
			}
			
		});
		menuPanel.add(confsBtn);
		
		JButton aboutUsBtn = new JButton("A propos");
		aboutUsBtn.setForeground(Color.WHITE);
		aboutUsBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		aboutUsBtn.setBorderPainted(false);
		aboutUsBtn.setBackground(new Color(128, 128, 255));
		aboutUsBtn.setBounds(10, 506, 248, 36);
		aboutUsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changerPanels(aboutUsPanel);
			}
			
		});
		menuPanel.add(aboutUsBtn);
		
		JButton logOutBtn = new JButton("Deconnexion");
		logOutBtn.setForeground(Color.WHITE);
		logOutBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		logOutBtn.setBorderPainted(false);
		logOutBtn.setBackground(new Color(128, 128, 255));
		logOutBtn.setBounds(10, 713, 248, 36);
		menuPanel.add(logOutBtn);
		
		JButton btnStatistiques = new JButton("Statistiques");
		btnStatistiques.setForeground(Color.WHITE);
		btnStatistiques.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		btnStatistiques.setBorderPainted(false);
		btnStatistiques.setBackground(new Color(128, 128, 255));
		btnStatistiques.setBounds(10, 391, 248, 36);
		btnStatistiques.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changerPanels(statisticsPanel);
			}
			
		});
		menuPanel.add(btnStatistiques);
		
		
		JPanel topBarPanel = new JPanel();
		topBarPanel.setBounds(268, 0, 918, 52);
		topBarPanel.setBackground(new Color(0, 64, 128));
		contentPane.add(topBarPanel);
		topBarPanel.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(278, 62, 898, 691);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		homeFrame hf = new homeFrame();
		accuielPanel = hf.hommePanel();
		layeredPane.add(accuielPanel, "name_2938422876814200");
		
		PersonnelsManagementFrame pmf = new PersonnelsManagementFrame();
		personnelsPanel = pmf.pmfPanel();
		layeredPane.add(personnelsPanel, "name_2938433490724500");
		
		gestionCongesFrame gcf = new gestionCongesFrame();
		gcfPanel = gcf.gcfPanel();
		layeredPane.add(gcfPanel, "name_2938436097331600");
		
		ConfigurationsFrame cf = new ConfigurationsFrame();
		confsPanel = cf.configurationsPanel();
		layeredPane.add(confsPanel, "name_2938438592272900");
		
		AboutUsFrame auf = new AboutUsFrame();
	    aboutUsPanel = auf.aboutUsPanel();
		layeredPane.add(aboutUsPanel, "name_2938440651973400");
		
		StatisticsFrame sf = new StatisticsFrame();
		statisticsPanel = sf.statisticsPanel();
		layeredPane.add(statisticsPanel, "name_3027211024554000");
		
		
	}
	public void changerPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
