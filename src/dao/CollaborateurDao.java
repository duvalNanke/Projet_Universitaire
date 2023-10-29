package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connexion.Connectiondb;
import model.Collaborateur;


public class CollaborateurDao {

	public static Collaborateur rechercheColDAO(String id) {
	    Collaborateur ets = new  Collaborateur();
		try {
		String sql ="SELECT * FROM collaborateur WHERE initial=?"; 
		Connectiondb con= new Connectiondb();
		Connection conn=con.connect();
		PreparedStatement stat;
		stat = conn.prepareStatement(sql);
		stat.setString(1, id);
		ResultSet rs=stat.executeQuery();
		if(rs.next()) {
		ets.setInitiale(rs.getString(3));
		ets.setNom(rs.getString(1));
		ets.setAdresse(rs.getString(9));
		ets.setSexe(rs.getString(7));
		ets.setDatenaissance(rs.getString(6));
		ets.setStatut(rs.getString(4));
		ets.setProfession(rs.getString(10));
		ets.setNumeroscni(rs.getString(8));
		ets.setTelephone(rs.getInt(5));
		ets.setPassword(rs.getString(2));
		conn.close();
		}
		}catch (SQLException e2) {
		// TODO: handle exception
		e2.printStackTrace(); 
		}
		return ets;

}
}

