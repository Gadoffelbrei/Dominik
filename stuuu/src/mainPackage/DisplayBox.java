package mainPackage;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DisplayBox {

	private static Stage window;
	private static Button button1;
	private static Scene scene;
	private static VBox layout;

	public static void display(String title, String messege) {
		window = new Stage();
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(250);

		Label label = new Label();
		label.setText(messege);
		label.setAlignment(Pos.CENTER);

		button1 = new Button();
		button1.setText("close");
		button1.setOnAction(e -> window.close());

		layout = new VBox();
		layout.getChildren().addAll(label, button1);
		layout.setAlignment(Pos.CENTER);

		scene = new Scene(layout);
		window.setScene(scene);
		window.show();
	}
}
