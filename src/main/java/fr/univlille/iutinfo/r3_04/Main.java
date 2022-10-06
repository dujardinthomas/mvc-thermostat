package fr.univlille.iutinfo.r3_04;

import fr.univlille.iutinfo.r3_04.modelQ1.Thermogeekostat;
import fr.univlille.iutinfo.r3_04.viewQ1.SliderView;
import fr.univlille.iutinfo.r3_04.viewQ1.TextView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	//demarrage soit avec le fichier pom.xml ou les VM arguments :  " --module-path C:\javafx-sdk-17.0.2\lib --add-modules=javafx.controls "

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Thermogeekostat thermo = new Thermogeekostat();
		
		//pour en ouvir un autre : plein de vus mais qu'un seul serveur
		
		//new TextView( thermo);
		new TextView( thermo);
		new SliderView(thermo);

	}

}
