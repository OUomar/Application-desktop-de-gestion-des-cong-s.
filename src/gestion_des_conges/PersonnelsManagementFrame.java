package gestion_des_conges;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Models.Employee;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.CheckboxGroup;

import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.BevelBorder;

public class PersonnelsManagementFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomTXT;
	private JTextField prenomTXT;
	private JTextField adresseTXT;
	private JTextField naissanceTXT;
	private JTextField telTXT;
	private JTextField mailTXT;
	private JTextField jrsTotalTXT;
	private JTextField jrsRestantTXT;

	
	private JTextField nomTextM; 
	private JTextField prenomTextM;
	private JTextField adresseTextM;
	private JTextField naissanceTextM;
	private JTextField telTextM;
	private JTextField mailTextM;
	private JTextField jrsTotTextM;
	private JTextField jrsResTextM;
	private JTextField cinTextM;
	private String path;
	//private ButtonGroup groupeTriage;
	private JLayeredPane afficherAjouterModifierPanel;
	private JTextField cinTXT;
	Employee employe;
	
	JTable taab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonnelsManagementFrame frame = new PersonnelsManagementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonnelsManagementFrame() {
		pmfPanel();
	}
	
	
	public JPanel pmfPanel() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Gestion des Personnels");
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
		
		JPanel globalPanel = new JPanel();
		globalPanel.setBackground(new Color(255, 128, 64));
		globalPanel.setForeground(new Color(255, 128, 64));
		globalPanel.setBounds(10, 165, 878, 519);
		contentPane.add(globalPanel);
		
		
	

        /*JButton refresh= new JButton("Actualiser");
        refresh.setBounds(465,100, 115, 40);
        refresh.setForeground( Color.white);
        refresh.setBackground(new Color(53, 128, 48));
        refresh.setHorizontalAlignment(JButton.CENTER);
        panel_3.setLayout(null);
        ButtonGroup groupeTriage = new ButtonGroup();*/

        /////////////////////////////////////////////////
		JTable tableau = new JTable();
		
		Employee employe = new Employee();
		
		try {
			 taab = employe.afficher();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		JScrollPane jsc = null;
		try {
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

		}
		//les buttons
        
        JButton btnAfficher = new JButton("Afficher");
        btnAfficher.setForeground(Color.WHITE);
        btnAfficher.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        btnAfficher.setBackground(new Color(0, 128, 255));
        btnAfficher.setBounds(230, 10, 120, 30);
        
        
        btnAfficher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
						changerPanels(afficherPanel());
					
			}
			
		});
        globalPanel.setLayout(null);
        globalPanel.add(btnAfficher);
        
        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.setForeground(Color.WHITE);
        btnAjouter.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        btnAjouter.setBackground(new Color(0, 128, 255));
        btnAjouter.setBounds(370, 10, 120, 30);
        btnAjouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					changerPanels(ajouterPanel());
				
			}
        	
        });
        globalPanel.add(btnAjouter);
        
        JButton btnModifier = new JButton("Modifier");
        btnModifier.setForeground(Color.WHITE);
        btnModifier.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        btnModifier.setBackground(new Color(0, 128, 255));
        btnModifier.setBounds(510, 10, 120, 30);
        btnModifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					changerPanels(modifierPanel());
				
			}
        	
        });
        globalPanel.add(btnModifier);
        
         afficherAjouterModifierPanel = new JLayeredPane();
        afficherAjouterModifierPanel.setBounds(10, 44, 858, 465);
        globalPanel.add(afficherAjouterModifierPanel);
        afficherAjouterModifierPanel.setLayout(new CardLayout(0, 0));
        return contentPane;
	}
	
	@SuppressWarnings("null")
	public JPanel afficherPanel() {
        JPanel afficherPanel = new JPanel();
        afficherAjouterModifierPanel.add(afficherPanel, "name_3135452879484300");
        afficherPanel.setLayout(null);
        JLabel trier = new JLabel("Trier par :");
        trier.setBounds(40, 13, 112, 31);
        afficherPanel.add(trier);
        trier.setForeground(new Color(0, 0, 0));
        trier.setHorizontalAlignment(SwingConstants.CENTER);
        trier.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        trier.setBackground(new Color(79, 83, 78));
        JPanel panel = new JPanel();
        panel.setBounds(159, 13, 512, 31);
        afficherPanel.add(panel);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        
        // 
        ButtonGroup groupe = new ButtonGroup();
        
        
        
       /* if(e.getActionCommand()=="num") {
    		
    	    TableRowSorter<TableModel> s = new TableRowSorter<TableModel>(tableau.getModel());
    	      //trier les lignes de JTable
    	      tableau.setRowSorter(s);
    	      java.util.List<RowSorter.SortKey> sortList = new ArrayList<>();
    	      sortList.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
    	 
    	      s.setSortKeys(sortList);
    	
    }
    	if(e.getActionCommand()=="nom") {
    		
    	    TableRowSorter<TableModel> s = new TableRowSorter<TableModel>(tableau.getModel());
    	      //trier les lignes de JTable
    	      tableau.setRowSorter(s);
    	      java.util.List<RowSorter.SortKey> sortList = new ArrayList<>();
    	      sortList.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
    	 
    	      s.setSortKeys(sortList);
    	
    }*/

        
        
        
        //checkbox num
        JRadioButton numB = new JRadioButton("num");
        numB.setBackground(new Color(255, 255, 255));
        numB.setHorizontalAlignment(SwingConstants.CENTER);
        numB.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        numB.setBounds(34, 0, 99, 31);
        numB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		    	
		    		if(e.getActionCommand().equals("numB")) {
		    			try {
							Employee em = new Employee();
				    	    TableRowSorter<TableModel> s = new TableRowSorter<TableModel>(em.afficher().getModel());
				    	      //trier les lignes de JTable
				    	     
								em.afficher().setRowSorter(s);
						
				    	      java.util.List<RowSorter.SortKey> sortList = new ArrayList<>();
				    	      sortList.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
				    	 
				    	      s.setSortKeys(sortList);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

						}
		    		}
		    	   	
		    
			}
        	
        });
        groupe.add(numB);
        panel.add(numB);
 
        //checkbox nom
        JRadioButton nomB = new JRadioButton("nom");
        nomB.setBackground(new Color(255, 255, 255));
        nomB.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        nomB.setHorizontalAlignment(SwingConstants.CENTER);
        nomB.setBounds(198, 0, 99, 31);
        groupe.add(nomB);
        panel.add(nomB);
        
        
        //checkbox dateNaissance
        JRadioButton dateNaissB= new JRadioButton("dateNaissance");
        dateNaissB.setBackground(new Color(255, 255, 255));
        dateNaissB.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        dateNaissB.setHorizontalAlignment(SwingConstants.CENTER);
        dateNaissB.setBounds(338, 0, 168, 31);
        dateNaissB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("dateNaissB")) {
	    			try {
						Employee em = new Employee();
			    	    TableRowSorter<TableModel> s = new TableRowSorter<TableModel>(taab.getModel());
			    	      //trier les lignes de JTable
			    	     
							em.afficher().setRowSorter(s);
					
			    	      java.util.List<RowSorter.SortKey> sortList = new ArrayList<>();
			    	      sortList.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
			    	 
			    	      s.setSortKeys(sortList);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

					}
	    		}
			}
        	
        });
        groupe.add(dateNaissB);
        panel.add(dateNaissB);
        
        JButton refreshButton = new JButton("Actualiser");
        refreshButton.setBounds(713, 10, 112, 37);
        afficherPanel.add(refreshButton);
        refreshButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        refreshButton.setBackground(new Color(0, 128, 0));
        refreshButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Employee em = new Employee();
			       
				try {
					JScrollPane jsc = new JScrollPane(em.afficher()); ;
				    jsc.setBounds(0,60,858,465);
					
					afficherPanel.add(jsc);
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

				}
			}
        	
        });
        refreshButton.setForeground(new Color(255, 255, 255));
        
      
        
        Employee em = new Employee();
       
		try {
			JScrollPane jsc = new JScrollPane(em.afficher()); ;
		    jsc.setBounds(0,60,858,465);
			
			afficherPanel.add(jsc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

		}

        


       
        return afficherPanel;
	}
	
	public JPanel ajouterPanel() {
        JPanel ajouterPan = new JPanel();
        afficherAjouterModifierPanel.add(ajouterPan, "name_3129150754006000");
        ajouterPan.setLayout(null);
        
        nomTXT = new JTextField();
        nomTXT.setBounds(139, 90, 258, 20);
        ajouterPan.add(nomTXT);
        nomTXT.setColumns(10);
        
        prenomTXT = new JTextField();
        prenomTXT.setColumns(10);
        prenomTXT.setBounds(139, 130, 258, 20);
        ajouterPan.add(prenomTXT);
        
        adresseTXT = new JTextField();
        adresseTXT.setColumns(10);
        adresseTXT.setBounds(139, 170, 258, 20);
        ajouterPan.add(adresseTXT);
        
        naissanceTXT = new JTextField();
        naissanceTXT.setColumns(10);
        naissanceTXT.setBounds(139, 210, 258, 20);
        ajouterPan.add(naissanceTXT);
        
        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.setForeground(Color.WHITE);
        btnAjouter.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        btnAjouter.setBackground(new Color(0, 128, 255));
        btnAjouter.setBounds(29, 418, 148, 30);
        btnAjouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("Ajouter")) {
					
					if(cinTXT.getText().equals("") || nomTXT.getText().isEmpty() || prenomTXT.getText().isEmpty() || adresseTXT.getText().isEmpty() || telTXT.getText().isEmpty() || naissanceTXT.getText().isEmpty() || mailTXT.getText().isEmpty() || jrsTotalTXT.getText().isEmpty() || jrsRestantTXT.getText().toString().isEmpty()){
						JOptionPane.showMessageDialog(null, "veuillez remplir tous les champs !!", "Info", JOptionPane.WARNING_MESSAGE);
					}else {
						
						employe = new Employee();
						employe.setCin_employe(cinTXT.getText());
						employe.setNom_employee(nomTXT.getText());
						employe.setPrenom_employee(prenomTXT.getText());
						employe.setAdresse_employee(adresseTXT.getText());
						employe.setNumero_telephone(telTXT.getText());
						employe.setDate_naissance(naissanceTXT.getText());
						employe.setNbre_restant(Integer.parseInt(jrsRestantTXT.getText()));
						employe.setNbre_total(Integer.parseInt(jrsTotalTXT.getText()));
						employe.setEmail_employee(mailTXT.getText());
						employe.setPath(path);
						
						try {
							employe.ajouterEmploye(employe);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

						}
					}
					
				}
			}
        	
        });
        
        ajouterPan.add(btnAjouter);
        
        telTXT = new JTextField();
        telTXT.setColumns(10);
        telTXT.setBounds(139, 250, 258, 20);
        ajouterPan.add(telTXT);
        
        mailTXT = new JTextField();
        mailTXT.setColumns(10);
        mailTXT.setBounds(139, 290, 258, 20);
        ajouterPan.add(mailTXT);
        
        jrsTotalTXT = new JTextField();
        jrsTotalTXT.setColumns(10);
        jrsTotalTXT.setBounds(139, 330, 258, 20);
        ajouterPan.add(jrsTotalTXT);
        
        jrsRestantTXT = new JTextField();
        jrsRestantTXT.setColumns(10);
        jrsRestantTXT.setBounds(139, 370, 258, 20);
        ajouterPan.add(jrsRestantTXT);
        
        JLabel nomLabel = new JLabel("Nom :");
        nomLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        nomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nomLabel.setBounds(20, 90, 121, 18);
        ajouterPan.add(nomLabel);
        
        JLabel prenomLabel = new JLabel("Prénom :");
        prenomLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        prenomLabel.setBackground(new Color(0, 64, 128));
        prenomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        prenomLabel.setBounds(20, 130, 121, 18);
        ajouterPan.add(prenomLabel);
        
        JLabel adresseLabel = new JLabel("Adresse :");
        adresseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        adresseLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        adresseLabel.setBackground(new Color(0, 64, 128));
        adresseLabel.setBounds(20, 170, 121, 18);
        ajouterPan.add(adresseLabel);
        
        JLabel naissanceLabel = new JLabel("Date Naissance :");
        naissanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        naissanceLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        naissanceLabel.setBackground(new Color(0, 64, 128));
        naissanceLabel.setBounds(20, 210, 121, 18);
        ajouterPan.add(naissanceLabel);
        
        JLabel telLabel = new JLabel("N° Tel  :");
        telLabel.setHorizontalAlignment(SwingConstants.CENTER);
        telLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        telLabel.setBackground(new Color(0, 64, 128));
        telLabel.setBounds(20, 250, 121, 18);
        ajouterPan.add(telLabel);
        
        JLabel mailLabel = new JLabel("Email :");
        mailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mailLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        mailLabel.setBackground(new Color(0, 64, 128));
        mailLabel.setBounds(20, 290, 121, 18);
        ajouterPan.add(mailLabel);
        
        JLabel jrsTotLabel = new JLabel("Jours Totals :");
        jrsTotLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jrsTotLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        jrsTotLabel.setBackground(new Color(0, 64, 128));
        jrsTotLabel.setBounds(29, 330, 121, 18);
        ajouterPan.add(jrsTotLabel);
        
        JLabel jrsResLabel = new JLabel("Jours réstants :");
        jrsResLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jrsResLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        jrsResLabel.setBackground(new Color(0, 64, 128));
        jrsResLabel.setBounds(29, 370, 121, 18);
        ajouterPan.add(jrsResLabel);
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(new Color(0, 64, 128));
        formPanel.setBounds(0, 0, 858, 30);
        ajouterPan.add(formPanel);
        
        JLabel formLabel = new JLabel("Formulaire d'ajout");
        formLabel.setHorizontalAlignment(SwingConstants.CENTER);
        formLabel.setForeground(new Color(255, 128, 64));
        formLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        formLabel.setBounds(0, 0, 858, 30);
        formPanel.add(formLabel);
        
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setForeground(Color.WHITE);
        btnAnnuler.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        btnAnnuler.setBackground(new Color(0, 128, 255));
        btnAnnuler.setBounds(197, 418, 148, 30);
        ajouterPan.add(btnAnnuler);
        
        JLabel photoLabel = new JLabel("photo d'employe  :");
        photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        photoLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        photoLabel.setBackground(new Color(0, 64, 128));
        photoLabel.setBounds(419, 147, 121, 18);
        ajouterPan.add(photoLabel);
        
        JLabel photoProfil = new JLabel();
        photoProfil.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 128, 64), null, null, null));
        photoProfil.setBackground(new Color(0, 128, 255));
        photoProfil.setBounds(563, 57, 213, 192);
        ajouterPan.add(photoProfil);
        
        JButton btnImporter = new JButton("Importer l'image");
        btnImporter.setForeground(Color.WHITE);
        btnImporter.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        btnImporter.setBackground(new Color(255, 128, 64));
        btnImporter.setBounds(570, 270, 200, 30);
        btnImporter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			    JFileChooser file = new JFileChooser();
			    file.setCurrentDirectory(new File(System.getProperty("user.home")));

			    FileNameExtensionFilter filter = new FileNameExtensionFilter("jpeg","jpg","png");
			    file.addChoosableFileFilter(filter);
			    int res = file.showSaveDialog(null);
			    if(res == JFileChooser.APPROVE_OPTION){
			        File selFile = file.getSelectedFile();
			        path = selFile.getAbsolutePath();
			        photoProfil.setIcon(resize(path));
			        System.out.println(path);
			        
			}
        }
			private ImageIcon resize(String imgPath) {
			    ImageIcon path = new ImageIcon(imgPath);
			    Image img = path.getImage();
			    Image newImg = img.getScaledInstance(photoProfil.getWidth(), photoProfil.getHeight(), Image.SCALE_SMOOTH);
			    ImageIcon image = new ImageIcon(newImg);
			    return image;
			}
        });
        ajouterPan.add(btnImporter);
        
        cinTXT = new JTextField();
        cinTXT.setColumns(10);
        cinTXT.setBounds(139, 57, 258, 20);
        ajouterPan.add(cinTXT);
        
        JLabel cinLabel = new JLabel("CIN :");
        cinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cinLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        cinLabel.setBounds(20, 60, 121, 18);
        ajouterPan.add(cinLabel);
        
        return ajouterPan;
	}
	
	public JPanel modifierPanel() {
        JPanel ModifierPan = new JPanel();
        ModifierPan.setLayout(null);
        afficherAjouterModifierPanel.add(ModifierPan, "name_3189508645353700");
        
        nomTextM = new JTextField();
        nomTextM.setColumns(10);
        nomTextM.setBounds(119, 153, 258, 20);
        ModifierPan.add(nomTextM);
        
        prenomTextM = new JTextField();
        prenomTextM.setColumns(10);
        prenomTextM.setBounds(119, 193, 258, 20);
        ModifierPan.add(prenomTextM);
        
        adresseTextM = new JTextField();
        adresseTextM.setColumns(10);
        adresseTextM.setBounds(119, 232, 258, 20);
        ModifierPan.add(adresseTextM);
        
        naissanceTextM = new JTextField();
        naissanceTextM.setColumns(10);
        naissanceTextM.setBounds(119, 272, 258, 20);
        ModifierPan.add(naissanceTextM);
        
        JButton btnModifier = new JButton("Modifier");
        btnModifier.setForeground(Color.WHITE);
        btnModifier.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        btnModifier.setBackground(new Color(0, 128, 255));
        btnModifier.setBounds(160, 355, 148, 30);
        btnModifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("Modifier")) {
					
					if(cinTextM.getText().equals("") || nomTextM.getText().isEmpty() || prenomTextM.getText().isEmpty() || adresseTextM.getText().isEmpty() || telTextM.getText().isEmpty() || naissanceTextM.getText().isEmpty() || mailTextM.getText().isEmpty() || jrsTotTextM.getText().isEmpty() || jrsResTextM.getText().toString().isEmpty()){
						JOptionPane.showMessageDialog(null, "veuillez remplir tous les champs !!", "Info", JOptionPane.WARNING_MESSAGE);
					}else {
						
						employe = new Employee();
						employe.setCin_employe(cinTextM.getText());
						employe.setNom_employee(nomTextM.getText());
						employe.setPrenom_employee(prenomTextM.getText());
						employe.setAdresse_employee(adresseTextM.getText());
						employe.setNumero_telephone(telTextM.getText());
						employe.setDate_naissance(naissanceTextM.getText());
						employe.setNbre_restant(Integer.parseInt(jrsTotTextM.getText()));
						employe.setNbre_total(Integer.parseInt(jrsResTextM.getText()));
						employe.setEmail_employee(mailTextM.getText());
						
						try {
							employe.modifierEmploye(employe);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

						}
					}
					
				}
			}
        	
        });
        ModifierPan.add(btnModifier);
        
        telTextM = new JTextField();
        telTextM.setColumns(10);
        telTextM.setBounds(534, 152, 258, 20);
        ModifierPan.add(telTextM);
        
        mailTextM = new JTextField();
        mailTextM.setColumns(10);
        mailTextM.setBounds(534, 192, 258, 20);
        ModifierPan.add(mailTextM);
        
        jrsTotTextM = new JTextField();
        jrsTotTextM.setColumns(10);
        jrsTotTextM.setBounds(534, 231, 258, 20);
        ModifierPan.add(jrsTotTextM);
        
        jrsResTextM = new JTextField();
        jrsResTextM.setColumns(10);
        jrsResTextM.setBounds(534, 271, 258, 20);
        ModifierPan.add(jrsResTextM);
        
        JLabel nomLabelM = new JLabel("Nom :");
        nomLabelM.setHorizontalAlignment(SwingConstants.CENTER);
        nomLabelM.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        nomLabelM.setBounds(0, 156, 121, 18);
        ModifierPan.add(nomLabelM);
        
        JLabel prenomLabelM = new JLabel("Prénom :");
        prenomLabelM.setHorizontalAlignment(SwingConstants.CENTER);
        prenomLabelM.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        prenomLabelM.setBackground(new Color(0, 64, 128));
        prenomLabelM.setBounds(0, 196, 121, 18);
        ModifierPan.add(prenomLabelM);
        
        JLabel adresseLabelM = new JLabel("Adresse :");
        adresseLabelM.setHorizontalAlignment(SwingConstants.CENTER);
        adresseLabelM.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        adresseLabelM.setBackground(new Color(0, 64, 128));
        adresseLabelM.setBounds(0, 235, 121, 18);
        ModifierPan.add(adresseLabelM);
        
        JLabel naissanceLabelM = new JLabel("Date Naissance :");
        naissanceLabelM.setHorizontalAlignment(SwingConstants.CENTER);
        naissanceLabelM.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        naissanceLabelM.setBackground(new Color(0, 64, 128));
        naissanceLabelM.setBounds(0, 275, 121, 18);
        ModifierPan.add(naissanceLabelM);
        
        JLabel telLabelM = new JLabel("N° Tel  :");
        telLabelM.setHorizontalAlignment(SwingConstants.CENTER);
        telLabelM.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        telLabelM.setBackground(new Color(0, 64, 128));
        telLabelM.setBounds(413, 155, 121, 18);
        ModifierPan.add(telLabelM);
        
        JLabel mailLabelM = new JLabel("Email :");
        mailLabelM.setHorizontalAlignment(SwingConstants.CENTER);
        mailLabelM.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        mailLabelM.setBackground(new Color(0, 64, 128));
        mailLabelM.setBounds(413, 195, 121, 18);
        ModifierPan.add(mailLabelM);
        
        JLabel jrsTotLabelM = new JLabel("Jours Totals :");
        jrsTotLabelM.setHorizontalAlignment(SwingConstants.CENTER);
        jrsTotLabelM.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        jrsTotLabelM.setBackground(new Color(0, 64, 128));
        jrsTotLabelM.setBounds(413, 234, 121, 18);
        ModifierPan.add(jrsTotLabelM);
        
        JLabel jrsResLabelM = new JLabel("Jours réstants :");
        jrsResLabelM.setHorizontalAlignment(SwingConstants.CENTER);
        jrsResLabelM.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        jrsResLabelM.setBackground(new Color(0, 64, 128));
        jrsResLabelM.setBounds(413, 274, 121, 18);
        ModifierPan.add(jrsResLabelM);
        
        JPanel formulairTitrePanel = new JPanel();
        formulairTitrePanel.setLayout(null);
        formulairTitrePanel.setBackground(new Color(0, 64, 128));
        formulairTitrePanel.setBounds(0, 0, 858, 30);
        ModifierPan.add(formulairTitrePanel);
        
        JLabel titreLabel = new JLabel("Formulaire de modification");
        titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titreLabel.setForeground(new Color(255, 128, 64));
        titreLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        titreLabel.setBounds(0, 0, 858, 30);
        formulairTitrePanel.add(titreLabel);
        
        JButton btnVider = new JButton("Vider");
        btnVider.setForeground(Color.WHITE);
        btnVider.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        btnVider.setBackground(new Color(0, 128, 255));
        btnVider.setBounds(328, 355, 148, 30);
        btnVider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("Vider")) {
					nomTextM.setText(""); prenomTextM.setText(""); adresseTextM.setText(""); 
					naissanceTextM.setText(""); telTextM.setText(""); mailTextM.setText(""); jrsTotTextM.setText(""); jrsResTextM.setText(""); cinTextM.setText("");
				}
			}
        	
        });
        ModifierPan.add(btnVider);
        
        cinTextM = new JTextField();
        cinTextM.setColumns(10);
        cinTextM.setBounds(246, 76, 258, 20);
        ModifierPan.add(cinTextM);
        
        JLabel cinLabel = new JLabel("cin d'employe :");
        cinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cinLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        cinLabel.setBounds(93, 75, 133, 18);
        ModifierPan.add(cinLabel);
        
        JButton btnRechercher = new JButton("Rechercher");
        btnRechercher.setForeground(Color.WHITE);
        btnRechercher.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        btnRechercher.setBackground(new Color(0, 128, 255));
        btnRechercher.setBounds(522, 72, 148, 30);
        btnRechercher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cinTextM.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "veuillez entrer le code national d'identité !!", "Info", JOptionPane.WARNING_MESSAGE);

				}else {
					try {
						Employee em = new Employee();
						ResultSet res= em.rechercherEmploye(cinTextM.getText());
						nomTextM.setText(res.getString("nom"));
						prenomTextM.setText(res.getString("prenom"));
						adresseTextM.setText(res.getString("adresse"));
						naissanceTextM.setText(res.getString("date_naiss"));
						telTextM.setText(res.getString("telephone"));
						mailTextM.setText(res.getString("email"));
						jrsTotTextM.setText(res.getString("nbre_conges_totals"));
						jrsResTextM.setText(res.getString("nbre_conges_restants"));
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						
						JOptionPane.showMessageDialog(null, "cette cin n'exeste pas  !!", "Info", JOptionPane.WARNING_MESSAGE);

					}
				}
				
			}
        	
        });
        ModifierPan.add(btnRechercher);
        
        
        //buttoun pour la suppression des emloyes.
        
        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setForeground(Color.WHITE);
        btnSupprimer.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
        btnSupprimer.setBackground(new Color(0, 128, 255));
        btnSupprimer.setBounds(496, 355, 148, 30);
        btnSupprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("Supprimer")) {
					Employee employe = new Employee();
					employe.supprimerEmploye(cinTextM.getText());
				}
			}
        	
        });
        ModifierPan.add(btnSupprimer);
        return ModifierPan;
	}
	
	//fonction de changement des panel ajouterPanel, afficherPanel et modifierPanel
	
	public void changerPanels(JPanel panel) {
		afficherAjouterModifierPanel.removeAll();
		afficherAjouterModifierPanel.add(panel);
		afficherAjouterModifierPanel.repaint();
		afficherAjouterModifierPanel.revalidate();
	}
}
