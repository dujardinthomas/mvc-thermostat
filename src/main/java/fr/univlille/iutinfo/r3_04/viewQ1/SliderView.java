package fr.univlille.iutinfo.r3_04.viewQ1;

import fr.univlille.iutinfo.r3_04.modelQ1.Thermogeekostat;
import fr.univlille.iutinfo.r3_04.utils.Observer;
import fr.univlille.iutinfo.r3_04.utils.Subject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SliderView extends Stage implements ITemperatureView, Observer {

	private Thermogeekostat model;
	Slider slider;
	Label label, temp;
	VBox vbox;

	Button bPlus, bMoins;

	double value;

	public SliderView(Thermogeekostat m) {
		this.model=m;
		m.attach(this);


		slider = new Slider(m.tempMin, m.tempMax, m.d); //Slider(min, max, value)
		label = new Label("°C");
		temp = new Label(""+m.d);
		vbox = new VBox();

		bPlus = new Button("+");
		bMoins = new Button("-");

		// La première méthode va afficher des marqueurs et la seconde va étiqueter les marqueurs.
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);


		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				value = (int) slider.getValue();
				changeValues(value);
			}
		});


		slider.setOrientation(Orientation.VERTICAL);

		bPlus.setOnAction((event) -> incrementAction());
		bPlus.setOnMouseDragged((event) -> incrementAction());

		bMoins.setOnAction((event) -> decrementAction());
		bMoins.setOnMouseDragged((event) -> decrementAction());

		HBox hbox = new HBox(4);
		hbox.getChildren().addAll(temp, label);
		vbox.getChildren().addAll(hbox, bPlus, slider, bMoins);
		Scene scene = new Scene(vbox,150,200);
		this.setScene(scene);
		this.setTitle("Gestion température");
		this.show();
	}


	@Override
	public void update(Subject subj) {

	}

	@Override
	public void update(Subject subj, Object data) {
		temp.setText(data.toString());	
		slider.setValue(model.d);
		//System.out.println(data);
	}

	@Override
	public double getDisplayedValue() {
		return model.getTemperature();
	}

	@Override
	public void changeValues(double v) {
		model.changeValues(v);
	}

	@Override
	public void incrementAction() {
		model.incrementTemperature();
	}

	@Override
	public void decrementAction() {
		model.decrementTemperature();
	}

}
