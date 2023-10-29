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

public class TestamentController implements Initializable {
	
	   @FXML
	    private JFXTextField type;

	    @FXML
	    private JFXTextArea legs;

	    @FXML
	    private JFXTextField faitpar;

	    @FXML
	    private JFXTextField lieu;

	    @FXML
	    private JFXTextField noml;

	    @FXML
	    private JFXTextField adrtessel;

	    @FXML
	    private JFXTextField cnil;

	    @FXML
	    private JFXTextField tell;

	    @FXML
	    private JFXTextField nomb;

	    @FXML
	    private JFXTextField adresseb;

	    @FXML
	    private JFXTextField cnib;

	    @FXML
	    private JFXTextField telb;

	    @FXML
	    private JFXButton redac;

	    @FXML
	    private JFXDatePicker date;

	    @FXML
	    private JFXTextArea conditions;
	    

	    @FXML
	    private JFXTextField Categorie;


	    @FXML
	    void rediger() throws MalformedURLException {
	    	    	

	    			//String  = initialeco.getText();
	    			String typeok = type.getText();
	    			String legsok = legs.getText();
	    			String nomlok = noml.getText();
	    			String adresselok = adrtessel.getText();
	    			String cnilok = cnil.getText();
	    			String tellok = tell.getText();
	    			String nombok = nomb.getText();
	    			String adressebok = adresseb.getText();
	    			String cnibok = cnib.getText();
	    			String telbok = telb.getText();
	    			String categorieok = Categorie.getText();
	    			String conditionsok = conditions.getText();
	    			String faitparok = faitpar.getText();
	    			//String dateok = date.getValue();
	    			String lieuok = lieu.getText();
	    			
	    			imprimer();
	    			
	    			String sql = "INSERT INTO testament (type,legs,nomlegeur, adresselegeur,cnilegeur,telephonelegeur,nombene,adressebene,cnibene,telephonebene,categoriebene,conditions,faitpar,date,lieu) VALUES (?, ?, ?,?,?,?,?,?,?,?, ?,?,?,?,?) ";

	    		
	    			try {

	    				Connectiondb con = new Connectiondb();
	    				Connection conn = con.connect();
	    				PreparedStatement stat;
	    				stat = conn.prepareStatement(sql);
	    				stat.setString(1, typeok);
	    				stat.setString(2, legsok);
	    				stat.setString(3, nomlok );
	    				stat.setString(4, adresselok);
	    				stat.setString(5, cnilok);
	    				stat.setString(6, tellok);
	    				stat.setString(7, nombok );
	    				stat.setString(8, adressebok);
	    				stat.setString(9, cnibok);
	    				stat.setString(10, telbok);
	    				stat.setString(11, categorieok);
	    				stat.setString(12, conditionsok );
	    				stat.setString(13, faitparok);
	    				java.util.Date dat= java.util.Date.from(date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
	    				Date sqlDate = new Date (dat.getTime());
	    				stat.setDate(14, sqlDate);
	    				stat.setString(15, lieuok);
	    				
	    				stat.executeUpdate();
	    				 type.setText("");
	    				legs.setText("");
	    				noml.setText("");
	    				adrtessel.setText("");
	    				cnil.setText("");
	    				tell.setText("");
	    				nomb.setText("");
	    				adresseb.setText("");
	    				cnib.setText("");
	    				telb.setText("");
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
	    		   PdfWriter.getInstance(docu, new FileOutputStream("testament.pdf"));
	    		    docu.open();
	    		String format="dd/mm/yy";
	    		SimpleDateFormat formater= new SimpleDateFormat(format);
	    		java.util.Date date=  new java.util.Date();
	    		docu.add(new Paragraph("    ELEMENTS POUR LA REDACTION DE DU TESTAMENT"
	    				+"\n Nature: " + type.getText() + ""
	    				+"\n Legs: " + legs.getText()+ ""
	    				+"\n :Conditions " + conditions.getText()+ ""
	    				+"\n                        "
	    				+"\n COORDONNEES DU LEGEUR / DONNATEUR " 
	    				+"\n Nom: " + noml.getText() + ""
	    				+"\n Adresse: " + adrtessel.getText() + ""
	    				+"\n N°CNI: " + cnil.getText() + ""
	    				+"\n Telephone: " + tell.getText() + ""
	    				+"\n                        "
	    				+"\n COORDONNEES DU BENEFICIAIRE / DESTINATAIRE " 
	    				+"\n Nom: " + nomb.getText() + ""
	    				+"\n Adresse: " + adresseb.getText() + ""
	    				+"\n N°CNI: " + cnib.getText() + ""
	    				+"\n Telephone: " + telb.getText() + ""
	    				+"\n Conditions: " + conditions.getText() + ""
	    				+"\n                        "
	    				+"\n fait par : " + faitpar.getText() + " " + "le : " + formater.format(date) + " " +"A : " + lieu.getText() ,FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.NORMAL,BaseColor.BLACK)));
	    		docu.close();
	    		Desktop.getDesktop().open(new File ("testament.pdf"));
	    		} catch (FileNotFoundException | DocumentException e1) {
	    		System.out.println("l erreur est:"+ e1.getMessage());
	    		e1.printStackTrace();
	    	}catch (IOException e) {
	    		System.out.println("l erreur est:"+ e.getMessage());
	    		e.printStackTrace();
	    }}
	    



	@Override
	public void initialize(URL location, ResourceBundle resources) {
	

	}

}
