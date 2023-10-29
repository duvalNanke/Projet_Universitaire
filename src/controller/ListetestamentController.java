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
import model.GestionTestament;

public class ListetestamentController implements Initializable {
	
	@FXML
    private JFXButton addtest;

    @FXML
    void addtestament(ActionEvent event) throws IOException {
    	addtest.getScene().getWindow().hide();               
    	Stage stage= new Stage();
    	FXMLLoader loader= new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/TestamentView.fxml"));
    	Parent main=loader.load();//CONTENAIRE MERE polymorphisme de Anshorpane
    	Scene scene= new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    }
	   @FXML
	    private TableView<GestionTestament> tab;

	    @FXML
	    private TableColumn<GestionTestament, Integer> tabid;

	    @FXML
	    private TableColumn<GestionTestament, String> tabtype;

	    @FXML
	    private TableColumn<GestionTestament, String> tablegs;

	    @FXML
	    private TableColumn<GestionTestament, String> tabnoml;

	    @FXML
	    private TableColumn<GestionTestament, String> tabadrl;

	    @FXML
	    private TableColumn<GestionTestament, String> tabcnil;

	    @FXML
	    private TableColumn<GestionTestament, String> tabtell;

	    @FXML
	    private TableColumn<GestionTestament, String> tabnomb;

	    @FXML
	    private TableColumn<GestionTestament, String> tabadrb;

	    @FXML
	    private TableColumn<GestionTestament, String> tabcnib;

	    @FXML
	    private TableColumn<GestionTestament, String> tabtelb;

	    @FXML
	    private TableColumn<GestionTestament, String> tabcate;

	    @FXML
	    private TableColumn<GestionTestament, String> tabcon;

	    @FXML
	    private TableColumn<GestionTestament, String> tabfait;

	    @FXML
	    private TableColumn<GestionTestament, String> tabdate;

	    @FXML
	    private TableColumn<GestionTestament, String> tablieu;
	    
	    
	    ObservableList<GestionTestament> listet = FXCollections.observableArrayList();
		ObservableList<String> ob = FXCollections.observableArrayList();

	    
	    public void showlisteacte() {

			try {
				Connectiondb con = new Connectiondb();
				Connection conn = con.connect();
				tab.getItems().clear();
				String sql = "SELECT * FROM testament";
				PreparedStatement stat = conn.prepareStatement(sql);
				ResultSet rs = stat.executeQuery();
				while (rs.next()) {
					listet.add(new GestionTestament(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
				}
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
			tabid.setCellValueFactory(new PropertyValueFactory<GestionTestament, Integer>("id"));
			// tett.setCellFactory(TextFieldTableCell.<Fournisseur>forTableColumn());
			tabtype.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("type"));
			tabtype.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabtype.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setType(t.getNewValue());
			});

			tablegs.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("legs"));
			tablegs.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tablegs.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLegs(t.getNewValue());
			});
			tabnoml.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("noml"));
			tabnoml.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabnoml.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNoml(t.getNewValue());
			});
			tabadrl.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("adressel"));
			tabadrl.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabadrl.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdressel(t.getNewValue());
			});
			tabcnil.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("cnil"));
			tabcnil.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabcnil.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCnil(t.getNewValue());
			});
			tabtell.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("tell"));
			tabtell.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabtell.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTelb(t.getNewValue());
			});
			tabnomb.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("nomb"));
			tabnomb.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabnomb.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNomb(t.getNewValue());
			});
			tabadrb.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("adresseb"));
			tabadrb.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabadrb.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdresseb(t.getNewValue());
			});
			tabcnib.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("cnib"));
			tabcnib.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabcnib.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCnib(t.getNewValue());
			});
			tabtelb.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("telb"));
			tabtelb.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabtelb.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTelb(t.getNewValue());
			});
			tabcate.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("categorie"));
			tabcate.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabcate.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTelb(t.getNewValue());
			});
			tabcon.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("conditions"));
			tabcon.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabcon.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTelb(t.getNewValue());
			});
			tabfait.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("faitpar"));
			tabfait.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabfait.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFaitpar(t.getNewValue());
			});
			
			tabdate.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("date"));
			tabdate.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tabdate.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDate(t.getNewValue());
			});
			tablieu.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("lieu"));
			tablieu.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
			tablieu.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
				((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLieu(t.getNewValue());
			});
			tab.setItems(listet);
	    }

	    @FXML
	    private JFXTextField recherchertes;

	    @FXML
	    private JFXButton rechtest;

	  

	    @FXML
	    void recherchertestament(ActionEvent event) {
	   	 tab.getItems().clear();	
    	 String recher = recherchertes.getText().toString();
    	
 try {
 String sql ="SELECT * FROM testament WHERE nomlegeur=?"; 
	Connectiondb con= new Connectiondb();
	Connection conn=con.connect();
	PreparedStatement stat;
	stat = conn.prepareStatement(sql);
	stat.setString(1, recher);
	ResultSet rs=stat.executeQuery();
	if(rs.next()) {
		tabid.setCellValueFactory(new PropertyValueFactory<GestionTestament, Integer>("id"));
		// tett.setCellFactory(TextFieldTableCell.<Fournisseur>forTableColumn());
		tabtype.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("type"));
		tabtype.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabtype.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setType(t.getNewValue());
		});

		tablegs.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("legs"));
		tablegs.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tablegs.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLegs(t.getNewValue());
		});
		tabnoml.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("noml"));
		tabnoml.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabnoml.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNoml(t.getNewValue());
		});
		tabadrl.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("adressel"));
		tabadrl.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabadrl.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdressel(t.getNewValue());
		});
		tabcnil.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("cnil"));
		tabcnil.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabcnil.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCnil(t.getNewValue());
		});
		tabtell.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("tell"));
		tabtell.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabtell.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTelb(t.getNewValue());
		});
		tabnomb.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("nomb"));
		tabnomb.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabnomb.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNomb(t.getNewValue());
		});
		tabadrb.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("adresseb"));
		tabadrb.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabadrb.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdresseb(t.getNewValue());
		});
		tabcnib.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("cnib"));
		tabcnib.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabcnib.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCnib(t.getNewValue());
		});
		tabtelb.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("telb"));
		tabtelb.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabtelb.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTelb(t.getNewValue());
		});
		tabcate.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("categorie"));
		tabcate.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabcate.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTelb(t.getNewValue());
		});
		tabcon.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("conditions"));
		tabcon.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabcon.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTelb(t.getNewValue());
		});
		tabfait.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("faitpar"));
		tabfait.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabfait.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFaitpar(t.getNewValue());
		});
		
		tabdate.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("date"));
		tabdate.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tabdate.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDate(t.getNewValue());
		});
		tablieu.setCellValueFactory(new PropertyValueFactory<GestionTestament, String>("lieu"));
		tablieu.setCellFactory(TextFieldTableCell.<GestionTestament>forTableColumn());
		tablieu.setOnEditCommit((CellEditEvent<GestionTestament, String> t) -> {
			((GestionTestament) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLieu(t.getNewValue());
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
