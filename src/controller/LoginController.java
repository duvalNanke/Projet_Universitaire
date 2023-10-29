package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



import connexion.Connectiondb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	
	  @FXML
	    private TextField noml;

	    @FXML
	    private PasswordField mdpl;

	    @FXML
	    private PasswordField inil;

	    @FXML
	    private Button connect;

	  
	    @FXML
	    void connecter(ActionEvent event) throws SQLException {
	    	Connectiondb con= new Connectiondb();
	    	Connection conn=con.connect();
	    	PreparedStatement stat=null;
	    	ResultSet rs=null;
	    	String sql="SELECT * FROM collaborateur WHERE nom= ? AND password= ? AND initial= ? ";
	    	try {
	    	stat=conn.prepareStatement(sql);
	    	stat.setString(1, noml.getText().toString());
	    	stat.setString(2, mdpl.getText().toString());
	    	stat.setString(3, inil.getText().toString());
	    	rs=stat.executeQuery();
	    	if(rs.next()) {
	    	connect.getScene().getWindow().hide();            
	    	Stage stage= new Stage();
	    	FXMLLoader loader= new FXMLLoader();
	    	loader.setLocation(getClass().getResource("/view/AccueilView.fxml"));
	    	Parent main=loader.load();//CONTENAIRE MERE polymorphisme de Anshorpane
	    	Scene scene= new Scene(main);
	    	stage.setScene(scene);
	    	stage.show();
	    	 
	   	 
	    	}else {
	    	Alert alert= new Alert(AlertType.ERROR);//la boite de dialogue ;ALERT 
	    	alert.setTitle("Alert");
	    	alert.setHeaderText("Erreur");
	    	alert.setContentText("Nom,mot de passe ou initial incorrect");
	    	alert.showAndWait();
	    	}
	    	}catch (Exception e) {
	    	// TODO: handle exception
	    	} 

	    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
