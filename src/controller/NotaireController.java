package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class NotaireController implements Initializable {

	

	@FXML
    private JFXButton confirmer;

    @FXML
    private JFXPasswordField notaire;

    @FXML
    private JFXButton annuler;

    @FXML
    void annulerAction(ActionEvent event) throws IOException {
    	annuler.getScene().getWindow().hide();               
    	Stage stage= new Stage();
    	FXMLLoader loader= new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/AccueilView.fxml"));
    	Parent main=loader.load();//CONTENAIRE MERE polymorphisme de Anshorpane
    	Scene scene= new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    }
	    @FXML
	    void confirmerAction(ActionEvent event) {
	    	try {
	    	if(notaire.getText().equals("JEAN1")) {
	    		confirmer.getScene().getWindow().hide();               
		    	Stage stage= new Stage();
		    	FXMLLoader loader= new FXMLLoader();
		    	loader.setLocation(getClass().getResource("/view/AcceuilView1.fxml"));
		    	Parent main=loader.load();//CONTENAIRE MERE polymorphisme de Anshorpane
		    	Scene scene= new Scene(main);
		    	stage.setScene(scene);
		    	stage.show();
		    	 
		    	}else {
		    	Alert alert= new Alert(AlertType.ERROR);//la boite de dialogue ;ALERT 
		    	alert.setTitle("Alert");
		    	alert.setHeaderText("Erreur");
		    	alert.setContentText("mot de pass ou login incorrect");
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
