package mainPackage;


import javafx.application.Application;

public class launcher {
	public static void main(final String[] args) {
		csvUser.init();
        Application.launch(Gui.class, args);
    }
}

