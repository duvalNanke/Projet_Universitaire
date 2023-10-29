package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Collaborateur {
	private final  StringProperty initiale;
	private  final StringProperty nom;
	private  final StringProperty adresse; 
	private  final StringProperty sexe;
	private  final StringProperty datenaissance;
	private  final StringProperty statut;
	private  final StringProperty profession;
	private  final StringProperty numeroscni;
	private  final IntegerProperty telephone;
	private  final StringProperty password;
	
	public Collaborateur(String initiale, String nom, String adresse, String sexe,String datenaissance ,String statut,String profession, String numeroscni,Integer telephone,String password ) {
		super();
		this.initiale = new SimpleStringProperty (initiale);
		this.nom =  new SimpleStringProperty(nom);
		this.adresse = new SimpleStringProperty (adresse);   
		this.sexe = new SimpleStringProperty (sexe);
		this.datenaissance = new SimpleStringProperty (datenaissance);
		this.statut = new SimpleStringProperty (statut);
		this.profession = new SimpleStringProperty (profession);
		this.numeroscni = new SimpleStringProperty (numeroscni);
		this.telephone = new SimpleIntegerProperty (telephone);
		this.password = new SimpleStringProperty (password);
	}
	
	public Collaborateur() {
		super();
		this.initiale = new SimpleStringProperty ();
		this.nom =  new SimpleStringProperty();
		this.adresse = new SimpleStringProperty ();   
		this.sexe = new SimpleStringProperty ();
		this.datenaissance = new SimpleStringProperty ();
		this.statut = new SimpleStringProperty ();
		this.profession = new SimpleStringProperty ();
		this.numeroscni = new SimpleStringProperty ();
		this.telephone = new SimpleIntegerProperty ();
		this.password = new SimpleStringProperty ();
		
	
	}
	public final StringProperty initialeProperty() {
		return this.initiale;
	}
	

	public final String getInitiale() {
		return this.initialeProperty().get();
	}
	

	public final void setInitiale(final String initiale) {
		this.initialeProperty().set(initiale);
	}
	

	public final StringProperty nomProperty() {
		return this.nom;
	}
	

	public final String getNom() {
		return this.nomProperty().get();
	}
	

	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	

	public final StringProperty adresseProperty() {
		return this.adresse;
	}
	
 
	public final String getAdresse() {
		return this.adresseProperty().get();
	}
	

	public final void setAdresse(final String adresse) {
		this.adresseProperty().set(adresse);
	}
	

	
	public final String getDatenaissance() {
		return this.datenaissanceProperty().get();
	}
	

	public final void setDatenaissance(final String datenaissance) {
		this.datenaissanceProperty().set(datenaissance);
	}
	
	public final StringProperty datenaissanceProperty() {
		return this.datenaissance;
	}
	
	
	public final StringProperty sexeProperty() {
		return this.sexe;
	}
	
	public final String getSexe() {
		return this.sexeProperty().get();
	}
	

	public final void setSexe(final String sexe) {
		this.sexeProperty().set(sexe);
	}
	
	
	public final StringProperty statutProperty() {
		return this.statut;
	}
	

	public final String getStatut() {
		return this.statutProperty().get();
	}
	

	public final void setStatut(final String statut) {
		this.statutProperty().set(statut);
	}
	
	public final StringProperty numeroscniProperty() {
		return this.numeroscni;
	}
	
	public final String getNumeroscni() {
		return this.numeroscniProperty().get();
	}
	

	public final void setNumeroscni(final String numeroscni) {
		this.numeroscniProperty().set(numeroscni);
	}

	public final IntegerProperty telephoneProperty() {
		return this.telephone;
	}
	
	public final int getTelephone() {
		return this.telephoneProperty().get();
	}
	

	public final void setTelephone(final int telephone) {
		this.telephoneProperty().set(telephone);
	}
	
	public final StringProperty passwordProperty() {
		return this.password;
	}
	
	public final String getPassword() {
		return this.passwordProperty().get();
	}
	

	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}
	
	
	public final StringProperty professionProperty() {
		return this.profession;
	}
	

	public final String getProfession() {
		return this.professionProperty().get();
	}
	

	public final void setProfession(final String profession) {
		this.professionProperty().set(profession);
	}
	

	
}

