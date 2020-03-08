package mainPackage;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TextBox {

	private static Stage window;
	private static Button button1, button2;
	private static Scene scene;
	private static VBox layout;
	private static boolean submit = false;

	public static String display(String title, String messege) {
		window = new Stage();
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(250);

		Label label = new Label();
		label.setText(messege);
		label.setAlignment(Pos.CENTER);

		TextField eingabe = new TextField();

		button1 = new Button();
		button1.setText("submit");
		button1.setOnAction(e -> {
			submit = true;
			window.close();
		});

		button2 = new Button();
		button2.setText("close");
		button2.setOnAction(e -> {
			submit = false;
			window.close();
		});

		HBox buttonBox = new HBox();
		buttonBox.getChildren().add(button1);
		buttonBox.getChildren().add(button2);

		layout = new VBox();
		layout.getChildren().addAll(label, eingabe, buttonBox);
		layout.setAlignment(Pos.CENTER);

		scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

		if (submit)
			return eingabe.getText();
		else
			return null;
	}
}
