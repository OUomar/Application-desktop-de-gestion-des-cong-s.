package base_de_données;
import java.sql.Connection;
import java.sql.DriverManager;

public class BdConfigurations {
	
	
    public  Connection getConnexion() throws Exception {
        
    	Connection con= null;


            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/projet_java";
        
            con = DriverManager.getConnection(url, "root", "");
        

        return con;
    }
}
