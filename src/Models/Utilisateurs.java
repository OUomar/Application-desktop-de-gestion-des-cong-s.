package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base_de_données.BdConfigurations;

public class Utilisateurs {

		private int id_user;
		private String nom_utilisateur;
		private String password;
		private BdConfigurations bdc;
		
		
		
		public int getId_user() {
			return id_user;
		}
		public void setId_user(int id_user) {
			this.id_user = id_user;
		}
		public String getNom_utilisateur() {
			return nom_utilisateur;
		}
		public void setNom_utilisateur(String nom_utilisateur) {
			this.nom_utilisateur = nom_utilisateur;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public ResultSet remplirChamps(String user_name) throws SQLException, Exception {

			Statement stm = null;
	    	bdc = new BdConfigurations();
			 stm = bdc.getConnexion().createStatement();

			 String requete = "SELECT * FROM utilisateurs WHERE nom_utilisateur = '"+user_name+"'";
			 ResultSet res = stm.executeQuery(requete);
			 
			 if (res.next()) {
				 return res;
			 }else {
					JOptionPane.showMessageDialog(null, "il n'exist aucun employe avec le nom d'utilisateur entré, Merci de ressayer avec un autre valide!!", "Info", JOptionPane.WARNING_MESSAGE);
			 }
			return null;
		}
		
		
		public void modifierInformations(Utilisateurs user) {
			try {
		    	//la requete
					   int val=JOptionPane.showConfirmDialog(null, "Voulez Vous vraiment modifier ces informations !!", "Modifier",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE );
			 if(val == 0) {
				 String requete = "UPDATE  utilisateurs SET nom_utilisateur=?,password=?";
			    	// prepared statement
			    	  PreparedStatement preparedstm;
			    	  bdc = new BdConfigurations();
						preparedstm = bdc.getConnexion().prepareStatement(requete);
						    preparedstm.setString(1,user.nom_utilisateur);
						    preparedstm.setString(2,user.password);
						    
						    
						    preparedstm.executeUpdate();
						    JOptionPane.showMessageDialog(null, "les modification sont faites avec succés", "Info", JOptionPane.INFORMATION_MESSAGE);
			 }
		    	
			

				} catch (Exception e) {
					// TODO Auto-generated catch block
				    JOptionPane.showMessageDialog(null, e.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

				}
			
			
		}
}
		    	
		

//