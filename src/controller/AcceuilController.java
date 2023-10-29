package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import connexion.Connectiondb;
//import dao.GestionClientDao;
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
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.GestionClient;
public class AcceuilController implements Initializable {

	@FXML
    private JFXButton col;

    @FXML
    private JFXButton doc;

    @FXML
    private JFXTextField rechercherusa;

    @FXML
    private TableView<GestionClient> tabu;

    @FXML
    private TableColumn<GestionClient, Integer> idu;

    @FXML
    private TableColumn<GestionClient, String> nomu;

    @FXML
    private TableColumn<GestionClient, String> cniu;

    @FXML
    private TableColumn<GestionClient, String> adresseu;

    @FXML
    private TableColumn<GestionClient, String> sexeu;

    @FXML
    private TableColumn<GestionClient, String> datenaisu;

    @FXML
    private TableColumn<GestionClient, String> statutu;

    @FXML
    private TableColumn<GestionClient, String> profu;

    @FXML
    private TableColumn<GestionClient, Integer> telu;

    @FXML
    private TableColumn<GestionClient, String> docu;

    @FXML
    private TableColumn<GestionClient, String> depotu;

    @FXML
    private TableColumn<GestionClient, String> natureu;

    @FXML
    private JFXTextField nomcli;

    @FXML
    private JFXTextField adressecli;

    @FXML
    private JFXTextField statutcli;

    @FXML
    private JFXTextField cnicli;

    @FXML
    private JFXTextField telcli;

    @FXML
    private JFXTextArea doccli;

    @FXML
    private JFXTextField pbcli;

    @FXML
    private JFXDatePicker depotcli;

    @FXML
    private JFXTextField datecli;

    @FXML
    private JFXComboBox<String> sexecli;

    @FXML
    private JFXTextField metier;
    
