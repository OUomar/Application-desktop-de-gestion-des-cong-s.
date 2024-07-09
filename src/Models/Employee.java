package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import base_de_données.BdConfigurations;

public class Employee {
	private int id_employee;
	private String cin_employe;
	private String nom_employee;
	private String prenom_employee;
	private String adresse_employee;
	private String date_naissance;
	private String numero_telephone;
	private String email_employee;
	private int nbre_total;
	private int nbre_restant;
	private String Path;
	BdConfigurations bdc = new BdConfigurations();
	private DefaultTableModel model;
	private JTable tableau;

	public static void main(String[] args) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		
			System.out.println(e.afficher());
		
		//

	}

	public int getId_employee() {
		return id_employee;
	}

	public void setId_employee(int id_employee) {
		this.id_employee = id_employee;
	}
	
	public String getCin_employe() {
		return cin_employe;
	}

	public void setCin_employe(String cin_employe) {
		this.cin_employe = cin_employe;
	}

	public String getNom_employee() {
		return nom_employee;
	}

	public void setNom_employee(String nom_employee) {
		this.nom_employee = nom_employee;
	}

	public String getPrenom_employee() {
		return prenom_employee;
	}

	public void setPrenom_employee(String prenom_employee) {
		this.prenom_employee = prenom_employee;
	}

	public String getAdresse_employee() {
		return adresse_employee;
	}

	public void setAdresse_employee(String adresse_employee) {
		this.adresse_employee = adresse_employee;
	}

	public String getNumero_telephone() {
		return numero_telephone;
	}

	public void setNumero_telephone(String numero_telephone) {
		this.numero_telephone = numero_telephone;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getEmail_employee() {
		return email_employee;
	}

	public void setEmail_employee(String email_employee) {
		this.email_employee = email_employee;
	}

	
	
	public int getNbre_total() {
		return this.nbre_total;
	}
	public void setNbre_total(int nbre_total) {
		this.nbre_total = nbre_total;
	}
	
	public int getNbre_restant() {
		return nbre_restant;
	}
	public void setNbre_restant(int nbre_restant) {
	 this.nbre_restant = nbre_restant;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		 this.Path = path;
	}
	
	public JTable afficher() throws SQLException, Exception {
		
		 String query = "SELECT * FROM employes";
	     
	       Statement stm = bdc.getConnexion().createStatement();
	       ResultSet res = stm.executeQuery(query);
	       String entete[] = { "cin", "nom", "prenom","adresse","date naissance", "telephone","email", "nombre total", "nombre restants" };
	       model= new DefaultTableModel(entete,0);
			while(res.next()){
				
				//{"ID","Nom"," Pr�nom", "DATENAISSANCE", "ADRESSE"};
				String table[]= {res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9)};
				model.addRow(table);
			}
		
		tableau = new JTable(model);	
		return tableau;
	}
	
    public void ajouterEmploye(Employee employe) throws SQLException, Exception {
    		     
		      
		     Statement stm = null;
	
			 stm = bdc.getConnexion().createStatement();
	
			 String requete = "SELECT * FROM employes WHERE cin_employe = '"+employe.getCin_employe()+"'";
			 ResultSet res = stm.executeQuery(requete);
			 /*if(res.next()) {
				 System.out.println("L'employes exist deja dans la base de données");
			 }else {
				 String requete2 = "INSERT INTO employes VALUES(null,'PA15452','uhffrf','omar','efefef','1998-10-20','062154878','yak.ihya@gmail.com','30','30')";
				stm.executeUpdate(requete2);
			 }*/
			 
			 
			 if(res.next()) {
					JOptionPane.showMessageDialog(null, "ce code d'identité national est déjà associé a un autre employe, merci d'entrer un CIN valide !!", "Info", JOptionPane.WARNING_MESSAGE);
			 }else {
				   int val=JOptionPane.showConfirmDialog(null, "Voulez Vous vraiment ajouter ce client !!", "Ajouter",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE );
				   if(val==0) {
						 String requete2 = "INSERT INTO employes VALUES('"+employe.cin_employe+"','"+employe.nom_employee+"','"+employe.prenom_employee+"','"+employe.adresse_employee+"','"+employe.date_naissance+"','"+employe.numero_telephone+"','"+employe.email_employee+"','"+employe.nbre_total+"','"+employe.nbre_restant+"','"+employe.Path+"')";
							
						    stm.executeUpdate(requete2);
						    JOptionPane.showMessageDialog(null, "le client est ajouté avec succ�s !!", "Info", JOptionPane.INFORMATION_MESSAGE);
			
				   }
			 }
			 
		  	
	
    	}
    //fonction pour la modification des informations des employes 
    public void modifierEmploye(Employee employe) {
    	
    	
	 try {
    	//la requete
	 int val=JOptionPane.showConfirmDialog(null, "Voulez Vous vraiment modifier ce client !!", "Ajouter",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE );
	 if(val == 0) {
		 String requete = "UPDATE  employes SET nom=?,prenom=?,adresse=?, date_naiss=?, telephone=?, email=?, nbre_conges_totals=?, nbre_conges_restants=? where cin_employe=?";
	    	// prepared statement
	    	  PreparedStatement preparedstm;
				preparedstm = bdc.getConnexion().prepareStatement(requete);
				    preparedstm.setString(1,employe.nom_employee);
				    preparedstm.setString(2,employe.prenom_employee);
				    preparedstm.setString(3,employe.adresse_employee);
				    preparedstm.setString(4, employe.date_naissance);
				    preparedstm.setString(5,employe.numero_telephone);
				    preparedstm.setString(6,employe.email_employee);
				    preparedstm.setInt(7,employe.nbre_total);
				    preparedstm.setInt(8,employe.nbre_restant);
				    preparedstm.setString(9,employe.cin_employe);
				    
				    preparedstm.executeUpdate();
				    JOptionPane.showMessageDialog(null, "l'employe est modifié avec succés", "Info", JOptionPane.INFORMATION_MESSAGE);
	 }
    	
	

		} catch (Exception e) {
			// TODO Auto-generated catch block
		    JOptionPane.showMessageDialog(null, e.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

		}
		
			 
			
		}
    
    // fonction pour la recherche d'un employe en utilisant son cin 
    public ResultSet rechercherEmploye(String cin) throws SQLException, Exception {
    	
    	Statement stm = null;
    	
		 stm = bdc.getConnexion().createStatement();

		 String requete = "SELECT * FROM employes WHERE cin_employe = '"+cin+"'";
		 ResultSet res = stm.executeQuery(requete);
		 
		 if (res.next()) {
			 return res;
		 }else {
				JOptionPane.showMessageDialog(null, "il n'exist aucun employe avec le cin entré, Merci de ressayer avec un autre cin valide!!", "Info", JOptionPane.WARNING_MESSAGE);
		 }
		return null;
		 
		
		 
    }
    // fonction pour la suppression d'un employe dans la base de données
    public void supprimerEmploye(String cin) {
     int val=JOptionPane.showConfirmDialog(null, "Voulez Vous vraiment modifier ce client !!", "Ajouter",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE );
   	 if(val == 0) {
   		try {
			
   			
   	    	//la requete
   	    	String query = "DELETE FROM employes WHERE cin_employe='"+cin+"'";
   	    	//statement
   	    	  Statement stm;
   				stm = bdc.getConnexion().createStatement();
   				 stm.executeUpdate(query);
   				 JOptionPane.showMessageDialog(null," le client est supprim� avec succ�s", "Info", JOptionPane.INFORMATION_MESSAGE);
   				 
   			
   		

   			} catch (Exception e) {
   				// TODO Auto-generated catch block
   			    JOptionPane.showMessageDialog(null, e.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

   			}
   	 }
    
    }


}
