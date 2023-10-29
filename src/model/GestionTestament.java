package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GestionTestament {
	

	private IntegerProperty id;
	private StringProperty type;
	private StringProperty legs;
	private StringProperty noml;
	private StringProperty adressel;
	private StringProperty cnil;
	private StringProperty tell;
	private StringProperty nomb;
	private StringProperty adresseb;
	private StringProperty cnib;
	private StringProperty telb;
	private StringProperty categorie;
	private StringProperty conditions;
	private StringProperty faitpar;
	private  StringProperty date ;
	private StringProperty lieu;
	
	
	
	public GestionTestament(int id,String type, String legs, String noml, String adressel, String cnil, String tell, String nomb, String adresseb,String cnib, String telb,String categorie,String conditions, String faitpar, String date,String lieu) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.type = new SimpleStringProperty(legs);
		this.legs = new SimpleStringProperty(legs);
		this.noml = new SimpleStringProperty(noml);
		this.adressel =new SimpleStringProperty(adressel);
		this.cnil = new SimpleStringProperty(cnil);
		this.tell = new SimpleStringProperty(tell);
		this.nomb = new SimpleStringProperty(nomb);
		this.categorie = new SimpleStringProperty(categorie);
		this.adresseb =new SimpleStringProperty(adressel);
		this.cnib = new SimpleStringProperty(cnib);
		this.telb = new SimpleStringProperty(telb);
		this.conditions = new SimpleStringProperty(conditions);
		this.faitpar = new SimpleStringProperty(faitpar);
		this.date =new SimpleStringProperty(date);
		this.lieu =new SimpleStringProperty(lieu);
	
	}
	
	public GestionTestament() {
		super();
		this.id = new SimpleIntegerProperty();
		this.type = new SimpleStringProperty();
		this.legs =new SimpleStringProperty();
		this.noml = new SimpleStringProperty();
		this.adressel = new SimpleStringProperty();
		this.cnil = new SimpleStringProperty();
		this.tell = new SimpleStringProperty();
		this.nomb = new SimpleStringProperty();
		this.categorie = new SimpleStringProperty();
		this.adresseb= new  SimpleStringProperty();
		this.cnib =new SimpleStringProperty();
		this.telb =new SimpleStringProperty();
		this.conditions =new SimpleStringProperty();
		this.faitpar = new SimpleStringProperty();
		this.date = new SimpleStringProperty();
		this.lieu = new SimpleStringProperty();
		
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
	

	public final StringProperty typeProperty() {
		return this.type;
	}
	

	public final String getType() {
		return this.typeProperty().get();
	}
	

	public final void setType(final String type) {
		this.typeProperty().set(type);
	}
	

	public final StringProperty legsProperty() {
		return this.legs;
	}
	

	public final String getLegs() {
		return this.legsProperty().get();
	}
	

	public final void setLegs(final String legs) {
		this.legsProperty().set(legs);
	}
	

	public final StringProperty nomlProperty() {
		return this.noml;
	}
	

	public final String getNoml() {
		return this.nomlProperty().get();
	}
	

	public final void setNoml(final String noml) {
		this.nomlProperty().set(noml);
	}
	

	public final StringProperty adresselProperty() {
		return this.adressel;
	}
	

	public final String getAdressel() {
		return this.adresselProperty().get();
	}
	

	public final void setAdressel(final String adressel) {
		this.adresselProperty().set(adressel);
	}
	

	public final StringProperty cnilProperty() {
		return this.cnil;
	}
	

	public final String getCnil() {
		return this.cnilProperty().get();
	}
	

	public final void setCnil(final String cnil) {
		this.cnilProperty().set(cnil);
	}
	

	public final StringProperty tellProperty() {
		return this.tell;
	}
	

	public final String getTell() {
		return this.tellProperty().get();
	}
	

	public final void setTell(final String tell) {
		this.tellProperty().set(tell);
	}
	

	public final StringProperty nombProperty() {
		return this.nomb;
	}
	

	public final String getNomb() {
		return this.nombProperty().get();
	}
	

	public final void setNomb(final String nomb) {
		this.nombProperty().set(nomb);
	}
	

	public final StringProperty adressebProperty() {
		return this.adresseb;
	}
	

	public final String getAdresseb() {
		return this.adressebProperty().get();
	}
	

	public final void setAdresseb(final String adresseb) {
		this.adressebProperty().set(adresseb);
	}
	

	public final StringProperty cnibProperty() {
		return this.cnib;
	}
	

	public final String getCnib() {
		return this.cnibProperty().get();
	}
	

	public final void setCnib(final String cnib) {
		this.cnibProperty().set(cnib);
	}
	

	public final StringProperty telbProperty() {
		return this.telb;
	}
	

	public final String getTelb() {
		return this.telbProperty().get();
	}
	

	public final void setTelb(final String telb) {
		this.telbProperty().set(telb);
	}
	

	public final StringProperty categorieProperty() {
		return this.categorie;
	}
	

	public final String getCategorie() {
		return this.categorieProperty().get();
	}
	

	public final void setCategorie(final String categorie) {
		this.categorieProperty().set(categorie);
	}
	

	public final StringProperty conditionsProperty() {
		return this.conditions;
	}
	

	public final String getConditions() {
		return this.conditionsProperty().get();
	}
	

	public final void setConditions(final String conditions) {
		this.conditionsProperty().set(conditions);
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
	

	public final StringProperty dateProperty() {
		return this.date;
	}
	

	public final String getDate() {
		return this.dateProperty().get();
	}
	

	public final void setDate(final String date) {
		this.dateProperty().set(date);
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
	

	

}
