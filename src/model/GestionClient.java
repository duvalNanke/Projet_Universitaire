package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GestionClient {

	private final  IntegerProperty id;
	private  final StringProperty nom;
	private  final StringProperty adresse; 
	private  final StringProperty sexe;
	private  final StringProperty datenaissance;
	private  final StringProperty statut;
	private  final StringProperty profession;
	private  final StringProperty numeroscni;
	private  final IntegerProperty telephone;
	private  final StringProperty naturepb;
	private  final StringProperty document;
	private  final ObjectProperty<String> datedepot;
	
	public GestionClient(Integer id, String nom, String adresse, String sexe,String datenaissance ,String statut,String profession, String numeroscni,Integer telephone,String naturepb,String document,String datedepot ) {
		super();
		this.id = new SimpleIntegerProperty (id);
		this.nom =  new SimpleStringProperty(nom);
		this.adresse = new SimpleStringProperty (adresse);   
		this.sexe = new SimpleStringProperty (sexe);
		this.datenaissance = new SimpleStringProperty (datenaissance);
		this.statut = new SimpleStringProperty (statut);
		this.profession = new SimpleStringProperty (profession);
		this.numeroscni = new SimpleStringProperty (numeroscni);
		this.telephone = new SimpleIntegerProperty (telephone);
		this.naturepb = new SimpleStringProperty (naturepb);
		this.document = new SimpleStringProperty (document);
		this.datedepot = new SimpleObjectProperty<String> (datedepot);
	}
	
	public GestionClient() {
		super();
		this.id = new SimpleIntegerProperty ();
		this.nom =  new SimpleStringProperty();
		this.adresse = new SimpleStringProperty ();   
		this.sexe = new SimpleStringProperty ();
		this.datenaissance = new SimpleStringProperty ();
		this.statut = new SimpleStringProperty ();
		this.profession = new SimpleStringProperty ();
		this.numeroscni = new SimpleStringProperty ();
		this.telephone = new SimpleIntegerProperty ();
		this.naturepb = new SimpleStringProperty ();
		this.document = new SimpleStringProperty ();
		this.datedepot = new SimpleObjectProperty<String> ();
	}

	public final IntegerProperty idProperty() {
		return this.id;
	}
	
	public final int getId() {
		return this.idProperty().get();
	}
	

	public final void setId(final int id) {
		this.telephoneProperty().set(id);
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
	
	public final StringProperty naturepbProperty() {
		return this.naturepb;
	}
	
	public final String getNaturepb() {
		return this.naturepbProperty().get();
	}
	

	public final void setNaturepb(final String naturepb) {
		this.naturepbProperty().set(naturepb);
	}
	
	public final StringProperty documentProperty() {
		return this.document;
	}
	
	public final String getDocument() {
		return this.documentProperty().get();
	}
	

	public final void setDocument(final String document) {
		this.documentProperty().set(document);
	}
	
	
	public final ObjectProperty<String> datedepotProperty() {
		return this.datedepot;
	}
	
	public final String getDatedepot() {
		return this.datedepotProperty().get();
	}
	

	public final void setDatedepot(final String datedepot) {
		this.datedepotProperty().set(datedepot);
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
	

	@Override
	public String toString() {
		return "GestionClient [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", sexe=" + sexe
				+ ", datenaissance=" + datenaissance + ", statut=" + statut + ", numeroscni=" + numeroscni
				+ ", telephone=" + telephone + ", naturepb=" + naturepb + ", document=" + document + ", datedepot="
				+ datedepot + "]";
	}
	


	
}
