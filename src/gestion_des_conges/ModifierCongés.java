package gestion_des_conges;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Models.Conges;

public class ModifierCongés extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nbreJrsTXT;
	private JTextField cin_employe;
	private Choice anneeDebutChoice;
	private Choice moisDebutChoice;
	private Choice jrsDebutChoice;
	private Choice anneeFinChoice;
	private Choice moisFinChoice;
	private Choice jrsFinChoice;
	private Choice typeChoice;
	private JTextArea motifTextArea;
	private JTextField idTXT;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ModifierCongés() {
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
		
		
	
		cin_employe = new JTextField();
	    cin_employe.setColumns(10);
	    cin_employe.setBounds(165, 34, 123, 23);
	    containerPanel.add(cin_employe);
	    
	    JButton rechercherBtn = new JButton("Rechercher");
        rechercherBtn.setForeground(Color.WHITE);
        rechercherBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        rechercherBtn.setBackground(new Color(255, 255, 0));
        rechercherBtn.setBounds(404, 35, 112, 23);
        rechercherBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("Rechercher")) {
					Conges con = new Conges();
					try {
						ResultSet res = con.rechercherCongés(cin_employe.getText());
						res.last();
						String datedebut = res.getString("date_debut");
						String datefin = res.getString("date_fin");
					
						
						anneeDebutChoice.select(datedebut.split("-")[0]);
						moisDebutChoice.select(datedebut.split("-")[1]);
						jrsDebutChoice.select(datedebut.split("-")[2]);
						
						anneeFinChoice.select(datefin.split("-")[0]);
						moisFinChoice.select(datefin.split("-")[1]);
						jrsFinChoice.select(datefin.split("-")[2]);
						
						typeChoice.select(res.getString("type_conge"));
						motifTextArea.setText(res.getString("motif"));
						nbreJrsTXT.setText(res.getString("nbre_jrs"));
						
						
						
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
        	
        });
        containerPanel.add(rechercherBtn);
	        
        JButton refresh= new JButton("Actualiser");
        refresh.setBounds(465,100, 115, 40);
        refresh.setForeground( Color.white);
        refresh.setBackground(new Color(53, 128, 48));
        refresh.setHorizontalAlignment(JButton.CENTER);
        containerPanel.setLayout(null);
        ButtonGroup groupeTriage = new ButtonGroup();
        

   
        
        JLabel typeLabel = new JLabel("Type de congé :");
        typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        typeLabel.setForeground(Color.WHITE);
        typeLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        typeLabel.setBackground(new Color(0, 64, 128));
        typeLabel.setBounds(46, 67, 113, 23);
        containerPanel.add(typeLabel);
        
        JLabel motifLabel = new JLabel("Motif :");
        motifLabel.setHorizontalAlignment(SwingConstants.CENTER);
        motifLabel.setForeground(Color.WHITE);
        motifLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        motifLabel.setBackground(new Color(0, 64, 128));
        motifLabel.setBounds(46, 110, 113, 23);
        containerPanel.add(motifLabel);
        
        JLabel debutLabel = new JLabel("date de début :");
        debutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        debutLabel.setForeground(Color.WHITE);
        debutLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        debutLabel.setBackground(new Color(0, 64, 128));
        debutLabel.setBounds(51, 195, 113, 23);
        containerPanel.add(debutLabel);
        
        JLabel finLabel = new JLabel("date de fin :");
        finLabel.setHorizontalAlignment(SwingConstants.CENTER);
        finLabel.setForeground(Color.WHITE);
        finLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        finLabel.setBackground(new Color(0, 64, 128));
        finLabel.setBounds(51, 224, 113, 23);
        containerPanel.add(finLabel);
        
        
        
        String[] joursTable={"","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
         jrsDebutChoice = new Choice();
        for(String str : joursTable) {
        	jrsDebutChoice.add(str);
        }
        jrsDebutChoice.setBounds(165, 195, 51, 23);
        containerPanel.add(jrsDebutChoice);
        
        
        
        String[] moisTable={"","01","02","03","04","05","06","07","08","09","10","11","12"};
         moisDebutChoice = new Choice();
        for(String element : moisTable) {
        	 moisDebutChoice.add(element);
        }
        moisDebutChoice.setBounds(247, 195, 51, 23);
        containerPanel.add(moisDebutChoice);
        
        String[] yearsTable= new String[60];
        yearsTable[0]="";
        for(int i=1;i<60;i++) {
        	yearsTable[i]=String.valueOf(1960+i);
        }
         anneeDebutChoice = new Choice();
        for(String el : yearsTable) {
        	anneeDebutChoice.add(el);
        }
        anneeDebutChoice.setBounds(336, 195, 70, 18);
        containerPanel.add(anneeDebutChoice);
        
        
        String[] moisFinTable = {"","01","02","03","04","05","06","07","08","09","10","11","12"};
         moisFinChoice = new Choice();
        for(String str : moisFinTable) {
        	moisFinChoice.add(str);
        }
        moisFinChoice.setBounds(247, 224, 51, 18);
        containerPanel.add(moisFinChoice);
        
        
        String[] anneeFinTable= new String[60];
        anneeFinTable[0]="";
        for(int i=1;i<60;i++) {
        	anneeFinTable[i]=String.valueOf(1960+i);
        }
         anneeFinChoice = new Choice();
        for(String element : anneeFinTable) {
        	anneeFinChoice.add(element);
        }
        anneeFinChoice.setBounds(336, 224, 70, 18);
        containerPanel.add(anneeFinChoice);
        
        
        String[] jrsFinTable = {"","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        jrsFinChoice = new Choice();
        for(String el : jrsFinTable ) {
        	jrsFinChoice.add(el);
        }
        jrsFinChoice.setBounds(165, 224, 51, 18);
        containerPanel.add(jrsFinChoice);
        
        
        /*String[] motifsTable = {"malade","voyage","travail","...","..."};
        for(String element : motifsTable) {
        	motifChoice.add(element);
        }*/
        
        
        String[] typeTable = {"Administratif","Maladé","Maternité"};
         typeChoice = new Choice();
        for(String string : typeTable) {
        	typeChoice.add(string);
        }
        typeChoice.setBounds(165, 71, 351, 23);
        containerPanel.add(typeChoice);
        
         motifTextArea = new JTextArea();
        motifTextArea.setBounds(165, 101, 351, 43);
        containerPanel.add(motifTextArea);
        
        JLabel nbreJrs = new JLabel("Nombre de jours :");
        nbreJrs.setHorizontalAlignment(SwingConstants.CENTER);
        nbreJrs.setForeground(Color.WHITE);
        nbreJrs.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        nbreJrs.setBackground(new Color(0, 64, 128));
        nbreJrs.setBounds(26, 158, 133, 23);
        containerPanel.add(nbreJrs);
        
        nbreJrsTXT = new JTextField();
        nbreJrsTXT.setColumns(10);
        nbreJrsTXT.setBounds(165, 158, 351, 23);
        containerPanel.add(nbreJrsTXT);
        
        JButton modifierBtn = new JButton("Modifier");
        modifierBtn.setForeground(Color.WHITE);
        modifierBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        modifierBtn.setBackground(new Color(0, 128, 255));
        modifierBtn.setBounds(46, 273, 112, 29);
   
   
        modifierBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				

					try {
						String date_debut = anneeDebutChoice.getSelectedItem()+"-"+moisDebutChoice.getSelectedItem()+"-"+jrsDebutChoice.getSelectedItem();
						String date_fin = anneeFinChoice.getSelectedItem()+"-"+moisFinChoice.getSelectedItem()+"-"+jrsFinChoice.getSelectedItem();
						Conges conge = new Conges();
						System.out.println(date_debut);
						System.out.println(date_fin);
						conge.setDate_debut(date_debut);
						conge.setDate_fin(date_fin);
						conge.setMotif(motifTextArea.getText());
						conge.setType_conge(typeChoice.getSelectedItem());
						conge.setNbre_jrs(Integer.parseInt(nbreJrsTXT.getText()));
						conge.setCin_employe(cin_employe.getText());
						conge.setAnnee(anneeDebutChoice.getSelectedItem());
						conge.modifierConge(conge);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
			
        	
        });
        containerPanel.add(modifierBtn);
        
        
        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setForeground(Color.WHITE);
        btnSupprimer.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        btnSupprimer.setBackground(new Color(128, 128, 0));
        btnSupprimer.setBounds(336, 273, 112, 29);
        btnSupprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Conges conge = new Conges();
				if(idTXT.getText().isEmpty()) {
				
					conge.supprimerConge(cin_employe.getText());
				}else {
					conge.supprimerConge(cin_employe.getText(), Integer.parseInt(idTXT.getText()));
				}
				
				
			}
        	
        });
        containerPanel.add(btnSupprimer);
       
        
        JButton viderBtn = new JButton("Vider");
        viderBtn.setForeground(Color.WHITE);
        viderBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        viderBtn.setBackground(new Color(128, 128, 0));
        viderBtn.setBounds(190, 273, 112, 29);
        viderBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cin_employe.setText("");
				motifTextArea.setText("");
				anneeDebutChoice.select(0);
				moisDebutChoice.select(0);
				jrsDebutChoice.select(0);
				anneeFinChoice.select(0);
				moisFinChoice.select(0);
				jrsFinChoice.select(0);
				nbreJrsTXT.setText("");
				typeChoice.select(0);
			}
        	
        });
        containerPanel.add(viderBtn);
        
        JLabel lblCinDemandeur = new JLabel("CIN demandeur :");
        lblCinDemandeur.setHorizontalAlignment(SwingConstants.CENTER);
        lblCinDemandeur.setForeground(Color.WHITE);
        lblCinDemandeur.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        lblCinDemandeur.setBackground(new Color(0, 64, 128));
        lblCinDemandeur.setBounds(46, 34, 113, 23);
        containerPanel.add(lblCinDemandeur);
        
        idTXT = new JTextField();
        idTXT.setColumns(10);
        idTXT.setBounds(342, 34, 50, 23);
        containerPanel.add(idTXT);
        
        JLabel IDlabel = new JLabel("ID :");
        IDlabel.setHorizontalAlignment(SwingConstants.CENTER);
        IDlabel.setForeground(Color.WHITE);
        IDlabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        IDlabel.setBackground(new Color(0, 64, 128));
        IDlabel.setBounds(286, 32, 50, 23);
        containerPanel.add(IDlabel);
        
       
        
      
        
        
        
        return this;
	}
}
