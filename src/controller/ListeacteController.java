package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import connexion.Connectiondb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import model.GestionActes;

public class ListeacteController implements Initializable {
	
	@FXML
    private JFXButton addact;

    @FXML
    void addacte(ActionEvent event) throws IOException {
    	
    	addact.getScene().getWindow().hide();               
    	Stage stage= new Stage();
    	FXMLLoader loader= new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/ActesView.fxml"));
    	Parent main=loader.load();//CONTENAIRE MERE polymorphisme de Anshorpane
    	Scene scene= new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    }
    @FXML
    private TableView<GestionActes> tab;

    @FXML
    private TableColumn<GestionActes, Integer> tabid;

    @FXML
    private TableColumn<GestionActes, String> tabnature;

    @FXML
    private TableColumn<GestionActes, String> tabobjet;

    @FXML
    private TableColumn<GestionActes, String> tabnomv;

    @FXML
    private TableColumn<GestionActes, String> tabadrv;

    @FXML
    private TableColumn<GestionActes, String> tabcniv;

    @FXML
    private TableColumn<GestionActes, String> tabtelv;

    @FXML
    private TableColumn<GestionActes, String> tabnoma;

    @FXML
    private TableColumn<GestionActes, String> tabadra;

    @FXML
    private TableColumn<GestionActes, String> tabcnia;

    @FXML
    private TableColumn<GestionActes, String> tabtela;

    @FXML
    private TableColumn<GestionActes, String> tabfait;

    @FXML
    private TableColumn<GestionActes, String> tabdate;

    @FXML
    private TableColumn<GestionActes, String> tablieu;
	
    ObservableList<GestionActes> listet = FXCollections.observableArrayList();
	ObservableList<String> ob = FXCollections.observableArrayList();

    
    public void showlisteacte() {

		try {
			Connectiondb con = new Connectiondb();
			Connection conn = con.connect();
			tab.getItems().clear();
			String sql = "SELECT * FROM actes";
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				listet.add(new GestionActes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		tabid.setCellValueFactory(new PropertyValueFactory<GestionActes, Integer>("id"));
		// tett.setCellFactory(TextFieldTableCell.<Fournisseur>forTableColumn());
		tabnature.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("nature"));
		tabnature.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabnature.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNature(t.getNewValue());
		});

		tabobjet.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("objet"));
		tabobjet.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabobjet.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setObjet(t.getNewValue());
		});
		tabnomv.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("nomv"));
		tabnomv.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabnomv.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNomv(t.getNewValue());
		});
		tabadrv.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("adressev"));
		tabadrv.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabadrv.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdressev(t.getNewValue());
		});
		tabcniv.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("cniv"));
		tabcniv.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabcniv.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCniv(t.getNewValue());
		});
		tabtelv.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("telv"));
		tabtelv.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabtelv.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTelv(t.getNewValue());
		});
		tabnoma.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("noma"));
		tabnoma.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabnoma.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNoma(t.getNewValue());
		});
		tabadra.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("adressea"));
		tabadra.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabadra.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdressea(t.getNewValue());
		});
		tabcnia.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("cnia"));
		tabcnia.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabcnia.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCnia(t.getNewValue());
		});
		tabtela.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("tela"));
		tabtela.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabtela.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTela(t.getNewValue());
		});
		tabfait.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("faitpar"));
		tabfait.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabfait.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFaitpar(t.getNewValue());
		});
		
		tabdate.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("date"));
		tabdate.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabdate.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDate(t.getNewValue());
		});
		tablieu.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("lieu"));
		tablieu.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tablieu.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLieu(t.getNewValue());
		});
		tab.setItems(listet);
    }

    @FXML
    private JFXTextField rechercheract;

    @FXML
    private JFXButton rechact;

   
    @FXML
    void rechercheracte(ActionEvent event) {
    	 tab.getItems().clear();	
    	 String recher = rechercheract.getText().toString();
    	
 try {
 String sql ="SELECT * FROM actes WHERE nomacheteur=?"; 
	Connectiondb con= new Connectiondb();
	Connection conn=con.connect();
	PreparedStatement stat;
	stat = conn.prepareStatement(sql);
	stat.setString(1, recher);
	ResultSet rs=stat.executeQuery();
	if(rs.next()) {
		
		tabid.setCellValueFactory(new PropertyValueFactory<GestionActes, Integer>("id"));
		// tett.setCellFactory(TextFieldTableCell.<Fournisseur>forTableColumn());
		tabnature.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("nature"));
		tabnature.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabnature.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNature(t.getNewValue());
		});

		tabobjet.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("objet"));
		tabobjet.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabobjet.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setObjet(t.getNewValue());
		});
		tabnomv.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("nomv"));
		tabnomv.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabnomv.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNomv(t.getNewValue());
		});
		tabadrv.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("adressev"));
		tabadrv.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabadrv.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdressev(t.getNewValue());
		});
		tabcniv.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("cniv"));
		tabcniv.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabcniv.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCniv(t.getNewValue());
		});
		tabtelv.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("telv"));
		tabtelv.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabtelv.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTelv(t.getNewValue());
		});
		tabnoma.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("noma"));
		tabnoma.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabnoma.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNoma(t.getNewValue());
		});
		tabadra.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("adressea"));
		tabadra.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabadra.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdressea(t.getNewValue());
		});
		tabcnia.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("cnia"));
		tabcnia.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabcnia.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCnia(t.getNewValue());
		});
		tabtela.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("tela"));
		tabtela.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabtela.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTela(t.getNewValue());
		});
		tabfait.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("faitpar"));
		tabfait.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabfait.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFaitpar(t.getNewValue());
		});
		
		tabdate.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("date"));
		tabdate.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tabdate.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDate(t.getNewValue());
		});
		tablieu.setCellValueFactory(new PropertyValueFactory<GestionActes, String>("lieu"));
		tablieu.setCellFactory(TextFieldTableCell.<GestionActes>forTableColumn());
		tablieu.setOnEditCommit((CellEditEvent<GestionActes, String> t) -> {
			((GestionActes) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLieu(t.getNewValue());
		});
		tab.setItems(listet);
	}else {
		showlisteacte();
	}
 }catch (SQLException e2) {
		// TODO: handle exception
		e2.printStackTrace(); 
		}
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		showlisteacte();
	}

}
