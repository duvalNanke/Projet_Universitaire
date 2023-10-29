package controller;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Collaborateur;
import javafx.stage.Stage;

public class AcceuilController1 implements Initializable {
      
	
	@FXML
    private JFXButton usa;

    @FXML
    private JFXButton docc;

    @FXML
    private JFXTextField recherchercol;

    @FXML
    private TableView<Collaborateur> tabcol;

    @FXML
    private TableColumn<Collaborateur, String> nomtab;

    @FXML
    private TableColumn<Collaborateur, String> mdptab;

    @FXML
    private TableColumn<Collaborateur, String> initab;

    @FXML
    private TableColumn<Collaborateur, String> statuttab;

    @FXML
    private TableColumn<Collaborateur, String> sexetab;

    @FXML
    private TableColumn<Collaborateur, String> professiontab;

    @FXML
    private TableColumn<Collaborateur, String> adressetab;

    @FXML
    private TableColumn<Collaborateur, String> datetab;

    @FXML
    private TableColumn<Collaborateur, String> cnitab;

    @FXML
    private TableColumn<Collaborateur, Integer> teltab;

    @FXML
    private JFXTextField nomcol;

    @FXML
    private JFXTextField inicol;

    @FXML
    private JFXTextField datecol;

    @FXML
    private JFXTextField cnicol;

    @FXML
    private JFXTextField statutcol;

    @FXML
    private JFXComboBox<String> sexecol;
    private FileInputStream fs;

    @FXML
    private JFXTextField mdpcol;

    @FXML
    private JFXTextField adressecol;

    @FXML
    private JFXTextField procol;

    @FXML
    private Label selection;

    @FXML
    private ImageView photo;

    @FXML
    private JFXTextField telcol;

    ObservableList<Collaborateur>listet=FXCollections.observableArrayList();
    @FXML
    void ajoutercol(ActionEvent event) throws SQLException {
    	afficher();
    	String initialeok = inicol.getText();
    	String nomok = nomcol.getText();
    	String adresp = adressecol.getText();
    	String statp = statutcol.getText();
    	String cnip = cnicol.getText();
    	String telp = telcol.getText();
    	int telok = Integer.parseInt(telp);
    	String pbp = mdpcol.getText();
    	String datep = datecol.getText();
    	String sexep = sexecol.getValue();
    	String metierp = procol.getText();
    	File image = new File(selection.getText());
    	
    	Collaborateur cl = new Collaborateur();
    	cl.setNom(nomok);
    	cl.setInitiale(initialeok);
    	cl.setAdresse(adresp);
    	cl.setTelephone(telok);
    	cl.setDatenaissance(datep);
    	cl.setStatut(statp);
    	cl.setSexe(sexep);
    	cl.setProfession(metierp);
    	cl.setNumeroscni(cnip);
    	cl.setPassword(pbp);
    	
		String sql = "INSERT INTO collaborateur (nom, password,initial,statut, telephone,datenaissance, sexe,numeroscni,adresse, profession, image) VALUES (?, ?, ?,?,?,?,?,?,?,?, ?) ";

		try {

			Connectiondb con = new Connectiondb();
			Connection conn = con.connect();
			PreparedStatement stat;
			stat = conn.prepareStatement(sql);
			stat.setString(3, initialeok);
			stat.setString(1, nomok);
			stat.setString(2, pbp);
			stat.setString(6, datep);
			stat.setString(9, adresp);
			stat.setString(4, statp);
			stat.setString(7, sexep);
			stat.setString(8, cnip);
			stat.setInt(5, telok);
			stat.setString(10, metierp);
			fs = new FileInputStream(image);
			stat.setBinaryStream(11, fs, image.length());
			stat.executeUpdate();
			//urlco.setText("aucun selectionner");
			inicol.clear();
	    	nomcol.clear();
	    	adressecol.clear();
	    	statutcol.clear();
	    	cnicol.clear();
	    	telcol.clear();
	    	mdpcol.clear();
	    	datecol.clear();
	    	sexecol.setValue(null);
	    	procol.clear();
	    	photo.setImage(null);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Enregistrement");
			alert.setContentText("collaborateur ajouté");
			alert.showAndWait();

		} catch (Exception e1) {
System.out.println("l erreur est:"+ e1.getMessage());
			e1.printStackTrace();
		}

    }

