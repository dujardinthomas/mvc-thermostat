package fr.univlille.iutinfo.r3_04.viewQ3;

import fr.univlille.iutinfo.r3_04.modelQ1.Thermogeekostat;
import fr.univlille.iutinfo.r3_04.modelQ2.Temperature;
import fr.univlille.iutinfo.r3_04.utils.Observer;
import fr.univlille.iutinfo.r3_04.utils.Subject;
import fr.univlille.iutinfo.r3_04.viewQ1.ITemperatureView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TextView extends Stage implements ITemperatureView,Observer {

	private Temperature model;
	double temp;
	Button pls = new Button("+");
	Button mns = new Button("-");
	Label label;
	Button b1, b2;
	TextField txt;


	public TextView(Temperature model) {
		this.model = model;
		model.attach(this);
		label = new Label("0");
		b1 = new Button("  -  ");
		txt = new TextField("");
		b2 = new Button("  +  ");
		txt.setText("");//TODO
		VBox vbox = new VBox(3);
		vbox.setPadding(new Insets(3, 3, 3, 3));
		vbox.setAlignment(Pos.CENTER);
		HBox hbox = new HBox(3);
		hbox.getChildren().addAll(b1, b2);
		vbox.getChildren().addAll(label, hbox);

		Scene scene = new Scene(vbox);
		this.setTitle(model.getEchelle().getName());
		txt.setText("temperature en" + model.getEchelle().getName());
		this.setScene(scene);
		this.show();

		b1.setOnAction((event) -> decrementAction());
		b2.setOnAction((event) -> incrementAction());

	}

	@Override
	public double getDisplayedValue() {
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

	@Override
	public void update(Subject subj) {

	}

	@Override
	public void update(Subject subj, Object data) {
		label.setText(data.toString());	
		System.out.println(data);
	}

	@Override
	public void changeValues(double v) {
		// TODO Auto-generated method stub
		
	}
}