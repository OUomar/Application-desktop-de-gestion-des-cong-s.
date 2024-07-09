package gestion_des_conges;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class modifierPersonnelFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifierPersonnelFrame frame = new modifierPersonnelFrame();
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
	public modifierPersonnelFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 898, 694);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(255, 128, 64), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 64, 128));
		panel_1_1.setBounds(0, 114, 898, 41);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel modifierLabel = new JLabel("Modifier Personnel");
		modifierLabel.setBounds(10, 0, 878, 35);
		panel_1_1.add(modifierLabel);
		modifierLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modifierLabel.setForeground(new Color(255, 128, 64));
		modifierLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(homeFrame.class.getResource("/res/fstee (1).png")));
		lblNewLabel.setBounds(0, 20, 853, 77);
		contentPane.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 128, 64));
		panel_3.setForeground(new Color(255, 128, 64));
		panel_3.setBounds(10, 165, 878, 519);
		contentPane.add(panel_3);
		
		
	

        JButton refresh= new JButton("Actualiser");
        refresh.setBounds(465,100, 115, 40);
        refresh.setForeground( Color.white);
        refresh.setBackground(new Color(53, 128, 48));
        refresh.setHorizontalAlignment(JButton.CENTER);
        panel_3.setLayout(null);
        ButtonGroup groupeTriage = new ButtonGroup();
        
        JButton addButton = new JButton("Modifier");
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        addButton.setBackground(new Color(0, 128, 255));
        addButton.setBounds(221, 454, 112, 37);
        panel_3.add(addButton);
        
        JButton btnVider = new JButton("Vider");
        btnVider.setForeground(Color.WHITE);
        btnVider.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        btnVider.setBackground(new Color(128, 128, 0));
        btnVider.setBounds(372, 454, 112, 37);
        panel_3.add(btnVider);
        
        JButton btnAnnuler = new JButton("Fermer");
        btnAnnuler.setForeground(Color.WHITE);
        btnAnnuler.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        btnAnnuler.setBackground(new Color(255, 0, 0));
        btnAnnuler.setBounds(529, 454, 112, 37);
        panel_3.add(btnAnnuler);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 64, 128));
        panel.setBounds(56, 34, 529, 40);
        panel_3.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Numero ° :");
        lblNewLabel_1.setBackground(new Color(0, 64, 128));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 0, 137, 39);
        panel.add(lblNewLabel_1);
        
        JTextField textField = new JTextField();
        textField.setBounds(138, 0, 391, 39);
        panel.add(textField);
        textField.setColumns(10);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBounds(604, 34, 208, 221);
        panel_3.add(panel_7);
        
        JButton importButton = new JButton("importer une image");
        importButton.setForeground(Color.WHITE);
        importButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        importButton.setBackground(new Color(64, 128, 128));
        importButton.setBounds(604, 274, 208, 40);
        panel_3.add(importButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(0, 64, 128));
        panel_1.setBounds(56, 94, 529, 40);
        panel_3.add(panel_1);
        
        JLabel nomLabel = new JLabel("Nom :");
        nomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nomLabel.setForeground(new Color(255, 255, 255));
        nomLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        nomLabel.setBounds(0, 0, 137, 39);
        panel_1.add(nomLabel);
        
        JTextField textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(138, 0, 391, 39);
        panel_1.add(textField_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(new Color(0, 64, 128));
        panel_2.setBounds(56, 154, 529, 40);
        panel_3.add(panel_2);
        
        JLabel prenomLabel = new JLabel("Prénom :");
        prenomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        prenomLabel.setForeground(new Color(255, 255, 255));
        prenomLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        prenomLabel.setBounds(0, 0, 137, 39);
        panel_2.add(prenomLabel);
        
        JTextField textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(138, 0, 391, 39);
        panel_2.add(textField_2);
        
        JPanel panel_4 = new JPanel();
        panel_4.setLayout(null);
        panel_4.setBackground(new Color(0, 64, 128));
        panel_4.setBounds(56, 214, 529, 40);
        panel_3.add(panel_4);
        
        JLabel adresseLabel = new JLabel("Adresse :");
        adresseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        adresseLabel.setForeground(new Color(255, 255, 255));
        adresseLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        adresseLabel.setBounds(0, 0, 137, 39);
        panel_4.add(adresseLabel);
        
        JTextField textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(138, 0, 391, 39);
        panel_4.add(textField_3);
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setLayout(null);
        panel_2_1.setBackground(new Color(0, 64, 128));
        panel_2_1.setBounds(56, 274, 529, 40);
        panel_3.add(panel_2_1);
        
        JLabel SexeLabel = new JLabel("Sexe :");
        SexeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        SexeLabel.setForeground(Color.WHITE);
        SexeLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        SexeLabel.setBounds(0, 0, 137, 39);
        panel_2_1.add(SexeLabel);
        
        JTextField textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(138, 0, 391, 39);
        panel_2_1.add(textField_4);
        
        JPanel panel_2_1_1 = new JPanel();
        panel_2_1_1.setLayout(null);
        panel_2_1_1.setBackground(new Color(0, 64, 128));
        panel_2_1_1.setBounds(56, 334, 529, 40);
        panel_3.add(panel_2_1_1);
        
        JLabel SexeLabel_1 = new JLabel("Date de Naissance :");
        SexeLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        SexeLabel_1.setForeground(Color.WHITE);
        SexeLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        SexeLabel_1.setBounds(0, 0, 137, 39);
        panel_2_1_1.add(SexeLabel_1);
        
        JTextField textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(138, 0, 391, 39);
        panel_2_1_1.add(textField_5);
        
        JPanel panel_2_1_2 = new JPanel();
        panel_2_1_2.setLayout(null);
        panel_2_1_2.setBackground(new Color(0, 64, 128));
        panel_2_1_2.setBounds(56, 394, 529, 40);
        panel_3.add(panel_2_1_2);
        
        JLabel roleLabel = new JLabel("Role :");
        roleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        roleLabel.setForeground(Color.WHITE);
        roleLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        roleLabel.setBounds(0, 0, 137, 39);
        panel_2_1_2.add(roleLabel);
        
        JTextField textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(138, 0, 391, 39);
        panel_2_1_2.add(textField_6);
	}

}