    ObservableList<GestionClient>listet=FXCollections.observableArrayList();
    @FXML
    void Ajouterusa(ActionEvent event) throws SQLException {
    	afficher();
    	String nomok = nomcli.getText();
    	String adresp = adressecli.getText();
    	String statp = statutcli.getText();
    	String cnip = cnicli.getText();
    	String telp = telcli.getText();
    	int telok = Integer.parseInt(telp);
    	String docp = doccli.getText();
    	String pbp = pbcli.getText();
    	//String depotp = depotcli.getValue().toString();
    	String datep = datecli.getText();
    	String sexep = sexecli.getValue();
    	String metierp = metier.getText();
    
    	
    	
    	String sql ="INSERT INTO usager ( nom,adresse,sexe,datenaissance,statut,profession,numeroscni,telephone,naturepb,documentfourni,datedepot) VALUES ( ?, ?,?,?,?,?,?,?,?,?,?) ";
    	try {
    	Connectiondb con= new Connectiondb();
		Connection conn=con.connect();
		PreparedStatement stat;
		
		stat = conn.prepareStatement(sql);
		stat.setString(1, nomok);
		stat.setString(2, adresp);
		stat.setString(4, datep);
		stat.setString(5, statp);
		stat.setString(6, metierp);
		stat.setString(7, cnip);
		stat.setInt(8, telok);
		stat.setString(3, sexep);
		stat.setString(9, pbp );
		stat.setString(10, docp);
		java.util.Date dat= java.util.Date.from(depotcli.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date sqlDate = new Date (dat.getTime());
		stat.setDate(11, sqlDate);
		stat.executeUpdate();
    	
    	
    	Alert alert= new Alert(AlertType.INFORMATION);
    	
    	alert.setTitle("Information");
    	alert.setHeaderText("Enregistrement");
    	alert.setContentText("client ajouté");
    	alert.showAndWait();
    	nomcli.clear();
    	adressecli.clear();
    	statutcli.clear();
    	cnicli.clear();
    	telcli.clear();
    	doccli.clear();
    	pbcli.clear();
    	datecli.clear();
    	depotcli.setValue(null);
    	sexecli.setValue(null);
    	metier.clear();
    	
    	} catch (Exception e1) {
    	System.out.println("l erreur est:"+ e1.getMessage());
		e1.printStackTrace();
	}
   
//    	Alert alert= new Alert(AlertType.INFORMATION);
//    	alert.setTitle("Information");
//    	alert.setHeaderText("Enregistrement");
//    	alert.setContentText("client non ajouté");
//    	alert.showAndWait();

    	}
    


    @FXML
    void Modifierusa(ActionEvent event) throws IOException, SQLException {
    	afficher();
    	String idf = rechercherusa.getText();
    	int idok = Integer.parseInt(idf);
    	String nomok = nomcli.getText();
    	String adresp = adressecli.getText();
    	String statp = statutcli.getText();
    	String cnip = cnicli.getText();
    	String telp = telcli.getText();
    	int telok = Integer.parseInt(telp);
    	String docp = doccli.getText();
    	String pbp = pbcli.getText();
    	
    	String depotp = depotcli.getPromptText();
    	String datep = datecli.getText();
    	String sexep = sexecli.getValue();
    	String metierp = metier.getText();
    
    	try {
    	
    		String sql ="UPDATE usager SET nom=?,adresse=?,sexe=?,datenaissance=?,statut=?,profession=?,numeroscni=? ,telephone=?, naturepb=?,documentfourni=?,datedepot=?  WHERE id=?";
		Connectiondb con= new Connectiondb();
		Connection conn=con.connect();
		PreparedStatement stat;
		
		stat = conn.prepareStatement(sql);
		stat.setString(1, nomok);
		stat.setString(2, adresp);
		stat.setString(4, datep);
		stat.setString(5, statp);
		stat.setString(6, metierp);
		stat.setString(7, cnip);
		stat.setInt(8, telok);
		stat.setString(3, sexep);
		stat.setString(9, pbp );
		stat.setString(10, docp);
		stat.setString(11, depotp);
		stat.setInt(12, idok);
		stat.executeUpdate();
    	
    	
    	Alert alert= new Alert(AlertType.INFORMATION);
    	
    	alert.setTitle("Modification");
    	alert.setHeaderText("Modification");
    	alert.setContentText("client modifié");
    	alert.showAndWait();
    	nomcli.clear();
    	adressecli.clear();
    	statutcli.clear();
    	cnicli.clear();
    	telcli.clear();
    	doccli.clear();
    	pbcli.clear();
    	datecli.clear();
    	depotcli.setValue(null);
    	sexecli.setValue(null);
    	metier.clear();
    	
    	} catch (Exception e1) {
    	System.out.println("l erreur est:"+ e1.getMessage());
		e1.printStackTrace();
	}
   
//    	Alert alert= new Alert(AlertType.INFORMATION);
//    	alert.setTitle("Information");
//    	alert.setHeaderText("Enregistrement");
//    	alert.setContentText("client non ajouté");
//    	alert.showAndWait();

    	}
    
    

    @FXML
    void rechercherusa(ActionEvent event) {
    	
    	 tabu.getItems().clear();	
    	 String recher = rechercherusa.getText().toString();
    	
 try {
 String sql ="SELECT * FROM usager WHERE id=?"; 
	Connectiondb con= new Connectiondb();
	Connection conn=con.connect();
	PreparedStatement stat;
	stat = conn.prepareStatement(sql);
	stat.setString(1, recher);
	ResultSet rs=stat.executeQuery();
	if(rs.next()) {
		nomcli.setText(rs.getString("nom"));
		adressecli.setText(rs.getString("adresse"));
		sexecli.setValue(rs.getString("sexe"));
		datecli.setText(rs.getString("datenaissance"));
	statutcli.setText(rs.getString("statut"));
	metier.setText(rs.getString("profession"));
	cnicli.setText(rs.getString("numeroscni"));
	int t= rs.getInt("telephone");
	telcli.setText(String.valueOf(t));
	pbcli.setText(rs.getString("naturepb"));
	doccli.setText(rs.getString("documentfourni"));
	depotcli.setPromptText(rs.getString("datedepot"));
    listet.add(new GestionClient(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11), rs.getString(12)));
    idu.setCellValueFactory(new
    		PropertyValueFactory<GestionClient,Integer>("id"));
    		//tett.setCellFactory(TextFieldTableCell.<Fournisseur>forTableColumn());
nomu.setCellValueFactory(new
	PropertyValueFactory<GestionClient,String>("nom"));
nomu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
nomu.setOnEditCommit((CellEditEvent<GestionClient,String> n)->{
	((GestionClient) 
	n.getTableView().getItems().get(n.getTablePosition().getRow())).setNom(n.getNewValue());
	});
telu.setCellValueFactory(new
	PropertyValueFactory<GestionClient,Integer>("telephone"));
	//tett.setCellFactory(TextFieldTableCell.<Fournisseur>forTableColumn());
adresseu.setCellValueFactory(new
	PropertyValueFactory<GestionClient,String>("adresse"));
adresseu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
adresseu.setOnEditCommit((CellEditEvent<GestionClient,String> n)->{
	((GestionClient) 
	n.getTableView().getItems().get(n.getTablePosition().getRow())).setSexe(n.getNewValue());
	});
adresseu.setCellValueFactory(new
		PropertyValueFactory<GestionClient,String>("adresse"));
	adresseu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
	adresseu.setOnEditCommit((CellEditEvent<GestionClient,String> n)->{
		((GestionClient) 
		n.getTableView().getItems().get(n.getTablePosition().getRow())).setSexe(n.getNewValue());
		});
sexeu.setCellValueFactory(new
			PropertyValueFactory<GestionClient,String>("sexe"));
		sexeu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
		sexeu.setOnEditCommit((CellEditEvent<GestionClient,String> n)->{
			((GestionClient) 
			n.getTableView().getItems().get(n.getTablePosition().getRow())).setSexe(n.getNewValue());
			});
		datenaisu.setCellValueFactory(new
				PropertyValueFactory<GestionClient,String>("datenaissance"));
			datenaisu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
			datenaisu.setOnEditCommit((CellEditEvent<GestionClient,String> n)->{
				((GestionClient) 
				n.getTableView().getItems().get(n.getTablePosition().getRow())).setSexe(n.getNewValue());
				});
			statutu.setCellValueFactory(new
					PropertyValueFactory<GestionClient,String>("statut"));
				statutu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
				statutu.setOnEditCommit((CellEditEvent<GestionClient,String> n)->{
					((GestionClient) 
					n.getTableView().getItems().get(n.getTablePosition().getRow())).setSexe(n.getNewValue());
					});
				profu.setCellValueFactory(new
						PropertyValueFactory<GestionClient,String>("profession"));
					profu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
					profu.setOnEditCommit((CellEditEvent<GestionClient,String> n)->{
						((GestionClient) 
						n.getTableView().getItems().get(n.getTablePosition().getRow())).setSexe(n.getNewValue());
						});
					cniu.setCellValueFactory(new
							PropertyValueFactory<GestionClient,String>("numeroscni"));
						cniu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
						cniu.setOnEditCommit((CellEditEvent<GestionClient,String> n)->{
							((GestionClient) 
							n.getTableView().getItems().get(n.getTablePosition().getRow())).setSexe(n.getNewValue());
							});
					depotu.setCellValueFactory(new
							PropertyValueFactory<GestionClient,String>("datedepot"));
						depotu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
						depotu.setOnEditCommit((CellEditEvent<GestionClient,String> n)->{
							((GestionClient) 
							n.getTableView().getItems().get(n.getTablePosition().getRow())).setSexe(n.getNewValue());
							});
						docu.setCellValueFactory(new
								PropertyValueFactory<GestionClient,String>("document"));
							docu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
							docu.setOnEditCommit((CellEditEvent<GestionClient,String> n)->{
								((GestionClient) 
								n.getTableView().getItems().get(n.getTablePosition().getRow())).setSexe(n.getNewValue());
								});
							natureu.setCellValueFactory(new
									PropertyValueFactory<GestionClient,String>("naturepb"));
								natureu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
								natureu.setOnEditCommit((CellEditEvent<GestionClient,String> n)->{
									((GestionClient) 
											n.getTableView().getItems().get(n.getTablePosition().getRow())).setSexe(n.getNewValue());
								});
						tabu.setItems(listet);
						
								}else {
									afficher();
								}
		

	
	
	conn.close();
	}catch (SQLException e2) {
	// TODO: handle exception
	e2.printStackTrace(); 
	}
 
    }
    
    
    public void afficher() {
    	try {
		Connectiondb con= new Connectiondb();
		Connection conn=con.connect();
		tabu.getItems().clear();
		String sql = "SELECT * FROM usager";
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
		listet.add(new
		GestionClient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
	rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12)));
		}
		conn.close();
		} catch (Exception e) {
		e.printStackTrace();
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
    	idu.setCellValueFactory(new
	    		PropertyValueFactory<GestionClient,Integer>("id"));
	    		//tett.setCellFactory(TextFieldTableCell.<Fournisseur>forTableColumn());
	nomu.setCellValueFactory(new
		PropertyValueFactory<GestionClient,String>("nom"));
	nomu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
	nomu.setOnEditCommit((CellEditEvent<GestionClient,String> t)->{
		((GestionClient) 
		t.getTableView().getItems().get(t.getTablePosition().getRow())).setNom(t.getNewValue());
		});
	telu.setCellValueFactory(new
		PropertyValueFactory<GestionClient,Integer>("telephone"));
		//tett.setCellFactory(TextFieldTableCell.<Fournisseur>forTableColumn());
	adresseu.setCellValueFactory(new
		PropertyValueFactory<GestionClient,String>("adresse"));
	adresseu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
	adresseu.setOnEditCommit((CellEditEvent<GestionClient,String> t)->{
		((GestionClient) 
		t.getTableView().getItems().get(t.getTablePosition().getRow())).setSexe(t.getNewValue());
		});
	adresseu.setCellValueFactory(new
			PropertyValueFactory<GestionClient,String>("adresse"));
		adresseu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
		adresseu.setOnEditCommit((CellEditEvent<GestionClient,String> t)->{
			((GestionClient) 
			t.getTableView().getItems().get(t.getTablePosition().getRow())).setSexe(t.getNewValue());
			});
	sexeu.setCellValueFactory(new
				PropertyValueFactory<GestionClient,String>("sexe"));
			sexeu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
			sexeu.setOnEditCommit((CellEditEvent<GestionClient,String> t)->{
				((GestionClient) 
				t.getTableView().getItems().get(t.getTablePosition().getRow())).setSexe(t.getNewValue());
				});
			datenaisu.setCellValueFactory(new
					PropertyValueFactory<GestionClient,String>("datenaissance"));
				datenaisu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
				datenaisu.setOnEditCommit((CellEditEvent<GestionClient,String> t)->{
					((GestionClient) 
					t.getTableView().getItems().get(t.getTablePosition().getRow())).setSexe(t.getNewValue());
					});
				statutu.setCellValueFactory(new
						PropertyValueFactory<GestionClient,String>("statut"));
					statutu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
					statutu.setOnEditCommit((CellEditEvent<GestionClient,String> t)->{
						((GestionClient) 
						t.getTableView().getItems().get(t.getTablePosition().getRow())).setSexe(t.getNewValue());
						});
					profu.setCellValueFactory(new
							PropertyValueFactory<GestionClient,String>("profession"));
						profu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
						profu.setOnEditCommit((CellEditEvent<GestionClient,String> t)->{
							((GestionClient) 
							t.getTableView().getItems().get(t.getTablePosition().getRow())).setSexe(t.getNewValue());
							});
						cniu.setCellValueFactory(new
								PropertyValueFactory<GestionClient,String>("numeroscni"));
							cniu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
							cniu.setOnEditCommit((CellEditEvent<GestionClient,String> t)->{
								((GestionClient) 
								t.getTableView().getItems().get(t.getTablePosition().getRow())).setSexe(t.getNewValue());
								});
						depotu.setCellValueFactory(new
								PropertyValueFactory<GestionClient,String>("datedepot"));
							depotu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
							depotu.setOnEditCommit((CellEditEvent<GestionClient,String> t)->{
								((GestionClient) 
								t.getTableView().getItems().get(t.getTablePosition().getRow())).setSexe(t.getNewValue());
								});
							docu.setCellValueFactory(new
									PropertyValueFactory<GestionClient,String>("document"));
								docu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
								docu.setOnEditCommit((CellEditEvent<GestionClient,String> t)->{
									((GestionClient) 
									t.getTableView().getItems().get(t.getTablePosition().getRow())).setSexe(t.getNewValue());
									});
								natureu.setCellValueFactory(new
										PropertyValueFactory<GestionClient,String>("naturepb"));
									natureu.setCellFactory(TextFieldTableCell.<GestionClient>forTableColumn());
									natureu.setOnEditCommit((CellEditEvent<GestionClient,String> t)->{
										((GestionClient) 
												t.getTableView().getItems().get(t.getTablePosition().getRow())).setSexe(t.getNewValue());
									});
		tabu.setItems(listet);

									}
			
    


    @FXML
    void sexeclient(MouseEvent event) throws IOException{
    	sexecli.getSelectionModel().getSelectedItem().toString();

    }




  
	   

    @FXML
    void collaboratorAction(ActionEvent event) throws IOException {
    	col.getScene().getWindow().hide();
    	Stage stage= new Stage();
    	FXMLLoader loader= new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/NotaireView.fxml"));
    	Parent main=loader.load();//CONTENAIRE MERE polymorphisme de Anshorpane
    	Scene scene= new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    @FXML
    void documentAction(ActionEvent event) throws IOException {
    	Stage stage= new Stage();
    	FXMLLoader loader= new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/DocumentChoiseView.fxml"));
    	Parent main=loader.load();//CONTENAIRE MERE polymorphisme de Anshorpane
    	Scene scene= new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    }
    @FXML
    void Actualiser(ActionEvent event) {
    	afficher();
    }

    
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	     afficher();
		ObservableList<String> list = FXCollections.observableArrayList("Masculin", "feminin");
		sexecli.setItems(list);
	}
							}	

