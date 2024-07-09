package Models;

import java.sql.ResultSet;
import java.sql.Statement;

import base_de_données.BdConfigurations;

public class Statistiques {
 
	private BdConfigurations bdc;
	
	public int numberTotalDesEmploye() throws Exception {
		Statement stm = null;
    	bdc = new BdConfigurations();
		 stm = bdc.getConnexion().createStatement();

		 String requete = "SELECT COUNT(*) FROM conges";
		 ResultSet res = stm.executeQuery(requete);
		if(res.next()) {
			return Integer.parseInt(res.getString(1));
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		Statistiques stats = new Statistiques();
		try {
			System.out.println(stats.numberTotalDesEmploye());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
