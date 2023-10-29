package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DocumentChoiseController implements Initializable {

	@FXML
    private Button actes;

    @FXML
    private Button testament;

    @FXML
    void actesAction(ActionEvent event) throws IOException {

    	Stage stage= new Stage();
    	FXMLLoader loader= new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/ListeacteView.fxml"));
    	Parent main=loader.load();//CONTENAIRE MERE polymorphisme de Anshorpane
    	Scene scene= new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void testamentAction(ActionEvent event) throws IOException {
    	
    	Stage stage= new Stage();
    	FXMLLoader loader= new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/ListetestamentView.fxml"));
    	Parent main=loader.load();//CONTENAIRE MERE polymorphisme de Anshorpane
    	Scene scene= new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
