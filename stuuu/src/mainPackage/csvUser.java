package mainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class csvUser {

	public static String CSVFILE = "res/Artikel.csv";
	public final static ObservableList<Artikel> csvListe = FXCollections.observableArrayList();

	private static BufferedReader br = null;
	private static String line = "";
	private static String csvSplitBy = ";";
	public static int anzahlDerSpalten = 16;
	private static Artikel kategorien;

	public static void init() {
		readCSV();
	}

	private static void readCSV() {
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(CSVFILE));

			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(csvSplitBy, -1);

				try {
					Artikel temp = new Artikel(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5],
							fields[6], fields[7], fields[8], fields[9], fields[10], fields[11], fields[12], fields[13],
							fields[14], fields[15]);

					csvListe.add(temp);

				} catch (ArrayIndexOutOfBoundsException e) {

				}

			}

			// remove header row
			kategorien = csvListe.get(0);
			csvListe.remove(0);

		} catch (FileNotFoundException ex) {

		} catch (IOException ex) {

		}

	}

	public static void newSet(String Hauptartikelnr, String Artikelname, String Hersteller, String beschreibung,
			String Materialangaben, String Geschlecht, String Produkt, String Aermel, String Bein, String Kraagen,
			String Herstellung, String Taschenart, String Grammatur, String Material, String Ursprungsland,
			String Bildname) {

		// neuen artiekl anlegen
		Artikel temp = new Artikel(Hauptartikelnr, Artikelname, Hersteller, beschreibung, Materialangaben, Geschlecht,
				Produkt, Aermel, Bein, Kraagen, Herstellung, Taschenart, Grammatur, Material, Ursprungsland, Bildname);

		// der liste hinzufügen
		csvListe.add(temp);

	}

	public static boolean exportCsvToDesktop(String name) {
		try {

			if (name.length() == 0)
				name = "noname";

			File textFile;
			// ist im name schon ein ".csv" ?

			if (name.substring(name.length() - 4, name.length() - 1).equals(".csv")) {
				textFile = new File(System.getProperty("user.home"), "/Desktop/" + name);
			} else {
				// wenn kein ".csv" im namen ist, eins anfuegen
				textFile = new File(System.getProperty("user.home"), "/Desktop/" + name + ".csv");
			}

			FileWriter csvWriter = new FileWriter(textFile);

			// ueberschriften einfuegen
			csvWriter.append(kategorien.getHauptartikelnr() + csvSplitBy + kategorien.getArtikelname() + csvSplitBy
					+ kategorien.getHersteller() + csvSplitBy + kategorien.getBeschreibung() + csvSplitBy
					+ kategorien.getMaterialangaben() + csvSplitBy + kategorien.getGeschlecht() + csvSplitBy
					+ kategorien.getProdukt() + csvSplitBy + kategorien.getAermel() + csvSplitBy + kategorien.getBein()
					+ csvSplitBy + kategorien.getKraagen() + csvSplitBy + kategorien.getHerstellung() + csvSplitBy
					+ kategorien.getTaschenart() + csvSplitBy + kategorien.getGrammatur() + csvSplitBy
					+ kategorien.getMaterial() + csvSplitBy + kategorien.getUrsprungsland() + csvSplitBy
					+ kategorien.getBildname());

			csvWriter.append("\n");

			// jeden artikel in der csv liste durchgehen und anhaengen
			for (Artikel tempArtikel : csvListe) {
				csvWriter.append(tempArtikel.getHauptartikelnr() + csvSplitBy + tempArtikel.getArtikelname()
						+ csvSplitBy + tempArtikel.getHersteller() + csvSplitBy + tempArtikel.getBeschreibung()
						+ csvSplitBy + tempArtikel.getMaterialangaben() + csvSplitBy + tempArtikel.getGeschlecht()
						+ csvSplitBy + tempArtikel.getProdukt() + csvSplitBy + tempArtikel.getAermel() + csvSplitBy
						+ tempArtikel.getBein() + csvSplitBy + tempArtikel.getKraagen() + csvSplitBy
						+ tempArtikel.getHerstellung() + csvSplitBy + tempArtikel.getTaschenart() + csvSplitBy
						+ tempArtikel.getGrammatur() + csvSplitBy + tempArtikel.getMaterial() + csvSplitBy
						+ tempArtikel.getUrsprungsland() + csvSplitBy + tempArtikel.getBildname());

				csvWriter.append("\n");
			}

			// nach der schleife file schließen
			csvWriter.flush();
			csvWriter.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean saveFile() {
		try {

			File textFile = new File(CSVFILE);

			FileWriter csvWriter = new FileWriter(textFile);

			// ueberschriften einfuegen
			csvWriter.append(kategorien.getHauptartikelnr() + csvSplitBy + kategorien.getArtikelname() + csvSplitBy
					+ kategorien.getHersteller() + csvSplitBy + kategorien.getBeschreibung() + csvSplitBy
					+ kategorien.getMaterialangaben() + csvSplitBy + kategorien.getGeschlecht() + csvSplitBy
					+ kategorien.getProdukt() + csvSplitBy + kategorien.getAermel() + csvSplitBy + kategorien.getBein()
					+ csvSplitBy + kategorien.getKraagen() + csvSplitBy + kategorien.getHerstellung() + csvSplitBy
					+ kategorien.getTaschenart() + csvSplitBy + kategorien.getGrammatur() + csvSplitBy
					+ kategorien.getMaterial() + csvSplitBy + kategorien.getUrsprungsland() + csvSplitBy
					+ kategorien.getBildname());

			csvWriter.append("\n");

			// jeden artikel in der csv liste durchgehen und anhaengen
			for (Artikel tempArtikel : csvListe) {
				csvWriter.append(tempArtikel.getHauptartikelnr() + csvSplitBy + tempArtikel.getArtikelname()
						+ csvSplitBy + tempArtikel.getHersteller() + csvSplitBy + tempArtikel.getBeschreibung()
						+ csvSplitBy + tempArtikel.getMaterialangaben() + csvSplitBy + tempArtikel.getGeschlecht()
						+ csvSplitBy + tempArtikel.getProdukt() + csvSplitBy + tempArtikel.getAermel() + csvSplitBy
						+ tempArtikel.getBein() + csvSplitBy + tempArtikel.getKraagen() + csvSplitBy
						+ tempArtikel.getHerstellung() + csvSplitBy + tempArtikel.getTaschenart() + csvSplitBy
						+ tempArtikel.getGrammatur() + csvSplitBy + tempArtikel.getMaterial() + csvSplitBy
						+ tempArtikel.getUrsprungsland() + csvSplitBy + tempArtikel.getBildname());

				csvWriter.append("\n");
			}

			// nach der schleife file schließen
			csvWriter.flush();
			csvWriter.close();

			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
