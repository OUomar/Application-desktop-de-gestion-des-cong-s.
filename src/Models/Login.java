package Models;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import gestion_des_conges.HomePageFrame;


public class Login implements ActionListener{
    JFrame fenetre;
    JLabel userName;
    JTextField userNameTxt;
    JLabel password;
    JPasswordField passwordTxt;
    JButton connexion;
    JLabel login;
    String[] tab;
    public Login() {
        this.session();
    }
    public JFrame session() {
        fenetre= new JFrame();
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setTitle("La page de connexion");
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setBounds(0, 0, 500, 500);
        ///////////////////////////////////////////
        JPanel jp2= new JPanel();
        jp2.setLayout(null);
        jp2.setSize(500, 500);
        jp2.setBackground(new Color(255, 255, 255));


        ///////////////////////////////////////////////

        JPanel jp = new JPanel();
        jp.setLayout(null);
        jp.setBackground(new Color(255, 255, 255));
        jp.setBounds(0, 0, 500, 500);



        //////////////////////////
        ImageIcon img = new ImageIcon("F://ffff.png");
        JLabel photo = new JLabel(img);

        photo.setBounds(0, 60,500, 100);

        ////////////////////

        login = new JLabel("CONNEXION : ");
        login.setBounds(0,0,500,80);
        login.setFont(new Font("Monaco", Font.BOLD, 20));
        login.setForeground( Color.white);
        login.setBackground(new Color(198, 74, 7));


        login.setOpaque(true);
        login.setHorizontalAlignment(JLabel.CENTER);
        ////////////////////////////////
        userName= new JLabel("Nom d'utilisateur  : ");

        userName.setFont(new Font("sans-serif", Font.BOLD, 15));
        userName.setHorizontalAlignment(JLabel.CENTER);
        userName.setForeground(Color.black);

        userName.setBounds(160,150, 150, 30);
        userNameTxt= new JTextField();
        Border bd4 = BorderFactory.createLineBorder(new Color(186, 76, 76), 3);
        userNameTxt.setBorder(bd4);
        userNameTxt.setBounds(90, 190, 300, 30);
        //////////////////////////////////////////////////
        password= new JLabel("Mot de passe  : ");

        password.setFont(new Font("sans-serif", Font.BOLD, 15));
        password.setHorizontalAlignment(JLabel.CENTER);
        password.setForeground(Color.black);
        password.setBounds(160,240, 150, 30);
        passwordTxt= new JPasswordField();
        Border bd3 = BorderFactory.createLineBorder(new Color(186, 76, 76), 3);
        passwordTxt.setBorder(bd3);
        passwordTxt.setBounds(90, 280, 300, 30);

        //////////////////////////////////////////////////////
        connexion= new JButton("Connexion");
        connexion.setBounds(140,350, 200, 40);
        connexion.setForeground( Color.white);
        connexion.setBackground(new Color(53, 128, 48));
        connexion.setHorizontalAlignment(JButton.CENTER);
        connexion.addActionListener(this);

        ///////////////////////////////////////////////////////

        jp.add(login);jp.add(photo);
        jp.add(userName);jp.add(userNameTxt);
        jp.add(password);jp.add(passwordTxt);
        jp.add(connexion);
        ////////////////////////////////////////////////////////
        jp2.add(jp,BorderLayout.CENTER);
        fenetre.add(jp2);
        fenetre.setSize(500, 500);
        fenetre.setLayout(null);
        fenetre.setVisible(true);
        ///////////////////////////////////////////
        return fenetre;
    }

    @Override


	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Connexion")) {
			if(userNameTxt.getText().isEmpty() || passwordTxt.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "veuillez remplir tous les champs !!", "Info", JOptionPane.WARNING_MESSAGE);
			}else {
				try {
					authentifier();
				}catch(Exception exc) {
					exc.printStackTrace();
				}
			}
             
		
            
		}



	}




    public void authentifier() throws IOException{
    	
    	///////////////////////////////////////// LOGIN AVEC FICHIER ///////////////////////////////////////////////
		    	/* Le chemin vers le fichier � lire */
		    	
		    	
		    	/*String ligneLue;
		
		    	BufferedReader fluxEntree=null;
		    	
		    	try {
		    		// Cr�ation du flux vers le fichier texte 
		    		fluxEntree = new BufferedReader(new FileReader("F://authentification.txt"));
		              
		    		// Lecture d'une ligne 
		    		ligneLue = fluxEntree.readLine();
		    		while(ligneLue!=null){
		    			
		    			 tab=ligneLue.split("&");
		    		
		    			
		    			ligneLue = fluxEntree.readLine();		
		    		}
		    	
		    		if(userNameTxt.getText().equals(tab[0]) && passwordTxt.getText().equals(tab[1])) {
						 new PageAccueil();
				          fenetre.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "le nom d'utilisateur ou le mot de passe est incorrect !!", "Info", JOptionPane.WARNING_MESSAGE);
					}
		    	}
		    	catch(IOException exc){
		    		System.out.println(exc.getMessage());
		    	}finally {
		    		if(fluxEntree!=null) {
		    					fluxEntree.close();
		
		    		}
		    	}*/
    	

         ///////////////////////////LOGIN AVEC BD ///////////////////////////////////////////////
         try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 String url = "jdbc:mysql://localhost:3306/projet_java";
		     String user= "root";
		     String pass = "";
	         try {
	        	 Connection con = DriverManager.getConnection(url, user, pass);
				  
				     
			       Statement stm = con.createStatement();
			       String query = "SELECT * FROM utilisateurs WHERE password = '"+passwordTxt.getText()+"'";
			       ResultSet res = stm.executeQuery(query);
			
			     if(res.next()) {
			 		EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								HomePageFrame frame = new HomePageFrame();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
			    	 fenetre.dispose();
			     }
			     else {
						JOptionPane.showMessageDialog(null, "le nom d'utilisateur ou le mot de passe est incorrect !!", "Info", JOptionPane.WARNING_MESSAGE);
					}
			       
			       
			       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
     
    	
    	
    	
    	
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         new Login();
        

    }
}
