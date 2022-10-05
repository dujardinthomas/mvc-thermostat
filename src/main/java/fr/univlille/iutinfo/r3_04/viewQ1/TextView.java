package fr.univlille.iutinfo.r3_04.viewQ1;

import fr.univlille.iutinfo.r3_04.modelQ1.Thermogeekostat;
import fr.univlille.iutinfo.r3_04.utils.Observer;
import fr.univlille.iutinfo.r3_04.utils.Subject;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextView extends Stage implements ITemperatureView, Observer {

	private Thermogeekostat model;

	Label label;
	Button bMoins, bPlus;
	TextField tf;


	public TextView(Thermogeekostat model) {
		this.model = model;
		model.attach(this);

		VBox root = new VBox();
		label = new Label("Température en celsius");
		bMoins = new Button("-");
		bPlus = new Button("+");
		HBox hbox = new HBox(10);
		tf = new TextField(""+model.d);
		tf.setAlignment(Pos.TOP_CENTER);
		root.setAlignment(Pos.TOP_CENTER);
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.getChildren().addAll(bMoins, tf, bPlus);
		root.getChildren().addAll(label, hbox);

		bMoins.setOnAction((event) -> decrementAction());
		bMoins.setOnMouseDragged((event) -> decrementAction());

		bPlus.setOnAction((event) -> incrementAction());
		bPlus.setOnMouseDragged((event) -> incrementAction());

		Scene scene = new Scene(root);
		this.setScene(scene);
		this.setTitle("Gestion température");
		this.show();
	}

	@Override
	public double getDisplayedValue() {
		// TODO Auto-generated method stub
		return model.getTemperature();
	}

	@Override
	public void incrementAction() {
		model.incrementTemperature();

	}

	@Override
	public void decrementAction() {
		model.decrementTemperature();

	}

	public void update(Subject subj) {

	}

	public void update(Subject subj, Object data) { //Appeller a chaque mise a jour = a chaque clique
		tf.setText(data.toString());	
		System.out.println(data);
	}

}
