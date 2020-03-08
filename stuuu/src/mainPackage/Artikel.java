package mainPackage;

import javafx.beans.property.SimpleStringProperty;

public class Artikel {

	private SimpleStringProperty hauptartikelnr, artikelname, hersteller,
	        beschreibung, materialangaben, geschlecht, produkt, aermel, bein,
	        kraagen, herstellung, taschenart, grammatur, material,
	        ursprungsland, bildname;

	public Artikel(String hauptartikelnr,
			String artikelname, String hersteller,
			String beschreibung,
	        String materialangaben,
	        String geschlecht, String produkt,
	        String aermel, String bein,
	        String kraagen, String herstellung,
	        String taschenart, String grammatur,
	        String material, String ursprungsland,
	        String bildname) {

		this.hauptartikelnr = new SimpleStringProperty(hauptartikelnr);
		this.artikelname = new SimpleStringProperty(artikelname);
		this.hersteller = new SimpleStringProperty(hersteller);
		this.beschreibung = new SimpleStringProperty(beschreibung);
		this.materialangaben = new SimpleStringProperty(materialangaben);
		this.geschlecht = new SimpleStringProperty(geschlecht);
		this.produkt = new SimpleStringProperty(produkt);
		this.aermel = new SimpleStringProperty(aermel);
		this.bein = new SimpleStringProperty(bein);
		this.kraagen = new SimpleStringProperty(kraagen);
		this.herstellung = new SimpleStringProperty(herstellung);
		this.taschenart = new SimpleStringProperty(taschenart);
		this.grammatur = new SimpleStringProperty(grammatur);
		this.material = new SimpleStringProperty(material);
		this.ursprungsland = new SimpleStringProperty(ursprungsland);
		this.bildname = new SimpleStringProperty(bildname);
	}

	public String getHauptartikelnr() {
		return hauptartikelnr.get();
	}

	public void setHauptartikelnr(String hauptartikelnr) {
		this.hauptartikelnr = new SimpleStringProperty(hauptartikelnr);
	}

	public String getArtikelname() {
		return artikelname.get();
	}

	public void setArtikelname(String artikelname) {
		this.artikelname = new SimpleStringProperty(artikelname);
	}

	public String getHersteller() {
		return hersteller.get();
	}

	public void setHersteller(String hersteller) {
		this.hersteller = new SimpleStringProperty(hersteller);
	}

	public String getBeschreibung() {
		return beschreibung.get();
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = new SimpleStringProperty(beschreibung);
	}

	public String getMaterialangaben() {
		return materialangaben.get();
	}

	public void setMaterialangaben(String materialangaben) {
		this.materialangaben = new SimpleStringProperty(materialangaben);
	}

	public String getGeschlecht() {
		return geschlecht.get();
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = new SimpleStringProperty(geschlecht);
	}

	public String getProdukt() {
		return produkt.get();
	}

	public void setProdukt(String produkt) {
		this.produkt = new SimpleStringProperty(produkt);
	}

	public String getAermel() {
		return aermel.get();
	}

	public void setAermel(String aermel) {
		this.aermel = new SimpleStringProperty(aermel);
	}

	public String getBein() {
		return bein.get();
	}

	public void setBein(String bein) {
		this.bein = new SimpleStringProperty(bein);
	}

	public String getKraagen() {
		return kraagen.get();
	}

	public void setKraagen(String kraagen) {
		this.kraagen = new SimpleStringProperty(kraagen);
	}

	public String getHerstellung() {
		return herstellung.get();
	}

	public void setHerstellung(String herstellung) {
		this.herstellung = new SimpleStringProperty(herstellung);
	}

	public String getTaschenart() {
		return taschenart.get();
	}

	public void setTaschenart(String taschenart) {
		this.taschenart = new SimpleStringProperty(taschenart);
	}

	public String getGrammatur() {
		return grammatur.get();
	}

	public void setGrammatur(String grammatur) {
		this.grammatur = new SimpleStringProperty(grammatur);
	}

	public String getMaterial() {
		return material.get();
	}

	public void setMaterial(String material) {
		this.material = new SimpleStringProperty(material);
	}

	public String getUrsprungsland() {
		return ursprungsland.get();
	}

	public void setUrsprungsland(String ursprungsland) {
		this.ursprungsland = new SimpleStringProperty(ursprungsland);
	}

	public String getBildname() {
		return bildname.get();
	}

	public void setBildname(String bildname) {
		this.bildname = new SimpleStringProperty(bildname);
	}

}