    @FXML
    void collaboratorAdd(ActionEvent event) throws SQLException {
    	
   	 tabcol.getItems().clear();	
   	

    	try {
    	String sql = "select * from collaborateur where initial=? ";

		
			Connectiondb con = new Connectiondb();
			Connection conn = con.connect();
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1,  recherchercol.getText());
			//stat.setString(1, cnico.getText());
			ResultSet rs = stat.executeQuery();
			byte byteimage[];
			Blob blob;
			if (rs.next()) {
				inicol.setText(rs.getString("initial"));
				nomcol.setText(rs.getString("nom"));
				mdpcol.setText(rs.getString("password"));
				datecol.setText(rs.getString("datenaissance"));
				adressecol.setText(rs.getString("adresse"));
				statutcol.setText(rs.getString("statut"));
				sexecol.setValue(rs.getString("sexe"));
				cnicol.setText(rs.getString("numeroscni"));
				int t = rs.getInt("telephone");
				telcol.setText(String.valueOf(t));
				procol.setText(rs.getString("profession"));
				blob = rs.getBlob("image");
				byteimage = blob.getBytes(1, (int) blob.length());
				Image img = new Image(new ByteArrayInputStream(byteimage), photo.getFitWidth(),
						photo.getFitHeight(), true, true);
				photo.setImage(img);
		
			    listet.add(new Collaborateur(rs.getString(1), rs.getString(3),rs.getString(9),rs.getString(7),rs.getString(6),rs.getString(4),rs.getString(10),rs.getString(8),rs.getInt(5),rs.getString(2) ));
			    initab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("initiale"));
		    	initab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
		    	initab.setOnEditCommit((CellEditEvent<Collaborateur, String> n) -> {
					((Collaborateur) n.getTableView().getItems().get(n.getTablePosition().getRow()))
							.setInitiale(n.getNewValue());
				});
				nomtab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("nom"));
				nomtab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
				nomtab.setOnEditCommit((CellEditEvent<Collaborateur, String> n) -> {
					((Collaborateur) n.getTableView().getItems().get(n.getTablePosition().getRow())).setNom(n.getNewValue());
				});

