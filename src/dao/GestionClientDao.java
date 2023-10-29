package dao;



import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import connexion.Connectiondb;
import model.GestionClient;

public class GestionClientDao {
	public static int enregistrer(GestionClient cl) {
		int et=0;
		try {
		String sql ="INSERT INTO usager (id, nom,adresse,sexe,datenaissance,statut,profession,numeroscni,telephone,naturepb,documentfourni) VALUES ( ?, ?,?,?,?,?,?,?,?,?,?) ";
		Connectiondb con= new Connectiondb();
		Connection conn=con.connect();
		PreparedStatement stat;
		stat = conn.prepareStatement(sql);
		stat.setInt(1, cl.getId());
		stat.setString(2, cl.getNom());
		stat.setString(3, cl.getAdresse());
		stat.setString(4, cl.getSexe());
		stat.setString(5, cl.getDatenaissance());
		stat.setString(6, cl.getStatut());
		stat.setString(7, cl.getProfession());
		stat.setString(8, cl.getNumeroscni());
		stat.setLong(9, cl.getTelephone());
		stat.setString(10, cl.getNaturepb());
		stat.setString(11, cl.getDocument());
		et =stat.executeUpdate();
		conn.close();
		}catch (Exception e1) {
		// TODO: handle exception
			e1.printStackTrace();
		}
		return et;
		}
		public static int updateenter(GestionClient cl) {
		int et1=0;
		try {
		String sql ="UPDATE usager SET nom=?,adresse=?,sexe=?,datenaissance=?,statut=?,profession=?,numeroscni=? ,telephone=?, naturepb=?,documentfourni=?  WHERE id=?";
		Connectiondb con= new Connectiondb();
		Connection conn=con.connect();
		PreparedStatement stat;
		stat = conn.prepareStatement(sql);
		stat.setLong(1, cl.getId());
		stat.setString(2, cl.getNom());
		stat.setString(3, cl.getAdresse());
		stat.setString(4, cl.getSexe());
		stat.setString(5, cl.getDatenaissance());
		stat.setString(6, cl.getStatut());
		stat.setString(7, cl.getProfession());
		stat.setString(8, cl.getNumeroscni());
		stat.setLong(9, cl.getTelephone());
		stat.setString(10, cl.getNaturepb());
		stat.setString(11, cl.getDocument());
		et1 =stat.executeUpdate();
		conn.close();
		}catch (SQLException e2) {
		// TODO: handle exception
		e2.printStackTrace();
		}
		return et1;
		}
		public static int deleteenter(String ide) {
		int et1=0;
		try {
		String sql ="DELETE FROM usager WHERE id=?";
		Connectiondb con= new Connectiondb();
		Connection conn=con.connect();
		PreparedStatement stat;
		stat = conn.prepareStatement(sql);
		stat.setString(1, ide);
		et1 =stat.executeUpdate();
		conn.close();
		}catch (SQLException e2) {
		// TODO: handle exception
		e2.printStackTrace();
		}
		return et1;
		}
		public static GestionClient rechercheDAO(String id) {
	    GestionClient ets = new GestionClient();
		try {
		String sql ="SELECT * FROM usager WHERE id=?"; 
		Connectiondb con= new Connectiondb();
		Connection conn=con.connect();
		PreparedStatement stat;
		stat = conn.prepareStatement(sql);
		stat.setString(1, id);
		ResultSet rs=stat.executeQuery();
		if(rs.next()) {
		ets.setId(rs.getInt(1));
		ets.setNom(rs.getString(2));
		ets.setAdresse(rs.getString(3));
		ets.setSexe(rs.getString(4));
		ets.setDatenaissance(rs.getString(5));
		ets.setStatut(rs.getString(6));
		ets.setProfession(rs.getString(7));
		ets.setNumeroscni(rs.getString(8));
		ets.setTelephone(rs.getInt(9));
		ets.setNaturepb(rs.getString(10));
		ets.setDocument(rs.getString(11));
		ets.setDatedepot(rs.getString(12));
		}
		conn.close();
		}catch (SQLException e2) {
		// TODO: handle exception
		e2.printStackTrace(); 
		}
		return ets;

}
}
