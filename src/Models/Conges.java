package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import base_de_données.BdConfigurations;

public class Conges {
	
	private int id_conge;
	private String type_conge;
	private String motif;
	private int nbre_jrs;
	private String date_debut;
	private String date_fin;
	private String cin_employe;
	private String annee;
	private BdConfigurations bdc = new BdConfigurations();
	private DefaultTableModel model;
	private JTable tableau;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conges conge  = new Conges();
		conge.setType_conge("pro");
		conge.setMotif("hgh");
		conge.setNbre_jrs(1);
		conge.setDate_debut("2023-01-25");
		conge.setDate_fin("2023-12-20");
		conge.setCin_employe("PA166062");
		conge.annee= "2023";
	
		
		try {
			System.out.println(conge.calculerNombreCongesParAnnee(conge));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public int getId_conge() {
		return id_conge;
	}


	public void setId_conge(int id_conge) {
		this.id_conge = id_conge;
	}


	public String getType_conge() {
		return type_conge;
	}


	public void setType_conge(String type_conge) {
		this.type_conge = type_conge;
	}


	public String getMotif() {
		return motif;
	}


	public void setMotif(String motif) {
		this.motif = motif;
	}


	public String getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}


	public String getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}


	public String getCin_employe() {
		return cin_employe;
	}
	public void setCin_employe(String cin_employe) {
		this.cin_employe = cin_employe;
	}
	
	public int getNbre_jrs() {
		return nbre_jrs;
	}
	public void setNbre_jrs(int nbre_jrs) {
		this.nbre_jrs =  nbre_jrs;
	}
	
	public String getAnnee() {
		return this.annee;
	}
	public void setAnnee(String annee) {
		this.annee= annee;
	}
	
	
	public JTable afficherConges() throws SQLException, Exception {
		  String query = "SELECT * FROM conges";
	    
	      Statement stm = bdc.getConnexion().createStatement();
	      ResultSet res = stm.executeQuery(query);
	       String entete[] = { "id conges","type conges", "motif","nombre de jours", "date debut","date fin","cin demandeur", "annee"};
	       model= new DefaultTableModel(entete,0);
			while(res.next()){
				
				//{"ID","Nom"," Pr�nom", "DATENAISSANCE", "ADRESSE"};
				String table[]= {res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7), res.getString(8)};
				model.addRow(table);
			}
		
		tableau = new JTable(model);	
		return tableau;
	}
	
	
	public void ajouterConge(Conges conge) throws Exception {
	  if(calculerNombreCongesParAnnee(conge) < 5 ) {
		  
			  Statement stm = null;
			  	
				 stm = bdc.getConnexion().createStatement();

				 String requete = "SELECT * FROM conges WHERE id_conge = '"+conge.id_conge+"'";
				 ResultSet res = stm.executeQuery(requete);
				//decrementer le nombre des conge restants.
				 decrementerJrsRes(conge.cin_employe);
				 /*if(res.next()) {
					 System.out.println("L'employes exist deja dans la base de données");
				 }else {
					 String requete2 = "INSERT INTO employes VALUES(null,'PA15452','uhffrf','omar','efefef','1998-10-20','062154878','yak.ihya@gmail.com','30','30')";
					stm.executeUpdate(requete2);
				 }*/
				 
				 
				 if(res.next()) {
						JOptionPane.showMessageDialog(null, "ce code est déjà associé a un autre congés, merci d'entrer un CIN valide !!", "Info", JOptionPane.WARNING_MESSAGE);
				 }else {
					   int val=JOptionPane.showConfirmDialog(null, "Voulez Vous vraiment ajouter ce congés !!", "Ajouter",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE );
					   if(val==0) {
						   String year = conge.date_debut.split("-")[0];
							 String requete2 = "INSERT INTO conges VALUES(0,'"+conge.type_conge+"','"+conge.motif+"','"+conge.nbre_jrs+"','"+conge.date_debut+"','"+conge.date_fin+"','"+conge.cin_employe+"','"+conge.annee+"')";
							    stm.executeUpdate(requete2);
							    JOptionPane.showMessageDialog(null, "le congés est ajouté avec succ�s !!", "Info", JOptionPane.INFORMATION_MESSAGE);
				
					   }
				 }
	
		}else {
			JOptionPane.showMessageDialog(null, "impossible d'ajouter un conge pour cet employe, le nobmre total des conges pour cette employe et fini pour l'année encours !!", "Info", JOptionPane.WARNING_MESSAGE);
		}
	  }
		
		
	   
		 
	
	
	public ResultSet rechercherCongés(String cin) throws Exception {
		Statement stm = null;
 
		 stm = bdc.getConnexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				    ResultSet.CONCUR_READ_ONLY);

		 String requete = "SELECT * FROM conges WHERE cin_employe = '"+cin+"'";
		 ResultSet res = stm.executeQuery(requete);
		 
		 while (res.next()) {
			 return res;
		 }
		return null;
	}
	
	public void decrementerJrsRes(String cin_employe) throws Exception {
		Employee em = new Employee();
		ResultSet res = em.rechercherEmploye(cin_employe);
		int nbreRestants = res.getInt("nbre_conges_restants");
		int nbreRestantsModifie = nbreRestants-1;
		
		 String requete = "UPDATE  employes SET  nbre_conges_restants=? where cin_employe=?";
	    	// prepared statement
	    	  PreparedStatement preparedstm;
				preparedstm = bdc.getConnexion().prepareStatement(requete);
				    preparedstm.setInt(1,nbreRestantsModifie);
				    preparedstm.setString(2,cin_employe);
				    preparedstm.executeUpdate();
		
	}
	
	public void modifierConge(Conges conge) {
		 try {
		    	//la requete
			 int val=JOptionPane.showConfirmDialog(null, "Voulez Vous vraiment modifier ce client !!", "Modifier",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE );
			 if(val == 0) {
				 String requete = "UPDATE conges SET type_conge=?,motif=?,nbre_jrs=?, date_debut=?, date_fin=?, annee=? WHERE cin_employe=?";
			    	// prepared statement
			    	  PreparedStatement preparedstm;
	
						preparedstm = bdc.getConnexion().prepareStatement(requete);
						    preparedstm.setString(1,conge.type_conge);
						    preparedstm.setString(2,conge.motif);
						    preparedstm.setInt(3,conge.nbre_jrs);
						    preparedstm.setString(4, conge.date_debut);
						    preparedstm.setString(5,conge.date_fin);
						   			
						    preparedstm.setString(6, conge.annee);
						    preparedstm.setString(7,conge.cin_employe);
				
						    preparedstm.executeUpdate();
						    JOptionPane.showMessageDialog(null, "l'employe est modifié avec succés", "Info", JOptionPane.INFORMATION_MESSAGE);
			 }
		    	
			

				} catch (Exception e) {
					// TODO Auto-generated catch block
				    JOptionPane.showMessageDialog(null, e.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

				}
	}
	
	public void supprimerConge(String cin_employe, int id) {
	     int val=JOptionPane.showConfirmDialog(null, "Voulez Vous vraiment modifier ce congés !!", "Supprimer",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE );
	   	 if(val == 0) {
	   		try {
				
	   			
	   	    	//la requete
	   	    	String query = "DELETE FROM conges WHERE cin_employe='"+cin_employe+"' AND id_conge = '"+id+"' ";
	   	    	//statement
	   	    	  Statement stm;
	   				stm = bdc.getConnexion().createStatement();
	   				 stm.executeUpdate(query);
	   				 JOptionPane.showMessageDialog(null," le congés est supprimé avec succés", "Info", JOptionPane.INFORMATION_MESSAGE);
	   				 
	   			
	   		

	   			} catch (Exception e) {
	   				// TODO Auto-generated catch block
	   			    JOptionPane.showMessageDialog(null, e.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

	   			}
	   	 }
	}
	
	public void supprimerConge(String cin_employe) {
		int val=JOptionPane.showConfirmDialog(null, "Voulez Vous vraiment modifier ce congés !!", "Supprimer",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE );
	   	 if(val == 0) {
	   		try {
				
	   			
	   	    	//la requete
	   	    	String query = "DELETE FROM conges WHERE cin_employe='"+cin_employe+"'";
	   	    	//statement
	   	    	  Statement stm;
	   				stm = bdc.getConnexion().createStatement();
	   				 stm.executeUpdate(query);
	   				 JOptionPane.showMessageDialog(null," le congés est supprimé avec succés", "Info", JOptionPane.INFORMATION_MESSAGE);
	   				 
	   			
	   		

	   			} catch (Exception e) {
	   				// TODO Auto-generated catch block
	   			    JOptionPane.showMessageDialog(null, e.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);

	   			}
	   	 }
	}
	
	/*public boolean testerPossibiliteConge(String cin_employe) throws SQLException, Exception {
		Employee em = new Employee();
		
		int nbre_restants = em.rechercherEmploye(cin_employe).getInt("nbre_conges_restants");
		if(nbre_restants == 0) {
		    return false;
		}
		return true;
	}*/
	
	public int calculerNombreCongesParAnnee(Conges conge) throws SQLException, Exception {
		Statement stm = null;

		 stm = bdc.getConnexion().createStatement();

		 String requete = "SELECT COUNT(*) FROM conges WHERE cin_employe = '"+conge.cin_employe+"' AND annee = '"+conge.annee+"' ";
		 ResultSet res = stm.executeQuery(requete);
		if(res.next()) {
			return Integer.parseInt(res.getString(1));
		}
		return 0;
	}
}
