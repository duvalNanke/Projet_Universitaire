package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GestionActes {

	private IntegerProperty id;
	private StringProperty nature;
	private StringProperty objet;
	private StringProperty noma;
	private StringProperty adressea;
	private StringProperty cnia;
	private StringProperty tela;
	private StringProperty nomv;
	private StringProperty adressev;
	private StringProperty cniv;
	private StringProperty telv;
	private StringProperty faitpar;
	private  StringProperty date ;
	private StringProperty lieu;
	
	
	
	public GestionActes(int id,String nature, String objet, String noma, String adressea, String cnia, String tela, String nomv, String adressev,String cniv, String telv,String faitpar, String date,String lieu) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.nature = new SimpleStringProperty(nature);
		this.objet = new SimpleStringProperty(objet);
		this.noma = new SimpleStringProperty(noma);
		this.adressea =new SimpleStringProperty(adressea);
		this.cnia = new SimpleStringProperty(cnia);
		this.tela = new SimpleStringProperty(tela);
		this.nomv = new SimpleStringProperty(nomv);
		this.adressev =new SimpleStringProperty(adressev);
		this.cniv = new SimpleStringProperty(cniv);
		this.telv = new SimpleStringProperty(telv);
		this.faitpar = new SimpleStringProperty(faitpar);
		this.date =new SimpleStringProperty(date);
		this.lieu =new SimpleStringProperty(lieu);
	
	}
	
	public GestionActes() {
		super();
		this.id = new SimpleIntegerProperty();
		this.nature = new SimpleStringProperty();
		this.objet =new SimpleStringProperty();
		this.noma = new SimpleStringProperty();
		this.adressea = new SimpleStringProperty();
		this.cnia = new SimpleStringProperty();
		this.tela = new SimpleStringProperty();
		this.nomv = new SimpleStringProperty();
		this.adressev= new  SimpleStringProperty();
		this.cniv =new SimpleStringProperty();
		this.telv =new SimpleStringProperty();
		this.faitpar = new SimpleStringProperty();
		this.date = new SimpleStringProperty();
		this.lieu =new SimpleStringProperty();
	}

	public final IntegerProperty idProperty() {
		return this.id;
	}
	

	public final int getId() {
		return this.idProperty().get();
	}
	

	public final void setId(final int id) {
		this.idProperty().set(id);
	}
	

	public final StringProperty natureProperty() {
		return this.nature;
	}
	

	public final String getNature() {
		return this.natureProperty().get();
	}
	

	public final void setNature(final String nature) {
		this.natureProperty().set(nature);
	}
	
	public final StringProperty lieuProperty() {
		return this.lieu;
	}
	

	public final String getLieu() {
		return this.lieuProperty().get();
	}
	

	public final void setLieu(final String lieu) {
		this.lieuProperty().set(lieu);
	}

	public final StringProperty objetProperty() {
		return this.objet;
	}
	

	public final String getObjet() {
		return this.objetProperty().get();
	}
	

	public final void setObjet(final String objet) {
		this.objetProperty().set(objet);
	}
	

	public final StringProperty nomaProperty() {
		return this.noma;
	}
	

	public final String getNoma() {
		return this.nomaProperty().get();
	}
	

	public final void setNoma(final String noma) {
		this.nomaProperty().set(noma);
	}
	

	public final StringProperty adresseaProperty() {
		return this.adressea;
	}
	

	public final String getAdressea() {
		return this.adresseaProperty().get();
	}
	

	public final void setAdressea(final String adressea) {
		this.adresseaProperty().set(adressea);
	}
	

	public final StringProperty cniaProperty() {
		return this.cnia;
	}
	

	public final String getCnia() {
		return this.cniaProperty().get();
	}
	

	public final void setCnia(final String cnia) {
		this.cniaProperty().set(cnia);
	}
	

	public final StringProperty telaProperty() {
		return this.tela;
	}
	

	public final String getTela() {
		return this.telaProperty().get();
	}
	

	public final void setTela(final String tela) {
		this.telaProperty().set(tela);
	}
	

	public final StringProperty nomvProperty() {
		return this.nomv;
	}
	

	public final String getNomv() {
		return this.nomvProperty().get();
	}
	

	public final void setNomv(final String nomv) {
		this.nomvProperty().set(nomv);
	}
	

	public final StringProperty adressevProperty() {
		return this.adressev;
	}
	

	public final String getAdressev() {
		return this.adressevProperty().get();
	}
	

	public final void setAdressev(final String adressev) {
		this.adressevProperty().set(adressev);
	}
	

	public final StringProperty cnivProperty() {
		return this.cniv;
	}
	

	public final String getCniv() {
		return this.cnivProperty().get();
	}
	

	public final void setCniv(final String cniv) {
		this.cnivProperty().set(cniv);
	}
	

	public final StringProperty telvProperty() {
		return this.telv;
	}
	

	public final String getTelv() {
		return this.telvProperty().get();
	}
	

	public final void setTelv(final String telv) {
		this.telvProperty().set(telv);
	}
	

	public final StringProperty faitparProperty() {
		return this.faitpar;
	}
	

	public final String getFaitpar() {
		return this.faitparProperty().get();
	}
	

	public final void setFaitpar(final String faitpar) {
		this.faitparProperty().set(faitpar);
		
	}
	public final void setDate(final String date) {
		this.dateProperty().set(date);
	}
	

	public final StringProperty dateProperty() {
		return this.date;
	}
	

	public final String getDate() {
		return this.dateProperty().get();
	}
}
