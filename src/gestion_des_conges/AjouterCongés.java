package gestion_des_conges;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import Models.Conges;

import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JTextArea;

public class AjouterCongés extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField demandeurTXT;
	private JTextField nbreJrsTXT;


	public AjouterCongés() {
		ajouterFrame();
	}
	public JFrame ajouterFrame() {
		setBounds(0, 0, 623, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setLayout(null);
		
		JPanel titrepanel = new JPanel();
		titrepanel.setBackground(new Color(0, 64, 128));
		titrepanel.setBounds(0, 97, 609, 37);
		contentPane.add(titrepanel);
		titrepanel.setLayout(null);
		
		JLabel titreLabel = new JLabel("Formulaire d'Ajout des Personnels");
		titreLabel.setBounds(10, 0, 593, 35);
		titrepanel.add(titreLabel);
		titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titreLabel.setForeground(new Color(255, 128, 64));
		titreLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		
		JLabel logoFsteLabel = new JLabel("");
		logoFsteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoFsteLabel.setIcon(new ImageIcon(homeFrame.class.getResource("/res/fstee (1).png")));
		logoFsteLabel.setBounds(0, 10, 609, 77);
		contentPane.add(logoFsteLabel);
		
		JPanel containerPanel = new JPanel();
		containerPanel.setBackground(new Color(255, 128, 64));
		containerPanel.setForeground(new Color(255, 128, 64));
		containerPanel.setBounds(10, 144, 588, 330);
		contentPane.add(containerPanel);
		
		
	

        JButton refresh= new JButton("Actualiser");
        refresh.setBounds(465,100, 115, 40);
        refresh.setForeground( Color.white);
        refresh.setBackground(new Color(53, 128, 48));
        refresh.setHorizontalAlignment(JButton.CENTER);
        containerPanel.setLayout(null);
        

        
        JButton btnVider = new JButton("Vider");
        btnVider.setForeground(Color.WHITE);
        btnVider.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        btnVider.setBackground(new Color(128, 128, 0));
        btnVider.setBounds(193, 283, 112, 37);
        containerPanel.add(btnVider);
        
        JLabel typeLabel = new JLabel("Type de congé :");
        typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        typeLabel.setForeground(Color.WHITE);
        typeLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        typeLabel.setBackground(new Color(0, 64, 128));
        typeLabel.setBounds(51, 31, 113, 23);
        containerPanel.add(typeLabel);
        
        JLabel motifLabel = new JLabel("Motif :");
        motifLabel.setHorizontalAlignment(SwingConstants.CENTER);
        motifLabel.setForeground(Color.WHITE);
        motifLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        motifLabel.setBackground(new Color(0, 64, 128));
        motifLabel.setBounds(51, 74, 113, 23);
        containerPanel.add(motifLabel);
        
        JLabel debutLabel = new JLabel("date de début :");
        debutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        debutLabel.setForeground(Color.WHITE);
        debutLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        debutLabel.setBackground(new Color(0, 64, 128));
        debutLabel.setBounds(56, 159, 113, 23);
        containerPanel.add(debutLabel);
        
        JLabel finLabel = new JLabel("date de fin :");
        finLabel.setHorizontalAlignment(SwingConstants.CENTER);
        finLabel.setForeground(Color.WHITE);
        finLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        finLabel.setBackground(new Color(0, 64, 128));
        finLabel.setBounds(56, 188, 113, 23);
        containerPanel.add(finLabel);
        
        JLabel demandeurLabel = new JLabel("ID demandeur :");
        demandeurLabel.setHorizontalAlignment(SwingConstants.CENTER);
        demandeurLabel.setForeground(Color.WHITE);
        demandeurLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        demandeurLabel.setBackground(new Color(0, 64, 128));
        demandeurLabel.setBounds(56, 226, 113, 23);
        containerPanel.add(demandeurLabel);
        
        demandeurTXT = new JTextField();
        demandeurTXT.setColumns(10);
        demandeurTXT.setBounds(170, 226, 351, 23);
        containerPanel.add(demandeurTXT);
        
        
        
        String[] joursTable={"","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        Choice jrsDebutChoice = new Choice();
        for(String str : joursTable) {
        	jrsDebutChoice.add(str);
        }
        jrsDebutChoice.setBounds(170, 159, 51, 23);
        containerPanel.add(jrsDebutChoice);
        
        
        
        String[] moisTable={"","01","02","03","04","05","06","07","08","09","10","11","12"};
        Choice moisDebutChoice = new Choice();
        for(String element : moisTable) {
        	 moisDebutChoice.add(element);
        }
        moisDebutChoice.setBounds(252, 159, 51, 23);
        containerPanel.add(moisDebutChoice);
        
        String[] yearsTable= new String[10];
        yearsTable[0]="";
        for(int i=1;i<10;i++) {
        	yearsTable[i]=String.valueOf(2023+i);
        }
        Choice anneeDebutChoice = new Choice();
        for(String el : yearsTable) {
        	anneeDebutChoice.add(el);
        }
        anneeDebutChoice.setBounds(341, 159, 70, 18);
        containerPanel.add(anneeDebutChoice);
        
        
        String[] moisFinTable = {"","01","02","03","04","05","06","07","08","09","10","11","12"};
        Choice moisFinChoice = new Choice();
        for(String str : moisFinTable) {
        	moisFinChoice.add(str);
        }
        moisFinChoice.setBounds(252, 188, 51, 18);
        containerPanel.add(moisFinChoice);
        
        
        String[] anneeFinTable= new String[10];
        anneeFinTable[0]="";
        for(int i=1;i<10;i++) {
        	anneeFinTable[i]=String.valueOf(2023+i);
        }
        Choice anneeFinChoice = new Choice();
        for(String element : anneeFinTable) {
        	anneeFinChoice.add(element);
        }
        anneeFinChoice.setBounds(341, 188, 70, 18);
        containerPanel.add(anneeFinChoice);
        
        
        String[] jrsFinTable = {"","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        Choice jrsFinChoice = new Choice();
        for(String el : jrsFinTable ) {
        	jrsFinChoice.add(el);
        }
        jrsFinChoice.setBounds(170, 188, 51, 18);
        containerPanel.add(jrsFinChoice);
        
        
        /*String[] motifsTable = {"malade","voyage","travail","...","..."};
        for(String element : motifsTable) {
        	motifChoice.add(element);
        }*/
        
        
        String[] typeTable = {"Administratif","Maladé","Maternité"};
        Choice typeChoice = new Choice();
        for(String string : typeTable) {
        	typeChoice.add(string);
        }
        typeChoice.setBounds(170, 35, 351, 23);
        containerPanel.add(typeChoice);
        
        JTextArea motifTextArea = new JTextArea();
        motifTextArea.setBounds(170, 65, 351, 43);
        containerPanel.add(motifTextArea);
        
        JLabel nbreJrs = new JLabel("Nombre de jours :");
        nbreJrs.setHorizontalAlignment(SwingConstants.CENTER);
        nbreJrs.setForeground(Color.WHITE);
        nbreJrs.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        nbreJrs.setBackground(new Color(0, 64, 128));
        nbreJrs.setBounds(31, 122, 133, 23);
        containerPanel.add(nbreJrs);
        
        nbreJrsTXT = new JTextField();
        nbreJrsTXT.setColumns(10);
        nbreJrsTXT.setBounds(170, 122, 351, 23);
        containerPanel.add(nbreJrsTXT);
        
        JButton addButton = new JButton("Ajouter");
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        addButton.setBackground(new Color(0, 128, 255));
        addButton.setBounds(51, 283, 112, 37);
        addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("Ajouter")) {

					try {
						String date_debut = anneeDebutChoice.getSelectedItem()+"-"+moisDebutChoice.getSelectedItem()+"-"+jrsDebutChoice.getSelectedItem();
						String date_fin = anneeFinChoice.getSelectedItem()+"-"+moisFinChoice.getSelectedItem()+"-"+jrsFinChoice.getSelectedItem();
						String annee = anneeDebutChoice.getSelectedItem();
						Conges conge = new Conges();
						
						
						conge.setDate_debut(date_debut);
						conge.setDate_fin(date_fin);
						conge.setMotif(motifTextArea.getText());
						conge.setCin_employe(demandeurTXT.getText());
						conge.setType_conge(typeChoice.getSelectedItem());
						conge.setNbre_jrs(Integer.parseInt(nbreJrsTXT.getText()));
						conge.setAnnee(annee);
						
						conge.ajouterConge(conge);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
			}
        	
        });
        containerPanel.add(addButton);
        
        return this;
	}
}
