package gestion_des_conges;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Models.Conges;

public class gestionCongesFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionCongesFrame frame = new gestionCongesFrame();
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
	public gestionCongesFrame() {
		gcfPanel();
	}
	
	public JPanel gcfPanel() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Gestion des Congés");
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
        JLabel trier = new JLabel("Trier par :");
        trier.setForeground(new Color(255, 255, 255));
        trier.setHorizontalAlignment(SwingConstants.CENTER);
        trier.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        trier.setBounds(40,10,112,44);
        trier.setBackground(new Color(79, 83, 78));
        panel_3.add(trier);
        ButtonGroup groupeTriage = new ButtonGroup();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(159, 10, 512, 44);
		panel_3.add(panel);
		panel.setLayout(null);
		//checkbox num
		JRadioButton numB = new JRadioButton("num");
		numB.setBackground(new Color(255, 255, 255));
		numB.setHorizontalAlignment(SwingConstants.CENTER);
		numB.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		numB.setBounds(34, 0, 99, 44);
		panel.add(numB);
		groupeTriage.add(numB);
		//checkbox nom
		JRadioButton nomB = new JRadioButton("date");
		nomB.setBackground(new Color(255, 255, 255));
		nomB.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		nomB.setHorizontalAlignment(SwingConstants.CENTER);
		nomB.setBounds(198, 0, 99, 44);
		panel.add(nomB);
		groupeTriage.add(nomB);
		
		//checkbox dateNaissance
		JRadioButton dateNaissB= new JRadioButton("Emloyee");
		dateNaissB.setBackground(new Color(255, 255, 255));
		dateNaissB.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		dateNaissB.setHorizontalAlignment(SwingConstants.CENTER);
		dateNaissB.setBounds(338, 0, 168, 44);
		panel.add(dateNaissB);
		groupeTriage.add(dateNaissB);
		JButton refreshButton = new JButton("Actualiser");
		refreshButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		refreshButton.setBackground(new Color(0, 128, 0));
		refreshButton.setForeground(new Color(255, 255, 255));
		refreshButton.setBounds(713, 14, 112, 37);
		refreshButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("Actualiser")) {
					Conges con = new Conges();
					
					try {
						 JScrollPane jsc;
						 jsc = new JScrollPane(con.afficherConges());
						 jsc.setBounds(10, 64, 858, 398);
					     panel_3.add(jsc);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		panel_3.add(refreshButton);

        /////////////////////////////////////////////////
		Conges con = new Conges();
		
		try {
			 JScrollPane jsc;
			 jsc = new JScrollPane(con.afficherConges());
			 jsc.setBounds(10, 64, 858, 398);
		     panel_3.add(jsc);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

       
        
        JButton addButton = new JButton("Ajouter");
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        addButton.setBackground(new Color(0, 128, 255));
        addButton.setBounds(10, 472, 112, 37);
        
        addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (e.getActionCommand().equals("Ajouter")){
					try {
						AjouterCongés frame = new AjouterCongés();
						frame.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
		        }
				
			}
			
		});
        panel_3.add(addButton);
        
        JButton btnModifier = new JButton("Modifier");
        btnModifier.setForeground(Color.WHITE);
        btnModifier.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        btnModifier.setBackground(new Color(128, 128, 0));
        btnModifier.setBounds(159, 472, 112, 37);
        btnModifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getActionCommand().equals("Modifier")){
					try {
						ModifierCongés frame = new ModifierCongés();
						frame.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
		        }
			}
        	
        });
        panel_3.add(btnModifier);
        return contentPane;
	}

}
