package gestion_des_conges;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Models.Utilisateurs;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextField;

public class ConfigurationsFrame extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel  databaseconfsPanel;
	private JTextField serveurTXT;
	private JTextField bdTXT;
	private JTextField tableTXT;
	private JTextField userTXT;
	private JTextField passTXT;
	private JTextField ancienPassTXT;
	private JTextField newPassTXT;
	private JTextField newPass2TXT;
	private JTextField userNameTXT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurationsFrame frame = new ConfigurationsFrame();
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
	public ConfigurationsFrame() {
		configurationsPanel();
	}
	public JPanel configurationsPanel() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Configurations");
		lblNewLabel_1.setBounds(10, 0, 878, 35);
		panel_1_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(homeFrame.class.getResource("/res/fstee (1).png")));
		lblNewLabel.setBounds(0, 20, 898, 77);
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
        
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(10, 72, 858, 437);
        panel_3.add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));
        

        
     
        
        JPanel btnsPanel = new JPanel();
        btnsPanel.setBackground(new Color(255, 128, 64));
        btnsPanel.setBounds(10, 10, 858, 52);
        panel_3.add(btnsPanel);
        btnsPanel.setLayout(null);
        
        JButton confsDbBtn = new JButton("Configurer les parametres de la base de données");
        confsDbBtn.setForeground(new Color(255, 255, 255));
        confsDbBtn.setBackground(new Color(64, 128, 128));
        confsDbBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        confsDbBtn.setBounds(88, 5, 349, 42);
        confsDbBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changerPanels(dataBasesConfs());
			}
        	
        });
        btnsPanel.add(confsDbBtn);
        
        JButton btnConfigurerLesInformation = new JButton("Configurer les information du compte");
        btnConfigurerLesInformation.setForeground(new Color(255, 255, 255));
        btnConfigurerLesInformation.setBackground(new Color(64, 128, 128));
        btnConfigurerLesInformation.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        btnConfigurerLesInformation.setBounds(481, 5, 268, 42);
        btnConfigurerLesInformation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changerPanels(userInfosConfs());
			}
        	
        });
        btnsPanel.add(btnConfigurerLesInformation);
        return contentPane;
	}
	
	public JPanel dataBasesConfs() {
        JPanel dataBaseConfigurationsPanel = new JPanel();
        layeredPane.add(dataBaseConfigurationsPanel, "name_3017286014320800");
        dataBaseConfigurationsPanel.setLayout(null);
        
        databaseconfsPanel = new JPanel();
        databaseconfsPanel.setLayout(null);
        databaseconfsPanel.setBackground(new Color(0, 64, 128));
        databaseconfsPanel.setBounds(0, 0, 858, 41);
        dataBaseConfigurationsPanel.add(databaseconfsPanel);
        
        JLabel databaseConfsLabel = new JLabel("Base de Données - BD");
        databaseConfsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        databaseConfsLabel.setForeground(new Color(255, 255, 255));
        databaseConfsLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        databaseConfsLabel.setBounds(10, 0, 838, 35);
        databaseconfsPanel.add(databaseConfsLabel);
        
        JLabel adresseServeurLabel = new JLabel("Adresse Serveur");
        adresseServeurLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        adresseServeurLabel.setBounds(101, 61, 122, 27);
        dataBaseConfigurationsPanel.add(adresseServeurLabel);
        
        JLabel dbLabel = new JLabel("Base de données");
        dbLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        dbLabel.setBounds(101, 123, 122, 27);
        dataBaseConfigurationsPanel.add(dbLabel);
        
        JLabel tableLabel = new JLabel("Table");
        tableLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        tableLabel.setBounds(101, 188, 122, 27);
        dataBaseConfigurationsPanel.add(tableLabel);
        
        JLabel userLabel = new JLabel("Utilisateur");
        userLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        userLabel.setBounds(101, 250, 122, 27);
        dataBaseConfigurationsPanel.add(userLabel);
        
        JLabel password = new JLabel("Mot de passe ");
        password.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        password.setBounds(101, 316, 122, 27);
        dataBaseConfigurationsPanel.add(password);
        
        serveurTXT = new JTextField();
        serveurTXT.setBounds(277, 61, 438, 27);
        dataBaseConfigurationsPanel.add(serveurTXT);
        serveurTXT.setColumns(10);
        
        bdTXT = new JTextField();
        bdTXT.setColumns(10);
        bdTXT.setBounds(277, 123, 438, 27);
        dataBaseConfigurationsPanel.add(bdTXT);
        
        tableTXT = new JTextField();
        tableTXT.setColumns(10);
        tableTXT.setBounds(277, 188, 438, 27);
        dataBaseConfigurationsPanel.add(tableTXT);
        
        userTXT = new JTextField();
        userTXT.setColumns(10);
        userTXT.setBounds(277, 250, 438, 27);
        dataBaseConfigurationsPanel.add(userTXT);
        
        passTXT = new JTextField();
        passTXT.setColumns(10);
        passTXT.setBounds(277, 316, 438, 27);
        dataBaseConfigurationsPanel.add(passTXT);
        
        JButton validerBtn = new JButton("Valider");
        validerBtn.setForeground(new Color(255, 255, 255));
        validerBtn.setBackground(new Color(0, 64, 128));
        validerBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        validerBtn.setBounds(277, 384, 161, 41);
        validerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(serveurTXT.getText().isEmpty() || bdTXT.getText().isEmpty() ||  tableTXT.getText().isEmpty() || userTXT.getText().isEmpty() || passTXT.getText().isEmpty()) {
    			    JOptionPane.showMessageDialog(null, "veuillez remplir tous les champs !!", "Info", JOptionPane.INFORMATION_MESSAGE);

				}else {
					  int val=JOptionPane.showConfirmDialog(null, "Voulez Vous vraiment modifier les champs", "modifier",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE );
					   if(val==0) {
							String txt = serveurTXT.getText()+"&"+bdTXT.getText()+"&"+tableTXT.getText()+"&"+userTXT.getText()+"&"+passTXT.getText();
							try {
								
								BufferedWriter fich= new BufferedWriter(new FileWriter("D://file.txt"));
								
								fich.write(txt);
								
								fich.close();
			    			    JOptionPane.showMessageDialog(null, "modification est  faite !!", "Info", JOptionPane.INFORMATION_MESSAGE);

						

							}catch(Exception exc) {
								
							    JOptionPane.showMessageDialog(null, exc.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

							}
					   }
				}
				 
			}
        	
        });
        dataBaseConfigurationsPanel.add(validerBtn);
        
        JButton viderBtn = new JButton("Vider");
        viderBtn.setForeground(new Color(255, 255, 255));
        viderBtn.setBackground(new Color(255, 128, 64));
        viderBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        viderBtn.setBounds(554, 384, 161, 41);
        viderBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				serveurTXT.setText("");
				bdTXT.setText("");
				tableTXT.setText("");
				passTXT.setText("");
				userTXT.setText("");
			}
        	
        });
        dataBaseConfigurationsPanel.add(viderBtn);
        
        try {
			chargerData();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		    JOptionPane.showMessageDialog(null, e1.getMessage(), "Info", JOptionPane.INFORMATION_MESSAGE);
		}
        
        return  dataBaseConfigurationsPanel;
	}
	public JPanel userInfosConfs() {
		   JPanel userInfosConfigurationsPanel = new JPanel();
	        layeredPane.add(userInfosConfigurationsPanel, "name_3017291236710000");
	        userInfosConfigurationsPanel.setLayout(null);
	        
	        JPanel userInfoConfsPanel = new JPanel();
	        userInfoConfsPanel.setLayout(null);
	        userInfoConfsPanel.setBackground(new Color(0, 64, 128));
	        userInfoConfsPanel.setBounds(0, 0, 858, 41);
	        userInfosConfigurationsPanel.add(userInfoConfsPanel);
	        
	        JLabel userInfoConfLabel = new JLabel("Configurer votre Compte Utilisateur");
	        userInfoConfLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        userInfoConfLabel.setForeground(new Color(255, 255, 255));
	        userInfoConfLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
	        userInfoConfLabel.setBounds(10, 0, 838, 35);
	        userInfoConfsPanel.add(userInfoConfLabel);
	        
	        JButton viderBtn = new JButton("Vider");
	        viderBtn.setForeground(Color.WHITE);
	        viderBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
	        viderBtn.setBackground(new Color(255, 128, 64));
	        viderBtn.setBounds(596, 319, 161, 41);
	        viderBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					userNameTXT.setText("");
					ancienPassTXT.setText("");
					newPassTXT.setText("");
					newPass2TXT.setText("");
				}
	        	
	        });
	        userInfosConfigurationsPanel.add(viderBtn);
	        
	        JLabel ancienPassLabel = new JLabel("Ancien mot de passe :");
	        ancienPassLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
	        ancienPassLabel.setBounds(78, 127, 166, 27);
	        userInfosConfigurationsPanel.add(ancienPassLabel);
	        
	        ancienPassTXT = new JTextField();
	        ancienPassTXT.setColumns(10);
	        ancienPassTXT.setBounds(319, 130, 438, 27);
	        userInfosConfigurationsPanel.add(ancienPassTXT);
	        
	        JLabel newPassLabel = new JLabel("Nouveau mot de passe :");
	        newPassLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
	        newPassLabel.setBounds(78, 183, 166, 27);
	        userInfosConfigurationsPanel.add(newPassLabel);
	        
	        newPassTXT = new JTextField();
	        newPassTXT.setColumns(10);
	        newPassTXT.setBounds(319, 186, 438, 27);
	        userInfosConfigurationsPanel.add(newPassTXT);
	        
	        JLabel newPass2Label = new JLabel("Réecrir le noveau mot de passe :");
	        newPass2Label.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
	        newPass2Label.setBounds(78, 234, 234, 27);
	        userInfosConfigurationsPanel.add(newPass2Label);
	        
	        newPass2TXT = new JTextField();
	        newPass2TXT.setColumns(10);
	        newPass2TXT.setBounds(319, 237, 438, 27);
	        userInfosConfigurationsPanel.add(newPass2TXT);
	        
	        JButton saveBtn = new JButton("Enregistrer");
	        saveBtn.setForeground(Color.WHITE);
	        saveBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
	        saveBtn.setBackground(new Color(0, 64, 128));
	        saveBtn.setBounds(319, 319, 161, 41);
	        saveBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getActionCommand().equals("Enregistrer")) {
					if(userNameTXT.getText().isEmpty() || ancienPassTXT.getText().isEmpty() || newPassTXT.getText().isEmpty() || newPass2TXT.getText().isEmpty()) {
					    JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs", "Info", JOptionPane.INFORMATION_MESSAGE);

					}else {

						if( newPassTXT.getText().equals(newPass2TXT.getText()) ) {
						    Utilisateurs user = new Utilisateurs();
							user.setNom_utilisateur(userNameTXT.getText());
							user.setPassword(newPassTXT.getText());
							user.modifierInformations(user);
						}else {
						    JOptionPane.showMessageDialog(null, "les deux nouveaux mot de passes saisies sont incompatible", "Info", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					
					}
					
					
				}
	        	
	        });
	        userInfosConfigurationsPanel.add(saveBtn);
	        
	        userNameTXT = new JTextField();
	        userNameTXT.setColumns(10);
	        userNameTXT.setBounds(319, 76, 263, 27);
	        userInfosConfigurationsPanel.add(userNameTXT);
	        
	        JLabel userNameLabel = new JLabel("Nom d'utilisateur :");
	        userNameLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
	        userNameLabel.setBounds(78, 73, 137, 27);
	        userInfosConfigurationsPanel.add(userNameLabel);
	        
	        JButton btnTrouver = new JButton("Trouver");
	        btnTrouver.setForeground(Color.WHITE);
	        btnTrouver.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
	        btnTrouver.setBackground(new Color(255, 128, 64));
	        btnTrouver.setBounds(592, 76, 161, 27);
	        btnTrouver.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Utilisateurs user = new Utilisateurs();
					try {
						ResultSet res = user.remplirChamps(userNameTXT.getText());
						ancienPassTXT.setText(res.getString("password"));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
					    JOptionPane.showMessageDialog(null, e1.getMessage(), "Info", JOptionPane.INFORMATION_MESSAGE);
					    
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
					    JOptionPane.showMessageDialog(null, e1.getMessage(), "Info", JOptionPane.INFORMATION_MESSAGE);
					}
				}
	        	
	        });
	        userInfosConfigurationsPanel.add(btnTrouver);
	        return userInfosConfigurationsPanel;
	
	}
	public void changerPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
    public void chargerData() throws IOException{
    	/* Le chemin vers le fichier � lire */
    	
    	
    	String ligneLue;
    	String[] tab = null;

    	BufferedReader fluxEntree=null;
    	
    	try {
    		/* Cr�ation du flux vers le fichier texte */
    		fluxEntree = new BufferedReader(new FileReader("D://file.txt"));
              
    		/* Lecture d'une ligne */
    		ligneLue = fluxEntree.readLine();
    		while(ligneLue!=null){
    			
    			tab=ligneLue.split("&");
    		
    			
    			ligneLue = fluxEntree.readLine();	
    			
        		serveurTXT.setText(tab[0]);
    			bdTXT.setText(tab[1]);
    			tableTXT.setText(tab[2]);
    			userTXT.setText(tab[3]);
    			passTXT.setText(tab[4]);
    		}
    		

		

    	}
    	catch(IOException exc){
    		System.out.println(exc.getMessage());
    	}finally {
    		if(fluxEntree!=null) {
    					fluxEntree.close();

    		}
    	}
    	
    	
    	
    	
    }
}
