package mainPackage;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {

	Stage stage;

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;
		// cooler name des programms
		stage.setTitle("CSV Viewer");

		// szene der stage hinzufügen und anzeigen
		stage.setScene(tableScene());
		stage.show();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Scene tableScene() {
		// csv liste aufbauen
		TableView<Artikel> table = new TableView<Artikel>();
		table.setEditable(true);

		ContextMenu context = new ContextMenu();
		MenuItem editCell = new MenuItem("Edit");
		editCell.setOnAction(e -> {
			// ausgewaehlten cell artikel verwenden
			Artikel artikel = table.getSelectionModel().getSelectedItem();
			stage.setScene(editScene(artikel));
		});
		context.getItems().add(editCell);

		table.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				if (t.getButton() == MouseButton.SECONDARY) {
					context.show(table, t.getScreenX(), t.getScreenY());
				}
			}
		});

		// alle spalten benennen
		TableColumn col0 = new TableColumn("hauptartikelnr");
		col0.setCellValueFactory(new PropertyValueFactory<>("hauptartikelnr"));

		TableColumn col1 = new TableColumn("artikelname");
		col1.setCellValueFactory(new PropertyValueFactory<>("artikelname"));
		TableColumn col2 = new TableColumn("hersteller");
		col2.setCellValueFactory(new PropertyValueFactory<>("hersteller"));
		TableColumn col3 = new TableColumn("beschreibung");
		col3.setCellValueFactory(new PropertyValueFactory<>("beschreibung"));
		TableColumn col4 = new TableColumn("materialangaben");
		col4.setCellValueFactory(new PropertyValueFactory<>("materialangaben"));
		TableColumn col5 = new TableColumn("geschlecht");
		col5.setCellValueFactory(new PropertyValueFactory<>("geschlecht"));
		TableColumn col6 = new TableColumn("produkt");
		col6.setCellValueFactory(new PropertyValueFactory<>("produkt"));
		TableColumn col7 = new TableColumn("aermel");
		col7.setCellValueFactory(new PropertyValueFactory<>("aermel"));
		TableColumn col8 = new TableColumn("bein");
		col8.setCellValueFactory(new PropertyValueFactory<>("bein"));
		TableColumn col9 = new TableColumn("kraagen");
		col9.setCellValueFactory(new PropertyValueFactory<>("kraagen"));
		TableColumn col10 = new TableColumn("herstellung");
		col10.setCellValueFactory(new PropertyValueFactory<>("herstellung"));
		TableColumn col11 = new TableColumn("taschenart");
		col11.setCellValueFactory(new PropertyValueFactory<>("taschenart"));
		TableColumn col12 = new TableColumn("grammatur");
		col12.setCellValueFactory(new PropertyValueFactory<>("grammatur"));
		TableColumn col13 = new TableColumn("material");
		col13.setCellValueFactory(new PropertyValueFactory<>("material"));
		TableColumn col14 = new TableColumn("ursprungsland");
		col14.setCellValueFactory(new PropertyValueFactory<>("ursprungsland"));
		TableColumn col15 = new TableColumn("bildname");
		col15.setCellValueFactory(new PropertyValueFactory<>("bildname"));

		// add collumns to table
		table.getColumns().addAll(col0, col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12,
				col13, col14, col15);
		table.setItems(csvUser.csvListe);

		// menue bar definieren
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("Edit");

		MenuItem neuerArtikel = new MenuItem("neuer Artikel");
		neuerArtikel.setOnAction(e -> {
			stage.setScene(addingScene());
		});

		MenuItem save = new MenuItem("save File");
		save.setOnAction(e -> {
			if (csvUser.saveFile()) {
				DisplayBox.display("geschafft", "datei wurde gespeichert");
			} else {
				DisplayBox.display("Error", "unbekannter fehler :(");
			}
		});

		MenuItem export = new MenuItem("export csv to Desktop");
		export.setOnAction(e -> {

			if (csvUser.exportCsvToDesktop(TextBox.display("Eingabe", "wie soll die datei heissen ? "))) {
				DisplayBox.display("geschafft", "datei wurde exporiert");
			} else {
				DisplayBox.display("Error", "Datei wurde nicht exportiert");
			}

		});

		menu1.getItems().add(neuerArtikel);
		menu1.getItems().add(save);
		menu1.getItems().add(export);
		menuBar.getMenus().add(menu1);

		// layout aufbauen
		BorderPane tablelayout = new BorderPane();
		tablelayout.setTop(menuBar);
		tablelayout.setCenter(table);

		// szenen definieren und layout einfuegen
		Scene tableScene = new Scene(tablelayout, 1200, 600);
		stage.setX(200);
		stage.setY(50);

		return tableScene;
	}

	private Scene addingScene() {

		// textfelder und labels
		Label lable = new Label("atrikelnummer");
		TextField artikelnummer = new TextField();
		Label lable1 = new Label("artikelname");
		TextField artikelname = new TextField();
		Label lable2 = new Label("hersteller");
		TextField hersteller = new TextField();
		Label lable3 = new Label("beschreibung");
		TextField beschreibung = new TextField();
		Label lable4 = new Label("materialangaben");
		TextField materialangaben = new TextField();
		Label lable5 = new Label("geschlecht");
		TextField geschlecht = new TextField();
		Label lable6 = new Label("produkt");
		TextField produkt = new TextField();
		Label lable7 = new Label("aermel");
		TextField aermel = new TextField();
		Label lable8 = new Label("bein");
		TextField bein = new TextField();
		Label lable9 = new Label("kraagen");
		TextField kraagen = new TextField();
		Label lable10 = new Label("herstellung");
		TextField herstellung = new TextField();
		Label lable11 = new Label("taschenart");
		TextField taschenart = new TextField();
		Label lable12 = new Label("grammatur");
		TextField grammatur = new TextField();
		Label lable13 = new Label("material");
		TextField material = new TextField();
		Label lable14 = new Label("ursprungsland");
		TextField ursprungsland = new TextField();
		Label lable15 = new Label("bildname");
		TextField bildname = new TextField();

		// speichern button einfuegen
		Button submit = new Button("submit");
		submit.setOnAction(e -> {
			// wenn artikelnummer, name und beschreibung fehlen ueberspringe das
			// submitten
			if (!artikelnummer.getText().isEmpty() && !artikelname.getText().isEmpty()
					&& !beschreibung.getText().isEmpty()) {

				csvUser.newSet(artikelnummer.getText(), artikelname.getText(), hersteller.getText(),
						beschreibung.getText(), materialangaben.getText(), geschlecht.getText(), produkt.getText(),
						aermel.getText(), bein.getText(), bein.getText(), herstellung.getText(), taschenart.getText(),
						grammatur.getText(), material.getText(), ursprungsland.getText(), bildname.getText());

				DisplayBox.display("done!", "Artikel wurde aufgenommen!");
				stage.setScene(tableScene());

			} else {
				// und bringe ein error
				DisplayBox.display("Error", "Artikelnummer, Artikelname oder Beschreibung fehlt! try again");

			}
		});

		// button zum abbrechen
		Button cancel = new Button("cancel");
		cancel.setOnAction(e -> {
			stage.setScene(tableScene());
		});

		// box fuer die buttons
		HBox buttons = new HBox();
		buttons.getChildren().add(submit);
		buttons.getChildren().add(cancel);

		// box zur ausrichtung der textfelder und labels
		VBox addingBox = new VBox();
		addingBox.getChildren().addAll(lable, artikelnummer, lable1, artikelname, lable2, hersteller, lable3,
				beschreibung, lable4, materialangaben, lable5, geschlecht, lable6, produkt, lable7, aermel, lable8,
				bein, lable9, kraagen, lable10, herstellung, lable11, taschenart, lable12, grammatur, lable13, material,
				lable14, ursprungsland, lable15, bildname, buttons);

		// layout aufbauen
		BorderPane addingLayout = new BorderPane();
		addingLayout.setCenter(addingBox);

		// scene definieren
		Scene addingScene = new Scene(addingLayout, 1000, 900);
		stage.setX(200);
		stage.setY(50);

		return addingScene;
	}

	private Scene editScene(Artikel artikel) {
		// textfelder und labels
		Label lable = new Label("atrikelnummer");
		TextField artikelnummer = new TextField(artikel.getHauptartikelnr());
		Label lable1 = new Label("artikelname");
		TextField artikelname = new TextField(artikel.getArtikelname());
		Label lable2 = new Label("hersteller");
		TextField hersteller = new TextField(artikel.getHersteller());
		Label lable3 = new Label("beschreibung");
		TextField beschreibung = new TextField(artikel.getBeschreibung());
		Label lable4 = new Label("materialangaben");
		TextField materialangaben = new TextField(artikel.getMaterialangaben());
		Label lable5 = new Label("geschlecht");
		TextField geschlecht = new TextField(artikel.getGeschlecht());
		Label lable6 = new Label("produkt");
		TextField produkt = new TextField(artikel.getProdukt());
		Label lable7 = new Label("aermel");
		TextField aermel = new TextField(artikel.getAermel());
		Label lable8 = new Label("bein");
		TextField bein = new TextField(artikel.getBein());
		Label lable9 = new Label("kraagen");
		TextField kraagen = new TextField(artikel.getKraagen());
		Label lable10 = new Label("herstellung");
		TextField herstellung = new TextField(artikel.getHerstellung());
		Label lable11 = new Label("taschenart");
		TextField taschenart = new TextField(artikel.getTaschenart());
		Label lable12 = new Label("grammatur");
		TextField grammatur = new TextField(artikel.getGrammatur());
		Label lable13 = new Label("material");
		TextField material = new TextField(artikel.getMaterial());
		Label lable14 = new Label("ursprungsland");
		TextField ursprungsland = new TextField(artikel.getUrsprungsland());
		Label lable15 = new Label("bildname");
		TextField bildname = new TextField(artikel.getBildname());

		// speichern button einfuegen
		Button submit = new Button("submit");
		submit.setOnAction(e -> {
			// wenn artikelnummer, name und beschreibung fehlen ueberspringe das
			// submitten
			if (!artikelnummer.getText().isEmpty() && !artikelname.getText().isEmpty()
					&& !beschreibung.getText().isEmpty()) {
				// update alle kategorien
				artikel.setHauptartikelnr(artikelnummer.getText());
				artikel.setArtikelname(artikelname.getText());
				artikel.setHersteller(hersteller.getText());
				artikel.setBeschreibung(beschreibung.getText());
				artikel.setMaterialangaben(materialangaben.getText());
				artikel.setGeschlecht(geschlecht.getText());
				artikel.setProdukt(produkt.getText());
				artikel.setAermel(aermel.getText());
				artikel.setBein(bein.getText());
				artikel.setKraagen(kraagen.getText());
				artikel.setHerstellung(herstellung.getText());
				artikel.setTaschenart(taschenart.getText());
				artikel.setGrammatur(grammatur.getText());
				artikel.setMaterial(material.getText());
				artikel.setUrsprungsland(ursprungsland.getText());
				artikel.setBildname(bildname.getText());

				// cahnge scene nach dem updaten
				DisplayBox.display("done!", "Artikel wurde geaendert!");
				stage.setScene(tableScene());

			} else {
				// und bringe ein error
				DisplayBox.display("Error", "Artikelnummer, Artikelname oder Beschreibung fehlt! try again");

			}
		});

		// button zum abbrechen
		Button cancel = new Button("cancel");
		cancel.setOnAction(e -> {
			stage.setScene(tableScene());
		});

		// box fuer die buttons
		HBox buttons = new HBox();
		buttons.getChildren().add(submit);
		buttons.getChildren().add(cancel);

		// box zur ausrichtung der textfelder und labels
		VBox addingBox = new VBox();
		addingBox.getChildren().addAll(lable, artikelnummer, lable1, artikelname, lable2, hersteller, lable3,
				beschreibung, lable4, materialangaben, lable5, geschlecht, lable6, produkt, lable7, aermel, lable8,
				bein, lable9, kraagen, lable10, herstellung, lable11, taschenart, lable12, grammatur, lable13, material,
				lable14, ursprungsland, lable15, bildname, buttons);

		// layout aufbauen
		BorderPane addingLayout = new BorderPane();
		addingLayout.setCenter(addingBox);

		// scene definieren
		Scene editScene = new Scene(addingLayout, 1000, 900);
		stage.setX(200);
		stage.setY(50);

		return editScene;
	}
}
