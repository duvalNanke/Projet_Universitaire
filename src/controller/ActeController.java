package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ResourceBundle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import connexion.Connectiondb; 
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
public class ActeController implements Initializable {
	

	//public ObservableList<GestionActes> data FXCollections.observableArrayList();
    @FXML
    private JFXTextField nature;

    @FXML
    private JFXTextField objet;

    @FXML
    private JFXTextArea article;

    @FXML
    private JFXTextField prix;

    @FXML
    private JFXTextField faitpar;

    @FXML
    private JFXTextField lieu;

    @FXML
    private JFXTextField noma;

    @FXML
    private JFXTextField adrtessea;

    @FXML
    private JFXTextField cnia;

    @FXML
    private JFXTextField tela;

    @FXML
    private JFXTextField nomv;

    @FXML
    private JFXTextField adressev;

    @FXML
    private JFXTextField cniv;

    @FXML
    private JFXTextField telv;

    @FXML
    private JFXButton redac;

    @FXML
    private JFXDatePicker date;

    @FXML
    void rediger() throws MalformedURLException {
    	

		//String  = initialeco.getText();
		String natureok = nature.getText();
		String objetok = objet.getText();
		String nomaok = noma.getText();
		String adresseaok = adrtessea.getText();
		String cniaok = cnia.getText();
		String telaok = tela.getText();
		String nomvok = nomv.getText();
		//String te = telco.getText();
		//int telok = Integer.parseInt(te);
		String adressevok = adressev.getText();
		String cnivok = cniv.getText();
		String telvok = telv.getText();
		String faitparok = faitpar.getText();
		//String dateok = date.getValue();
		String lieuok = lieu.getText();
		
		imprimer();
		
		String sql = "INSERT INTO actes (nature,objet,nomvendeur, adressevendeur,cnivendeur,telvendeur,nomacheteur,adresseacheteur,cniacheteur,telacheteur,faitpar,date,lieu) VALUES (?, ?, ?,?,?,?,?,?,?,?, ?,?,?) ";

	
		try {

			Connectiondb con = new Connectiondb();
			Connection conn = con.connect();
			PreparedStatement stat;
			stat = conn.prepareStatement(sql);
			//stat.setString(1, initialeok);
			stat.setString(1, natureok);
			stat.setString(2, objetok);
			stat.setString(7, nomaok );
			stat.setString(8, adresseaok);
			stat.setString(9, cniaok);
			stat.setString(10, telaok);
			stat.setString(3, nomvok);
			//stat.setInt(9, telok);
			//stat.setString(10, metierok);
			stat.setString(4, adressevok );
			stat.setString(5, cnivok);
			stat.setString(6, telvok);
			stat.setString(11, faitparok);
			java.util.Date dat= java.util.Date.from(date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date sqlDate = new Date (dat.getTime());
			stat.setDate(12, sqlDate);
			stat.setString(13, lieuok);
			
			stat.executeUpdate();
			//urlco.setText("aucun selectionner");
			 nature.setText("");
			objet.setText("");
			noma.setText("");
			adrtessea.setText("");
			cnia.setText("");
			tela.setText("");
			nomv.setText("");
			adressev.setText("");
			cniv.setText("");
			telv.setText("");
			faitpar.setText("");
			date.setValue(null);
			lieu.setText("");

		} catch (Exception e1) {
System.out.println("l erreur est:"+ e1.getMessage());
			e1.printStackTrace();
		}

	}
 public void imprimer() throws MalformedURLException {
	//
	//Document doc = new Document();
	com.itextpdf.text.Document docu = new com.itextpdf.text.Document();
	try {
		   PdfWriter.getInstance(docu, new FileOutputStream("acte.pdf"));
		    docu.open();
		String format="dd/mm/yy hh:mm";
		SimpleDateFormat formater= new SimpleDateFormat(format);
		java.util.Date date=  new java.util.Date();
		docu.add(new Paragraph("    ELEMENTS POUR LA REDACTION DE L'ACTE"
				+"\n NATURE: " + nature.getText() + ""
				+"\n OBJET: " + objet.getText()+ ""
				+"\n DESCRIPTION DE L'ARTICLE: " + article.getText()+ ""
				+"\n PRIX CONVENU: " + prix.getText() + ""
				+"\n                        "
				+"\n                        "
				+"\n COORDONNEES DU VENDEUR " 
				+"\n NOM: " + nomv.getText() + ""
				+"\n ADRESSE: " + adressev.getText() + ""
				+"\n N°CNI: " + cniv.getText() + ""
				+"\n TELEPHONE: " + telv.getText() + ""
				+"\n                        "
				+"\n                        "
				+"\n COORDONNEES DU VENDEUR " 
				+"\n NOM: " + noma.getText() + ""
				+"\n ADRESSE: " + adrtessea.getText() + ""
				+"\n N°CNI: " + cnia.getText() + ""
				+"\n TELEPHONE: " + tela.getText() + ""
				+"\n FAIT PAR : " + faitpar.getText() + " " + "LE : " + formater.format(date) + " " +"A : " + lieu.getText() ,FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.NORMAL,BaseColor.BLACK)));
		docu.close();
		Desktop.getDesktop().open(new File ("acte.pdf"));
		} catch (FileNotFoundException | DocumentException e1) {
		System.out.println("l erreur est:"+ e1.getMessage());
		e1.printStackTrace();
	}catch (IOException e) {
		System.out.println("l erreur est:"+ e.getMessage());
		e.printStackTrace();
}}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
