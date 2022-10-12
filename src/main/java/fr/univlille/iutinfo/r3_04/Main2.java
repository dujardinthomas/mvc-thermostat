package fr.univlille.iutinfo.r3_04;

import fr.univlille.iutinfo.r3_04.modelQ2.Echelle;
import fr.univlille.iutinfo.r3_04.modelQ2.Temperature;
import fr.univlille.iutinfo.r3_04.viewQ3.TextView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main2 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Temperature tC = new Temperature(Echelle.CELSIUS);
		Temperature tF = new Temperature(Echelle.FAHRENHEIT);
		Temperature tN = new Temperature(Echelle.NEWTON);
		tC.biconnectTo(tF);
		tC.biconnectTo(tN);
		new TextView( tC);
		new TextView( tF);
		new TextView( tN);

	}

}