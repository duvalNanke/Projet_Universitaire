package connexion;

import java.sql.Connection;
import java.sql.SQLException;



public abstract class ParametreConnexion {
	
	protected final String url ="jdbc:mysql://localhost:3306/cabinet de notaire";
	protected final String user = "root";
	protected final String password ="";
	public abstract Connection connect() throws SQLException;
	public String getUrl() {
	return url;
	}
	public String getUser() {
	return user;
	}
	public String getPassword() {
	return password;
	}

}
