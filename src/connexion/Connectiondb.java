package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;



public class Connectiondb extends ParametreConnexion {

	@Override
	public Connection connect() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword());
			return con;
			}catch (ClassNotFoundException | SQLException e) {
			Logger.getLogger(Connectiondb.class.getName()).log(Level.SEVERE,null, e);
			e.printStackTrace();
			}
			return null;
			}
	
	}