				mdptab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("password"));
				mdptab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
				mdptab.setOnEditCommit((CellEditEvent<Collaborateur, String> n) -> {
					((Collaborateur) n.getTableView().getItems().get(n.getTablePosition().getRow())).setSexe(n.getNewValue());
				});
				datetab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("datenaissance"));
				datetab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
				datetab.setOnEditCommit((CellEditEvent<Collaborateur, String> n) -> {
					((Collaborateur) n.getTableView().getItems().get(n.getTablePosition().getRow())).setDatenaissance(n.getNewValue());
				});
				adressetab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("adresse"));
				adressetab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
				adressetab.setOnEditCommit((CellEditEvent<Collaborateur, String> n) -> {
					((Collaborateur) n.getTableView().getItems().get(n.getTablePosition().getRow())).setAdresse(n.getNewValue());
				});
				statuttab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("statut"));
				statuttab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
				statuttab.setOnEditCommit((CellEditEvent<Collaborateur, String> n) -> {
					((Collaborateur) n.getTableView().getItems().get(n.getTablePosition().getRow())).setStatut(n.getNewValue());
				});
				sexetab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("sexe"));
				sexetab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
				sexetab.setOnEditCommit((CellEditEvent<Collaborateur, String> n) -> {
					((Collaborateur) n.getTableView().getItems().get(n.getTablePosition().getRow())).setSexe(n.getNewValue());
				});
				cnitab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("numeroscni"));
				cnitab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
				cnitab.setOnEditCommit((CellEditEvent<Collaborateur, String> n) -> {
					((Collaborateur) n.getTableView().getItems().get(n.getTablePosition().getRow())).setNumeroscni(n.getNewValue());
				});
				teltab.setCellValueFactory(new PropertyValueFactory<Collaborateur, Integer>("telephone"));
				// tett.setCellFactory(TextFieldTableCell.<Fournisseur>forTableColumn());
				professiontab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("profession"));
				professiontab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
				professiontab.setOnEditCommit((CellEditEvent<Collaborateur, String>n) -> {
					((Collaborateur) n.getTableView().getItems().get(n.getTablePosition().getRow())).setProfession(n.getNewValue());
				});	
			    tabcol.setItems(listet);
			}else {
				afficher();
			}
		
		} catch (Exception e) {
			e.printStackTrace();

		}


    }

    @FXML
    void modifiercol(ActionEvent event) throws SQLException {
    	afficher();
    	String initialeok = inicol.getText();
    	String nomok = nomcol.getText();
    	String adresp = adressecol.getText();
    	String statp = statutcol.getText();
    	String cnip = cnicol.getText();
    	String telp = telcol.getText();
    	int telok = Integer.parseInt(telp);
    	String pbp = mdpcol.getText();
    	String datep = datecol.getText();
    	String sexep = sexecol.getValue();
    	String metierp = procol.getText();
    	File image = new File(selection.getText());
    	Collaborateur cl = new Collaborateur();
    	cl.setNom(nomok);
    	cl.setInitiale(initialeok);
    	cl.setAdresse(adresp);
    	cl.setTelephone(telok);
    	cl.setDatenaissance(datep);
    	cl.setStatut(statp);
    	cl.setSexe(sexep);
    	cl.setProfession(metierp);
    	cl.setNumeroscni(cnip);
    	cl.setPassword(pbp);
    	
		String sql = "UPDATE collaborateur SET nom=?, password=?,statut=?, telephone=?,datenaissance=?, sexe=?,numeroscni=?,adresse=?, profession=?,image=? WHERE initial=? ";

		try {

			Connectiondb con = new Connectiondb();
			Connection conn = con.connect();
			PreparedStatement stat;
			stat = conn.prepareStatement(sql);
			stat.setString(11, initialeok);
			stat.setString(1, nomok);
			stat.setString(2, pbp);
			stat.setString(5, datep);
			stat.setString(8, adresp);
			stat.setString(3, statp);
			stat.setString(6, sexep);
			stat.setString(7, cnip);
			stat.setInt(4, telok);
			stat.setString(9, metierp);
			fs = new FileInputStream(image);
			stat.setBinaryStream(10, fs, image.length());
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
			//urlco.setText("aucun selectionner");
			inicol.clear();
	    	nomcol.clear();
	    	adressecol.clear();
	    	statutcol.clear();
	    	cnicol.clear();
	    	telcol.clear();
	    	mdpcol.clear();
	    	datecol.clear();
	    	sexecol.setValue(null);
	    	procol.clear();
	    	photo.setImage(null);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Enregistrement");
			alert.setContentText("collaborateur modifier");
			alert.showAndWait();

			}
			} catch (Exception e1) {
System.out.println("l erreur est:"+ e1.getMessage());
			e1.printStackTrace();
		}

    }
    

    @FXML
    void sexecol(MouseEvent event) throws IOException{
    	sexecol.getSelectionModel().getSelectedItem().toString();
    }

    @FXML
    void telecharger() {
FileChooser fo= new FileChooser();
fo.getExtensionFilters().add(new ExtensionFilter("Image Files",".png",".jpg"));
File f= fo.showOpenDialog(null);
if(f != null) {
	selection.setText(f.getAbsolutePath());
	Image image = new Image(f.toURI().toString(),photo.getFitWidth(),photo.getFitHeight(),true,true);
	photo.setImage(image);
}
    }

    
    
    public void afficher() {
    	try {
			Connectiondb con = new Connectiondb();
			Connection conn = con.connect();
			tabcol.getItems().clear();
			String sql = "SELECT * FROM collaborateur";
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				listet.add(new Collaborateur(rs.getString(3), rs.getString(1), rs.getString(9), rs.getString(7),
						rs.getString(6), rs.getString(4), rs.getString(10), rs.getString(8), rs.getInt(5),
						rs.getString(2)));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
    	initab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("initiale"));
    	initab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
    	initab.setOnEditCommit((CellEditEvent<Collaborateur, String> t) -> {
			((Collaborateur) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setInitiale(t.getNewValue());
		});
		nomtab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("nom"));
		nomtab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
		nomtab.setOnEditCommit((CellEditEvent<Collaborateur, String> t) -> {
			((Collaborateur) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNom(t.getNewValue());
		});

		mdptab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("password"));
		mdptab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
		mdptab.setOnEditCommit((CellEditEvent<Collaborateur, String> t) -> {
			((Collaborateur) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSexe(t.getNewValue());
		});
		datetab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("datenaissance"));
		datetab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
		datetab.setOnEditCommit((CellEditEvent<Collaborateur, String> t) -> {
			((Collaborateur) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDatenaissance(t.getNewValue());
		});
		adressetab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("adresse"));
		adressetab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
		adressetab.setOnEditCommit((CellEditEvent<Collaborateur, String> t) -> {
			((Collaborateur) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdresse(t.getNewValue());
		});
		statuttab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("statut"));
		statuttab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
		statuttab.setOnEditCommit((CellEditEvent<Collaborateur, String> t) -> {
			((Collaborateur) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStatut(t.getNewValue());
		});
		sexetab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("sexe"));
		sexetab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
		sexetab.setOnEditCommit((CellEditEvent<Collaborateur, String> t) -> {
			((Collaborateur) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSexe(t.getNewValue());
		});
		cnitab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("numeroscni"));
		cnitab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
		cnitab.setOnEditCommit((CellEditEvent<Collaborateur, String> t) -> {
			((Collaborateur) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNumeroscni(t.getNewValue());
		});
		teltab.setCellValueFactory(new PropertyValueFactory<Collaborateur, Integer>("telephone"));
		// tett.setCellFactory(TextFieldTableCell.<Fournisseur>forTableColumn());
		professiontab.setCellValueFactory(new PropertyValueFactory<Collaborateur, String>("profession"));
		professiontab.setCellFactory(TextFieldTableCell.<Collaborateur>forTableColumn());
		professiontab.setOnEditCommit((CellEditEvent<Collaborateur, String> t) -> {
			((Collaborateur) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProfession(t.getNewValue());
		});
		tabcol.setItems(listet);

	}

    
   
    @FXML
    void DocumentAction(ActionEvent event) throws IOException {
    	Stage stage= new Stage();
    	FXMLLoader loader= new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/DocumentChoiseView.fxml"));
    	Parent main=loader.load();//CONTENAIRE MERE polymorphisme de Anshorpane
    	Scene scene= new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    }
 
  
	    @FXML
	    void usagerAction(ActionEvent event) throws IOException {
	    	usa.getScene().getWindow().hide();
	    	Stage stage= new Stage();
	    	FXMLLoader loader= new FXMLLoader();
	    	loader.setLocation(getClass().getResource("/view/AccueilView.fxml"));
	    	Parent main=loader.load();//CONTENAIRE MERE polymorphisme de Anshorpane
	    	Scene scene= new Scene(main);
	    	stage.setScene(scene);
	    	stage.show();
	    }
	    @FXML
	    void actualise(ActionEvent event) {
afficher();  }
	    
	    @FXML
	    void tableclick(MouseEvent event) throws SQLException {
			//Selection en fonction de l indexe cliquer
			int index = tabcol.getSelectionModel().getSelectedIndex();
			
			Connectiondb con = new Connectiondb();
			Connection conn = con.connect();
			String idok=initab.getCellData(index).toString();
			tabcol.getItems().clear();
			String sql = "SELECT * FROM collaborateur Where initial=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1,  idok);
			ResultSet rs = stat.executeQuery();
			byte byteimage[];
			Blob blob;
			  
			  while(rs.next()) {
				  inicol.setText(rs.getString("initial"));
					nomcol.setText(rs.getString("nom"));
					mdpcol.setText(rs.getString("password"));
					datecol.setText(rs.getString("datenaissance"));
					adressecol.setText(rs.getString("adresse"));
					statutcol.setText(rs.getString("statut"));
					sexecol.setValue(rs.getString("sexe"));
					cnicol.setText(rs.getString("numeroscni"));
					int t = rs.getInt("telephone");
					telcol.setText(String.valueOf(t));
					procol.setText(rs.getString("profession"));
					blob = rs.getBlob("image");
					byteimage = blob.getBytes(1, (int) blob.length());
					Image img = new Image(new ByteArrayInputStream(byteimage), photo.getFitWidth(),
							photo.getFitHeight(), true, true);
					photo.setImage(img);
					afficher();     
	    }


	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		afficher();
		ObservableList<String> list = FXCollections.observableArrayList("Masculin", "feminin");
		sexecol.setItems(list);
	}
}
	
   
